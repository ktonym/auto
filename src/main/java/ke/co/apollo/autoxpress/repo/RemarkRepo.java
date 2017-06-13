package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.AntiTheftDevice;
import ke.co.apollo.autoxpress.entity.Inspection;
import ke.co.apollo.autoxpress.entity.Remark;
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
public class RemarkRepo extends JdbcDaoSupport{

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Remark create(String generalCondition, AntiTheftDevice antiTheftDevice,
                         Double estimatedValue, String overallComment, Inspection inspection){

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "genRemarksId";

        getJdbcTemplate().update( con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO generalremarks(generalCondition,antiTheftDevice,estimatedValue,overallComments,inspectionId) VALUES (?,?,?,?,?)",
                    new String[]{idCol});
                    ps.setString(1,generalCondition);
                    ps.setString(2,antiTheftDevice.toString());
                    ps.setDouble(3,estimatedValue);
                    ps.setString(4,overallComment);
                    ps.setInt(5,inspection.getInspectionId());
                    return ps;
        },keyHolder);

        return new Remark.RemarkBuilder(inspection.getInspectionId())
                .remarkId(keyHolder.getKey().intValue())
                .generalCondition(generalCondition)
                .antiTheftDevice(antiTheftDevice)
                .estimatedValue(estimatedValue)
                .overallComment(overallComment)
                .build();

    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Remark update(Integer remarkId, String generalCondition, AntiTheftDevice antiTheftDevice,
                         Double estimatedValue, String overallComment, Inspection inspection){

        getJdbcTemplate().update("UPDATE generalremarks SET generalCondition=?,antiTheftDevice=?,estimatedValue=?,overallComments=?,inspectionId=? WHERE genRemarksId = ? ",
                    new Object[]{generalCondition,antiTheftDevice,estimatedValue,overallComment,inspection.getInspectionId(),remarkId});
            return new Remark.RemarkBuilder(inspection.getInspectionId())
                    .remarkId(remarkId)
                    .generalCondition(generalCondition)
                    .antiTheftDevice(antiTheftDevice)
                    .estimatedValue(estimatedValue)
                    .overallComment(overallComment)
                    .build();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Remark> findByInspection(Inspection inspection){
        return getJdbcTemplate().query("SELECT * FROM photo WHERE inspectionId = ?",
                (rs,i) -> new
                        Remark.RemarkBuilder(inspection.getInspectionId())
                        .antiTheftDevice(AntiTheftDevice.valueOf(rs.getString("antiTheftDevice")))
                        .estimatedValue(rs.getDouble("estimatedValue"))
                        .generalCondition(rs.getString("generalCondition"))
                        .remarkId(rs.getInt("genRemarksId"))
                        .overallComment(rs.getString("overallComments"))
                        .build(),inspection.getInspectionId());
    }

}
