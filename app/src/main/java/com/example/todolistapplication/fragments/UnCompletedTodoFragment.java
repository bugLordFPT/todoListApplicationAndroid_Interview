package com.example.todolistapplication.fragments;

import android.os.Bundle;
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
import com.example.todolistapplication.adapters.UnCompletedTodoFragmentAdapter;
import com.example.todolistapplication.contracts.UnCompletedTodoFragmentContract;
import com.example.todolistapplication.listeners.UnCompleted_Todo_Fragment_Listener;
import com.example.todolistapplication.presenters.UnCompletedTodoFragmentAdapterPresenterImpl;
import com.example.todolistapplication.presenters.UnCompletedTodoFragmentPresenterImpl;

public class UnCompletedTodoFragment extends Fragment implements UnCompletedTodoFragmentContract.unCompletedFragmentView, UnCompleted_Todo_Fragment_Listener {
    private RecyclerView recyclerView;
    private UnCompletedTodoFragmentPresenterImpl presenter;
    private UnCompletedTodoFragmentAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new UnCompletedTodoFragmentPresenterImpl(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_uncompleted_todo, container, false);
        recyclerView = view.findViewById(R.id.listUnCompletedTodoView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        presenter.loadData(getActivity().getApplicationContext());
        return view;
    }

    @Override
    public void setAdapter(UnCompletedTodoFragmentAdapterPresenterImpl unCompletedTodoFragmentAdapterPresenter) {
        adapter = new UnCompletedTodoFragmentAdapter(unCompletedTodoFragmentAdapterPresenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void reLoadFragment() {
        Fragment currentFragment = getFragmentManager().findFragmentByTag("unCompletedTodo");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.detach(currentFragment);
        fragmentTransaction.attach(currentFragment);
        fragmentTransaction.commit();
    }
}
