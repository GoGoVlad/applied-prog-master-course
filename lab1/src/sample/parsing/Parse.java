package sample.parsing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Parse {

    public ArrayList<String> readTXT(){
        try(BufferedReader br = new BufferedReader(new FileReader("F:\\text.txt"))) {
            //чтение построчно
            ArrayList<String> arrayList = new ArrayList<>();
            String s;
            while((s=br.readLine())!=null){
                arrayList.add(s);
            }
            return arrayList;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return null;
        }

    }
    public void writingTXT(String text){
        try(FileWriter writer = new FileWriter("F:\\text.txt", true)) {
            if (!text.equals("")){
                // запись всей строки
                writer.write("\nЖурнал " + text);
                // запись по символам
//                writer.append('\n');
//                writer.append('E');
                writer.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void writingTXT(String name, String author, int year){
        try(FileWriter writer = new FileWriter("F:\\text.txt", true)) {
            if (!name.equals("") && !author.equals("") && year != 0) {
                // запись всей строки
                String text = "\nКнига " + name + " (автор " + author + ")" + " была издана в " + year + " году";
                writer.write(text);
                // запись по символам
//            writer.append('\n');
//            writer.append('E');

                writer.flush();
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
