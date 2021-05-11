public class AntiTask extends Task{
   private int date;

    public AntiTask(String name, String type, float startTime, float duration, int date){
        super(name, type, startTime, duration);
        this.date = date;
    }

    public void cancelRecurringOnce(int date, float startTime, float duration){

    }

    public void checkDate(int date){
        //todo - Figure out if there is a recurring task on that day and time
    }


    public int getDate() {
        return date;
    }
}
