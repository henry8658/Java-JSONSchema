import com.google.gson.JsonObject;

import java.util.LinkedList;
import java.util.Queue;

public final class JSONSchema {
    private String JsonSchema;
    private JsonObject JsonSchemaObject;
    private Queue<JsonObject> listOFProperties;

    public JSONSchema() {
        JsonSchemaObject = new JsonObject();
        listOFProperties = new LinkedList<>();
    }

    public void addToProperties(String element) {
        JsonObject innerElement = new JsonObject();
        innerElement.addProperty(element, element);
        listOFProperties.add(innerElement);
    }


}
