package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.BodyType;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * Created by anthony.kipkoech on 29/05/2017.
 */
@Repository
public class BodyTypeRepo extends JdbcDaoSupport {

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public BodyType findById(Integer id){
        return getJdbcTemplate().queryForObject(
                "SELECT * FROM bodytype WHERE bodyTypeId = " + id,
                (rs, i) -> new BodyType.BodyTypeBuilder()
                        .bodyTypeId(rs.getInt(1))
                        .body(rs.getString(2))
                        .build());
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public List<BodyType> findByBodyLike(String searchStr){
        return getJdbcTemplate().query(
                "SELECT * FROM bodytype WHERE UPPER(body) LIKE '%" + searchStr.toUpperCase() + "%'",
                (rs, i) -> new BodyType.BodyTypeBuilder()
                        .bodyTypeId(rs.getInt(1))
                        .body(rs.getString(2))
                        .build());
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public BodyType findByBody(String body){
        return getJdbcTemplate().queryForObject("SELECT * FROM bodytype WHERE body = ? ",
                    (rs,i) -> new BodyType.BodyTypeBuilder()
                            .bodyTypeId(rs.getInt(1))
                            .body(rs.getString(2))
                            .build(), new String[]{body});
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public BodyType create(String body){
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "bodyTypeId";
        getJdbcTemplate().update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO bodytype(body) VALUES(?)", new String[]{idCol});
            ps.setString(1,body);
            return ps;
        },keyHolder);

        Integer id = (Integer) keyHolder.getKey().intValue();
        return new BodyType.BodyTypeBuilder().bodyTypeId(id).body(body).build();
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public BodyType update(Integer id,String body){
        getJdbcTemplate().update("UPDATE bodyType SET body = ? WHERE bodyTypeId = ?", new Object[]{body,id});
        return new BodyType.BodyTypeBuilder().bodyTypeId(id).body(body).build();
    }

}
