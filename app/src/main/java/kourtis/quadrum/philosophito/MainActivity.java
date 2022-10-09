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

import java.util.Objects;

import kourtis.quadrum.philosophito.databinding.ActivityMainBinding;
import kourtis.quadrum.philosophito.ui.main.bank.QuestionsBankFragment;
import kourtis.quadrum.philosophito.ui.main.data.State;
import kourtis.quadrum.philosophito.ui.main.favorites.FavoritesFragment;
import kourtis.quadrum.philosophito.ui.main.general.AboutActivitiy;
import kourtis.quadrum.philosophito.ui.main.home.HomeFragment;
import kourtis.quadrum.philosophito.ui.main.home.theories.MoralTheoriesItemActivitiy;
import kourtis.quadrum.philosophito.ui.main.quiz.QuizMenuFragment;
import kourtis.quadrum.philosophito.ui.main.settings.SettingsFragment;
import kourtis.quadrum.philosophito.utils.CustomTypefaceSpan;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
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

        navDrawer = findViewById(R.id.drawer_layout);

        FavoritesFragment favoritesFragment = new FavoritesFragment();
        QuizMenuFragment quizMenuFragment = new QuizMenuFragment();
        QuestionsBankFragment questionsBankFragment = new QuestionsBankFragment();
        SettingsFragment settingsFragment = new SettingsFragment();
        homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).addToBackStack(null).commit();

        binding.bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).addToBackStack(null).commit();
                    return true;
                case R.id.quiz:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, quizMenuFragment).addToBackStack(null).commit();
                    return true;
                case R.id.bank:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, questionsBankFragment).addToBackStack(null).commit();
                    return true;
                case R.id.favorites:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, favoritesFragment).addToBackStack(null).commit();
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
        Menu m = binding.navView.getMenu();
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
            System.out.println(item.getItemId());
            System.out.println(item.getTitle());
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
                    binding.bottomNavigationView.setSelectedItemId(R.id.home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    homeFragment.setSelectedtab(1);
                    Objects.requireNonNull(homeFragment.getTabs().getTabAt(1)).select();
                    break;
                case R.id.whistle:
                    binding.bottomNavigationView.setSelectedItemId(R.id.home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    homeFragment.setSelectedtab(2);
                    Objects.requireNonNull(homeFragment.getTabs().getTabAt(2)).select();
                    break;
                case R.id.disc:
                    binding.bottomNavigationView.setSelectedItemId(R.id.home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    homeFragment.setSelectedtab(3);
                    Objects.requireNonNull(homeFragment.getTabs().getTabAt(3)).select();
                    break;
                case R.id.affirm:
                    binding.bottomNavigationView.setSelectedItemId(R.id.home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    homeFragment.setSelectedtab(4);
                    Objects.requireNonNull(homeFragment.getTabs().getTabAt(4)).select();
                    break;
                case R.id.harass:
                    binding.bottomNavigationView.setSelectedItemId(R.id.home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    homeFragment.setSelectedtab(5);
                    Objects.requireNonNull(homeFragment.getTabs().getTabAt(5)).select();
                    break;
                case R.id.advertising:
                    binding.bottomNavigationView.setSelectedItemId(R.id.home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    homeFragment.setSelectedtab(6);
                    Objects.requireNonNull(homeFragment.getTabs().getTabAt(6)).select();
                    break;
                case R.id.product:
                    binding.bottomNavigationView.setSelectedItemId(R.id.home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    homeFragment.setSelectedtab(7);
                    Objects.requireNonNull(homeFragment.getTabs().getTabAt(7)).select();
                    break;
                case R.id.employment:
                    binding.bottomNavigationView.setSelectedItemId(R.id.home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    homeFragment.setSelectedtab(8);
                    Objects.requireNonNull(homeFragment.getTabs().getTabAt(8)).select();
                    break;
                case R.id.corp:
                    binding.bottomNavigationView.setSelectedItemId(R.id.home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    homeFragment.setSelectedtab(9);
                    Objects.requireNonNull(homeFragment.getTabs().getTabAt(9)).select();
                    break;
                case R.id.dict:
                    binding.bottomNavigationView.setSelectedItemId(R.id.home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    homeFragment.setSelectedtab(10);
                    Objects.requireNonNull(homeFragment.getTabs().getTabAt(10)).select();
                    break;
                case R.id.extra:
                    binding.bottomNavigationView.setSelectedItemId(R.id.home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    homeFragment.setSelectedtab(11);
                    Objects.requireNonNull(homeFragment.getTabs().getTabAt(11)).select();
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
}