package testMarvel;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;

import engine.Game;
import engine.Player;
import engine.PriorityQueue;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.effects.Disarm;
import model.world.Champion;
import model.world.Condition;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;


public class Main extends Application {

	boolean ability = false;
	Ability able;
	boolean targeted;
	Ability targetAbility;
	@Override
	public void start(Stage PrimaryStage) throws IOException{
		
		PrimaryStage.setTitle("Avengers: Battle of the Pharohs");
		File Icon=new File("GUI/marvellabel.png");
		Image icon = new Image(Icon.toURI().toString());
		StackPane layout2=new StackPane();
		PrimaryStage.getIcons().add(icon);
		GridPane layout4=new GridPane();
		Scene scene2=new Scene(layout2,800,529);
		Scene scene4 = new Scene(layout4,800,529);
		GridPane layout1 = new GridPane();
		Scene scene1=new Scene(layout1,640,360);
		GridPane layout5=new GridPane();
		Scene scene5=new Scene(layout5,800,529);
		GridPane layout6=new GridPane();
		Scene scene6=new Scene(layout6,800,529);
		GridPane layout7=new GridPane();
		Scene scene7=new Scene(layout7,640,352);
		GridPane layout8=new GridPane();
		Scene scene8=new Scene(layout8,800,529);
		GridPane layout9=new GridPane();
		Scene scene9=new Scene(layout9,1280,720);
		GridPane endLayout=new GridPane();
		Scene endScene=new Scene(endLayout,800,529);
		Label p1=new Label();
		Label p2=new Label();
		Stage tmpstage=new Stage();
		tmpstage.setMaximized(true);
		PrimaryStage.setResizable(false);
		ArrayList<String>ordername=new ArrayList<String>();
		ArrayList<Champion>orderch=new ArrayList<Champion>();
				

		
		
		ArrayList<Champion> chosen= new ArrayList<Champion> ();
		
		File iam=new File("GUI/iamIronMan2.mp4");
		Media iammedia=new Media(iam.toURI().toString());
		MediaPlayer iammediaplayer=new MediaPlayer(iammedia);
		
		File CAbg1=new File("GUI/CA.png");
		Image CAbg=new Image(CAbg1.toURI().toString());
		
		ImageView CAview=new ImageView(CAbg);
		CAview.setFitHeight(100);
		CAview.setFitWidth(100);
		
		File IRbg1 =new File("GUI/Iron_Man-removebg-preview.png");
		Image IRbg =new Image(IRbg1.toURI().toString());
		
		ImageView IRview=new ImageView(IRbg);
		IRview.setFitHeight(100);
		IRview.setFitWidth(100);
		
		File IMbg1=new File("GUI/iceman symbol.png");
		Image IMbg=new Image(IMbg1.toURI().toString());
		
		ImageView IMview=new ImageView(IMbg);
		IMview.setFitWidth(100);
		IMview.setFitHeight(100);
		
		File Hulkbg1=new File("GUI/Hulk-removebg-preview.png");
		Image Hulkbg=new Image(Hulkbg1.toURI().toString());
		
		ImageView Hulkview=new ImageView(Hulkbg);
		Hulkview.setFitHeight(100);
		Hulkview.setFitWidth(100);
		
		File Helabg1=new File("GUI/Hela.png");
		Image Helabg=new Image(Helabg1.toURI().toString());
		
		ImageView Helaview=new ImageView(Helabg);
		Helaview.setFitHeight(100);
		Helaview.setFitWidth(100);
		
		File GRbg1=new File("GUI/Ghost_Rider-removebg-preview.png");
		Image GRbg=new Image(GRbg1.toURI().toString());
		
		ImageView GRview=new ImageView(GRbg);
		GRview.setFitHeight(100);
		GRview.setFitWidth(100);
		
		File Ebg1=new File("GUI/Elec-removebg-preview.png");
		Image Ebg=new Image(Ebg1.toURI().toString());
		
		ImageView Eview=new ImageView(Ebg);
		Eview.setFitHeight(100);
		Eview.setFitWidth(100);
		
		File DSbg1=new File("GUI/Doctor_s-removebg-preview.png");
		Image DSbg=new Image(DSbg1.toURI().toString());
		
		ImageView DSview=new ImageView(DSbg);
		DSview.setFitHeight(100);
		DSview.setFitWidth(100);
		
		File DPbg1=new File("GUI/DeadPool-removebg-preview.png");
		Image DPbg=new Image(DPbg1.toURI().toString());
		
		ImageView DPview=new ImageView(DPbg);
		DPview.setFitHeight(100);
		DPview.setFitWidth(100);
		
		File Lbg1=new File("GUI/Loki-removebg-preview.png");
		Image Lbg=new Image(Lbg1.toURI().toString());
		
		ImageView Lview=new ImageView(Lbg);
		Lview.setFitHeight(100);
		Lview.setFitWidth(100);
		
		File QSbg1=new File("GUI/QuickS-removebg-preview.png");
		Image QSbg=new Image(QSbg1.toURI().toString());
		
		ImageView QSview=new ImageView(QSbg);
		QSview.setFitHeight(100);
		QSview.setFitWidth(100);
		
		File zbidrbg1=new File("GUI/SpidrMan-removebg-preview.png");
		Image zbidrbg=new Image(zbidrbg1.toURI().toString());
		
		ImageView zbidrview=new ImageView(zbidrbg);
		zbidrview.setFitHeight(100);
		zbidrview.setFitWidth(100);
		
		File TObg1=new File("GUI/Thor.png");
		Image TObg=new Image(TObg1.toURI().toString());
		
		ImageView TOview=new ImageView(TObg);
		TOview.setFitHeight(100);
		TOview.setFitWidth(100);
		
		File Vbg1=new File("GUI/Venom-removebg-preview.png");
		Image Vbg=new Image(Vbg1.toURI().toString());
		
		ImageView Vview=new ImageView(Vbg);
		Vview.setFitHeight(100);
		Vview.setFitWidth(100);
		
		File YJbg1=new File("GUI/Yellow_J-removebg-preview.png");
		Image YJbg=new Image(YJbg1.toURI().toString());
		
		ImageView YJview=new ImageView(YJbg);
		YJview.setFitHeight(100);
		YJview.setFitWidth(100);
		
		File thunder1=new File("GUI/Thunder.mp4");
		Media thunder=new Media(thunder1.toURI().toString());
		
		MediaPlayer thunderPlayer=new MediaPlayer(thunder);
		MediaView thunderview=new MediaView(thunderPlayer);
		thunderview.setVisible(false);
		
		File GOW1=new File("GUI/GOW.3gp");
		Media GOW=new Media(GOW1.toURI().toString());
		
		MediaPlayer GOWPlayer=new MediaPlayer(GOW);
		MediaView GOWview=new MediaView(GOWPlayer);
		GOWview.setVisible(false);
		
		
		Label press=new Label("Press Enter to Continue");
		press.setFont(new Font("Verdana",10));
		press.setTranslateY(150);
		press.setTranslateX(270);
		press.setTextFill(Color.color(1, 1, 1));
		
		Label pressE=new Label("Press Enter to Continue");
		pressE.setFont(new Font("Verdana",10));
		pressE.setTranslateY(300);
		pressE.setTranslateX(335);
		pressE.setTextFill(Color.color(1, 1, 1));
		
		TextField tf1=new TextField();
		tf1.setTranslateX(250);
		tf1.setTranslateY(350);
		tf1.setMinWidth(10);
		tf1.setMaxWidth(100);
		
		TextField tf2=new TextField();
		tf2.setTranslateX(500);
		tf2.setTranslateY(350);
		tf2.setMinWidth(10);
		tf2.setMaxWidth(100);

		File filesound=new File("GUI/firstplay.mp4");
		
		Media firstsound=new Media(filesound.toURI().toString());
		MediaPlayer firstPlay=new MediaPlayer(firstsound);
		MediaView firstview=new MediaView(firstPlay);
		firstview.setTranslateX(800);
		firstview.setVisible(false);
		
		File boardsound=new File("GUI/introsound.mp4");
		Media boardmedia=new Media(boardsound.toURI().toString());
		MediaPlayer boardPlayer=new MediaPlayer(boardmedia);
		MediaView boardPlayerview=new MediaView(boardPlayer);
		boardPlayer.setCycleCount(11);
		boardPlayerview.setVisible(false);
		
		File file=new File("GUI/intro.mp4");
		
		Media intro = new Media(file.toURI().toString()); 
		MediaPlayer introPlayer = new MediaPlayer(intro);
		introPlayer.setAutoPlay(true);
		MediaView introView = new MediaView (introPlayer);
		
		File instructimg1=new File("GUI/InstructionsB.png");
		Image instructimg=new Image(instructimg1.toURI().toString());
		
		ImageView instructview=new ImageView(instructimg);
		instructview.setFitHeight(100);
		instructview.setFitWidth(100);
		Button instructButton=new Button();
		instructButton.setTranslateX(370);
		instructButton.setTranslateY(420);
		instructButton.setGraphic(instructview);
		instructButton.setBackground(null);
		instructButton.setOnAction(e->{
			Stage in=new Stage();
			GridPane inlayout=new GridPane();
			Scene inScene=new Scene(inlayout,800,529);
			File inimg1=new File("GUI/Instructions.jpeg");
			Image inimg = new Image(inimg1.toURI().toString());
			
			BackgroundImage inbgimg=new BackgroundImage(inimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT); 
			Background inbg=new Background(inbgimg);
			inlayout.setBackground(inbg);
			in.setScene(inScene);
			in.show();
			
		});
		
		
		File egimg1=new File("GUI/EndGamepng.png");
		Image egimg=new Image(egimg1.toURI().toString());
		
		ImageView egview=new ImageView(egimg);
		egview.setFitHeight(110);
		egview.setFitWidth(110);
		
		
		
		Button endGame=new Button();
		endGame.setTranslateX(335);
		endGame.setTranslateY(295);
		endGame.setGraphic(egview);
		endGame.setBackground(null);
		endGame.setOnAction(e->PrimaryStage.close());
		endLayout.getChildren().addAll(endGame);
		
		Button skipintro=new Button();
		skipintro.setBackground(null);
		skipintro.setPrefSize(800, 529);
		skipintro.setOnAction(e->{
			PrimaryStage.setScene(scene2);
			introPlayer.stop();
			boardPlayer.setAutoPlay(true);
			});
		layout1.getChildren().addAll(skipintro,introView,press);
		
		Button backscene3=new Button();
		backscene3.setOnAction(e->PrimaryStage.setScene(scene2));
		GridPane layout3=new GridPane();
		Scene scene3=new Scene(layout3,800,529);
		backscene3.setTranslateY(420);
		backscene3.setTranslateX(60);
		File backimage1=new File("GUI/Back.png");
		Image backimage=new Image(backimage1.toURI().toString());
		
        ImageView backview=new ImageView(backimage);
        backview.setFitHeight(100);
		backview.setFitWidth(100);
		backscene3.setGraphic(backview);
		backscene3.setBackground(null);
		
		
		
		
		Button nextscene3=new Button();
		nextscene3.setOnAction(e->
		{if(tf1.getText()!=""&&tf2.getText()!="") {
			PrimaryStage.setScene(scene4);
		}
		else
			display("Attention","GUI/errornames.jpeg");
		
		});
		nextscene3.setTranslateY(420);
		nextscene3.setTranslateX(670);
		File nextimg1=new File("GUI/next.png");
		Image nextimg=new Image(nextimg1.toURI().toString());
		
		ImageView nextview=new ImageView(nextimg);
		nextview.setFitHeight(100);
		nextview.setFitWidth(100);
		nextscene3.setGraphic(nextview);
		nextscene3.setBackground(null);
		
		
		
		Button b1=new Button();
		b1.setBackground(null);
		File b1img1 = new File("GUI/button (1).png");
		Image b1img = new Image(b1img1.toURI().toString());
		
        ImageView b1imv=new ImageView(b1img);
        
        
		b1.setGraphic(b1imv);
		b1imv.setFitHeight(150);
		b1imv.setFitWidth(150);
		b1.setTranslateY(150);
		layout2.getChildren().addAll(b1,boardPlayerview);
		
		File img1 = new File("GUI/background small.jpg");
		Image img = new Image(img1.toURI().toString());
		
		BackgroundImage bImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);
		layout2.setBackground(bGround);
		File pyramids1 = new File("GUI/enter p names.jpg");
		Image pyramids = new Image(pyramids1.toURI().toString());
		
		BackgroundImage bgpyramids = new BackgroundImage(pyramids, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
		Background bGroundpyramids = new Background(bgpyramids);
		layout3.setBackground(bGroundpyramids);
		b1.setOnAction(e->PrimaryStage.setScene(scene3));
		 
		Player first= new Player(tf1.getText());
		Player second = new Player (tf2.getText());
		Game.loadAbilities("Abilities.csv");
		Game.loadChampions("Champions.csv");
		Game gg= new Game(first,second);
		
		ArrayList<Button>coverButtons=new ArrayList<Button>();
		
		
		Button A4=new Button();
		File ability41 = new File("GUI/Ability 4.png");
		Image ability4 = new Image(ability41.toURI().toString());
		
		ImageView ab4= new ImageView(ability4);
		A4.setGraphic(ab4);
		A4.setBackground(null);
		ab4.setFitHeight(70);
		ab4.setFitWidth(80);
		A4.setTranslateX(640);
		A4.setTranslateY(190);
		ab4.setFitWidth(50);
		A4.setVisible(false);
		A4.setDisable(true);
		A4.setOnAction(e->{
			targeted=true;
			targetAbility=gg.getCurrentChampion().getAbilities().get(3);
		});
		
		
		File coverimgf1=new File("GUI/covertest.png");
		Image coverimg=new Image(coverimgf1.toURI().toString());
		
		ImageView coverview=new ImageView(coverimg);
		coverview.setFitHeight(90);
		coverview.setFitWidth(80);
		
		
		Button cover1= new Button();
		cover1.setGraphic(coverview);
		cover1.setBackground(null);
		coverButtons.add(cover1);
		
		
		File coverimgf2=new File("GUI/covertest.png");
		Image coverimg2=new Image(coverimgf2.toURI().toString());
		
		ImageView coverview2=new ImageView(coverimg2);
		coverview2.setFitHeight(90);
		coverview2.setFitWidth(80);
		
		Button cover2=new Button();
		cover2.setGraphic(coverview2);
		cover2.setBackground(null);
		coverButtons.add(cover2);
		
		File coverimgf3=new File("GUI/covertest.png");
		Image coverimg3=new Image(coverimgf3.toURI().toString());
		
		ImageView coverview3=new ImageView(coverimg3);
		coverview3.setFitHeight(90);
		coverview3.setFitWidth(80);
		
		Button cover3=new Button();
		cover3.setGraphic(coverview3);
		cover3.setBackground(null);
		coverButtons.add(cover3);
		
		File coverimgf4=new File("GUI/covertest.png");
		Image coverimg4=new Image(coverimgf4.toURI().toString());
		
		ImageView coverview4=new ImageView(coverimg4);
		coverview4.setFitHeight(90);
		coverview4.setFitWidth(80);
		
		Button cover4=new Button();
		cover4.setGraphic(coverview4);
		cover4.setBackground(null);
		coverButtons.add(cover4);
		
		File coverimgf5=new File("GUI/covertest.png");
		Image coverimg5=new Image(coverimgf5.toURI().toString());
		
		ImageView coverview5=new ImageView(coverimg5);
		coverview5.setFitHeight(90);
		coverview5.setFitWidth(80);
		
		Button cover5=new Button();
		cover5.setGraphic(coverview5);
		cover5.setBackground(null);
		coverButtons.add(cover5);
		
		
		
		ArrayList<Cover> covers= new ArrayList<Cover>();
		int counter=0;
		for(int i =0; i<5;i++) {
			for(int j=1;j<4;j++) {
				if(gg.getBoard()[j][i] instanceof Cover) {
					
					layout8.getChildren().addAll(coverButtons.get(counter));
					if(i==0)
					{
						coverButtons.get(counter).setTranslateX(20);
					}
					if(i==1)
					{
						coverButtons.get(counter).setTranslateX(150);
					}
					if(i==2)
					{
						coverButtons.get(counter).setTranslateX(270);
					}
					if(i==3)
					{
						coverButtons.get(counter).setTranslateX(390);
					}
					if(i==4)
					{
						coverButtons.get(counter).setTranslateX(510);
					}
					
					if(j==1)
					{
						coverButtons.get(counter).setTranslateY(185);
					}
					if(j==2)
					{
						coverButtons.get(counter).setTranslateY(85);
					}
					if(j==3)
					{
						coverButtons.get(counter).setTranslateY(-15);
					}
					covers.add((Cover)gg.getBoard()[j][i]);
					counter++;
			}
		}
			}
		
		coverButtons.get(0).setOnAction(e->{
			if(PrimaryStage.getScene()==scene8 && targeted) {
				 targeted=false;
				 try {
					gg.castAbility(targetAbility,(int)covers.get(0).getLocation().getX(),(int)covers.get(0).getLocation().getY());
				    if(covers.get(0).getCurrentHP()==0) {
				    	coverButtons.get(0).setDisable(true);
				    	coverButtons.get(0).setVisible(false);
				    }
				 } catch (NotEnoughResourcesException e1) {
					 display("Attention","GUI/not enough resources.jpeg");
					 
					
				} catch (AbilityUseException e1) {
					display("Attention","GUI/AbilityUseException .jpeg");
					
				} catch (InvalidTargetException e1) {
					display("Attention","GUI/InvalidAttack.jpeg");
					
				} catch (CloneNotSupportedException e1) {
					System.out.print("CloneNotSupportedException");
				}
			 }
		});
		
		coverButtons.get(0).setOnMouseEntered(e->{
       	 	GridPane tmplayout=new GridPane();
    		Scene tmpscene=new Scene(tmplayout,300,300);
    		File tmpscimg1=new File("GUI/propertiesBg 3.jpg");
			Image tmpscimg = new Image(tmpscimg1.toURI().toString());
    		
    		BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
    		Background btmpsc = new Background(tmpscbImg);
    		tmplayout.setBackground(btmpsc);
    		
			 
			 if(PrimaryStage.getScene()==scene8)
			 { 
				 tmpstage.show();
				 tmpstage.setScene(tmpscene);
				 Label l=new Label(covers.get(0).toString()); 
				 l.setTextFill(Color.color(1, 1, 1));
				 l.setFont(new Font("Verdana",30));
				 l.setTranslateX(20);
				 l.setTranslateY(120);
				 
				 tmpstage.getIcons().clear();
				 tmpstage.getIcons().add(coverimg);
				 tmplayout.getChildren().add(l);
				 tmpstage.setAlwaysOnTop(true);
			 }});
		coverButtons.get(0).setOnMouseExited(e->{
			 if(PrimaryStage.getScene()==scene8)
			 {
				 tmpstage.close();
			 }});
		
		coverButtons.get(1).setOnAction(e->{
			if(PrimaryStage.getScene()==scene8 && targeted) {
				 targeted=false;
				 try {
					gg.castAbility(targetAbility,(int)covers.get(1).getLocation().getX(),(int)covers.get(1).getLocation().getY());
				    if(covers.get(1).getCurrentHP()==0) {
				    	coverButtons.get(1).setDisable(true);
				    	coverButtons.get(1).setVisible(false);
				    }
				 } catch (NotEnoughResourcesException e1) {
					 display("Attention","GUI/not enough resources.jpeg");
					 
					
				} catch (AbilityUseException e1) {
					display("Attention","GUI/AbilityUseException .jpeg");
					
				} catch (InvalidTargetException e1) {
					display("Attention","GUI/InvalidAttack.jpeg");
					
				} catch (CloneNotSupportedException e1) {
					System.out.print("CloneNotSupportedException");
				}
			 }
		});
		
		coverButtons.get(1).setOnMouseEntered(e->{
       	 	GridPane tmplayout=new GridPane();
    		Scene tmpscene=new Scene(tmplayout,300,300);
    		File tmpscimg1=new File("GUI/propertiesBg 3.jpg");
			Image tmpscimg = new Image(tmpscimg1.toURI().toString());
    		
    		BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
    		Background btmpsc = new Background(tmpscbImg);
    		tmplayout.setBackground(btmpsc);
    		
			 
			 if(PrimaryStage.getScene()==scene8)
			 { 
				 tmpstage.show();
				 tmpstage.setScene(tmpscene);
				 Label l=new Label(covers.get(1).toString()); 
				 tmpstage.getIcons().clear();
				 tmpstage.getIcons().add(coverimg);
				 l.setTextFill(Color.color(1, 1, 1));
				 l.setFont(new Font("Verdana",30));
				 l.setTranslateX(20);
				 l.setTranslateY(120);
				 tmplayout.getChildren().add(l);
				 tmpstage.setAlwaysOnTop(true);
			 }});
		coverButtons.get(1).setOnMouseExited(e->{
			 if(PrimaryStage.getScene()==scene8)
			 {
				 tmpstage.close();
			 }});
		
		coverButtons.get(2).setOnAction(e->{
			if(PrimaryStage.getScene()==scene8 && targeted) {
				 targeted=false;
				 try {
					gg.castAbility(targetAbility,(int)covers.get(2).getLocation().getX(),(int)covers.get(2).getLocation().getY());
				    if(covers.get(2).getCurrentHP()==0) {
				    	coverButtons.get(2).setDisable(true);
				    	coverButtons.get(2).setVisible(false);
				    }
				 } catch (NotEnoughResourcesException e1) {
					 display("Attention","GUI/not enough resources.jpeg");
					 
					
				} catch (AbilityUseException e1) {
					display("Attention","GUI/AbilityUseException .jpeg");
					
				} catch (InvalidTargetException e1) {
					display("Attention","GUI/InvalidAttack.jpeg");
					
				} catch (CloneNotSupportedException e1) {
					System.out.print("CloneNotSupportedException");
				}
			 }
		});
		
		coverButtons.get(2).setOnMouseEntered(e->{
       	 	GridPane tmplayout=new GridPane();
    		Scene tmpscene=new Scene(tmplayout,300,300);
    		File tmpscimg1=new File("GUI/propertiesBg 3.jpg");
			Image tmpscimg = new Image(tmpscimg1.toURI().toString());
    		
    		BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
    		Background btmpsc = new Background(tmpscbImg);
    		tmplayout.setBackground(btmpsc);
    		
			 
			 if(PrimaryStage.getScene()==scene8)
			 { 
				 tmpstage.show();
				 tmpstage.setScene(tmpscene);
				 Label l=new Label(covers.get(2).toString()); 
				 tmpstage.getIcons().clear();
				 tmpstage.getIcons().add(coverimg);
				 l.setTextFill(Color.color(1, 1, 1));
				 l.setFont(new Font("Verdana",30));
				 l.setTranslateX(20);
				 l.setTranslateY(120);
				 tmplayout.getChildren().add(l);
				 tmpstage.setAlwaysOnTop(true);
			 }});
		coverButtons.get(2).setOnMouseExited(e->{
			 if(PrimaryStage.getScene()==scene8)
			 {
				 tmpstage.close();
			 }});
		
		coverButtons.get(3).setOnAction(e->{
			if(PrimaryStage.getScene()==scene8 && targeted) {
				 targeted=false;
				 try {
					gg.castAbility(targetAbility,(int)covers.get(3).getLocation().getX(),(int)covers.get(3).getLocation().getY());
				    if(covers.get(3).getCurrentHP()==0) {
				    	coverButtons.get(3).setDisable(true);
				    	coverButtons.get(3).setVisible(false);
				    }
				 } catch (NotEnoughResourcesException e1) {
					 display("Attention","GUI/not enough resources.jpeg");
					 
					
				} catch (AbilityUseException e1) {
					display("Attention","GUI/AbilityUseException .jpeg");
					
				} catch (InvalidTargetException e1) {
					display("Attention","GUI/InvalidAttack.jpeg");
					
				} catch (CloneNotSupportedException e1) {
					System.out.print("CloneNotSupportedException");
				}
			 }
		});
		
		coverButtons.get(3).setOnMouseEntered(e->{
       	 	GridPane tmplayout=new GridPane();
    		Scene tmpscene=new Scene(tmplayout,300,300);
    		File tmpscimg1=new File("GUI/propertiesBg 3.jpg");
			Image tmpscimg = new Image(tmpscimg1.toURI().toString());
    		
    		BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
    		Background btmpsc = new Background(tmpscbImg);
    		tmplayout.setBackground(btmpsc);
    		
			 
			 if(PrimaryStage.getScene()==scene8)
			 { 
				 tmpstage.show();
				 tmpstage.setScene(tmpscene);
				 Label l=new Label(covers.get(3).toString());
				 tmpstage.getIcons().clear();
				 tmpstage.getIcons().add(coverimg);
				 l.setTextFill(Color.color(1, 1, 1));
				 l.setFont(new Font("Verdana",30));
				 l.setTranslateX(20);
				 l.setTranslateY(120);
				 tmplayout.getChildren().add(l);
				 tmpstage.setAlwaysOnTop(true);
			 }});
		coverButtons.get(3).setOnMouseExited(e->{
			 if(PrimaryStage.getScene()==scene8)
			 {
				 tmpstage.close();
			 }});
		
		coverButtons.get(4).setOnAction(e->{
			if(PrimaryStage.getScene()==scene8 && targeted) {
				 targeted=false;
				 try {
					gg.castAbility(targetAbility,(int)covers.get(4).getLocation().getX(),(int)covers.get(4).getLocation().getY());
				    if(covers.get(4).getCurrentHP()==0) {
				    	coverButtons.get(4).setDisable(true);
				    	coverButtons.get(4).setVisible(false);
				    }
				 } catch (NotEnoughResourcesException e1) {
					 display("Attention","GUI/not enough resources.jpeg");
					 
					
				} catch (AbilityUseException e1) {
					display("Attention","GUI/AbilityUseException .jpeg");
					
				} catch (InvalidTargetException e1) {
					display("Attention","GUI/InvalidAttack.jpeg");
					
				} catch (CloneNotSupportedException e1) {
					System.out.print("CloneNotSupportedException");
				}
			 }
		});
		
		coverButtons.get(4).setOnMouseEntered(e->{
       	 	GridPane tmplayout=new GridPane();
    		Scene tmpscene=new Scene(tmplayout,300,300);
    		File tmpscimg1=new File("GUI/propertiesBg 3.jpg");
			Image tmpscimg = new Image(tmpscimg1.toURI().toString());
    		
    		BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
    		Background btmpsc = new Background(tmpscbImg);
    		tmplayout.setBackground(btmpsc);
    		
			 
			 if(PrimaryStage.getScene()==scene8)
			 { 
				 tmpstage.show();
				 tmpstage.setScene(tmpscene);
				 Label l=new Label(covers.get(4).toString()); 
				 tmpstage.getIcons().clear();
				 tmpstage.getIcons().add(coverimg);
				 l.setTextFill(Color.color(1, 1, 1));
				 l.setFont(new Font("Verdana",30));
				 l.setTranslateX(20);
				 l.setTranslateY(120);
				 tmplayout.getChildren().add(l);
				 tmpstage.setAlwaysOnTop(true);
			 }});
		coverButtons.get(4).setOnMouseExited(e->{
			 if(PrimaryStage.getScene()==scene8)
			 {
				 tmpstage.close();
			 }});
		
		ArrayList<Button> chButtons=new ArrayList<Button>();
		
		Button CA = new Button();
		chButtons.add(CA);
		File CAimg1 = new File("GUI/CAIcon.jpg");
		Image CAimg = new Image(CAimg1.toURI().toString());
		
		 ImageView CAimv=new ImageView(CAimg);
		 CA.setGraphic(CAimv);
		 CAimv.setFitHeight(100);
		 CAimv.setFitWidth(80);
		 CA.setBackground(null);
		 CA.setTranslateX(30);
		 CA.setTranslateY(50);
		 CA.setOnAction( 
		 e->{
			 if(PrimaryStage.getScene()==scene4)
			 {
			 if (first.getTeam().size()>second.getTeam().size())
			 display(second, Game.getAvailableChampions().get(0),CA,"GUI/CAIcon.jpg");
			 
			 else if (first.getTeam().size() == second.getTeam().size())
		     display(first, Game.getAvailableChampions().get(0),CA,"GUI/CAIcon.jpg");
			
			 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
				 for (int i=0; i<chButtons.size();i++) {
					 chButtons.get(i).setDisable(true);
				 }
			 }
			 }
			 else if(PrimaryStage.getScene()==scene5)
			 {
				 if(first.getTeam().contains(Game.getAvailableChampions().get(0)))
				 {
					 for(int i=0;i<first.getTeam().size();i++)
					 {
						 if(first.getTeam().get(i)==Game.getAvailableChampions().get(0))
						 first.setLeader(first.getTeam().get(i));
						 for(int j=0;j<Game.getAvailableChampions().size();j++)
						 {
							 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
							 {
								 chButtons.get(j).setDisable(true);
							 }
						 }
					 }
				 }
				 else if(second.getTeam().contains(Game.getAvailableChampions().get(0)))
					 {
					 	for(int i=0;i<second.getTeam().size();i++)
					 {
					 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(0))
					 			second.setLeader(second.getTeam().get(i));
					 		for(int j=0;j<Game.getAvailableChampions().size();j++)
							 {
								 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
								 {
									 chButtons.get(j).setDisable(true);
								 }
							 }
					 }
					 }
			 }
			 else {if(PrimaryStage.getScene()==scene8 && targeted) {
				 targeted=false;
				 try {
					gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(0).getLocation().getX(),(int)Game.getAvailableChampions().get(0).getLocation().getY());
				    if(Game.getAvailableChampions().get(0).getCurrentHP()==0) {
				    	chButtons.get(0).setDisable(true);
				    	chButtons.get(0).setVisible(false);
				    }
				    if(gg.checkGameOver()!=null)
					{
						
				    	PrimaryStage.setScene(scene9);GOWPlayer.stop();
						MediaView iammediaview=new MediaView(iammediaplayer);PrimaryStage.setScene(scene9);GOWPlayer.stop();
						layout9.getChildren().addAll(iammediaview);
						iammediaplayer.setAutoPlay(true);
					}
				 } catch (NotEnoughResourcesException e1) {
					 display("Attention","GUI/not enough resources.jpeg");
					 
					
				} catch (AbilityUseException e1) {
					display("Attention","GUI/AbilityUseException .jpeg");
					
				} catch (InvalidTargetException e1) {
					display("Attention","GUI/InvalidAttack.jpeg");
					
				} catch (CloneNotSupportedException e1) {
					System.out.print("CloneNotSupportedException");
				}
			 }
			 }
		 
		 });
         CA.setOnMouseEntered(e->{
        	 GridPane tmplayout=new GridPane();
     		Scene tmpscene=new Scene(tmplayout,300,800);
     		File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
     		Image tmpscimg = new Image(tmpscimg1.toURI().toString());
     		
     		BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
     		Background btmpsc = new Background(tmpscbImg);
     		tmplayout.setBackground(btmpsc);
     		
			 
			 if(PrimaryStage.getScene()==scene8)
			 { 
				 tmpstage.show();
				 tmpstage.setScene(tmpscene);
				 Label l= new Label();
				 String lead="";
				 if(gg.getAvailableChampions().get(0).equals(first.getLeader()) || gg.getAvailableChampions().get(0).equals(second.getLeader()))
					 lead= "Leader" +"\n";
				 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(0))
				 l.setText(gg.getAvailableChampions().get(0).currentToString()); 
				 else {
					 l.setText(lead+gg.getAvailableChampions().get(0).notToString());
					 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
					 }
				 tmpstage.getIcons().clear();
				 tmpstage.getIcons().add(CAimg);
				 l.setTextFill(Color.color(1, 1, 1));
				 tmplayout.getChildren().add(l);
				 tmpstage.setAlwaysOnTop(true);
			 }});
		  CA.setOnMouseExited(e->{
			 if(PrimaryStage.getScene()==scene8)
			 {
				 tmpstage.close();
			 }});
	 
		 
		Button DP = new Button();
		chButtons.add(DP);
		File DPimg1 = new File("GUI/DDIcon.jpg");
		Image DPimg = new Image(DPimg1.toURI().toString());
		
		 ImageView DPimv=new ImageView(DPimg);
		 DP.setGraphic(DPimv);
		 DPimv.setFitHeight(100);
		 DPimv.setFitWidth(80);
         DP.setBackground(null);
         DP.setTranslateX(130);
		 DP.setTranslateY(50);
		 DP.setOnAction(
		 e->{
			 if(PrimaryStage.getScene()==scene4)
			 {
			 if (first.getTeam().size()>second.getTeam().size())
			 display(second, Game.getAvailableChampions().get(1),DP,"GUI/DDIcon.jpg");
			 
			 else if (first.getTeam().size() == second.getTeam().size())
		     display(first, Game.getAvailableChampions().get(1),DP,"GUI/DDIcon.jpg");
			 
			 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
				 for (int i=0; i<chButtons.size();i++) {
					 chButtons.get(i).setDisable(true);
				 }
			 }
			 }
			 else if(PrimaryStage.getScene()==scene5)
			 {
				 if(first.getTeam().contains(Game.getAvailableChampions().get(1)))
				 {
					 for(int i=0;i<first.getTeam().size();i++)
					 {
						 if(first.getTeam().get(i)==Game.getAvailableChampions().get(1))
						 first.setLeader(first.getTeam().get(i));
						 for(int j=0;j<Game.getAvailableChampions().size();j++)
						 {
							 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
							 {
								 chButtons.get(j).setDisable(true);
							 }
						 }
					 }
				 }
				 else if(second.getTeam().contains(Game.getAvailableChampions().get(1)))
					 {
					 	for(int i=0;i<second.getTeam().size();i++)
					 {
					 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(1))
					 			second.setLeader(second.getTeam().get(i));
					 		for(int j=0;j<Game.getAvailableChampions().size();j++)
							 {
								 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
								 {
									 chButtons.get(j).setDisable(true);
								 }
							 }
					 }
					 }
			 }
			 else {if(PrimaryStage.getScene()==scene8 && targeted) {
				 targeted=false;
				 try {
					gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(1).getLocation().getX(),(int)Game.getAvailableChampions().get(1).getLocation().getY());
				    if(Game.getAvailableChampions().get(1).getCurrentHP()==0) {
				    	chButtons.get(1).setDisable(true);
				    	chButtons.get(1).setVisible(false);
				    }
				    if(gg.checkGameOver()!=null)
					{
						PrimaryStage.setScene(scene9);GOWPlayer.stop();
						
						MediaView iammediaview=new MediaView(iammediaplayer);
						layout9.getChildren().addAll(iammediaview);
						iammediaplayer.setAutoPlay(true);
					}
				 } catch (NotEnoughResourcesException e1) {
					 display("Attention","GUI/not enough resources.jpeg");
					
					
				} catch (AbilityUseException e1) {
					display("Attention","GUI/AbilityUseException .jpeg");
					
				} catch (InvalidTargetException e1) {
					display("Attention","GUI/InvalidAttack.jpeg");
					
				} catch (CloneNotSupportedException e1) {
					System.out.print("CloneNotSupportedException");
				}
			 }
			 }
		 });  
		 DP.setOnMouseEntered(e->{
			 GridPane tmplayout=new GridPane();
				Scene tmpscene=new Scene(tmplayout,300,800);
				File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
				Image tmpscimg = new Image(tmpscimg1.toURI().toString());
				
				BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
				Background btmpsc = new Background(tmpscbImg);
				tmplayout.setBackground(btmpsc);
				
			 
			 if(PrimaryStage.getScene()==scene8)
			 { 
				 tmpstage.show();
				 tmpstage.setScene(tmpscene);
				 Label l= new Label();
				 String lead="";
				 if(gg.getAvailableChampions().get(1).equals(first.getLeader()) || gg.getAvailableChampions().get(1).equals(second.getLeader()))
					 lead= "Leader" +"\n";
				 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(1))
				 l.setText(gg.getAvailableChampions().get(1).currentToString()); 
				 else {
					 l.setText(lead+gg.getAvailableChampions().get(1).notToString());
					 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
				 }
				 tmpstage.getIcons().clear();
				 tmpstage.getIcons().add(DPimg);
				 l.setTextFill(Color.color(1, 1, 1));
				 tmplayout.getChildren().add(l);
				 tmpstage.setAlwaysOnTop(true);
			 }});
		DP.setOnMouseExited(e->{
			 if(PrimaryStage.getScene()==scene8)
			 {
				 tmpstage.close();
			 }});
		
		 
		Button DS = new Button();
		chButtons.add(DS);
		File DSimg1 = new File("GUI/DSIcon.png");
		Image DSimg = new Image(DSimg1.toURI().toString());
		
		 ImageView DSimv=new ImageView(DSimg);
		 DS.setGraphic(DSimv);
		 DSimv.setFitHeight(100);
		 DSimv.setFitWidth(80);
		 DS.setBackground(null);
		 DS.setTranslateX(230);
		 DS.setTranslateY(50);
		 DS.setOnAction(
		 e->{
			 if(PrimaryStage.getScene()==scene4)
			 {
					 if (first.getTeam().size()>second.getTeam().size())
					 display(second, Game.getAvailableChampions().get(2),DS,"GUI/DSIcon.png");
					 
					 else if (first.getTeam().size() == second.getTeam().size())
				     display(first, Game.getAvailableChampions().get(2),DS,"GUI/DSIcon.png");
					 
					 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
						 for (int i=0; i<chButtons.size();i++) {
							 chButtons.get(i).setDisable(true);
						 }
					 }
			 }
			 else if(PrimaryStage.getScene()==scene5)
			 {
				 if(first.getTeam().contains(Game.getAvailableChampions().get(2)))
				 {
					 for(int i=0;i<first.getTeam().size();i++)
					 {
						 if(first.getTeam().get(i)==Game.getAvailableChampions().get(2))
						 first.setLeader(first.getTeam().get(i));
						 for(int j=0;j<Game.getAvailableChampions().size();j++)
						 {
							 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
							 {
								 chButtons.get(j).setDisable(true);
							 }
						 }
					 }
				 }
				 else if(second.getTeam().contains(Game.getAvailableChampions().get(2)))
					 {
					 	for(int i=0;i<second.getTeam().size();i++)
					 {
					 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(2))
					 			second.setLeader(second.getTeam().get(i));
					 		for(int j=0;j<Game.getAvailableChampions().size();j++)
							 {
								 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
								 {
									 chButtons.get(j).setDisable(true);
								 }
							 }
					 }
					 }
			 }
			 else {if(PrimaryStage.getScene()==scene8 && targeted) {
				 targeted=false;
				 try {
					gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(2).getLocation().getX(),(int)Game.getAvailableChampions().get(2).getLocation().getY());
				    if(Game.getAvailableChampions().get(2).getCurrentHP()==0) {
				    	chButtons.get(2).setDisable(true);
				    	chButtons.get(2).setVisible(false);
				    }
				    if(gg.checkGameOver()!=null)
					{
						PrimaryStage.setScene(scene9);GOWPlayer.stop();
						
						MediaView iammediaview=new MediaView(iammediaplayer);
						layout9.getChildren().addAll(iammediaview);
						iammediaplayer.setAutoPlay(true);
					}
				 } catch (NotEnoughResourcesException e1) {
					 display("Attention","GUI/not enough resources.jpeg");
					 
					
				} catch (AbilityUseException e1) {
					display("Attention","GUI/AbilityUseException .jpeg");
					
				} catch (InvalidTargetException e1) {
					display("Attention","GUI/InvalidAttack.jpeg");
					
				} catch (CloneNotSupportedException e1) {
					System.out.print("CloneNotSupportedException");
				}
			 }
			 }
		});  
		 DS.setOnMouseEntered(e->{
			 GridPane tmplayout=new GridPane();
				Scene tmpscene=new Scene(tmplayout,300,800);
				File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
				Image tmpscimg = new Image(tmpscimg1.toURI().toString());
				
				BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
				Background btmpsc = new Background(tmpscbImg);
				tmplayout.setBackground(btmpsc);
				
			 
			 if(PrimaryStage.getScene()==scene8)
			 { 
				 tmpstage.show();
				 tmpstage.setScene(tmpscene);
				 Label l= new Label();
				 String lead="";
				 if(gg.getAvailableChampions().get(2).equals(first.getLeader()) || gg.getAvailableChampions().get(2).equals(second.getLeader()))
					 lead= "Leader" +"\n";
				 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(2))
				 l.setText(gg.getAvailableChampions().get(2).currentToString()); 
				 else {
					 l.setText(lead+gg.getAvailableChampions().get(2).notToString());
					 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
				 }
				 tmpstage.getIcons().clear();
				 tmpstage.getIcons().add(DSimg);
				 l.setTextFill(Color.color(1, 1, 1));
				 tmplayout.getChildren().add(l);
				 tmpstage.setAlwaysOnTop(true);
			 }});
		DS.setOnMouseExited(e->{
			 if(PrimaryStage.getScene()==scene8)
			 {
				 tmpstage.close();
			 }});
     
	  
		 
		 
		Button E = new Button();
		chButtons.add(E);
		File Eimg1 = new File("GUI/ElectroIcon.png");
		Image Eimg = new Image(Eimg1.toURI().toString());
		
		 ImageView Eimv=new ImageView(Eimg);
		 E.setGraphic(Eimv);
		 Eimv.setFitHeight(100);
		 Eimv.setFitWidth(80);
		 E.setBackground(null);
		 E.setTranslateX(330);
		 E.setTranslateY(50);
		 E.setOnAction(
		 e->{
			 if(PrimaryStage.getScene()==scene4)
			 {
							 if (first.getTeam().size()>second.getTeam().size())
								 display(second, Game.getAvailableChampions().get(3),E,"GUI/ElectroIcon.png");
							 
							 else if (first.getTeam().size() == second.getTeam().size())
								 display(first, Game.getAvailableChampions().get(3),E,"GUI/ElectroIcon.png");
							
							 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
								 for (int i=0; i<chButtons.size();i++) {
									 chButtons.get(i).setDisable(true);
								 }
							 }
			 }
			 else if(PrimaryStage.getScene()==scene5)
			 {
				 if(first.getTeam().contains(Game.getAvailableChampions().get(3)))
				 {
					 for(int i=0;i<first.getTeam().size();i++)
					 {
						 if(first.getTeam().get(i)==Game.getAvailableChampions().get(3))
						 first.setLeader(first.getTeam().get(i));
						 for(int j=0;j<Game.getAvailableChampions().size();j++)
						 {
							 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
							 {
								 chButtons.get(j).setDisable(true);
							 }
						 }
					 }
				 }
				 else if(second.getTeam().contains(Game.getAvailableChampions().get(3)))
					 {
					 	for(int i=0;i<second.getTeam().size();i++)
					 {
					 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(3))
					 			second.setLeader(second.getTeam().get(i));
					 		for(int j=0;j<Game.getAvailableChampions().size();j++)
							 {
								 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
								 {
									 chButtons.get(j).setDisable(true);
								 }
							 }
					 }
					 }
			 }
			 else {if(PrimaryStage.getScene()==scene8 && targeted) {
				 targeted=false;
				 try {
					gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(3).getLocation().getX(),(int)Game.getAvailableChampions().get(3).getLocation().getY());
				    if(Game.getAvailableChampions().get(3).getCurrentHP()==0) {
				    	chButtons.get(3).setDisable(true);
				    	chButtons.get(3).setVisible(false);
				    }
				    if(gg.checkGameOver()!=null)
					{
						PrimaryStage.setScene(scene9);GOWPlayer.stop();
						
						MediaView iammediaview=new MediaView(iammediaplayer);
						layout9.getChildren().addAll(iammediaview);
						iammediaplayer.setAutoPlay(true);
					}
				 } catch (NotEnoughResourcesException e1) {
					 display("Attention","GUI/not enough resources.jpeg");
					 
					
				} catch (AbilityUseException e1) {
					display("Attention","GUI/AbilityUseException .jpeg");
					
				} catch (InvalidTargetException e1) {
					display("Attention","GUI/InvalidAttack.jpeg");
					
				} catch (CloneNotSupportedException e1) {
					System.out.print("CloneNotSupportedException");
				}
			 }
			 }
		});  
		 E.setOnMouseEntered(e->{
			 GridPane tmplayout=new GridPane();
				Scene tmpscene=new Scene(tmplayout,300,800);
				File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
				Image tmpscimg = new Image(tmpscimg1.toURI().toString());
				
				BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
				Background btmpsc = new Background(tmpscbImg);
				tmplayout.setBackground(btmpsc);
				
			 
			 if(PrimaryStage.getScene()==scene8)
			 { 
				 tmpstage.show();
				 tmpstage.setScene(tmpscene);
				 Label l= new Label();
				 String lead="";
				 if(gg.getAvailableChampions().get(3).equals(first.getLeader()) || gg.getAvailableChampions().get(3).equals(second.getLeader()))
					 lead= "Leader" +"\n";
				 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(3))
				 l.setText(gg.getAvailableChampions().get(3).currentToString()); 
				 else {
					 l.setText(lead+gg.getAvailableChampions().get(3).notToString());
					 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
				 }
				 tmpstage.getIcons().clear();
				 tmpstage.getIcons().add(Eimg);
				 l.setTextFill(Color.color(1, 1, 1));
				 tmplayout.getChildren().add(l);
				 tmpstage.setAlwaysOnTop(true);
			 }});
		E.setOnMouseExited(e->{
			 if(PrimaryStage.getScene()==scene8)
			 {
				 tmpstage.close();
			 }});
		 
		Button GR = new Button();
		chButtons.add(GR);
		File GRimg1 = new File("GUI/GRIcon.jpg");
		Image GRimg = new Image(GRimg1.toURI().toString());
		
		 ImageView GRimv=new ImageView(GRimg);
		 GR.setGraphic(GRimv);
		 GRimv.setFitHeight(100);
		 GRimv.setFitWidth(80);
		 GR.setBackground(null);
		 GR.setTranslateX(430);
		 GR.setTranslateY(50);
		 GR.setOnAction(
				 e->{
					 if(PrimaryStage.getScene()==scene4)
					 {
							 if (first.getTeam().size()>second.getTeam().size())
								 display(second, Game.getAvailableChampions().get(4),GR,"GUI/GRIcon.jpg");
							 
							 else if (first.getTeam().size() == second.getTeam().size())
								 display(first, Game.getAvailableChampions().get(4),GR,"GUI/GRIcon.jpg");
							 
							 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
								 for (int i=0; i<chButtons.size();i++) {
									 chButtons.get(i).setDisable(true);
								 }
							 }
					}
					 else if(PrimaryStage.getScene()==scene5)
					 {
						 if(first.getTeam().contains(Game.getAvailableChampions().get(4)))
						 {
							 for(int i=0;i<first.getTeam().size();i++)
							 {
								 if(first.getTeam().get(i)==Game.getAvailableChampions().get(4))
								 first.setLeader(first.getTeam().get(i));
								 for(int j=0;j<Game.getAvailableChampions().size();j++)
								 {
									 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
									 {
										 chButtons.get(j).setDisable(true);
									 }
								 }
							 }
						 }
						 else if(second.getTeam().contains(Game.getAvailableChampions().get(4)))
							 {
							 	for(int i=0;i<second.getTeam().size();i++)
							 {
							 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(4))
							 			second.setLeader(second.getTeam().get(i));
							 		for(int j=0;j<Game.getAvailableChampions().size();j++)
									 {
										 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
										 {
											 chButtons.get(j).setDisable(true);
										 }
									 }
							 }
							 }
					 }
					 else {if(PrimaryStage.getScene()==scene8 && targeted) {
						 targeted=false;
						 try {
							gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(4).getLocation().getX(),(int)Game.getAvailableChampions().get(4).getLocation().getY());
						    if(Game.getAvailableChampions().get(4).getCurrentHP()==0) {
						    	chButtons.get(4).setDisable(true);
						    	chButtons.get(4).setVisible(false);
						    }
						    if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						 } catch (NotEnoughResourcesException e1) {
							 display("Attention","GUI/not enough resources.jpeg");
							 
								
							} catch (AbilityUseException e1) {
								display("Attention","GUI/AbilityUseException .jpeg");
								
							} catch (InvalidTargetException e1) {
								display("Attention","GUI/InvalidAttack.jpeg");
								
							} catch (CloneNotSupportedException e1) {
								System.out.print("CloneNotSupportedException");
							}
					 }
					 }
				});  
		 GR.setOnMouseEntered(e->{
			 GridPane tmplayout=new GridPane();
				Scene tmpscene=new Scene(tmplayout,300,800);
				File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
				Image tmpscimg = new Image(tmpscimg1.toURI().toString());
				
				BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
				Background btmpsc = new Background(tmpscbImg);
				tmplayout.setBackground(btmpsc);
				
					 
					 if(PrimaryStage.getScene()==scene8)
					 { 
						 tmpstage.show();
						 tmpstage.setScene(tmpscene);
						 Label l= new Label();
						 String lead="";
						 if(gg.getAvailableChampions().get(4).equals(first.getLeader()) || gg.getAvailableChampions().get(4).equals(second.getLeader()))
							 lead= "Leader" +"\n";
						 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(4))
						 l.setText(gg.getAvailableChampions().get(4).currentToString()); 
						 else {
							 l.setText(lead+gg.getAvailableChampions().get(4).notToString());
							 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
						 }
						 tmpstage.getIcons().clear();
						 tmpstage.getIcons().add(GRimg);
						 l.setTextFill(Color.color(1, 1, 1));
						 tmplayout.getChildren().add(l);
						 tmpstage.setAlwaysOnTop(true);
					 }});
				GR.setOnMouseExited(e->{
					 if(PrimaryStage.getScene()==scene8)
					 {
						 tmpstage.close();
					 }});
		 
		Button HE = new Button();
		chButtons.add(HE);
		File HEimg1 = new File("GUI/HelaIcon.png");
		Image HEimg = new Image(HEimg1.toURI().toString());
		
		 ImageView HEimv=new ImageView(HEimg);
		 HE.setGraphic(HEimv);
		 HEimv.setFitHeight(100);
		 HEimv.setFitWidth(80);
		 HE.setBackground(null);
		 HE.setTranslateX(30);
		 HE.setTranslateY(170);
		 HE.setOnAction(
				 e->{
					 if(PrimaryStage.getScene()==scene4)
					 {
							 if (first.getTeam().size()>second.getTeam().size())
							 display(second, Game.getAvailableChampions().get(5),HE,"GUI/HelaIcon.png");
							 
							 else if (first.getTeam().size() == second.getTeam().size())
						     display(first, Game.getAvailableChampions().get(5),HE,"GUI/HelaIcon.png");
							 
							 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
								 for (int i=0; i<chButtons.size();i++) {
									 chButtons.get(i).setDisable(true);
								 }
							 }
					 }
					 else if(PrimaryStage.getScene()==scene5)
					 {
						 if(first.getTeam().contains(Game.getAvailableChampions().get(5)))
						 {
							 for(int i=0;i<first.getTeam().size();i++)
							 {
								 if(first.getTeam().get(i)==Game.getAvailableChampions().get(5))
								 first.setLeader(first.getTeam().get(i));
								 for(int j=0;j<Game.getAvailableChampions().size();j++)
								 {
									 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
									 {
										 chButtons.get(j).setDisable(true);
									 }
								 }
							 }
						 }
						 else if(second.getTeam().contains(Game.getAvailableChampions().get(5)))
							 {
							 	for(int i=0;i<second.getTeam().size();i++)
							 {
							 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(5))
							 			second.setLeader(second.getTeam().get(i));
							 		for(int j=0;j<Game.getAvailableChampions().size();j++)
									 {
										 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
										 {
											 chButtons.get(j).setDisable(true);
										 }
									 }
							 }
							 }
					 }
					 else {if(PrimaryStage.getScene()==scene8 && targeted) {
						 targeted=false;
						 try {
							gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(5).getLocation().getX(),(int)Game.getAvailableChampions().get(5).getLocation().getY());
						    if(Game.getAvailableChampions().get(5).getCurrentHP()==0) {
						    	chButtons.get(5).setDisable(true);
						    	chButtons.get(5).setVisible(false);
						    }
						    if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						 } catch (NotEnoughResourcesException e1) {
							 display("Attention","GUI/not enough resources.jpeg");
							 
								
							} catch (AbilityUseException e1) {
								display("Attention","GUI/AbilityUseException .jpeg");
								
							} catch (InvalidTargetException e1) {
								display("Attention","GUI/InvalidAttack.jpeg");
								
							} catch (CloneNotSupportedException e1) {
								System.out.print("CloneNotSupportedException");
							}
					 }
					 }
				});
		 HE.setOnMouseEntered(e->{
			 GridPane tmplayout=new GridPane();
				Scene tmpscene=new Scene(tmplayout,300,800);
				File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
				Image tmpscimg = new Image(tmpscimg1.toURI().toString());
				
				BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
				Background btmpsc = new Background(tmpscbImg);
				tmplayout.setBackground(btmpsc);
				
			 
			 if(PrimaryStage.getScene()==scene8)
			 { 
				 tmpstage.show();
				 tmpstage.setScene(tmpscene);
				 Label l= new Label();
				 String lead="";
				 if(gg.getAvailableChampions().get(5).equals(first.getLeader()) || gg.getAvailableChampions().get(5).equals(second.getLeader()))
					 lead= "Leader" +"\n";
				 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(5))
				 l.setText(gg.getAvailableChampions().get(5).currentToString()); 
				 else {
					 l.setText(lead+gg.getAvailableChampions().get(5).notToString());
					 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
				 }
				 tmpstage.getIcons().clear();
				 tmpstage.getIcons().add(HEimg);
				 l.setTextFill(Color.color(1, 1, 1));
				 tmplayout.getChildren().add(l);
				 tmpstage.setAlwaysOnTop(true);
			 }});
		HE.setOnMouseExited(e->{
			 if(PrimaryStage.getScene()==scene8)
			 {
				 tmpstage.close();
			 }});
 
		 
		Button HU = new Button();
		chButtons.add(HU);
		File HUimg1 = new File("GUI/HulkIcon.jpg");
		Image HUimg = new Image(HUimg1.toURI().toString());
		
		 ImageView HUimv=new ImageView(HUimg);
		 HU.setGraphic(HUimv);
		 HUimv.setFitHeight(100);
		 HUimv.setFitWidth(80);
		 HU.setBackground(null);
		 HU.setTranslateX(130);
		 HU.setTranslateY(170);
		 HU.setOnAction(
				 e->{
					 if(PrimaryStage.getScene()==scene4)
					 {
							 if (first.getTeam().size()>second.getTeam().size())
							 display(second, Game.getAvailableChampions().get(6),HU,"GUI/HulkIcon.jpg");
							
							 else if (first.getTeam().size() == second.getTeam().size())
						     display(first, Game.getAvailableChampions().get(6),HU,"GUI/HulkIcon.jpg");
							 
							 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
								 for (int i=0; i<chButtons.size();i++) {
									 chButtons.get(i).setDisable(true);
								 }
							 }
					 }
					 else if(PrimaryStage.getScene()==scene5)
					 {
						 if(first.getTeam().contains(Game.getAvailableChampions().get(6)))
						 {
							 for(int i=0;i<first.getTeam().size();i++)
							 {
								 if(first.getTeam().get(i)==Game.getAvailableChampions().get(6))
								 first.setLeader(first.getTeam().get(i));
								 for(int j=0;j<Game.getAvailableChampions().size();j++)
								 {
									 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
									 {
										 chButtons.get(j).setDisable(true);
									 }
								 }
							 }
						 }
						 else if(second.getTeam().contains(Game.getAvailableChampions().get(6)))
							 {
							 	for(int i=0;i<second.getTeam().size();i++)
							 {
							 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(6))
							 			second.setLeader(second.getTeam().get(i));
							 		for(int j=0;j<Game.getAvailableChampions().size();j++)
									 {
										 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
										 {
											 chButtons.get(j).setDisable(true);
										 }
									 }
							 }
							 }
					 }
					 else {if(PrimaryStage.getScene()==scene8 && targeted) {
						 targeted=false;
						 try {
							gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(6).getLocation().getX(),(int)Game.getAvailableChampions().get(6).getLocation().getY());
						    if(Game.getAvailableChampions().get(6).getCurrentHP()==0) {
						    	chButtons.get(6).setDisable(true);
						    	chButtons.get(6).setVisible(false);
						    }
						    if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						 } catch (NotEnoughResourcesException e1) {
							 display("Attention","GUI/not enough resources.jpeg");
							 
								
							} catch (AbilityUseException e1) {
								display("Attention","GUI/AbilityUseException .jpeg");
								
							} catch (InvalidTargetException e1) {
								display("Attention","GUI/InvalidAttack.jpeg");
								
							} catch (CloneNotSupportedException e1) {
								System.out.print("CloneNotSupportedException");
							}
					 }
					 }
				});
		HU.setOnMouseEntered(e->{
			GridPane tmplayout=new GridPane();
			Scene tmpscene=new Scene(tmplayout,300,800);
			File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
			Image tmpscimg = new Image(tmpscimg1.toURI().toString());
			
			BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
			Background btmpsc = new Background(tmpscbImg);
			tmplayout.setBackground(btmpsc);
			
			 
			 if(PrimaryStage.getScene()==scene8)
			 { 
				 tmpstage.show();
				 tmpstage.setScene(tmpscene);
				 Label l= new Label();
				 String lead="";
				 if(gg.getAvailableChampions().get(6).equals(first.getLeader()) || gg.getAvailableChampions().get(6).equals(second.getLeader()))
					 lead= "Leader" +"\n";
				 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(6))
				 l.setText(gg.getAvailableChampions().get(6).currentToString()); 
				 else {
					 l.setText(lead+gg.getAvailableChampions().get(6).notToString());
					 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
				 }
				 tmpstage.getIcons().clear();
				 tmpstage.getIcons().add(HUimg);
				 l.setTextFill(Color.color(1, 1, 1));
				 tmplayout.getChildren().add(l);
				 tmpstage.setAlwaysOnTop(true);
			 }});
		HU.setOnMouseExited(e->{
			 if(PrimaryStage.getScene()==scene8)
			 {
				 tmpstage.close();
			 }});
 
		 
		Button IC = new Button();
		chButtons.add(IC);
		File ICimg1 = new File("GUI/IceIcon.jpg");
		Image ICimg = new Image(ICimg1.toURI().toString());
		
		 ImageView ICimv=new ImageView(ICimg);
		 IC.setGraphic(ICimv);
		 ICimv.setFitHeight(100);
		 ICimv.setFitWidth(80);
		 IC.setBackground(null);
		 IC.setTranslateX(230);
		 IC.setTranslateY(170);
		 IC.setOnAction(
				 e->{
					 if(PrimaryStage.getScene()==scene4)
					 {
							 if (first.getTeam().size()>second.getTeam().size())
							 display(second, Game.getAvailableChampions().get(7),IC,"GUI/IceIcon.jpg");
							 
							 else if (first.getTeam().size() == second.getTeam().size())
						     display(first, Game.getAvailableChampions().get(7),IC,"GUI/IceIcon.jpg");
							 
							 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
								 for (int i=0; i<chButtons.size();i++) {
									 chButtons.get(i).setDisable(true);
								 }
							 }
					 }
					 else if(PrimaryStage.getScene()==scene5)
					 {
						 if(first.getTeam().contains(Game.getAvailableChampions().get(7)))
						 {
							 for(int i=0;i<first.getTeam().size();i++)
							 {
								 if(first.getTeam().get(i)==Game.getAvailableChampions().get(7))
								 first.setLeader(first.getTeam().get(i));
								 for(int j=0;j<Game.getAvailableChampions().size();j++)
								 {
									 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
									 {
										 chButtons.get(j).setDisable(true);
									 }
								 }
							 }
						 }
						 else if(second.getTeam().contains(Game.getAvailableChampions().get(7)))
							 {
							 	for(int i=0;i<second.getTeam().size();i++)
							 {
							 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(7))
							 			second.setLeader(second.getTeam().get(i));
							 		for(int j=0;j<Game.getAvailableChampions().size();j++)
									 {
										 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
										 {
											 chButtons.get(j).setDisable(true);
										 }
									 }
							 }
							 }
					 }
					 else {if(PrimaryStage.getScene()==scene8 && targeted) {
						 targeted=false;
						 try {
							gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(7).getLocation().getX(),(int)Game.getAvailableChampions().get(7).getLocation().getY());
						    if(Game.getAvailableChampions().get(7).getCurrentHP()==0) {
						    	chButtons.get(7).setDisable(true);
						    	chButtons.get(7).setVisible(false);
						    }
						    if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						 } catch (NotEnoughResourcesException e1) {
							 display("Attention","GUI/not enough resources.jpeg");
							 
								
							} catch (AbilityUseException e1) {
								display("Attention","GUI/AbilityUseException .jpeg");
								
							} catch (InvalidTargetException e1) {
								display("Attention","GUI/InvalidAttack.jpeg");
								
							} catch (CloneNotSupportedException e1) {
								System.out.print("CloneNotSupportedException");
							}
					 }
					 }
				});
		 IC.setOnMouseEntered(e->{
			 GridPane tmplayout=new GridPane();
				Scene tmpscene=new Scene(tmplayout,300,800);
				File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
				Image tmpscimg = new Image(tmpscimg1.toURI().toString());

				
				BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
				Background btmpsc = new Background(tmpscbImg);
				tmplayout.setBackground(btmpsc);
				
			 
			 if(PrimaryStage.getScene()==scene8)
			 { 
				 tmpstage.show();
				 tmpstage.setScene(tmpscene);
				 Label l= new Label();
				 String lead="";
				 if(gg.getAvailableChampions().get(7).equals(first.getLeader()) || gg.getAvailableChampions().get(7).equals(second.getLeader()))
					 lead= "Leader" +"\n";
				 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(7))
				 l.setText(gg.getAvailableChampions().get(7).currentToString()); 
				 else {
					 l.setText(lead+gg.getAvailableChampions().get(7).notToString());
					 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
				 }
				 tmpstage.getIcons().clear();
				 tmpstage.getIcons().add(ICimg);
				 l.setTextFill(Color.color(1, 1, 1));
				 tmplayout.getChildren().add(l);
				 tmpstage.setAlwaysOnTop(true);
			 }});
		IC.setOnMouseExited(e->{
			 if(PrimaryStage.getScene()==scene8)
			 {
				 tmpstage.close();
			 }});
 
		Button IR = new Button();
		chButtons.add(IR);
		File IRimg1 = new File("GUI/IronIcon.jpg");
		Image IRimg = new Image(IRimg1.toURI().toString());
		
		 ImageView IRimv=new ImageView(IRimg);
		 IR.setGraphic(IRimv);
		 IRimv.setFitHeight(100);
		 IRimv.setFitWidth(80);
		 IR.setBackground(null);
		 IR.setTranslateX(330);
		 IR.setTranslateY(170);
		 IR.setOnAction(
				 e->{
					 if(PrimaryStage.getScene()==scene4)
					 {
							 if (first.getTeam().size()>second.getTeam().size())
							 display(second, Game.getAvailableChampions().get(8),IR,"GUI/IronIcon.jpg");
							 
							 else if (first.getTeam().size() == second.getTeam().size())
						     display(first, Game.getAvailableChampions().get(8),IR,"GUI/IronIcon.jpg");
							 
							 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
								 for (int i=0; i<chButtons.size();i++) {
									 chButtons.get(i).setDisable(true);
								 }
							 }
					 }
					 else if(PrimaryStage.getScene()==scene5)
					 {
						 if(first.getTeam().contains(Game.getAvailableChampions().get(8)))
						 {
							 for(int i=0;i<first.getTeam().size();i++)
							 {
								 if(first.getTeam().get(i)==Game.getAvailableChampions().get(8))
								 first.setLeader(first.getTeam().get(i));
								 for(int j=0;j<Game.getAvailableChampions().size();j++)
								 {
									 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
									 {
										 chButtons.get(j).setDisable(true);
									 }
								 }
							 }
						 }
						 else if(second.getTeam().contains(Game.getAvailableChampions().get(8)))
							 {
							 	for(int i=0;i<second.getTeam().size();i++)
							 {
							 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(8))
							 			second.setLeader(second.getTeam().get(i));
							 		for(int j=0;j<Game.getAvailableChampions().size();j++)
									 {
										 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
										 {
											 chButtons.get(j).setDisable(true);
										 }
									 }
							 }
							 }
					 }
					 else {if(PrimaryStage.getScene()==scene8 && targeted) {
						 targeted=false;
						 try {
							gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(8).getLocation().getX(),(int)Game.getAvailableChampions().get(8).getLocation().getY());
						    if(Game.getAvailableChampions().get(8).getCurrentHP()==0) {
						    	chButtons.get(8).setDisable(true);
						    	chButtons.get(8).setVisible(false);
						    }
						    if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						 } catch (NotEnoughResourcesException e1) {
							 display("Attention","GUI/not enough resources.jpeg");
							 
								
							} catch (AbilityUseException e1) {
								display("Attention","GUI/AbilityUseException .jpeg");
								
							} catch (InvalidTargetException e1) {
								display("Attention","GUI/InvalidAttack.jpeg");
								
							} catch (CloneNotSupportedException e1) {
								System.out.print("CloneNotSupportedException");
							}
					 }
					 }
				});
		 IR.setOnMouseEntered(e->{
			 GridPane tmplayout=new GridPane();
				Scene tmpscene=new Scene(tmplayout,300,800);
				File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
				Image tmpscimg = new Image(tmpscimg1.toURI().toString());
				
				BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
				Background btmpsc = new Background(tmpscbImg);
				tmplayout.setBackground(btmpsc);
				
					 if(PrimaryStage.getScene()==scene8)
					 { 
						 tmpstage.show();
						 tmpstage.setScene(tmpscene);
						 Label l= new Label();
						 String lead="";
						 if(gg.getAvailableChampions().get(8).equals(first.getLeader()) || gg.getAvailableChampions().get(8).equals(second.getLeader()))
							 lead= "Leader" +"\n";
						 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(8))
						 l.setText(gg.getAvailableChampions().get(8).currentToString()); 
						 else {
							 l.setText(lead+gg.getAvailableChampions().get(8).notToString());
							 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
						 }
						 tmpstage.getIcons().clear();
						 tmpstage.getIcons().add(IRimg);
						 l.setTextFill(Color.color(1, 1, 1));
						 tmplayout.getChildren().add(l);
						 tmpstage.setAlwaysOnTop(true);
					 }});
				IR.setOnMouseExited(e->{
					 if(PrimaryStage.getScene()==scene8)
					 {
						 tmpstage.close();
					 }});
		 
		 
		Button L = new Button();
		chButtons.add(L);
		File Limg1 = new File("GUI/LokiIcon.png");
		Image Limg = new Image(Limg1.toURI().toString());
		
		 ImageView Limv=new ImageView(Limg);
		 L.setGraphic(Limv);
		 Limv.setFitHeight(100);
		 Limv.setFitWidth(80);
		 L.setBackground(null);
		 L.setTranslateX(430);
		 L.setTranslateY(170);
		 L.setOnAction(
				 e->{
					 if(PrimaryStage.getScene()==scene4)
					 {
							 if (first.getTeam().size()>second.getTeam().size())
							 display(second, Game.getAvailableChampions().get(9),L,"GUI/LokiIcon.png");
							 
							 else if (first.getTeam().size() == second.getTeam().size())
						     display(first, Game.getAvailableChampions().get(9),L,"GUI/LokiIcon.png");
							 
							 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
								 for (int i=0; i<chButtons.size();i++) {
									 chButtons.get(i).setDisable(true);
								 }
							 }
					 }
					 else if(PrimaryStage.getScene()==scene5)
					 {
						 if(first.getTeam().contains(Game.getAvailableChampions().get(9)))
						 {
							 for(int i=0;i<first.getTeam().size();i++)
							 {
								 if(first.getTeam().get(i)==Game.getAvailableChampions().get(9))
								 first.setLeader(first.getTeam().get(i));
								 for(int j=0;j<Game.getAvailableChampions().size();j++)
								 {
									 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
									 {
										 chButtons.get(j).setDisable(true);
										 
									 }
								 }
							 }
						 }
						 else if(second.getTeam().contains(Game.getAvailableChampions().get(9)))
							 {
							 	for(int i=0;i<second.getTeam().size();i++)
							 {
							 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(9))
							 			second.setLeader(second.getTeam().get(i));
							 		for(int j=0;j<Game.getAvailableChampions().size();j++)
									 {
										 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
										 {
											 chButtons.get(j).setDisable(true);
										 }
									 }
							 }
							 }
					 }
					 else {if(PrimaryStage.getScene()==scene8 && targeted) {
						 targeted=false;
						 try {
							gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(9).getLocation().getX(),(int)Game.getAvailableChampions().get(9).getLocation().getY());
						    if(Game.getAvailableChampions().get(9).getCurrentHP()==0) {
						    	chButtons.get(9).setDisable(true);
						    	chButtons.get(9).setVisible(false);
						    }
						    if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						 } catch (NotEnoughResourcesException e1) {
							 display("Attention","GUI/not enough resources.jpeg");
							 
								
							} catch (AbilityUseException e1) {
								display("Attention","GUI/AbilityUseException .jpeg");
								
							} catch (InvalidTargetException e1) {
								display("Attention","GUI/InvalidAttack.jpeg");
								
							} catch (CloneNotSupportedException e1) {
								System.out.print("CloneNotSupportedException");
							}
					 }
					 }
				});
		 L.setOnMouseEntered(e->{
			 GridPane tmplayout=new GridPane();
				Scene tmpscene=new Scene(tmplayout,300,800);
				File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
				Image tmpscimg = new Image(tmpscimg1.toURI().toString());
				
				BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
				Background btmpsc = new Background(tmpscbImg);
				tmplayout.setBackground(btmpsc);
				
					 if(PrimaryStage.getScene()==scene8)
					 { 
						 tmpstage.show();
						 tmpstage.setScene(tmpscene);
						 Label l= new Label();
						 String lead="";
						 if(gg.getAvailableChampions().get(9).equals(first.getLeader()) || gg.getAvailableChampions().get(9).equals(second.getLeader()))
							 lead= "Leader" +"\n";
						 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(9))
						 l.setText(gg.getAvailableChampions().get(9).currentToString()); 
						 else {
							 l.setText(lead+gg.getAvailableChampions().get(9).notToString());
							 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
						 } 
						 tmpstage.getIcons().clear();
						 tmpstage.getIcons().add(Limg);
						 l.setTextFill(Color.color(1, 1, 1));
						 tmplayout.getChildren().add(l);
						 tmpstage.setAlwaysOnTop(true);
					 }});
				L.setOnMouseExited(e->{
					 if(PrimaryStage.getScene()==scene8)
					 {
						 tmpstage.close();
					 }});
		 
		 
		Button Q = new Button();
		chButtons.add(Q);
		File Qimg1 = new File("GUI/QSIcon.jpg");
		Image Qimg = new Image(Qimg1.toURI().toString());
		
		 ImageView Qimv=new ImageView(Qimg);
		 Q.setGraphic(Qimv);
		 Qimv.setFitHeight(100);
		 Qimv.setFitWidth(80);
		 Q.setBackground(null);
		 Q.setTranslateX(30);
		 Q.setTranslateY(290);
		 Q.setOnAction(
				 e->{
					 if(PrimaryStage.getScene()==scene4)
					 {
							 if (first.getTeam().size()>second.getTeam().size())
							 display(second, Game.getAvailableChampions().get(10),Q,"GUI/QSIcon.jpg");
							
							 else if (first.getTeam().size() == second.getTeam().size())
						     display(first, Game.getAvailableChampions().get(10),Q,"GUI/QSIcon.jpg");
							 
							 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
								 for (int i=0; i<chButtons.size();i++) {
									 chButtons.get(i).setDisable(true);
								 }
							 }
					 }
					 else if(PrimaryStage.getScene()==scene5)
					 {
						 if(first.getTeam().contains(Game.getAvailableChampions().get(10)))
						 {
							 for(int i=0;i<first.getTeam().size();i++)
							 {
								 if(first.getTeam().get(i)==Game.getAvailableChampions().get(10))
								 first.setLeader(first.getTeam().get(i));
								 for(int j=0;j<Game.getAvailableChampions().size();j++)
								 {
									 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
									 {
										 chButtons.get(j).setDisable(true);
									 }
								 }
							 }
						 }
						 else if(second.getTeam().contains(Game.getAvailableChampions().get(10)))
							 {
							 	for(int i=0;i<second.getTeam().size();i++)
							 {
							 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(10))
							 			second.setLeader(second.getTeam().get(i));
							 		for(int j=0;j<Game.getAvailableChampions().size();j++)
									 {
										 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
										 {
											 chButtons.get(j).setDisable(true);
										 }
									 }
							 }
							 }
					 }
					 else {if(PrimaryStage.getScene()==scene8 && targeted) {
						 targeted=false;
						 try {
							gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(10).getLocation().getX(),(int)Game.getAvailableChampions().get(10).getLocation().getY());
						    if(Game.getAvailableChampions().get(10).getCurrentHP()==0) {
						    	chButtons.get(10).setDisable(true);
						    	chButtons.get(10).setVisible(false);
						    }
						    if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						 } catch (NotEnoughResourcesException e1) {
							 display("Attention","GUI/not enough resources.jpeg");
							 
								
							} catch (AbilityUseException e1) {
								display("Attention","GUI/AbilityUseException .jpeg");
								
							} catch (InvalidTargetException e1) {
								display("Attention","GUI/InvalidAttack.jpeg");
								
							} catch (CloneNotSupportedException e1) {
								System.out.print("CloneNotSupportedException");
							}
					 }
					 }
				});  
		            Q.setOnMouseEntered(e->{
					GridPane tmplayout=new GridPane();
					Scene tmpscene=new Scene(tmplayout,300,800);
					File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
					Image tmpscimg = new Image(tmpscimg1.toURI().toString());
					
					BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
					Background btmpsc = new Background(tmpscbImg);
					tmplayout.setBackground(btmpsc);
					
					 
					 if(PrimaryStage.getScene()==scene8)
					 { 
						 tmpstage.show();
						 tmpstage.setScene(tmpscene);
						 Label l= new Label();
						 String lead="";
						 if(gg.getAvailableChampions().get(10).equals(first.getLeader()) || gg.getAvailableChampions().get(10).equals(second.getLeader()))
							 lead= "Leader" +"\n";
						 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(10))
						 l.setText(gg.getAvailableChampions().get(10).currentToString()); 
						 else {
							 l.setText(lead+gg.getAvailableChampions().get(10).notToString());
							 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
						 } 
						 tmpstage.getIcons().clear();
						 l.setTextFill(Color.color(1,1, 1));
						 tmpstage.getIcons().add(Qimg);
						 tmplayout.getChildren().add(l);
						 tmpstage.setAlwaysOnTop(true);
					 }});
				Q.setOnMouseExited(e->{
					 if(PrimaryStage.getScene()==scene8)
					 {
						 tmpstage.close();
					 }});
		 
		 
		Button SP = new Button();
		chButtons.add(SP);
		File SPimg1 = new File("GUI/SpiderIcon.jpg");
		Image SPimg = new Image(SPimg1.toURI().toString());
		
		 ImageView SPimv=new ImageView(SPimg);
		 SP.setGraphic(SPimv);
		 SPimv.setFitHeight(100);
		 SPimv.setFitWidth(80);
		 SP.setBackground(null);
		 SP.setTranslateX(130);
		 SP.setTranslateY(290);
		 SP.setOnAction(
				 e->{
					 if(PrimaryStage.getScene()==scene4)
					 {
							 if (first.getTeam().size()>second.getTeam().size())
							 display(second, Game.getAvailableChampions().get(11),SP,"GUI/SpiderIcon.jpg");
							 
							 else if (first.getTeam().size() == second.getTeam().size())
						     display(first, Game.getAvailableChampions().get(11),SP,"GUI/SpiderIcon.jpg");
							 
							 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
								 for (int i=0; i<chButtons.size();i++) {
									 chButtons.get(i).setDisable(true);
								 }
							 }
					 }
					 else if(PrimaryStage.getScene()==scene5)
					 {
						 if(first.getTeam().contains(Game.getAvailableChampions().get(11)))
						 {
							 for(int i=0;i<first.getTeam().size();i++)
							 {
								 if(first.getTeam().get(i)==Game.getAvailableChampions().get(11))
								 first.setLeader(first.getTeam().get(i));
								 for(int j=0;j<Game.getAvailableChampions().size();j++)
								 {
									 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
									 {
										 chButtons.get(j).setDisable(true);
									 }
								 }
							 }
						 }
						 else if(second.getTeam().contains(Game.getAvailableChampions().get(11)))
							 {
							 	for(int i=0;i<second.getTeam().size();i++)
							 {
							 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(11))
							 			second.setLeader(second.getTeam().get(i));
							 		for(int j=0;j<Game.getAvailableChampions().size();j++)
									 {
										 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
										 {
											 chButtons.get(j).setDisable(true);
										 }
									 }
							 }
							 }
					 }
					 else {if(PrimaryStage.getScene()==scene8 && targeted) {
						 targeted=false;
						 try {
							gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(11).getLocation().getX(),(int)Game.getAvailableChampions().get(11).getLocation().getY());
						    if(Game.getAvailableChampions().get(11).getCurrentHP()==0) {
						    	chButtons.get(11).setDisable(true);
						    	chButtons.get(11).setVisible(false);
						    }
						    if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						 } catch (NotEnoughResourcesException e1) {
							 display("Attention","GUI/not enough resources.jpeg");
							
								
							} catch (AbilityUseException e1) {
								display("Attention","GUI/AbilityUseException .jpeg");
								
							} catch (InvalidTargetException e1) {
								display("Attention","GUI/InvalidAttack.jpeg");
								
							} catch (CloneNotSupportedException e1) {
								System.out.print("CloneNotSupportedException");
							}
					 }
					 }
				}); 
		            SP.setOnMouseEntered(e->{
					GridPane tmplayout=new GridPane();
					Scene tmpscene=new Scene(tmplayout,300,800);
					File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
					Image tmpscimg = new Image(tmpscimg1.toURI().toString());
					
					BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
					Background btmpsc = new Background(tmpscbImg);
					tmplayout.setBackground(btmpsc);
					
					 
					 if(PrimaryStage.getScene()==scene8)
					 { 
						 tmpstage.show();
						 tmpstage.setScene(tmpscene);
						 Label l= new Label();
						 String lead="";
						 if(gg.getAvailableChampions().get(11).equals(first.getLeader()) || gg.getAvailableChampions().get(11).equals(second.getLeader()))
							 lead= "Leader" +"\n";
						 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(11))
						 l.setText(gg.getAvailableChampions().get(11).currentToString()); 
						 else {
							 l.setText(lead+gg.getAvailableChampions().get(11).notToString());
							 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
						 }
						 tmpstage.getIcons().clear();
						 tmpstage.getIcons().add(SPimg);
						 l.setTextFill(Color.color(1, 1, 1));
						 tmplayout.getChildren().add(l);
						 tmpstage.setAlwaysOnTop(true);
					 }});
				SP.setOnMouseExited(e->{
					 if(PrimaryStage.getScene()==scene8)
					 {
						 tmpstage.close();
					 }});
		 
		 
		Button TH = new Button();
		chButtons.add(TH);
		File THimg1 = new File("GUI/ThorIcon.png");
		Image THimg = new Image(THimg1.toURI().toString());
		
		 ImageView THimv=new ImageView(THimg);
		 TH.setGraphic(THimv);
		 THimv.setFitHeight(100);
		 THimv.setFitWidth(80);
		 TH.setBackground(null);
		 TH.setTranslateX(230);
		 TH.setTranslateY(290);
		 TH.setOnAction(
				 e->{
					 if(PrimaryStage.getScene()==scene4)
					 {
							 if (first.getTeam().size()>second.getTeam().size())
							 display(second, Game.getAvailableChampions().get(12),TH,"GUI/ThorIcon.png");
							 
							 else if (first.getTeam().size() == second.getTeam().size())
						     display(first, Game.getAvailableChampions().get(12),TH,"GUI/ThorIcon.png");
							
							 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
								 for (int i=0; i<chButtons.size();i++) {
									 chButtons.get(i).setDisable(true);
								 }
							 }
					 }
					 else if(PrimaryStage.getScene()==scene5)
					 {
						 if(first.getTeam().contains(Game.getAvailableChampions().get(12)))
						 {
							 for(int i=0;i<first.getTeam().size();i++)
							 {
								 if(first.getTeam().get(i)==Game.getAvailableChampions().get(12))
								 first.setLeader(first.getTeam().get(i));
								 for(int j=0;j<Game.getAvailableChampions().size();j++)
								 {
									 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
									 {
										 chButtons.get(j).setDisable(true);
									 }
								 }
							 }
						 }
						 else if(second.getTeam().contains(Game.getAvailableChampions().get(12)))
							 {
							 	for(int i=0;i<second.getTeam().size();i++)
							 {
							 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(12))
							 			second.setLeader(second.getTeam().get(i));
							 		for(int j=0;j<Game.getAvailableChampions().size();j++)
									 {
										 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
										 {
											 chButtons.get(j).setDisable(true);
										 }
									 }
							 }
							 }
					 }
					 else {if(PrimaryStage.getScene()==scene8 && targeted) {
						 targeted=false;
						 try {
							gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(12).getLocation().getX(),(int)Game.getAvailableChampions().get(12).getLocation().getY());
						    if(Game.getAvailableChampions().get(12).getCurrentHP()==0) {
						    	chButtons.get(12).setDisable(true);
						    	chButtons.get(12).setVisible(false);
						    }
						    if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						 } catch (NotEnoughResourcesException e1) {
							 display("Attention","GUI/not enough resources.jpeg");
							 
								
							} catch (AbilityUseException e1) {
								display("Attention","GUI/AbilityUseException .jpeg");
								
							} catch (InvalidTargetException e1) {
								display("Attention","GUI/InvalidAttack.jpeg");
								
							} catch (CloneNotSupportedException e1) {
								System.out.print("CloneNotSupportedException");
							}
					 }
					 }
				}); 
		            TH.setOnMouseEntered(e->{
					GridPane tmplayout=new GridPane();
					Scene tmpscene=new Scene(tmplayout,300,800);
					File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
					Image tmpscimg = new Image(tmpscimg1.toURI().toString());
					
					BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
					Background btmpsc = new Background(tmpscbImg);
					tmplayout.setBackground(btmpsc);
					
					 
					 if(PrimaryStage.getScene()==scene8)
					 { 
						 tmpstage.show();
						 tmpstage.setScene(tmpscene);
						 Label l= new Label();
						 String lead="";
						 if(gg.getAvailableChampions().get(12).equals(first.getLeader()) || gg.getAvailableChampions().get(12).equals(second.getLeader()))
							 lead= "Leader" +"\n";
						 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(12))
						 l.setText(gg.getAvailableChampions().get(12).currentToString()); 
						 else {
							 l.setText(lead+gg.getAvailableChampions().get(12).notToString());
							 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
						 }
						 tmpstage.getIcons().clear();
						 tmpstage.getIcons().add(THimg);
						 l.setTextFill(Color.color(1, 1, 1));
						 tmplayout.getChildren().add(l);
						 tmpstage.setAlwaysOnTop(true);
					 }});
				TH.setOnMouseExited(e->{
					 if(PrimaryStage.getScene()==scene8)
					 {
						 tmpstage.close();
					 }});
		 
		 
		Button V = new Button();
		chButtons.add(V);
		File Vimg1 = new File("GUI/VenomIcon.jpg");
		Image Vimg = new Image(Vimg1.toURI().toString());
		
		 ImageView Vimv=new ImageView(Vimg);
		 V.setGraphic(Vimv);
		 Vimv.setFitHeight(100);
		 Vimv.setFitWidth(80);
		 V.setBackground(null);
		 V.setTranslateX(330);
		 V.setTranslateY(290);
		 V.setOnAction(
				 e->{
					 if(PrimaryStage.getScene()==scene4)
					 {
							 if (first.getTeam().size()>second.getTeam().size())
							 display(second, Game.getAvailableChampions().get(13),V,"GUI/VenomIcon.jpg");
							
							 else if (first.getTeam().size() == second.getTeam().size())
						     display(first, Game.getAvailableChampions().get(13),V,"GUI/VenomIcon.jpg");
							 
							 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
								 for (int i=0; i<chButtons.size();i++) {
									 chButtons.get(i).setDisable(true);
								 }
							 }
					 }
					 else if(PrimaryStage.getScene()==scene5)
					 {
						 if(first.getTeam().contains(Game.getAvailableChampions().get(13)))
						 {
							 for(int i=0;i<first.getTeam().size();i++)
							 {
								 if(first.getTeam().get(i)==Game.getAvailableChampions().get(13))
								 first.setLeader(first.getTeam().get(i));
								 for(int j=0;j<Game.getAvailableChampions().size();j++)
								 {
									 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
									 {
										 chButtons.get(j).setDisable(true);
									 }
								 }
							 }
						 }
						 else if(second.getTeam().contains(Game.getAvailableChampions().get(13)))
							 {
							 	for(int i=0;i<second.getTeam().size();i++)
							 {
							 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(13))
							 			second.setLeader(second.getTeam().get(i));
							 		for(int j=0;j<Game.getAvailableChampions().size();j++)
									 {
										 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
										 {
											 chButtons.get(j).setDisable(true);
										 }
									 }
							 }
							 }
					 }
					 else {if(PrimaryStage.getScene()==scene8 && targeted) {
						 targeted=false;
						 try {
							gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(13).getLocation().getX(),(int)Game.getAvailableChampions().get(13).getLocation().getY());
						    if(Game.getAvailableChampions().get(13).getCurrentHP()==0) {
						    	chButtons.get(13).setDisable(true);
						    	chButtons.get(13).setVisible(false);
						    }
						    if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						 } catch (NotEnoughResourcesException e1) {
							 display("Attention","GUI/not enough resources.jpeg");
							 
								
							} catch (AbilityUseException e1) {
								display("Attention","GUI/AbilityUseException .jpeg");
								
							} catch (InvalidTargetException e1) {
								display("Attention","GUI/InvalidAttack.jpeg");
								
							} catch (CloneNotSupportedException e1) {
								System.out.print("CloneNotSupportedException");
							}
					 }
					 }
				}); 
		            V.setOnMouseEntered(e->{
					GridPane tmplayout=new GridPane();
					Scene tmpscene=new Scene(tmplayout,300,800);
					File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
					Image tmpscimg = new Image(tmpscimg1.toURI().toString());
					
					BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
					Background btmpsc = new Background(tmpscbImg);
					tmplayout.setBackground(btmpsc);
					
					 
					 if(PrimaryStage.getScene()==scene8)
					 { 
						 tmpstage.show();
						 tmpstage.setScene(tmpscene);
						 Label l= new Label();
						 String lead="";
						 if(gg.getAvailableChampions().get(13).equals(first.getLeader()) || gg.getAvailableChampions().get(13).equals(second.getLeader()))
							 lead= "Leader" +"\n";
						 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(13))
						 l.setText(gg.getAvailableChampions().get(13).currentToString()); 
						 else {
							 l.setText(lead+gg.getAvailableChampions().get(13).notToString());
							 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
						 }
						 tmpstage.getIcons().clear();
						 tmpstage.getIcons().add(Vimg);
						 l.setTextFill(Color.color(1, 1, 1));
						 tmplayout.getChildren().add(l);
						 tmpstage.setAlwaysOnTop(true);
					 }});
				V.setOnMouseExited(e->{
					 if(PrimaryStage.getScene()==scene8)
					 {
						 tmpstage.close();
					 }});
		 
		 
		Button YJ = new Button();
		chButtons.add(YJ);
		File YJimg1 = new File("GUI/YJIcon.png");
		Image YJimg = new Image(YJimg1.toURI().toString());
		
		 ImageView YJimv=new ImageView(YJimg);
		 YJ.setGraphic(YJimv);
		 YJimv.setFitHeight(100);
		 YJimv.setFitWidth(80);
		 YJ.setBackground(null);
		 YJ.setTranslateX(430);
		 YJ.setTranslateY(290);
		 YJ.setOnAction(
				 e->{
					 if(PrimaryStage.getScene()==scene4)
					 {
							 if (first.getTeam().size()>second.getTeam().size())
							 display(second, Game.getAvailableChampions().get(14),YJ,"GUI/YJIcon.png");
							 
							 else if (first.getTeam().size() == second.getTeam().size())
						     display(first, Game.getAvailableChampions().get(14),YJ,"GUI/YJIcon.png");
							 
							 if (first.getTeam().size()==3 && second.getTeam().size()==3) {
								 for (int i=0; i<chButtons.size();i++) {
									 chButtons.get(i).setDisable(true);
								 }
							 }
					 }
					 else if(PrimaryStage.getScene()==scene5)
					 {
						 if(first.getTeam().contains(Game.getAvailableChampions().get(14)))
						 {
							 for(int i=0;i<first.getTeam().size();i++)
							 {
								 if(first.getTeam().get(i)==Game.getAvailableChampions().get(14))
								 first.setLeader(first.getTeam().get(i));
								 for(int j=0;j<Game.getAvailableChampions().size();j++)
								 {
									 if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
									 {
										 chButtons.get(j).setDisable(true);
									 }
								 }
							 }
						 }
						 else if(second.getTeam().contains(Game.getAvailableChampions().get(14)))
							 {
							 	for(int i=0;i<second.getTeam().size();i++)
							 {
							 		if(second.getTeam().get(i)==Game.getAvailableChampions().get(14))
							 			second.setLeader(second.getTeam().get(i));
							 		for(int j=0;j<Game.getAvailableChampions().size();j++)
									 {
										 if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
										 {
											 chButtons.get(j).setDisable(true);
										 }
									 }
							 }
							 }
					 }
					 else {if(PrimaryStage.getScene()==scene8 && targeted) {
						 targeted=false;
						 try {
							gg.castAbility(targetAbility,(int)Game.getAvailableChampions().get(14).getLocation().getX(),(int)Game.getAvailableChampions().get(14).getLocation().getY());
						    if(Game.getAvailableChampions().get(14).getCurrentHP()==0) {
						    	chButtons.get(14).setDisable(true);
						    	chButtons.get(14).setVisible(false);
						    }
						    if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						 } catch (NotEnoughResourcesException e1) {
							 display("Attention","GUI/not enough resources.jpeg");
							 
								
							} catch (AbilityUseException e1) {
								display("Attention","GUI/AbilityUseException .jpeg");
								
							} catch (InvalidTargetException e1) {
								display("Attention","GUI/InvalidAttack.jpeg");
								
							} catch (CloneNotSupportedException e1) {
								System.out.print("CloneNotSupportedException");
							}
					 }
					 }
				}); 
		            YJ.setOnMouseEntered(e->{
					GridPane tmplayout=new GridPane();
					Scene tmpscene=new Scene(tmplayout,300,800);
					File tmpscimg1 = new File("GUI/propertiesBg 2.jpg");
					Image tmpscimg = new Image(tmpscimg1.toURI().toString());
					
					BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
					Background btmpsc = new Background(tmpscbImg);
					tmplayout.setBackground(btmpsc);
					
					 if(PrimaryStage.getScene()==scene8)
					 { 
						 tmpstage.show();
						 tmpstage.setScene(tmpscene);
						 Label l= new Label();
						 String lead="";
						 if(gg.getAvailableChampions().get(14).equals(first.getLeader()) || gg.getAvailableChampions().get(14).equals(second.getLeader()))
							 lead= "Leader" +"\n";
						 if(gg.getCurrentChampion()==gg.getAvailableChampions().get(14))
						 l.setText(gg.getAvailableChampions().get(14).currentToString()); 
						 else {
							 l.setText(lead+gg.getAvailableChampions().get(14).notToString());
							 l.setFont(Font.font("Verdana",FontWeight.BOLD,20));
						 } 
						 tmpstage.getIcons().clear();
						 tmpstage.getIcons().add(YJimg);
						 l.setTextFill(Color.color(1, 1, 1));
						 tmplayout.getChildren().add(l);
						 tmpstage.setAlwaysOnTop(true);
					 }});
				YJ.setOnMouseExited(e->{
					 if(PrimaryStage.getScene()==scene8)
					 {
						 tmpstage.close();
					 }});
		 		 
				File ViewTurnimg1 = new File("GUI/ViewTurns.png");
				Image ViewTurnimg = new Image(ViewTurnimg1.toURI().toString());
				
				ImageView ViewTurnview=new ImageView(ViewTurnimg);
				ViewTurnview.setFitHeight(80);
				ViewTurnview.setFitWidth(80);
				
				Button ViewTurn=new Button();
				ViewTurn.setBackground(null);
				ViewTurn.setTranslateX(670);
				ViewTurn.setTranslateY(-15);
				
				    ViewTurn.setOnMouseEntered(e->{
		       	 	GridPane tmplayout=new GridPane();
		    		Scene tmpscene=new Scene(tmplayout,300,400);
		    		File tmpscimg1 = new File("GUI/propertiesBg 3.jpg");
					Image tmpscimg = new Image(tmpscimg1.toURI().toString());
		    		
		    		BackgroundImage tmpscbImg = new BackgroundImage(tmpscimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
		    		Background btmpsc = new Background(tmpscbImg);
		    		tmplayout.setBackground(btmpsc);
		    		String order="";
		    		
		    		 if(PrimaryStage.getScene()==scene8)
					 { 
						 tmpstage.show();
						 tmpstage.setScene(tmpscene);
						 Label l=new Label();
						 for(int i=0;i<ordername.size();i++) {
							 order+=(i+1)+". ";
							 for (int j=0;j<first.getTeam().size();j++ ) {
								 if(first.getTeam().get(j).getName().equals(ordername.get(i)))
								 {
									 order+= p1.getText() +"'s: "+"\n";
									 break;
								 }
							 }
								 for(int k=0;k<second.getTeam().size();k++) {
									 if(second.getTeam().get(k).getName().equals(ordername.get(i))) 
									 {
										 order+= p2.getText() +"'s: "+"\n";
										 break;
									 }
								 }
							 
							 order+=ordername.get(i)+"\n"+"\n";
						 }
						 l.setText(order);
						 tmpstage.getIcons().clear();
						 tmpstage.getIcons().add(icon);
						 l.setTextFill(Color.color(1, 1, 1));
						 l.setFont(new Font("Verdana",15));
						 l.setTranslateX(20);
						 l.setTranslateY(50);
						 tmplayout.getChildren().add(l);
						 tmpstage.setAlwaysOnTop(true);
					 }});
				    ViewTurn.setOnMouseExited(e->{
					 if(PrimaryStage.getScene()==scene8)
					 {
						 tmpstage.close();
					 }});
	     File menu1 = new File("GUI/backbgscene4.jpeg");
		 Image menu = new Image(menu1.toURI().toString());
		
			BackgroundImage bgmenu = new BackgroundImage(menu, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
			Background bGroundmenu = new Background(bgmenu);
			layout4.setBackground(bGroundmenu);
			
			Button changename=new Button();
			changename.setOnAction(e->PrimaryStage.setScene(scene3));
			File changeimg1 = new File("GUI/change names.png");
			 Image changeimg = new Image(changeimg1.toURI().toString());
			
			ImageView changeimv=new ImageView(changeimg);
			changeimv.setFitHeight(110);
			changeimv.setFitWidth(120);
			changename.setGraphic(changeimv);
			changename.setBackground(null);
			changename.setTranslateX(100);
			changename.setTranslateY(420);

			Button ready=new Button();
			ready.setTranslateX(320);
			ready.setTranslateY(420);
			ready.setOnAction(
					e->{if(first.getTeam().size()==3 && second.getTeam().size()==3) {
						PrimaryStage.setScene(scene5);
						for(int i=0;i<first.getTeam().size();i++)
						{
							for(int j=0;j<Game.getAvailableChampions().size();j++)
							{
								if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
								{
									layout5.getChildren().addAll(chButtons.get(j));
									chButtons.get(j).setDisable(false);
									if(i==0)
									{
									chButtons.get(j).setTranslateY(120);
									chButtons.get(j).setTranslateX(470);
									}
									else if(i==1)
									{
									chButtons.get(j).setTranslateY(120);
									chButtons.get(j).setTranslateX(570);
									}
									else if(i==2)
									{
									chButtons.get(j).setTranslateY(120);
									chButtons.get(j).setTranslateX(670);
									}
								}
							}
						}
						for(int i=0;i<second.getTeam().size();i++)
						{
							for(int j=0;j<Game.getAvailableChampions().size();j++)
							{
								if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
								{
									layout5.getChildren().addAll(chButtons.get(j));
									chButtons.get(j).setDisable(false);
									if(i==0)
									{
									chButtons.get(j).setTranslateY(380);
									chButtons.get(j).setTranslateX(50);
									}
									else if(i==1)
									{
									chButtons.get(j).setTranslateY(380);
									chButtons.get(j).setTranslateX(150);
									}
									else if(i==2)
									{
									chButtons.get(j).setTranslateY(380);
									chButtons.get(j).setTranslateX(250);
									}
								}
							}
						}
						p1.setText(tf1.getText());
						p1.setFont(new Font("Verdana",50));
						p1.setTranslateX(50);
						p1.setTranslateY(120);
						p2.setText(tf2.getText());
						p2.setFont(new Font("Verdana",50));
						p2.setTranslateX(530);
						p2.setTranslateY(380);
						p1.setTextFill(Color.color(1, 1, 1));
						p2.setTextFill(Color.color(1, 1, 1));
						p1.setAlignment(Pos.CENTER);
						p2.setAlignment(Pos.CENTER);
						if(tf1.getText().length()>8) {
							p1.setText(tf1.getText().substring(0, 8));
						}
						if(tf2.getText().length()>8) {
							p2.setText(tf2.getText().substring(0, 8));
						}
						layout5.getChildren().addAll(p1,p2);
						
					}
					else 
						display("ATTENTION!","GUI/backbgproperties.jpeg");
					
					});
			
			File readyimg1 = new File("GUI/Next.png");
			 Image readyimg = new Image(readyimg1.toURI().toString());
			
			ImageView readyview=new ImageView(readyimg);
			readyview.setFitHeight(110);
			readyview.setFitWidth(120);
			ready.setGraphic(readyview);
			ready.setBackground(null);
			
			
			Button Assemble=new Button();
			File AssemImg1 = new File("GUI/AssembleButton.png");
			 Image AssemImg = new Image(AssemImg1.toURI().toString());
			
			ImageView AssemView=new ImageView(AssemImg);
			Assemble.setGraphic(AssemView);
			AssemView.setFitHeight(120);
			AssemView.setFitWidth(140);
			Assemble.setBackground(null);
			Assemble.setTranslateX(320);
			Assemble.setTranslateY(240);
			
			
			
			Assemble.setOnAction(e->{
				gg.placeChampions();
				String f=null;
				
				if(first.getLeader()!=null&&second.getLeader()!=null)
				{
				boardPlayer.stop();
				PrimaryStage.setScene(scene6);
				for (Champion c : first.getTeam())
					gg.getTurnOrder().insert(c);
				for (Champion c : second.getTeam())
					gg.getTurnOrder().insert(c);
				
				for(int i=0;i<first.getTeam().size();i++)
				{
					for(int j=0;j<Game.getAvailableChampions().size();j++)
					{
						if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
						{
							layout6.getChildren().addAll(chButtons.get(j));
							chButtons.get(j).setDisable(false);
							if(i==0)
							{
								chButtons.get(j).setTranslateX(50);
								chButtons.get(j).setTranslateY(0);
							}
							else if(i==1)
							{
								chButtons.get(j).setTranslateX(50);
								chButtons.get(j).setTranslateY(100);
							}
							else if(i==2)
							{
								chButtons.get(j).setTranslateX(50);
								chButtons.get(j).setTranslateY(200);
							}
						}
					}
				}
				for(int i=0;i<second.getTeam().size();i++)
				{
					for(int j=0;j<Game.getAvailableChampions().size();j++)
					{
						if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
						{
							layout6.getChildren().addAll(chButtons.get(j));
							chButtons.get(j).setDisable(false);
							if(i==0)
							{
							chButtons.get(j).setTranslateX(650);
							chButtons.get(j).setTranslateY(0);
							}
							else if(i==1)
							{
							chButtons.get(j).setTranslateX(650);
							chButtons.get(j).setTranslateY(100);
							}
							else if(i==2)
							{
								chButtons.get(j).setTranslateX(650);
								chButtons.get(j).setTranslateY(200);
							}
						}
					}
				}
				
				
				
				p1.setFont(new Font("Verdana",40));
				p1.setTranslateX(20);
				p1.setTranslateY(-120);
				
				p2.setFont(new Font("Verdana",40));
				p2.setTranslateX(610);
				p2.setTranslateY(-120);
				p1.setTextFill(Color.color(1, 1, 1));
				p2.setTextFill(Color.color(1, 1, 1));
				p1.setAlignment(Pos.CENTER);
				p2.setAlignment(Pos.CENTER);
				layout6.getChildren().addAll(p1,p2,pressE,thunderview);
				thunderPlayer.setAutoPlay(true);
				for (int j=0;j<first.getTeam().size();j++) {
					chosen.add(first.getTeam().get(j));
				}
				for (int j=0;j<second.getTeam().size();j++) {
					chosen.add(second.getTeam().get(j));
				}
				PriorityQueue temp=new PriorityQueue(6);
				while(!gg.getTurnOrder().isEmpty())
				{
					f=((Champion)(gg.getTurnOrder().peekMin())).getName();
					ordername.add(f);
					temp.insert(gg.getTurnOrder().remove());
					
				}
				while(!temp.isEmpty())
				{
					gg.getTurnOrder().insert(temp.remove());
				}

				}
				else 
					display("ATTENTION!","GUI/Attentionleader.jpeg");
				
			});
			layout5.getChildren().addAll(Assemble);
			
			Button skipvs=new Button();
			skipvs.setBackground(null);
			skipvs.setMinWidth(0);
			skipvs.setMaxWidth(700);
			skipvs.setMaxHeight(400);
			skipvs.setMinHeight(400);
			skipvs.setPrefWidth(640);
			skipvs.setPrefHeight(360);
			
			File file2=new File("GUI/Avengers Endgame _ 'Avengers Assemble' Scenes - IMAX 4K_Trim.mp4");
			
			Media thanossnap = new Media(file2.toURI().toString()); 
			MediaPlayer thanosPlayer = new MediaPlayer(thanossnap);
			
			skipvs.setOnAction(e->
			{
				PrimaryStage.setScene(scene7);
				thunderPlayer.stop();
		    	thanosPlayer.setAutoPlay(true);
				MediaView thanossnapView = new MediaView (thanosPlayer);
				layout7.getChildren().addAll(thanossnapView,press);
			});
			File vsimg1 = new File("GUI/versus.jpeg");
		    Image vsimg = new Image(vsimg1.toURI().toString());
			
			BackgroundImage vsview=new BackgroundImage(vsimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
			Background vsbg=new Background(vsview);
			layout6.setBackground(vsbg);
			
			
			layout6.getChildren().addAll(skipvs);
			
			Label chCurrent=new Label();
			chCurrent.setTranslateX(650);
			chCurrent.setTranslateY(-80);
			chCurrent.setFont(Font.font("Verdana",FontWeight.BOLD,12));
			chCurrent.setTextFill(Color.color(1, 1, 1));
			
			Label chnext=new Label();
			chnext.setTranslateX(650);
			chnext.setTranslateY(45);
			chnext.setFont(Font.font("Verdana",FontWeight.BOLD,12));
			chnext.setTextFill(Color.color(1, 1, 1));
			
			Button skipthanos=new Button();
			skipthanos.setBackground(null);
			skipthanos.setMinWidth(0);
			skipthanos.setMaxWidth(800);
			skipthanos.setMaxHeight(529);
			skipthanos.setMinHeight(0);
			skipthanos.setPrefWidth(800);
			skipthanos.setPrefHeight(529);
			skipthanos.setOnAction(e->
			{
				PrimaryStage.setScene(scene8);
				GOWPlayer.setAutoPlay(true);
				thanosPlayer.stop();
				CA.setGraphic(CAview);
				DP.setGraphic(DPview);
				DS.setGraphic(DSview);
				E.setGraphic(Eview);
				GR.setGraphic(GRview);
				HE.setGraphic(Helaview);
				HU.setGraphic(Hulkview);
				IC.setGraphic(IMview);
				IR.setGraphic(IRview);
				L.setGraphic(Lview);
				Q.setGraphic(QSview);
				SP.setGraphic(zbidrview);
				TH.setGraphic(TOview);
				V.setGraphic(Vview);
				YJ.setGraphic(YJview);
				ViewTurn.setGraphic(ViewTurnview);
				for(int i=0;i<first.getTeam().size();i++)
				{
					for(int j=0;j<Game.getAvailableChampions().size();j++)
					{
						if(first.getTeam().get(i)==Game.getAvailableChampions().get(j))
						{
							layout8.getChildren().addAll(chButtons.get(j));
							chButtons.get(j).setDisable(false);
							if(i==0)
							{
							chButtons.get(j).setTranslateY(290);
							chButtons.get(j).setTranslateX(140);
							}
							else if(i==1)
							{
							chButtons.get(j).setTranslateY(290);
							chButtons.get(j).setTranslateX(260);
							}
							else if(i==2)
							{
							chButtons.get(j).setTranslateY(290);
							chButtons.get(j).setTranslateX(390);
							}
						}
					}
				}
				for(int i=0;i<second.getTeam().size();i++)
				{
					for(int j=0;j<Game.getAvailableChampions().size();j++)
					{
						if(second.getTeam().get(i)==Game.getAvailableChampions().get(j))
						{
							layout8.getChildren().addAll(chButtons.get(j));
							chButtons.get(j).setDisable(false);
							if(i==0)
							{
							chButtons.get(j).setTranslateY(-125);
							chButtons.get(j).setTranslateX(140);
							}
							else if(i==1)
							{
							chButtons.get(j).setTranslateY(-125);
							chButtons.get(j).setTranslateX(260);
							}
							else if(i==2)
							{
							chButtons.get(j).setTranslateY(-125);
							chButtons.get(j).setTranslateX(390);
							}
						}
					}
				}
				
				if (first.getTeam().contains(gg.getTurnOrder().peekMin())) {
					String c= "Current Champion "+"\n"+p1.getText()+"'s: "+"\n"+((Champion)(gg.getTurnOrder().peekMin())).getName();
					chCurrent.setText(c);
					
					for(int k=0;k<gg.getTurnOrder().size();k++)
					{
						
					if(gg.getTurnOrder().size()!=1)
					{
					orderch.add((Champion)(gg.getTurnOrder().peekMin()));
					gg.getTurnOrder().remove();
					while(!gg.getTurnOrder().isEmpty()&&((Champion)(gg.getTurnOrder().peekMin())).getCondition()==Condition.INACTIVE)
					{
						orderch.add((Champion)gg.getTurnOrder().remove());
						
					}
					if(gg.getTurnOrder().isEmpty())
					{
						chnext.setText("A Whole Turn Has Ended");
						for(int w=0;!orderch.isEmpty();w++)
						{
							gg.getTurnOrder().insert(orderch.remove(w));
							w--;
						}
						break;
					}
					if (first.getTeam().contains(gg.getTurnOrder().peekMin())) {
						String n= "Next Champion "+"\n"+p1.getText()+"'s: "+"\n"+((Champion)(gg.getTurnOrder().peekMin())).getName();
						chnext.setText(n);
						}
					else {
						String n= "Next Champion "+"\n"+p2.getText()+"'s: "+"\n"+((Champion)(gg.getTurnOrder().peekMin())).getName();
						chnext.setText(n);
					}
					for(int w=0;!orderch.isEmpty();w++)
					{
						gg.getTurnOrder().insert(orderch.remove(w));
						w--;
					}
					}
					else
					{
						chnext.setText("A Whole Turn Has Ended");
						break;
					}
					
					}
					
					
					
				}
				else {
					String c= "Current Champion "+"\n"+p2.getText()+"'s: "+"\n"+((Champion)(gg.getTurnOrder().peekMin())).getName();
					chCurrent.setText(c);
					
					
					for(int k=0;k<gg.getTurnOrder().size();k++)
					{
						
					if(gg.getTurnOrder().size()!=1)
					{
					orderch.add((Champion)(gg.getTurnOrder().peekMin()));
					gg.getTurnOrder().remove();
					while(!gg.getTurnOrder().isEmpty()&&((Champion)(gg.getTurnOrder().peekMin())).getCondition()==Condition.INACTIVE)
					{
						orderch.add((Champion)gg.getTurnOrder().remove());
						
					}
					if(gg.getTurnOrder().isEmpty())
					{
						chnext.setText("A Whole Turn Has Ended");
						for(int w=0;!orderch.isEmpty();w++)
						{
							gg.getTurnOrder().insert(orderch.remove(w));
							w--;
						}
						break;
					}
					if (first.getTeam().contains(gg.getTurnOrder().peekMin())) {
						String n= "Next Champion "+"\n"+p1.getText()+"'s: "+"\n"+((Champion)(gg.getTurnOrder().peekMin())).getName();
						chnext.setText(n);
						}
					else {
						String n= "Next Champion "+"\n"+p2.getText()+"'s: "+"\n"+((Champion)(gg.getTurnOrder().peekMin())).getName();
						chnext.setText(n);
					}
					for(int w=0;!orderch.isEmpty();w++)
					{
						gg.getTurnOrder().insert(orderch.remove(w));
						w--;
					}
					}
					else
					{
						chnext.setText("A Whole Turn Has Ended");
						break;
					}
					
					}
				}
			});
			
			layout7.getChildren().addAll(skipthanos);
			
			File boardimg1 = new File("GUI/Board.jpeg");
		    Image boardimg = new Image(boardimg1.toURI().toString());
			
			BackgroundImage boardview = new BackgroundImage(boardimg, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
			Background boardbg = new Background(boardview);
			layout8.setBackground(boardbg);
			
			
			File menublur1 = new File("GUI/Leaderpick.jpeg");
		    Image menublur = new Image(menublur1.toURI().toString());
			
			BackgroundImage blurimg = new BackgroundImage(menublur, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
			Background blurbg = new Background(blurimg);
			layout5.setBackground(blurbg);
			
			
		layout4.getChildren().addAll(CA,DP,DS,E,GR,HE,HU,IC,IR,L,Q,SP,TH,V,YJ,changename,ready); 
		

		
		layout3.getChildren().addAll(tf1,tf2,backscene3,nextscene3,instructButton);
		
		File endimg1 = new File("GUI/endturn.png");
	    Image endimg = new Image(endimg1.toURI().toString());
		
		ImageView endview=new ImageView(endimg);
		endview.setFitHeight(70);
		endview.setFitWidth(90);

		Button endturn=new Button();
		endturn.setGraphic(endview);
		
		endturn.setBackground(null);
		endturn.setTranslateX(670);
		endturn.setTranslateY(150);
		endturn.setOnAction(e->{
			for(int i =0; i<gg.getCurrentChampion().getAppliedEffects().size();i++) {
				if(gg.getCurrentChampion().getAppliedEffects().get(i) instanceof Disarm) {
					A4.setVisible(false);
					A4.setDisable(true);
					break;
				}
			}
			gg.endTurn();
			for(int i =0; i<gg.getCurrentChampion().getAppliedEffects().size();i++) {
				if(gg.getCurrentChampion().getAppliedEffects().get(i) instanceof Disarm) {
					A4.setVisible(true);
					A4.setDisable(false);
					break;
				}
			}
			if (first.getTeam().contains(gg.getTurnOrder().peekMin())) {
				String c= "Current Champion "+"\n"+p1.getText()+"'s: "+"\n"+((Champion)(gg.getTurnOrder().peekMin())).getName();
				chCurrent.setText(c);
				
				for(int k=0;k<gg.getTurnOrder().size();k++)
				{
					
				if(gg.getTurnOrder().size()!=1)
				{
				orderch.add((Champion)(gg.getTurnOrder().peekMin()));
				gg.getTurnOrder().remove();
				while(!gg.getTurnOrder().isEmpty()&&((Champion)(gg.getTurnOrder().peekMin())).getCondition()==Condition.INACTIVE)
				{
					orderch.add((Champion)gg.getTurnOrder().remove());
					
				}
				if(gg.getTurnOrder().isEmpty())
				{
					chnext.setText("A Whole Turn Has Ended");
					for(int w=0;!orderch.isEmpty();w++)
					{
						gg.getTurnOrder().insert(orderch.remove(w));
						w--;
					}
					break;
				}
				if (first.getTeam().contains(gg.getTurnOrder().peekMin())) {
					String n= "Next Champion "+"\n"+p1.getText()+"'s: "+"\n"+((Champion)(gg.getTurnOrder().peekMin())).getName();
					chnext.setText(n);
					}
				else {
					String n= "Next Champion "+"\n"+p2.getText()+"'s: "+"\n"+((Champion)(gg.getTurnOrder().peekMin())).getName();
					chnext.setText(n);
				}
				for(int w=0;!orderch.isEmpty();w++)
				{
					gg.getTurnOrder().insert(orderch.remove(w));
					w--;
				}
				}
				else
				{
					chnext.setText("A Whole Turn Has Ended");
					break;
				}
				
				}
				
				
				
			}
			else {
				String c= "Current Champion "+"\n"+p2.getText()+"'s: "+"\n"+((Champion)(gg.getTurnOrder().peekMin())).getName();
				chCurrent.setText(c);
				
				
				for(int k=0;k<gg.getTurnOrder().size();k++)
				{
					
				if(gg.getTurnOrder().size()!=1)
				{
				orderch.add((Champion)(gg.getTurnOrder().peekMin()));
				gg.getTurnOrder().remove();
				while(!gg.getTurnOrder().isEmpty()&&((Champion)(gg.getTurnOrder().peekMin())).getCondition()==Condition.INACTIVE)
				{
					orderch.add((Champion)gg.getTurnOrder().remove());
					
				}
				if(gg.getTurnOrder().isEmpty())
				{
					chnext.setText("A Whole Turn Has Ended");
					for(int w=0;!orderch.isEmpty();w++)
					{
						gg.getTurnOrder().insert(orderch.remove(w));
						w--;
					}
					break;
				}
				if (first.getTeam().contains(gg.getTurnOrder().peekMin())) {
					String n= "Next Champion "+"\n"+p1.getText()+"'s: "+"\n"+((Champion)(gg.getTurnOrder().peekMin())).getName();
					chnext.setText(n);
					}
				else {
					String n= "Next Champion "+"\n"+p2.getText()+"'s: "+"\n"+((Champion)(gg.getTurnOrder().peekMin())).getName();
					chnext.setText(n);
				}
				for(int w=0;!orderch.isEmpty();w++)
				{
					gg.getTurnOrder().insert(orderch.remove(w));
					w--;
				}
				}
				else
				{
					chnext.setText("A Whole Turn Has Ended");
					break;
				}
				
				}
			}
			});
		
		Button Ability1= new Button();
		File a11 = new File("GUI/Ability 1.png");
	    Image a1 = new Image(a11.toURI().toString());
		
		ImageView a1v= new ImageView(a1);
		a1v.setFitHeight(70);
		a1v.setFitWidth(80);
		Ability1.setGraphic(a1v);
		Ability1.setBackground(null);
		Ability1.setTranslateX(632);
		Ability1.setTranslateY(320);
		
		Ability1.setOnAction(e->{
			 if(gg.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.SELFTARGET || 
					 gg.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.TEAMTARGET || 
					 gg.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.SURROUND) {
				 try {
					gg.castAbility(gg.getCurrentChampion().getAbilities().get(0));
					for(int i=0; i<chosen.size();i++) {
						if(chosen.get(i).getCurrentHP()==0) {
							for(int j=0;j<Game.getAvailableChampions().size();j++) {
								if(chosen.get(i).getName().equals(Game.getAvailableChampions().get(j).getName())) {
									chButtons.get(j).setDisable(true);
									chButtons.get(j).setVisible(false);
								}
							}
						}
					}
					for(int i=0; i<covers.size(); i++) {
						if(covers.get(i).getCurrentHP()==0) {
							coverButtons.get(i).setDisable(true);
							coverButtons.get(i).setVisible(false);
						}
					}
					if(gg.checkGameOver()!=null)
					{
						PrimaryStage.setScene(scene9);GOWPlayer.stop();
						
						
						
						MediaView iammediaview=new MediaView(iammediaplayer);
						layout9.getChildren().addAll(iammediaview);
						iammediaplayer.setAutoPlay(true);
					}
				} catch (NotEnoughResourcesException e1) {
					display("Attention","GUI/not enough resources.jpeg");
					
				} catch (AbilityUseException e1) {
					display("Attention","GUI/AbilityUseException .jpeg");
					
				} catch (CloneNotSupportedException e1) {
					System.out.print("CloneNotSupportedException");
				} 
			 }
			 else { if(gg.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.DIRECTIONAL) {
				 ability=true;
				 able=gg.getCurrentChampion().getAbilities().get(0);
			 }
			 else {if(gg.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.SINGLETARGET) {
				 targeted=true;
				 targetAbility=gg.getCurrentChampion().getAbilities().get(0);
			   }
			 }
			 }
		});
		
		Button Ability2= new Button();
		File a21 = new File("GUI/Ability 2.png");
	    Image a2 = new Image(a21.toURI().toString());
		
		ImageView a2v= new ImageView(a2);
		a2v.setFitHeight(70);
		a2v.setFitWidth(80);
		Ability2.setGraphic(a2v);
		Ability2.setBackground(null);
		Ability2.setTranslateX(650);
		Ability2.setTranslateY(255);
		
		Ability2.setOnAction(e->{
			 if(gg.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.SELFTARGET || 
					 gg.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.TEAMTARGET ||
					 gg.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.SURROUND) {
				 try {
					gg.castAbility(gg.getCurrentChampion().getAbilities().get(1));
					for(int i=0; i<chosen.size();i++) {
						if(chosen.get(i).getCurrentHP()==0) {
							for(int j=0;j<Game.getAvailableChampions().size();j++) {
								if(chosen.get(i).getName().equals(Game.getAvailableChampions().get(j).getName())) {
									chButtons.get(j).setDisable(true);
									chButtons.get(j).setVisible(false);
								}
							}
						}
					}
					for(int i=0; i<covers.size(); i++) {
						if(covers.get(i).getCurrentHP()==0) {
							coverButtons.get(i).setDisable(true);
							coverButtons.get(i).setVisible(false);
						}
					}
					if(gg.checkGameOver()!=null)
					{
						PrimaryStage.setScene(scene9);GOWPlayer.stop();
						
						
						
						MediaView iammediaview=new MediaView(iammediaplayer);
						layout9.getChildren().addAll(iammediaview);
						iammediaplayer.setAutoPlay(true);
					}
				}catch (NotEnoughResourcesException e1) {
					display("Attention","GUI/not enough resources.jpeg");
					
				} catch (AbilityUseException e1) {
					display("Attention","GUI/AbilityUseException .jpeg");
					
				} catch (CloneNotSupportedException e1) {
					System.out.print("CloneNotSupportedException");
				} 
			 }
			 else { if(gg.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.DIRECTIONAL) {
				 ability=true;
				 able=gg.getCurrentChampion().getAbilities().get(1);
			 }
			 else {if(gg.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.SINGLETARGET) {
				 targeted=true;
				 targetAbility=gg.getCurrentChampion().getAbilities().get(1);
			   }
			 }
			 }
		});
		
		Button Ability3= new Button();
		File a31 = new File("GUI/Ability 3.png");
	    Image a3 = new Image(a31.toURI().toString());
		
		ImageView a3v= new ImageView(a3);
		a3v.setFitHeight(70);
		a3v.setFitWidth(80);
		Ability3.setGraphic(a3v);
		Ability3.setBackground(null);
		Ability3.setTranslateX(710);
		Ability3.setTranslateY(220);
		
		Ability3.setOnAction(e->{
			 if(gg.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.SELFTARGET ||
					 gg.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.TEAMTARGET || 
					 gg.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.SURROUND) {
				 try {
					gg.castAbility(gg.getCurrentChampion().getAbilities().get(2));
					for(int i=0; i<chosen.size();i++) {
						if(chosen.get(i).getCurrentHP()==0) {
							for(int j=0;j<Game.getAvailableChampions().size();j++) {
								if(chosen.get(i).getName().equals(Game.getAvailableChampions().get(j).getName())) {
									chButtons.get(j).setDisable(true);
									chButtons.get(j).setVisible(false);
								}
							}
						}
					}
					for(int i=0; i<covers.size(); i++) {
						if(covers.get(i).getCurrentHP()==0) {
							coverButtons.get(i).setDisable(true);
							coverButtons.get(i).setVisible(false);
						}
					}
					if(gg.checkGameOver()!=null)
					{
						PrimaryStage.setScene(scene9);GOWPlayer.stop();
						
						
						
						MediaView iammediaview=new MediaView(iammediaplayer);
						layout9.getChildren().addAll(iammediaview);
						iammediaplayer.setAutoPlay(true);
					}
				} catch (NotEnoughResourcesException e1) {
					display("Attention","GUI/not enough resources.jpeg");
					
				} catch (AbilityUseException e1) {
					display("Attention","GUI/AbilityUseException .jpeg");
					
				} catch (CloneNotSupportedException e1) {
					System.out.print("CloneNotSupportedException");
				} 
			 }
			 else { if(gg.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.DIRECTIONAL) {
				 ability=true;
				 able=gg.getCurrentChampion().getAbilities().get(2);
			 }
			 else {if(gg.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.SINGLETARGET) {
				 targeted=true;
				 targetAbility=gg.getCurrentChampion().getAbilities().get(2);
			   }
			 }
			 }
		});
		
		
		Button leaderAbility= new Button();
		File leader1 = new File("GUI/LeaderAbilityButton.png");
	    Image leader = new Image(leader1.toURI().toString());
		
		ImageView leaderView= new ImageView(leader);
		leaderView.setFitHeight(90);
		leaderView.setFitWidth(80);
		leaderAbility.setGraphic(leaderView);
		leaderAbility.setBackground(null);
		leaderAbility.setTranslateX(710);
		leaderAbility.setTranslateY(300);
		leaderAbility.setOnAction(e->{
			try {
				gg.useLeaderAbility();
				for(int i=0; i<chosen.size();i++) {
					if(chosen.get(i).getCurrentHP()==0) {
						for(int j=0;j<Game.getAvailableChampions().size();j++) {
							if(chosen.get(i).getName().equals(Game.getAvailableChampions().get(j).getName())) {
								chButtons.get(j).setDisable(true);
								chButtons.get(j).setVisible(false);
							}
						}
					}
				}
				if(gg.getTurnOrder().isEmpty())
				{
					for(int i=0;i<gg.getFirstPlayer().getTeam().size();i++)
					{
						gg.getTurnOrder().insert(gg.getFirstPlayer().getTeam().get(i));
					}
					for(int i=0;i<gg.getSecondPlayer().getTeam().size();i++)
					{
						gg.getTurnOrder().insert(gg.getSecondPlayer().getTeam().get(i));
					}
				}
				for(int k=0;k<gg.getTurnOrder().size();k++)
				{
					
				if(gg.getTurnOrder().size()!=1)
				{
				orderch.add((Champion)(gg.getTurnOrder().peekMin()));
				gg.getTurnOrder().remove();
				while(!gg.getTurnOrder().isEmpty()&&((Champion)(gg.getTurnOrder().peekMin())).getCondition()==Condition.INACTIVE)
				{
					orderch.add((Champion)gg.getTurnOrder().remove());
					
				}
				if(gg.getTurnOrder().isEmpty())
				{
					chnext.setText("A Whole Turn Has Ended");
					for(int w=0;!orderch.isEmpty();w++)
					{
						gg.getTurnOrder().insert(orderch.remove(w));
						w--;
					}
					break;
				}
				if (first.getTeam().contains(gg.getTurnOrder().peekMin())) {
					String n= "Next Champion "+"\n"+p1.getText()+"'s: "+"\n"+((Champion)(gg.getTurnOrder().peekMin())).getName();
					chnext.setText(n);
					}
				else {
					String n= "Next Champion "+"\n"+p2.getText()+"'s: "+"\n"+((Champion)(gg.getTurnOrder().peekMin())).getName();
					chnext.setText(n);
				}
				for(int w=0;!orderch.isEmpty();w++)
				{
					gg.getTurnOrder().insert(orderch.remove(w));
					w--;
				}
				}
				else
				{
					chnext.setText("A Whole Turn Has Ended");
					break;
				}
				
				}
				if(gg.checkGameOver()!=null)
				{
					PrimaryStage.setScene(scene9);GOWPlayer.stop();
					
					
					
					MediaView iammediaview=new MediaView(iammediaplayer);
					layout9.getChildren().addAll(iammediaview);
					iammediaplayer.setAutoPlay(true);
				}
			} catch (LeaderNotCurrentException e1) {
				display("Attention","GUI/NotCurrentLeader.jpeg");
				
			} catch (LeaderAbilityAlreadyUsedException e1) {
				display("Attention","GUI/LeaderAbilityAlreadyUsed.jpeg");
				
			}});
		
		
		
		
		layout8.getChildren().addAll(firstview,chnext,chCurrent,GOWview,endturn,ViewTurn,leaderAbility,Ability1,Ability2,Ability3,A4);
		
		scene8.setOnKeyPressed(event-> {
				//switch(event.getCode()) {
				if (event.getCode()== KeyCode.NUMPAD5	) {
					try {
						gg.move(Direction.UP);
							for(int j=0;j<gg.getAvailableChampions().size();j++)
							{
								if(gg.getCurrentChampion().getName()==gg.getAvailableChampions().get(j).getName())
								{
									chButtons.get(j).setTranslateY(chButtons.get(j).getTranslateY()-103.75);
									break;
								}
							}
						
					}
					catch (NotEnoughResourcesException e1) {
						display("Attention","GUI/not enough resources.jpeg");
						
					} catch (UnallowedMovementException e1) {
						display("Attention","GUI/MovementUnallowed .jpeg");
						
					}
				}
				if (event.getCode()== KeyCode.NUMPAD2) {
					try {
						gg.move(Direction.DOWN);
						
							for(int j=0;j<gg.getAvailableChampions().size();j++)
							{
								if(gg.getCurrentChampion().getName()==gg.getAvailableChampions().get(j).getName())
								{
									chButtons.get(j).setTranslateY(chButtons.get(j).getTranslateY()+103.75);
									break;
								}
							}
						
					} catch (NotEnoughResourcesException e1) {
						display("Attention","GUI/not enough resources.jpeg");
						
					} catch (UnallowedMovementException e1) {
						display("Attention","GUI/MovementUnallowed .jpeg");
						
					}
					}
				if (event.getCode()== KeyCode.NUMPAD1) {
					try {
						gg.move(Direction.LEFT);
						
							for(int j=0;j<gg.getAvailableChampions().size();j++)
							{
								if(gg.getCurrentChampion().getName()==gg.getAvailableChampions().get(j).getName())
								{
									chButtons.get(j).setTranslateX(chButtons.get(j).getTranslateX()-132.5);
									break;
								}
							}
						
					}
					catch (NotEnoughResourcesException e1) {
						display("Attention","GUI/not enough resources.jpeg");
						
					} catch (UnallowedMovementException e1) {
						display("Attention","GUI/MovementUnallowed .jpeg");
						
					}
				}
				if (event.getCode()== KeyCode.NUMPAD3) {
					try {
						gg.move(Direction.RIGHT);
						
							for(int j=0;j<gg.getAvailableChampions().size();j++)
							{
								if(gg.getCurrentChampion().getName()==gg.getAvailableChampions().get(j).getName())
								{
									chButtons.get(j).setTranslateX(chButtons.get(j).getTranslateX()+132.5);
									break;
								}
							}
						
					}
					catch (NotEnoughResourcesException e1) {
						display("Attention","GUI/not enough resources.jpeg");
						
					} catch (UnallowedMovementException e1) {
						display("Attention","GUI/MovementUnallowed .jpeg");
						
					}
				}
				
				if (event.getCode()== KeyCode.W) {
					if(ability) {
						try {
							gg.castAbility(able,Direction.UP);
							ability=false;
							for(int i=0; i<chosen.size();i++) {
								if(chosen.get(i).getCurrentHP()==0) {
									for(int j=0;j<Game.getAvailableChampions().size();j++) {
										if(chosen.get(i).getName().equals(Game.getAvailableChampions().get(j).getName())) {
											chButtons.get(j).setDisable(true);
											chButtons.get(j).setVisible(false);
										}
									}
								}
							}
							for(int i=0; i<covers.size(); i++) {
								if(covers.get(i).getCurrentHP()==0) {
									coverButtons.get(i).setDisable(true);
									coverButtons.get(i).setVisible(false);
								}
							}
							if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						} catch (NotEnoughResourcesException e1) {
							display("Attention","GUI/not enough resources.jpeg");
							
						} catch (AbilityUseException e1) {
							display("Attention","GUI/AbilityUseException .jpeg");
							
						} catch (CloneNotSupportedException e1) {
							System.out.print("CloneNotSupportedException");
						} 
					}
					else {
					try {
						gg.attack(Direction.UP);
						
						for(int i=0; i<chosen.size();i++) {
							if(chosen.get(i).getCurrentHP()==0) {
								for(int j=0;j<Game.getAvailableChampions().size();j++) {
									if(chosen.get(i).getName().equals(Game.getAvailableChampions().get(j).getName())) {
										chButtons.get(j).setDisable(true);
										chButtons.get(j).setVisible(false);
									}
								}
							}
						}
						for(int i=0; i<covers.size(); i++) {
							if(covers.get(i).getCurrentHP()==0) {
								coverButtons.get(i).setDisable(true);
								coverButtons.get(i).setVisible(false);
							}
						}
						if(gg.checkGameOver()!=null)
						{
							PrimaryStage.setScene(scene9);GOWPlayer.stop();
							
							
							
							MediaView iammediaview=new MediaView(iammediaplayer);
							layout9.getChildren().addAll(iammediaview);
							iammediaplayer.setAutoPlay(true);
						}
					} catch (NotEnoughResourcesException e1) {
						display("Attention","GUI/not enough resources.jpeg");
					} catch (ChampionDisarmedException e1) {
						display("Attention","GUI/disarmed.jpeg");
					} catch (InvalidTargetException e1) {
						display("Attention","GUI/InvalidAttack.jpeg");
					}
				}}
				
				if (event.getCode()== KeyCode.S) {
					if(ability) {
						try {
							gg.castAbility(able,Direction.DOWN);
							ability=false;
							for(int i=0; i<chosen.size();i++) {
								if(chosen.get(i).getCurrentHP()==0) {
									for(int j=0;j<Game.getAvailableChampions().size();j++) {
										if(chosen.get(i).getName().equals(Game.getAvailableChampions().get(j).getName())) {
											chButtons.get(j).setDisable(true);
											chButtons.get(j).setVisible(false);
										}
									}
								}
							}
							for(int i=0; i<covers.size(); i++) {
								if(covers.get(i).getCurrentHP()==0) {
									coverButtons.get(i).setDisable(true);
									coverButtons.get(i).setVisible(false);
								}
							}
							if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						} catch (NotEnoughResourcesException e1) {
							display("Attention","GUI/not enough resources.jpeg");
							
						} catch (AbilityUseException e1) {
							display("Attention","GUI/AbilityUseException .jpeg");
							
						} catch (CloneNotSupportedException e1) {
							System.out.print("CloneNotSupportedException");
						} 
					}
					else {
					try {
						gg.attack(Direction.DOWN);
						for(int i=0; i<chosen.size();i++) {
							if(chosen.get(i).getCurrentHP()==0) {
								for(int j=0;j<Game.getAvailableChampions().size();j++) {
									if(chosen.get(i).getName().equals(Game.getAvailableChampions().get(j).getName())) {
										chButtons.get(j).setDisable(true);
										chButtons.get(j).setVisible(false);
									}
								}
							}
						}
						for(int i=0; i<covers.size(); i++) {
							if(covers.get(i).getCurrentHP()==0) {
								coverButtons.get(i).setDisable(true);
								coverButtons.get(i).setVisible(false);
							}
						}
						if(gg.checkGameOver()!=null)
						{
							PrimaryStage.setScene(scene9);GOWPlayer.stop();
							
							
							
							MediaView iammediaview=new MediaView(iammediaplayer);
							layout9.getChildren().addAll(iammediaview);
							iammediaplayer.setAutoPlay(true);
						}
					} catch (NotEnoughResourcesException e1) {
						display("Attention","GUI/not enough resources.jpeg");
					} catch (ChampionDisarmedException e1) {
						display("Attention","GUI/disarmed.jpeg");
					} catch (InvalidTargetException e1) {
						display("Attention","GUI/InvalidAttack.jpeg");
					}
				}
					}
				
				if (event.getCode()== KeyCode.D) {	
					if(ability) {
						try {
							gg.castAbility(able,Direction.RIGHT);
							ability=false;
							for(int i=0; i<chosen.size();i++) {
								if(chosen.get(i).getCurrentHP()==0) {
									for(int j=0;j<Game.getAvailableChampions().size();j++) {
										if(chosen.get(i).getName().equals(Game.getAvailableChampions().get(j).getName())) {
											chButtons.get(j).setDisable(true);
											chButtons.get(j).setVisible(false);
										}
									}
								}
							}
							for(int i=0; i<covers.size(); i++) {
								if(covers.get(i).getCurrentHP()==0) {
									coverButtons.get(i).setDisable(true);
									coverButtons.get(i).setVisible(false);
								}
							}
							if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						} catch (NotEnoughResourcesException e1) {
							display("Attention","GUI/not enough resources.jpeg");
							
						} catch (AbilityUseException e1) {
							display("Attention","GUI/AbilityUseException .jpeg");
							
						} catch (CloneNotSupportedException e1) {
							System.out.print("CloneNotSupportedException");
						} 
					}
					else {
					try {
						gg.attack(Direction.RIGHT);
						for(int i=0; i<chosen.size();i++) {
							if(chosen.get(i).getCurrentHP()==0) {
								for(int j=0;j<Game.getAvailableChampions().size();j++) {
									if(chosen.get(i).getName().equals(Game.getAvailableChampions().get(j).getName())) {
										chButtons.get(j).setDisable(true);
										chButtons.get(j).setVisible(false);
									}
								}
							}
						}
						for(int i=0; i<covers.size(); i++) {
							if(covers.get(i).getCurrentHP()==0) {
								coverButtons.get(i).setDisable(true);
								coverButtons.get(i).setVisible(false);
							}
						}
						if(gg.checkGameOver()!=null)
						{
							PrimaryStage.setScene(scene9);GOWPlayer.stop();
							
							
							
							MediaView iammediaview=new MediaView(iammediaplayer);
							layout9.getChildren().addAll(iammediaview);
							iammediaplayer.setAutoPlay(true);
						}
					} catch (NotEnoughResourcesException e1) {
						display("Attention","GUI/not enough resources.jpeg");
					} catch (ChampionDisarmedException e1) {
						display("Attention","GUI/disarmed.jpeg");
					} catch (InvalidTargetException e1) {
						display("Attention","GUI/InvalidAttack.jpeg");
					}
				}
					}
				
				if (event.getCode()== KeyCode.A) {	
					if(ability) {
						try {
							gg.castAbility(able,Direction.LEFT);
							ability=false;
							for(int i=0; i<chosen.size();i++) {
								if(chosen.get(i).getCurrentHP()==0) {
									for(int j=0;j<Game.getAvailableChampions().size();j++) {
										if(chosen.get(i).getName().equals(Game.getAvailableChampions().get(j).getName())) {
											chButtons.get(j).setDisable(true);
											chButtons.get(j).setVisible(false);
										}
									}
								}
							}
							for(int i=0; i<covers.size(); i++) {
								if(covers.get(i).getCurrentHP()==0) {
									coverButtons.get(i).setDisable(true);
									coverButtons.get(i).setVisible(false);
								}
							}
							if(gg.checkGameOver()!=null)
							{
								PrimaryStage.setScene(scene9);GOWPlayer.stop();
								
								
								
								MediaView iammediaview=new MediaView(iammediaplayer);
								layout9.getChildren().addAll(iammediaview);
								iammediaplayer.setAutoPlay(true);
							}
						} catch (NotEnoughResourcesException e1) {
							display("Attention","GUI/not enough resources.jpeg");
							
						} catch (AbilityUseException e1) {
							display("Attention","GUI/AbilityUseException .jpeg");
							
						} catch (CloneNotSupportedException e1) {
							System.out.print("CloneNotSupportedException");
						} 
					}
					else {
					try {
						gg.attack(Direction.LEFT);
						for(int i=0; i<chosen.size();i++) {
							if(chosen.get(i).getCurrentHP()==0) {
								for(int j=0;j<Game.getAvailableChampions().size();j++) {
									if(chosen.get(i).getName().equals(Game.getAvailableChampions().get(j).getName())) {
										chButtons.get(j).setDisable(true);
										chButtons.get(j).setVisible(false);
									}
								}
							}
						}
						for(int i=0; i<covers.size(); i++) {
							if(covers.get(i).getCurrentHP()==0) {
								coverButtons.get(i).setDisable(true);
								coverButtons.get(i).setVisible(false);
							}
						}
						if(gg.checkGameOver()!=null)
						{
							PrimaryStage.setScene(scene9);GOWPlayer.stop();
							
							
							
							MediaView iammediaview=new MediaView(iammediaplayer);
							layout9.getChildren().addAll(iammediaview);
							iammediaplayer.setAutoPlay(true);
						}
					} catch (NotEnoughResourcesException e1) {
						display("Attention","GUI/not enough resources.jpeg");
					} catch (ChampionDisarmedException e1) {
						display("Attention","GUI/disarmed.jpeg");
					} catch (InvalidTargetException e1) {
						display("Attention","GUI/InvalidAttack.jpeg");
					}
				}}
		
		});
		
		
		Button iamskip=new Button();
		iamskip.setPrefSize(1280, 720);
		iamskip.setBackground(null);
		iamskip.setOnAction(e->{
			PrimaryStage.setScene(endScene);
			iammediaplayer.stop();
			File final2=new File("GUI/mask2.mp4");
			Media finalmedia=new Media(final2.toURI().toString());
			MediaPlayer finalplayer=new MediaPlayer(finalmedia);
			MediaView finalview=new MediaView(finalplayer);
			finalplayer.setAutoPlay(true);
			finalview.setVisible(false);
			Label won=new Label();
			if(gg.checkGameOver()==gg.getFirstPlayer())
			won.setText((p1.getText()+" WON!"));
			if(gg.checkGameOver()==gg.getSecondPlayer())
				won.setText((p2.getText()+" WON!"));
			endLayout.getChildren().add(won);
			won.setFont(Font.font("Verdana",FontWeight.BOLD,25));
			won.setTextFill(Color.color(1, 1, 1));
			won.setTranslateX(320);
			won.setTranslateY(170);
			File last1 = new File("GUI/Endbgscene.jpeg");
		    Image last = new Image(last1.toURI().toString());
			BackgroundImage lastbgimv=new BackgroundImage(last, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
			Background lastbg=new Background(lastbgimv);
			endLayout.setBackground(lastbg);
			endLayout.getChildren().addAll(finalview);
		});
		layout9.getChildren().addAll(iamskip);
		

		PrimaryStage.setScene(scene1);
		PrimaryStage.show();
		
		// TODO Auto-generated method stub
		// y of gridpane that can contain covers are either:
		//16,123,230.
		//x of gridpane that contain covers are either:
		//30,150,270,390,510
		
	}
	public static void display(Player player, Champion champion, Button b, String filePath){
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window .setTitle("Champion's Properties");
		window.setMinWidth(250);
		Label label= new Label();
		label.setText(champion.toString());
		
		Button add = new Button();
		File addimg1 = new File("GUI/Addbutton.png");
	    Image addimg = new Image(addimg1.toURI().toString());
		ImageView addimv=new ImageView(addimg);
		addimv.setFitWidth(100);
		addimv.setFitHeight(100);
		add.setGraphic(addimv);
		add.setBackground(null);
		add.setTranslateX(17);
		add.setTranslateY(345);
		add.setOnAction(e->{
			player.getTeam().add(champion);
			b.setDisable(true);
			window.close();
		});
		
		
		
		GridPane layout = new GridPane();
		layout.getChildren().addAll(add,label);
		layout.setAlignment(Pos.TOP_CENTER);
		File icon1 = new File(filePath);
	    Image icon = new Image(icon1.toURI().toString());
		window.getIcons().add(icon);
	    Scene scene = new Scene(layout, 300,700);
		File BG1 = new File("GUI/propertiesBg.jpg");
	    Image BG = new Image(BG1.toURI().toString());
		BackgroundImage BGsand = new BackgroundImage(BG, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
		Background BGview = new Background(BGsand);
		label.setTextFill(Color.color(1, 1, 1));
		label.setFont(new Font("Verdana",12));
		layout.setBackground(BGview);
		window.setScene(scene);
		window.showAndWait();
		
	}
	public static void display(String title,String msg)
	{
		Stage window=new Stage();
		File icon1 = new File("GUI/warning_icon.png");
	    Image icon = new Image(icon1.toURI().toString());
		window.getIcons().add(icon);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		Button close=new Button();
		close.setTranslateY(100);
		close.setAlignment(Pos.BOTTOM_CENTER);
		close.setOnAction(e->{
			window.close();
		});
		File closeimg1 = new File("GUI/close.png");
	    Image closeimg = new Image(closeimg1.toURI().toString());
		ImageView closeview=new ImageView(closeimg);
		closeview.setFitWidth(100);
		closeview.setFitHeight(100);
		close.setGraphic(closeview);
		close.setBackground(null);
		
		GridPane layout=new GridPane();
		File BG1 = new File(msg);
	    Image BG = new Image(BG1.toURI().toString());
		BackgroundImage BGsand = new BackgroundImage(BG, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
		Background BGview = new Background(BGsand);
		layout.setBackground(BGview);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(close);
		
		Scene scene=new Scene(layout,300,300);
		window.setScene(scene);
		window.showAndWait();
		
	}

	public static void main(String[]args)
	{
		
		launch(args);
	}

}

