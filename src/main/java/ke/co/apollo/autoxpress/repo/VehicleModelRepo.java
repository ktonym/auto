package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.VehicleMake;
import ke.co.apollo.autoxpress.entity.VehicleModel;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by anthony.kipkoech on 29/05/2017.
 */
public class VehicleModelRepo extends JdbcDaoSupport{

    public VehicleModel create(VehicleMake make, String model){

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "modelId";
        getJdbcTemplate().update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO vehiclemodel(model,makeId) VALUES(?,?)",
                    new String[]{idCol});
            ps.setString(1,model);
            ps.setInt(2,make.getMakeId());
            return ps;
        },keyHolder);

        return new VehicleModel.VehicleModelBuilder()
                .make(make)
                .model(model)
                .modelId(keyHolder.getKey().intValue()).build();
    }

    public VehicleModel update(Integer modelId,VehicleMake make, String model){
        getJdbcTemplate().update("UPDATE vehiclemodel SET model = ? ,makeId = ? WHERE modelId = ?",
                new Object[]{model,make.getMakeId(),modelId});
        return new VehicleModel.VehicleModelBuilder()
                .make(make)
                .model(model)
                .modelId(modelId)
                .build();
    }

    public List<VehicleModel> findByMake(VehicleMake make){
        return getJdbcTemplate().query("SELECT * FROM vehiclemodel WHERE makeId = ?",
                (rs,i) -> new VehicleModel.VehicleModelBuilder()
                        .make(make)
                        .modelId(rs.getInt("modelId"))
                        .model(rs.getString("model")).build(), make.getMakeId());
    }


//    public List<VehicleModel> findAll(){
//        return getJdbcTemplate().query("SELECT * FROM vehiclemodel",
//                (rs,i)-> new VehicleModel.VehicleModelBuilder());
//    }

}
