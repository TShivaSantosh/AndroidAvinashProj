package mozo.com.mozo.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mozo.com.mozo.BaseFragment;
import mozo.com.mozo.PageFragmentListener;
import mozo.com.mozo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends BaseFragment {

    protected PageFragmentListener mListener;
    @SuppressLint("ValidFragment")
    public ChatFragment(PageFragmentListener listener)
    {
        mListener = listener;
    }

    public static ChatFragment newInstance(PageFragmentListener listener) {
        return new ChatFragment(listener);
    }

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

}
