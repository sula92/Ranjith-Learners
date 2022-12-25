package com.sula.ranjith_learners.dto.reports;

import java.sql.Date;
import java.sql.Time;

public interface ExamReport {
    String getId();

    Date getDate();

    Time getTime();

    String getVenue();

    int getTotalParticipants();

    int getTotalPass();

    int getTotalFail();
}
