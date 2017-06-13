package ke.co.apollo.autoxpress.web;

import ke.co.apollo.autoxpress.entity.Owner;
import ke.co.apollo.autoxpress.repo.OwnerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by anthony.kipkoech on 12/06/2017.
 */
@RestController
@RequestMapping("/owner")
public class OwnerHandler {

    @Autowired
    private OwnerRepo repo;

    @PostMapping(value = "/create", produces = "application/json")
    @ResponseBody
    public Owner create(@RequestParam(value = "name") String name,
                        @RequestParam(value = "email") String email,
                        @RequestParam(value = "mobile") String mobile,
                        @RequestParam(value = "id_pin") String id_pin,
                        @RequestParam(value = "idPhoto") String idPhoto,
                        @RequestParam(value = "dlPhoto") String dlPhoto){
        return repo.create(name,email,mobile,id_pin,idPhoto,dlPhoto);
    }

    @PostMapping(value = "/update", produces = "application/json")
    @ResponseBody
    public Owner update(@RequestParam(value = "ownerId") Integer ownerId,
                        @RequestParam(value = "name") String name,
                        @RequestParam(value = "email") String email,
                        @RequestParam(value = "mobile") String mobile,
                        @RequestParam(value = "id_pin") String id_pin,
                        @RequestParam(value = "idPhoto") String idPhoto,
                        @RequestParam(value = "dlPhoto") String dlPhoto){
        return repo.update(ownerId,name,email,mobile,id_pin,idPhoto,dlPhoto);
    }

    @GetMapping(value = "/findAll", produces = "application/json")
    @ResponseBody
    public List<Owner> findAll(){
        return repo.findAll();
    }

}
