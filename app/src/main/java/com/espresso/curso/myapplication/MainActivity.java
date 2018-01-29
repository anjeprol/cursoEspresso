/*
 *      File: MainActivity.java
 *    Author: Antonio Prado <antonio.prado@amk-technologies.com>
 *      Date: Jan 30, 2018
 * Copyright: AMK Technologies, S.A. de C.V. 2017
 */

package com.espresso.curso.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Espresso course.
 *
 * <p>This is the main class to run the test project.
 * The propose of this project is to help any new member get knowledge creating functional testing
 * working with Espresso.</p>
 *
 * @author Antonio Prado &lt;antonio.prado@amk-technologies.com&gt;
 * @version 1.0.0
 * @since 1.0.0
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * The name of reset button.
     */
    private Button mResetButton;
    /**
     * The name of change activity button.
     */
    private Button mChangeActivityButton;
    /**
     * The name of change text button.
     */
    private Button mChangeTextButton;
    /**
     * The name of edit text..
     */
    private EditText mEditText;
    /**
     * The name of text view.
     */
    private TextView mTextView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.text);
        mTextView = findViewById(R.id.textView);

        mChangeActivityButton = findViewById(R.id.changeActivity);
        mResetButton = findViewById(R.id.reset);
        mChangeTextButton = findViewById(R.id.changeTextView);

        mChangeActivityButton.setOnClickListener(this);
        mResetButton.setOnClickListener(this);
        mChangeTextButton.setOnClickListener(this);
    }

    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            case R.id.reset:
                mEditText.setText(R.string.str_empty_valid);
                break;
            case R.id.changeActivity:
                final Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("input", mEditText.getText().toString());
                startActivity(intent);
                break;
            case R.id.changeTextView:
                mTextView.setText(mEditText.getText().toString());
                break;
            default:
                break;
        }
    }
}
