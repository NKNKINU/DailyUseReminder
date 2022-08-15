package GUI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileManager  {
    private static FileManager instance;
    private Task cur_task;
    private ArrayList<Task> all_tasks;
    private FileManager (){}
    
    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }
    public boolean save(Task c) {
        boolean result;
        
        try {
            FileOutputStream fw=new FileOutputStream("data.txt", true);
            ObjectOutputStream outStream = new ObjectOutputStream(fw);
            outStream.writeObject(c);
            outStream.close();
            result=true;
        } catch (IOException e) {
            e.printStackTrace();
            result=false;
        }
        return result;
    }
    public ArrayList<Task> get_all() {
    	
    	
    	ArrayList<Task> tasks = new ArrayList<>();
    	
    	try {
            File file = new File("data.txt");
            if (!file.exists()) {
                FileWriter fw = new FileWriter("data.txt");
                fw.write("");
                fw.close();
            }
            FileInputStream f = new FileInputStream("data.txt");
    		while (true) {
    			try {
    				ObjectInputStream inStream = new ObjectInputStream(f);
        			tasks.add((Task) inStream.readObject());
    			}
    			
    			catch(EOFException e) {
    				break;
    			}
    		}	
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return tasks;
    }
    public void overwrite(List<Task> data) {
        try {
            FileWriter fw = new FileWriter("data.txt");
            fw.write("");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Task element : data) {
            save(element);
        }
    }
    public Task getCur_task() {
        return cur_task;
    }
    public ArrayList<Task> getAll_tasks() {
        return all_tasks;
    }
    public void load_AllTasks() {
        all_tasks = FileManager.getInstance().get_all();
    }
    public void setCur_task(Task t) {
        cur_task = t;
    }
}
