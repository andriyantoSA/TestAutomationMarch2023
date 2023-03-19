package qaautomation.maret2023.schemalist;

public class SchemaNegative {
	public String schemaNegative() {
		String s = "{\r\n"
				+ "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\r\n"
				+ "  \"type\": \"object\",\r\n"
				+ "  \"properties\": {\r\n"
				+ "    \"message\": {\r\n"
				+ "      \"type\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  },\r\n"
				+ "  \"required\": [\r\n"
				+ "    \"message\"\r\n"
				+ "  ]\r\n"
				+ "}";
		return s;
	}
	
	public String schemaNegative2() {
		String s = "{\r\n"
				+ "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\r\n"
				+ "  \"type\": \"object\",\r\n"
				+ "  \"properties\": {\r\n"
				+ "    \"status\": {\r\n"
				+ "      \"type\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  },\r\n"
				+ "  \"required\": [\r\n"
				+ "    \"status\"\r\n"
				+ "  ]\r\n"
				+ "}";
		return s;
	}
}
