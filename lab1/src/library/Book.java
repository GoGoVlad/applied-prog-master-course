package library;

import sample.parsing.Parse;
import sample.Printable;

public class Book implements Printable {

    private int id;
    private String name;
    private String author;
    private int year;

    public Book(String name, String author, int year){
        this.name = name;
        this.author = author;
        this.year = year;
    }
    @Override
    public String print() throws Exception {


        String s = "";
        Parse parse = new Parse();
        for (int i = 0; i < parse.readTXT().size(); i++) {
            s = s + parse.readTXT().get(i);
        }
        return s;
        //System.out.printf("Книга '%s' (автор %s) была издана в %d году \n", name, author, year);
    }

    @Override
    public void write() throws Exception {

    }

}
