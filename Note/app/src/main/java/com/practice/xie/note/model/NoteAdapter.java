package com.practice.xie.note.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.practice.xie.note.R;

import java.util.List;

/**
 * Created by xie on 2016/7/20.
 */
public class NoteAdapter extends ArrayAdapter<Note>{
    private int resourceId;

    public NoteAdapter(Context context, int resource, List<Note> objects) {
        super(context, resource, objects);
        this.resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Note note = getItem(position);
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        }else{
            view = convertView;
        }
        TextView noteTitle = (TextView)view.findViewById(R.id.note_title);
        TextView noteTime = (TextView)view.findViewById(R.id.note_time);
        noteTitle.setText(note.getNoteName());
        noteTime.setText(note.getNoteDate());
        return view;
    }
}
