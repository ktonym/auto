package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.Owner;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

/**
 * Created by anthony.kipkoech on 30/05/2017.
 */
@Repository
public class OwnerRepo extends JdbcDaoSupport {

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

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
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

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
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

    @Transactional(readOnly = true,propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
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

}
