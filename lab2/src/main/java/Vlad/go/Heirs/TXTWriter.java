package Vlad.go.Heirs;

import Vlad.go.AbstractWriter;
import Vlad.go.SomeModels.Class1;

import java.io.*;

public class TXTWriter extends AbstractWriter {
    public void write (Class1 context) {
        File file = new File("TestTXT.txt");

        try {
            try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
                out.println("Id: " + context.getId());
                out.println("Name: " + context.getName());
                System.out.println(System.getProperties().getProperty("user.dir") + "TestTXT.txt");
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
