package kourtis.quadrum.philosophito.ui.main.data;

import java.util.ArrayList;
import java.util.Collections;

public class State {

    public static final ArrayList<Theory> theoriesList = new ArrayList<>();
    public static final ArrayList<DictionaryItem> dictionary = new ArrayList<>();

    public State() {
        initTheories();
        initDictionary();
    }

    private void initTheories() {
        theoriesList.clear();
        Theory theoryUtilitarianism = new Theory();
        theoryUtilitarianism.setTitle("Utilitarianism");
        theoryUtilitarianism.setShortDescription("Utilitarianism is a theory of morality, which advocates actions that foster happiness and oppose actions that cause unhappiness. Utilitarianism promotes \"the greatest amount of good for the greatest number of people.\"");
        theoryUtilitarianism.setImage("@drawable/utilitarianismbtn");
        theoryUtilitarianism.setFullContent("util.md");

        Theory theoryKantianism = new Theory();
        theoryKantianism.setTitle("Kantianism");
        theoryKantianism.setShortDescription("Kantianism comprises diverse philosophies that share Kant's concern to explore the nature and limits of human knowledge in the hope of raising philosophy to the level of a science. Each submovement of Kantianism has tended to focus on its own selection and reading of Kant's many concerns.");
        theoryKantianism.setImage("@drawable/kantbtn2");
        theoryKantianism.setFullContent("kantianism.md");

        Theory theoryVirtueEthics = new Theory();
        theoryVirtueEthics.setTitle("Virtue Ethics");
        theoryVirtueEthics.setShortDescription("Virtue ethics mainly deals with the honesty and morality of a person. It states that practicing good habits such as honesty, generosity makes a moral and virtuous person. It guides a person without specific rules for resolving the ethical complexity.");
        theoryVirtueEthics.setImage("@drawable/virtueethicsbtn");
        theoryVirtueEthics.setFullContent("virtueethics.md");

        theoriesList.add(theoryUtilitarianism);
        theoriesList.add(theoryKantianism);
        theoriesList.add(theoryVirtueEthics);
    }

    private void initDictionary() {
        dictionary.clear();
        dictionary.add(new DictionaryItem("Business Ethics", "the conduct by which companies and their agents abide by the law and respect the rights of their stakeholders, particularly their customers, clients, employees, and the surrounding community and environment"));
        dictionary.add(new DictionaryItem("Compliance", "the extent to which a company conducts its business operations in accordance with applicable regulation and statutes"));
        dictionary.add(new DictionaryItem("Corporate Culture", "the shared beliefs, values, and behaviors that create the organizational context within which employees and managers interact"));
        dictionary.add(new DictionaryItem("Corporate Social Responsibility (CSR)", "the practice in which a business views itself within a broader context, as a member of society with certain implicit social obligations and responsibility for its own effects on environmental and social well-being"));
        dictionary.add(new DictionaryItem("Ceontology", "a normative ethical theory suggesting that an ethical decision requires us to observe only the rights and duties we owe to others, and, in the context of business, act on the basis of a primary motive to do what is right by all stakeholders"));
        dictionary.add(new DictionaryItem("Ethical Relativism", "a view that ethics depends entirely upon context"));
        dictionary.add(new DictionaryItem("Ethics", "the standards of behavior to which we hold ourselves in our personal and professional lives"));
        dictionary.add(new DictionaryItem("Goodwill", "the value of a business beyond its tangible assets, usually including its reputation, the value of its brand, the attitude of its workforce, and customer relations"));
        dictionary.add(new DictionaryItem("Integrity", "the adherence to a code of moral values implying trustworthiness and incorruptibility because there is unity between what we say and what we do"));
        dictionary.add(new DictionaryItem("Long-term Perspective", "a broad view of profit maximization that recognizes the fact that the impact of a business decision may not manifest for a long time"));
        dictionary.add(new DictionaryItem("Normative Ethical Theories", "a group of philosophical theories that describe how people ought to behave on the basis of reason"));
        dictionary.add(new DictionaryItem("Shareholder", "an individual or institution that owns stock or shares in a corporation, by definition a type of stakeholder; also called stockholder"));
        dictionary.add(new DictionaryItem("Short-term Perspective", "a focus on the goal of maximizing periodic (i.e., quarterly and annual) profits"));
        dictionary.add(new DictionaryItem("Social Contract", "an implicit agreement among societal members to cooperate for social benefit; when applied specifically to a business, it suggests a company that responsibly gives back to the society that permits it to incorporate, benefiting the community at the same time that it enriches itself"));
        dictionary.add(new DictionaryItem("Stakeholders", "individuals and entities affected by a business’s decisions, including customers, suppliers, investors, employees, the community, and the environment, among others"));
        Collections.sort(dictionary, (s1, s2) -> s1.getTitle().compareToIgnoreCase(s2.getTitle()));
    }
}