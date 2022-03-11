package remote;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.PrintWriter;
import java.net.*;
import javafx.scene.shape.*;
public class Remote extends Application{

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage arg0) throws Exception {
		//Connect to TV

		Socket remoteSock = new Socket("localhost", 5789);
		PrintWriter write = new PrintWriter(remoteSock.getOutputStream(), true);
		Stage window = new Stage();
		window.setTitle("TVTVRemote");
		window.setResizable(true);
		Button on_off = new Button();
		on_off.setStyle("-fx-background-radius: 5em; " +
                "-fx-min-width: 25px; " +
                "-fx-min-height: 25px; " +
                "-fx-max-width: 25px; " +
                "-fx-max-height: 25px; -fx-background-color: red;");
		on_off.setLayoutX(10);
		on_off.setLayoutY(10);
		Button mute = new Button();
		mute.setLayoutX(150);
		mute.setLayoutY(10);
		mute.setStyle("-fx-background-radius: 5em; " +
                "-fx-min-width: 25px; " +
                "-fx-min-height: 25px; " +
                "-fx-max-width: 25px; " +
                "-fx-max-height: 25px; -fx-background-color: black;");
		Button up_button = new Button();
		up_button.setStyle("-fx-background-color: -fx-mark-highlight-color, -fx-mark-color;\r\n" + 
				"    -fx-background-insets: 0 0 -1 0, 0;\r\n" + 
				"    -fx-padding: 1em;\r\n" + 
				"    -fx-shape: \"M 0 -3.5 v 7 l 4 -3.5 z\"; ");
		up_button.setLayoutX(80);
		up_button.setLayoutY(90);
		up_button.setRotate(-90);
		Button down_button = new Button();
		down_button.setStyle("-fx-background-color: -fx-mark-highlight-color, -fx-mark-color;\r\n" + 
				"    -fx-background-insets: 0 0 -1 0, 0;\r\n" + 
				"    -fx-padding: 1em;\r\n" + 
				"    -fx-shape: \"M 0 -3.5 v 7 l 4 -3.5 z\"; ");
		down_button.setLayoutX(80);
		down_button.setLayoutY(180);
		down_button.setRotate(90);
		Button right_button = new Button();
		right_button.setStyle("-fx-background-color: -fx-mark-highlight-color, -fx-mark-color;\r\n" + 
				"    -fx-background-insets: 0 0 -1 0, 0;\r\n" + 
				"    -fx-padding: 1em;\r\n" + 
				"    -fx-shape: \"M 0 -3.5 v 7 l 4 -3.5 z\"; ");
		right_button.setLayoutX(125);
		right_button.setLayoutY(135);
		Button left_button = new Button();
		left_button.setStyle("-fx-background-color: -fx-mark-highlight-color, -fx-mark-color;\r\n" + 
				"    -fx-background-insets: 0 0 -1 0, 0;\r\n" + 
				"    -fx-padding: 1em;\r\n" + 
				"    -fx-shape: \"M 0 -3.5 v 7 l 4 -3.5 z\"; ");
		left_button.setLayoutX(36);
		left_button.setLayoutY(135);
		left_button.setRotate(180);
		Button ok_button = new Button("ok");
		ok_button.setStyle("-fx-background-radius: 5em; " +
                "-fx-min-width: 40px; " +
                "-fx-min-height: 40px; " +
                "-fx-max-width: 40px; " +
                "-fx-max-height: 40px; -fx-background-color: black;");
		ok_button.setLayoutX(72);
		ok_button.setLayoutY(136);
		ok_button.setTextFill(Color.WHITE);
		
		Button volume_up = new Button();
		volume_up.setShape(new Rectangle(5, 5));
		volume_up.setText("/\\");
		volume_up.setStyle("-fx-background-color: black;");
		volume_up.setLayoutX(35);
		volume_up.setLayoutY(380);
		volume_up.setTextFill(Color.WHITE);
		Button volume_down = new Button();
		volume_down.setShape(new Rectangle(5, 5));
		volume_down.setText("\\/");
		volume_down.setTextFill(Color.WHITE);
		volume_down.setStyle("-fx-background-color: black;");
		volume_down.setLayoutX(120);
		volume_down.setLayoutY(380);
		Button keyboard_one = new Button();
		keyboard_one.setShape(new Rectangle(5, 5));
		keyboard_one.setText("1");
		keyboard_one.setTextFill(Color.WHITE);
		keyboard_one.setStyle("-fx-background-color: black;");
		keyboard_one.setLayoutX(50);
		keyboard_one.setLayoutY(240);
		Button keyboard_two = new Button();
		keyboard_two.setShape(new Rectangle(5, 5));
		keyboard_two.setText("2");
		keyboard_two.setTextFill(Color.WHITE);
		keyboard_two.setStyle("-fx-background-color: black;");
		keyboard_two.setLayoutX(keyboard_one.getLayoutX() + 30);
		keyboard_two.setLayoutY(keyboard_one.getLayoutY());
		Button keyboard_three = new Button();
		keyboard_three.setShape(new Rectangle(5, 5));
		keyboard_three.setText("3");
		keyboard_three.setTextFill(Color.WHITE);
		keyboard_three.setStyle("-fx-background-color: black;");
		keyboard_three.setLayoutX(keyboard_one.getLayoutX() + 60);
		keyboard_three.setLayoutY(keyboard_one.getLayoutY());
		Button keyboard_four = new Button();
		keyboard_four.setShape(new Rectangle(5, 5));
		keyboard_four.setText("4");
		keyboard_four.setTextFill(Color.WHITE);
		keyboard_four.setStyle("-fx-background-color: black;");
		keyboard_four.setLayoutX(keyboard_one.getLayoutX());
		keyboard_four.setLayoutY(keyboard_one.getLayoutY() + 30);
		Button keyboard_five = new Button();
		keyboard_five.setShape(new Rectangle(5, 5));
		keyboard_five.setText("5");
		keyboard_five.setTextFill(Color.WHITE);
		keyboard_five.setStyle("-fx-background-color: black;");
		keyboard_five.setLayoutX(keyboard_one.getLayoutX() + 30);
		keyboard_five.setLayoutY(keyboard_one.getLayoutY() + 30);
		Button keyboard_six = new Button();
		keyboard_six.setShape(new Rectangle(5, 5));
		keyboard_six.setText("6");
		keyboard_six.setTextFill(Color.WHITE);
		keyboard_six.setStyle("-fx-background-color: black;");
		keyboard_six.setLayoutX(keyboard_one.getLayoutX() + 60);
		keyboard_six.setLayoutY(keyboard_one.getLayoutY() + 30);
		Button keyboard_seven = new Button();
		keyboard_seven.setShape(new Rectangle(5, 5));
		keyboard_seven.setText("7");
		keyboard_seven.setTextFill(Color.WHITE);
		keyboard_seven.setStyle("-fx-background-color: black;");
		keyboard_seven.setLayoutX(keyboard_one.getLayoutX());
		keyboard_seven.setLayoutY(keyboard_one.getLayoutY() + 60);
		Button keyboard_eight = new Button();
		keyboard_eight.setShape(new Rectangle(5, 5));
		keyboard_eight.setText("8");
		keyboard_eight.setTextFill(Color.WHITE);
		keyboard_eight.setStyle("-fx-background-color: black;");
		keyboard_eight.setLayoutX(keyboard_one.getLayoutX() + 30);
		keyboard_eight.setLayoutY(keyboard_one.getLayoutY() + 60);
		Button keyboard_nine = new Button();
		keyboard_nine.setShape(new Rectangle(5, 5));
		keyboard_nine.setText("9");
		keyboard_nine.setTextFill(Color.WHITE);
		keyboard_nine.setStyle("-fx-background-color: black;");
		keyboard_nine.setLayoutX(keyboard_one.getLayoutX() + 60);
		keyboard_nine.setLayoutY(keyboard_one.getLayoutY() + 60);
		Button keyboard_zero = new Button();
		keyboard_zero.setShape(new Rectangle(5, 5));
		keyboard_zero.setText("0");
		keyboard_zero.setTextFill(Color.WHITE);
		keyboard_zero.setStyle("-fx-background-color: black;");
		keyboard_zero.setLayoutX(keyboard_one.getLayoutX() + 30);
		keyboard_zero.setLayoutY(keyboard_one.getLayoutY() + 90);
		ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("logo.png")));
		
		logo.setScaleX(0.1);
		logo.setScaleY(0.1);
		logo.setLayoutX(-230);
		logo.setLayoutY(140);
		Pane search_pane = new Pane();
		search_pane.setStyle("-fx-background-color: antiquewhite;");
		search_pane.getChildren().add(on_off);
		search_pane.getChildren().add(mute);
		search_pane.getChildren().add(up_button);
		search_pane.getChildren().add(down_button);
		search_pane.getChildren().add(right_button);
		search_pane.getChildren().add(left_button);
		search_pane.getChildren().add(ok_button);
		search_pane.getChildren().add(volume_up);
		search_pane.getChildren().add(volume_down);
		search_pane.getChildren().add(keyboard_one);
		search_pane.getChildren().add(keyboard_two);
		search_pane.getChildren().add(keyboard_three);
		search_pane.getChildren().add(keyboard_four);
		search_pane.getChildren().add(keyboard_five);
		search_pane.getChildren().add(keyboard_six);
		search_pane.getChildren().add(keyboard_seven);
		search_pane.getChildren().add(keyboard_eight);
		search_pane.getChildren().add(keyboard_nine);
		search_pane.getChildren().add(keyboard_zero);
		search_pane.getChildren().add(logo);
		
		Scene search_scene = new Scene(search_pane, 175, 500);
		
		window.setScene(search_scene);
		
		window.show();
		
		window.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent arg0) {
				Platform.exit();
				System.exit(-1);
				
			}
		});
		on_off.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('o');
			
			}
		});
		mute.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('m');	
			}
		});
		up_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('u');	
			}
		});
		down_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('d');	
			}
		});
		left_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println("l");	
			}
		});
		right_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('r');	
			}
		});
		keyboard_eight.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('8');	
			}
		});
		keyboard_five.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('5');	
			}
		});
		keyboard_four.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('4');	
			}
		});
		keyboard_nine.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('9');	
			}
		});
		keyboard_one.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('1');	
			}
		});
		keyboard_seven.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('7');	
			}
		});
		keyboard_six.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('6');	
			}
		});
		keyboard_three.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('3');	
			}
		});
		keyboard_two.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('2');	
			}
		});
		keyboard_zero.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('0');	
			}
		});
		ok_button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('k');	
			}
		});
		volume_down.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
			write.println('z');	
			}
		});
		volume_up.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
			
			write.println('x');	
			}
		});
		
	}

}
