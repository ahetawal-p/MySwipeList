package com.example.myswipelist;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment
 * must implement the {@link ThreadViewFragment.OnFragmentInteractionListener}
 * interface to handle interaction events. Use the
 * {@link ThreadViewFragment#newInstance} factory method to create an instance
 * of this fragment.
 * 
 */
public class ThreadViewFragment extends BaseViewFragment {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "content";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters
	private String emailContent;
	private String mParam2;
	
	protected Button backButton;
	private WebView emailView;
	
	private OnFragmentInteractionListener mListener;

	/**
	 * Use this factory method to create a new instance of this fragment using
	 * the provided parameters.
	 * 
	 * @param param1
	 *            Parameter 1.
	 * @param param2
	 *            Parameter 2.
	 * @return A new instance of fragment ThreadViewFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static ThreadViewFragment newInstance(String emailContent) {
		ThreadViewFragment fragment = new ThreadViewFragment();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, emailContent);
		//args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}

	public ThreadViewFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			emailContent = getArguments().getString(ARG_PARAM1);
		//	mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		System.out.println("I on Thread Create view....");
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.fragment_thread_view, container, false);
		backButton = (Button) rootView.findViewById(R.id.threadBack);
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onButtonPressed(true);
				
			}
		});
		
		emailView = (WebView) rootView.findViewById(R.id.emailView);
		emailView.getSettings().setBuiltInZoomControls(true);
		emailView.getSettings().setDisplayZoomControls(false);
		//emailView.setInitialScale(1);
		emailView.getSettings().setLoadWithOverviewMode(true);
		emailView.getSettings().setUseWideViewPort(true);
		emailView.loadData(emailContent, "text/html", "UTF-8");
		//emailView.loadUrl("http://commonsware.com");
		
		
		
		rootView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				onButtonPressed(true);
				
			}
		});
		return rootView;
	}
	
	
	
	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(boolean isRight) {
		if (mListener != null) {
			mListener.onFragmentInteraction(isRight);
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnFragmentInteractionListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		System.out.println("I am detaching Thread view....");
		super.onDetach();
		mListener = null;
		
	}

	
	

}
