package library;

import sample.parsing.Parse;
import sample.Printable;

public class Journal implements Printable {

    private int id;
    private String name;

    String getName(){
        return name;
    }

    public Journal(String name){

        this.name = name;
    }

    @Override
    public String print() throws Exception {
        String s = "";
        Parse parse = new Parse();
        for (int i = 0; i < parse.readTXT().size(); i++) {
            s = s + parse.readTXT().get(i);
        }
        return s;
        //System.out.printf("Журнал '%s'\n", name);
    }

    @Override
    public void write() throws Exception {

    }

}