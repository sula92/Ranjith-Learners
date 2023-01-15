package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.dto.CommonDTO;
import com.sula.ranjith_learners.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
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
public class PublicController {

    @Autowired
    StudentPaymentRepository studentPaymentRepository;

    @Autowired
    OtherExpenseRepository otherExpenseRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ExpenseRepository expenseRepository;

    @Autowired
    IncomeRepository incomeRepository;

    @Autowired
    EmployeeSalaryRepository  employeeSalaryRepository;

    /*@GetMapping("/income&expense")
    public TotIncomeAndExpensesDTO getTotIncome(){
        long stdIncome=studentPaymentRepository.getStudentMonthlyIncome();
        long totOtherExp=otherExpenseRepository.getTotOtherExpenses();
        long totSalaries=employeeRepository.getTotOtherExpenses();
        TotIncomeAndExpensesDTO totIncomeAndExpensesDTO =new TotIncomeAndExpensesDTO();
        totIncomeAndExpensesDTO.setGrossIncome(String.valueOf(stdIncome));
        totIncomeAndExpensesDTO.setNetIncome(String.valueOf(stdIncome));
        totIncomeAndExpensesDTO.setSalariesPaid(String.valueOf(totSalaries));
        totIncomeAndExpensesDTO.setTotalOtherExpenses(String.valueOf(totOtherExp));

        return totIncomeAndExpensesDTO;
    }

    @GetMapping("/income_records")
    public List<IncomeExpenseDTO> getIncomeRecords(){
        List<StudentPayment> studentPayments =studentPaymentRepository.findAll();
        List<IncomeExpenseDTO> incomeExpenseDTOS=new ArrayList<>();

        studentPayments.stream().forEach(incomeRecords -> {
            incomeExpenseDTOS.add(
                    IncomeExpenseDTO.builder().
                           Amount((long) incomeRecords.getAmount())
                            .description(incomeRecords.getPaymentDetail())
                            .Date(incomeRecords.getDateOfSettled().toString())
                            .build()
            );
        });


        return incomeExpenseDTOS;
    }

    @GetMapping("/expense_records")
    public List<IncomeExpenseDTO> getExpenseRecords(){
        List<OtherExpense> otherExpenses =otherExpenseRepository.findAll();
        List<IncomeExpenseDTO> incomeExpenseDTOS=new ArrayList<>();

        otherExpenses.stream().forEach(otherExpense -> {
            incomeExpenseDTOS.add(
                    IncomeExpenseDTO.builder().Amount(otherExpense.getAmount())
                            .Date(otherExpense.getDate().toString())
                            .description(otherExpense.getDescription()).build()
            );
        });


        return incomeExpenseDTOS;
    }*/

    @GetMapping("/dashboard")
    public CommonDTO getDashboardRecords(){
        Map<String, String> stringStringMap=new HashMap<>();

        long x=studentRepository.findAll().stream().count();
        long y=studentRepository.findAll().stream()
                .filter(student -> student.getIsLicenseIssued().equalsIgnoreCase("yes"))
                .count();
        long z=expenseRepository.getTotOtherExpenses()+employeeSalaryRepository.getTotSal();
        long p=incomeRepository.getTotIncome();

        stringStringMap.put("x", String.valueOf(x));
        stringStringMap.put("y", String.valueOf(y));
        stringStringMap.put("z", String.valueOf(z));
        stringStringMap.put("p", String.valueOf(p));

        return CommonDTO.builder().stringMap(stringStringMap).build();
    }

}
