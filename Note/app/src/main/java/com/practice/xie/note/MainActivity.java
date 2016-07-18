package com.practice.xie.note;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends Activity {

    private RelativeLayout mainLayout;
    private Button addNote;
    private TextView returnData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        mainLayout = (RelativeLayout) findViewById(R.id.main_layout);
//        View item = LayoutInflater.from(MainActivity.this).inflate(R.layout.note_item, null);
//        mainLayout.addView(item);

        addNote = (Button) findViewById(R.id.add_note);
        addNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, NoteDetailActiviy.class);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                returnData = (TextView)findViewById(R.id.return_data);
                if(resultCode == RESULT_OK){
                    String noteContent = data.getStringExtra("noteContent");
                    returnData.setText(noteContent);
                }
                else if (resultCode == RESULT_CANCELED){
                    returnData.setText("您没有填写笔记哦~");
                }
                break;
            default:
                break;
        }
    }


}
