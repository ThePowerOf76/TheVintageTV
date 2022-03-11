package tv;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.application.*;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.*;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.media.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;

import javafx.util.Duration;
public class TV extends Application{
MediaPlayer player;
Scene mainScene;
boolean oneTime = false;
static BufferedReader readRemote;
Socket remoteTV;
boolean isOn = false, isMuted = false;

 
	public static void main(String[] args) {
		Application.launch(args);
		
		
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		ArrayList<Media> channelList = new ArrayList<Media>();
		channelList.add(new Media(getClass().getResource("videoplayback(1).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(2).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(3).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(4).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(5).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(6).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(7).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(8).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(9).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(10).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(11).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(12).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(13).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(14).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(15).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(16).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(17).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(18).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(19).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(20).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(21).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(22).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(23).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(24).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(25).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(26).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(27).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(28).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(29).mp4").toExternalForm()));
		channelList.add(new Media(getClass().getResource("videoplayback(30).mp4").toExternalForm()));
		Stage window = new Stage();
		window.setTitle("TheVintageTV television simulator");
		Text off_info = new Text("Searching for remote...");
		off_info.setLayoutX(275);
		off_info.setLayoutY(250);
		off_info.setFill(Color.WHITE);
		off_info.setScaleX(2.5);
		off_info.setScaleY(2.5);
		Pane search_pane = new Pane();
		search_pane.getChildren().add(off_info);
		search_pane.setStyle("-fx-background-color: black;");
		Scene search_scene = new Scene(search_pane, 700, 500);
		window.setScene(search_scene);
		window.show();
		
		window.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent arg0) {
				Platform.exit();
				System.exit(-1);
				
			}
		});
		Media introJingle = new Media(getClass().getResource("introTV.mp3").toExternalForm());
		player = new MediaPlayer(introJingle);
		ImageView logo = new ImageView(new Image(getClass().getResourceAsStream("logo.png")));
		logo.setScaleX(0.15);
		logo.setScaleY(0.15);
		logo.setLayoutX(30);
		logo.setLayoutY(-60);
		FadeTransition logoTrans = new FadeTransition(Duration.seconds(3), logo);
		logoTrans.setFromValue(0);
		logoTrans.setToValue(1);
		Text name = new Text("TheVintageTV");
		name.setFill(Color.WHITE);
		name.setLayoutX(300);
		name.setLayoutY(300);
		name.setScaleX(1.5);
		name.setScaleY(1.5);
		FadeTransition nameTrans = new FadeTransition(Duration.seconds(3), name); 
		nameTrans.setFromValue(0);
		nameTrans.setToValue(1);
		String captions[] = {
			"Quality time, for a reasonable price of $49.99 a month.",	
			"Not a console app.",
			"Now with extra chaos.",
			"Maybe someday better than nTube.",
			"I like Garfield",
			"torutre_dance.mp4",
			"Now with more JoJokes.",
			"why.mp4",
			"Turn it off while you can.",
			"Door stuck. Door Stuck.",
			"Money printer goes BRRRRRRRRRR",
			"177013",
			"Here is Johnny!",
			"Not an NSA Spyware.",
			"MissingCaptionException in line 95.",
			"[Insert Generic Caption Here]",
			"Alexa play Despacito",
			"We love you as much as our legal advisors say we can.",
			"Until Dawn Version 4 when?",
			"Made in the deepest bowels of hell.",
			"Virus free! I think..."
			
		};
		Text caption = new Text(captions[(int)(Math.random()*20)]);
		caption.setFill(Color.WHITE);
		caption.setLayoutX(270);
		caption.setLayoutY(320);
		caption.setScaleX(1.5);
		caption.setScaleY(1.5);
		FadeTransition captionTrans = new FadeTransition(Duration.seconds(3), caption);
		captionTrans.setFromValue(0);
		captionTrans.setToValue(1);
		SequentialTransition introTrans = new SequentialTransition();
		introTrans.getChildren().add(logoTrans);
		introTrans.getChildren().add(nameTrans);
		introTrans.getChildren().add(captionTrans);
		Pane introPane = new Pane();
		introPane.setStyle("-fx-background-color: black;");
		introPane.getChildren().add(logo);
		introPane.getChildren().add(name);
		introPane.getChildren().add(caption);
		Scene introScene = new Scene(introPane, 700, 500);
		Pane mainPane = new Pane();
		MediaView screen = new MediaView();
		screen.setMediaPlayer(player);
		Rectangle listRect = new Rectangle(700, 500);
		listRect.setOpacity(0.7);
		listRect.setStyle("-fx-background-color: black;");
		listRect.setLayoutX(0);
		listRect.setLayoutY(0);
		listRect.setVisible(false);
		ProgressBar volumeBar = new ProgressBar();
		volumeBar.setProgress(TVLogic.getVolume()/100);
		volumeBar.setStyle("-fx-background-color: black; -fx-indeterminate-bar-length: 500px;");
		volumeBar.setLayoutX(100);
		volumeBar.setLayoutY(350);
		volumeBar.setVisible(false);
		Text channel = new Text("0");
		channel.setScaleX(5);
		channel.setScaleY(5);
		channel.setVisible(false);
		channel.setLayoutX(50);
		channel.setLayoutY(50);
		channel.setFill(Color.WHITE);
		
		mainPane.getChildren().add(volumeBar);
		mainPane.getChildren().add(screen);
		mainPane.getChildren().add(channel);
		mainPane.setStyle("-fx-background-color: black;");
		mainScene = new Scene(mainPane, 640, 350);
		Thread remoteReadThread = new Thread(new Runnable() {

			@Override
			public void run() {
				String remoteInput;
				while(true) {
					
						try {
							if(readRemote.ready()) {
								
							if((remoteInput = readRemote.readLine()) != null) {
							if(remoteInput.equals("o")) {
								if(!isOn) {
									isOn = true;
									oneTime = true;
								Platform.runLater(new Runnable() {

									@Override
									public void run() {
										window.setScene(introScene);
										introTrans.play();
										
										player.play();
										
										
									}
									
								});
								} else {
									Platform.runLater(new Runnable() {

										@Override
										public void run() {
											player.stop();
											window.setScene(search_scene);
											isOn = false;
										}
										
									});
								}
							} else if(isOn) {
								if(remoteInput.equals("m")) {
							
								if(player.isMute()) {
									player.setMute(false);
								} else {
									player.setMute(true);
								}
								
							} else if(remoteInput.equals("u")) {
								player.stop();
								TVLogic.increaseChannel();
								player = null;
								player = new MediaPlayer(channelList.get(TVLogic.getChannel() - 1));
								screen.setMediaPlayer(player);
								
								player.play();
							} else if(remoteInput.equals("d")) {
								player.stop();
								TVLogic.decreaseChannel();
								player = null;
								player = new MediaPlayer(channelList.get(TVLogic.getChannel() - 1));
								screen.setMediaPlayer(player);
								
								player.play();
							} else if(remoteInput.equals("l")) {
								//placeholder
								player.stop();
								TVLogic.increaseChannel();
								player = null;
								player = new MediaPlayer(channelList.get(TVLogic.getChannel() - 1));
								screen.setMediaPlayer(player);
								
								player.play();
							} else if(remoteInput.equals("r")) {
								//placeholder
								player.stop();
								TVLogic.decreaseChannel();
								player = null;
								player = new MediaPlayer(channelList.get(TVLogic.getChannel() - 1));
								screen.setMediaPlayer(player);
								
								player.play();
							} else if(remoteInput.equals("0")) {
								channel.setVisible(true);
								channel.setText(channel.getText() + "0");
							} else if(remoteInput.equals("1")) {
								channel.setVisible(true);
								channel.setText(channel.getText() + "1");
							} else if(remoteInput.equals("2")) {
								channel.setVisible(true);
								channel.setText(channel.getText() + "2");
							} else if(remoteInput.equals("3")) {
								channel.setVisible(true);
								channel.setText(channel.getText() + "3");
							} else if(remoteInput.equals("4")) {
								channel.setVisible(true);
								channel.setText(channel.getText() + "4");
							} else if(remoteInput.equals("5")) {
								channel.setVisible(true);
								channel.setText(channel.getText() + "5");
							} else if(remoteInput.equals("6")) {
								channel.setVisible(true);
								channel.setText(channel.getText() + "6");
							} else if(remoteInput.equals("7")) {
								channel.setVisible(true);
								channel.setText(channel.getText() + "7");
							} else if(remoteInput.equals("8")) {
								channel.setVisible(true);
								channel.setText(channel.getText() + "8");
							} else if(remoteInput.equals("9")) {
								channel.setVisible(true);
								channel.setText(channel.getText() + "9");
							} else if(remoteInput.equals("k")) {
								player.stop();
								TVLogic.selectChannel(Integer.parseInt(channel.getText()));
								player = null;
								player = new MediaPlayer(channelList.get(TVLogic.getChannel() - 1));
								screen.setMediaPlayer(player);
								
								player.play();
								channel.setText("0");
								channel.setVisible(false);
							} else if(remoteInput.equals("z")) {
								player.setVolume(player.getVolume()-0.1);
								
							} else if(remoteInput.equals("x")) {
								player.setVolume(player.getVolume()+0.1);
								
							}
							}
							}
								
 
}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
				
//								
//							});
							
						
				}
				
			}
			
		});
		
		Thread accept_stuff = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					ServerSocket tv_socket = new ServerSocket(5789);
					remoteTV = tv_socket.accept();
					readRemote = new BufferedReader(new InputStreamReader(remoteTV.getInputStream()));
					if(remoteTV.isConnected()) {
						off_info.setText("Remote Found. Press On/Off Button to start.");
						remoteReadThread.start();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		accept_stuff.start();	
		player.setOnEndOfMedia(new Runnable() {

			@Override
			public void run() {
				if(!oneTime) {
				player.seek(Duration.ZERO);
				player.play();
				} else {
					window.setScene(mainScene);
					oneTime = false;
					player = null;
					player = new MediaPlayer(channelList.get(TVLogic.getChannel() - 1));
					screen.setMediaPlayer(player);
					player.play();
					
				}
				
			}
			
		});
	
	
	}

}
