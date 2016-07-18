package com.practice.xie.note;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by xie on 2016/7/14.
 */
public class NoteDetailActiviy extends Activity{
    private EditText noteContent;
    private Button submitDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_detail);

        noteContent = (EditText)findViewById(R.id.note_content);
        submitDetail = (Button)findViewById(R.id.submit_detail);

        submitDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String noteString = noteContent.getText().toString();
                if(noteString.isEmpty()){
                    Toast.makeText(NoteDetailActiviy.this, "笔记内容不能为空~" ,Toast.LENGTH_SHORT).show();
                }else{
                    new AlertDialog.Builder(NoteDetailActiviy.this)
                            .setCancelable(false)
                            .setTitle("确认提交")
                            .setMessage("确认提交此次填写的内容？")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent i = new Intent();
                                    i.putExtra("noteContent", noteString);
                                    setResult(RESULT_OK, i);
                                    finish();
                                }
                            })
                            .setNegativeButton("再看一会", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent bi = new Intent(NoteDetailActiviy.this, MainActivity.class);
        setResult(RESULT_CANCELED);
        finish();
    }
}
