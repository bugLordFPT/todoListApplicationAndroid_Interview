package com.example.todolistapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistapplication.R;
import com.example.todolistapplication.presenters.CompletedTodoFragmentAdapterPresenterImpl;

public class CompletedTodoFragmentAdapter extends RecyclerView.Adapter<CompletedTodoFragmentAdapter.MyViewHolder>{
    private CompletedTodoFragmentAdapterPresenterImpl presenter;

    public CompletedTodoFragmentAdapter (CompletedTodoFragmentAdapterPresenterImpl presenter){
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo_list, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
            presenter.onbindHolderView(holder, position);
            holder.getTxtCheckBox().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    presenter.updateStateTodo(position, v);
                }
            });
    }

    @Override
    public int getItemCount() {
        return presenter.listTodoSize();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName;
        private CheckBox txtCheckBox;
        private Button btnAction;

        public MyViewHolder(View view){
            super(view);
            this.txtName = view.findViewById(R.id.txtName);
            this.txtCheckBox = view.findViewById(R.id.txtCheckBox);
            this.btnAction = view.findViewById(R.id.btnAction);
        }


        public TextView getTxtName() {
            return txtName;
        }

        public CheckBox getTxtCheckBox() {
            return txtCheckBox;
        }

        public Button getBtnAction() {
            return btnAction;
        }
    }
}
