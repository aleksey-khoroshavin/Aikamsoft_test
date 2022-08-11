package ru.aikamsoft.operation.search.criterias.searcher;

import ru.aikamsoft.connection.DatabaseConnection;
import ru.aikamsoft.entity.Customer;
import ru.aikamsoft.operation.search.criterias.Criteria;
import ru.aikamsoft.operation.search.criterias.LastName;
import ru.aikamsoft.result.subresult.CriteriaResult;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LastNameSearcher implements CriteriaSearcher{
    @Override
    public CriteriaResult searchByCriteria(Criteria criteria) throws SQLException{
        LastName criteriaLastName = (LastName) criteria;

        CriteriaResult criteriaResult = new CriteriaResult();
        criteriaResult.setCriteria(criteriaLastName);

        List<Customer> foundCustomers = findByLstName(criteriaLastName.getLastNameValue());
        criteriaResult.setResultsCustomers(foundCustomers);

        return criteriaResult;
    }

    List<Customer> findByLstName(String lastnameStr) throws SQLException {
        List<Customer> criteriaResult = new ArrayList<>();

        try(Connection connection = DatabaseConnection.getInstance().getConnection();
            Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery("select customers.firstname, customers.lastname from customers " +
                    "where customers.lastname like '" + lastnameStr + "'");

            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setFirstName(resultSet.getString("firstname"));
                customer.setLastName(resultSet.getString("lastname"));

                System.out.println(customer.getFirstName() + " " + customer.getLastName());

                criteriaResult.add(customer);
            }
        }

        return criteriaResult;
    }
}
