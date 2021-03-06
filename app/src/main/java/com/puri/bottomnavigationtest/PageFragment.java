package com.puri.bottomnavigationtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.FrameLayout;

/**
 * Created by puri on 6/15/2016 AD.
 */
public class PageFragment extends Fragment {
    private FrameLayout fragmentContainer;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    /**
     * Create a new instance of the fragment
     */
    public static PageFragment newInstance(int index) {
        PageFragment fragment = new PageFragment();
        Bundle b = new Bundle();
        b.putInt("index", index);
        fragment.setArguments(b);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (getArguments().getInt("index", 0) == 0) {
            View view = inflater.inflate(R.layout.fragment_feed, container, false);
//			initDemoSettings(view);
            return view;
        } else {
            View view = inflater.inflate(R.layout.fragment_map, container, false);
//			initDemoList(view);
            return view;
        }
    }

    /**
     * Init demo settings
     */
//	private void initDemoSettings(View view) {
//
//		final DemoActivity demoActivity = (DemoActivity) getActivity();
//		final SwitchCompat switchColored = (SwitchCompat) view.findViewById(R.id.fragment_demo_switch_colored);
//		final SwitchCompat switchFiveItems = (SwitchCompat) view.findViewById(R.id.fragment_demo_switch_five_items);
//		final SwitchCompat showHideBottomNavigation = (SwitchCompat) view.findViewById(R.id.fragment_demo_show_hide);
//
//		switchColored.setChecked(demoActivity.isBottomNavigationColored());
//		switchFiveItems.setChecked(demoActivity.getBottomNavigationNbItems() == 5);
//
//		switchColored.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//			@Override
//			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//				demoActivity.updateBottomNavigationColor(isChecked);
//			}
//		});
//		switchFiveItems.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//			@Override
//			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//				demoActivity.updateBottomNavigationItems(isChecked);
//			}
//		});
//		showHideBottomNavigation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//			@Override
//			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//				demoActivity.showOrHideBottomNavigation(isChecked);
//			}
//		});
//	}

    /**
     * Init the fragment
     */
//	private void initDemoList(View view) {
//
//		fragmentContainer = (FrameLayout) view.findViewById(R.id.fragment_container);
//		recyclerView = (RecyclerView) view.findViewById(R.id.fragment_demo_recycler_view);
//		recyclerView.setHasFixedSize(true);
//		layoutManager = new LinearLayoutManager(getActivity());
//		recyclerView.setLayoutManager(layoutManager);
//
//		ArrayList<String> itemsData = new ArrayList<>();
//		for (int i = 0; i < 50; i++) {
//			itemsData.add("Fragment " + getArguments().getInt("index", -1) + " / Item " + i);
//		}
//
//		DemoAdapter adapter = new DemoAdapter(itemsData);
//		recyclerView.setAdapter(adapter);
//	}

    /**
     * Refresh
     */
    public void refresh() {
        if (getArguments().getInt("index", 0) > 0 && recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
        }
    }

    /**
     * Called when a fragment will be displayed
     */
    public void willBeDisplayed() {
        // Do what you want here, for example animate the content
        if (fragmentContainer != null) {
            Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in);
            fragmentContainer.startAnimation(fadeIn);
        }
    }

    /**
     * Called when a fragment will be hidden
     */
    public void willBeHidden() {
        if (fragmentContainer != null) {
            Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fade_out);
            fragmentContainer.startAnimation(fadeOut);
        }
    }
}
