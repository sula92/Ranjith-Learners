package com.sula.ranjith_learners.service;

import com.sula.ranjith_learners.model.People;
import com.sula.ranjith_learners.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PeopleService {

    @Autowired
    PeopleRepository peopleRepository;


    public List<People> getPeolple() {


              return peopleRepository.findAll();

    }

    public People getPeolpleById(int id) {
          return peopleRepository.findById(id).get();

    }
}
