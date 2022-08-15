package GUI;

import java.io.Serializable;
import java.time.*;

public class Task implements Serializable{
    private LocalDateTime time;
    private String title;
    private String notes;
    private boolean isImportant;

    public Task(LocalDateTime time, String title, String notes, boolean important){
    	if (title.equals("")) {
    		this.title = "No Title";
    	}else {
    		this.title = title;
    	}
    	if (notes.equals("")) {
    		this.notes = "no notes";
    	}else {
    		this.notes = notes;
    	}
        this.time = time;
        this.isImportant = important;
    }

    @Override
    public String toString() {
        String res = title;
        return res;
    }

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public boolean isImportant() {
		return isImportant;
	}

	public void setImportant(boolean isImportant) {
		this.isImportant = isImportant;
	}
}
