package kourtis.quadrum.philosophito.core.util;

/**
 * Application-wide constants for Philosophito app.
 * Centralizes magic numbers and hardcoded values for better maintainability.
 *
 * @version 2.0
 */
public final class AppConstants {

    // Private constructor to prevent instantiation
    private AppConstants() {
        throw new AssertionError("Cannot instantiate AppConstants");
    }

    // ==================== Timing Constants ====================

    /**
     * Splash screen display duration in milliseconds
     */
    public static final long SPLASH_SCREEN_DELAY_MS = 2500;

    /**
     * Quiz answer feedback delay in milliseconds
     */
    public static final long QUIZ_ANSWER_FEEDBACK_DELAY_MS = 1500;

    /**
     * Countdown timer interval in milliseconds
     */
    public static final long COUNTDOWN_INTERVAL_MS = 1000;

    /**
     * MediaPlayer seek bar update interval in milliseconds
     */
    public static final long SEEKBAR_UPDATE_INTERVAL_MS = 100;

    // ==================== Quiz Constants ====================

    /**
     * Quiz choice option A
     */
    public static final int CHOICE_A = 1;

    /**
     * Quiz choice option B
     */
    public static final int CHOICE_B = 2;

    /**
     * Quiz choice option C
     */
    public static final int CHOICE_C = 3;

    /**
     * Quiz choice option D
     */
    public static final int CHOICE_D = 4;

    /**
     * Total number of quiz sets available
     */
    public static final int TOTAL_QUIZ_SETS = 15;

    /**
     * Questions per quiz set
     */
    public static final int QUESTIONS_PER_QUIZ = 10;

    // ==================== SharedPreferences Keys ====================

    /**
     * SharedPreferences file name
     */
    public static final String PREFS_NAME = "PhilosophitoPrefs";

    /**
     * Key for storing favorites in SharedPreferences
     */
    public static final String PREF_KEY_FAVORITES = "favorites";

    // ==================== Navigation Constants ====================

    /**
     * Home tab position in bottom navigation
     */
    public static final int TAB_HOME = 0;

    /**
     * Quiz tab position in bottom navigation
     */
    public static final int TAB_QUIZ = 1;

    /**
     * Favorites tab position in bottom navigation
     */
    public static final int TAB_FAVORITES = 2;

    /**
     * Settings tab position in bottom navigation
     */
    public static final int TAB_SETTINGS = 3;

    /**
     * Home ViewPager tab count
     */
    public static final int HOME_TAB_COUNT = 4;

    // ==================== Content Indices ====================

    /**
     * Index for Utilitarianism theory
     */
    public static final int THEORY_INDEX_UTILITARIANISM = 0;

    /**
     * Index for Kantianism theory
     */
    public static final int THEORY_INDEX_KANTIANISM = 1;

    /**
     * Index for Virtue Ethics theory
     */
    public static final int THEORY_INDEX_VIRTUE_ETHICS = 2;

    // ==================== Error Messages ====================

    /**
     * Error message when content is not available
     */
    public static final String ERROR_CONTENT_UNAVAILABLE = "Content not available";

    /**
     * Error message for invalid quiz question
     */
    public static final String ERROR_INVALID_QUESTION = "Invalid question index";

    /**
     * Error message for network issues
     */
    public static final String ERROR_NETWORK = "Network error occurred";

    /**
     * Error message for database issues
     */
    public static final String ERROR_DATABASE = "Database error occurred";
}
