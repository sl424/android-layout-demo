package com.layout.ui;

import android.app.Activity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class grid extends Activity
{
	private static final String[] numbers 
		= { "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C" };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid); 
		GridView grid = (GridView) findViewById(R.id.text_grid); 
		grid.setAdapter(new ArrayAdapter<String>(this, R.layout.text, numbers));
    }
}

