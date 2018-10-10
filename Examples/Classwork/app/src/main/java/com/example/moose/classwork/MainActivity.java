package com.example.moose.classwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mTv1;
    EditText mEt1;
    Button mBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTv1=findViewById(R.id.textView);
        mEt1=findViewById(R.id.editText);
        mBtn1=findViewById(R.id.btn_submit);

        mBtn1.setOnClickListener(this::btn_submit_func);
    }

    public void btn_submit_func(View view) {
        mTv1.setText(mEt1.getText().toString().trim());
    }
}
