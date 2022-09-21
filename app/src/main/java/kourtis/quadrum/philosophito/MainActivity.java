package kourtis.quadrum.philosophito;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.TypefaceSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import kourtis.quadrum.philosophito.databinding.ActivityMainBinding;
import kourtis.quadrum.philosophito.ui.main.AboutActivitiy;
import kourtis.quadrum.philosophito.ui.main.MoralTheoriesItemActivitiy;
import kourtis.quadrum.philosophito.ui.main.SectionsPagerAdapter;
import kourtis.quadrum.philosophito.ui.main.data.State;

public class MainActivity extends AppCompatActivity {
    private TabLayout.Tab tab = null;
    private DrawerLayout navDrawer = null;

    private void initState() {
        new State();
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);

        initState();
        navDrawer = findViewById(R.id.drawer_layout);

        binding.infoBtn.setOnClickListener(click -> {
            Intent startIntent = new Intent(getApplicationContext(), AboutActivitiy.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(startIntent);
        });

        binding.logoimg.setOnClickListener(click -> {

            if (!navDrawer.isDrawerOpen(Gravity.START)) navDrawer.openDrawer(Gravity.START);
            else navDrawer.closeDrawer(Gravity.END);
        });

        setfont();

        binding.navView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.one:
                    Intent intent = new Intent(getApplicationContext(), MoralTheoriesItemActivitiy.class);
                    intent.putExtra("title", State.theoriesList.get(0).getTitle());
                    intent.putExtra("content", State.theoriesList.get(0).getFullContent());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intent);
                    break;
                case R.id.two:
                    Intent intent1 = new Intent(getApplicationContext(), MoralTheoriesItemActivitiy.class);
                    intent1.putExtra("title", State.theoriesList.get(1).getTitle());
                    intent1.putExtra("content", State.theoriesList.get(1).getFullContent());
                    intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intent1);
                    break;
                case R.id.three:
                    Intent intent2 = new Intent(getApplicationContext(), MoralTheoriesItemActivitiy.class);
                    intent2.putExtra("title", State.theoriesList.get(2).getTitle());
                    intent2.putExtra("content", State.theoriesList.get(2).getFullContent());
                    intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intent2);
                    break;
                case R.id.csr:
                    TabLayout.Tab tab1 = tabs.getTabAt(1);
                    tab1.select();
                    break;
                case R.id.whistle:
                    TabLayout.Tab tab2 = tabs.getTabAt(2);
                    tab2.select();
                    break;
                case R.id.disc:
                    TabLayout.Tab tab3 = tabs.getTabAt(3);
                    tab3.select();
                    break;
                case R.id.affirm:
                    TabLayout.Tab tab4 = tabs.getTabAt(4);
                    tab4.select();
                    break;
                case R.id.harass:
                    TabLayout.Tab tab5 = tabs.getTabAt(5);
                    tab5.select();
                    break;
                case R.id.advertising:
                    TabLayout.Tab tab6 = tabs.getTabAt(6);
                    tab6.select();
                    break;
                case R.id.product:
                    TabLayout.Tab tab7 = tabs.getTabAt(7);
                    tab7.select();
                    break;
                case R.id.employment:
                    TabLayout.Tab tab8 = tabs.getTabAt(8);
                    tab8.select();
                    break;
                case R.id.corp:
                    TabLayout.Tab tab9 = tabs.getTabAt(9);
                    tab9.select();
                    break;
                case R.id.dict:
                    TabLayout.Tab tab10 = tabs.getTabAt(10);
                    tab10.select();
                    break;
                case R.id.extra:
                    TabLayout.Tab tab11 = tabs.getTabAt(11);
                    tab11.select();
                    break;
                case R.id.about:
                    Intent startIntent = new Intent(getApplicationContext(), AboutActivitiy.class);
                    startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(startIntent);
                    break;
            }

            navDrawer.closeDrawer(GravityCompat.START);

            return false;
        });
    }

    private void setfont() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> false);
        Menu m = navigationView.getMenu();
        Typeface myfont = ResourcesCompat.getFont(getApplicationContext(), R.font.lorabold);

        for (int i = 0; i < m.size(); i++) {
            MenuItem mi = m.getItem(i);
            SpannableString s = new SpannableString(mi.getTitle());
            TypefaceSpan robotoBoldSpan = new CustomTypefaceSpan("", myfont);
            s.setSpan(robotoBoldSpan, 0, s.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
            s.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.red)), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            s.setSpan(
                    new AbsoluteSizeSpan(16, true),
                    0,
                    s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            );
            mi.setTitle(s);
        }
    }

    @Override
    public void onBackPressed() {
        Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
        startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(startIntent);
    }
}