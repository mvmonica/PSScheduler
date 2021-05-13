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


    /**
     * Will create a transient task.
     * Checks the category and ensures it is part of the transient list, and then will check for any overlaps
     * such as duplicated task name or conflicting times
     * @param name - Name of the task
     * @param category - Category
     * @param startTime - Start time
     * @param duration - Duration of task
     * @param date - When the task occurs
     */
    public void createTask(String name, String category, float startTime, float duration, int date){
        TransientTask task = new TransientTask(name, category, startTime, duration, date);
        if((task.checkCategory()).equals("Transient")){
            if(testList.isEmpty()) {
                testList.add(task);
                task.setDate(date);
            }
            else{
                if(task.checkTaskName(name, testList) && checkTransientOverlap(task)) {
                    testList.add(task);
                    task.setDate(date);
                }
                else
                    System.out.println("Conflicting tasks, not added to schedule.\n");
            }
        } else {
            System.out.println("Invalid Category.\n");
        }
    }

    /**
     * Will create a recurring task, will call respective function based on frequency
     * @param name - Name of the task
     * @param category - Category
     * @param startTime - Start time
     * @param duration - Duration
     * @param startDate - Start date
     * @param endDate - End date
     * @param freq - Frequency of the task
     */
    public void createTask(String name, String category, float startTime, float duration, int startDate, int endDate, int freq){
        Task task = new RecurringTask(name, category, startTime, duration, startDate, endDate, freq);
        if((task.checkCategory()).equals("Recurring") && (startDate < endDate)) {
            boolean valid = true;
            if (task.checkTaskName(name, testList)) {
                if(freq == 1)
                    addRecurringDaily(name, category, startTime, duration, startDate, endDate);
                else if(freq == 7)
                    addRecurringWeekly(name, category, startTime, duration, startDate, endDate);
            }
        } else {
            System.out.println("Invalid Category or start and end date.\n");
        }
    }

    /**
     * Handles adding recurring daily tasks, this will calculate all the dates and ensures the
     * bounds are handled.  It will check for time overlap, but will not check for name or category since it is
     * prechecked in the createTask() method
     * @param name
     * @param type
     * @param startTime
     * @param duration
     * @param startDate
     * @param endDate
     */
    public void addRecurringDaily(String name, String type, float startTime, float duration, int startDate, int endDate){
        for (int i = startDate; i <= endDate; i++) {
            String month = String.valueOf(i).substring(4, 6);
            String day = String.valueOf(i).substring(6, 8);
            String year = String.valueOf(i).substring(0, 4);
            int maxDay = calculateMaxDays(month, year);
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
                day = String.valueOf(Integer.valueOf(day));
                if(day.length() < 2)
                    day = "0" + day;
            }
            String newDate = year + month + day;
            Task task1 = new Task(name, type, startTime, duration);
            task1.setDate(Integer.valueOf(newDate));
            if(checkOccurrenceOverlap(task1))
                testList.add(task1);
            else
                System.out.println("Conflicting tasks, cannot add to schedule.");
        }
    }

    /**
     * Handles adding recurring weekly tasks, this will calculate all the dates and ensures the
     * bounds are handled.  It will check for time overlap, but will not check for name or category since it is
     * prechecked in the createTask() method
     * @param name
     * @param category
     * @param startTime
     * @param duration
     * @param startDate
     * @param endDate
     */
    public void addRecurringWeekly(String name, String category, float startTime, float duration, int startDate, int endDate){
        for (int i = startDate; i < endDate; i += 7) {
            String month = String.valueOf(i).substring(4, 6);
            String day = String.valueOf(i).substring(6, 8);
            String year = String.valueOf(i).substring(0, 4);
            int maxDay = calculateMaxDays(month, year);
            if (Integer.valueOf(day) > maxDay) {
                day = String.valueOf(i - maxDay);
                day = day.length() < 2 ? "0" + day : day;
                if (month.equals("12")) {
                    month = "01";
                    year = String.valueOf(Integer.valueOf(year) + 1);
                } else {
                    month = String.valueOf(Integer.valueOf(month) + 1);
                }
            } else {
                day = String.valueOf(Integer.valueOf(day));
            }
            String newDate = year + month + day;
            Task task1 = new Task(name, category, startTime, duration);
            task1.setDate(Integer.valueOf(newDate));
            if(checkOccurrenceOverlap(task1))
                testList.add(task1);
            else
                System.out.println("Conflicting tasks, cannot add to schedule.");
        }
    }

    public void addRecurringMonthly(String name, String category, float startTime, float duration, int startDate, int endDate){
        for (int i = startDate; i < endDate; i += 30) {
            String month = String.valueOf(i).substring(4, 6);
            String day = String.valueOf(i).substring(6, 8);
            String year = String.valueOf(i).substring(0, 4);
            int maxDay = calculateMaxDays(month, year);
            if (month.equals("01") && maxDay < 30) {
                month = "02";
                day = String.valueOf(maxDay);
            } else {
                if (Integer.valueOf(day) > maxDay) {
                    day = String.valueOf(i - maxDay);
                    day = day.length() < 2 ? "0" + day : day;
                    if (month.equals("12")) {
                        month = "01";
                        year = String.valueOf(Integer.valueOf(year) + 1);
                    } else {
                        month = String.valueOf(Integer.valueOf(month) + 1);
                    }
                } else {
                    day = String.valueOf(Integer.valueOf(day));
                }
                String newDate = year + month + day;
                Task task1 = new Task(name, category, startTime, duration);
                task1.setDate(Integer.valueOf(newDate));
                if (checkOccurrenceOverlap(task1))
                    testList.add(task1);
                else
                    System.out.println("Conflicting tasks, cannot add to schedule.");
            }
        }
    }


    /**
     * Calculates the last day of the given month
     * @param month
     * @return
     */
    public int calculateMaxDays(String month, String year){
        int leapYear = Integer.valueOf(year);
        if(monthsWith30.contains(month))
            return 30;
        else if(monthsWith31.contains(month))
            return 31;
        else if(((leapYear % 4 == 0) && (leapYear % 100 != 0)) || (leapYear % 400 == 0))
            return 29;
        else
            return 28;
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

    /**
     * Checks an overlap for a given transient task
     * @param checkingTask
     * @return
     */
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

    /**
     * Checks the overlap of an occurrence from a recurring task
     * @return boolean that denotes if there is an overlap
     */
    public boolean checkOccurrenceOverlap(Task task){
        for (int i =0; i < testList.size(); i++) {
            Task inTask = testList.get(i);
                if (inTask.getDate() == task.getDate()) {
                    float inListEndTime = inTask.getStartTime() + inTask.getDuration();
                    float inListStart = inTask.getStartTime();

                    float taskStart = task.getStartTime();
                    float taskEndTime = task.getStartTime() + task.getDuration();

                    if (inListStart <= taskStart && taskStart < inListEndTime)
                        return false;
                    else if(inListStart <= taskEndTime && taskEndTime < inListEndTime)
                        return false;
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

    public void deleteTask(String name, int date){
        for (int i = 0; i < testList.size(); i++){
            Task temp = testList.get(i);
            if (temp.getName().equals(name) && temp.getDate() == date){
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

    public void editTask(int date, String name){
        for (int i = 0; i < testList.size(); i++){
            Task temp = testList.get(i);
            if (temp.getName().equals(name) && temp.getDate() == date){
                editPrompt(temp);
            }
        }
    }

    public void editPrompt(Task task){
        Scanner scanner = new Scanner(System.in);
        System.out.print("New Name: ");
        task.setName(scanner.nextLine());

        System.out.print("New Category: ");
        task.setCategory(scanner.nextLine());

        System.out.print("New start time: ");
        task.setStart(scanner.nextFloat());

        System.out.print("New duration: ");
        task.setDuration(scanner.nextFloat());

        System.out.print("New date: ");
        task.setDate(scanner.nextInt());
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

    /**
     * Prints the schedule given a start and end date
     * @param start - day the schedule starts printing
     * @param end - day the schedule ends
     */
    public void schedulePrinter(int start, int end){
        for(int i = start; i <= end; i++){
            String month = String.valueOf(i).substring(4, 6);
            String day = String.valueOf(i).substring(6, 8);
            String year = String.valueOf(i).substring(0, 4);
            int maxDay = calculateMaxDays(month, year);
            if(Integer.valueOf(day) > maxDay) {
                if (month.equals("12")) {
                    month = "01";
                    day = "01";
                    year = String.valueOf(Integer.valueOf(year) + 1);
                } else {
                    month = String.valueOf(Integer.valueOf(month) + 1);
                    if(month.length() < 2)
                        month = "0" + month;
                    day = "01";
                }
                String newiValue = year + month + day;
                i = Integer.valueOf(newiValue);
            }
            System.out.println("\n\nDate: " + month + "/" + day + "/" + year);
            for(int j =0; j < testList.size(); j++){
                Task t= testList.get(j);
                if(t.getDate() == i) {
                    System.out.println("\nTask Name: " + t.getName());
                    System.out.println("Task start time: " + t.getRealTime(t.getStartTime()));
                    System.out.println("Task end time: " + t.getRealTime(t.getStartTime() + t.getDuration()));
                }
            }
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
