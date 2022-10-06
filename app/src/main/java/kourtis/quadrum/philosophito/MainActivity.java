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
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import kourtis.quadrum.philosophito.databinding.ActivityMainBinding;
import kourtis.quadrum.philosophito.ui.main.AboutActivitiy;
import kourtis.quadrum.philosophito.ui.main.FavoritesFragment;
import kourtis.quadrum.philosophito.ui.main.FirstFragment;
import kourtis.quadrum.philosophito.ui.main.HomeFragment;
import kourtis.quadrum.philosophito.ui.main.MoralTheoriesItemActivitiy;
import kourtis.quadrum.philosophito.ui.main.MotivationFragment;
import kourtis.quadrum.philosophito.ui.main.PrivacyPolicyFragment;
import kourtis.quadrum.philosophito.ui.main.ResourcesFragment;
import kourtis.quadrum.philosophito.ui.main.SettingsFragment;
import kourtis.quadrum.philosophito.ui.main.data.State;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private TabLayout tabs;
    private DrawerLayout navDrawer = null;
    private HomeFragment homeFragment;

    private void initState() {
        new State();
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initState();

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        FirstFragment firstFragment = new FirstFragment();
        PrivacyPolicyFragment privacyPolicyFragment = new PrivacyPolicyFragment();
        FavoritesFragment favoritesFragment = new FavoritesFragment();
        MotivationFragment motivationFragment = new MotivationFragment();
        ResourcesFragment resourcesFragment = new ResourcesFragment();
        SettingsFragment settingsFragment = new SettingsFragment();
        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).addToBackStack(null).commit();

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).addToBackStack(null).commit();
                    return true;
                case R.id.bank:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, resourcesFragment).addToBackStack(null).commit();
                    return true;
                case R.id.quiz:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, favoritesFragment).addToBackStack(null).commit();
                    return true;
                case R.id.favorites:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, motivationFragment).addToBackStack(null).commit();
                    return true;
                case R.id.settings:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, settingsFragment).addToBackStack(null).commit();
                    return true;
            }
            return false;
        });

        setupnavdrawer();
        setfont();
        binding.drawerLayout.bringToFront();

        binding.logoimg.setOnClickListener(click -> {
            if (!binding.drawerLayout.isDrawerOpen(Gravity.START))
                binding.drawerLayout.openDrawer(Gravity.START);
            else binding.drawerLayout.closeDrawer(Gravity.END);
        });

        binding.infoBtn.setOnClickListener(click -> {
            Intent startIntent = new Intent(getApplicationContext(), AboutActivitiy.class);
            startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            getApplicationContext().startActivity(startIntent);
        });
    }

    private void setfont() {
        NavigationView navigationView = binding.navView;
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

    private void setupnavdrawer() {
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
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    TabLayout.Tab tab1 = homeFragment.getTabs().getTabAt(1);
                    tab1.select();
                    break;
                case R.id.whistle:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    TabLayout.Tab tab2 = homeFragment.getTabs().getTabAt(2);
                    tab2.select();
                    break;
                case R.id.disc:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    TabLayout.Tab tab3 = homeFragment.getTabs().getTabAt(3);
                    tab3.select();
                    break;
                case R.id.affirm:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    TabLayout.Tab tab4 = homeFragment.getTabs().getTabAt(4);
                    tab4.select();
                    break;
                case R.id.harass:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    TabLayout.Tab tab5 = homeFragment.getTabs().getTabAt(5);
                    tab5.select();
                    break;
                case R.id.advertising:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    TabLayout.Tab tab6 = homeFragment.getTabs().getTabAt(6);
                    tab6.select();
                    break;
                case R.id.product:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    TabLayout.Tab tab7 = homeFragment.getTabs().getTabAt(7);
                    tab7.select();
                    break;
                case R.id.employment:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    TabLayout.Tab tab8 = homeFragment.getTabs().getTabAt(8);
                    tab8.select();
                    break;
                case R.id.corp:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    TabLayout.Tab tab9 = homeFragment.getTabs().getTabAt(9);
                    tab9.select();
                    break;
                case R.id.dict:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    TabLayout.Tab tab10 = homeFragment.getTabs().getTabAt(10);
                    tab10.select();
                    break;
                case R.id.extra:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    TabLayout.Tab tab11 = homeFragment.getTabs().getTabAt(11);
                    tab11.select();
                    break;
                case R.id.about:
                    Intent startIntent = new Intent(getApplicationContext(), AboutActivitiy.class);
                    startIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(startIntent);
                    break;
            }

            return false;
        });
    }
}