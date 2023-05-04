package mouseevents;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * Created: 04.05.2023 at 11:52
 *
 * @author Plasek Sebastian
 */
public class Chess extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scanner sc = new Scanner(System.in);
        int num;
        while (true) {
            try {
                System.out.print("Input number: ");
                num = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Try again! \n");
            }
        }

        GridPane gp = new GridPane();
        boolean nextGrey;
        int prefSize = 800;
        gp.setPrefSize(prefSize, prefSize);

        for (int x = 0; x < num; x++) {
            for (int y = 0; y < num; y++) {
                Rectangle r = new Rectangle((double) prefSize / num, (double) prefSize / num);
                nextGrey = y % 2 == 1;
                if (x % 2 == 1) nextGrey = !nextGrey;

                if (nextGrey) {
                    r.setFill(Color.BLACK);
                    r.setUserData(Color.BLACK);
                } else {
                    r.setFill(Color.WHITE);
                    r.setUserData(Color.WHITE);
                }

                r.strokeProperty().bind(r.fillProperty());
                r.setOnMouseClicked(this::animation);
                gp.add(r, x, y);
            }
        }

        primaryStage.setScene(new Scene(gp));
        primaryStage.setResizable(false);
        primaryStage.setTitle("Chess");
        primaryStage.show();
    }

    public void animation(MouseEvent event) {
        Rectangle r = (Rectangle) event.getSource();
        if (r.getFill() == Color.RED) {
            r.setFill((Paint) r.getUserData());
        } else {
            r.setFill(Color.RED);
        }
    }
}
