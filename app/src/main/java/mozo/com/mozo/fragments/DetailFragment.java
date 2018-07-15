package mozo.com.mozo.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import mozo.com.mozo.BaseFragment;
import mozo.com.mozo.PageFragmentListener;
import mozo.com.mozo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends BaseFragment {

    protected PageFragmentListener mListener;

    @SuppressLint("ValidFragment")
    public DetailFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public DetailFragment(PageFragmentListener listener) {
        mListener = listener;
    }

    public static DetailFragment newInstance(String title) {
        return new DetailFragment(title);
    }

    private String mTitle;

    @SuppressLint("ValidFragment")
    public DetailFragment(String title) {
        mTitle = title;
    }

    View InfView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        InfView = inflater.inflate(R.layout.fragment_detail, container, false);
        ;
        // Inflate the layout for this fragment
        return InfView;
    }

    Button textView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        textView = (Button) InfView.findViewById(R.id.nextdataa);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction trans = getFragmentManager()
                        .beginTransaction();

                FragmentManager fm = getActivity().getSupportFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack();
                }
            }
        });
    }


}
