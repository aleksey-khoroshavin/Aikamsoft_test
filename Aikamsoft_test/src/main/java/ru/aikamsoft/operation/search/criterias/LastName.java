package ru.aikamsoft.operation.search.criterias;

import com.google.gson.JsonElement;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LastName implements Criteria{
    private String lastNameValue;

    public String getLastNameValue() {
        return lastNameValue;
    }

    @Override
    public String getCriteriaName() {
        return "lastName";
    }

    @Override
    public void initCriteriaParams(Set<Map.Entry<String, JsonElement>> params) {
        Iterator<Map.Entry<String, JsonElement>> iterator = params.iterator();
        Map.Entry<String, JsonElement> entry = iterator.next();
        lastNameValue = entry.getValue().getAsString();
    }
}
