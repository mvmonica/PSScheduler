public class Task {
    public String name;
    String type;
    float startTime;
    float duration;
    
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

    public void checkTaskType(){

    }

    //true = valid
    public boolean checkTaskName(String name, Task[] listOfTasks){
        for (Task taskThing: listOfTasks){
            if(taskThing.name.equals(name)){
                return false;
            }
        }
        return true;
    }

    public void checkOverlaps(){
    }
}
