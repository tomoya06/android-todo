package com.example.androidhelloworld.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidhelloworld.R;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoListItemViewHolder> {
  private List<Todo> todoList;

  @NonNull
  @Override
  public TodoListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
    return new TodoListItemViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull TodoListItemViewHolder holder, int position) {
    holder.contentTv.setText(todoList.get(position).getContent());
  }

  @Override
  public int getItemCount() {
    return todoList.size();
  }

  @Override
  public int getItemViewType(int position) {
    return R.layout.todo_listitem;
  }

  class TodoListItemViewHolder extends RecyclerView.ViewHolder {
    TextView contentTv;
    Button removeBtn;
    Button editBtn;

    TodoListItemViewHolder(View view) {
      super(view);
      contentTv = view.findViewById(R.id.todoListItemContentTv);
      removeBtn = view.findViewById(R.id.todoListItemRemoveBtn);
      editBtn = view.findViewById(R.id.todoListItemEditBtn);

      initView();
    }

    private void initView() {
      removeBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          int position = getAdapterPosition();
          todoList.remove(position);
        }
      });
    }
  }
}
