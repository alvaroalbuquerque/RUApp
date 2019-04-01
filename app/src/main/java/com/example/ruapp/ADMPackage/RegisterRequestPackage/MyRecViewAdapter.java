package com.example.ruapp.ADMPackage.RegisterRequestPackage;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ruapp.R;

import java.util.List;

public class MyRecViewAdapter extends RecyclerView.Adapter<MyRecViewAdapter.MyRecViewHolder> {
    private List< Student> studentList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);
        void onAcceptClick(int position);
    }

    public void setOnClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class MyRecViewHolder extends RecyclerView.ViewHolder{
        public TextView nameView;
        public TextView cpfView;
        public TextView nMatView;
        public ImageView rejectIcon;
        public ImageView acceptIcon;

        public MyRecViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            nameView = itemView.findViewById(R.id.nameViewID);
            cpfView = itemView.findViewById(R.id.cpfViewID);
            nMatView = itemView.findViewById(R.id.nMatViewID);
            rejectIcon = itemView.findViewById(R.id.rejectIcon);
            acceptIcon = itemView.findViewById(R.id.acceptIcon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

            rejectIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });

            acceptIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onAcceptClick(position);
                        }
                    }
                }
            });
        }
    }

    public MyRecViewAdapter (List<Student> studentList){
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public MyRecViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_register_request_card, viewGroup, false);
        MyRecViewHolder myRecViewHolder = new MyRecViewHolder(view, mListener);
        return myRecViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecViewHolder myRecViewHolder, int i) {
        Student currentStudent = studentList.get(i);
        myRecViewHolder.nameView.setText(currentStudent.getName());
        myRecViewHolder.cpfView.setText(currentStudent.getCPF());
        myRecViewHolder.nMatView.setText(currentStudent.getnMatricula());


    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
