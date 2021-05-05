public class AntiTask extends Task{
    int date;

    public AntiTask(String name, String type, float startTime, float duration){
        super(name, type, startTime, duration);

    }

    public void cancelRecurringOnce(int date, float startTime, float duration){

    }

    public void checkDate(int date){

    }

    public void checkOverlaps(){}
}
