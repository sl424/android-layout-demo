package com.layout.ui;

import java.util.Random;
import android.util.TypedValue;

import android.app.Activity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.LinearLayout;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.DividerItemDecoration;
import android.view.ViewGroup;
import android.view.LayoutInflater;
//import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;

public class stagger extends Activity {

	public class MyAdapter 
					 extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

		private String[] mDataset;
		private Random mRandom = new Random();
		//private int pad = 20;
		public MyAdapter(String[] myDataset) {
			mDataset = myDataset;
		}

		public class ViewHolder extends RecyclerView.ViewHolder {
			public TextView mTextView;
			public ViewHolder(TextView v) { super(v); mTextView = v; }
		}

		protected int getRandomIntInRange(int max, int min){
			return mRandom.nextInt((max-min)+min)+min;
		}

		@Override
		public MyAdapter.ViewHolder 
						 onCreateViewHolder(ViewGroup parent, int viewType) {

			TextView v = (TextView) LayoutInflater.from(parent.getContext())
					.inflate(R.layout.text, parent, false);
			//v.setPadding(pad,pad,pad,pad);
			ViewHolder vh = new ViewHolder(v);
			return vh;
		}
		@Override
		public void onBindViewHolder(ViewHolder holder, int position) {
			int tmp = getRandomIntInRange(150,75);
			holder.mTextView.setText(mDataset[position]);
			holder.mTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, tmp);
		}
		@Override
		public int getItemCount() {
			return mDataset.length;
		}
	}

	private static final String[] numbers 
		= { "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll);

		RecyclerView rv = (RecyclerView) findViewById(R.id.my_recycler_view);
		RecyclerView.LayoutManager lm = new StaggeredGridLayoutManager(3,
				StaggeredGridLayoutManager.VERTICAL);
		rv.setLayoutManager(lm);
		RecyclerView.Adapter adapter = new MyAdapter(numbers);
		rv.setAdapter(adapter);
    }
}

