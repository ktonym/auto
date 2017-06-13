package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.GeneralBodyCondition;
import ke.co.apollo.autoxpress.entity.Inspection;
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
public class GeneralBodyConditionRepo extends JdbcDaoSupport{

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public GeneralBodyCondition create(Boolean lhWiper,Boolean rhWiper,Boolean windscreenChipped,
                                       Boolean windscreenCracked,String doorComments,Boolean lhMirrorPresent,
                                       Boolean rhMirrorPresent,Boolean dentedFenderAndBumper,Inspection inspection){

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "genBodyCondId";

        getJdbcTemplate().update( con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO generalbodycondition(leftHandwiper,rightHandWiper,windscreenChipped,windscreenCracked,doorComments,leftHandMirrorPresent,righHandMirrorPresent,dentedFenderAndBumper,inspectionId) VALUES (?,?,?,?,?,?,?,?,?)",new String[]{idCol});
            ps.setBoolean(1,lhWiper);
            ps.setBoolean(2,rhWiper);
            ps.setBoolean(3,windscreenChipped);
            ps.setBoolean(4,windscreenCracked);
            ps.setString(5,doorComments);
            ps.setBoolean(6,lhMirrorPresent);
            ps.setBoolean(7,rhMirrorPresent);
            ps.setBoolean(8,dentedFenderAndBumper);
            ps.setInt(9,inspection.getInspectionId());
            return ps;
        },keyHolder);

        return new GeneralBodyCondition.GeneralBodyConditionBuilder(inspection)
                .lhWiper(lhWiper).rhWiper(rhWiper).windscreenChipped(windscreenChipped)
                .windscreenCracked(windscreenCracked).doorComments(doorComments)
                .lhMirrorPresent(lhMirrorPresent).rhMirrorPresent(rhMirrorPresent).dentedFenderAndBumper(dentedFenderAndBumper)
                .build();

    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public GeneralBodyCondition update(Integer genBodyCondId,Boolean lhWiper,Boolean rhWiper,Boolean windscreenChipped,
                                       Boolean windscreenCracked,String doorComments,Boolean lhMirrorPresent,
                                       Boolean rhMirrorPresent,Boolean dentedFenderAndBumper,Inspection inspection){

        getJdbcTemplate().update("UPDATE generalbodycondition SET lhWiper = ?, rhWiper = ?, windscreenChipped = ?, windscreenCracked = ?, doorComments = ?, lhMirrorPresent = ?, rhMirrorPresent = ?, dentedFenderAndBumper = ?, inspection = ? WHERE genBodyCondId = ?",
                new Object[]{lhWiper,rhWiper,windscreenChipped,windscreenCracked,doorComments,lhMirrorPresent,rhMirrorPresent,dentedFenderAndBumper,inspection,genBodyCondId});

        return new GeneralBodyCondition.GeneralBodyConditionBuilder(inspection)
                .lhWiper(lhWiper).rhWiper(rhWiper).windscreenChipped(windscreenChipped).windscreenCracked(windscreenCracked)
                .doorComments(doorComments).lhMirrorPresent(lhMirrorPresent).rhMirrorPresent(rhMirrorPresent)
                .dentedFenderAndBumper(dentedFenderAndBumper).genBodyCondId(genBodyCondId)
                .build();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<GeneralBodyCondition> findByInspection(Inspection inspection){
        return getJdbcTemplate().query("SELECT * FROM generalbodycondition WHERE inspectionId = ?",
                (rs,i) -> new GeneralBodyCondition.GeneralBodyConditionBuilder(inspection)
                        .lhWiper(rs.getBoolean("lhWiper"))
                        .rhWiper(rs.getBoolean("rhWiper"))
                        .windscreenChipped(rs.getBoolean("windscreenChipped"))
                        .windscreenCracked(rs.getBoolean("windscreenCracked"))
                        .doorComments(rs.getString("doorComments"))
                        .lhMirrorPresent(rs.getBoolean("lhMirrorPresent"))
                        .rhMirrorPresent(rs.getBoolean("rhMirrorPresent"))
                        .dentedFenderAndBumper(rs.getBoolean("dentedFenderAndBumper"))
                        .genBodyCondId(rs.getInt("genBodyCondId"))
                        .build()
                );
    }

}
