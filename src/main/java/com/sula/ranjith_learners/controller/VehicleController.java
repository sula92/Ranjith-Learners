package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.dto.BranchStudentCountDTO;
import com.sula.ranjith_learners.dto.VehicleDTO;
import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.Vehicle;
import com.sula.ranjith_learners.repository.BranchRepository;
import com.sula.ranjith_learners.repository.SupplierRepository;
import com.sula.ranjith_learners.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(
        value = "/api",
        produces = "application/json")
@Transactional

@CrossOrigin(origins = {
        "*"

},
        allowedHeaders = "*",

        maxAge = 15 * 60,
        methods = {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.DELETE,
                RequestMethod.PUT
        })
public class VehicleController {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @GetMapping("/vehicles")
    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    @GetMapping("/vehicles/{id}")
    public Vehicle getVehicle(@PathVariable int id){
        return vehicleRepository.findById(id).get();
    }

    @PostMapping("/vehicles")
    public Vehicle createVehile(@RequestBody VehicleDTO vehicleDTO)
    {
        Vehicle vehicle=new Vehicle();
        vehicle.setId(vehicleDTO.getId());
        vehicle.setNumber(vehicleDTO.getNumber());
        vehicle.setTypeAndModel(vehicleDTO.getTypeAndModel());
        vehicle.setBranch(branchRepository.findById(vehicleDTO.getBranchId()).get());
        vehicle.setSupplier(supplierRepository.findById(vehicleDTO.getSupplierId()).get());
        return vehicleRepository.save(vehicle);
    }

    @PutMapping("/vehicles/{id}")
    public Vehicle editVehicle(@PathVariable int id, @RequestBody  VehicleDTO vehicleDTO){
        if(!(vehicleRepository.findById(id).get()==null)){

            Vehicle vehicle=new Vehicle();
            vehicle.setId(vehicleDTO.getId());
            vehicle.setNumber(vehicleDTO.getNumber());
            vehicle.setTypeAndModel(vehicleDTO.getTypeAndModel());
            vehicle.setBranch(branchRepository.findById(vehicleDTO.getBranchId()).get());
            vehicle.setSupplier(supplierRepository.findById(vehicleDTO.getSupplierId()).get());

            return vehicleRepository.save(vehicle);
        }
        else {
            return null;
        }
    }

    @DeleteMapping("/vehicles/{id}")
    public void deleteVehicle(@PathVariable int id){
        vehicleRepository.delete(vehicleRepository.getOne(id));

    }

    @GetMapping("/vehicles/counts")
    public BranchStudentCountDTO getAllBranchVehicleCounts(){
        int gam=0;
        int yakkala=0;
        int hiri=0;

        List<Vehicle> vehicleList=vehicleRepository.findAll();

        for (int i = 0; i <vehicleList.size() ; i++) {
            if (vehicleList.get(i).getBranch().getName().equalsIgnoreCase("gampaha")){
                gam++;
            }
            else if (vehicleList.get(i).getBranch().getName().equalsIgnoreCase("yakkala")){
                yakkala++;
            }
            else {
                hiri++;
            }
        }

        return BranchStudentCountDTO.builder().gampaha(gam).yakkala(yakkala).hiripitiya(hiri).build();


    }


    @GetMapping("/vehicles/supplier/{sid}")
    public List<Vehicle> getSupplierVehicles(@PathVariable int sid) throws ResourceNotFoundException {
        return vehicleRepository.findAll().stream()
                .filter(vehicle -> vehicle.getSupplier().getId()==sid)
                .collect(Collectors.toList());

    }

}
