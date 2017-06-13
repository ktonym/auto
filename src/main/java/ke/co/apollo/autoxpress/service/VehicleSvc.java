package ke.co.apollo.autoxpress.service;

import ke.co.apollo.autoxpress.entity.Vehicle;
import ke.co.apollo.autoxpress.repo.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Year;

/**
 * Created by anthony.kipkoech on 13/06/2017.
 */
@Service("vehicleSvc")
public class VehicleSvc {

    @Autowired
    private VehicleRepo repo;

    public Vehicle create(String regNo, Year yom, Integer ownerId, Integer modelId,
                          Integer bodyTypeId, CommonsMultipartFile file, String policyNo) throws IOException{

        String destPath;

        if(!file.isEmpty()){
            BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            File destination = new File("C:\\autoImages\\"+file.getName());
            ImageIO.write(src,"png",destination);
            destPath = destination.getAbsolutePath();
        } else {
            destPath = "";
        }

        Vehicle vehicle = repo.create(regNo,yom,ownerId,modelId,bodyTypeId,destPath,policyNo);
        Vehicle.VehicleBuilder builder = new Vehicle.VehicleBuilder()
                .regNo(regNo)
                .yom(yom).ownerId(ownerId).policyNo(policyNo)
                .bodyTypeId(bodyTypeId).vehicleModelId(modelId);

        Path path = Paths.get(destPath);
        byte[] data = Files.readAllBytes(path);

        if(!destPath.isEmpty()|| destPath!=null) builder.logbookImage(data);

        return builder.build();

    }

    public Vehicle findByRegNo(String regNo) throws IOException{
        Vehicle vehicle = repo.findByRegistration(regNo);
        Path path = Paths.get(vehicle.getLogBookPhoto());
        byte[] data = Files.readAllBytes(path);
        Vehicle.VehicleBuilder builder = new Vehicle.VehicleBuilder()
                .regNo(regNo)
                .yom(vehicle.getYom()).ownerId(vehicle.getOwnerId()).policyNo(vehicle.getPolicyNo())
                .bodyTypeId(vehicle.getBodyTypeId()).vehicleModelId(vehicle.getVehicleModelId()).logbookImage(data);
        return builder.build();
    }

    /*public List<Vehicle> findByOwnerId(Integer ownerId) throws IOException{

        Vehicle vehicle = repo.findByOwnerId(ownerId);
        Path path = Paths.get(vehicle.getLogBookPhoto());
        byte[] data = Files.readAllBytes(path);
        Vehicle.VehicleBuilder builder = new Vehicle.VehicleBuilder()
                .regNo(vehicle.getRegNo())
                .yom(vehicle.getYom()).ownerId(ownerId).policyNo(vehicle.getPolicyNo())
                .bodyTypeId(vehicle.getBodyTypeId()).vehicleModelId(vehicle.getVehicleModelId()).logbookImage(data);
        return builder.build();

    }*/
}
