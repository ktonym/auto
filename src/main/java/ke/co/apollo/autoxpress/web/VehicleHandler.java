package ke.co.apollo.autoxpress.web;

import ke.co.apollo.autoxpress.entity.Vehicle;
import ke.co.apollo.autoxpress.service.VehicleSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.time.Year;
import java.time.format.DateTimeFormatter;

/**
 * Created by anthony.kipkoech on 13/06/2017.
 */
@RestController
@RequestMapping("/vehicle")
public class VehicleHandler {

    static final DateTimeFormatter YEAR_FORMAT_yyyy = DateTimeFormatter.ofPattern("yyyy");

    @Autowired
    private VehicleSvc service;

    @PostMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public Vehicle create(@RequestParam(value = "regNo") String regNo,
                          @RequestParam(value = "yom") String yomStr,
                          @RequestParam(value = "ownerId") Integer ownerId,
                          @RequestParam(value = "modelId") Integer modelId,
                          @RequestParam(value = "bodyTypeId") Integer bodyTypeId,
                          @RequestParam(value = "policyNo") String policyNo,
                          @RequestParam(value="logbookPhoto") CommonsMultipartFile file) throws IOException {

        return service.create(regNo,Year.parse(yomStr,YEAR_FORMAT_yyyy),ownerId,modelId,bodyTypeId,file,policyNo);
    }

    @GetMapping(value = "/findByRegNo", produces = "application/json")
    @ResponseBody
    public Vehicle findByRegNo(@RequestParam(value = "regNo") String regNo) throws IOException{
        return service.findByRegNo(regNo);
    }

    /*@GetMapping(value = "/findByOwnerId", produces = "application/json")
    @ResponseBody
    public List<Vehicle> findByOwner(@RequestParam(value = "ownerId") Integer ownerId){
        return service.findByOwnerId(ownerId);
    }*/

}
