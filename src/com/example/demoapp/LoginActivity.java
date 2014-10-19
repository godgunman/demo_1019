package com.example.demoapp;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParsePush;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	private EditText editText;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		Parse.initialize(this, "3OCZf9uNBUQG10wV7LnHViaXxHYvASPAvOaKdb23",
				"LNS4stNuomBtZqUQQNeeQQ2WQHtHV7mxz9FUAjp4");
		ParseInstallation.getCurrentInstallation().saveInBackground();
		ParsePush.subscribeInBackground("all");
		
		editText = (EditText) findViewById(R.id.editText1);
		button = (Button) findViewById(R.id.button1);

		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				go();
			}
		});

		editText.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN
						&& keyCode == KeyEvent.KEYCODE_ENTER) {
					go();
					return true;
				}

				return false;
			}
		});
	}

	private void go() {
		String nickname = editText.getText().toString();

		Intent intent = new Intent();
		intent.setClass(LoginActivity.this, MainActivity.class);
		intent.putExtra("nickname", nickname);
		startActivity(intent);
	}
}
