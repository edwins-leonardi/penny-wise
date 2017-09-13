package com.cwbyte.it.setup;

import java.io.InputStream;
import java.util.Scanner;

import org.junit.Ignore;

import com.google.gson.JsonObject;

@Ignore
public class JsonTestUtils {
	public static final String BASE_JSON_DIR = "json/";

	private JsonTestUtils() {
	}

	public static String readJsonFile(final String relativePath) {
		final InputStream is = JsonTestUtils.class.getClassLoader().getResourceAsStream(BASE_JSON_DIR + relativePath);
		try (Scanner s = new Scanner(is)) {
			return s.useDelimiter("\\A").hasNext() ? s.next() : "";
		}
	}

	public static Long getIdFromJson(final String json) {
		final JsonObject jsonObject = JsonReader.readAsJsonObject(json);
		return JsonReader.getLongOrNull(jsonObject, "id");
	}

}
