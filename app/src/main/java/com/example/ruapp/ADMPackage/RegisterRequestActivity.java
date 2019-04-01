package com.example.ruapp.ADMPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ruapp.ADMPackage.RegisterRequestPackage.MyRecViewAdapter;
import com.example.ruapp.Model.Student;
import com.example.ruapp.R;

import java.util.ArrayList;
import java.util.List;

public class RegisterRequestActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyRecViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    List<Student> studentsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_request);

        studentsList.add(new Student("aaaaa", "123", "321"));
        studentsList.add(new Student("bb", "123", "321"));
        studentsList.add(new Student("cc", "123", "321"));
        studentsList.add(new Student("aaaddaa", "123", "321"));
        studentsList.add(new Student("aaaaa", "123", "321"));
        studentsList.add(new Student("bb", "123", "321"));
        studentsList.add(new Student("cc", "123", "321"));
        studentsList.add(new Student("aaaddaa", "123", "321"));
        studentsList.add(new Student("aaaaa", "123", "321"));
        studentsList.add(new Student("bb", "123", "321"));
        studentsList.add(new Student("cc", "123", "321"));
        studentsList.add(new Student("aaaddaa", "123", "321"));
        studentsList.add(new Student("aaaaa", "123", "321"));
        studentsList.add(new Student("bb", "123", "321"));
        studentsList.add(new Student("cc", "123", "321"));
        studentsList.add(new Student("aaaddaa", "123", "321"));
       initView();
    }

    public void removeItem(int position){
        studentsList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void initView(){
        recyclerView = findViewById(R.id.recViewID);
        recyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyRecViewAdapter(studentsList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(mLayoutManager);

        mAdapter.setOnClickListener(new MyRecViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onDeleteClick(int position) {
                //remove da lista e do bd_reg_req mas nao add no bd_students
                removeItem(position);
            }

            @Override
            public void onAcceptClick(int position) {
                //remove da lista e do bd_reg_req E add no bd_students
                removeItem(position);

            }
        });
    }
}
