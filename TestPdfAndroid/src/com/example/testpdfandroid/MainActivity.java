package com.example.testpdfandroid;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private Button btnEmail;
	String outputPath;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnEmail = (Button) findViewById(R.id.btn_send_email);
		btnEmail.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_send_email:

			// Create folder
			File folder = new File(Environment.getExternalStorageDirectory()
					.getAbsolutePath() + "/ScreenLink");
			try {
				folder.mkdir();
			} catch (Exception ex) {
			}
			outputPath = Environment.getExternalStorageDirectory()
					.getAbsolutePath() + "/ScreenLink/output.pdf";
			new CRT_AUSTRALIA_Pdf(this, outputPath);

			File f = new File(outputPath);

			String subject = "Subject";
			String message = "Message\ndunglv";
			Intent email = new Intent(Intent.ACTION_SEND);
			email.putExtra(Intent.EXTRA_SUBJECT, subject);
			email.putExtra(Intent.EXTRA_TEXT, message);
			email.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(f));
			email.setType("message/rfc822");
			startActivityForResult(email, 20);
			break;

		default:
			break;
		}
	}
}
