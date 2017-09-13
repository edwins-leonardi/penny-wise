package com.cwbyte.it.setup;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class JsonReader {

	public static JsonObject readAsJsonObject(final String json) {
		return readJsonAs(json, JsonObject.class);
	}

	public static JsonArray readAsJsonArray(final String json) {
		return readJsonAs(json, JsonArray.class);
	}

	public static <T> T readJsonAs(final String json, final Class<T> jsonClass) {
		try {
			return new Gson().fromJson(json, jsonClass);
		} catch (final JsonSyntaxException e) {

		}
		return null;
	}

	public static Long getLongOrNull(final JsonObject jsonObject, final String propertyName) {
		final JsonElement property = jsonObject.get(propertyName);
		if (isJsonElementNull(property)) {
			return null;
		}
		return property.getAsLong();
	}

	public static Integer getIntegerOrNull(final JsonObject jsonObject, final String propertyName) {
		final JsonElement property = jsonObject.get(propertyName);
		if (isJsonElementNull(property)) {
			return null;
		}
		return property.getAsInt();
	}

	public static String getStringOrNull(final JsonObject jsonObject, final String propertyName) {
		final JsonElement property = jsonObject.get(propertyName);
		if (isJsonElementNull(property)) {
			return null;
		}
		return property.getAsString();
	}

	public static Double getDoubeOrNull(final JsonObject jsonObject, final String propertyName) {
		final JsonElement property = jsonObject.get(propertyName);
		if (isJsonElementNull(property)) {
			return null;
		}
		return property.getAsDouble();
	}

	private static boolean isJsonElementNull(final JsonElement element) {
		return element == null || element.isJsonNull();
	}

}
