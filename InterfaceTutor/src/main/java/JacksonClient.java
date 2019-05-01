import POJO.DummyPojo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by epshtein.
 * Date: 2019-05-01
 */
public class JacksonClient implements JsonInterface {
    DummyPojo dummyPojo;
    @Override
    public DummyPojo getJson(String str) {
        ObjectMapper mapper = new ObjectMapper();
        // JSON file to Java object
        try {
            dummyPojo = mapper.readValue(str, DummyPojo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dummyPojo;
    }

    @Override
    public String getPropertyAsString(String key) {
        String method;
        switch (key){
            case "name":
                method = "getName";
                break;
            case "family":
                method = "getFamily";
                break;

                default:
                    method = "";
        }

        try {
            Class noparams[] = {};

            return (String) DummyPojo.class.getDeclaredMethod(method, noparams).invoke(dummyPojo , null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
