package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.Inspection;
import ke.co.apollo.autoxpress.entity.Steering;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anthony.kipkoech on 12/06/2017.
 */
@Repository
public class SteeringRepo extends JdbcDaoSupport {

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Steering create(Inspection inspection, List<String> play){

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "steeringId";

        getJdbcTemplate().update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO steering(play,inspectionId) VALUES (?,?)",new String[]{idCol});
            ps.setString(1,StringUtils.join(play,','));
            ps.setInt(2,inspection.getInspectionId());
            return ps;
        },keyHolder);

        return new Steering.SteeringBuilder(inspection.getInspectionId())
                .play(play).steeringId(keyHolder.getKey().intValue())
                .build();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Steering update(Integer steeringId,Inspection inspection, List<String> play){
        getJdbcTemplate().update("UPDATE steering SET play = ? WHERE steeringId = ?",new Object[]{play,steeringId});
        return new Steering.SteeringBuilder(inspection.getInspectionId())
                .steeringId(steeringId).play(play)
                .build();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Steering> findByInspection(Inspection inspection){
        return getJdbcTemplate().query("SELECT * FROM steering WHERE inspectionId = ?",
                (rs,i) -> new Steering.SteeringBuilder(inspection.getInspectionId())
                        .steeringId(rs.getInt("steeringId"))
                        .play(Arrays.asList(rs.getString("play").split(",")))
                        .build());
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Steering findById(Integer steeringId){
        return getJdbcTemplate().queryForObject("SELECT * FROM steering WHERE steeringId = ?",
                (rs,i) -> new Steering.SteeringBuilder(rs.getInt("inspectionId"))
                        .steeringId(steeringId)
                        .play(Arrays.asList(rs.getString("play").split(",")))
                        .build()
        );
    }

}
