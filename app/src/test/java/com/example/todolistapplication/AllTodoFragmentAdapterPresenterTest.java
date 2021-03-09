package com.example.todolistapplication;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.todolistapplication.adapters.AllTodoFragmentAdapter;
import com.example.todolistapplication.listeners.All_Todo_Fragment_Listener;
import com.example.todolistapplication.models.Task;
import com.example.todolistapplication.presenters.AllTodoFragmentAdapterPresenterImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class AllTodoFragmentAdapterPresenterTest {

    private List<Task> testListTodo = new ArrayList<>();
    @Mock
    AllTodoFragmentAdapterPresenterImpl mMockAllTodoFragmentAdapterPresenterImpl;
    @Mock
    View mMockView;
    @Mock
    Context mMockContext;
    @Mock
    All_Todo_Fragment_Listener mMockAllTodoFragmentListener;
    @Mock
    AllTodoFragmentAdapter.MyViewHolder mMockHolder;
    @Mock
    TextView mMockTextView;
    @Mock
    AllTodoFragmentAdapter mMockAdapter;

    @Before
    public void initMocks(){
        loadData();
        mMockAllTodoFragmentAdapterPresenterImpl = new AllTodoFragmentAdapterPresenterImpl(testListTodo, mMockAllTodoFragmentListener);
        mMockAdapter = new AllTodoFragmentAdapter(mMockAllTodoFragmentAdapterPresenterImpl);

    }

    @Test
    public void testReturnListSize(){
        Assert.assertTrue(testListTodo.size() == mMockAllTodoFragmentAdapterPresenterImpl.listTodoSize());
    }

    @Test
    public void testOnBindDataCompleted(){
        int position = 2;
//        Mockito.when(mMockHolder).thenReturn(mMockAdapter.onCreateViewHolder(, 0));
//        mMockAllTodoFragmentAdapterPresenterImpl.onBindViewHolder(mMockHolder, position);
//        Mockito.when(testListTodo.get(position).isDone()).thenReturn(false);
    }
    private void loadData(){
        testListTodo.add(new Task("TD01", "task a", false));
        testListTodo.add(new Task("TD02", "task b", true));
        testListTodo.add(new Task("TD03", "task c", false));
        testListTodo.add(new Task("TD04", "task d", true));
    }
}
