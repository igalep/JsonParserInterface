import com.google.gson.Gson;
import com.google.gson.JsonElement;

/**
 * Created by epshtein.
 * Date: 2019-05-01
 */
public class GsonClient implements JsonInterface {
    JsonElement jsonElement;
    @Override
    public JsonElement getJson(String str) {
        Gson gson = new Gson();

        jsonElement = gson.fromJson(str , JsonElement.class);
        return jsonElement;
    }

    @Override
    public String getPropertyAsString(String key) {
        return jsonElement.getAsJsonObject().get(key).getAsString();
    }
}
