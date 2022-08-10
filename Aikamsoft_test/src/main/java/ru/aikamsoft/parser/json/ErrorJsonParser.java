package ru.aikamsoft.parser.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.aikamsoft.result.ErrorResult;
import ru.aikamsoft.result.Result;
import ru.aikamsoft.result.serialize.ErrorResultSerializer;

import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorJsonParser {

    private ErrorJsonParser(){}

    private static final Logger logger = Logger.getLogger(ErrorJsonParser.class.getName());

    public static void saveErrorResult(Result result, String fileName){

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ErrorResult.class, new ErrorResultSerializer())
                .setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter(fileName)){
            gson.toJson(result, writer);
        } catch (Exception exception){
            logger.log(Level.SEVERE, exception.getMessage());
        }
    }
}
