package com.example.todolistapplication.contracts;

import android.content.Context;

import com.example.todolistapplication.presenters.CompletedTodoFragmentAdapterPresenterImpl;

public class CompletedTodoFragmentContract {
    public interface completedTodoFragmentView{
        public void setAdapter(CompletedTodoFragmentAdapterPresenterImpl completedTodoFragmentAdapterPresenter);
    }

    public interface completedTodoFragmentPresenter{
        public void loadData(Context context);
    }
}
