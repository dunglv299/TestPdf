package com.example.testpdfandroid;
/*package com.persei.screenlink.activity;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.persei.screenlink.R;
import com.persei.screenlink.entity.ScreenLink;
import com.persei.screenlink.utils.Utils;

public class BackupMainActivity extends FragmentActivity implements OnClickListener,
		FirstFragment.OnDataPass {

	Button btnAbout, btnRegion, btnTherapies;
	int tabSelect;
	int saveTab;
	private ScreenLink screenLink;
	FirstFragment firstFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (!Utils.isTablet(getApplicationContext())) {
			// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
			// setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

		}

		btnAbout = (Button) findViewById(R.id.main_btn_first);
		btnRegion = (Button) findViewById(R.id.main_btn_second);
		btnTherapies = (Button) findViewById(R.id.main_btn_third);
		btnAbout.setOnClickListener(this);
		btnRegion.setOnClickListener(this);
		btnTherapies.setOnClickListener(this);
		screenLink = new ScreenLink(false, "", false);
		initFragment();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putInt("tab_select", tabSelect);
		Log.e("onsave", screenLink.getLvef());
		outState.putString("lvef", screenLink.getLvef());
		outState.putBoolean("echoAvailable", screenLink.isEchoAvailable());
		outState.putBoolean("priorMRI", screenLink.isPriorMRI());
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		if (savedInstanceState != null) {
			saveTab = savedInstanceState.getInt("tab_select");
			if (saveTab == 1) {
				btnAbout.performClick();
			} else if (saveTab == 2) {
				btnRegion.performClick();
			} else if (saveTab == 3) {
				btnTherapies.performClick();
			}

			screenLink.setLvef(savedInstanceState.getString("lvef"));
			screenLink.setEchoAvailable(savedInstanceState
					.getBoolean("echoAvailable"));
			screenLink.setPriorMRI(savedInstanceState.getBoolean("priorMRI"));
			Log.e("text from fragment", screenLink.getLvef() + "");
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {

		case R.id.main_btn_first:
			Log.e("tabSelect", tabSelect + "");
			setFirstSelect();
			if (tabSelect == 1) {
				btnAbout.setEnabled(false);
			}
			firstFragment = new FirstFragment();
			Utils.replaceFragment(getSupportFragmentManager(), firstFragment,
					null, "about");
			break;
		case R.id.main_btn_second:
			setSecondSelect();
			Utils.replaceFragment(getSupportFragmentManager(),
					SecondFragment.newInstance(), null, "region");
			saveData();
			break;
		case R.id.main_btn_third:
			setThirdSelect();
			Utils.replaceFragment(getSupportFragmentManager(),
					ThirdFragment.newInstance(), null, "therapies");
			saveData();
			break;
		}
	}

	*//**
	 * Save data when replace fragment
	 *//*
	public void saveData() {
		btnAbout.setEnabled(true);
		screenLink.setLvef(firstFragment.getEdLVEF());
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		// finish();
	}

	private void initFragment() {
		btnAbout.performClick();
	}

	private void setFirstSelect() {
		tabSelect = 1;
		btnAbout.setBackgroundResource(R.drawable.tabbar_select);
		btnRegion.setBackgroundResource(R.drawable.tabbar_unselect);
		btnTherapies.setBackgroundResource(R.drawable.tabbar_unselect);
	}

	private void setSecondSelect() {
		tabSelect = 2;
		btnAbout.setBackgroundResource(R.drawable.tabbar_unselect);
		btnRegion.setBackgroundResource(R.drawable.tabbar_select);
		btnTherapies.setBackgroundResource(R.drawable.tabbar_unselect);
	}

	private void setThirdSelect() {
		tabSelect = 3;
		btnAbout.setBackgroundResource(R.drawable.tabbar_unselect);
		btnRegion.setBackgroundResource(R.drawable.tabbar_unselect);
		btnTherapies.setBackgroundResource(R.drawable.tabbar_select);
	}

	@Override
	public void getDataFromFragment(ScreenLink data) {
		// TODO Auto-generated method stub
		Log.e("data", "hello " + data.getLvef());
		this.screenLink = data;
	}

	*//**
	 * @return the screenLink
	 *//*
	public ScreenLink getScreenLink() {
		return screenLink;
	}

	*//**
	 * @param screenLink
	 *            the screenLink to set
	 *//*
	public void setScreenLink(ScreenLink screenLink) {
		this.screenLink = screenLink;
	}

}
*/