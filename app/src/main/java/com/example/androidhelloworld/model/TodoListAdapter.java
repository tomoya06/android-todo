package com.example.androidhelloworld.model;

import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoListItemViewHolder> {
  private List<Todo> todoList;

  @NonNull
  @Override
  public TodoListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    TextView tv = new TextView(parent.getContext());
    return new TodoListItemViewHolder(tv);
  }

  @Override
  public void onBindViewHolder(@NonNull TodoListItemViewHolder holder, int position) {
    holder.contentTv.setText(todoList.get(position).getContent());
  }

  @Override
  public int getItemCount() {
    return todoList.size();
  }

  public static class TodoListItemViewHolder extends RecyclerView.ViewHolder {
    public TextView contentTv;

    public TodoListItemViewHolder(TextView textView) {
      super(textView);
      contentTv = textView;
    }
  }
}
