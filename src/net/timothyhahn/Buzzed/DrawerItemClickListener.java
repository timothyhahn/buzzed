package net.timothyhahn.Buzzed;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by tim on 4/12/14.
 */

public class DrawerItemClickListener implements ListView.OnItemClickListener {
    private ActionBar mActionBar;
    private FragmentManager mFragmentManager;
    private Activity mParentActivity;

    public DrawerItemClickListener(Activity activity) {
        this.mActionBar = activity.getActionBar();
        this.mFragmentManager = activity.getFragmentManager();
        this.mParentActivity = activity;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectItem(position);
    }

    private void selectItem(int position) {
        DrawerLayout drawerLayout = (DrawerLayout) mParentActivity.findViewById(R.id.drawer_layout);
        ListView drawerList = (ListView) mParentActivity.findViewById(R.id.left_drawer);
        String[] menuOptions = mParentActivity.getResources().getStringArray(R.array.menu_names);
        Fragment fragment = new BuzzedFragment();
        Bundle args = new Bundle();


        args.putInt(BuzzedFragment.ARG_BUZZED_NUMBER, position);
        fragment.setArguments(args);

        mFragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

        drawerList.setItemChecked(position, true);
        setTitle(menuOptions[position]);
        drawerLayout.closeDrawer(drawerList);
    }

    public void setTitle(CharSequence title) {
        mActionBar.setTitle(title);
    }
}