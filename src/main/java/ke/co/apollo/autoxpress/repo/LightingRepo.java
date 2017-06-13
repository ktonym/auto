package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.Inspection;
import ke.co.apollo.autoxpress.entity.Lighting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by anthony.kipkoech on 09/06/2017.
 */
@Repository
public class LightingRepo extends JdbcDaoSupport {

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Lighting create(Inspection inspection,Boolean leftHeadLight,Boolean rightHeadLight,
                           Boolean lhBrakeLight,Boolean rhBrakeLight,
                           Boolean lhFrontIndicator,Boolean rhFrontIndicator,
                           Boolean rhRearIndicator,Boolean lhRearIndicator,
                           Boolean frontParkingLight,Boolean rearParkingLight,
                           Boolean leftTailLight,Boolean rightTailLight,
                           Boolean rhReverseLight,Boolean lhReverseLight){

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "lightingId";

        getJdbcTemplate().update( con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO lighting(inspectionId) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new String[]{idCol});
            ps.setInt(1,inspection.getInspectionId());
            ps.setBoolean(2,leftHeadLight);
            ps.setBoolean(3,rightHeadLight);
            ps.setBoolean(4,lhBrakeLight);
            ps.setBoolean(5,rhBrakeLight);
            ps.setBoolean(6,lhFrontIndicator);
            ps.setBoolean(7,rhFrontIndicator);
            ps.setBoolean(8,rhRearIndicator);
            ps.setBoolean(9,lhRearIndicator);
            ps.setBoolean(10,frontParkingLight);
            ps.setBoolean(11,rearParkingLight);
            ps.setBoolean(12,leftTailLight);
            ps.setBoolean(13,rightTailLight);
            ps.setBoolean(14,rhReverseLight);
            ps.setBoolean(15,lhReverseLight);
            return ps;},keyHolder);

        return new Lighting.LightingBuilder(inspection).leftHeadLight(leftHeadLight).rightHeadLight(rightHeadLight)
                .lhBrakeLight(lhBrakeLight).rhBrakeLight(rhBrakeLight).lhFrontIndicator(lhFrontIndicator)
                .rhFrontIndicator(rhFrontIndicator).rhRearIndicator(rhRearIndicator).lhRearIndicator(lhRearIndicator)
                .frontParkingLight(frontParkingLight).rearParkingLight(rearParkingLight).leftTailLight(leftTailLight)
                .rightTailLight(rightTailLight).rhReverseLight(rhReverseLight).lhReverseLight(lhReverseLight)
                .build();

    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Lighting update(Inspection inspection,Boolean leftHeadLight,Boolean rightHeadLight,
                                     Boolean lhBrakeLight,Boolean rhBrakeLight,
                                     Boolean lhFrontIndicator,Boolean rhFrontIndicator,
                                     Boolean rhRearIndicator,Boolean lhRearIndicator,
                                     Boolean frontParkingLight,Boolean rearParkingLight,
                                     Boolean leftTailLight,Boolean rightTailLight,
                                     Boolean rhReverseLight,Boolean lhReverseLight,Integer lightingId){
        getJdbcTemplate().update("UPDATE lighting SET leftHeadLight=?, rightHeadLight=?, lhBrakeLight=?, rhBrakeLight=?, lhFrontIndicator=?, rhFrontIndicator=?, rhRearIndicator=?, lhRearIndicator=?, frontParkingLight=?, rearParkingLight=?, leftTailLight=?, rightTailLight=?, rhReverseLight=?, lhReverseLight=?, insepectionId=? WHERE lightingId=?",
                new Object[]{leftHeadLight,rightHeadLight,lhBrakeLight,rhBrakeLight,lhFrontIndicator,rhFrontIndicator,rhRearIndicator,lhRearIndicator,frontParkingLight,rearParkingLight,leftTailLight,rightTailLight,rhReverseLight,lhReverseLight,inspection.getInspectionId(),lightingId}
                );
        return new Lighting.LightingBuilder(inspection).leftHeadLight(leftHeadLight).rightHeadLight(rightHeadLight)
                .lhBrakeLight(lhBrakeLight).rhBrakeLight(rhBrakeLight).lhFrontIndicator(lhFrontIndicator)
                .rhFrontIndicator(rhFrontIndicator).rhRearIndicator(rhRearIndicator).lhRearIndicator(lhRearIndicator)
                .frontParkingLight(frontParkingLight).rearParkingLight(rearParkingLight).leftTailLight(leftTailLight)
                .rightTailLight(rightTailLight).rhReverseLight(rhReverseLight).lhReverseLight(lhReverseLight)
                .build();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Lighting> findByInspection(Inspection inspection){
        return getJdbcTemplate().query("SELECT * FROM lighting WHERE inspectionId = ?",
                (rs,i) -> new Lighting.LightingBuilder(inspection)
                        .leftHeadLight(rs.getBoolean("leftHeadLight"))
                        .rightHeadLight(rs.getBoolean("rightHeadLight"))
                        .lhBrakeLight(rs.getBoolean("lhBrakeLight"))
                        .rhBrakeLight(rs.getBoolean("rhBrakeLight"))
                        .lhFrontIndicator(rs.getBoolean("lhFrontIndicator"))
                        .rhFrontIndicator(rs.getBoolean("rhFrontIndicator"))
                        .rhRearIndicator(rs.getBoolean("rhRearIndicator"))
                        .lhRearIndicator(rs.getBoolean("lhRearIndicator"))
                        .frontParkingLight(rs.getBoolean("frontParkingLight"))
                        .rearParkingLight(rs.getBoolean("rearParkingLight"))
                        .leftTailLight(rs.getBoolean("leftTailLight"))
                        .rightTailLight(rs.getBoolean("rightTailLight"))
                        .rhReverseLight(rs.getBoolean("rhReverseLight"))
                        .lhReverseLight(rs.getBoolean("lhReverseLight"))
                        .build());
    }

}
