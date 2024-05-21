package com.apexgroup.todos.persistance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    private long Id;

    private String Description;
   
    private String duedate;
    
    public long getId() {
        return Id;
    }

    private void setId(long id) {
            Id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    private Todo() {
    }

    private Todo(String description) {
        this.Description = description;
    }

    public static Todo Create(String description) {
        return new Todo(description);
    }

    /**
     * @return String return the Duedate
     */
    public String getDuedate() {
        return duedate;
    }

    /**
     * @param Duedate the Duedate to set
     */
    public void setDuedate(String Duedate) {
        this.duedate = Duedate;
    }

}
