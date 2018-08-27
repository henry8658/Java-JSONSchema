import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import com.google.gson.JsonParser;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.HashMap;

/** This class stands alone to create JSONSchema
 *  Following examples are showing how to construct this class.
 *
 *  JSONSchemaUtil JsonSchema = new JSONSchemaUtil();
 *
 *  or you can use a builder to construct
 *
 *  JSONSchemaUtil JsonSchema = new JSONSchemaBuilder().create();
 *
 */

public final class JSONSchemaUtil {

    private JsonObject JsonSchema;
    private HashMap<String, String> listOfField;


     public JSONSchemaUtil() {
         JsonSchema = new JsonObject();
         listOfField = new LinkedHashMap<>();
     }

     //Building finalize JSONSchema and return JSONSchema Object
     public JsonObject build() throws Exception {
         StringWriter sw = new StringWriter();
         JsonWriter writer = new JsonWriter(sw);
         String typeName;
         writer.beginObject();
         writer.name("properties").beginObject();
         for (String e : listOfField.keySet()) {
            writer.name(e).beginObject();
            typeName = listOfField.get(e);
            if (typeName != null) {
               writer.name("type").value(typeName);
            }
            writer.endObject();
         }
         writer.endObject();
         writer.endObject();
         JsonSchema = new JsonParser().parse(sw.toString()).getAsJsonObject();
         writer.close();
         sw.close();
        return JsonSchema;
     }

     //Convert POJO to JsonSchema
     public void toJsonSchema(Object o) {
        Field[] objectFields = o.getClass().getDeclaredFields();
        for (Field element : objectFields) {
            listOfField.put(element.getName(), element.getType().getSimpleName());
        }
     }


}
