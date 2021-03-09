package com.example.todolistapplication.presenters;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.todolistapplication.contracts.UnCompletedTodoFragmentContract;
import com.example.todolistapplication.listeners.UnCompleted_Todo_Fragment_Listener;
import com.example.todolistapplication.models.Task;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class UnCompletedTodoFragmentPresenterImpl implements UnCompletedTodoFragmentContract.unCompletedFragmentPresenter {
    private List<Task> listTodo = new ArrayList<>();
    private UnCompletedTodoFragmentContract.unCompletedFragmentView view;
    private UnCompletedTodoFragmentAdapterPresenterImpl adapterPresenter;

    public UnCompletedTodoFragmentPresenterImpl(UnCompletedTodoFragmentContract.unCompletedFragmentView view){
        this.view = view;
    }

    @Override
    public void loadData(Context context) {
        if(listTodo != null){
            if(!listTodo.isEmpty()){
                listTodo.clear();
            }
        }

        try{
            SharedPreferences sharedPreferences = context.getSharedPreferences("listTodo", context.MODE_PRIVATE);

            Gson gson = new Gson();
            String json = sharedPreferences.getString("TODO_LIST", "");
            Type type = new TypeToken<List<Task>>(){}.getType();

            listTodo = gson.fromJson(json, type);
            List<Task> listTmp = new ArrayList<>();
            if(listTodo != null){
                for (int i = 0; i < listTodo.size(); i++){
                    if(listTodo.get(i).isDone() == false){
                        listTmp.add(listTodo.get(i));
                    }
                }

                adapterPresenter = new UnCompletedTodoFragmentAdapterPresenterImpl(listTmp, (UnCompleted_Todo_Fragment_Listener) view);
                view.setAdapter(adapterPresenter);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
