import java.util.*;
import java.io.*;
import org.json.simple.*;


public class Model {
    private ArrayList<Task> testList = new ArrayList<>();
    private List<String> monthsWith30 = List.of("04", "06", "09", "11");
    private List<String> monthsWith31 = List.of("01", "03", "05", "07", "08", "10", "12");

    
    public void createTask(String name, String type, float startTime, float duration) throws FileNotFoundException {
//        testList.add(new Task(name, type, startTime, duration));
/*
        JSONObject jo = new JSONObject();

        // putting data to JSONObject
        jo.put("Name of task", name);
        jo.put("Type of task", type);
        jo.put("Start time", startTime);
        jo.put("Duration", duration);

        //Making a new file with the given name. ".json" will ensure that it is json file.
        //This file will be in the main directory
        PrintWriter pw = new PrintWriter(new File("./JSON_Files", name + ".json"));
        pw.write(jo.toJSONString());

        pw.flush();
        pw.close();
        System.out.println(jo.toString());*/


    }

    public void createTask(String name, String type, float startTime, float duration, int date){
        TransientTask task = new TransientTask(name, type, startTime, duration, date);
        if((task.checkCategory()).equals("Transient")){
            if(testList.isEmpty())
                testList.add(task);
            else{
                if(task.checkTaskName(name, testList) && checkTransientOverlap(task))
                    testList.add(task);
                else
                    System.out.println("Conflicting tasks, not added to schedule.\n");
            }
        } else {
            System.out.println("Invalid Category.\n");
        }
    }

    public void createTask(String name, String type, float startTime, float duration, int startDate, int endDate, int freq){
        Task task = new RecurringTask(name, type, startTime, duration, startDate, endDate, freq);
        if((task.checkCategory()).equals("Recurring") && (startDate < endDate)) {
            boolean valid = true;
            if (task.checkTaskName(name, testList)) {
                if(freq == 1)
                    addRecurringDaily(name, type, startTime, duration, startDate, endDate);
                else if(freq == 30)
                    addRecurringWeekly(name, type, startTime, duration, startDate, endDate);
            }
        } else {
            System.out.println("Invalid Category or start and end date.\n");
        }
    }

    public void addRecurringDaily(String name, String type, float startTime, float duration, int startDate, int endDate){
        for (int i = startDate; i <= endDate; i++) {
            String month = String.valueOf(i).substring(4, 6);
            String day = String.valueOf(i).substring(6, 8);
            String year = String.valueOf(i).substring(0, 4);
            int maxDay = calculateMaxDays(month);
            if (Integer.valueOf(day) > maxDay) {
                if (month.equals("12")) {
                    month = "01";
                    day = "01";
                    year = String.valueOf(Integer.valueOf(year) + 1);
                } else {
                    month = String.valueOf(Integer.valueOf(month) + 1);
                    day = "01";
                }
            } else {
                day = String.valueOf(Integer.valueOf(day) + 1);
            }
            String newDate = year + month + day;
            Task task1 = new TransientTask(name, type, startTime, duration, Integer.valueOf(newDate));
            testList.add(task1);
            //todo - check for overlap before adding
        }
    }

    public void addRecurringWeekly(String name, String type, float startTime, float duration, int startDate, int endDate){
        //todo - Still need to modify to add weekly, this is base only
        for (int i = startDate; i < endDate; i += 7) {
            String month = String.valueOf(i).substring(4, 6);
            String day = String.valueOf(i).substring(6, 8);
            String year = String.valueOf(i).substring(0, 4);
            int maxDay = calculateMaxDays(month);
            if (Integer.valueOf(day) > maxDay) {
                if (year.equals("12")) {
                    month = "01";
                    day = "01";
                    year = String.valueOf(Integer.valueOf(year) + 1);
                } else {
                    month = String.valueOf(Integer.valueOf(month) + 1);
                    day = "01";
                }
            } else {
                day = String.valueOf(Integer.valueOf(day) + 1);
            }
            String newDate = year + month + day;
            Task task1 = new TransientTask(name, type, startTime, duration, Integer.valueOf(newDate));
        }
    }

    public void createRecurring(String name, String type, float startTime, float duration, int date){
        TransientTask task = new TransientTask(name, type, startTime, duration, date);
        if((task.checkCategory()).equals("Transient")){
            if(testList.isEmpty())
                testList.add(task);
            else{
                if(checkTransientOverlap(task))
                    testList.add(task);
                else
                    System.out.println("Conflicting tasks, not added to schedule.\n");
            }
        } else {
            System.out.println("Invalid Category.\n");
        }
    }

    public int calculateMaxDays(String month){
        if(monthsWith30.contains(month))
            return 30;
        else if(monthsWith31.contains(month))
            return 31;
        else
            return 28;
    }


    public void createTask(Task t){
        System.out.println(testList.add(t));
    }

    public void createAntiTask(String name, String type, float startTime, float duration, int date){
        AntiTask task = new AntiTask(name, type, startTime, duration, date);

    }

    public boolean checkAntiTaskOverlaps(AntiTask checkingTask){
        for (int i =0; i < testList.size(); i++) {
            AntiTask inList = (AntiTask) testList.get(i);
            if (inList.getDate() == checkingTask.getDate()){

                float inListEndTime = inList.getStartTime() + inList.getDuration();
                float inListStart = inList.getStartTime();

                float taskStart = checkingTask.getStartTime();
                float taskEndTime = checkingTask.getStartTime() + checkingTask.getDuration();


                if (inListStart <= taskStart && taskStart < inListEndTime)
                    return  false;
            }
        }
        return true;
    }

    public boolean checkTransientOverlap(TransientTask checkingTask){
        for (int i =0; i < testList.size(); i++) {
            Task inTask = testList.get(i);
            if(inTask.checkTaskType(inTask.getType()) == "Transient") {
                inTask = (TransientTask) inTask;
                if (((TransientTask) inTask).getDate() == checkingTask.getDate()) {

                    float inListEndTime = inTask.getStartTime() + inTask.getDuration();
                    float inListStart = inTask.getStartTime();

                    float taskStart = checkingTask.getStartTime();
                    float taskEndTime = checkingTask.getStartTime() + checkingTask.getDuration();


                    if (inListStart <= taskStart && taskStart < inListEndTime)
                        return false;
                    else if(inListStart <= taskEndTime && taskEndTime < inListEndTime)
                        return false;
                }
            }
        }
        return true;
    }


    public void viewTask(String name){
        for (int i = 0; i < testList.size(); i++){
            Task temp = (Task)testList.get(i);
            if (temp.getName().equals(name)){
                //displays a task, but should be replaced later
                System.out.println("Name: " + temp.getName());
                System.out.println("Type: " + temp.getType());
                System.out.println("Start Time: " + temp.getStartTime());
                System.out.println("Duration: " + temp.getDuration());
                break;
            }
        }
    }

    public void deleteTask(String name){
        for (int i = 0; i < testList.size(); i++){
            Task temp = (Task)testList.get(i);
            if (temp.getName().equals(name)){
                testList.remove(i);
            }
        }
    }

    public void editTask(String name) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        ArrayList <Object> testList1 = new ArrayList<Object>();

        //Searching for the items and counting how many similar items are available.
        //if there are more than one this is likely a recurring task.
        //save those into
        int count = 0;
        for (Object o : testList) {
            JSONObject jo = (JSONObject) o;
            if(jo.containsValue(name)){
                count++;
                testList1.add(jo);
            }
        }

        //if no items found exit
        if(count == 0){
            System.out.println("no items to change");
            System.exit(0);
        }

        //tell the user how many items found.
        System.out.printf("found %d item/s", count);


        for (Object o : testList1) {
            JSONObject jo = (JSONObject) o;
            System.out.println("do you want to change this item? (y/n)" );
            System.out.println(jo.toString());
            if(input.nextLine().equals("y")){
                takeInfo();
            }
        }
        System.out.println("no items to change!");
    }

    public void takeInfo() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.println("what is the name of this task?");
        String name = input.nextLine();

        System.out.println("what is the type of this task?");
        String type = input.nextLine();

        System.out.println("when does this task start?");
        float date = input.nextFloat();

        System.out.println("what is the duration?");
        float duration = input.nextFloat();

        createTask(name, type, date, duration);
    }

    public void schedulePrinter(){
        for(int i=0; i < testList.size(); i++){
            Task t= testList.get(i);
            System.out.println(t.getName());
            System.out.println(t.getStartTime());
            System.out.println(t.getDuration());
        }
    }

    /***
     *
     * @param name this is for the name of the file that we want to save as.
     */
    public void saveToFile(String name) throws FileNotFoundException {
        //This for loop will run through all the array list elements that are basically JSON objects and save their
        //To string output to a file.
        PrintWriter pw = new PrintWriter(new File("./JSON_Files", name + ".json"));
        for (int i = 0; i < testList.size(); i++) {
            // getting every item and toString them to JSON file. each object is on a separate line.
            pw.write(testList.get(i).toString() + "\n");
        }
        pw.flush();
        pw.close();

    }
}
