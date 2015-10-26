package com.epicodus.todolist.ui;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;

import com.epicodus.todolist.R;
import com.epicodus.todolist.models.Category;
import com.epicodus.todolist.models.Task;

import java.util.ArrayList;

public class CategoryActivity extends ListActivity {

    private Category mCategory;
    private ArrayList<String> mTasks;
    private Button mAddTaskButton;
    private EditText mNewTaskText;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        String name = getIntent().getStringExtra("categoryName");
        mCategory = Category.find(name);

        mTasks = new ArrayList<String>();
        for (Task task : mCategory.tasks()) {
            mTasks.add(task.getDescription());
        }
        mAddTaskButton = (Button) findViewById(R.id.addTaskButton);
        mNewTaskText = (EditText) findViewById(R.id.newTaskText);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, mTasks);
        setListAdapter(mAdapter);

        mAddTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        CheckedTextView task = (CheckedTextView)v;
        task.setChecked(!task.isChecked());
    }

    private void addTask() {
        String description = mNewTaskText.getText().toString();
        Task newTask = new Task(description, mCategory);
        newTask.save();
        mTasks.add(description);
        mAdapter.notifyDataSetChanged();
        mNewTaskText.setText("");
    }

}
