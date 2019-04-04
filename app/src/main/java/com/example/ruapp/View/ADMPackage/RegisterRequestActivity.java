package com.example.ruapp.View.ADMPackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ruapp.View.ADMPackage.RegisterRequestPackage.MyRecViewAdapter;
import com.example.ruapp.Controller.RegisterRequestController;
import com.example.ruapp.Model.Student;
import com.example.ruapp.R;

import java.util.ArrayList;
import java.util.List;

public class RegisterRequestActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyRecViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    List<Student> studentsList = new ArrayList<>();

    private RegisterRequestController registerRequestController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_request);

        recyclerView = findViewById(R.id.recViewID);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);

        registerRequestController = new RegisterRequestController( this);
        registerRequestController.fillStudentList(studentsList);

        initView();
    }

    public void removeItem(int position){
        studentsList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void initView(){

        setmAdapter(new MyRecViewAdapter(studentsList));
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(mLayoutManager);

        mAdapter.setOnClickListener(new MyRecViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }

            @Override
            public void onDeleteClick(int position) {
                //remove da lista e do bd_reg_req mas nao add no bd_students
                registerRequestController.deleteUser(studentsList.get(position).getnMatricula());
                removeItem(position);

                //Log.i("STUDENT:" + position, studentsList.get(position).getName()+"/"+studentsList.get(position).getCPF()+"/"+studentsList.get(position).getnMatricula());
            }

            @Override
            public void onAcceptClick(int position) {
                //remove da lista e do bd_reg_req E add no bd_students
                registerRequestController.updateUser(studentsList.get(position).getnMatricula());
                removeItem(position);
                //registerRequestController.updateUser(studentsList.get(position).getnMatricula());

            }
        });
    }

    public void setmAdapter(MyRecViewAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }
}
