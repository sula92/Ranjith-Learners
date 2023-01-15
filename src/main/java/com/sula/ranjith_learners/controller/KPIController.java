package com.sula.ranjith_learners.controller;


import com.sula.ranjith_learners.dto.FactoryPerformedEmployeeDTO;
import com.sula.ranjith_learners.dto.KPIDTO;
import com.sula.ranjith_learners.model.EmployeeKPI;
import com.sula.ranjith_learners.repository.EmployeeKPIRepository;
import com.sula.ranjith_learners.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(
        value = "/api",
        produces = "application/json")

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
@Transactional
public class KPIController {
    
    @Autowired
    EmployeeKPIRepository employeeKPIRepository;
    
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/kpis")
    public List<EmployeeKPI> getAllkpis(){

        return employeeKPIRepository.findAll();
    }

    /*@GetMapping("/kpis/counts")
    public KPIPriorityCountsDTO getkpisCount(){

      return null;
    }*/


    @PutMapping("/kpis/{id}")
    public EmployeeKPI editKPI(@PathVariable int id, @RequestBody KPIDTO kpidto){

        employeeKPIRepository.findById(id).get();

        return employeeKPIRepository.save(
                EmployeeKPI.builder()
                        .availabilityLevel(kpidto.getAvailabilityLevel())
                        .efficiencyLevel(kpidto.getEfficiencyLevel())
                        .reliabilityLevel(kpidto.getReliabilityLevel())
                        .employee(employeeRepository.findById(kpidto.getId()).get())
                        .build()
        );
    }

    @PostMapping("/kpis")
    public EmployeeKPI createKPI(@RequestBody KPIDTO kpidto){

      return employeeKPIRepository.save(
              EmployeeKPI.builder()
              .availabilityLevel(kpidto.getAvailabilityLevel())
              .efficiencyLevel(kpidto.getEfficiencyLevel())
              .reliabilityLevel(kpidto.getReliabilityLevel())
               .employee(employeeRepository.findById(kpidto.getId()).get())
              .build()
      );

    }

    @DeleteMapping("/kpis/{id}")
    public void deleteKPI(@PathVariable int id){

        employeeKPIRepository.deleteById(id);
    }

    @GetMapping("/kpis/counts")
    public FactoryPerformedEmployeeDTO getAllPerformedEmployeeCounts(){
        int a=0;
        int b=0;
        int c=0;
        int d=0;

        List<EmployeeKPI> KPIList=employeeKPIRepository.getAllEmployeesKPI();

        for (int i = 0; i <KPIList.size() ; i++) {

            double avg=kpiAverage(KPIList.get(i).getAvailabilityLevel(), KPIList.get(i).getEfficiencyLevel(), KPIList.get(i).getReliabilityLevel());

            if (avg>=7.0){
                a++;
            }
            else if (avg<7.0 && avg>=5.0){
                b++;
            }
            else {
                c++;
            }
        }

        return FactoryPerformedEmployeeDTO.builder().high(a).medium(b).low(c).tot(a+b+c+d).build();


    }

    private double kpiAverage(int eff, int avai, int rel){
        double avg=(eff+avai+rel)/3.0;
        return avg;
    }


}
