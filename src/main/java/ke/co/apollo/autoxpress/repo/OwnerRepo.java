package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.Owner;
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
 * Created by anthony.kipkoech on 30/05/2017.
 */
@Repository
public class OwnerRepo extends JdbcDaoSupport {

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Owner create(String name,String email,String mobile,
                        String id_pin,String idPhoto,String dlPhoto){

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "modelId";

        getJdbcTemplate().update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO owner(name,email,mobile,id_pin,idPhoto,dlPhoto) VALUES(?,?,?,?,?,?)",
                    new String[]{idCol});
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,mobile);
            ps.setString(5,idPhoto);
            ps.setString(4,id_pin);
            ps.setString(6,dlPhoto);
            return ps;
        },keyHolder);

        return new Owner.OwnerBuilder()
                .name(name).email(email).mobile(mobile).id_pin(id_pin)
                .dlPhoto(dlPhoto).idPhoto(idPhoto)
                .ownerId(keyHolder.getKey().intValue())
                .build();

    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Owner update(Integer ownerId, String name, String email,
                        String mobile, String id_pin, String idPhoto, String dlPhoto) {

        getJdbcTemplate().update("UPDATE owner SET name=?,email=?,mobile=?,id_pin=?,idPhoto=?,dlPhoto=? WHERE ownerId=?",
                new Object[]{name,email,mobile,id_pin,idPhoto,dlPhoto,ownerId});
        return new Owner.OwnerBuilder()
                .ownerId(ownerId).name(name).email(email).mobile(mobile).id_pin(id_pin)
                .idPhoto(idPhoto).dlPhoto(dlPhoto).build();

    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Owner> findByNameLike(String searchStr){
        return getJdbcTemplate().query("SELECT * FROM owner WHERE UPPER (name) LIKE ?",
                (rs,i) -> new Owner.OwnerBuilder()
                        .ownerId(rs.getInt(1))
                        .name(rs.getString(2))
                        .email(rs.getString(3))
                        .mobile(rs.getString(4))
                        .id_pin(rs.getString(5))
                        .idPhoto(rs.getString(6))
                        .dlPhoto(rs.getString(7))
                        .build()
                ,"%"+searchStr.toUpperCase()+"%");
    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public Owner findById_PIN(String search){

        return getJdbcTemplate().queryForObject("SELECT * FROM owner WHERE id_pin = ?",
                (rs, i) -> new Owner.OwnerBuilder()
                        .ownerId(rs.getInt(1))
                        .name(rs.getString(2))
                        .email(rs.getString(3))
                        .mobile(rs.getString(4))
                        .id_pin(rs.getString(5))
                        .idPhoto(rs.getString(6))
                        .dlPhoto(rs.getString(7))
                        .build(),search);

    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    private Owner findByOwnerId(Integer id){

        return getJdbcTemplate()
                .queryForObject("SELECT * FROM owner WHERE ownerId = ?",
                (rs, i) -> new Owner.OwnerBuilder()
                        .ownerId(rs.getInt(1))
                        .name(rs.getString(2))
                        .email(rs.getString(3))
                        .mobile(rs.getString(4))
                        .id_pin(rs.getString(5))
                        .idPhoto(rs.getString(6))
                        .dlPhoto(rs.getString(7))
                        .build(),id);

    }

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
    public List<Owner> findAll() {

       return getJdbcTemplate().query("SELECT * FROM owner",
                (rs,i) -> new Owner.OwnerBuilder()
                        .ownerId(rs.getInt("ownerId")).name(rs.getString("name"))
                        .email(rs.getString("email")).mobile(rs.getString("mobile"))
                        .id_pin(rs.getString("id_pin")).idPhoto(rs.getString("idPhoto"))
                        .dlPhoto(rs.getString("dlPhoto"))
                        .build());
    }
}
