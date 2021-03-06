package com.example.demoapp;

import java.util.ArrayList;
import java.util.List;

import com.parse.DeleteCallback;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView textView;
	private EditText editText;
	private Button button;
	private ListView listView;
	private ProgressBar progressBar;
	private String nickname;
	private List<ParseObject> messages;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView = (TextView) findViewById(R.id.textView1);
		editText = (EditText) findViewById(R.id.editText1);
		button = (Button) findViewById(R.id.button1);
		listView = (ListView) findViewById(R.id.listView1);
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String text = nickname + " : " + editText.getText().toString();
				Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT)
						.show();

				ParseObject testObject = new ParseObject("Message");
				testObject.put("text", text);
				testObject.saveInBackground(new SaveCallback() {

					@Override
					public void done(ParseException e) {
						loadDataFromParse();
					}
				});

				ParsePush push = new ParsePush();
				push.setChannel("all");
				push.setMessage(text);
				push.sendInBackground();
			}
		});

		nickname = getIntent().getStringExtra("nickname");
		textView.setText(nickname);

		loadDataFromParse();
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> adapter, View view,
					int position, long id) {
				messages.get(position).deleteInBackground(new DeleteCallback() {

					@Override
					public void done(ParseException e) {
						loadDataFromParse();
					}
				});
				return false;
			}
		});

	}

	private void loadDataFromParse() {
		listView.setVisibility(View.INVISIBLE);
		progressBar.setVisibility(View.VISIBLE);

		ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("Message");
		query.orderByDescending("createdAt");
		query.findInBackground(new FindCallback<ParseObject>() {

			@Override
			public void done(List<ParseObject> objects, ParseException e) {
				messages = objects;

				progressBar.setVisibility(View.GONE);
				listView.setVisibility(View.VISIBLE);

				List<String> data = new ArrayList<String>();
				for (ParseObject object : objects) {
					String text = object.getString("text");
					data.add(text);
				}
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(
						MainActivity.this, android.R.layout.simple_list_item_1,
						data);
				listView.setAdapter(adapter);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_refresh) {
			loadDataFromParse();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
