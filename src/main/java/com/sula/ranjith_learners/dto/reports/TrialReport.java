package com.sula.ranjith_learners.dto.reports;

import java.sql.Date;
import java.sql.Time;

public interface TrialReport {
    String getId();

    Date getDate();

    Time getTime();

    String getVenue();

    long getTotalParticipants();

    long getTotalPass();

    long getTotalFail();
}
