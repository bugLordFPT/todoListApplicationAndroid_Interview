package com.example.todolistapplication.contracts;

import android.content.Context;

import com.example.todolistapplication.presenters.AllTodoFragmentAdapterPresenterImpl;

public class AllTodoFragmentContract {
    public interface allTodoFragmentPresenter{
        void loadListTodo(Context context);
    }

    public interface allTodoFragmentView{
        void setAdapter(AllTodoFragmentAdapterPresenterImpl allTodoFragmentAdapterPresenter);
    }
}
