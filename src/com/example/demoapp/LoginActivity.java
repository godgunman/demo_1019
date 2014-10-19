package com.example.demoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {

	private EditText editText;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		editText = (EditText) findViewById(R.id.editText1);
		button = (Button) findViewById(R.id.button1);

		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String nickname = editText.getText().toString();
				
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, 
						MainActivity.class);
				intent.putExtra("nickname", nickname);
				startActivity(intent);
			}
		});
	}
}
