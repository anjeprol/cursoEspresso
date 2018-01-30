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

    /**
     * You must implement this callback, which fires when the system first creates the activity.
     * On activity creation, the activity enters the Created state. In the onCreate() method,
     * you perform basic application startup logic that should happen only once for the entire
     * life of the activity.
     *
     * @param savedInstanceState Bundle object containing the activity's previously saved state.
     *                           If the activity has never existed before, the value of the Bundle
     *                           object is null
     */
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

    /**
     * You must implement onClick method, when you are handling clicks events into yor app, the
     * best practice is contain each one using switch statement.
     *
     * @param view View object that contain the view to perform the click action.
     */
    @Override
    public void onClick(final View view) {
        switch (view.getId()) {
            //Event for reset button
            case R.id.reset:
                mEditText.setText(R.string.str_empty_valid);
                break;
            //Event for change activity button
            case R.id.changeActivity:
                final Intent intent = new Intent(this, Main2Activity.class);
                intent.putExtra("input", mEditText.getText().toString());
                startActivity(intent);
                break;
            //Event for change text view
            case R.id.changeTextView:
                mTextView.setText(mEditText.getText().toString());
                break;
            //Event that should be performance by default action.
            default:
                break;
        }
    }
}
