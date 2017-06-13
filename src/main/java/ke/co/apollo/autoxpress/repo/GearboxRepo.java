package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.Gearbox;
import ke.co.apollo.autoxpress.entity.Inspection;
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
public class GearboxRepo extends JdbcDaoSupport {


    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Gearbox create(Inspection inspection, List<String> shifting){

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "gearboxId";

        getJdbcTemplate().update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO gearbox(inspectionId,shifting) VALUES (?,?)",new String[]{idCol});
            ps.setInt(1,inspection.getInspectionId());
            ps.setString(2, StringUtils.join(shifting,','));
            return ps;
        },keyHolder);

        return new Gearbox.GearboxBuilder(inspection.getInspectionId())
                .shifting(shifting).geaboxId(keyHolder.getKey().intValue())
                .build();
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Gearbox update(Integer gearboxId,Inspection inspection,List<String> shifting){
        getJdbcTemplate().update("UPDATE gearbox SET shifting = ? WHERE gearboxId = ?",
                new Object[]{shifting,gearboxId});
        return new Gearbox.GearboxBuilder(inspection.getInspectionId())
                .shifting(shifting).geaboxId(gearboxId)
                .build();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Gearbox> findByInspection(Inspection inspection){

        return getJdbcTemplate().query("SELECT * FROM brakes WHERE inspectionId=?",
                (rs,i) -> new Gearbox.GearboxBuilder(inspection.getInspectionId())
                        .shifting(Arrays.asList(rs.getString("shifting").split(",")))
                        .geaboxId(rs.getInt("gearboxId"))
                        .build(),inspection.getInspectionId());

    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Gearbox findById(Integer gearboxId){

        return getJdbcTemplate().queryForObject("SELECT * FROM brakes WHERE brakesId=?",
                (rs,i) -> new Gearbox.GearboxBuilder(rs.getInt("inspectionId"))
                        .shifting(Arrays.asList(rs.getString("shifting").split(",")))
                        .geaboxId(gearboxId)
                        .build()
        );

    }

}
