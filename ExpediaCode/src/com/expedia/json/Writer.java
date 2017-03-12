package com.expedia.json;

import java.util.List;
import javax.json.JsonObject;

public interface Writer<T> {

	public List<T> writeToObject(JsonObject obj);
}
