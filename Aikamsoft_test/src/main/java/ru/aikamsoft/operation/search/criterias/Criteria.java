package ru.aikamsoft.operation.search.criterias;

import com.google.gson.JsonElement;

import java.util.Map;
import java.util.Set;

public interface Criteria {
    String getCriteriaName();
    void initCriteriaParams(Set<Map.Entry<String, JsonElement>> params);
}
