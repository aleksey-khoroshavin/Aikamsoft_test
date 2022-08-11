package ru.aikamsoft;

import ru.aikamsoft.connection.DatabaseConnection;
import ru.aikamsoft.operation.Operation;
import ru.aikamsoft.parser.cli.ArgumentParser;
import ru.aikamsoft.parser.json.ErrorJsonParser;
import ru.aikamsoft.parser.json.operation.OperationJsonParser;
import ru.aikamsoft.result.ErrorResult;
import ru.aikamsoft.result.Result;

import java.sql.SQLException;

public class App
{
    public static void main( String[] args ){

        try {
            ArgumentParser argumentParser = new ArgumentParser();
            argumentParser.parseCliArguments(args);
            DatabaseConnection.getInstance().createConnection();

            OperationJsonParser operationJsonParser = argumentParser.createOperationJsonParserByName();
            Operation operation = operationJsonParser.initOperation(argumentParser.getInputSrcName());
            Result result = operation.performOperation();
            operationJsonParser.saveOperationResult(result, argumentParser.getOutputSrcName());

            DatabaseConnection.getInstance().closeConnection();
        }
        catch (Exception exception){
            ErrorResult errorResult = new ErrorResult();
            StringBuilder errorMessage = new StringBuilder();

            try {
                DatabaseConnection.getInstance().closeConnection();
            }
            catch (SQLException sqlException){
                errorMessage.append(sqlException.getMessage()).append(System.lineSeparator());
            }

            errorMessage.append(exception.getMessage());
            errorResult.setMessage(errorMessage.toString());
            ErrorJsonParser.saveErrorResult(errorResult, "./src/main/resources/test_files/error_log.json");
        }
    }
}
