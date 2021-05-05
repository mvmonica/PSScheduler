public class TransientTask extends Task{
    int date;

    public TransientTask(String name, String type, float startTime, float duration){
        super(name, type, startTime, duration);
    }

    public void checkDate(int date){
    }

    public void checkOverlaps(){       
    }
}
