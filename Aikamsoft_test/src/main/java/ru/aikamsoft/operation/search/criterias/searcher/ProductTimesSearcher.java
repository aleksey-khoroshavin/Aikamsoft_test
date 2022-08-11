package ru.aikamsoft.operation.search.criterias.searcher;

import ru.aikamsoft.entity.Customer;
import ru.aikamsoft.operation.search.criterias.Criteria;
import ru.aikamsoft.operation.search.criterias.ProductTimes;
import ru.aikamsoft.result.subresult.CriteriaResult;

import java.sql.SQLException;
import java.util.List;

public class ProductTimesSearcher extends CriteriaSearcher{

    @Override
    public CriteriaResult searchByCriteria(Criteria criteria) throws SQLException {
        ProductTimes productTimesCriteria = (ProductTimes) criteria;

        CriteriaResult criteriaResult = new CriteriaResult();
        criteriaResult.setCriteria(productTimesCriteria);

        String sql = "with ct1 as(\n" +
                "    select purchases.customer_id from purchases inner join products on products.id = product_id\n" +
                "             where products.name = '" + productTimesCriteria.getProductName() + "'\n" +
                "),\n" +
                "ct2 as(\n" +
                "    select ct1.customer_id as customer_id, count(*) as purchase_count from ct1\n" +
                "            group by ct1.customer_id\n" +
                "),\n" +
                "ct3 as(\n" +
                "    select customers.firstname, customers.lastname\n" +
                "    from ct2 inner join customers on ct2.customer_id = customers.id\n" +
                "    where ct2.purchase_count >= "+ productTimesCriteria.getMinTimes() +"\n" +
                ")\n" +
                "select * from ct3;";

        List<Customer> foundCustomers = findCustomersBySql(sql);
        criteriaResult.setResultsCustomers(foundCustomers);

        return criteriaResult;
    }
}
