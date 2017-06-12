package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.Brakes;
import ke.co.apollo.autoxpress.entity.Inspection;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anthony.kipkoech on 12/06/2017.
 */
@Repository
public class BrakesRepo extends JdbcDaoSupport {

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Brakes create(Inspection inspection, List<String> foot, List<String> hand){
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "brakesId";

        getJdbcTemplate().update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO brakes(inspectionId,foot,hand) VALES(?,?,?)",new String[]{idCol});
            ps.setInt(1,inspection.getInspectionId());
            ps.setString(2,StringUtils.join(foot,','));
            ps.setString(3,StringUtils.join(hand,','));
            return ps;
        },keyHolder);

        return new Brakes.BrakesBuilder(inspection.getInspectionId())
                .foot(foot).hand(hand).brakesId(keyHolder.getKey().intValue())
                .build();
    }

    @Transactional(readOnly =  false, propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public Brakes update(Integer brakesId,Inspection inspection, List<String> foot, List<String> hand){

        getJdbcTemplate().update("UPDATE brakes SET foot = ? , hand = ? WHERE brakesId = ?",
                new Object[]{StringUtils.join(foot,','),StringUtils.join(hand,','),brakesId});

        return new Brakes.BrakesBuilder(inspection.getInspectionId())
                .foot(foot).hand(hand).brakesId(brakesId)
                .build();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Brakes> findByInspection(Inspection inspection){

        return getJdbcTemplate().query("SELECT * FROM brakes WHERE inspectionId=?",
                (rs,i) -> new Brakes.BrakesBuilder(inspection.getInspectionId())
                        .foot(Arrays.asList(rs.getString("foot").split(",")))
                        .hand(Arrays.asList(rs.getString("hand").split(",")))
                        .brakesId(rs.getInt("brakesId"))
                        .build(),inspection.getInspectionId());

    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Brakes findById(Integer brakesId){

        return getJdbcTemplate().queryForObject("SELECT * FROM brakes WHERE brakesId=?",
                (rs,i) -> new Brakes.BrakesBuilder(rs.getInt("inspectionId"))
                        .foot(Arrays.asList(rs.getString("foot").split(",")))
                        .hand(Arrays.asList(rs.getString("hand").split(",")))
                        .brakesId(rs.getInt("brakesId"))
                        .build(),brakesId);

    }

}
