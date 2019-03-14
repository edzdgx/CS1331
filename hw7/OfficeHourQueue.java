import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import java.util.Optional;
import javafx.scene.text.Text;

/**
 * javafx program implementing a OFFIDEHOURQUEUE
 *
 * @author xzhou309
 * @version 1.0
 */
public class OfficeHourQueue extends Application {
    private int numQ;
    private int maxQueue;
    private Text newStudent;



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CS 1321 Office Hours Queue");
        VBox root = new VBox(20);
        HBox firstRow = new HBox();
        VBox status = new VBox();
        VBox students = new VBox();

        status.setAlignment(Pos.TOP_LEFT);
        students.setAlignment(Pos.TOP_LEFT);
        TextField alertMsg = new TextField();
        // Text student1 = new Text("Bud Peterson");
        // Text student2 = new Text("George Brudell");
        Text cur = new Text("Current Number Of Students in Queue: " + numQ);
        Text max = new Text("Max Number Of Students In Queue: " + maxQueue);

        status.getChildren().addAll(cur, max);
        // students.getChildren().addAll(student1, student2);
        // firstRow.getChildren().addAll(student1, student2, label);

        // dequeue button
        Button deq = new Button();
        deq.setText("Dequeue Student");
        deq.setOnAction((event) -> {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Privilege Check");
                dialog.setHeaderText("Confirmation");

                // Label label = new Label("Please Enter Password: ");
                Optional<String> text = dialog.showAndWait();
                String password = "none.";
                if (text.isPresent()) {
                    password = text.get();
                    if (password.equals("CS1321R0X")) {
                        numQ--;
                        // remove student at the head of the queue
                        students.getChildren().remove(0);
                    }
                }

                cur.setText("Current Number Of Students in Queue: " + numQ);
                max.setText("Max Number Of Students In Queue: " + maxQueue);
            });

        // add button
        Button add = new Button();
        add.setText("Add Student");
        add.setOnAction((event) -> {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Add Student");
                dialog.setHeaderText("Enter Student Name: ");
                Optional<String> text = dialog.showAndWait();
                String entered = "none.";
                if (text.isPresent()) {
                    entered = text.get();
                    numQ++;
                    if (numQ > maxQueue) {
                        maxQueue = numQ;
                    }
                    // push student name to the queue
                    Text student = new Text(entered);
                    students.getChildren().add(students.getChildren().size(),
                             student);
                    cur.setText("Current Number Of Students in Queue: " + numQ);
                    max.setText("Max Number Of Students In Queue: " + maxQueue);
                }
            });



        root.getChildren().addAll(status, students, add, deq);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


