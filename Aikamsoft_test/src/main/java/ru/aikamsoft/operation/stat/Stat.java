package ru.aikamsoft.operation.stat;

import ru.aikamsoft.operation.Operation;
import ru.aikamsoft.result.Result;

public class Stat implements Operation {
    private String startDate;

    private String endDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public Result performOperation() {
        return null;
    }

}
