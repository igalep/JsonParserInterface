import POJO.DummyPojo;
import com.google.gson.JsonElement;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;


/**
 * Created by epshtein.
 * Date: 2019-05-01
 */
public class TestFile {
    public static void main(String [] ars) throws IOException {
        String str = readFile();

        JsonInterface j = new JSONObjectClient();
        JSONObject json = (JSONObject) j.getJson(str);
        String name = j.getPropertyAsString("name");
        print(name);

        JsonInterface jakson = new JacksonClient();
        DummyPojo dummyPojo = (DummyPojo) jakson.getJson(str);
        name = jakson.getPropertyAsString("family");
        print(name);


        JsonInterface gsonClient = new GsonClient();
        JsonElement jsonElement = (JsonElement) gsonClient.getJson(str);
        name = gsonClient.getPropertyAsString("name");
        print(name);
    }

    private static void print(String name) {
        System.out.println("---" + name);
    }

    private static String readFile() throws IOException {
        InputStream resourceAsStream = TestFile.class.getClassLoader().getResourceAsStream("Data.json");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(resourceAsStream, StandardCharsets.UTF_8))) {
            return br.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
