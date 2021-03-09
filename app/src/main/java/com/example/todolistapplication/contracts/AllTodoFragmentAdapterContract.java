package com.example.todolistapplication.contracts;

import android.content.Context;
import android.view.View;

import com.example.todolistapplication.adapters.AllTodoFragmentAdapter;

public class AllTodoFragmentAdapterContract {
    public interface allTodoFragmentAdapterPresenter {
        int listTodoSize();
        void onBindViewHolder(AllTodoFragmentAdapter.MyViewHolder holder, int position);
        public void updateStateTodo(int position, View view);
    }
}
