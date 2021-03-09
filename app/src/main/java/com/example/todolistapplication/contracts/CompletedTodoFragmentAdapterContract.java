package com.example.todolistapplication.contracts;

import android.view.View;

import com.example.todolistapplication.adapters.CompletedTodoFragmentAdapter;

public class CompletedTodoFragmentAdapterContract {
    public interface completedTodoFragmentAdapter{
        public int listTodoSize();
        public void onbindHolderView(CompletedTodoFragmentAdapter.MyViewHolder holder, int position);
        public void updateStateTodo(int position, View view);
    }
}
