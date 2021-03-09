package com.example.todolistapplication.contracts;

import android.content.Context;

import com.example.todolistapplication.presenters.UnCompletedTodoFragmentAdapterPresenterImpl;

public class UnCompletedTodoFragmentContract {
    public interface unCompletedFragmentPresenter{
        public void loadData(Context context);
    }

    public  interface unCompletedFragmentView{
        public void setAdapter(UnCompletedTodoFragmentAdapterPresenterImpl unCompletedTodoFragmentAdapterPresenter);
    }
}
