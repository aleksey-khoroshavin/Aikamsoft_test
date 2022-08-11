package ru.aikamsoft.operation.search.criterias.searcher;

import ru.aikamsoft.operation.search.criterias.Criteria;
import ru.aikamsoft.result.subresult.CriteriaResult;

import java.sql.SQLException;

public interface CriteriaSearcher {
    CriteriaResult searchByCriteria(Criteria criteria) throws SQLException;
}
