package setup;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class JavaCode {
    public static void main(String[] args) throws IOException, URISyntaxException {

        String fileName="config.properties";

new JavaCode().demo();


    }
    public void demo() throws IOException, URISyntaxException {
        Properties props = new Properties();
        InputStream stream = getClass().getClassLoader().getResourceAsStream("config.properties");
        props.load(stream);
        System.out.println(props.get("androidAppLocation"));
        System.out.println("get property - "+props.getProperty("androidAppLocation"));
        System.out.println(getClass());
        System.out.println(this.getClass());
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(props.getProperty("androidAppLocation"));
        System.out.println("resource :: "+resource);
        System.out.println("resource :: "+resource.getFile());
    }
}
