package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.Inspection;
import ke.co.apollo.autoxpress.entity.Photo;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by anthony.kipkoech on 08/06/2017.
 */
@Repository
public class PhotoRepo extends JdbcDaoSupport{

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Photo create(String engine,String dashboard,String bonnet,
                        String rear,String left,String right,
                        String interior,String front,Integer inspectionId){

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "inspectionId";

        getJdbcTemplate().update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO photo(`engine`,`dashboard`,`bonnet`,`rear`,`left`,`right`,`interior`,`front`,`inspectionId`) VALUES(?,?,?,?,?,?,?,?,?)",
                    new String[]{idCol});
                    ps.setString(1, engine);
                    ps.setString(2, dashboard);
                    ps.setString(3, bonnet);
                    ps.setString(4, rear);
                    ps.setString(5, left);
                    ps.setString(6, right);
                    ps.setString(7, interior);
                    ps.setString(8, front);
                    return ps;
                },keyHolder);

        return new Photo.PhotoBuilder(inspectionId)
                .photoId(keyHolder.getKey().intValue())
                .bonnet(bonnet).engine(engine).dashboard(dashboard)
                .rear(rear).front(front).left(left).right(right).interior(interior)
                .build();
    }

    public List<Photo> findByInspection(Inspection inspection){
        return getJdbcTemplate().query("SELECT * FROM photo WHERE inspectionId = ?",
                (rs,i) -> new Photo.PhotoBuilder(inspection.getInspectionId())
                        .engine(rs.getString("engine"))
                        .bonnet(rs.getString("bonnet"))
                        .dashboard(rs.getString("dashboard"))
                        .rear(rs.getString("rear"))
                        .front(rs.getString("front"))
                        .left(rs.getString("left"))
                        .right(rs.getString("right"))
                        .interior(rs.getString("interior"))
                        .photoId(rs.getInt("photoId"))
                        .build(),inspection.getInspectionId());
    }

}
