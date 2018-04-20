

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class tr16_13 extends Application{
    TextArea taNote = new TextArea("");
    public void start (Stage prstage){
        HBox box =new HBox(10);
        box.getChildren().add(new Text("Loan Amount "));
        TextField tf=new TextField();
        tf.setMaxSize(70, 15);
        box.getChildren().add(tf);

        box.getChildren().add(new Text("Number of Years "));
        TextField tf1=new TextField();
        tf1.setMaxSize(40, 15);
        box.getChildren().add(tf1);

        Button bt=new Button("Show Table");
        box.getChildren().add(bt);
        bt.setOnMousePressed(e ->{
            int loan=Integer.parseInt(tf.getText());
            int year=Integer.parseInt(tf1.getText());
            taNote.appendText("Interest Rate    Monthly Payment    Total Payment \n");
            for (double i = 5.0; i <= 8; i += 0.125) {
                taNote.appendText(String.format("%-5.3f", i));
                taNote.appendText("%              ");
                double monthlyInterestRate = i / 1200;
                double monthlyPayment = loan * monthlyInterestRate / (1
                    - 1 / Math.pow(1 + monthlyInterestRate, year * 12));
                taNote.appendText(String.format("%-19.2f        ", monthlyPayment));
                taNote.appendText(String.format("%-8.2f\n",(monthlyPayment * 12) * year));
            }
        });

        VBox box1=new VBox(5);
        box1.getChildren().add(box);

        taNote = new TextArea("");
        taNote.setPrefColumnCount(1);
        taNote.setPrefRowCount(5);
        taNote.setWrapText(true);
        taNote.setStyle("-fx-text-fill: black");
        taNote.setFont(Font.font("Times",13));

        box1.getChildren().add(taNote);

        Scene scene=new Scene(box1,400,150);
        prstage.setTitle("Exercise16_13");
        prstage.setScene(scene);
        prstage.show();

        
    }
}