package kourtis.quadrum.philosophito.core.data.local;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import kourtis.quadrum.philosophito.core.data.local.dao.DictionaryDao;
import kourtis.quadrum.philosophito.core.data.local.dao.IssueDao;
import kourtis.quadrum.philosophito.core.data.local.dao.QuizDao;
import kourtis.quadrum.philosophito.core.data.local.dao.TheoryDao;
import kourtis.quadrum.philosophito.core.data.local.entity.DictionaryEntity;
import kourtis.quadrum.philosophito.core.data.local.entity.IssueEntity;
import kourtis.quadrum.philosophito.core.data.local.entity.QuizEntity;
import kourtis.quadrum.philosophito.core.data.local.entity.QuizQuestionEntity;
import kourtis.quadrum.philosophito.core.data.local.entity.TheoryEntity;

/**
 * Room Database for Philosophito App
 * Replaces the old static State singleton with proper persistence
 */
@Database(
    entities = {
        TheoryEntity.class,
        IssueEntity.class,
        DictionaryEntity.class,
        QuizEntity.class,
        QuizQuestionEntity.class
    },
    version = 1,
    exportSchema = false
)
public abstract class PhilosophitoDatabase extends RoomDatabase {

    // DAOs
    public abstract TheoryDao theoryDao();
    public abstract IssueDao issueDao();
    public abstract DictionaryDao dictionaryDao();
    public abstract QuizDao quizDao();

    // Singleton instance
    private static volatile PhilosophitoDatabase INSTANCE;

    // ExecutorService for background operations
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    /**
     * Get database instance (Singleton pattern)
     */
    public static PhilosophitoDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PhilosophitoDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            PhilosophitoDatabase.class,
                            "philosophito_database"
                        )
                        .addCallback(roomDatabaseCallback)
                        .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Database callback to populate initial data on first creation
     */
    private static final RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // Populate database with initial data on first creation
            databaseWriteExecutor.execute(() -> {
                if (INSTANCE != null) {
                    populateInitialData(INSTANCE);
                }
            });
        }
    };

    /**
     * Populate database with initial data
     * This replaces the initialization logic from the old State.java singleton
     */
    private static void populateInitialData(PhilosophitoDatabase db) {
        // Clear existing data (in case of reimport)
        db.theoryDao().deleteAll();
        db.issueDao().deleteAll();
        db.dictionaryDao().deleteAll();
        db.quizDao().deleteAllQuizzes();
        db.quizDao().deleteAllQuestions();

        // Populate Theories
        populateTheories(db);

        // Populate Issues
        populateIssues(db);

        // Populate Dictionary
        populateDictionary(db);

        // Populate Quizzes
        populateQuizzes(db);
    }

    private static void populateTheories(PhilosophitoDatabase db) {
        List<TheoryEntity> theories = new ArrayList<>();

        theories.add(new TheoryEntity(
            "Utilitarianism",
            "Utilitarianism is a theory of morality, which advocates actions that foster happiness and oppose actions that cause unhappiness. Utilitarianism promotes \"the greatest amount of good for the greatest number of people.\"",
            "@drawable/john",
            "file:///android_asset/theories/md/util.md",
            "moraltheoryUTIL",
            "sample"
        ));

        theories.add(new TheoryEntity(
            "Kantianism",
            "Kantianism comprises diverse philosophies that share Kant's concern to explore the nature and limits of human knowledge in the hope of raising philosophy to the level of a science. Each submovement of Kantianism has tended to focus on its own selection and reading of Kant's many concerns.",
            "@drawable/kant",
            "file:///android_asset/theories/md/kantianism.md",
            "moraltheoryKANT",
            "sample"
        ));

        theories.add(new TheoryEntity(
            "Virtue Ethics",
            "Virtue ethics mainly deals with the honesty and morality of a person. It states that practicing good habits such as honesty, generosity makes a moral and virtuous person. It guides a person without specific rules for resolving the ethical complexity.",
            "@drawable/aristotle",
            "file:///android_asset/theories/md/virtueethics.md",
            "moraltheoryVIRTUE",
            "sample"
        ));

        db.theoryDao().insertAll(theories);
    }

    private static void populateIssues(PhilosophitoDatabase db) {
        List<IssueEntity> issues = new ArrayList<>();

        issues.add(new IssueEntity(
            "Corporate Social Responsibility",
            "Corporate social responsibility (CSR) is a business model that helps a company be socially accountable to itself, its stakeholders, and the public.",
            "@drawable/csr",
            "file:///android_asset/issues/md/csr.md",
            "moralissueCSR",
            "sample"
        ));

        issues.add(new IssueEntity(
            "Deceptive Advertising",
            "Deceptive advertising is false advertising, and it is illegal according to the Federal Trade Commission. It is also unethical.",
            "@drawable/falseadvertising",
            "file:///android_asset/issues/md/advertising.md",
            "moralissueADV",
            "sample"
        ));

        issues.add(new IssueEntity(
            "Affirmative Action",
            "Affirmative action refers to policies and programs that are designed to actively promote equal opportunity in the workplace or in education for people regardless of their race, gender, national origin, sexual orientation, and other factors.",
            "@drawable/affirmativeaction",
            "file:///android_asset/issues/md/affirmativeaction.md",
            "moralissueAFF",
            "sample"
        ));

        issues.add(new IssueEntity(
            "Corporate Governance",
            "Corporate governance is the system by which companies are directed and controlled. Boards of directors are responsible for the governance of their companies. The shareholders' role in governance is to appoint the directors and the auditors and to satisfy themselves that an appropriate governance structure is in place.",
            "@drawable/corporategovernance",
            "file:///android_asset/issues/md/governance.md",
            "moralissueCORP",
            "sample"
        ));

        issues.add(new IssueEntity(
            "Discrimination",
            "Discrimination in the workplace is based on certain prejudices and occurs when an employee is treated unfavourably because of gender, sexuality, race, religion, pregnancy and maternity or disability.",
            "@drawable/discrimination",
            "file:///android_asset/issues/md/discrimination.md",
            "moralissueDISC",
            "sample"
        ));

        issues.add(new IssueEntity(
            "Employment",
            "Freedom to discuss the terms and conditions of the employment with other employees and negotiating wages to suit lifestyle as per changing times. Right to ask for safe working conditions and reservation to answering questions on age, religion, nationality, and medical condition.",
            "@drawable/employment",
            "file:///android_asset/issues/md/employment.md",
            "moralissueEMP",
            "sample"
        ));

        issues.add(new IssueEntity(
            "Product Safety",
            "A safe product is one that provides either no risk or a minimum acceptable level of risk, taking into account the normal or reasonably foreseeable use of the product and the need to maintain a high level of protection for consumers.",
            "@drawable/productsafety",
            "file:///android_asset/issues/md/safety.md",
            "moralissuePROD",
            "sample"
        ));

        issues.add(new IssueEntity(
            "Sexual Harassment",
            "Harassment For the purposes of this Policy, harassment is conduct, considered by the employer to be unacceptable in the workplace, in which an employee exhibits offensive behaviour to another employee, or group of employees, and where that individual knew, or ought reasonably to have known, the behaviour would cause offence or harm.",
            "@drawable/sexualharassment",
            "file:///android_asset/issues/md/harassment.md",
            "moralissueSEX",
            "sample"
        ));

        issues.add(new IssueEntity(
            "Whistleblowing",
            "Whistleblowing is the voluntary release of nonpublic information, as a moral protest, by a member or former member of an organization outside the normal channels of communication to an appropriate audience about illegal and/or immoral conduct in the organization or conduct in the organization that is opposed in some significant way to the public interest.",
            "@drawable/whistleblowing",
            "file:///android_asset/issues/md/whistleblowing.md",
            "moralissueWHISTLE",
            "sample"
        ));

        db.issueDao().insertAll(issues);
    }

    private static void populateDictionary(PhilosophitoDatabase db) {
        List<DictionaryEntity> dictionary = new ArrayList<>();

        dictionary.add(new DictionaryEntity(
            "Agency",
            "Agency is a contractual relationship between two parties, in which one party – the agent – is empowered to act, to make certain decisions, and to make legally-binding agreements on behalf of another party – the principal – subject to the principal's control.",
            "https://conciseencyclopedia.org/entries/agency/",
            0
        ));

        dictionary.add(new DictionaryEntity(
            "Capitalism",
            "Capitalism is an economic system that can be summed up roughly by the intersection of three practices. The first is the holding of private property, and the right to keep whatever profit that property generates.",
            "https://conciseencyclopedia.org/entries/capitalism/",
            1
        ));

        dictionary.add(new DictionaryEntity(
            "Compliance",
            "In business ethics contexts, compliance generally refers to a company's or a business person's conformity with relevant laws and regulations—that is, following the rules set out by government.",
            "https://conciseencyclopedia.org/entries/compliance/",
            2
        ));

        dictionary.add(new DictionaryEntity(
            "Human Rights",
            "Human rights are moral entitlements that are thought of as being owed to all humans, simply in light of the fact of their humanity, independent of any legal structure and regardless of where in the world they live.",
            "https://conciseencyclopedia.org/entries/human-rights/",
            3
        ));

        dictionary.add(new DictionaryEntity(
            "Ethical Consumerism",
            "Ethical Consumerism is the idea that consumers can, and should, act out a range of ethical values and principles and seek any of a range of ethical objectives through how they spend their money in the market.",
            "https://conciseencyclopedia.org/entries/ethical-consumerism/",
            4
        ));

        dictionary.add(new DictionaryEntity(
            "Environmental Ethics",
            "Environmental ethics is the field dedicated to understanding human responsibilities with regard to the natural environment. Some approaches to environmental ethics apply standard philosophical theories to environmental issues.",
            "https://conciseencyclopedia.org/entries/environmental-ethics/",
            5
        ));

        dictionary.add(new DictionaryEntity(
            "Sustainability",
            "The term "sustainability" is most often used in business ethics to refer to environmental sustainability. In its most general sense, environmental sustainability refers to the ability to make sustained (prolonged) use of some resource.",
            "https://conciseencyclopedia.org/entries/sustainability/",
            6
        ));

        dictionary.add(new DictionaryEntity(
            "Business Ethics",
            "Business ethics (also known as Corporate Ethics) is a form of applied ethics or professional ethics, that examines ethical principles and moral or ethical problems that can arise in a business environment.",
            "https://en.wikipedia.org/wiki/Business_ethics",
            7
        ));

        dictionary.add(new DictionaryEntity(
            "Maxim",
            "A maxim is a concise expression of a fundamental moral rule or principle, whether considered as objective or subjective contingent on one's philosophy.",
            "https://en.wikipedia.org/wiki/Maxim_(philosophy)",
            8
        ));

        dictionary.add(new DictionaryEntity(
            "Corporate Governance",
            "Corporate governance describes the processes, structures, and mechanisms that influence the control and direction of corporations.",
            "https://en.wikipedia.org/wiki/Corporate_governance",
            9
        ));

        dictionary.add(new DictionaryEntity(
            "Good Faith",
            "In contract law, the implied covenant of good faith and fair dealing is a general presumption that the parties to a contract will deal with each other honestly, fairly, and in good faith.",
            "https://en.wikipedia.org/wiki/Good_faith_(law)",
            10
        ));

        dictionary.add(new DictionaryEntity(
            "Corruption",
            "Corruption is a form of dishonesty or a criminal offense which is undertaken by a person or an organization which is entrusted in a position of authority, in order to acquire illicit benefits or abuse power for one's personal gain.",
            "https://en.wikipedia.org/wiki/Corruption",
            11
        ));

        dictionary.add(new DictionaryEntity(
            "Conflict of Interest",
            "A conflict of interest (COI) is a situation in which a person or organization is involved in multiple interests, financial or otherwise, and serving one interest could involve working against another.",
            "https://en.wikipedia.org/wiki/Conflict_of_interest",
            12
        ));

        dictionary.add(new DictionaryEntity(
            "Code of Ethics",
            "Codes of ethics, or in other words ethical codes, are adopted by organizations to assist members in understanding the difference between right and wrong and in applying that understanding to their decisions.",
            "https://en.wikipedia.org/wiki/Ethical_code",
            13
        ));

        dictionary.add(new DictionaryEntity(
            "Code of Conduct",
            "A code of conduct is a set of rules outlining the norms, rules, and responsibilities or proper practices of an individual party or an organization.",
            "https://en.wikipedia.org/wiki/Code_of_conduct",
            14
        ));

        db.dictionaryDao().insertAll(dictionary);
    }

    private static void populateQuizzes(PhilosophitoDatabase db) {
        // Create 15 quizzes
        for (int i = 1; i <= 15; i++) {
            QuizEntity quiz = new QuizEntity(
                "Mock Test " + i,
                "Business Ethics Quiz " + i,
                10  // 10 questions per quiz
            );
            long quizId = db.quizDao().insertQuiz(quiz);

            // Add placeholder questions (to be replaced with real content later)
            List<QuizQuestionEntity> questions = new ArrayList<>();
            for (int j = 1; j <= 10; j++) {
                questions.add(new QuizQuestionEntity(
                    (int) quizId,
                    "Question " + j + " - This is a placeholder question that needs to be replaced with real business ethics content",
                    1,  // Correct answer is A by default
                    "Option A - Placeholder",
                    "Option B - Placeholder",
                    "Option C - Placeholder",
                    "Option D - Placeholder",
                    "This explanation will help students understand the correct answer."
                ));
            }
            db.quizDao().insertAllQuestions(questions);
        }
    }
}
