package com.sula.ranjith_learners.service;

import com.sula.ranjith_learners.model.Trial;
import com.sula.ranjith_learners.repository.TrialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrialService {

    @Autowired
    TrialRepository trialRepository;

    public Trial saveExam(Trial trial){
        Trial lastTrial=trialRepository.findTopByOrderByIdDesc().get();
        String lastId= String.valueOf(lastTrial.getId());
        String newId;
        int lId= Integer.parseInt(lastId.replace("E",""));
        newId="E"+(lId+1);
        trial.setId(Integer.parseInt(newId));
        return trialRepository.save(trial);
    }
}
