package ru.aikamsoft.parser.json.operation;

import com.google.gson.Gson;
import ru.aikamsoft.result.Result;

public interface OperationJsonParser {
    Gson parseOperationArguments(String jsonString);

    void saveOperationResult(Result result);
}
