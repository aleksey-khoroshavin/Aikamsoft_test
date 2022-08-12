package ru.aikamsoft.operation;

import ru.aikamsoft.exception.CriteriaNotFoundException;
import ru.aikamsoft.exception.WrongDateFormatException;
import ru.aikamsoft.result.Result;

import java.sql.SQLException;

public interface Operation {
    Result performOperation() throws SQLException, CriteriaNotFoundException, WrongDateFormatException;
}
