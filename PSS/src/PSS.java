//package pss;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;


public class PSS extends Application
{
    // to hold the overall page and be able to change scenes
    private BorderPane mainLayout = new BorderPane();
    private static Stage guiStage;
            
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ////////////////////I USED MENUBAR FOR READ AND WRITE SCHEDULE TO A FILE//////////////////////////////////////////////////////////////////////////////////////////////
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Read/Write File");
        menu.setStyle("-fx-background-color: tomato; -fx-font-size: 20pt");
        MenuItem read = new MenuItem("Read Schedule from a File");
        MenuItem write = new MenuItem("Write Schedule to a File");
        Label label = new Label();
        VBox vbox = new VBox();
        BorderPane borderPane = new BorderPane();
        
        //open a file
        read.setOnAction(e ->
        {
            FileChooser openFileChooser = new FileChooser();
            File selectedOpenFile = openFileChooser.showOpenDialog(primaryStage);
            if(selectedOpenFile != null)
            {
                String fileName = selectedOpenFile.getPath();
                label.setText("You have selected " + fileName);
                //HERE GOES THE REST OF THE CODE AND WHAT WE'RE GONNA DO WITH THE OPENED FILE*** 
            }
        });
        // save to a file
        write.setOnAction(e ->
        {
            FileChooser saveFileChooser = new FileChooser();
            File selectedSaveFile = saveFileChooser.showSaveDialog(primaryStage);
        });
        
        
        vbox.getChildren().add(label);
        vbox.setAlignment(Pos.CENTER);
        menu.getItems().addAll(read, new SeparatorMenuItem(), write);
        menuBar.getMenus().add(menu);
        borderPane.setTop(menuBar);
        borderPane.setCenter(vbox);
        
        ////////////////////1st page///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //font for the navigation texts
        Font navFont = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 30);
        
        //1st page's clickable text buttons 
        Text create = new Text("Create a Task");
        create.setFont(navFont);
        create.setFill(Color.BLACK);
        create.setOnMouseEntered(e -> {
            create.setFill(Color.AQUAMARINE);
        });
        create.setOnMouseExited(e -> {
            create.setFill(Color.BLACK);
        });
        
        Text view = new Text("View a Task");
        view.setFont(navFont);
        view.setFill(Color.BLACK);
        view.setOnMouseEntered(e -> {
            view.setFill(Color.AQUAMARINE);
        });
        view.setOnMouseExited(e -> {
            view.setFill(Color.BLACK);
        });
        
        Text delete = new Text("Delete a Task");
        delete.setFont(navFont);
        delete.setFill(Color.BLACK);
        delete.setOnMouseEntered(e -> {
            delete.setFill(Color.AQUAMARINE);
        });
        delete.setOnMouseExited(e -> {
            delete.setFill(Color.BLACK);
        });
        
        Text edit = new Text("Edit a Task");
        edit.setFont(navFont);
        edit.setFill(Color.BLACK);
        edit.setOnMouseEntered(e -> {
            edit.setFill(Color.AQUAMARINE);
        });
        edit.setOnMouseExited(e -> {
            edit.setFill(Color.BLACK);
        });
        
        //the rest of the buttons view/write for one day/week/month
        
        //HBox for the navigation
        VBox homePageNav = new VBox(30, create, view, delete, edit);
        homePageNav.setPadding(new Insets(15));
        homePageNav.setAlignment(Pos.CENTER);
        
        Image calendarImage1 = new Image("cal.jpg");
        ImageView calendarImgView1 = new ImageView(calendarImage1);
        calendarImgView1.setLayoutX(100.0);
        calendarImgView1.setLayoutY(100.0);
        
        mainLayout.setRight(homePageNav);
        mainLayout.setCenter(calendarImgView1);
        mainLayout.setTop(borderPane);
        
        
        //Vbox for the create button's page
        Label temp = new Label("Code goes here: ");
        VBox createPageVbox = new VBox(temp);
        createPageVbox.setPadding(new Insets(15));
        createPageVbox.setAlignment(Pos.CENTER);
        //you can use GridPane to contain all the stuff for each page
        GridPane createPage = new GridPane();
        createPage.add(createPageVbox, 0, 0);
        createPage.setHgap(15);
        createPage.setVgap(15);
        createPage.setPadding(new Insets(15));
        createPage.setAlignment(Pos.CENTER);
        
        //Vbox for the view button's page
        Label temp2 = new Label("And here: ");
        VBox viewPageVbox = new VBox(temp2);
        viewPageVbox.setPadding(new Insets(15));
        viewPageVbox.setAlignment(Pos.CENTER);
        //you can use GridPane to contain all the stuff for each page
        GridPane viewPage = new GridPane();
        viewPage.add(viewPageVbox, 0, 0);
        viewPage.setHgap(15);
        viewPage.setVgap(15);
        viewPage.setPadding(new Insets(15));
        viewPage.setAlignment(Pos.CENTER);
        
        //Vbox for the delete button's page
        Label temp3 = new Label("Code goes here: ");
        VBox deletePageVbox = new VBox(temp3);
        deletePageVbox.setPadding(new Insets(15));
        deletePageVbox.setAlignment(Pos.CENTER);
        //you can use GridPane to contain all the stuff for each page
        GridPane deletePage = new GridPane();
        deletePage.add(deletePageVbox, 0, 0);
        deletePage.setHgap(15);
        deletePage.setVgap(15);
        deletePage.setPadding(new Insets(15));
        deletePage.setAlignment(Pos.CENTER);
        
        //Vbox for the edit button's page
        Label temp4 = new Label("here: ");
        VBox editPageVbox = new VBox(temp4);
        editPageVbox.setPadding(new Insets(15));
        editPageVbox.setAlignment(Pos.CENTER);
        //you can use GridPane to contain all the stuff for each page
        GridPane editPage = new GridPane();
        editPage.add(editPageVbox, 0, 0);
        editPage.setHgap(15);
        editPage.setVgap(15);
        editPage.setPadding(new Insets(15));
        editPage.setAlignment(Pos.CENTER);
        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //if any of the text on the 1st page is clicked add the specific layout container to the scene
        create.setOnMouseClicked(e -> 
        { 
            mainLayout.setCenter(createPage);
            Scene newScene = new Scene(mainLayout, 1500, 950);
            PSS.getStage().setScene(newScene);
        });
        view.setOnMouseClicked(e -> 
        {
            mainLayout.setCenter(viewPage); 
            Scene newScene = new Scene(mainLayout, 1500, 950);
            PSS.getStage().setScene(newScene);
        });
        delete.setOnMouseClicked(e -> 
        {
            mainLayout.setCenter(deletePage);
            Scene newScene = new Scene(mainLayout, 1500, 950);
            PSS.getStage().setScene(newScene);
        });
        edit.setOnMouseClicked(e -> 
        {
            mainLayout.setCenter(editPage);
            Scene newScene = new Scene(mainLayout, 1500, 950);
            PSS.getStage().setScene(newScene);
        });
     
        Scene scene = new Scene(mainLayout, 1500, 950, Color.BLACK);
        primaryStage.setTitle("PSS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static Stage getStage() 
    {
        return guiStage;
    }  
}

