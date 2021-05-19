import org.json.simple.JSONObject;
import java.util.ArrayList;

public class RecurringTask extends Task{
    private int startDate;
    private int endDate;
    private int frequency;

    public RecurringTask(String name, String type, float startTime, float duration, int startDate, int endDate, int frequency){
        super(name, type, startTime, duration);
        this.startDate = startDate;
        this.endDate = endDate;
        this.frequency = frequency;
    }


    public void compareDates(int startDate, int endDate){
        if (startDate <= endDate)
            System.out.println("valid!");
        else
            System.out.println("invalid!");


    }

    /**
     * This method will return a JSON object of this specific instance of recurring task
     * @return JSON object
     */
    public JSONObject getJSON(){
        JSONObject obj = new JSONObject();

        //Putting all the field objects to the JSON object
        obj.put("Name" , getName());
        obj.put("Type" , getType());
        obj.put("StartTime" , getStartTime());
        obj.put("Duration" , getDuration());
        obj.put("Date" , getDate());

        obj.put("StartDate" , startDate);
        obj.put("EndDate" , endDate);
        obj.put("Frequency" , frequency);

        return obj;
    }
   
    public int getStartDate() {
        return startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public float getFrequency() {
        return frequency;
    }
}
