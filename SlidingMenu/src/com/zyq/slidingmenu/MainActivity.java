package com.zyq.slidingmenu;
import java.util.ArrayList;
import java.util.List;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class MainActivity extends Activity {

	ViewPager mViewPager;
	SlidingMenu menu;
	List<View>views = new ArrayList<View>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		getActionBar().setHomeButtonEnabled(true);
		initMenu();
		initViewpager();
		mViewPager.setPageTransformer(true,new DepthPageTransformer());




	}

	private void initViewpager() {

		mViewPager = (ViewPager) findViewById(R.id.viewpager);

		mViewPager.setAdapter(new Myadapter());
		LayoutInflater inflate = LayoutInflater.from(this);
		View view1 = inflate.inflate(R.layout.page_item, null);
		View view2 = inflate.inflate(R.layout.page_item2, null);
		View view3 = inflate.inflate(R.layout.page_item3, null);
		views.add(view1);
		views.add(view2);
		views.add(view3);
	}

	private void initMenu() {
		menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.LEFT_RIGHT);

		menu.setFadeDegree(0.35f);

		menu.setBehindOffsetRes(R.dimen.menu_width);
		menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);  
		//为侧滑菜单设置布局  
		menu.setMenu(R.layout.menu);
		menu.setSecondaryMenu(R.layout.menu2);

	}

	class Myadapter extends PagerAdapter{

		@Override
		public int getCount() {

			return 3;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {

			return arg0 == arg1;
		}
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View view = views.get(position);
			container.addView(view);
			return view;
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {

			container.removeView(views.get(position));
		}
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			menu.showMenu();

			break;

		default:

			break;
		}


		return super.onOptionsItemSelected(item);
	}

}
