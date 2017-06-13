package ke.co.apollo.autoxpress.web;

import ke.co.apollo.autoxpress.entity.Inspection;
import ke.co.apollo.autoxpress.repo.InspectionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonNumber;
import javax.json.JsonObject;
import java.time.LocalDate;

/**
 * Created by anthony.kipkoech on 13/06/2017.
 */
@RestController
@RequestMapping("/inspection")
public class InspectionHandler extends AbstractHandler {

    @Autowired
    private InspectionRepo repo;

    @PostMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public Inspection create(//@RequestParam(value = "regNo") String regNo,
                             @RequestParam(value = "data") String jsonData){
        JsonObject jsonObject = parseJsonObject(jsonData);

        String dateStr = jsonObject.getString("inspectionDate");
        LocalDate inspectionDate = LocalDate.parse(dateStr,DATE_FORMAT_yyyyMMdd);
        Long odo = ((JsonNumber) jsonObject.get("odometerReading")).longValue();
        String regNo = jsonObject.getString("regNo");
        Boolean shocksFitting = jsonObject.getBoolean("shocksFitting");
        Boolean shocksPhysical = jsonObject.getBoolean("shocksPhysical");
        Boolean steeringPlay = jsonObject.getBoolean("steeringPlay");
        Boolean gearShiftingProperly = jsonObject.getBoolean("gearShiftingProperly");
        Boolean footBrakes = jsonObject.getBoolean("footBrakes");
        Boolean handbrakes = jsonObject.getBoolean("handbrakes");
        Boolean engineOilLeaks = jsonObject.getBoolean("engineOilLeaks");
        Boolean frontLeftTyr = jsonObject.getBoolean("frontLeftTyre");
        Boolean frontRightTyre = jsonObject.getBoolean("frontRightTyre");
        Boolean rearRightTyre = jsonObject.getBoolean("rearRightTyre");
        Boolean rearLeftTyr = jsonObject.getBoolean("rearLeftTyre");
        Boolean spareTyre = jsonObject.getBoolean("spareTyre");
        Boolean headLights = jsonObject.getBoolean("headLights");
        Boolean brakeLights = jsonObject.getBoolean("brakeLights");
        Boolean indicators = jsonObject.getBoolean("indicators");
        Boolean parkingLights = jsonObject.getBoolean("parkingLights");
        Boolean tailLights = jsonObject.getBoolean("tailLights");
        Boolean reverseLight = jsonObject.getBoolean("reverseLights");
        Boolean wiringConcerns = jsonObject.getBoolean("wiringConcerns");
        Boolean windscreenWipers = jsonObject.getBoolean("windscreenWipers");
        Boolean windscreenCrackFree = jsonObject.getBoolean("windscreenCrackFree");
        Boolean doorLocks = jsonObject.getBoolean("doorLocks");
        Boolean sideMirrors = jsonObject.getBoolean("sideMirrors");
        Boolean fenderAndBumper = jsonObject.getBoolean("fenderAndBumper");
        Boolean generalCondition = jsonObject.getBoolean("generalCondition");
        Boolean complete = jsonObject.getBoolean("complete");

        return repo.create(inspectionDate,odo,regNo,shocksFitting,shocksPhysical,steeringPlay,gearShiftingProperly,
                footBrakes,handbrakes,engineOilLeaks,frontLeftTyr,frontRightTyre,rearRightTyre,rearLeftTyr,spareTyre,
                headLights,brakeLights,indicators,parkingLights,tailLights,reverseLight,wiringConcerns,windscreenWipers,
                windscreenCrackFree,doorLocks,sideMirrors,fenderAndBumper,generalCondition,complete);
    }

}
