package ru.aikamsoft.operation.search;

import ru.aikamsoft.exception.CriteriaNotFoundException;
import ru.aikamsoft.operation.Operation;
import ru.aikamsoft.operation.search.criterias.Criteria;
import ru.aikamsoft.operation.search.criterias.searcher.*;
import ru.aikamsoft.result.Result;
import ru.aikamsoft.result.SearchResult;
import ru.aikamsoft.result.subresult.CriteriaResult;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Search implements Operation {
    private List<Criteria> criteriaList;

    public List<Criteria> getCriteriaList() {
        return criteriaList;
    }

    public void setCriteriaList(List<Criteria> criteriaList) {
        this.criteriaList = criteriaList;
    }

    @Override
    public Result performOperation() throws SQLException, CriteriaNotFoundException {
        SearchResult result = new SearchResult();
        List<CriteriaResult> criteriaResults = new ArrayList<>();

        for(Criteria criteria : criteriaList){
            CriteriaSearcher criteriaSearcher = defineCriteriaSearcherByName(criteria.getCriteriaName());
            criteriaResults.add(criteriaSearcher.searchByCriteria(criteria));
        }

        result.setCriteriaResultList(criteriaResults);

        return result;
    }

    private CriteriaSearcher defineCriteriaSearcherByName(String name) throws CriteriaNotFoundException {
        switch (name){
            case "lastName":
                return new LastNameSearcher();
            case "badCustomers":
                return new BadCustomersSearcher();
            case "limitExpenses":
                return new LimitExpensesSearcher();
            case "productTimes":
                return new ProductTimesSearcher();
            default:
                throw new CriteriaNotFoundException("Данный критерий не найден![" + name + "]");
        }
    }

}
