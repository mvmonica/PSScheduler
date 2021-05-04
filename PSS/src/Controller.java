public class Controller {
    public static void main(String[] args) throws Exception{
        Task testTask = new Task("Class", "Recurring", 12.26f, 4.5f);
        System.out.println(testTask.name);
        System.out.println(testTask.type);
        System.out.println(testTask.startTime);
        System.out.println(testTask.duration);
    }

    public void writeSchedule(String fileName){

    }

    public void readSchedule(String fileName){

    }

    public void writeSchedule(int date, String type){

    }

}
