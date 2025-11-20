package kourtis.quadrum.philosophito.core.util;

/**
 * Intent extra key constants for Philosophito app.
 * Centralizes all Intent extra keys to prevent typos and improve maintainability.
 * Uses reverse domain name notation to avoid conflicts.
 *
 * @version 2.0
 */
public final class IntentKeys {

    // Private constructor to prevent instantiation
    private IntentKeys() {
        throw new AssertionError("Cannot instantiate IntentKeys");
    }

    // Base package name for all keys
    private static final String BASE = "kourtis.quadrum.philosophito.";

    // ==================== Common Content Keys ====================

    /**
     * Key for content title
     */
    public static final String EXTRA_TITLE = BASE + "TITLE";

    /**
     * Key for markdown file location
     */
    public static final String EXTRA_MD_LOCATION = BASE + "MD_LOCATION";

    /**
     * Key for content enum type
     */
    public static final String EXTRA_ENUM_TYPE = BASE + "ENUM_TYPE";

    /**
     * Key for audio file location
     */
    public static final String EXTRA_AUDIO_LOCATION = BASE + "AUDIO_LOCATION";

    /**
     * Key for content description/definition
     */
    public static final String EXTRA_DESCRIPTION = BASE + "DESCRIPTION";

    /**
     * Key for external source URL
     */
    public static final String EXTRA_SOURCE_URL = BASE + "SOURCE_URL";

    // ==================== Dictionary Keys ====================

    /**
     * Key for dictionary item ID
     */
    public static final String EXTRA_DICTIONARY_ITEM_ID = BASE + "DICTIONARY_ITEM_ID";

    /**
     * Key for dictionary term title
     */
    public static final String EXTRA_DICTIONARY_TITLE = BASE + "DICTIONARY_TITLE";

    /**
     * Key for dictionary term definition
     */
    public static final String EXTRA_DICTIONARY_DEFINITION = BASE + "DICTIONARY_DEFINITION";

    /**
     * Key for dictionary term source
     */
    public static final String EXTRA_DICTIONARY_SOURCE = BASE + "DICTIONARY_SOURCE";

    // ==================== Quiz Keys ====================

    /**
     * Key for quiz set number
     */
    public static final String EXTRA_QUIZ_SET_NUMBER = BASE + "QUIZ_SET_NUMBER";

    /**
     * Key for quiz question list
     */
    public static final String EXTRA_QUIZ_QUESTIONS = BASE + "QUIZ_QUESTIONS";

    /**
     * Key for quiz score
     */
    public static final String EXTRA_QUIZ_SCORE = BASE + "QUIZ_SCORE";

    /**
     * Key for quiz total questions
     */
    public static final String EXTRA_QUIZ_TOTAL = BASE + "QUIZ_TOTAL";

    /**
     * Key for quiz user answers
     */
    public static final String EXTRA_QUIZ_USER_ANSWERS = BASE + "QUIZ_USER_ANSWERS";

    /**
     * Key for quiz correct answers
     */
    public static final String EXTRA_QUIZ_CORRECT_ANSWERS = BASE + "QUIZ_CORRECT_ANSWERS";

    // ==================== Favorites Keys ====================

    /**
     * Key for favorite item type
     */
    public static final String EXTRA_FAVORITE_TYPE = BASE + "FAVORITE_TYPE";

    /**
     * Key for favorite item data
     */
    public static final String EXTRA_FAVORITE_DATA = BASE + "FAVORITE_DATA";

    // ==================== Media Keys ====================

    /**
     * Key for media player state
     */
    public static final String EXTRA_MEDIA_STATE = BASE + "MEDIA_STATE";

    /**
     * Key for media playback position
     */
    public static final String EXTRA_MEDIA_POSITION = BASE + "MEDIA_POSITION";
}
