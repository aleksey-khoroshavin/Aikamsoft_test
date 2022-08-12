package ru.aikamsoft.parser.json.operation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;
import ru.aikamsoft.exception.WrongDateFormatException;
import ru.aikamsoft.operation.Operation;
import ru.aikamsoft.operation.stat.Stat;
import ru.aikamsoft.parser.util.DateValidator;
import ru.aikamsoft.result.Result;
import ru.aikamsoft.result.StatResult;
import ru.aikamsoft.result.serialize.StatResultSerializer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StatJsonParser implements OperationJsonParser{

    private static final Logger logger = Logger.getLogger(StatJsonParser.class.getName());

    @Override
    public Operation initOperation(String inputSrcName)
            throws IOException, WrongDateFormatException {
        Gson gson = new Gson();

        try(JsonReader reader = new JsonReader(new FileReader(inputSrcName))){
            Stat stat = new Stat();

            JsonObject json = gson.fromJson(reader, JsonObject.class);

            String startDate = json.get("startDate").getAsString();
            String endDate = json.get("endDate").getAsString();

            DateValidator dateValidator = new DateValidator("yyyy-MM-dd");
            dateValidator.validateDateStr(startDate);
            dateValidator.validateDateStr(endDate);
            dateValidator.checkStartDateBeforeEndDate(startDate, endDate);

            stat.setStartDate(startDate);
            stat.setEndDate(endDate);

            return stat;
        }

    }

    @Override
    public void saveOperationResult(Result result, String outputSrcName) {
        Gson gson = new GsonBuilder().
                registerTypeAdapter(StatResult.class, new StatResultSerializer())
                .setPrettyPrinting().create();

        try(FileWriter writer = new FileWriter(outputSrcName)){
            gson.toJson(result, writer);
        } catch (Exception exception){
            logger.log(Level.SEVERE, exception.getMessage());
        }
    }

}
