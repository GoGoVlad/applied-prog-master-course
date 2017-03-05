package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.parsing.Parse;

import java.util.Objects;

public class Controller {

    Parse parse = new Parse();
    @FXML
    public TextField textFieldName;
    @FXML
    public TextField textFieldAuthor;
    @FXML
    public TextField textFieldYear;
    @FXML
    private Button button1;
    @FXML
    private TextArea itsText;

    @FXML
    public void onClickAddBook(ActionEvent actionEvent){
        try {
            if (Objects.equals(textFieldName.getText(), "")){
                itsText.setText("Invalid entry");
            }
            if (textFieldAuthor.getText().equals("") && textFieldYear.getText().length() == 0) {
                parse.writingTXT(textFieldName.getText());
                textFieldName.clear();
                textFieldAuthor.clear();
                textFieldYear.clear();
            }
            else if (!Objects.equals(textFieldName.getText(), "") && !Objects.equals(textFieldAuthor.getText(), "") && textFieldYear.getText().length() != 0){
                parse.writingTXT(textFieldName.getText(), textFieldAuthor.getText(), Integer.parseInt((textFieldYear.getText())));
                textFieldName.clear();
                textFieldAuthor.clear();
                textFieldYear.clear();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void onClickShowCatalog(ActionEvent actionEvent) {
        String s = null;
        /*Printable a;
        a = new Journal(parse.readTXT().get(0));
        try {
            itsText.setText(a.print());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
        for (int i = 0; i < parse.readTXT().size(); i++) {
            s = s + "\n" +  parse.readTXT().get(i);
        }
        itsText.setText(s != null ? s.substring(6) : null);
    }
}
