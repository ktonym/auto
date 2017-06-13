package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.time.Year;

/**
 * Created by anthony.kipkoech on 31/05/2017.
 */
@Repository
@Transactional
public class VehicleRepo extends JdbcDaoSupport {

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Vehicle create(String regNo, Year yom, Integer ownerId,
                          Integer modelId, Integer bodyTypeId,
                          String logbookPhoto,/* byte[] src,*/String policyNo){

        getJdbcTemplate().update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO vehicle(regNo,yom,ownerId,modelId,bodyTypeId,logbookPhoto,policyNo) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1,regNo);
            ps.setInt(2,yom.getValue());
            ps.setInt(3,ownerId);
            ps.setInt(4,modelId);
            ps.setInt(5,bodyTypeId);
            ps.setString(6,logbookPhoto);
            ps.setString(7,policyNo);
            return ps;
        });

        return new Vehicle.VehicleBuilder()
                .regNo(regNo).yom(yom)
                .ownerId(ownerId).logBookPhoto(logbookPhoto)
                .policyNo(policyNo).vehicleModelId(modelId).bodyTypeId(bodyTypeId)
                //.logbookImage(src)
                .build();

    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public Vehicle findByRegistration(String regNo){
        return getJdbcTemplate().queryForObject("SELECT * FROM vehicle WHERE regNo = ?",
                (rs, i) -> new Vehicle.VehicleBuilder()
                        .yom(Year.of(rs.getInt("yom")))
                        .logBookPhoto(rs.getString("logbookPhoto"))
                        .regNo(regNo).policyNo(rs.getString("policyNo"))
                        .vehicleModelId(rs.getInt("modelId"))
                        .bodyTypeId(rs.getInt("bodyTypeId"))
                        .ownerId(rs.getInt("ownerId"))
                        //.bodyType().vehicleModel()
                        .build(),regNo);
    }

}
