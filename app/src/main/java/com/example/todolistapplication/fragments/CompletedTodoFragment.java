package com.example.todolistapplication.fragments;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistapplication.R;
import com.example.todolistapplication.adapters.CompletedTodoFragmentAdapter;
import com.example.todolistapplication.contracts.CompletedTodoFragmentContract;
import com.example.todolistapplication.listeners.Completed_Todo_Fragment_Listener;
import com.example.todolistapplication.presenters.CompletedTodoFragmentAdapterPresenterImpl;
import com.example.todolistapplication.presenters.CompletedTodoFragmentPresenterImpl;

public class CompletedTodoFragment extends Fragment implements CompletedTodoFragmentContract.completedTodoFragmentView, Completed_Todo_Fragment_Listener {
    private CompletedTodoFragmentPresenterImpl presenter;
    private CompletedTodoFragmentAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CompletedTodoFragmentPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completed_todo, container, false);
        recyclerView = view.findViewById(R.id.listCompletedTodoView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        presenter.loadData(getActivity().getApplicationContext());
        return view;
    }

    @Override
    public void setAdapter(CompletedTodoFragmentAdapterPresenterImpl completedTodoFragmentAdapterPresenter) {
        adapter = new CompletedTodoFragmentAdapter(completedTodoFragmentAdapterPresenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void reLoadFragment() {
        Fragment currentFragment = getFragmentManager().findFragmentByTag("completedTodo");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.detach(currentFragment);
        fragmentTransaction.attach(currentFragment);
        fragmentTransaction.commit();
    }
}
