package com.espresso.curso.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mReset_b;
    private Button mChangeActivity_b;
    private Button mChangeText_b;
    private EditText mText_et;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mText_et = findViewById(R.id.text);
        mTextView = findViewById(R.id.textView);

        mChangeActivity_b = findViewById(R.id.changeActivity);
        mReset_b = findViewById(R.id.reset);
        mChangeText_b = findViewById(R.id.changeTextView);

        mChangeActivity_b.setOnClickListener(this);
        mReset_b.setOnClickListener(this);
        mChangeText_b.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.reset:
                mText_et.setText("");
                break;
            case R.id.changeActivity:
                Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("input", mText_et.getText().toString());
                startActivity(intent);
                break;
            case R.id.changeTextView:
                mTextView.setText(mText_et.getText().toString());
                break;

        }
    }
}