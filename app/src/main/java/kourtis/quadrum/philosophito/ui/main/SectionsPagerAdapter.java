package kourtis.quadrum.philosophito.ui.main;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import kourtis.quadrum.philosophito.R;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_Moral_Theories, R.string.tab_text_CSR, R.string.tab_text_Whistle_Blowing, R.string.tab_text_Discrimination, R.string.tab_text_Affirmative_Action, R.string.tab_text_Sexual_Harassment, R.string.tab_text_Advertising, R.string.tab_text_Product_Safety, R.string.tab_text_Employment, R.string.tab_text_Corporate_Governance, R.string.tab_text_Dictionary};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MoralTheoriesFragment();
            case 1:
                return new CsrFragment();
            case 2:
                return new WhistleBlowingFragment();
            case 3:
                return new DiscriminationFragment();
            case 4:
                return new AffirmativeActionFragment();
            case 5:
                return new SexualHarassmentFragment();
            case 6:
                return new AdvertisingFragment();
            case 7:
                return new ProductSafetyFragment();
            case 8:
                return new EmploymentFragment();
            case 9:
                return new CorporateGovernanceFragment();
            case 10:
                return new DictionaryFragment();
            default:
                return new Fragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        return 11;
    }
}