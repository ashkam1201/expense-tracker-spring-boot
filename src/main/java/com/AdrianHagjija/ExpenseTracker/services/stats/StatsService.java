package com.AdrianHagjija.ExpenseTracker.services.stats;

import com.AdrianHagjija.ExpenseTracker.dto.GraphDTO;
import com.AdrianHagjija.ExpenseTracker.dto.StatsDTO;

public interface StatsService {

    GraphDTO getChartData();

    StatsDTO getStats();
}
