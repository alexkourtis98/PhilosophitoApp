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
import kourtis.quadrum.philosophito.ui.main.data.State;
import kourtis.quadrum.philosophito.ui.main.favorites.FavoritesFragment;
import kourtis.quadrum.philosophito.ui.main.general.AboutActivitiy;
import kourtis.quadrum.philosophito.ui.main.home.HomeFragment;
import kourtis.quadrum.philosophito.ui.main.home.issues.MoralIssueItemActivitiy;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initState();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        navDrawer = findViewById(R.id.drawer_layout);

        FavoritesFragment favoritesFragment = new FavoritesFragment();
        QuizMenuFragment quizMenuFragment = new QuizMenuFragment();
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
        clickListeners();
    }

    @SuppressLint("WrongConstant")
    private void clickListeners() {
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
            switch (item.getItemId()) {
                case R.id.one:
                    Intent intent = new Intent(getApplicationContext(), MoralTheoriesItemActivitiy.class);
                    intent.putExtra("title", State.theoriesList.get(0).getTitle());
                    intent.putExtra("mdlocation", State.theoriesList.get(0).getMdLocation());
                    intent.putExtra("enumtype", State.theoriesList.get(0).getEnumtype());
                    intent.putExtra("audiolocation", State.theoriesList.get(0).getAudioLocation());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intent);
                    break;
                case R.id.two:
                    Intent intent1 = new Intent(getApplicationContext(), MoralTheoriesItemActivitiy.class);
                    intent1.putExtra("title", State.theoriesList.get(1).getTitle());
                    intent1.putExtra("mdlocation", State.theoriesList.get(1).getMdLocation());
                    intent1.putExtra("enumtype", State.theoriesList.get(1).getEnumtype());
                    intent1.putExtra("audiolocation", State.theoriesList.get(1).getAudioLocation());
                    intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intent1);
                    break;
                case R.id.three:
                    Intent intent2 = new Intent(getApplicationContext(), MoralTheoriesItemActivitiy.class);
                    intent2.putExtra("title", State.theoriesList.get(2).getTitle());
                    intent2.putExtra("mdlocation", State.theoriesList.get(2).getMdLocation());
                    intent2.putExtra("enumtype", State.theoriesList.get(2).getEnumtype());
                    intent2.putExtra("audiolocation", State.theoriesList.get(2).getAudioLocation());
                    intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intent2);
                    break;
                case R.id.csr:
                    Intent intentCSR = new Intent(getApplicationContext(), MoralIssueItemActivitiy.class);
                    intentCSR.putExtra("title", State.issuesList.get(0).getTitle());
                    intentCSR.putExtra("mdlocation", State.issuesList.get(0).getMdLocation());
                    intentCSR.putExtra("enumtype", State.issuesList.get(0).getEnumtype());
                    intentCSR.putExtra("audiolocation", State.issuesList.get(0).getAudioLocation());
                    intentCSR.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intentCSR);
                    break;
                case R.id.whistle:
                    Intent intentWHISTLE = new Intent(getApplicationContext(), MoralIssueItemActivitiy.class);
                    intentWHISTLE.putExtra("title", State.issuesList.get(8).getTitle());
                    intentWHISTLE.putExtra("mdlocation", State.issuesList.get(8).getMdLocation());
                    intentWHISTLE.putExtra("enumtype", State.issuesList.get(8).getEnumtype());
                    intentWHISTLE.putExtra("audiolocation", State.issuesList.get(8).getAudioLocation());
                    intentWHISTLE.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intentWHISTLE);
                    break;
                case R.id.disc:
                    Intent intentDISC = new Intent(getApplicationContext(), MoralIssueItemActivitiy.class);
                    intentDISC.putExtra("title", State.issuesList.get(4).getTitle());
                    intentDISC.putExtra("mdlocation", State.issuesList.get(4).getMdLocation());
                    intentDISC.putExtra("enumtype", State.issuesList.get(4).getEnumtype());
                    intentDISC.putExtra("audiolocation", State.issuesList.get(4).getAudioLocation());
                    intentDISC.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intentDISC);
                    break;
                case R.id.affirm:
                    Intent intentAFF = new Intent(getApplicationContext(), MoralIssueItemActivitiy.class);
                    intentAFF.putExtra("title", State.issuesList.get(2).getTitle());
                    intentAFF.putExtra("mdlocation", State.issuesList.get(2).getMdLocation());
                    intentAFF.putExtra("enumtype", State.issuesList.get(2).getEnumtype());
                    intentAFF.putExtra("audiolocation", State.issuesList.get(2).getAudioLocation());
                    intentAFF.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intentAFF);
                    break;
                case R.id.harass:
                    Intent intentHARASS = new Intent(getApplicationContext(), MoralIssueItemActivitiy.class);
                    intentHARASS.putExtra("title", State.issuesList.get(7).getTitle());
                    intentHARASS.putExtra("mdlocation", State.issuesList.get(7).getMdLocation());
                    intentHARASS.putExtra("enumtype", State.issuesList.get(7).getEnumtype());
                    intentHARASS.putExtra("audiolocation", State.issuesList.get(7).getAudioLocation());
                    intentHARASS.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intentHARASS);
                    break;
                case R.id.advertising:
                    Intent intentADV = new Intent(getApplicationContext(), MoralIssueItemActivitiy.class);
                    intentADV.putExtra("title", State.issuesList.get(1).getTitle());
                    intentADV.putExtra("mdlocation", State.issuesList.get(1).getMdLocation());
                    intentADV.putExtra("enumtype", State.issuesList.get(1).getEnumtype());
                    intentADV.putExtra("audiolocation", State.issuesList.get(1).getAudioLocation());
                    intentADV.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intentADV);
                    break;
                case R.id.product:
                    Intent intentPROD = new Intent(getApplicationContext(), MoralIssueItemActivitiy.class);
                    intentPROD.putExtra("title", State.issuesList.get(6).getTitle());
                    intentPROD.putExtra("mdlocation", State.issuesList.get(6).getMdLocation());
                    intentPROD.putExtra("enumtype", State.issuesList.get(6).getEnumtype());
                    intentPROD.putExtra("audiolocation", State.issuesList.get(6).getAudioLocation());
                    intentPROD.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intentPROD);
                    break;
                case R.id.employment:
                    Intent intentEMP = new Intent(getApplicationContext(), MoralIssueItemActivitiy.class);
                    intentEMP.putExtra("title", State.issuesList.get(5).getTitle());
                    intentEMP.putExtra("mdlocation", State.issuesList.get(5).getMdLocation());
                    intentEMP.putExtra("enumtype", State.issuesList.get(5).getEnumtype());
                    intentEMP.putExtra("audiolocation", State.issuesList.get(5).getAudioLocation());
                    intentEMP.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intentEMP);
                    break;
                case R.id.corp:
                    Intent intentCORP = new Intent(getApplicationContext(), MoralIssueItemActivitiy.class);
                    intentCORP.putExtra("title", State.issuesList.get(3).getTitle());
                    intentCORP.putExtra("mdlocation", State.issuesList.get(3).getMdLocation());
                    intentCORP.putExtra("enumtype", State.issuesList.get(3).getEnumtype());
                    intentCORP.putExtra("audiolocation", State.issuesList.get(3).getAudioLocation());
                    intentCORP.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().startActivity(intentCORP);
                    break;
                case R.id.dict:
                    binding.bottomNavigationView.setSelectedItemId(R.id.home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    homeFragment.setSelectedtab(3);
                    Objects.requireNonNull(homeFragment.getTabs().getTabAt(2)).select();
                    break;
                case R.id.extra:
                    binding.bottomNavigationView.setSelectedItemId(R.id.home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame, homeFragment).commit();
                    homeFragment.setSelectedtab(4);
                    Objects.requireNonNull(homeFragment.getTabs().getTabAt(3)).select();
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