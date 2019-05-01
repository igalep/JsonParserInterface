import java.io.IOException;

/**
 * Created by epshtein.
 * Date: 2019-04-30
 */
public interface JsonInterface {
    Object getJson(String str);

    String getPropertyAsString(String key);
}
