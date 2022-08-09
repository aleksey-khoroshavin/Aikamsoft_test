package ru.aikamsoft.result.subresult;

import ru.aikamsoft.entity.Customer;
import ru.aikamsoft.operation.search.criterias.Criteria;

import java.util.List;

public class CriteriaResult {
    private Criteria criteria;

    private List<Customer> resultsCustomers;

    public Criteria getCriteria() {
        return criteria;
    }

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public List<Customer> getResultsCustomers() {
        return resultsCustomers;
    }

    public void setResultsCustomers(List<Customer> resultsCustomers) {
        this.resultsCustomers = resultsCustomers;
    }
}
