package ke.co.apollo.autoxpress.web;

import ke.co.apollo.autoxpress.entity.BodyType;
import ke.co.apollo.autoxpress.repo.BodyTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by anthony.kipkoech on 12/06/2017.
 */
@RestController
@RequestMapping("/bodytype")
public class BodyTypeHandler {

    @Autowired
    private BodyTypeRepo repo;

    @PostMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public BodyType create(@RequestParam(value = "body") String body){
        return repo.create(body);
    }

    @PostMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public BodyType update(@RequestParam(value = "bodyTypeId") Integer bodyTypeId,
                           @RequestParam(value = "body") String body){
        return repo.update(bodyTypeId,body);
    }

    @GetMapping(value = "/findAll", produces = "application/json")
    @ResponseBody
    public List<BodyType> findAll(){
        return repo.findAll();
    }

}
