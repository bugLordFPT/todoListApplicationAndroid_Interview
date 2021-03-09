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
import com.example.todolistapplication.adapters.AllTodoFragmentAdapter;
import com.example.todolistapplication.contracts.AllTodoFragmentContract;
import com.example.todolistapplication.listeners.All_Todo_Fragment_Listener;
import com.example.todolistapplication.presenters.AllTodoFragmentAdapterPresenterImpl;
import com.example.todolistapplication.presenters.AllTodoFragmentPresenterImpl;

public class AllTodoFragment extends Fragment implements AllTodoFragmentContract.allTodoFragmentView, All_Todo_Fragment_Listener {
    private AllTodoFragmentContract.allTodoFragmentPresenter presenter;
    private RecyclerView recyclerView;
    private AllTodoFragmentAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AllTodoFragmentPresenterImpl(this);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_all_todo, container, false);
        recyclerView = view.findViewById(R.id.listAllTodoRecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        presenter.loadListTodo(getActivity().getApplicationContext());
        return view;
    }

    @Override
    public void setAdapter(AllTodoFragmentAdapterPresenterImpl allTodoFragmentAdapterPresenter) {
        adapter = new AllTodoFragmentAdapter(allTodoFragmentAdapterPresenter);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void reloadFragment() {
        Fragment currentFragment = getFragmentManager().findFragmentByTag("allTodo");
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.detach(currentFragment);
        fragmentTransaction.attach(currentFragment);
        fragmentTransaction.commit();
    }
}
