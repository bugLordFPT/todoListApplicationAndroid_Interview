package com.example.todolistapplication.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.todolistapplication.R;
import com.example.todolistapplication.fragments.AllTodoFragment;
import com.example.todolistapplication.fragments.CompletedTodoFragment;
import com.example.todolistapplication.fragments.UnCompletedTodoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
private BottomNavigationView bottom_navigation;
private FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fm = getSupportFragmentManager();
        bottom_navigation = findViewById(R.id.bottom_navigation);

        AllTodoFragment allTodoFragment = new AllTodoFragment();
        loadFragment(allTodoFragment, "allTodo");
    }

    @Override
    protected void onStart() {
        super.onStart();
    bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.ic_all:
                    AllTodoFragment allTodoFragment = new AllTodoFragment();
                    loadFragment(allTodoFragment, "allTodo");
                    break;
                case R.id.ic_completed:
                    CompletedTodoFragment completedTodoFragment = new CompletedTodoFragment();
                    loadFragment(completedTodoFragment, "completedTodo");
                    break;
                case R.id.ic_un_completed:
                    UnCompletedTodoFragment unCompletedTodoFragment = new UnCompletedTodoFragment();
                    loadFragment(unCompletedTodoFragment, "unCompletedTodo");
                    break;
            }
            return true;
        }
    });
    }

    private void loadFragment(Fragment fragment, String fragmentTag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.listTodoLayout, fragment, fragmentTag);
        fragmentTransaction.commit();
    }
}
