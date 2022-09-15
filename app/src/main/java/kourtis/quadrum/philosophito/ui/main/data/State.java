package kourtis.quadrum.philosophito.ui.main.data;

import java.util.ArrayList;
import java.util.Collections;

public class State {

    public static final ArrayList<Theory> theoriesList = new ArrayList<>();
    public static final ArrayList<DictionaryItem> dictionary = new ArrayList<>();
    public static final ArrayList<ExtraItem> extras = new ArrayList<>();

    public State() {
        initTheories();
        initDictionary();
        initExtra();
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
        dictionary.add(new DictionaryItem("Whistleblower", "Any employee who reports misconduct when observed in the workplace. Although some believe whistleblowers are distinct from internal reporters, ECI research indicates that nearly all employees who report to someone outside their organization report internally as well. Furthermore, internal reporting always precedes reporting externally. External reporting is usually a function of the organization’s (perceived) lack of adequate response to the report."));
        dictionary.add(new DictionaryItem("Values", "The core beliefs we hold regarding what is right and fair in terms of our actions and our interactions with others. Another way to characterize values is that they are what an individual believes to be of worth and importance to their life (valuable) (from “What is the Difference Between Ethics, Morals and Values?”, Frank Navran).\n" +
                "Values-Centered Code of Ethics\n" +
                "A set of principles for an organization and its employees grounded in ideals (such as integrity, trust-worthiness and responsibility) which guide workplace decision-making and conduct."));
        dictionary.add(new DictionaryItem("Sustainability", "Generally, referring to a state or condition that can be maintained over an indefinite period of time. Commonly used with development as in: “Sustainable development is development that meets the needs of the present without compromising the ability of future generations to meet their own needs” (from the landmark 1987 publication “Our Common Future” by the World Commission on Environment and Development)."));
        dictionary.add(new DictionaryItem("Transparency", "Sharing information and acting in an open manner.\n" +
                "A principle that allows those affected by administrative decisions, business transactions or charitable work to know not only the basic facts and figures but also the mechanisms and processes. It is the duty of civil servants, managers and trustees to act visibly, predictably and understandably (based on 2006 publications by Transparency International, https://www.transparency.org/)."));
        dictionary.add(new DictionaryItem("Reputational Risk", "Potential for harm resulting from the loss of stakeholder trust."));
        dictionary.add(new DictionaryItem("Reporter", "Any employee who observes workplace misconduct and informs an appropriate authority (either external or internal to the organization)."));
        dictionary.add(new DictionaryItem("Reporting System", "Any mechanism (i.e., helpline, hotline or website) established by an organization in order to provide employees and other agents with a means to report misconduct to the organization without fear of retribution. An essential component of an ethics and compliance program, reporting systems may be confidential and/or anonymous and enable the organization to “exercise due diligence to prevent and detect criminal conduct” per Chapter Eight of the Federal Sentencing Guidelines Manual."));
        dictionary.add(new DictionaryItem("Morals", "Values that we attribute to a system of beliefs that help the individual define right versus wrong, good versus bad. These typically get their authority from something outside the individual – a higher being or higher authority (i.e., government, society). Moral concepts, judgments and practices may vary from one society to another."));
        dictionary.add(new DictionaryItem("Maxims", "Short, pithy statements that are used to instruct and guide behavior."));
        dictionary.add(new DictionaryItem("Independence", "In the most general usage, freedom to act without control or influence from others, to be free to make decisions and act without external constraint. In the business world, independence has come to have a specialized meaning. It is most commonly understood to mean freedom from conflicting interests – the specialized case of having the ability to make a decision or act in ways which are free from conflict between one’s personal interests and the interests of the party on whose behalf we are making the decision."));
        dictionary.add(new DictionaryItem("Governance", "The act, process or power of exercising authority or control in an organizational setting."));
        dictionary.add(new DictionaryItem("Good Faith", "Based on the belief in the accuracy of the information or concern being reported."));
        dictionary.add(new DictionaryItem("Ethical Congruence", "A situation where one’s decision is consistent with, aligns with, the applicable set(s) of values. Under these circumstances, a choice to take some action will harmonize with the decision-maker’s values. The organizational state where values, behaviors and perceptions are aligned."));
        dictionary.add(new DictionaryItem("Corruption", "The abuse of public power for private benefit. Perversion or destruction of integrity in the discharge of public duties by bribery or favor or the use or existence of corrupt practices, especially in a state or public corporation."));
        dictionary.add(new DictionaryItem("Conflict of Interest", "A person has a conflict of interest when the person is in a position of trust which requires her to exercise judgment on behalf of others (people, institutions, etc.) and also has interests or obligations of the sort that might interfere with the exercise of her judgment, and which the person is required to either avoid or openly acknowledge."));
        dictionary.add(new DictionaryItem("Code of Ethics", "Often conveys organizational values, a commitment to standards and communicates a set of ideals. In practice, used interchangeably with Code of Conduct. In Section 406(c), the Sarbanes-Oxley Act defines “code of ethics” as such standards as are reasonably necessary to promote– (1) honest and ethical conduct, including the ethical handling of actual or apparent conflicts of interest between personal and professional relationships; (2) full, fair, accurate, timely, and understandable disclosure in the periodic reports required to be filed by the issuer; and (3) in compliance with applicable governmental rules and regulations."));
        dictionary.add(new DictionaryItem("Code of Conduct", "Can refer to a listing of required behaviors, the violation of which would result in disciplinary action. In practice, used interchangeably with Code of Ethics."));
        dictionary.add(new DictionaryItem("Agency", "Belief that one has the power to enact change. Agency is a critical component in reporting decisions because most people will only report if they believe their action has the potential to make a difference."));
        Collections.sort(dictionary, (s1, s2) -> s1.getTitle().compareToIgnoreCase(s2.getTitle()));
    }


    private void initExtra() {
        extras.clear();
        extras.add(new ExtraItem("https://www.ted.com/talks/marianne_cooper_the_power_of_us_how_we_stop_sexual_harassment?language=en", "The power of us: how we stop sexual harassment | Marianne Cooper", "To stop sexual harassment, we must understand why it happens. In her Tedx Talk, Stanford University sociologist Marianne Cooper shares the research with us about the root causes of sexual harassment. And then, with her powerful call to action, we learn about what each of us can do to prevent harassment, hold abusers accountable, give voice to the voiceless, and work together to create long lasting change. Marianne Cooper is a sociologist studying gender and inequality at the Clayman Institute for Gender Research and the Center for Women’s Leadership at Stanford University. She is also an affiliate at the Stanford Center on Poverty and Inequality. She was the lead researcher for Lean In: Women, Work, and the Will to Lead by Sheryl Sandberg. She is a contributing writer to The Atlantic and writes about gender, leadership, diversity and inclusion, financial insecurity, and economic inequality. She is an author of the 2016, 2017, and 2018 Lean In & McKinsey Women in the Workplace reports on the status of women in corporate America. Her book, Cut Adrift: Families in Insecure Times, examines how families are coping with economic insecurity. She received her Ph.D. in sociology from the University of California, Berkeley. This talk was given at a TEDx event using the TED conference format but independently organized by a local community. Learn more at https://www.ted.com/tedx"));
        extras.add(new ExtraItem("https://www.ted.com/talks/gretchen_carlson_how_we_can_end_sexual_harassment_at_work?language=en", "How we can end sexual harassment at work", "When Gretchen Carlson spoke out about her experience of workplace sexual harassment, it inspired women everywhere to take their power back and tell the world what happened to them. In a remarkable, fierce talk, she tells her story -- and identifies three specific things we can all do to create safer places to work. \"We will no longer be underestimated, intimidated or set back,\" Carlson says. \"We will stand up and speak up and have our voices heard. We will be the women we were meant to be.\""));
        extras.add(new ExtraItem("https://www.ted.com/talks/jackson_katz_violence_against_women_it_s_a_men_s_issue?language=en", "Violence against women -- it's a men's issue", "Domestic violence and sexual abuse are often called \"women's issues.\" But in this bold, blunt talk, Jackson Katz points out that these are intrinsically men's issues -- and shows how these violent behaviors are tied to definitions of manhood. A clarion call for us all -- women and men -- to call out unacceptable behavior and be leaders of change."));
        extras.add(new ExtraItem("https://www.ted.com/talks/john_biewen_the_lie_that_invented_racism", "The lie that invented racism", "To understand and eradicate racist thinking, start at the beginning. That's what journalist and documentarian John Biewen did, leading to a trove of surprising and thought-provoking information on the \"origins\" of race. He shares his findings, supplying answers to fundamental questions about racism -- and lays out an exemplary path for practicing effective allyship."));
        extras.add(new ExtraItem("https://www.ted.com/talks/michelle_tlaseca_verde_why_we_need_affirmative_action", "Why We Need Affirmative Action", "Affirmative action in higher education continues to be a hotly contested policy. In her talk, Michelle details the myriad ways in which American society has systematically worked to help white Americans and oppress African Americans. Michelle goes on to argue that knowing this history will help all Americans see the necessity of affirmative action policies."));
        extras.add(new ExtraItem("https://www.ted.com/talks/baratunde_thurston_how_to_deconstruct_racism_one_headline_at_a_time", "How to deconstruct racism, one headline at a time", "Baratunde Thurston explores the phenomenon of white Americans calling the police on Black Americans who have committed the crimes of ... eating, walking or generally \"living while Black.\" In this profound, thought-provoking and often hilarious talk, he reveals the power of language to change stories of trauma into stories of healing -- while challenging us all to level up."));

        extras.add(new ExtraItem("https://www.youtube.com/watch?v=VO6XEQIsCoM&ab_channel=TED", "The paradox of choice | Barry Schwartz", "Psychologist Barry Schwartz takes aim at a central tenet of western societies: freedom of choice. In Schwartz's estimation, choice has made us not freer but more paralyzed, not happier but more dissatisfied."));
        extras.add(new ExtraItem("http://www.youtube.com/watch?v=lA-zdh_bQBo", "Barry Schwartz: Our loss of wisdom", "Barry Schwartz makes a passionate call for practical wisdom as an antidote to a society gone mad with bureaucracy. He argues powerfully that rules often fail us, incentives often backfire, and practical, everyday wisdom will help rebuild our world."));
        extras.add(new ExtraItem("http://www.youtube.com/watch?v=IDS-ieLCmS4", "Barry Schwartz: Using our practical wisdom", "In an intimate talk, Barry Schwartz dives into the question \"How do we do the right thing?\" With help from collaborator Kenneth Sharpe, he shares stories that illustrate the difference between following the rules and truly choosing wisely."));
        extras.add(new ExtraItem("http://www.youtube.com/watch?v=PZFoJiqmW2s", "Vintage 1960's Anacin TV Commercial", ""));
        extras.add(new ExtraItem("http://www.youtube.com/watch?v=4bfzQhs0Jyw", "Grocery Store Kid Condom Ad", ""));
        extras.add(new ExtraItem("http://www.youtube.com/watch?v=W-Dls232Q_g", "Another Top 10 Funniest Banned Commercials", "Although they may be hilarious, for some, these commercials just went too far and as a result, were banned from TV. Luckily however, they are still available on the internet. From a dirty Doritos ad to a Game Boy Micro commercial these videos are hard to watch without laughing. "));
        extras.add(new ExtraItem("http://www.youtube.com/watch?v=Gv1fpvAqMh8", "Banned Commercials You Won't Be Seeing Anytime Soon", "Some of these ads got banned for being too risque for network TV, while others were too violent, sacrilegious, or—in the case of a truly bizarre Axe commercial—simultaneously risque and sacrilegious"));
        extras.add(new ExtraItem("http://www.youtube.com/watch?v=Y888wVY5hzw", "The Corporation", "THE CORPORATION is a Canadian documentary film written by Joel Bakan, and directed by Mark Achbar and Jennifer Abbott. The documentary examines the modern-day corporation, considering its legal status as a class of person and evaluating its behavior towards society and the world at large as a psychiatrist might evaluate an ordinary person. This is explored through specific examples. Bakan wrote the book, The Corporation: The Pathological Pursuit of Profit and Power, during the filming of the documentary."));
        extras.add(new ExtraItem("https://vimeo.com/218553565", "Ethical Consumption", "Interviewees Christian Barry and Kate McDonald unwind supply chains and consider ethical consumption in a complex world."));
        extras.add(new ExtraItem("https://vimeo.com/231632026?from=outro-embed", "Ethics Matters", ""));
        extras.add(new ExtraItem("http://www.youtube.com/watch?v=5jfdjiUeDnk", "VERYBODY DIES, BUT NOT EVERYBODY LIVES Hebrew Sub 2016", ""));
        Collections.sort(extras, (s1, s2) -> s1.getTitle().compareToIgnoreCase(s2.getTitle()));
    }
}