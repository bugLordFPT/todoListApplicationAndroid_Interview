package com.example.todolistapplication.presenters;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

import com.example.todolistapplication.adapters.CompletedTodoFragmentAdapter;
import com.example.todolistapplication.contracts.CompletedTodoFragmentAdapterContract;
import com.example.todolistapplication.listeners.Completed_Todo_Fragment_Listener;
import com.example.todolistapplication.models.Task;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class CompletedTodoFragmentAdapterPresenterImpl implements CompletedTodoFragmentAdapterContract.completedTodoFragmentAdapter {
    private List<Task> listTodo;
    private Completed_Todo_Fragment_Listener mCallBack;

    public CompletedTodoFragmentAdapterPresenterImpl (List<Task> listTodo, Completed_Todo_Fragment_Listener mCallBack){
        this.listTodo = listTodo;
        this.mCallBack = mCallBack;
    }

    @Override
    public int listTodoSize() {
        return listTodo.size();
    }

    @Override
    public void onbindHolderView(CompletedTodoFragmentAdapter.MyViewHolder holder, int position) {
        holder.getTxtName().setText(listTodo.get(position).getName());
        if(listTodo.get(position).isDone()){
            holder.getBtnAction().setText("Completed");
            holder.getTxtCheckBox().setChecked(true);
        }else{
            holder.getBtnAction().setText("UnCompleted");
            holder.getTxtCheckBox().setChecked(false);
        }
    }

    @Override
    public void updateStateTodo(int position, View view) {
        String taskID = listTodo.get(position).getId();
        boolean oldState = listTodo.get(position).isDone();
        Context context = view.getContext();

        SharedPreferences pref = context.getSharedPreferences("listTodo", context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        Gson gson = new Gson();
        String json = pref.getString("TODO_LIST", "");
        Type type = new TypeToken<List<Task>>(){}.getType();

        List<Task> listOldTodo = gson.fromJson(json, type);
        if(listOldTodo != null){
            if(oldState){
                for (int i = 0; i < listOldTodo.size(); i++){
                    if(listOldTodo.get(i).getId().equals(taskID)){
                        listOldTodo.get(i).setDone(false);
                        break;
                    }
                }
            }else{
                for (int i = 0; i < listOldTodo.size(); i++){
                    if(listOldTodo.get(i).getId().equals(taskID)){
                        listOldTodo.get(i).setDone(true);
                        break;
                    }
                }
            }

            Gson gson2 = new Gson();
            String json2 = gson2.toJson(listOldTodo);
            editor.putString("TODO_LIST", json2);
            editor.commit();
        }

        mCallBack.reLoadFragment();
    }
}
