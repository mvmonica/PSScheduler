import java.util.ArrayList;

public class Model {
    Task[] listOfTasks; //going to change array to arrayList make edits to the schedule easier
    
    public void createTask(String name, String type, float startTime, float duration){
    }

    public void roundTime(){

    }

    public void viewTask(String name){
        for (Task taskThing: listOfTasks){
            if(taskThing.name.equals(name)){
                //display task info\
                System.out.println("found " + name);
            }
        } 
    }

    public void deleteTask(String name){
        for (Task taskThing: listOfTasks){
            if(taskThing.name.equals(name)){
                
            }
        }
    }

    public void editTask(){
    }

}
