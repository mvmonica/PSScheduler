import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.time.LocalDate;
import java.util.Observable;

import javafx.scene.control.DatePicker;
import java.awt.event.*;

public class PSS extends Application
{
    private static final Scene scene = null;
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

        Text home = new Text("Home"); // this is to add a text to your navigation bar
        home.setFont(navFont);
        home.setFill(Color.BLACK);
        home.setOnMouseEntered(e -> {
            home.setFill(Color.AQUAMARINE);
        });
        home.setOnMouseExited(e -> {
            home.setFill(Color.BLACK);
        });

        Text viewschedule = new Text("View Schedule"); // this is to add a text to your navigation bar
        viewschedule.setFont(navFont);
        viewschedule.setFill(Color.BLACK);
        viewschedule.setOnMouseEntered(e -> {
            viewschedule.setFill(Color.AQUAMARINE);
        });
        viewschedule.setOnMouseExited(e -> {
            viewschedule.setFill(Color.BLACK);
        });
        
        Text writeschedule = new Text("Write Schedule"); // this is to add a text to your navigation bar
        writeschedule.setFont(navFont);
        writeschedule.setFill(Color.BLACK);
        writeschedule.setOnMouseEntered(e -> {
            writeschedule.setFill(Color.AQUAMARINE);
        });
        writeschedule.setOnMouseExited(e -> {
            writeschedule.setFill(Color.BLACK);
        });
        //the rest of the buttons view/write for one day/week/month
        
        //HBox for the navigation
        VBox homePageNav = new VBox(30, home, create, view, delete, edit, viewschedule, writeschedule); // add home to your VBox
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
        Label temp = new Label("");
        VBox createPageVbox = new VBox(temp);
        createPageVbox.setPadding(new Insets(15));
        createPageVbox.setAlignment(Pos.CENTER);
        //you can use GridPane to contain all the stuff for each page
        GridPane createPage = new GridPane();
        createPage.add(createPageVbox, 0, 0);
        createPage.setHgap(15);
        createPage.setVgap(15);
        createPage.setPadding(new Insets(15));
        createPage.setAlignment(Pos.TOP_LEFT);
        final ComboBox taskComboBox = new ComboBox();
        taskComboBox.getItems().addAll("Transient Task", "Recurring Task", "AntiTask");
        final ComboBox typetaskComboBox = new ComboBox();
        final ComboBox frequencyComboBox = new ComboBox();
        DatePicker startDatePicker = new DatePicker();
        DatePicker endDatePicker = new DatePicker();
        final ObservableList<String> typetransList = FXCollections.observableArrayList("Visit", "Shopping", "Appointment");
        final ObservableList<String> typerecurList = FXCollections.observableArrayList("Class", "Study", "Sleep", "Exercise", "Work", "Meal");
        final ObservableList<String> typeantiList = FXCollections.observableArrayList("Cancellation");
        final ObservableList<String> freqList = FXCollections.observableArrayList("Daily", "Weekly");
       taskComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener()
       {
           public void changed(ObservableValue ov, Object t, Object t1)
           {
               switch (t1.toString()){
                   case "Transient Task":
                        typetaskComboBox.setItems(typetransList);
                        createPage.add(new Label("Select the date:"), 0, 3);
                        createPage.add(startDatePicker, 1, 3);
                        break;
                    case "Recurring Task":
                        createPage.add(new Label(" "), 0, 3);
                        createPage.add(new Label(" "), 1, 3);
                        typetaskComboBox.setItems(typerecurList);
                        frequencyComboBox.setItems(freqList);
                        createPage.add(new Label("Select the start date:"), 0, 3);
                        createPage.add(startDatePicker, 1, 3);
                        createPage.add(new Label("Select the end date:"), 0, 4);
                        createPage.add(endDatePicker, 1, 4);
                        createPage.add(new Label("Frequency: "), 0, 7);
                        createPage.add(frequencyComboBox, 1, 7);
                        break;
                    case "AntiTask":
                        typetaskComboBox.setItems(typeantiList);
                        createPage.add(new Label("Select the date:"), 0, 3);
                        createPage.add(startDatePicker, 1, 3);
                        break;
               }
           }
           
       });
        
        //frequencyComboBox.getItems().addAll("Daily", "Weekly");
        final TextField name = new TextField();
        final TextField duration = new TextField();
        final TextField startTime = new TextField();
        
        startDatePicker.setValue(LocalDate.now());
        endDatePicker.setValue(startDatePicker.getValue().plusDays(1));
        createPage.add(new Label("Name of task: "), 0, 0);
        createPage.add(name, 1, 0);
        createPage.add(new Label("Select the style of task:"), 0, 1);
        createPage.add(taskComboBox, 1, 1);
        createPage.add(new Label("Select the type of task:"), 0, 2);
        createPage.add(typetaskComboBox, 1, 2);
        //createPage.add(new Label("Select the start date:"), 0, 3);
        //createPage.add(startDatePicker, 1, 3);
        //createPage.add(new Label("Select the end date:"), 0, 4);
        //createPage.add(endDatePicker, 1, 4);
        createPage.add(new Label("Start time of the task: "), 0, 5);
        createPage.add(startTime, 1, 5);
        createPage.add(new Label("Duartion of the task: "), 0, 6);
        createPage.add(duration, 1, 6);
        //createPage.add(new Label("Frequency: "), 0, 7);
        //createPage.add(frequencyComboBox, 1, 7);
        
        
        //Vbox for the view button's page
        Label temp2 = new Label("");
        VBox viewPageVbox = new VBox(temp2);
        viewPageVbox.setPadding(new Insets(15));
        viewPageVbox.setAlignment(Pos.CENTER);
        //you can use GridPane to contain all the stuff for each page
        GridPane viewPage = new GridPane();
        viewPage.add(viewPageVbox, 0, 0);
        viewPage.setHgap(15);
        viewPage.setVgap(15);
        viewPage.setPadding(new Insets(15));
        viewPage.setAlignment(Pos.TOP_LEFT);
        final TextField name2 = new TextField();
        viewPage.add(new Label("Name of task: "), 0, 0);
        viewPage.add(name2, 1, 0);
        
        //Vbox for the delete button's page
        Label temp3 = new Label("");
        VBox deletePageVbox = new VBox(temp3);
        deletePageVbox.setPadding(new Insets(15));
        deletePageVbox.setAlignment(Pos.CENTER);
        //you can use GridPane to contain all the stuff for each page
        GridPane deletePage = new GridPane();
        deletePage.add(deletePageVbox, 0, 0);
        deletePage.setHgap(15);
        deletePage.setVgap(15);
        deletePage.setPadding(new Insets(15));
        deletePage.setAlignment(Pos.TOP_LEFT);
        final TextField name3 = new TextField();
        deletePage.add(new Label("Name of task: "), 0, 0);
        deletePage.add(name3, 1, 0);
        
        //Vbox for the edit button's page
        Label temp4 = new Label("");
        VBox editPageVbox = new VBox(temp4);
        editPageVbox.setPadding(new Insets(15));
        editPageVbox.setAlignment(Pos.CENTER);
        //you can use GridPane to contain all the stuff for each page
        GridPane editPage = new GridPane();
        editPage.add(editPageVbox, 0, 0);
        editPage.setHgap(15);
        editPage.setVgap(15);
        editPage.setPadding(new Insets(15));
        editPage.setAlignment(Pos.TOP_LEFT);
        final ComboBox newtaskComboBox = new ComboBox();
        newtaskComboBox.getItems().addAll("Transient Task", "Recurring Task", "AntiTask");
        final ComboBox newtypetaskComboBox = new ComboBox();
        newtypetaskComboBox.getItems().addAll("Class", "Study", "Sleep", "Exercise", "Work", "Meal", "Visit", "Shopping", "Appointment", "Cancellation");
        final ComboBox newfrequencyComboBox = new ComboBox();
        newfrequencyComboBox.getItems().addAll("Daily", "Weekly");
        final TextField name4 = new TextField();
        final TextField newduration = new TextField();
        final TextField newstartTime = new TextField();
        DatePicker newstartDatePicker = new DatePicker();
        DatePicker newendDatePicker = new DatePicker();
        newstartDatePicker.setValue(LocalDate.now());
        newendDatePicker.setValue(newstartDatePicker.getValue().plusDays(1));
        editPage.add(new Label("Name of task: "), 0, 0);
        editPage.add(name4, 1, 0);
        editPage.add(new Label("Select new style of task:"), 0, 1);
        editPage.add(newtaskComboBox, 1, 1);
        editPage.add(new Label("Select the new type of task:"), 0, 2);
        editPage.add(newtypetaskComboBox, 1, 2);
        editPage.add(new Label("Select the new start date:"), 0, 3);
        editPage.add(newstartDatePicker, 1, 3);
        editPage.add(new Label("Select the new end date:"), 0, 4);
        editPage.add(newendDatePicker, 1, 4);
        editPage.add(new Label("New start time of the task: "), 0, 5);
        editPage.add(newstartTime, 1, 5);
        editPage.add(new Label("New duartion of the task: "), 0, 6);
        editPage.add(newduration, 1, 6);
        editPage.add(new Label("New frequency: "), 0, 7);
        editPage.add(newfrequencyComboBox, 1, 7);

        Label temp6 = new Label("");
        VBox viewschedulePageVbox = new VBox(temp4);
        viewschedulePageVbox.setPadding(new Insets(15));
        viewschedulePageVbox.setAlignment(Pos.CENTER);
        //you can use GridPane to contain all the stuff for each page
        GridPane viewschedulePage = new GridPane();
        viewschedulePage.add(viewschedulePageVbox, 0, 0);
        viewschedulePage.setHgap(15);
        viewschedulePage.setVgap(15);
        viewschedulePage.setPadding(new Insets(15));
        viewschedulePage.setAlignment(Pos.TOP_LEFT);
        DatePicker thirdstartDatePicker = new DatePicker();
        DatePicker thirdendDatePicker = new DatePicker();
        final ObservableList<String> length = FXCollections.observableArrayList("Day", "Week", "Month");
        final ComboBox lengthComboBox = new ComboBox();
        lengthComboBox.setItems(length);
        viewschedulePage.add(new Label("Select length of wanted schedule:"), 0, 0);
        viewschedulePage.add(lengthComboBox, 1, 0);
        lengthComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener()
       {
           public void changed(ObservableValue ov2, Object t2, Object t3)
           {
               switch (t3.toString()){
                   case "Day":
                        viewschedulePage.add(new Label("Select the date:"), 0, 3);
                        viewschedulePage.add(thirdstartDatePicker, 1, 3);
                        break;
                    case "Week":
                        viewschedulePage.add(new Label("Select the start date:"), 0, 3);
                        viewschedulePage.add(thirdstartDatePicker, 1, 3);
                        viewschedulePage.add(new Label("Select the end date:"), 0, 4);
                        viewschedulePage.add(thirdendDatePicker, 1, 4);
                        break;
                    case "Month":
                        viewschedulePage.add(new Label("Select the start date:"), 0, 3);
                        viewschedulePage.add(thirdstartDatePicker, 1, 3);
                        viewschedulePage.add(new Label("Select the end date:"), 0, 4);
                        viewschedulePage.add(thirdendDatePicker, 1, 4);
                        break;
               }
            }
        });


        Label temp5 = new Label("");
        VBox writeschedulePageVBox = new VBox(temp5);
        writeschedulePageVBox.setPadding(new Insets(15));
        writeschedulePageVBox.setAlignment(Pos.CENTER);
        //you can use GridPane to contain all the stuff for each page
        GridPane writeschedulePage = new GridPane();
        writeschedulePage.add(writeschedulePageVBox, 0, 0);
        writeschedulePage.setHgap(15);
        writeschedulePage.setVgap(15);
        writeschedulePage.setPadding(new Insets(15));
        writeschedulePage.setAlignment(Pos.TOP_LEFT);
        DatePicker laststartDatePicker = new DatePicker();
        DatePicker lastendDatePicker = new DatePicker();
        final TextField namefile = new TextField();
        final ObservableList<String> lastlength = FXCollections.observableArrayList("Day", "Week", "Month");
        final ComboBox lastlengthComboBox = new ComboBox();
        lastlengthComboBox.setItems(lastlength);
        writeschedulePage.add(new Label("Select length of wanted schedule:"), 0, 0);
        writeschedulePage.add(lastlengthComboBox, 1, 0);
        lastlengthComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener()
       {
           public void changed(ObservableValue ov3, Object t4, Object t5)
           {
               switch (t5.toString()){
                   case "Day":
                        writeschedulePage.add(new Label("Select the date:"), 0, 3);
                        writeschedulePage.add(thirdstartDatePicker, 1, 3);
                        break;
                    case "Week":
                        writeschedulePage.add(new Label("Select the start date:"), 0, 3);
                        writeschedulePage.add(thirdstartDatePicker, 1, 3);
                        writeschedulePage.add(new Label("Select the end date:"), 0, 4);
                        writeschedulePage.add(thirdendDatePicker, 1, 4);
                        break;
                    case "Month":
                        writeschedulePage.add(new Label("Select the start date:"), 0, 3);
                        writeschedulePage.add(thirdstartDatePicker, 1, 3);
                        writeschedulePage.add(new Label("Select the end date:"), 0, 4);
                        writeschedulePage.add(thirdendDatePicker, 1, 4);
                        break;
               }
            }
        });
        writeschedulePage.add(new Label("Enter file name: "), 0, 1);
        writeschedulePage.add(namefile, 1, 1);



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

        home.setOnMouseClicked(e -> 
        { 
            mainLayout.setCenter(calendarImgView1);
            Scene newScene = new Scene(mainLayout, 1500, 950); // this goes with all the other .setOnMouseClicked actions towards the end of the code
            PSS.getStage().setScene(newScene);
        });

        viewschedule.setOnMouseClicked(e -> 
        { 
            mainLayout.setCenter(viewschedulePage);
            Scene newScene = new Scene(mainLayout, 1500, 950); 
            PSS.getStage().setScene(newScene);
        });

        writeschedule.setOnMouseClicked(e -> 
        { 
            mainLayout.setCenter(writeschedulePage);
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

