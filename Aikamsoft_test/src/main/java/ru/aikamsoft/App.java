package ru.aikamsoft;

import ru.aikamsoft.connection.DatabaseConnection;
import ru.aikamsoft.parser.cli.ArgumentParser;
import ru.aikamsoft.parser.json.ErrorJsonParser;
import ru.aikamsoft.result.ErrorResult;

public class App
{
    public static void main( String[] args ) {

        try {
            ArgumentParser argumentParser = new ArgumentParser();
            argumentParser.parseCliArguments(args);

            DatabaseConnection.getInstance().createConnection();

        }
        catch (Exception exception){
            ErrorResult errorResult = new ErrorResult();
            errorResult.setMessage(exception.getMessage());
            ErrorJsonParser.saveErrorResult(errorResult, "./src/main/resources/test_files/output.json");
        }

    }
}
