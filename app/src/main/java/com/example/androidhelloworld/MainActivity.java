package com.example.androidhelloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidhelloworld.model.Todo;
import com.example.androidhelloworld.model.TodoListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private Button submitBtn;
  private EditText createEt;
  private RecyclerView todoListRv;

  private RecyclerView.Adapter todoListAdapter;
  private RecyclerView.LayoutManager todoListLayoutManager;

  private List<Todo> todoList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initData();
    initView();
  }

  private void initData() {
    todoList = new ArrayList<>();
    todoList.add(new Todo("Hello"));
  }

  private void initView() {
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    submitBtn = findViewById(R.id.submitBtn);
    createEt = findViewById(R.id.createEt);
    todoListRv = findViewById(R.id.todoListRv);

    todoListLayoutManager = new LinearLayoutManager(this);
    todoListRv.setLayoutManager(todoListLayoutManager);
    todoListAdapter = new TodoListAdapter(todoList);
    todoListRv.setAdapter(todoListAdapter);

    initListener();
  }

  private void initListener() {
    submitBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String newTodo = createEt.getText().toString();
        todoList.add(new Todo(newTodo));
        todoListAdapter.notifyItemInserted(todoList.size());
        createEt.setText("");
      }
    });
  }
}
