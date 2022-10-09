package kourtis.quadrum.philosophito.ui.main.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

import kourtis.quadrum.philosophito.R;
import kourtis.quadrum.philosophito.ui.main.SectionsPagerAdapter;

public class HomeFragment extends Fragment {

    public TabLayout tabs;
    private TabLayout.Tab tab = null;
    private DrawerLayout navDrawer = null;
    private ViewGroup view;
    private View inflateview;
    private int selectedtab = 0;
    private ViewPager viewPager;
    private SectionsPagerAdapter sectionsPagerAdapter;

    public HomeFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflateview = inflater.inflate(R.layout.fragment_home, container, false);
        sectionsPagerAdapter = new SectionsPagerAdapter(container.getContext(), getChildFragmentManager());
        viewPager = inflateview.findViewById(R.id.viewPager);
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs = inflateview.findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        return inflateview;
    }

    @Override
    public void onResume() {
        super.onResume();
        Objects.requireNonNull(this.tabs.getTabAt(selectedtab)).select();
    }

    @Override
    public void onPause() {
        super.onPause();
        this.selectedtab = tabs.getSelectedTabPosition();
    }

    public void setSelectedtab(int selectedtab) {
        this.selectedtab = selectedtab;
    }

    public TabLayout getTabs() {
        return tabs;
    }
}