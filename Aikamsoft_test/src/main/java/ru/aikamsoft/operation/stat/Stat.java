package ru.aikamsoft.operation.stat;

import ru.aikamsoft.exception.WrongDateFormatException;
import ru.aikamsoft.operation.Operation;
import ru.aikamsoft.operation.stat.searcher.CustomerPurchasesSearcher;
import ru.aikamsoft.parser.util.TotalDaysCounter;
import ru.aikamsoft.result.Result;
import ru.aikamsoft.result.StatResult;

import java.sql.SQLException;
import java.util.ArrayList;

public class Stat implements Operation {
    private String startDate;

    private String endDate;

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public Result performOperation() throws SQLException, WrongDateFormatException {
        StatResult statResult = new StatResult();

        TotalDaysCounter totalDaysCounter = new TotalDaysCounter();
        statResult.setTotalDays(totalDaysCounter.getTotalDaysCount(startDate, endDate));

        CustomerPurchasesSearcher customerPurchasesSearcher = new CustomerPurchasesSearcher();
        statResult.setCustomersPurchases(new ArrayList<>(customerPurchasesSearcher.
                getCustomersPurchasesForPeriod(startDate, endDate).values()));

        return statResult;
    }



}
