import com.google.gson.*;

public final class JSONSchemaUtilTest {
    public static void main(String[] args) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Customer POJO = new Customer();
        JSONSchemaUtil factory = new JSONSchemaUtil();
        factory.toJsonSchema(POJO);
        JsonObject schemaObject = factory.build();
        String schema =  gson.toJson(schemaObject);
        System.out.print(schema);
    }
}
