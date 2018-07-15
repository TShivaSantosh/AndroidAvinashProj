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
import android.widget.RelativeLayout;
import android.widget.TextView;

import mozo.com.mozo.BaseFragment;
import mozo.com.mozo.PageFragmentListener;
import mozo.com.mozo.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CallsFragment extends BaseFragment {

    protected PageFragmentListener mListener;
    public CallsFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ValidFragment")
    public CallsFragment(PageFragmentListener listener)
    {
        mListener = listener;
    }

    public static CallsFragment newInstance(PageFragmentListener listener) {
        return new CallsFragment(listener);
    }

View InfView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        InfView=inflater.inflate(R.layout.fragment_calls, container, false);;
        // Inflate the layout for this fragment
        return InfView;
    }
    Button textView;
    RelativeLayout parentFragment;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        parentFragment=(RelativeLayout)InfView.findViewById(R.id.parentFragment);
        textView=(Button) InfView.findViewById(R.id.nextdataa);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
                    DetailFragment myDetailFragment = new DetailFragment();
                    int count = fragmentManager.getBackStackEntryCount();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction
                            .replace(R.id.parentFragment, myDetailFragment)
                            .setTransition(
                                    FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                            .addToBackStack(String.valueOf(count)).commit();
                  // mListener.onSwitchToNextFragment();
                }

        });
    }
}
