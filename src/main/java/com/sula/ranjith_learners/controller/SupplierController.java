package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.exceptions.ResourceNotFoundException;
import com.sula.ranjith_learners.model.Supplier;
import com.sula.ranjith_learners.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

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
public class SupplierController {
    
    @Autowired
    SupplierRepository supplierRepository;


    @GetMapping("/Suppliers")
    public List<Supplier> getAllSuppliers(){
        return supplierRepository.findAll();
    }

    /*@GetMapping("/Suppliers/getLast")
    public Supplier getLastSupplier(){
        return supplierRepository.findTopByOrderByIdDesc().get();
    }*/

    @GetMapping("/Suppliers/{id}")
    public Supplier getSupplierById(@PathVariable int id) throws ResourceNotFoundException {
        try {
            return supplierRepository.findById(id).get();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResourceNotFoundException("Can Not Find The Supplier");
        }

    }

    /*@GetMapping("/Suppliers/report/{id}")
    public List<SupplierReportById> getSupplierByIdReport(@PathVariable String id) throws ResourceNotFoundException {
        try {
            return supplierRepository.getSupplierByIdReport(id);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResourceNotFoundException("Can Not Find The Record");
        }

    }*/

    /*@GetMapping("/Suppliers/report")
    public List<SupplierReport> getSupplierReport(@PathVariable String id) throws ResourceNotFoundException {
        try {
            return supplierRepository.getSupplierReport();
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResourceNotFoundException("Can Not Find The Record");
        }

    }*/

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/Suppliers")
    public Supplier saveSupplier(@RequestBody @Valid Supplier Supplier){
        return supplierRepository.save(Supplier);
    }

    @PutMapping("/Suppliers")
    public Supplier editSupplier(@RequestBody @Valid Supplier Supplier){
        return supplierRepository.save(Supplier);
    }

    @DeleteMapping("/Suppliers")
    public void deleteSupplier(@RequestParam int id){
        supplierRepository.deleteById(id);
    }

}
