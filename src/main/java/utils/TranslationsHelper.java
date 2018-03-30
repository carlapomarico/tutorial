package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class TranslationsHelper {

    public String getTranslation(String key, String language) throws IOException {
        Properties prop = new Properties();
        FileInputStream input = new FileInputStream("src/main/resources/languages/" + language + ".properties");
        prop.load(new InputStreamReader(input, Charset.forName("UTF-8")));
        input.close();
        return prop.getProperty(key);
    }

}
