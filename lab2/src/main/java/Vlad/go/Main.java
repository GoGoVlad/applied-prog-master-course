package Vlad.go;

import Vlad.go.Heirs.ExcelWriter;
import Vlad.go.Heirs.JsWriter;
import Vlad.go.Heirs.TXTWriter;
import Vlad.go.SomeModels.Class1;

public class Main {
    public static void main(String[] args) {
        Class1 c1 = new Class1();
        c1.setId(5);
        c1.setName("test");
        AbstractWriter aw;
        aw = getWriter("excel");
        aw.write(c1);
        aw = getWriter("json");
        aw.write(c1);
        aw = getWriter("txt");
        aw.write(c1);
    }
    private static AbstractWriter getWriter(String fType) {
        AbstractWriter writer = null;
        switch (fType) {
            case "excel":
                writer = new ExcelWriter();
                break;
            case "json":
                writer = new JsWriter();
                break;
            case "txt":
                writer = new TXTWriter();
                break;
        }
        return writer;
    }
}
