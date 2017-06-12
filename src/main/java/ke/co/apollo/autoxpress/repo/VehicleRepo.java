package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.BodyType;
import ke.co.apollo.autoxpress.entity.Owner;
import ke.co.apollo.autoxpress.entity.Vehicle;
import ke.co.apollo.autoxpress.entity.VehicleModel;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.time.Year;

/**
 * Created by anthony.kipkoech on 31/05/2017.
 */
@Repository
@Transactional
public class VehicleRepo extends JdbcDaoSupport {

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Vehicle create(String regNo, Year yom, Owner owner,
                          VehicleModel model, BodyType bodyType,
                          String logbookPhoto, String policyNo){

        getJdbcTemplate().update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO vehicle(regNo,yom,ownerId,modelId,bodyTypeId,logbookPhoto,policyNo) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1,regNo);
            ps.setInt(2,yom.getValue());
            ps.setInt(3,owner.getOwnerId());
            ps.setInt(4,model.getModelId());
            ps.setInt(5,bodyType.getBodyTypeId());
            ps.setString(6,logbookPhoto);
            ps.setString(7,policyNo);
            return ps;
        });

        return new Vehicle.VehicleBuilder()
                .regNo(regNo).yom(yom)
                .owner(owner).logBookPhoto(logbookPhoto)
                .policyNo(policyNo)
                .build();

    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public Vehicle findByRegistration(String regNo){
        return getJdbcTemplate().queryForObject("SELECT * FROM vehicle WHERE regNo = ?",
                (rs, i) -> new Vehicle.VehicleBuilder()
                        .yom(Year.of(rs.getInt("yom")))
                        .logBookPhoto(rs.getString("logbookPhoto"))
                        .regNo(regNo).policyNo(rs.getString("policyNo"))
                        //.bodyType().vehicleModel()
                        .build(),regNo);
    }

}
