package ru.aikamsoft.result;

import ru.aikamsoft.result.subresult.CriteriaResult;

import java.util.List;

public class SearchResult extends Result{

    private List<CriteriaResult> criteriaResultList;

    public SearchResult(){
        super();
        setType("search");
    }

    public List<CriteriaResult> getCriteriaResultList() {
        return criteriaResultList;
    }

    public void setCriteriaResultList(List<CriteriaResult> criteriaResultList) {
        this.criteriaResultList = criteriaResultList;
    }
}
