package kourtis.quadrum.philosophito.core.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * Utility class for consistent fragment navigation throughout the app.
 * Reduces code duplication and provides centralized navigation logic.
 *
 * Usage:
 * <pre>
 * NavigationHelper.navigateTo(requireContext(), new QuizMenuFragment(), true);
 * </pre>
 *
 * @version 2.0
 */
public final class NavigationHelper {

    // Private constructor to prevent instantiation
    private NavigationHelper() {
        throw new AssertionError("Cannot instantiate NavigationHelper");
    }

    /**
     * Navigate to a fragment with optional back stack
     *
     * @param context        Context (should be AppCompatActivity)
     * @param fragment       Fragment to navigate to
     * @param addToBackStack Whether to add transaction to back stack
     */
    public static void navigateTo(@NonNull Context context,
                                   @NonNull Fragment fragment,
                                   boolean addToBackStack) {
        if (context instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) context;
            FragmentManager fragmentManager = activity.getSupportFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction()
                    .replace(android.R.id.content, fragment);

            if (addToBackStack) {
                transaction.addToBackStack(null);
            }

            transaction.commit();
        }
    }

    /**
     * Navigate to a fragment in a specific container with optional back stack
     *
     * @param context        Context (should be AppCompatActivity)
     * @param containerId    Container resource ID
     * @param fragment       Fragment to navigate to
     * @param addToBackStack Whether to add transaction to back stack
     */
    public static void navigateTo(@NonNull Context context,
                                   int containerId,
                                   @NonNull Fragment fragment,
                                   boolean addToBackStack) {
        if (context instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) context;
            FragmentManager fragmentManager = activity.getSupportFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction()
                    .replace(containerId, fragment);

            if (addToBackStack) {
                transaction.addToBackStack(null);
            }

            transaction.commit();
        }
    }

    /**
     * Navigate to a fragment with custom animations
     *
     * @param context        Context (should be AppCompatActivity)
     * @param containerId    Container resource ID
     * @param fragment       Fragment to navigate to
     * @param addToBackStack Whether to add transaction to back stack
     * @param enterAnim      Enter animation resource
     * @param exitAnim       Exit animation resource
     */
    public static void navigateToWithAnimation(@NonNull Context context,
                                                int containerId,
                                                @NonNull Fragment fragment,
                                                boolean addToBackStack,
                                                int enterAnim,
                                                int exitAnim) {
        if (context instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) context;
            FragmentManager fragmentManager = activity.getSupportFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction()
                    .setCustomAnimations(enterAnim, exitAnim)
                    .replace(containerId, fragment);

            if (addToBackStack) {
                transaction.addToBackStack(null);
            }

            transaction.commit();
        }
    }

    /**
     * Navigate to a fragment with fade animation
     *
     * @param context        Context (should be AppCompatActivity)
     * @param containerId    Container resource ID
     * @param fragment       Fragment to navigate to
     * @param addToBackStack Whether to add transaction to back stack
     */
    public static void navigateToWithFade(@NonNull Context context,
                                           int containerId,
                                           @NonNull Fragment fragment,
                                           boolean addToBackStack) {
        if (context instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) context;
            FragmentManager fragmentManager = activity.getSupportFragmentManager();

            FragmentTransaction transaction = fragmentManager.beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .replace(containerId, fragment);

            if (addToBackStack) {
                transaction.addToBackStack(null);
            }

            transaction.commit();
        }
    }

    /**
     * Pop the back stack to go back one fragment
     *
     * @param context Context (should be AppCompatActivity)
     * @return true if there was something to pop, false otherwise
     */
    public static boolean navigateBack(@NonNull Context context) {
        if (context instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) context;
            FragmentManager fragmentManager = activity.getSupportFragmentManager();

            if (fragmentManager.getBackStackEntryCount() > 0) {
                fragmentManager.popBackStack();
                return true;
            }
        }
        return false;
    }

    /**
     * Clear all fragments from back stack
     *
     * @param context Context (should be AppCompatActivity)
     */
    public static void clearBackStack(@NonNull Context context) {
        if (context instanceof AppCompatActivity) {
            AppCompatActivity activity = (AppCompatActivity) context;
            FragmentManager fragmentManager = activity.getSupportFragmentManager();

            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }
}
