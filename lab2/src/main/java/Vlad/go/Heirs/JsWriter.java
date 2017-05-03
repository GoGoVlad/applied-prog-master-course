package Vlad.go.Heirs;

import Vlad.go.AbstractWriter;
import Vlad.go.SomeModels.Class1;

import javax.json.Json;
import javax.json.JsonWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class JsWriter extends AbstractWriter {
    public void write (Class1 context) {
        try (FileOutputStream outputStream = new FileOutputStream( "TestJSON.json")) {
            JsonWriter jsonWriter = Json.createWriter(outputStream);
            jsonWriter.writeObject(Json.createObjectBuilder()
                    .add("Id", context.getId())
                    .add("Name", context.getName())
                    .build());
            jsonWriter.close();
            System.out.println(System.getProperties().getProperty("user.dir") + "TestJSON.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
