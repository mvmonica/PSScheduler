import java.util.ArrayList;

public class Task {
    private String name;
    private String type;
    private float startTime;
    private float duration;
    //
    private String[] RTaskList = {"Class", "Study", "Sleep", "Exercise", "Work", "Meal"};
    private String[] TTaskList = {"Visit", "Shopping", "Appointment"};
    private String[] ATaskList = {"Cancellation"};
    
    public Task(String name, String type, float startTime, float duration){
        this.name = name;
        this.type = type;
        this.startTime = roundTime(startTime);   
        this.duration = roundTime(duration);
    }

    //true = valid
    public boolean checkStartTime(float startTime){
        if (startTime < 0 || startTime > 23.75){
            return false;
        }
        return true;
    }

    public boolean checkDurationTime(float duration){
        if (duration < .25 || duration > 23.75){
            return false;
        }
        return true;
    }

    public float roundTime(float time){
        float temp = time - (int)time;
        if (temp < .125){
            //round to zero
            return time - temp + 0f;
        }
        else if (temp < .375){
            //round to .25
            return time - temp + .25f;
        }
        else if (temp < .625){
            //round to .5
            return time - temp + .5f;
        }
        else if (temp < .875){
            //round to .75
            return time - temp + .75f;
        }
        else{
            //round to 1
            return time - temp + 1f;
        }
    }

    //think this is how it is suppose to go, but I do not know
    //used three for each loops for easy expandablity 
    //since the anti task list only one for now
    public String checkTaskType(String type){
        for(String rTypeList: RTaskList){
            if(type.equals(rTypeList)){
                return "Recurring";
            }
        }
        for(String tTypeList: TTaskList){
            if(type.equals(tTypeList)){
                return "Transient";
            }
        }
        for(String aTypeList: ATaskList){
            if(type.equals(aTypeList)){
                return "Anti";
            }
        }
        return "Invalid Task Type";
    }

    public String checkCategory(){
        for(String rTypeList: RTaskList){
            if(type.equals(rTypeList))
                return "Recurring";
        }
        for(String tTypeList: TTaskList){
            if(type.equals(tTypeList))
                return "Transient";
        }
        for(String aTypeList: ATaskList){
            if(type.equals(aTypeList))
                return "Anti";
        }
        return "invalid";
    }

    //true = valid name
    public boolean checkTaskName(String name, ArrayList<Task> listOfTasks){
        for(Task taskList: listOfTasks){
            if(taskList.name.equals(name)){
                return false;
            }
        }
        return true;
    }

    public void checkOverlaps(){
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public float getStartTime() {
        return startTime;
    }

    public float getDuration() {
        return duration;
    }
}
