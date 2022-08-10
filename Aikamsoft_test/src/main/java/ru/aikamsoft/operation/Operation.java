package ru.aikamsoft.operation;

import com.google.gson.Gson;
import ru.aikamsoft.result.Result;

public interface Operation {

    void initOperationArguments(Operation operation, Gson gson);

    Result performOperation();

}
