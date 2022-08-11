package ru.aikamsoft.result.serialize;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.aikamsoft.result.StatResult;

import java.lang.reflect.Type;

public class StatResultSerializer implements JsonSerializer<StatResult> {

    @Override
    public JsonElement serialize(StatResult statResult, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }
}
