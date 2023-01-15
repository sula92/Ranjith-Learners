package com.sula.ranjith_learners.repository;

import com.sula.ranjith_learners.model.EmployeeKPI;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeKPIRepository extends JpaRepository<EmployeeKPI, Integer> {

    @Query(value = "SELECT * FROM `employeekpi` WHERE `factoryId`= :fid", nativeQuery = true)
    List<EmployeeKPI> getAllFactoryPerformedEmployees(@Param("fid") int fid);

    @Query(value = "SELECT * FROM `employeekpi`", nativeQuery = true)
    List<EmployeeKPI> getAllEmployeesKPI();
}
