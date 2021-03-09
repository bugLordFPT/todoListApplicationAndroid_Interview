package com.example.todolistapplication.presenters;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.todolistapplication.contracts.AllTodoFragmentContract;
import com.example.todolistapplication.listeners.All_Todo_Fragment_Listener;
import com.example.todolistapplication.models.Task;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AllTodoFragmentPresenterImpl implements AllTodoFragmentContract.allTodoFragmentPresenter {
    private List<Task> listTodo;
    private AllTodoFragmentContract.allTodoFragmentView view;
    private AllTodoFragmentAdapterPresenterImpl adapterPresenter;

    public AllTodoFragmentPresenterImpl(AllTodoFragmentContract.allTodoFragmentView view){
        this.view = view;
    }

    @Override
    public void loadListTodo(Context context) {
        if(listTodo != null){
            if(!listTodo.isEmpty()){
                listTodo.clear();
            }
        }

        try{
            SharedPreferences sharedPreferences = context.getSharedPreferences("listTodo", context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            Gson gson = new Gson();
            String json = sharedPreferences.getString("TODO_LIST", "");
            Type type = new TypeToken<List<Task>>(){}.getType();

            listTodo = gson.fromJson(json, type);

            if(listTodo == null){
                listTodo = new ArrayList<>();
                listTodo.add(new Task("TD01", "Lau nha", false));
                listTodo.add(new Task("TD02", "Nau com", true));
                listTodo.add(new Task("TD03", "Giat do", false));
                listTodo.add(new Task("TD04", "Di cho", true));
                listTodo.add(new Task("TD05", "don rac", false));
                listTodo.add(new Task("TD06", "hoc bai", true));

                Gson gson2 = new Gson();
                String json2 = gson2.toJson(listTodo);
                editor.putString("TODO_LIST", json2);
                editor.commit();
            }

            adapterPresenter = new AllTodoFragmentAdapterPresenterImpl(listTodo, (All_Todo_Fragment_Listener) view);
            view.setAdapter(adapterPresenter);



        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
