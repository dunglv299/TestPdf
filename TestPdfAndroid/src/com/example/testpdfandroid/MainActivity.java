package com.example.testpdfandroid;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String outputPath = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/Medtronic/output.pdf";
		new CRT_AUSTRALIA_Pdf(this, outputPath);
	}

}
