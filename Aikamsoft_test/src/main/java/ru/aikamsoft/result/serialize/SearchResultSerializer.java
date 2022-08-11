package ru.aikamsoft.result.serialize;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import ru.aikamsoft.result.SearchResult;

import java.lang.reflect.Type;

public class SearchResultSerializer implements JsonSerializer<SearchResult> {
    @Override
    public JsonElement serialize(SearchResult searchResult, Type type, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        json.add("type", context.serialize(searchResult.getType()));
        json.add("results", context.serialize(searchResult.getCriteriaResultList()));
        return json;
    }
}
