package com.example.joebuntu.notepaddemo;

import android.content.Context;
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

    public NoteAdapter(ArrayList<NoteContent> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public NoteView onCreateViewHolder
            (ViewGroup parent, int viewType) {
        View v  = LayoutInflater.from(context).inflate(R.layout.content_saved_files,parent,false);
        NoteView nv = new NoteView(v);
        return nv;
    }

    @Override
    public void onBindViewHolder(NoteView holder, int position) {
        NoteContent note = data.get(position);
        holder.name.setText(note.getHeader());
    holder.number.setText(note.getBody());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class NoteView extends RecyclerView.ViewHolder{
        public TextView number, name;

        public NoteView(View itemView) {
            super(itemView);
            number = (TextView)itemView.findViewById(R.id.number);
            name = (TextView) itemView.findViewById(R.id.filename);
        }
    }
}
