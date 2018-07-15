/*
 * Copyright (c) 2014, Rukmal Dias 
All rights reserved. 

Redistribution and use in source and binary forms, with or without 
modification, are permitted provided that the following conditions are met: 

 * Redistributions of source code must retain the above copyright notice, 
   this list of conditions and the following disclaimer. 
 * Redistributions in binary form must reproduce the above copyright 
   notice, this list of conditions and the following disclaimer in the 
   documentation and/or other materials provided with the distribution. 

THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS ``AS IS'' AND ANY 
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE 
DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE FOR ANY 
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR 
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT 
LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY 
OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH 
DAMAGE. 
 */
package mozo.com.mozo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import mozo.com.mozo.fragments.CallsFragment;
import mozo.com.mozo.fragments.ChatFragment;
import mozo.com.mozo.fragments.ChildFragment;
import mozo.com.mozo.fragments.ContactsFragment;
import mozo.com.mozo.fragments.FirstFragment;

/**
 * ViewPagerAdapter is an {@link FragmentPagerAdapter FragmentPagerAdapter}
 * that is used bind some fragments with their child fragments here.
 * @author Rukmal Dias
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
	
    private BaseFragment mFragmentAtPos1; // Fragment at index 1
    private BaseFragment mFragmentAtPos2; // Fragment at index 2
    private BaseFragment mFragmentAtPos3; // Fragment at index 3
	private final FragmentManager mFragmentManager;
	
	private static final int NUM_OF_ITEMS = 3; // No of ViewPager items
	
	private static final String STR_CHILD_TAG_0 = " -> child fragment of tag 0";
	private static final String STR_CHILD_TAG_1 = " -> child fragment of tag 1";
	private static final String STR_CHILD_TAG_2 = " -> child fragment of tag 2";


	public ViewPagerAdapter(FragmentManager fm) {
		super(fm);
		mFragmentManager = fm;
	}

    @Override
    public Fragment getItem(int position) {
	    switch (position){

            case 0:
                if (mFragmentAtPos1 == null) {
                    mFragmentAtPos1 = FirstFragment.newInstance(new PageFragmentListener() {
                        public void onSwitchToNextFragment() {

                            notifyDataSetChanged();
                        }
                    });
                }
                return mFragmentAtPos1;
            case 1:
                if (mFragmentAtPos2 == null) {
                    mFragmentAtPos2 = ChatFragment.newInstance(new PageFragmentListener() {
                        public void onSwitchToNextFragment() {

                            notifyDataSetChanged();
                        }
                    });
                }
                return mFragmentAtPos2;
            case 2:
                if (mFragmentAtPos3 == null) {
                    mFragmentAtPos3 = ContactsFragment.newInstance(new PageFragmentListener() {
                        public void onSwitchToNextFragment() {

                            notifyDataSetChanged();
                        }
                    });
                }
                return mFragmentAtPos3;

        }

       return null;

    }

	@Override
	public int getCount() {
		return NUM_OF_ITEMS;
	}
	
    @Override
    public int getItemPosition(Object object)
    {
        if (object instanceof CallsFragment && mFragmentAtPos1 instanceof ChildFragment) {
            return POSITION_NONE;
        }
        else if(object instanceof ChatFragment && mFragmentAtPos2 instanceof ChildFragment) {
            return POSITION_NONE;
        }
        else if(object instanceof ChildFragment) {
       	 	return POSITION_NONE;
        }
        return POSITION_UNCHANGED;
    }
	


}
