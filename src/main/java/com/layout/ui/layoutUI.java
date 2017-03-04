package com.layout.ui;

import android.app.Activity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.LinearLayout;
import static android.widget.LinearLayout.VERTICAL;

import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.Arrays;
import android.content.Context;

public class layoutUI extends Activity
{
	public class MyArrayAdapter extends ArrayAdapter<String[]>{
		private Context mContext;
		private String[] data;
		private int rowLayout;
		public MyArrayAdapter(Context context, int layoutResourceId, String[] temp) {
			super(context, layoutResourceId);
			this.rowLayout = layoutResourceId;
			this.mContext = context;
			this.data = temp;
		}
		public class ViewHolder { Button button; }

		@Override
		public int getCount() {
			return data.length;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent){
			View row = convertView;
			ViewHolder holder = null; 
			LayoutInflater inflater = ((Activity) mContext).getLayoutInflater(); 
			row = inflater.inflate(rowLayout, parent, false);

			holder = new ViewHolder();
			holder.button = (Button) row.findViewById(R.id.aButton);
			holder.button.setText(data[position]);
			final int pos = position;
			holder.button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View row) {
					Log.v("*******", "pos is "+pos);
					chooseClick(pos);
				}
			});
			row.setTag(position);
			return row;
		}
	}

	private String[] items	
		= { "Grid Layout", "List Layout", "Scroll View", "Stagger Layout"}; 
	private Class<?>[] itemClass = {grid.class, list.class, 
		scroll.class, stagger.class}; 
	public void chooseClick(int pos) {
				Intent intent0 = new Intent(getBaseContext(), itemClass[pos]);
				startActivity(intent0);
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//MyArrayAdapter adapter = new MyArrayAdapter(this, R.layout.row, items);
		ListView ls = (ListView) findViewById(R.id.list);
		ls.setAdapter( new MyArrayAdapter(this, R.layout.row, items));
		//ls.setAdapter(adapter);
	}
}

