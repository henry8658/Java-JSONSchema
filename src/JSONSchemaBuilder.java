import com.google.gson.GsonBuilder;

//This class configures JSONSchemaUtil before its used.

public final class JSONSchemaBuilder {

    private GsonBuilder builder;

    public JSONSchemaBuilder() {
        builder = new GsonBuilder();
    }

    public void setPrettyPrinting() {
        builder.setPrettyPrinting();
    }

    public JSONSchemaUtil create() {

        return new JSONSchemaUtil();
    }
}
