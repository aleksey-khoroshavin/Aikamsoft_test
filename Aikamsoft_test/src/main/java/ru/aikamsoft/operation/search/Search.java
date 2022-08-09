package ru.aikamsoft.operation.search;

import ru.aikamsoft.operation.search.criterias.Criteria;

import java.util.List;

public class Search {
    private List<Criteria> criteriaList;

    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }
}
