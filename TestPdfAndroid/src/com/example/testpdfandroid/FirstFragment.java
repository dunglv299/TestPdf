package com.example.testpdfandroid;
/*package com.persei.screenlink.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.persei.screenlink.R;
import com.persei.screenlink.entity.ScreenLink;

public class FirstFragment extends Fragment implements OnCheckedChangeListener,
		OnClickListener {
	OnDataPass mCallback;
	private ToggleButton togEcho;
	private ToggleButton togPrior;
	private EditText edLVEF;
	private ScreenLink screenLink;
	private Button btnEmail;

	public interface OnDataPass {
		public void getDataFromFragment(ScreenLink data);
	}

	public static FirstFragment newInstance() {
		FirstFragment firstFragment = new FirstFragment();
		return firstFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.first_fragment, container, false);
		togEcho = (ToggleButton) view.findViewById(R.id.toggle_echo);
		togPrior = (ToggleButton) view.findViewById(R.id.toggle_prior);
		edLVEF = (EditText) view.findViewById(R.id.ed_echo);
		btnEmail = (Button) view.findViewById(R.id.btn_send_email);
		if (getActivity() instanceof MainActivity) {
			screenLink = ((MainActivity) getActivity()).getScreenLink();
			edLVEF.setText(screenLink.getLvef() + "");
			togEcho.setChecked(screenLink.isEchoAvailable());
			togPrior.setChecked(screenLink.isPriorMRI());
			Log.e("data from activity",
					screenLink.getLvef() + screenLink.isEchoAvailable()
							+ screenLink.isPriorMRI());
		}
		togEcho.setOnCheckedChangeListener(this);
		togPrior.setOnCheckedChangeListener(this);
		btnEmail.setOnClickListener(this);
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		// This makes sure that the container activity has implemented
		// the callback interface. If not, it throws an exception
		super.onAttach(activity);

		try {
			mCallback = (OnDataPass) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnHeadlineSelectedListener");
		}

	}

	public void passDataToActivity(ScreenLink data) {
		mCallback.getDataFromFragment(data);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		screenLink.setLvef(edLVEF.getText().toString());
		screenLink.setEchoAvailable(screenLink.isEchoAvailable());
		screenLink.setPriorMRI(screenLink.isPriorMRI());
		passDataToActivity(screenLink);
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		switch (buttonView.getId()) {
		case R.id.toggle_echo:
			screenLink.setEchoAvailable(isChecked);
			break;
		case R.id.toggle_prior:
			screenLink.setPriorMRI(isChecked);
			break;
		default:
			break;
		}
	}

	*//**
	 * @return the edLVEF
	 *//*
	public String getEdLVEF() {
		return edLVEF.getText().toString();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_send_email:
			// String to = "abc@gmail.com";
			String subject = "Subject";
			String message = "Message\ndunglv";

			Intent email = new Intent(Intent.ACTION_SEND);
			// email.putExtra(Intent.EXTRA_EMAIL, snew String[] { to });
			// email.putExtra(Intent.EXTRA_CC, new String[]{ to});
			// email.putExtra(Intent.EXTRA_BCC, new String[]{to});
			email.putExtra(Intent.EXTRA_SUBJECT, subject);
			email.putExtra(Intent.EXTRA_TEXT, message);
			// email.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(f));
			// need this to prompts email client only
			email.setType("message/rfc822");
			startActivityForResult(email, 20);
			break;

		default:
			break;
		}
	}
}
*/