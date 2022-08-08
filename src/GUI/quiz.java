package GUI;

import engine.Game;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.world.Champion;

public class quiz extends Application {

	
	public void start(Stage stage) throws Exception {
		Game.loadChampions("Champions.csv");
		int first=(int)(Math.random()*(Game.getAvailableChampions().size()));
		int second=(int)(Math.random()*(Game.getAvailableChampions().size()));
		int third=(int)(Math.random()*(Game.getAvailableChampions().size()));
		
		Champion firstchamp = Game.getAvailableChampions().get(first);
		Champion secondchamp = Game.getAvailableChampions().get(second);
		Champion thirdchamp = Game.getAvailableChampions().get(third);
		
		GridPane layout1= new GridPane();
		Scene scene= new Scene(layout1,400,300);
		stage.setScene(scene);
		Button champion1= new Button();
		champion1.setText(firstchamp.getName()+", "+firstchamp.getCurrentHP());
		champion1.setPrefSize(400, 100);
		champion1.setTranslateY(0);
		champion1.setOnAction(e->{
			if(firstchamp.getCurrentHP()!=0) {
				firstchamp.setCurrentHP(firstchamp.getCurrentHP()-500);
				champion1.setText(firstchamp.getName()+", "+firstchamp.getCurrentHP());
			}
		});
		
		Button champion2= new Button();
		champion2.setText(secondchamp.getName()+", "+secondchamp.getCurrentHP());
		champion2.setPrefSize(400, 100);
		champion2.setTranslateY(100);
		champion2.setOnAction(e->{
			if(secondchamp.getCurrentHP()!=0) {
				secondchamp.setCurrentHP(secondchamp.getCurrentHP()-500);
				champion2.setText(secondchamp.getName()+", "+secondchamp.getCurrentHP());
			}
		});
		
		Button champion3= new Button();
		champion3.setText(thirdchamp.getName()+", "+thirdchamp.getCurrentHP());
		champion3.setPrefSize(400, 100);
		champion3.setTranslateY(200);
		champion3.setOnAction(e->{
			if(thirdchamp.getCurrentHP()!=0) {
				thirdchamp.setCurrentHP(thirdchamp.getCurrentHP()-500);
				champion3.setText(thirdchamp.getName()+", "+thirdchamp.getCurrentHP());
			}
		});
		
		
		layout1.getChildren().addAll(champion1,champion2, champion3);
		stage.show();
		
	}
	public static void main(String[]args)
	{
		
		launch(args);
	}

}
