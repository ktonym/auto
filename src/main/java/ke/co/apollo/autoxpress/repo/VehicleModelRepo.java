package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.VehicleModel;
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
 * Created by anthony.kipkoech on 29/05/2017.
 */
@Repository
public class VehicleModelRepo extends JdbcDaoSupport{

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public VehicleModel create(Integer makeId, String model){

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "modelId";
        getJdbcTemplate().update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO vehiclemodel(model,makeId) VALUES(?,?)",
                    new String[]{idCol});
            ps.setString(1,model);
            ps.setInt(2,makeId);
            return ps;
        },keyHolder);

        return new VehicleModel.VehicleModelBuilder()
                .makeId(makeId)
                .model(model)
                .modelId(keyHolder.getKey().intValue()).build();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public VehicleModel update(Integer modelId,Integer vehicleMakeId, String model){
        getJdbcTemplate().update("UPDATE vehiclemodel SET model = ? ,makeId = ? WHERE modelId = ?",
                new Object[]{model,vehicleMakeId,modelId});
        return new VehicleModel.VehicleModelBuilder()
                .makeId(vehicleMakeId)
                .model(model)
                .modelId(modelId)
                .build();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public List<VehicleModel> findByMake(Integer makeId){
        return getJdbcTemplate().query("SELECT * FROM vehiclemodel WHERE makeId = ?",
                (rs,i) -> new VehicleModel.VehicleModelBuilder()
                        .makeId(makeId)
                        .modelId(rs.getInt("modelId"))
                        .model(rs.getString("model")).build(), makeId);
    }


//    public List<VehicleModel> findAll(){
//        return getJdbcTemplate().query("SELECT * FROM vehiclemodel",
//                (rs,i)-> new VehicleModel.VehicleModelBuilder());
//    }

}
