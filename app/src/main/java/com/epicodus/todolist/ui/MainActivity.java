package com.epicodus.todolist.ui;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.todolist.R;
import com.epicodus.todolist.models.Task;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    private ArrayList<String> mTasks;
    private Button mAddTaskButton;
    private EditText mNewTaskText;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTasks = new ArrayList<String>();
        for (Task task : Task.all()) {
            mTasks.add(task.getDescription());
        }
        mAddTaskButton = (Button) findViewById(R.id.addTaskButton);
        mNewTaskText = (EditText) findViewById(R.id.newTaskText);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mTasks);
        setListAdapter(mAdapter);

        mAddTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });

    }

    private void addTask() {
        String description = mNewTaskText.getText().toString();
        Task newTask = new Task(description);
        newTask.save();
        mTasks.add(description);
        mAdapter.notifyDataSetChanged();
        mNewTaskText.setText("");
    }

}