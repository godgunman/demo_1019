package com.example.demoapp;

import com.parse.Parse;
import com.parse.ParseObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText editText;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Parse.initialize(this, "3OCZf9uNBUQG10wV7LnHViaXxHYvASPAvOaKdb23",
				"LNS4stNuomBtZqUQQNeeQQ2WQHtHV7mxz9FUAjp4");

		editText = (EditText) findViewById(R.id.editText1);
		button = (Button) findViewById(R.id.button1);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String text = editText.getText().toString();
				Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT)
						.show();

				ParseObject testObject = new ParseObject("Message");
				testObject.put("text", text);
				testObject.saveInBackground();
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
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
