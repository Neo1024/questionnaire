package edu.cuit.questionnaire.web.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 系统配置<br>
 */
public class SysConfig {

    private static Map<String, String> properties = new HashMap<>();

    public static void init() throws IOException {
        InputStream inputStream = SysConfig.class.getClassLoader()
                .getResourceAsStream("sys.properties");
        Properties p = new Properties();
        p.load(inputStream);
        for (Object key : p.keySet()) {
            SysConfig.setProperty((String) key, (String) p.get(key));
        }
    }

    public static Map<String, String> getProperties() {
        return properties;
    }

    public static void setProperties(Map<String, String> properties) {
        SysConfig.properties = properties;
    }

    public static void setProperty(String key, String value) {
        properties.put(key, value);
    }

    public static String getProperty(String key) {
        return properties.get(key);
    }
}
