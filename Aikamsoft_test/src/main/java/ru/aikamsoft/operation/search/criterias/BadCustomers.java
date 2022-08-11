package ru.aikamsoft.operation.search.criterias;

import com.google.gson.JsonElement;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BadCustomers implements Criteria{
    private int badCustomersValue;

    public int getBadCustomersValue() {
        return badCustomersValue;
    }

    @Override
    public String getCriteriaName() {
        return "badCustomers";
    }

    @Override
    public void initCriteriaParams(Set<Map.Entry<String, JsonElement>> params) {
        Iterator<Map.Entry<String, JsonElement>> iterator = params.iterator();
        Map.Entry<String, JsonElement> entry = iterator.next();
        badCustomersValue = Integer.parseInt(entry.getValue().getAsString());
    }
}
