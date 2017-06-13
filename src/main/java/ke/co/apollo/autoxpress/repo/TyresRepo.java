package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.Inspection;
import ke.co.apollo.autoxpress.entity.Tyres;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anthony.kipkoech on 12/06/2017.
 */
@Repository
public class TyresRepo extends JdbcDaoSupport {

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Tyres create(Inspection inspection,ArrayList<String> frontLeft,
                        ArrayList<String> frontRight,ArrayList<String> backLeft,
                        ArrayList<String> backRight,ArrayList<String> spare){

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "tyreId";
        getJdbcTemplate().update( con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO tyres(inspectionId,frontLeft,frontRight,backLeft,backRight,spare) VALUES(?,?,?,?,?,?)"
            ,new String[]{idCol});
            ps.setInt(1,inspection.getInspectionId());
            ps.setString(2, StringUtils.join(frontLeft,','));
            ps.setString(3,StringUtils.join(frontRight,','));
            ps.setString(4,StringUtils.join(backLeft,','));
            ps.setString(5,StringUtils.join(backRight,','));
            ps.setString(6,StringUtils.join(spare,','));
            return ps;
        },keyHolder);

        return new Tyres.TyresBuilder(inspection.getInspectionId())
                .frontLeft(frontLeft).frontRight(frontRight)
                .backLeft(backLeft).backRight(backRight).tyreId(keyHolder.getKey().intValue())
                .spare(spare).build();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Tyres update(Integer tyreId,Inspection inspection,ArrayList<String> frontLeft,
                        ArrayList<String> frontRight,ArrayList<String> backLeft,
                        ArrayList<String> backRight,ArrayList<String> spare){

            getJdbcTemplate().update("UPDATE tyres SET inspectionId = ?, frontLeft = ?, frontRight = ?, backLeft = ?, backRight = ?, spare = ? WHERE tyreId = ?",
                    new Object[]{inspection.getInspectionId(),
                            StringUtils.join(frontLeft,','),
                            StringUtils.join(frontRight,','),
                            StringUtils.join(backLeft,','),
                            StringUtils.join(backRight,','),
                            StringUtils.join(spare,','),
                            tyreId});

            return new Tyres.TyresBuilder(inspection.getInspectionId())
                    .frontLeft(frontLeft).frontRight(frontRight)
                    .backLeft(backLeft).backRight(backRight).tyreId(tyreId)
                    .spare(spare).build();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<Tyres> findByInspection(Inspection inspection){

        return getJdbcTemplate().query("SELECT * FROM tyres WHERE inspectionId = ?",
                (rs,i) -> new Tyres.TyresBuilder(inspection.getInspectionId())
                        .frontLeft(new ArrayList<String>(Arrays.asList(rs.getString("frontLeft").split(","))))
                        .frontRight(new ArrayList<String>(Arrays.asList(rs.getString("frontRight").split(","))))
                        .backLeft(new ArrayList<String>(Arrays.asList(rs.getString("backLeft").split(","))))
                        .backRight(new ArrayList<String>(Arrays.asList(rs.getString("backRight").split(","))))
                        .spare(new ArrayList<String>(Arrays.asList(rs.getString("spare").split(","))))
                        .tyreId(rs.getInt("tyreId"))
                        .build(),inspection.getInspectionId());

    }

}
