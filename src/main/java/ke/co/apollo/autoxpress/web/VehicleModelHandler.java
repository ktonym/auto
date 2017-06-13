package ke.co.apollo.autoxpress.web;

import ke.co.apollo.autoxpress.entity.VehicleModel;
import ke.co.apollo.autoxpress.repo.VehicleModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by anthony.kipkoech on 12/06/2017.
 */
@RestController
@RequestMapping("/vehiclemodel")
public class VehicleModelHandler {

    @Autowired
    private VehicleModelRepo repo;

    @PostMapping(value = ("/create"), produces = "application/json")
    @ResponseBody
    public VehicleModel create(@RequestParam(value = "model") String model,
                               @RequestParam(value = "makeId") Integer makeId){
        return repo.create(makeId,model);
    }

    @PostMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public VehicleModel update(@RequestParam(value = "modelId") Integer modelId,
                               @RequestParam(value = "makeId") Integer makeId,
                               @RequestParam(value = "model") String model){

        return repo.update(modelId,makeId,model);
    }

    @GetMapping(value = "/findByVehicleMake", produces = "application/json")
    @ResponseBody
    public List<VehicleModel> findByVehicleMake(@RequestParam(value = "makeId") Integer makeId){
        return repo.findByMake(makeId);
    }

}
