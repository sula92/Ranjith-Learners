package com.sula.ranjith_learners.controller;

import com.sula.ranjith_learners.dto.IncomeExpenseDTO;
import com.sula.ranjith_learners.dto.TotIncomeAndExpensesDTO;
import com.sula.ranjith_learners.model.OtherExpense;
import com.sula.ranjith_learners.model.StudentPayment;
import com.sula.ranjith_learners.repository.EmployeeRepository;
import com.sula.ranjith_learners.repository.OtherExpenseRepository;
import com.sula.ranjith_learners.repository.StudentPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/income&expense")
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
    }

}
