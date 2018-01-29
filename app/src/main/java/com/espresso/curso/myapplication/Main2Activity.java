/*
 *      File: Main2Activity.java
 *    Author: Antonio Prado <antonio.prado@amk-technologies.com>
 *      Date: Jan 30, 2018
 * Copyright: AMK Technologies, S.A. de C.V. 2017
 */

package com.espresso.curso.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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


public class Main2Activity extends AppCompatActivity {
    /**
     * The name of text view.
     */
    private TextView mTextView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mTextView = findViewById(R.id.text2);

        final Bundle inputData = getIntent().getExtras();
        final String input = inputData.getString("input");
        mTextView.setText(input);
    }
}
