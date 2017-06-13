package ke.co.apollo.autoxpress.repo;

import ke.co.apollo.autoxpress.entity.Inspection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by anthony.kipkoech on 08/06/2017.
 */
@Repository
public class InspectionRepo extends JdbcDaoSupport{

    @Autowired
    public void setDs(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Inspection create(/*Integer inspectionId,*/ LocalDate inspectionDate, Long odometerReading,
                             String regNo, Boolean shocksFitting, Boolean shocksPhysical,
                             Boolean steeringPlay, Boolean gearShiftingProperly, Boolean footBrakes,
                             Boolean handbrakes, Boolean engineOilLeaks, Boolean frontLeftTyre,
                             Boolean frontRightTyre, Boolean rearRightTyre, Boolean rearLeftTyre,
                             Boolean spareTyre, Boolean headLights, Boolean brakeLights, Boolean indicators,
                             Boolean parkingLights, Boolean tailLights, Boolean reverseLights,
                             Boolean wiringConcerns, Boolean windscreenWipers, Boolean windscreenCrackFree,
                             Boolean doorLocks, Boolean sideMirrors, Boolean fenderAndBumper,
                             Boolean generalCondition, Boolean complete){

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String idCol = "inspectionId";

        getJdbcTemplate().update(con -> {
            PreparedStatement ps = con.prepareStatement("INSERT INTO inspection(inspectionDate,odometerReading,regNo,shocksFitting,shocksPhysical,steeringPlay,gearShiftingProperly,footBrakes,handbrakes,engineOilLeaks,frontLeftTyre,frontRightTyre,rearRightTyre,rearLeftTyre,spareTyre,headLights, brakeLights,indicators,parkingLights,tailLights,reverseLights,wiringConcerns,windscreenWipers,windscreenCrackFree,doorLocks,sideMirrors,fenderAndBumper,generalCondition,complete)" +
                            " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
                    new String[]{idCol});
            ps.setDate(1, Date.valueOf(inspectionDate));
            ps.setLong(2,odometerReading);
            ps.setString(3,regNo);
            ps.setBoolean(4,shocksFitting);
            ps.setBoolean(5,shocksPhysical);
            ps.setBoolean(6,steeringPlay);
            ps.setBoolean(7,gearShiftingProperly);
            ps.setBoolean(8,footBrakes);
            ps.setBoolean(9,handbrakes);
            ps.setBoolean(10,engineOilLeaks);
            ps.setBoolean(11,frontLeftTyre);
            ps.setBoolean(12,frontRightTyre);
            ps.setBoolean(13,rearRightTyre);
            ps.setBoolean(14,rearLeftTyre);
            ps.setBoolean(15,spareTyre);
            ps.setBoolean(16,headLights);
            ps.setBoolean(17,brakeLights);
            ps.setBoolean(18,indicators);
            ps.setBoolean(19,parkingLights);
            ps.setBoolean(20,tailLights);
            ps.setBoolean(21,reverseLights);
            ps.setBoolean(22,wiringConcerns);
            ps.setBoolean(23,windscreenWipers);
            ps.setBoolean(24,windscreenCrackFree);
            ps.setBoolean(25,doorLocks);
            ps.setBoolean(26,sideMirrors);
            ps.setBoolean(27,fenderAndBumper);
            ps.setBoolean(28,generalCondition);
            ps.setBoolean(29,complete);
            return ps;
        },keyHolder);

        return new Inspection.InspectionBuilder().inspectionId(keyHolder.getKey().intValue()).inspectionDate(inspectionDate)
                .odometerReading(odometerReading).regNo(regNo).shocksFitting(shocksFitting).shocksPhysical(shocksPhysical)
                .steeringPlay(steeringPlay).gearShiftingProperly(gearShiftingProperly).footBrakes(footBrakes).handbrakes(handbrakes)
                .engineOilLeaks(engineOilLeaks).frontLeftTyre(frontLeftTyre).frontRightTyre(frontRightTyre).rearRightTyre(rearRightTyre)
                .rearLeftTyre(rearLeftTyre).spareTyre(spareTyre).headLights(headLights).brakeLights(brakeLights)
                .indicators(indicators).parkingLights(parkingLights).tailLights(tailLights).reverseLights(reverseLights)
                .wiringConcerns(wiringConcerns).windscreenWipers(windscreenWipers).windscreenCrackFree(windscreenCrackFree)
                .doorLocks(doorLocks).sideMirrors(sideMirrors).fenderAndBumper(fenderAndBumper).generalCondition(generalCondition)
                .complete(complete).build();

    };


    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Inspection> findByRegNo(String regNo){

        return getJdbcTemplate().query("SELECT * FROM inspection WHERE regNo = ?",
                (rs, i ) -> new Inspection.InspectionBuilder()
                        .inspectionId(rs.getInt(1))
                        .inspectionDate(rs.getDate(2).toLocalDate())
                        .odometerReading(rs.getLong(3))
                        .regNo(regNo).shocksFitting(rs.getBoolean(5)).shocksPhysical(rs.getBoolean(6))
                        .steeringPlay(rs.getBoolean(7)).gearShiftingProperly(rs.getBoolean(8))
                        .footBrakes(rs.getBoolean(9)).handbrakes(rs.getBoolean(10))
                        .engineOilLeaks(rs.getBoolean(11)).frontLeftTyre(rs.getBoolean(12))
                        .frontRightTyre(rs.getBoolean(13)).rearRightTyre(rs.getBoolean(14))
                        .rearLeftTyre(rs.getBoolean(15)).spareTyre(rs.getBoolean(16))
                        .headLights(rs.getBoolean(17)).brakeLights(rs.getBoolean(18))
                        .indicators(rs.getBoolean(19)).parkingLights(rs.getBoolean(20))
                        .tailLights(rs.getBoolean(21)).reverseLights(rs.getBoolean(22))
                        .wiringConcerns(rs.getBoolean(23)).windscreenWipers(rs.getBoolean(24))
                        .windscreenCrackFree(rs.getBoolean(25)).doorLocks(rs.getBoolean(26))
                        .sideMirrors(rs.getBoolean(27)).fenderAndBumper(rs.getBoolean(28))
                        .generalCondition(rs.getBoolean(29)).complete(rs.getBoolean(30))
                        .build(),regNo);

    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Inspection findById(Integer inspectionId){

        return getJdbcTemplate().queryForObject("SELECT * FROM inspection WHERE inspectionId = ?",
                (rs, i ) -> new Inspection.InspectionBuilder()
                        .inspectionId(rs.getInt(1))
                        .inspectionDate(rs.getDate(2).toLocalDate())
                        .odometerReading(rs.getLong(3))
                        .regNo(rs.getString(4)).shocksFitting(rs.getBoolean(5)).shocksPhysical(rs.getBoolean(6))
                        .steeringPlay(rs.getBoolean(7)).gearShiftingProperly(rs.getBoolean(8))
                        .footBrakes(rs.getBoolean(9)).handbrakes(rs.getBoolean(10))
                        .engineOilLeaks(rs.getBoolean(11)).frontLeftTyre(rs.getBoolean(12))
                        .frontRightTyre(rs.getBoolean(13)).rearRightTyre(rs.getBoolean(14))
                        .rearLeftTyre(rs.getBoolean(15)).spareTyre(rs.getBoolean(16))
                        .headLights(rs.getBoolean(17)).brakeLights(rs.getBoolean(18))
                        .indicators(rs.getBoolean(19)).parkingLights(rs.getBoolean(20))
                        .tailLights(rs.getBoolean(21)).reverseLights(rs.getBoolean(22))
                        .wiringConcerns(rs.getBoolean(23)).windscreenWipers(rs.getBoolean(24))
                        .windscreenCrackFree(rs.getBoolean(25)).doorLocks(rs.getBoolean(26))
                        .sideMirrors(rs.getBoolean(27)).fenderAndBumper(rs.getBoolean(28))
                        .generalCondition(rs.getBoolean(29)).complete(rs.getBoolean(30))
                        .build(),inspectionId);

    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Inspection> findByInspectionDate(LocalDate inspectionDate){

        return getJdbcTemplate().query("SELECT * FROM inspection WHERE inspectionDate = ?",
                (rs, i ) -> new Inspection.InspectionBuilder()
                        .inspectionId(rs.getInt(1)).inspectionDate(rs.getDate(2).toLocalDate())
                        .odometerReading(rs.getLong(3)).regNo(rs.getString(4))
                        .shocksFitting(rs.getBoolean(5)).shocksPhysical(rs.getBoolean(6))
                        .steeringPlay(rs.getBoolean(7)).gearShiftingProperly(rs.getBoolean(8))
                        .footBrakes(rs.getBoolean(9)).handbrakes(rs.getBoolean(10))
                        .engineOilLeaks(rs.getBoolean(11)).frontLeftTyre(rs.getBoolean(12))
                        .frontRightTyre(rs.getBoolean(13)).rearRightTyre(rs.getBoolean(14))
                        .rearLeftTyre(rs.getBoolean(15)).spareTyre(rs.getBoolean(16))
                        .headLights(rs.getBoolean(17)).brakeLights(rs.getBoolean(18))
                        .indicators(rs.getBoolean(19)).parkingLights(rs.getBoolean(20))
                        .tailLights(rs.getBoolean(21)).reverseLights(rs.getBoolean(22))
                        .wiringConcerns(rs.getBoolean(23)).windscreenWipers(rs.getBoolean(24))
                        .windscreenCrackFree(rs.getBoolean(25)).doorLocks(rs.getBoolean(26))
                        .sideMirrors(rs.getBoolean(27)).fenderAndBumper(rs.getBoolean(28))
                        .generalCondition(rs.getBoolean(29)).complete(rs.getBoolean(30))
                        .build(),Date.valueOf(inspectionDate));

    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Inspection> findByComplete(Boolean complete){
        return getJdbcTemplate().query("SELECT * FROM inspection WHERE complete = ?",
                (rs, i ) -> new Inspection.InspectionBuilder()
                        .inspectionId(rs.getInt(1)).inspectionDate(rs.getDate(2).toLocalDate())
                        .odometerReading(rs.getLong(3)).regNo(rs.getString(4))
                        .shocksFitting(rs.getBoolean(5)).shocksPhysical(rs.getBoolean(6))
                        .steeringPlay(rs.getBoolean(7)).gearShiftingProperly(rs.getBoolean(8))
                        .footBrakes(rs.getBoolean(9)).handbrakes(rs.getBoolean(10))
                        .engineOilLeaks(rs.getBoolean(11)).frontLeftTyre(rs.getBoolean(12))
                        .frontRightTyre(rs.getBoolean(13)).rearRightTyre(rs.getBoolean(14))
                        .rearLeftTyre(rs.getBoolean(15)).spareTyre(rs.getBoolean(16))
                        .headLights(rs.getBoolean(17)).brakeLights(rs.getBoolean(18))
                        .indicators(rs.getBoolean(19)).parkingLights(rs.getBoolean(20))
                        .tailLights(rs.getBoolean(21)).reverseLights(rs.getBoolean(22))
                        .wiringConcerns(rs.getBoolean(23)).windscreenWipers(rs.getBoolean(24))
                        .windscreenCrackFree(rs.getBoolean(25)).doorLocks(rs.getBoolean(26))
                        .sideMirrors(rs.getBoolean(27)).fenderAndBumper(rs.getBoolean(28))
                        .generalCondition(rs.getBoolean(29)).complete(rs.getBoolean(30))
                        .build(),complete);

    }

}
