package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.VehicleMake;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by anthony.kipkoech on 29/05/2017.
 */
public class VehicleMakeRepo extends JdbcDaoSupport {


    public VehicleMake create(String make){
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "makeId";
        getJdbcTemplate().update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO vehicleMake(make) VALUES(?)", new String[]{idCol});
            ps.setString(1,make);
            return ps;
        },keyHolder);

        Integer id = (Integer) keyHolder.getKey().intValue();
        return new VehicleMake.VehicleMakeBuilder(make).makeId(id).build();
    }

    public VehicleMake update(Integer makeId,String make){
        getJdbcTemplate().update("UPDATE  vehicleMake SET make = ? WHERE makeId = ?",new Object[]{make,makeId});
        return new VehicleMake.VehicleMakeBuilder(make).makeId(makeId).build();
    }

    public List<VehicleMake> findAll(){
        return getJdbcTemplate().query("SELECT * FROM vehicleMake",
                (rs, i) -> new VehicleMake.VehicleMakeBuilder(rs.getString(2))
                        .makeId(rs.getInt(1))
                        .build());
    }

    public List<VehicleMake> findByMakeLike(String searchStr){
        return getJdbcTemplate().query("SELECT * FROM vehicleMake WHERE UPPER(make) LIKE ? ",
                (rs,i) -> new VehicleMake.VehicleMakeBuilder(rs.getString(2))
                        .makeId(rs.getInt(1))
                        .build(),"%"+searchStr.toUpperCase()+"%");
    }

}
