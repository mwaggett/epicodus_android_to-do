package com.epicodus.todolist.models;

import android.content.pm.LabeledIntent;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Guest on 10/26/15.
 */
@Table(name = "tasks", id = "_id")
public class Task extends Model {

    @Column(name = "description")
    private String mDescription;

    @Column(name = "Category")
    private Category mCategory;

    public Task() {
        super();
    }

    public Task(String description, Category category) {
        super();
        mDescription = description;
        mCategory = category;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;
    }

    public static List<Task> all() {
        return new Select().from(Task.class).execute();
    }
}
