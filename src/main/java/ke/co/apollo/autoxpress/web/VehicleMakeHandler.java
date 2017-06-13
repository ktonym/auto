package ke.co.apollo.autoxpress.web;

import ke.co.apollo.autoxpress.entity.VehicleMake;
import ke.co.apollo.autoxpress.repo.VehicleMakeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by anthony.kipkoech on 12/06/2017.
 */
@RestController
@RequestMapping("/vehiclemake")
public class VehicleMakeHandler {

    @Autowired
    private VehicleMakeRepo repo;

    @PostMapping(value = ("/create"), produces = "application/json")
    @ResponseBody
    public VehicleMake create(@RequestParam(value = "make") String make, HttpServletRequest request){
        return repo.create(make);
    }

    @PostMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public VehicleMake update(@RequestParam(value = "make") String make,
                              @RequestParam(value = "makeId") Integer makeId){
        return repo.update(makeId,make);
    }

    @GetMapping(value = "/findAll", produces = "application/json")
    @ResponseBody
    public List<VehicleMake> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/findByMakeLike", produces = "application/json")
    @ResponseBody
    public List<VehicleMake> findByMakeLike(@RequestParam(value = "searchStr") String searchStr){
        return repo.findByMakeLike(searchStr);
    }

}
