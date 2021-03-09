package com.example.todolistapplication.contracts;

import android.view.View;

import com.example.todolistapplication.adapters.UnCompletedTodoFragmentAdapter;

public class UnCompletedTodoFragmentAdapterContract {
    public interface unCompletedFragmentAdapterPresenter{
        public int listTodoSize();
        public void onbindViewHolder(UnCompletedTodoFragmentAdapter.MyViewHolder holder, int position);
        public void updateStateTodo(int position, View view);
    }
}
