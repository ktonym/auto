package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.Inspection;
import ke.co.apollo.autoxpress.entity.Shocks;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anthony.kipkoech on 12/06/2017.
 */
@Repository
public class ShocksRepo extends JdbcDaoSupport {

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Shocks create(Inspection inspection,List<String> fitting,List<String> physical){
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "shocksId";

        getJdbcTemplate().update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO shocks(inspectionId,fitting,physical) VALUES(?,?,?)",
                    new String[]{idCol});
            ps.setInt(1,inspection.getInspectionId());
            ps.setString(2, StringUtils.join(fitting,','));
            ps.setString(3,StringUtils.join(physical,','));
            return ps;
        },keyHolder);

        return new Shocks.ShocksBuilder(inspection.getInspectionId())
                .shocksId(keyHolder.getKey().intValue())
                .fitting(fitting).physical(physical)
                .build();
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Shocks update(Integer shocksId,Inspection inspection,List<String> fitting,List<String> physical){

        getJdbcTemplate().update("UPDATE shocks SET fitting = ?, physical = ? WHERE shocksId = ?",
                new Object[]{StringUtils.join(fitting,','),
                        StringUtils.join(physical,','),shocksId});

        return new Shocks.ShocksBuilder(inspection.getInspectionId())
                .fitting(fitting).shocksId(shocksId)
                .physical(physical)
                .build();

    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Shocks> findByInspection(Inspection inspection){
        return getJdbcTemplate().query("SELECT * FROM shocks WHERE inspectionId = ?",
                (rs,i) -> new Shocks.ShocksBuilder(inspection.getInspectionId())
                        .shocksId(rs.getInt("shocksId"))
                        .fitting(Arrays.asList(rs.getString("fitting").split(",")))
                        .physical(Arrays.asList(rs.getString("physical").split(",")))
                        .build(),inspection.getInspectionId());
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Shocks findByShockId(Integer shocksId){

        return getJdbcTemplate().queryForObject("SELECT * FROM shocks WHERE shocksId = ?",
                (rs, i) -> new Shocks.ShocksBuilder(rs.getInt("inspectionId"))
                        .shocksId(shocksId)
                        .fitting(Arrays.asList(rs.getString("fitting").split(",")))
                        .physical(Arrays.asList(rs.getString("physical").split(",")))
                        .build(),shocksId);

    }

}
