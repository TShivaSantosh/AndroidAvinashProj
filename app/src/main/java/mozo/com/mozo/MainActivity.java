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

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MenuItem;

/**
 * Shows a ViewPager using a FragmentPagerAdapter and shows the usage of child
 * fragments within a ViewPager.
 * 
 * @author Rukmal Dias
 */
public class MainActivity extends FragmentActivity {
	
	 private ViewPager mPager;
	 private ViewPagerAdapter mAdapter;
	MenuItem prevMenuItem;
	BottomNavigationView bottomNavigationView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mPager = (ViewPager)findViewById(R.id.my_pager);
		mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
		mPager.setAdapter(mAdapter);
		bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

		bottomNavigationView.setOnNavigationItemSelectedListener(
				new BottomNavigationView.OnNavigationItemSelectedListener() {
					@Override
					public boolean onNavigationItemSelected(@NonNull MenuItem item) {
						switch (item.getItemId()) {
							case R.id.action_call:
								mPager.setCurrentItem(0);
								break;
							case R.id.action_chat:
								mPager.setCurrentItem(1);
								break;
							case R.id.action_contact:
								mPager.setCurrentItem(2);
								break;
						}
						return false;
					}
				});

		mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

			}

			@Override
			public void onPageSelected(int position) {
				if (prevMenuItem != null) {
					prevMenuItem.setChecked(false);
				}
				else
				{
					bottomNavigationView.getMenu().getItem(0).setChecked(false);
				}
				Log.d("page", "onPageSelected: "+position);
				bottomNavigationView.getMenu().getItem(position).setChecked(true);
				prevMenuItem = bottomNavigationView.getMenu().getItem(position);

			}

			@Override
			public void onPageScrollStateChanged(int state) {

			}
		});
	}
	 
	/**
	 * Identifies whether the back is called form a child fragment or a parent fragment
	 * and takes necessary steps then.
	 */
	@Override
	public void onBackPressed() {
super.onBackPressed();
	}

	// Back Button Pressed
	private void backButton() {
		finish();
	}
	
	public void replaceChild(BaseFragment oldFrg, int position) {
	}
	 
}
