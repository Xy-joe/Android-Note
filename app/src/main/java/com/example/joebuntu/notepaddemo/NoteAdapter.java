package com.example.joebuntu.notepaddemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by joebuntu on 7/20/17.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteView> {
ArrayList<NoteContent> data = new ArrayList<>();
    Context context;
    ClickListner clickListner;
    private int item_layout;

    public NoteAdapter(ArrayList<NoteContent> data, int item_layout) {
        this.data = data;
        this.item_layout = item_layout;
    }
    public interface ClickListner {

        public void Itemclicked(View view, int position);

    }
    public void setClickListner(ClickListner clickListner){
        this.clickListner = clickListner;
    }


    @Override
    public NoteView onCreateViewHolder
            (ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(context).inflate(item_layout,parent,false);
        NoteView nv = new NoteView(v);
        return nv;
    }

    @Override
    public void onBindViewHolder(NoteView holder, int position) {
        NoteContent note = data.get(position);
        holder.name.setText(note.getFile_Name());
    holder.number.setText(note.getNo());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class NoteView extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView number, name;

        public NoteView(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            number = (TextView)itemView.findViewById(R.id.number);
            name = (TextView) itemView.findViewById(R.id.filename);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            NoteContent nc  = data.get(position);

            Intent intent = new Intent(context,MainActivity.class);
            intent.putExtra("index", nc.getNo());
            intent.putExtra("filename", nc.getFile_Name());
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);
        }
    }
}
