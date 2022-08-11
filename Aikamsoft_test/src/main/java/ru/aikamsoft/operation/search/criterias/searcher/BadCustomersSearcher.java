package ru.aikamsoft.operation.search.criterias.searcher;

import ru.aikamsoft.entity.Customer;
import ru.aikamsoft.operation.search.criterias.BadCustomers;
import ru.aikamsoft.operation.search.criterias.Criteria;
import ru.aikamsoft.result.subresult.CriteriaResult;

import java.sql.SQLException;
import java.util.List;

public class BadCustomersSearcher extends CriteriaSearcher{
    @Override
    public CriteriaResult searchByCriteria(Criteria criteria) throws SQLException {
        BadCustomers criteriaBadCustomers = (BadCustomers) criteria;

        CriteriaResult criteriaResult = new CriteriaResult();
        criteriaResult.setCriteria(criteriaBadCustomers);

        String sql = "with ct1 as (\n" +
                "    select c.firstname, c.lastname, count(*) as purchases_count\n" +
                "    from purchases\n" +
                "        inner join customers c on c.id = purchases.customer_id\n" +
                "    group by c.lastname, c.firstname\n" +
                "),\n" +
                "    ct2 as(\n" +
                "        select min(ct1.purchases_count) as min_count from ct1\n" +
                "    ),\n" +
                "    ct3 as(\n" +
                "        select ct1.firstname, ct1.lastname from ct1\n" +
                "        where ct1.purchases_count = (select * from ct2)\n" +
                "    )\n" +
                "select * from ct3 limit " + criteriaBadCustomers.getBadCustomers();

        List<Customer> foundCustomers = findCustomersBySql(sql);
        criteriaResult.setResultsCustomers(foundCustomers);

        return criteriaResult;
    }
}
