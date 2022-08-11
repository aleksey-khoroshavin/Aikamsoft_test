package ru.aikamsoft.parser.json.operation;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import ru.aikamsoft.exception.WrongArgumentCountException;
import ru.aikamsoft.exception.WrongArgumentException;
import ru.aikamsoft.operation.Operation;
import ru.aikamsoft.operation.stat.Stat;
import ru.aikamsoft.result.Result;

import java.io.FileReader;
import java.io.IOException;

public class StatJsonParser implements OperationJsonParser{
    @Override
    public Operation initOperation(String inputSrcName)
            throws WrongArgumentCountException, WrongArgumentException, IOException{
        Gson gson = new Gson();

        try(JsonReader reader = new JsonReader(new FileReader(inputSrcName))){
            return gson.<Stat>fromJson(reader, Stat.class);
        }

    }

    @Override
    public void saveOperationResult(Result result, String outputSrcName) {

    }

}
