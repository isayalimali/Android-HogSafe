package com.example.project_1110;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private Context mContext;
    private ArrayList<String> restName;
    private ArrayList<String> restType;
    private ArrayList<String> restAdd;
    private int[] foodImage;


    public RecyclerViewAdapter(Context mContext,ArrayList<String> restName, ArrayList<String> restType, ArrayList<String> restAdd, int[] foodImage) {
        this.restName = restName;
        this.restType = restType;
        this.restAdd = restAdd;
        this.foodImage = foodImage;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");

        int image_id = foodImage[position];
        holder.imageFood.setImageResource(image_id);
        holder.resName.setText(restName.get(position));
        holder.resAdd.setText(restAdd.get(position));
        holder.resType.setText(restType.get(position));

        holder.menuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: "+ restName.get(position));
                Toast.makeText(mContext, restName.get(position), Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this,SecondActivity.class);
//                intent.putExtra("note_position",position);
//                startActivityForResult(intent,1000);
            }
        });

        holder.selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClickButton "+ restName.get(position));
                Toast.makeText(mContext, "Button"+restName.get(position), Toast.LENGTH_SHORT).show();
                //onClick(v);
            }
        });
    }
//    private void onClick(View v){
//
//    }
    @Override
    public int getItemCount() {
        return restName.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageFood;
        TextView resName;
        TextView resType;
        TextView resAdd;
        Button selectBtn;
        ConstraintLayout menuLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageFood = itemView.findViewById(R.id.imageView2);
            resName = itemView.findViewById(R.id.textView5);
            resType = itemView.findViewById(R.id.textView6);
            resAdd = itemView.findViewById(R.id.textView7);
            selectBtn = itemView.findViewById(R.id.select);
            menuLayout = itemView.findViewById(R.id.menuLayout);

        }
    }
}
