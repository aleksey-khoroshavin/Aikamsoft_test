package ru.aikamsoft.operation.search.criterias.searcher;

import ru.aikamsoft.entity.Customer;
import ru.aikamsoft.operation.search.criterias.Criteria;
import ru.aikamsoft.operation.search.criterias.LastName;
import ru.aikamsoft.result.subresult.CriteriaResult;

import java.sql.SQLException;
import java.util.List;

public class LastNameSearcher extends CriteriaSearcher{
    @Override
    public CriteriaResult searchByCriteria(Criteria criteria) throws SQLException{
        LastName criteriaLastName = (LastName) criteria;

        CriteriaResult criteriaResult = new CriteriaResult();
        criteriaResult.setCriteria(criteriaLastName);

        String sql = "select customers.firstname, customers.lastname from customers " +
                "where customers.lastname like '" + criteriaLastName.getLastName() + "'";

        List<Customer> foundCustomers = findCustomersBySql(sql);
        criteriaResult.setResultsCustomers(foundCustomers);

        return criteriaResult;
    }
}
