package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.VehicleMake;
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
public class VehicleMakeRepo extends JdbcDaoSupport {

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
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

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public VehicleMake update(Integer makeId,String make){
        getJdbcTemplate().update("UPDATE  vehicleMake SET make = ? WHERE makeId = ?",new Object[]{make,makeId});
        return new VehicleMake.VehicleMakeBuilder(make).makeId(makeId).build();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<VehicleMake> findAll(){
        return getJdbcTemplate().query("SELECT * FROM vehicleMake",
                (rs, i) -> new VehicleMake.VehicleMakeBuilder(rs.getString(2))
                        .makeId(rs.getInt(1))
                        .build());
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<VehicleMake> findByMakeLike(String searchStr){
        return getJdbcTemplate().query("SELECT * FROM vehicleMake WHERE UPPER(make) LIKE ? ",
                (rs,i) -> new VehicleMake.VehicleMakeBuilder(rs.getString(2))
                        .makeId(rs.getInt(1))
                        .build(),"%"+searchStr.toUpperCase()+"%");
    }

}
