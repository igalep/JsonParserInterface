import org.json.JSONObject;

/**
 * Created by epshtein.
 * Date: 2019-04-30
 */
public class JSONObjectClient implements JsonInterface {
    JSONObject jsonObject;
    public JSONObject getJson(String strJ) {
        jsonObject = new JSONObject(strJ);

        return jsonObject;
    }

    @Override
    public String getPropertyAsString(String key) {
        jsonObject.getString(key);
        return jsonObject.getString(key);
    }
}
