package com.example.myapplication.ui.main.data;

import java.util.ArrayList;
import java.util.Collections;

public class State {

    public static final ArrayList<Theory> theoriesList = new ArrayList<>();
    public static final ArrayList<DictionaryItem> dictionary = new ArrayList<>();
    public static CSR CSR = new CSR();
    public static WhistleBlowing whistleBlowing = new WhistleBlowing();

    public State() {
        initTheories();
        initCSR();
        initWhistleBlowing();
        initDictionary();
    }

    private void initTheories() {
        theoriesList.clear();
        Theory theoryUtilitarianism = new Theory();
        theoryUtilitarianism.setTitle("Utilitarianism");
        theoryUtilitarianism.setShortDescription("Seeks to...");
        theoryUtilitarianism.setImage("@mipmap/john_foreground");
        theoryUtilitarianism.setFullContent("What Is Utilitarianism?\n" +
                "-----------------------\n" +
                "\n" +
                "Utilitarianism is a theory of morality that advocates actions that foster happiness or pleasure and oppose actions that cause unhappiness or harm. When directed toward making social, economic, or political decisions, a utilitarian philosophy would aim for the betterment of society as a whole.\n" +
                "\n" +
                "Utilitarianism would say that an action is right if it results in the happiness of the greatest number of people in a society or a group.\n" +
                "\n" +
                "### KEY TAKEAWAYS\n" +
                "\n" +
                "-   Utilitarianism is a theory of morality, which advocates actions that foster happiness and oppose actions that cause unhappiness.\n" +
                "-   Utilitarianism promotes \"the greatest amount of good for the greatest number of people.\"\n" +
                "-   When used in a sociopolitical construct, utilitarian ethics aims for the betterment of society as a whole.\n" +
                "-   Utilitarianism is a reason-based approach to determining right and wrong, but it has limitations.\n" +
                "-   Utilitarianism does not account for things like feelings and emotions, culture, or justice.\n" +
                "\n" +
                "Understanding Utilitarianism\n" +
                "----------------------------\n" +
                "\n" +
                "Utilitarianism is a tradition of ethical philosophy that is associated with Jeremy Bentham and [John Stuart Mill](https://www.investopedia.com/terms/j/john-stuart-mill.asp), two late 18th- and 19th-century British philosophers, economists, and political thinkers. Utilitarianism holds that an action is right if it tends to promote happiness and wrong if it tends to produce sadness, or the reverse of happiness---not just the happiness of the actor but that of everyone affected by it.\n" +
                "\n" +
                "At work, you display utilitarianism when you take actions to ensure that the office is a positive environment for your co-workers to be in, and then make it so for yourself.\n" +
                "\n" +
                "\"The greatest good for the greatest number\" is a maxim of utilitarianism.\n" +
                "\n" +
                "### The Three Generally Accepted Axioms of Utilitarianism State That\n" +
                "\n" +
                "-   Pleasure, or happiness, is the only thing that has intrinsic value.\n" +
                "-   Actions are right if they promote happiness, and wrong if they promote unhappiness.\n" +
                "-   Everyone's happiness counts equally.\n" +
                "\n" +
                "From the Founders of Utilitarianism\n" +
                "-----------------------------------\n" +
                "\n" +
                "Jeremy Bentham describes his \"greatest happiness principle\" in *Introduction to the Principles of Morals and Legislation, *a 1789 publication in which he writes: \"Nature has placed mankind under the governance of two sovereign masters, pain and pleasure. It is for them alone to point out what we ought to do, as well as to determine what we shall do.\"1\n" +
                "\n" +
                "John Stuart Mill had many years to absorb and reflect on Jeremy Bentham's thoughts on utilitarianism by the time he published his own work, *Utilitarianism*, in 1863. The key passage from this book:\n" +
                "\n" +
                "> The creed which accepts as the foundation of morals utility, or the greatest happiness principle, holds that actions are right in proportion as they tend to promote happiness, wrong as they tend to produce the reverse of happiness. By happiness is intended pleasure, and the absence of pain; by unhappiness, pain, and the privation of pleasure.2\n" +
                "\n" +
                "Utilitarianism's Relevance in a Political Economy\n" +
                "-------------------------------------------------\n" +
                "\n" +
                "In liberal democracies throughout the centuries, the progenitors of utilitarianism spawned variants and extensions of its core principles. Some of the questions they wrestled with include: What constitutes \"the greatest amount of good\"? How is happiness defined? How is justice accommodated?\n" +
                "\n" +
                "In today's Western democracies, policymakers are generally proponents of [free markets](https://www.investopedia.com/terms/f/freemarket.asp) and some base level of government interference in the private lives of citizens so as to assure safety and security. Although the appropriate amount of regulation and laws will always be a subject of debate, political and [economic policies](https://www.investopedia.com/ask/answers/031615/what-impact-does-economics-have-government-policy.asp) are geared primarily toward fostering as much well-being for as many people as possible, or at least they should be. Where there are disadvantaged groups who suffer income inequality or other negative consequences because of a utilitarian-based policy or action, most politicians would try to find a remedy.\n" +
                "\n" +
                "In Business and Commerce\n" +
                "------------------------\n" +
                "\n" +
                "Utilitarianism holds that the most ethical choice is the one that will produce the greatest good for the greatest number. As such, it is the only moral framework that can justify military force or war. Moreover, utilitarianism is the most common approach to [business ethics](https://www.investopedia.com/terms/b/business-ethics.asp) because of the way that it accounts for [costs and benefits](https://www.investopedia.com/terms/c/cost-benefitanalysis.asp).\n" +
                "\n" +
                "The theory asserts that there are two types of utilitarian ethics practiced in the business world, \"rule\" utilitarianism and \"act\" utilitarianism.\n" +
                "\n" +
                "-   Rule utilitarianism helps the largest number of people using the fairest methods possible.\n" +
                "-   Act utilitarianism makes the most ethical actions possible for the benefit of the people.\n" +
                "\n" +
                "Utilitarian Ethics\n" +
                "------------------\n" +
                "\n" +
                "### \"Rule\" Utilitarian Ethics\n" +
                "\n" +
                "An example of rule utilitarianism in business is tiered pricing for a product or service for different types of customers. In the airline industry, for example, many planes offer first-, business-, and economy-class seats. Customers who fly in first or business class pay a much higher rate than those in economy seats, but they also get more amenities---simultaneously, people who cannot afford upper-class seats benefit from the economy rates. This practice produces the highest good for the greatest number of people.\n" +
                "\n" +
                "And the airline benefits, too. The more expensive upper-class seats help to ease the financial burden that the airline created by making room for economy-class seats.\n" +
                "\n" +
                "\"Act\" Utilitarian Ethics\n" +
                "------------------------\n" +
                "\n" +
                "An example of act utilitarianism could be when pharmaceutical companies release drugs that have been governmentally approved, but with known minor side effects because the drug is able to help more people than are bothered by the side effects. Act utilitarianism often demonstrates the concept that \"the end justifies the means\"---or it's worth it.\n" +
                "\n" +
                "In the Corporate Workplace\n" +
                "--------------------------\n" +
                "\n" +
                "Most companies have a formal or informal [code of ethics](https://www.investopedia.com/terms/c/code-of-ethics.asp), which is shaped by their corporate culture, values, and regional laws. Today, having a formalized code of business ethics is more important than ever. For a business to grow, it not only needs to increase its [bottom line](https://www.investopedia.com/terms/b/bottomline.asp), but it also must create a reputation for being [socially responsible](https://www.investopedia.com/terms/c/corp-social-responsibility.asp). Companies also must endeavor to keep their promises and put ethics at least on par with profits. Consumers are looking for companies that they can trust, and employees work better when there is a solid model of ethics in place.\n" +
                "\n" +
                "On an individual level, if you make morally correct decisions at work, then everyone's happiness will increase. However, if you choose to do something morally wrong---even if legal---then your happiness and that of your colleagues, will decrease.\n" +
                "\n" +
                "The Limitations of Utilitarianism\n" +
                "---------------------------------\n" +
                "\n" +
                "In the workplace, though, utilitarian ethics are difficult to achieve. These ethics also can be challenging to maintain in our business culture, where a [capitalistic economy](https://www.investopedia.com/terms/c/capitalism.asp) often teaches people to focus on themselves at the expense of others. Similarly, [monopolistic competition](https://www.investopedia.com/terms/m/monopolisticmarket.asp) teaches one business to flourish at the expense of others.\n" +
                "\n" +
                "-   A limitation of utilitarianism is that it tends to create a black-and-white construct of morality. In utilitarian ethics, there are no shades of gray---either something is wrong or it is right.\n" +
                "-   Utilitarianism also cannot predict with certainty whether the consequences of our actions will be good or bad---the results of our actions happen in the future.\n" +
                "-   Utilitarianism also has trouble accounting for values like justice and individual rights. For example, say a hospital has four people whose lives depend upon receiving organ transplants: a heart, lungs, a kidney, and a liver. If a healthy person wanders into the hospital, his organs could be harvested to save four lives at the expense of his one life. This would arguably produce the greatest good for the greatest number. But few would consider it an acceptable course of action, let alone an ethical one.\n" +
                "\n" +
                "So, although utilitarianism is surely a reason-based approach to determining right and wrong, it has obvious limitations.\n" +
                "\n" +
                "What are the principles of utilitarianism?\n" +
                "------------------------------------------\n" +
                "\n" +
                "Utilitarianism puts forward that it is a virtue to improve one's life better by increasing the good things in the world and minimizing the bad things. This means striving for pleasure and happiness while avoiding discomfort or unhappiness.\n" +
                "\n" +
                "What is a utilitarian?\n" +
                "----------------------\n" +
                "\n" +
                "A utilitarian is a person who holds the beliefs of utilitarianism. Today, these people might be described as cold and calculating, practical, and perhaps selfish---since they may seek their own pleasure at the expense of the social good at times.\n" +
                "\n" +
                "What is rule utilitarianism?\n" +
                "----------------------------\n" +
                "\n" +
                "Rule utilitarians focus on the effects of actions that stem from certain rules or moral guidelines (e.g. the \"golden rule\", the 10 commandments, or laws against murder). If an action conforms to a moral rule then the act is moral. A rule is deemed moral if its existence increases the greater good than any other rule, or the absence of such a rule.\n" +
                "\n" +
                "What is utilitarian value in consumer behavior?\n" +
                "-----------------------------------------------\n" +
                "\n" +
                "If a consumer buys something only for its practical use-value, in a calculative and rational evaluation, then it is of utilitarian value. This precludes any sort of emotional or sentimental valuing, psychological biases, or other considerations.\n" +
                "\n" +
                "What is the ethical framework of utilitarianism in today's business environment?\n" +
                "--------------------------------------------------------------------------------\n" +
                "\n" +
                "Because its ideology argues for the greatest good for the greatest number, a business acting in a utilitarian fashion should increase the welfare of others. However, in practice, utilitarianism can lead to greed and dog-eat-dog competition that can undermine the social good.");

        Theory theoryKantianism = new Theory();
        theoryKantianism.setTitle("Kantianism");
        theoryKantianism.setShortDescription("Seeks to...");
        theoryKantianism.setImage("@mipmap/kant_foreground");
        theoryKantianism.setFullContent("[![Immanuel Kant](https://cdn.britannica.com/74/102174-050-79127006/Immanuel-Kant-print-London-1812.jpg?w=400&h=300&c=crop)](https://cdn.britannica.com/74/102174-050-79127006/Immanuel-Kant-print-London-1812.jpg)\n" +
                "\n" +
                "Immanuel Kant\n" +
                "\n" +
                "[See all media](https://www.britannica.com/topic/Kantianism/images-videos)\n" +
                "\n" +
                "Key People:\n" +
                "\n" +
                "[Hans Vaihinger](https://www.britannica.com/biography/Hans-Vaihinger) [Isaak August Dorner](https://www.britannica.com/biography/Isaak-August-Dorner)\n" +
                "\n" +
                "Related Topics:\n" +
                "\n" +
                "[categorical imperative](https://www.britannica.com/topic/categorical-imperative) [noumenon](https://www.britannica.com/topic/noumenon) [transcendental idealism](https://www.britannica.com/topic/transcendental-idealism) [Neo-Kantianism](https://www.britannica.com/topic/Neo-Kantianism) [transcendental method](https://www.britannica.com/topic/transcendental-method)\n" +
                "\n" +
                "...*(Show more)*\n" +
                "\n" +
                "[See all related content →](https://www.britannica.com/facts/Kantianism)\n" +
                "\n" +
                "Summary\n" +
                "\n" +
                "### Read a brief summary of this topic\n" +
                "\n" +
                "Kantianism, either the system of thought contained in the writings of the epoch-making 18th-century philosopher [Immanuel Kant](https://www.britannica.com/biography/Immanuel-Kant) or those later philosophies that arose from the study of Kant's writings and drew their inspiration from his principles. Only the latter is the concern of this article.\n" +
                "\n" +
                "Nature and types of Kantianism\n" +
                "------------------------------\n" +
                "\n" +
                "The Kantian movement [comprises](https://www.merriam-webster.com/dictionary/comprises) a loose assemblage of rather [diverse](https://www.merriam-webster.com/dictionary/diverse) philosophies that share Kant's concern with exploring the nature, and especially the limits, of human [knowledge](https://www.britannica.com/topic/epistemology) in the hope of raising [philosophy](https://www.britannica.com/topic/philosophy) to the level of a [science](https://www.britannica.com/science/history-of-science) in some sense similar to [mathematics](https://www.britannica.com/science/mathematics) and [physics](https://www.britannica.com/science/physics-science). Participating in the critical spirit and method of Kant, these philosophies are thus opposed to [dogmatism](https://www.britannica.com/topic/doctrine), to expansive speculative [naturalism](https://www.britannica.com/topic/naturalism-philosophy) (such as that of [Benedict de Spinoza](https://www.britannica.com/biography/Benedict-de-Spinoza), the Dutch Jewish rationalist), and, usually, to [irrationalism](https://www.britannica.com/topic/irrationalism). The various submovements of Kantianism are characterized by their sharing of certain \"family resemblances\"---i.e., by the preoccupation of each with its own selection of concerns from among the many developments of Kant's philosophy: a concern, for example, with the nature of [empirical](https://www.britannica.com/topic/empiricism) knowledge; with the way in which the [mind](https://www.britannica.com/topic/mind) imposes its own [categorial](https://www.britannica.com/topic/category-logic) structure upon experience, and, in particular, with the nature of the structure that renders human knowledge and [moral](https://www.merriam-webster.com/dictionary/moral) action possible, a structure considered to be [a priori](https://www.britannica.com/topic/a-priori-knowledge) (logically independent of experience); with the status of the *Ding an sich* (\"[thing-in-itself](https://www.britannica.com/topic/thing-in-itself)\"), that more ultimate [reality](https://www.britannica.com/topic/reality) that presumably lurks behind the [apprehension](https://www.merriam-webster.com/dictionary/apprehension) of an object; or with the relationship between knowledge and [morality](https://www.merriam-webster.com/dictionary/morality).\n" +
                "\n" +
                "A system such as the critical philosophy of Kant freely lends itself to reconstructions of its [synthesis](https://www.britannica.com/topic/synthesis-philosophy) according to whatever preferences the private philosophical inclinations of the reader may impose or suggest. Kant's system was a syncretism, or union, of British [empiricism](https://www.britannica.com/topic/empiricism) (as in [John Locke](https://www.britannica.com/biography/John-Locke), [George Berkeley](https://www.britannica.com/biography/George-Berkeley), and [David Hume](https://www.britannica.com/biography/David-Hume)) that stressed the role of experience in the rise of knowledge; of the scientific [methodology](https://www.merriam-webster.com/dictionary/methodology) of [Isaac Newton](https://www.britannica.com/biography/Isaac-Newton); and of the [metaphysical](https://www.merriam-webster.com/dictionary/metaphysical) apriorism (or [rationalism](https://www.britannica.com/topic/rationalism)) of [Christian Wolff](https://www.britannica.com/biography/Christian-baron-von-Wolff), who systematized the philosophy of [Gottfried Wilhelm Leibniz](https://www.britannica.com/biography/Gottfried-Wilhelm-Leibniz), with its emphasis on mind. Thus, it [constituted](https://www.merriam-webster.com/dictionary/constituted) a synthesis of elements very different in origin and nature, which tempted students to read their own presuppositions into it.\n" +
                "\n" +
                "The critical philosophy has been subjected to a variety of approaches and methods of interpretation. These can be reduced to three fundamental types: those that conceive of the critical philosophy as an [epistemology](https://www.britannica.com/topic/epistemology) or a pure theory of (scientific) knowledge and methodology, those that conceive of it as a critical theory of [metaphysics](https://www.britannica.com/topic/metaphysics) or the nature of being (ultimate reality), and those that conceive of it as a theory of normative or valuational reflection parallel to that of [ethics](https://www.britannica.com/topic/ethics-philosophy) (in the field of action). Each of these types---known, respectively, as epistemological, metaphysical, and [axiological](https://www.britannica.com/topic/axiology) Kantianism---can, in turn, be subdivided into several secondary approaches. Historically, epistemological Kantianism included such different attitudes as [empirical](https://www.merriam-webster.com/dictionary/empirical) Kantianism, rooted either in physiological or psychological inquiries; the logistic Kantianism of the [Marburg school](https://www.britannica.com/topic/Marburg-school), which stressed essences and the use of [logic;](https://www.britannica.com/topic/logic) and the realistic Kantianism of the Austrian Alois Riehl. Metaphysical Kantianism developed from the [transcendental](https://www.britannica.com/topic/transcendental-idealism) [idealism](https://www.britannica.com/topic/idealism) of German [Romanticism](https://www.britannica.com/art/Romanticism) to [realism](https://www.britannica.com/topic/realism-philosophy), a course followed by many speculative thinkers, who saw in the critical philosophy the foundations of an essentially inductive [metaphysics](https://www.merriam-webster.com/dictionary/metaphysics), in accordance with the results of the modern sciences. Axiological Kantianism, concerned with value theory, branched, first, into an axiological approach (properly so-called), which interpreted the methods of all three of Kant's *Critiques*---*Critik der reinen Vernunft* (1781, rev. ed. 1787; *[Critique of Pure Reason](https://www.britannica.com/topic/Critique-of-Pure-Reason)*), *Critik der practischen Vernunft* (1788; *Critique of Practical Reason*), and *Critik der Urteilskraft* (1790; *Critique of Judgment*)---as normative [disciplines](https://www.merriam-webster.com/dictionary/disciplines) of thought, and, second, into an [eclectic](https://www.merriam-webster.com/dictionary/eclectic) or relativistic Kantianism, which regarded the critical philosophy as a system of thought dependent upon social, cultural, and historical conditions. The chief representatives of these submovements are identified in the historical sections below.\n" +
                "\n" +
                "It is essential to distinguish clearly between two periods within the Kantian movement: first, the period from 1790 to 1831 (the death of the German idealist [G.W.F. Hegel](https://www.britannica.com/biography/Georg-Wilhelm-Friedrich-Hegel)) and, second, the period from 1860 to the present---separated by a time when an antiphilosophical [positivism](https://www.britannica.com/topic/positivism), a type of thought that supplanted metaphysics with science, was predominant. The first period began with the thorough study and emendation of Kant's chief theoretical work, the *Critique of Pure Reason*, but it soon became intermingled with the [romantic](https://www.merriam-webster.com/dictionary/romantic) tendencies in German [idealism](https://www.britannica.com/topic/idealism). The second period, called specifically [Neo-Kantianism](https://www.britannica.com/topic/Neo-Kantianism), was first of all a conscious reappraisal, in whole or in part, of the theoretical *Critique* but was also, as a total system, a reaction against positivism. Earlier Neo-Kantianism reduced philosophy to the theory of knowledge and scientific methodology; systematic Neo-Kantianism, arising at the beginning of the 20th century, expressed itself in attempts at building metaphysical structures.\n" +
                "\n" +
                "Early Kantianism: 1790--1835\n" +
                "===========================\n" +
                "\n" +
                "According to Kant, the *[Critique of Pure Reason](https://www.britannica.com/topic/Critique-of-Pure-Reason)* [comprised](https://www.merriam-webster.com/dictionary/comprised) a [treatise](https://www.merriam-webster.com/dictionary/treatise) on [methodology](https://www.merriam-webster.com/dictionary/methodology), a preliminary investigation prerequisite to the study of science, which placed the Newtonian method ([induction](https://www.britannica.com/topic/induction-reason), [inference](https://www.merriam-webster.com/dictionary/inference), and generalization) over against that of Descartes and Wolff ([deduction](https://www.britannica.com/topic/deduction-reason) from [intuitions](https://www.merriam-webster.com/dictionary/intuitions) asserted to be self-evident). The result was a [critique](https://www.merriam-webster.com/dictionary/critique) of [metaphysics](https://www.britannica.com/topic/metaphysics), the value of which lay not in science but in a realm of being accessible only to the pure intellect. In exploring this \"[noumenal](https://www.britannica.com/topic/noumenon)\" realm, as he called it, Kant placed his *Critique* in a positive role. Recalling the revolution that occurred in astronomy when [Nicolaus Copernicus](https://www.britannica.com/biography/Nicolaus-Copernicus) discerned, in the apparent motions of the planets, reflections of the Earth's own motion, Kant inaugurated a Copernican revolution in [philosophy](https://www.britannica.com/topic/philosophy), which claimed that the subject doing the knowing [constitutes](https://www.merriam-webster.com/dictionary/constitutes), to a considerable extent, the object---i.e., that knowledge is in part [constituted](https://www.merriam-webster.com/dictionary/constituted) by a priori or transcendental factors (contributed by the mind itself), which the mind imposes upon the data of experience. Far from being a description of an external reality, knowledge is, to Kant, the product of the knowing subject. When the data are those of sense experience, the transcendental (mental) apparatus constitutes human experience or science, or makes it to be such.\n" +
                "\n" +
                "[![Nicolaus Copernicus: heliocentric system](https://cdn.britannica.com/82/7782-004-831501EF/Engraving-Nicolaus-Copernicus-solar-system-illustration-De.jpg?w=690&h=388&c=crop)](https://cdn.britannica.com/82/7782-004-831501EF/Engraving-Nicolaus-Copernicus-solar-system-illustration-De.jpg)\n" +
                "\n" +
                "[Nicolaus Copernicus: heliocentric system](https://cdn.britannica.com/82/7782-004-831501EF/Engraving-Nicolaus-Copernicus-solar-system-illustration-De.jpg)\n" +
                "\n" +
                "Engraving of the solar system from Nicolaus Copernicus's *De revolutionibus orbium coelestium libri VI*, 2nd ed. (1566; \"Six Books Concerning the Revolutions of the Heavenly Orbs\"), the first published illustration of Copernicus's heliocentric system.\n" +
                "\n" +
                "*The Adler Planetarium and Astronomy Museum, Chicago, Illinois*\n" +
                "\n" +
                "These transcendental elements are of three different orders: at the lowest level are the forms of [space](https://www.britannica.com/science/space-physics-and-metaphysics) and [time](https://www.britannica.com/science/time) (technically called [intuitions](https://www.britannica.com/topic/intuition)); above these are the categories and principles of [human intelligence](https://www.britannica.com/science/human-intelligence-psychology), among them substance, [causality](https://www.britannica.com/topic/causation), and necessity; and at the uppermost level of abstraction are the ideas of [reason](https://www.britannica.com/topic/reason)---the [transcendental](https://www.britannica.com/topic/transcendental-ego) \"I,\" the world as a whole, and God. It is through the encounter between the forms of human sensory [intuition](https://www.merriam-webster.com/dictionary/intuition) (space and time) and [perceptions](https://www.britannica.com/topic/perception) that [phenomena](https://www.britannica.com/topic/phenomenon-philosophy) are formed. The forms arise from the subject himself; the perceptions, however---or the data of experience---have reference, ultimately, to things-in-themselves, which nevertheless remain unknowable, inasmuch as, in order to be known at all, it is necessary for things to appear clothed, as it were, in the forms of human intuition and, thenceforth, to present themselves as phenomena and not as noumena. The thing-in-itself, accordingly, indicates the limit and not the object of knowledge.\n" +
                "\n" +
                "These theses of Kant provoked [criticism](https://www.merriam-webster.com/dictionary/criticism) among the followers of Christian Wolff, the Leibnizian rationalist, and doubts among the [disciples](https://www.merriam-webster.com/dictionary/disciples) of Kant, which, as they further developed into systems, marked the first period of Kantianism. Inasmuch as these disciples took the *[Critique of Pure Reason](https://www.britannica.com/topic/Critique-of-Pure-Reason)* to be a \"preface\" to the study of pure reason or of the transcendental system and not the system itself, they saw in this interpretation an [explanation](https://www.britannica.com/topic/explanation) for the [ambiguities](https://www.merriam-webster.com/dictionary/ambiguities) to which the *Critique* (as they felt) was subject. Their doubts revolved around two points: first, Kant had erroneously distinguished three kinds of [a priori knowledge](https://www.britannica.com/topic/a-priori-knowledge), coordinate with the three aforementioned levels or faculties of the mind; and second, Kant had accepted the thing-in-itself as constitutive of knowledge. Regarding the first point, they claimed that Kant had accepted the three faculties and their respective transcendental characteristics without investigation, in which case this structure should be viewed, in accordance with the preliminary character of the *Critique*, as a triple [manifestation](https://www.merriam-webster.com/dictionary/manifestation) of a single fundamental faculty. For this reason the distinction between the levels of intuition and [understanding](https://www.britannica.com/topic/understanding) (or between the receptivity and spontaneity of the mind) had to be rejected---for the three transcendentals---space and time, the categories, and the ideas of reason---were not existents but were only functions of [thought](https://www.britannica.com/topic/thought). Finally, these disciples argued that the existence of a single transcendental subject, the Ego, would render the thing-in-itself superfluous and even [pernicious](https://www.merriam-webster.com/dictionary/pernicious) for the scientific treatment of [epistemology](https://www.britannica.com/topic/epistemology).\n" +
                "\n" +
                "[![Christian von Wolff, engraving by J.M. Bernigeroth, 1755](https://cdn.britannica.com/20/41520-004-5CD2B358/engraving-Christian-von-Wolff-JM-Bernigeroth-1755.jpg?w=690&h=388&c=crop)](https://cdn.britannica.com/20/41520-004-5CD2B358/engraving-Christian-von-Wolff-JM-Bernigeroth-1755.jpg)\n" +
                "\n" +
                "Christian von Wolff, engraving by J.M. Bernigeroth, 1755\n" +
                "\n" +
                "*Archiv für Kunst und Geschichte, Berlin*\n" +
                "\n" +
                "This function of human thought (the transcendental subject), which serves as the absolute source of the a priori, was variously designated by different early Kantian thinkers: for the German realist Karl L. Reinhold, it constituted the faculty of representation; for the Lithuanian idealist [Salomon Maimon](https://www.britannica.com/biography/Salomon-Maimon), it was a mental capacity for constructing objects; for the idealist Jakob S. Beck, a protégé of Kant, it was the act of synthesis; for the [empirical](https://www.merriam-webster.com/dictionary/empirical) critic of Kantianism [G.E. Schulze](https://www.britannica.com/biography/Gottlob-Ernst-Schulze), it was experience in the sense intended by Hume, a volley of discrete sense impressions; for the theory of knowledge of the outstanding [ethical](https://www.merriam-webster.com/dictionary/ethical) idealist [Johann G. Fichte](https://www.britannica.com/biography/Johann-Gottlieb-Fichte), it was the original positing of the [Ego](https://www.britannica.com/topic/ego-philosophy-and-psychology) and the non-Ego, which meant, in turn, in the case of the [aesthetic](https://www.merriam-webster.com/dictionary/aesthetic) idealist [F.W.J. von Schelling](https://www.britannica.com/biography/Friedrich-Wilhelm-Joseph-von-Schelling), the \"absolute self,\" in the case of Hegel, the *[Geist](https://www.britannica.com/topic/Geist)*, or \"absolute Spirit,\" and finally, in the case of the pessimistic Romanticist [Arthur Schopenhauer](https://www.britannica.com/biography/Arthur-Schopenhauer), the \"absolute [Will](https://www.britannica.com/topic/will-psychology-and-philosophy).\" In each case (excepting Schulze) the interpretation of the thing-in-itself in a realistic [metaphysical](https://www.merriam-webster.com/dictionary/metaphysical) sense was rejected in favour of various degrees of [transcendental idealism](https://www.britannica.com/topic/transcendental-idealism). Removed from the main current of Kantianism was the empirically oriented thinker [Jakob Friedrich Fries](https://www.britannica.com/biography/Jakob-Friedrich-Fries) (the one figure in this group who was not an idealist in the true sense), who interpreted the a priori in terms of psychological faculties and elements.\n" +
                "\n" +
                "Having earlier renounced these apostates on a large scale, Kant, at the end of his life, prepared a new exposition of the transcendental philosophy (the second part of his *Opus Postumum*), which showed that he was ready tacitly to accede to the [criticisms](https://www.merriam-webster.com/dictionary/criticisms) of his adversaries.");

        Theory theoryVirtueEthics = new Theory();
        theoryVirtueEthics.setTitle("Virtue Ethics");
        theoryVirtueEthics.setShortDescription("Seeks to...");
        theoryVirtueEthics.setImage("@mipmap/aristotle_foreground");
        theoryVirtueEthics.setFullContent("Ethics Explainer: Virtue Ethics\n" +
                "===============================\n" +
                "\n" +
                "###### ARTICLEBIG THINKERS + EXPLAINERS\n" +
                "\n" +
                "###### BY THE ETHICS CENTRE 16 FEB 2016\n" +
                "\n" +
                "Virtue ethics is arguably the oldest ethical theory in the world, with origins in Ancient Greece.\n" +
                "-------------------------------------------------------------------------------------------------\n" +
                "\n" +
                "It defines good actions as ones that display embody virtuous character traits, like courage, loyalty, or wisdom. A virtue itself is a disposition to act, think and feel in certain ways. Bad actions display the opposite and are informed by vices, such as cowardice, treachery, and ignorance.\n" +
                "\n" +
                "For [Aristotle](https://ethics.org.au/big-thinker-aristotle/), ethics was a key element of human flourishing because it taught people how to differentiate between virtues and vices. By encouraging examination, more people could live a life dedicated to developing virtues.\n" +
                "\n" +
                "But it's one thing to know what's right -- it's another to actually do it. How did Aristotle advise us to live our virtues?\n" +
                "\n" +
                "By acting as though we already have them.\n" +
                "\n" +
                "### Excellence as habit\n" +
                "\n" +
                "Aristotle explained that both virtues and vices are acquired by repetition. If we routinely overindulge a sweet tooth, we develop a vice, -- gluttony. If we repeatedly allow others to serve themselves dinner before us, we develop a virtue -- selflessness.\n" +
                "\n" +
                "Virtue ethics suggests treating our character as a lifelong project, one that has the capacity to truly change who we are. The goal is not to form virtues that mean we act ethically without thinking, but to form virtues that help us see the world clearly and make better judgments as a result.\n" +
                "\n" +
                "> In a pinch, remember: vices distort, virtues examine.\n" +
                "\n" +
                "A quote most of the internet attributes to Aristotle succinctly reads: \"We are what we repeatedly do. Excellence, then, is not an act, but a habit\".\n" +
                "\n" +
                "Though he didn't actually say this, it's a good indication of what virtue ethics stands for. We can thank American philosopher, Will Durant, for the neat summary.\n" +
                "\n" +
                "### Aim for in between\n" +
                "\n" +
                "There are two practical principles that virtue ethics encourages us to use in ethical dilemmas. The first is called The Golden Mean. When we're trying to work out what the virtuous thing to do in a particular situation is, look to what lies in the middle between two extreme forms of behaviour. The mean will be the virtue, and the extremes at either end, vices.\n" +
                "\n" +
                "Here's an example. Imagine your friend is wearing a horrendous outfit and asks you how they look. What are the extreme responses you could take? You could a) burst out laughing or b) tell them they look wonderful when they don't.\n" +
                "\n" +
                "These two extremes are vices -- the first response is malicious, the second is dishonest. The virtuous response is between these two. In this case, that would be gently but honestly telling your friend you think they'd look nicer in another outfit.\n" +
                "\n" +
                "### Imagination\n" +
                "\n" +
                "The second is to use our imagination. What would we do if we were *already *a virtuous person? By imagining the kind of person we'd like to be and how we would want to respond we can start to close the gap between our aspirational identity and who we are at the moment.\n" +
                "\n" +
                "> Virtue ethics can remind us of the importance of role models. If you want someone to learn ethics, show them an ethical person.\n" +
                "\n" +
                "Some argue virtue ethics is overly vague in guiding actions. They say its principles aren't specific enough to help us overcome difficult ethical conundrums. \"Be virtuous\" isn't very practical. Others have expressed concern that virtues or vices aren't agreed on by everybody. Stoicism or sexual openness can be a virtue to some, a vice to others.\n" +
                "\n" +
                "Finally, some people think virtue ethics breeds 'moral narcissism', where we are so obsessed with our own ethical character that we value it above anyone or anything else.");

        theoriesList.add(theoryUtilitarianism);
        theoriesList.add(theoryKantianism);
        theoriesList.add(theoryVirtueEthics);
    }

    private void initCSR() {
        CSR csrLocal = new CSR();
        csrLocal.setContent("Corporate Social Responsibility (CSR)\n" +
                "=====================================\n" +
                "\n" +
                "By \n" +
                "\n" +
                "[JASON FERNANDO](https://www.investopedia.com/contributors/53746/)\n" +
                "\n" +
                "Updated March 07, 2022\n" +
                "\n" +
                "Reviewed by \n" +
                "\n" +
                "[THOMAS BROCK](https://www.investopedia.com/thomas-j-brock-4799774)\n" +
                "\n" +
                "![Thomas Brock](https://www.investopedia.com/thmb/qTWXY9JLAW584FmJtddg0f5Vs48=/90x200/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/HeadshotThomasBrock03.08.20-ThomasBrock-924a228f9b25436183c3d61b0fc6f263.jpeg)\n" +
                "\n" +
                "[](https://www.investopedia.com/thomas-j-brock-4799774)\n" +
                "\n" +
                "[](https://www.investopedia.com/investopedia-financial-review-board-5076269)\n" +
                "\n" +
                "Fact checked by \n" +
                "\n" +
                "[KATRINA MUNICHIELLO](https://www.investopedia.com/katrina-munichiello-5078531)\n" +
                "\n" +
                "What Is Corporate Social Responsibility (CSR)?\n" +
                "----------------------------------------------\n" +
                "\n" +
                "Corporate social responsibility (CSR) is a self-regulating business model that helps a company be socially accountable to itself, its stakeholders, and the public. By practicing corporate social responsibility, also called [corporate citizenship](https://www.investopedia.com/terms/c/corporatecitizenship.asp), companies can be conscious of the kind of impact they are having on all aspects of society, including economic, social, and environmental.\n" +
                "\n" +
                "To engage in CSR means that, in the ordinary course of business, a company is operating in ways that enhance society and the environment instead of contributing negatively to them.\n" +
                "\n" +
                "### KEY TAKEAWAYS\n" +
                "\n" +
                "-   Corporate social responsibility is a business model by which companies make a concerted effort to operate in ways that enhance rather than degrade society and the environment.\n" +
                "-   CSR helps both society and the brand image of companies.\n" +
                "-   Corporate responsibility programs are a great way to raise morale in the workplace.1 \n" +
                "-   Some examples of companies that strive to be leaders in CSR include Starbucks and Ben & Jerry's.2\n" +
                "\n" +
                "0 seconds of 1 minute, 37 secondsVolume 75%\n" +
                "\n" +
                "1:37\n" +
                "\n" +
                "#### Click Play to Learn What CSR Is\n" +
                "\n" +
                "Understanding Corporate Social Responsibility (CSR)\n" +
                "---------------------------------------------------\n" +
                "\n" +
                "Corporate social responsibility is a broad concept that can take many forms depending on the company and industry. Through CSR programs, philanthropy, and volunteer efforts, businesses can benefit society while boosting their brands.\n" +
                "\n" +
                "As important as CSR is for the community, it is equally valuable for a company. CSR activities can help forge a stronger bond between employees and corporations, boost morale, and aid both employees and employers in feeling more connected to the world around them.\n" +
                "\n" +
                "For a company to be socially responsible, it first needs to be accountable to itself and its shareholders. Companies that adopt CSR programs have often grown their business to the point where they can give back to society. Thus, CSR is typically a strategy that's implemented by large corporations. After all, the more visible and successful a corporation is, the more responsibility it has to set standards of ethical behavior for its peers, competition, and industry.\n" +
                "\n" +
                "Small and midsize businesses also create social responsibility programs, although their initiatives are rarely as well-publicized as those of larger corporations.\n" +
                "\n" +
                "Example of Corporate Social Responsibility\n" +
                "------------------------------------------\n" +
                "\n" +
                "[Starbucks](https://www.investopedia.com/articles/markets/101415/biggest-risks-investing-starbucks-stock.asp) has long been known for its keen sense of corporate social responsibility and commitment to sustainability and community welfare. According to the company, Starbucks has achieved many of its CSR milestones since it opened its doors. According to its 2020 Global Social Impact Report, these milestones include reaching 100% of ethically sourced coffee, creating a global network of farmers and providing them with 100 million trees by 2025, pioneering green building throughout its stores, contributing millions of hours of community service, and creating a groundbreaking college program for its employees.3\n" +
                "\n" +
                "Starbucks' goals for 2021 and beyond include hiring 5,000 veterans and 10,000 refugees, reducing the environmental impact of its cups, and engaging its employees in environmental leadership.4\n" +
                "\n" +
                "The 2020 report also mentioned how Starbucks planned to help the world navigate the coronavirus pandemic. The company's response to the pandemic focuses on three essential elements:\n" +
                "\n" +
                "1.  Prioritizing the health of its customers and employees\n" +
                "2.  Supporting health and government officials in their attempts to mitigate the effects of the pandemic\n" +
                "3.  Showing up for communities through responsible and positive actions.\n" +
                "\n" +
                "Today, there are many socially responsible companies whose brands are known for their CSR programs, such as Ben & Jerry's.2\n" +
                "\n" +
                "Special Considerations\n" +
                "----------------------\n" +
                "\n" +
                "In 2010, the [International Organization for Standardization (ISO)](https://www.investopedia.com/terms/i/international-organization-for-standardization-iso.asp) released ISO 26000, a set of voluntary standards meant to help companies implement corporate social responsibility. Unlike other ISO standards, ISO 26000 provides guidance rather than requirements because the nature of CSR is more qualitative than quantitative, and its standards cannot be certified.5\n" +
                "\n" +
                "ISO 26000 clarifies what social responsibility is and helps organizations translate CSR principles into practical actions. The standard is aimed at all types of organizations, regardless of their activity, size, or location. And because many key stakeholders from around the world contributed to developing ISO 26000, this standard represents an international consensus.5\n" +
                "\n" +
                "What Is Corporate Social Responsibility (CSR)?\n" +
                "----------------------------------------------\n" +
                "\n" +
                "The term corporate social responsibility (CSR) refers to practices and policies undertaken by corporations intended to have a positive influence on the world. The key idea behind CSR is for corporations to pursue other pro-social objectives, in addition to maximizing profits. Examples of common CSR objectives include minimizing [environmental externalities](https://www.investopedia.com/terms/e/externality.asp), promoting volunteerism among company employees, and donating to charity.\n" +
                "\n" +
                "Why Should a Company Implement CSR?\n" +
                "-----------------------------------\n" +
                "\n" +
                "Many companies view CSR as an integral part of their brand image, believing that customers will be more likely to do business with brands that they perceive to be more ethical. In this sense, CSR activities can be an important component of corporate public relations. At the same time, some company founders are also motivated to engage in CSR due to their convictions.\n" +
                "\n" +
                "What Is the Impact of CSR?\n" +
                "--------------------------\n" +
                "\n" +
                "The movement toward CSR has had an impact in several domains. For example, many companies have taken steps to improve the environmental sustainability of their operations, through measures such as installing renewable energy sources or purchasing carbon offsets. In managing supply chains, efforts have also been taken to eliminate reliance on unethical labor practices, such as child labor and slavery.\n" +
                "\n" +
                "Although CSR programs have generally been most common among large corporations, small businesses also participate in CSR through smaller-scale programs, such as donating to local charities and sponsoring local events.");
        CSR = csrLocal;
    }

    private void initWhistleBlowing() {
        WhistleBlowing whistleBlowingLocal = new WhistleBlowing();
        whistleBlowingLocal.setContent("Whistleblowing for employees\n" +
                "============================\n" +
                "\n" +
                "[Skip to contents of guide](https://www.gov.uk/whistleblowing#guide-contents)\n" +
                "\n" +
                "Contents\n" +
                "--------\n" +
                "\n" +
                "![image](https://www.ephotozine.com/articles/xxxx-amazing-examples-of-landscape-photography--26838/images/lrg_14833_1411235204.jpg) \n" +
                "1.  What is a whistleblower\n" +
                "2.  [Who to tell and what to expect](https://www.gov.uk/whistleblowing/who-to-tell-what-to-expect)\n" +
                "3.  [If you're treated unfairly after whistleblowing](https://www.gov.uk/whistleblowing/treated-unfairly-after-whistleblowing)\n" +
                "\n" +
                "What is a whistleblower\n" +
                "=======================\n" +
                "\n" +
                "You're a whistleblower if you're a worker and you report certain types of wrongdoing. This will usually be something you've seen at work - though not always.\n" +
                "\n" +
                "The wrongdoing you disclose must be in the public interest. This means it must affect others, for example the general public.\n" +
                "\n" +
                "As a whistleblower you're protected by law - you should not be [treated unfairly or lose your job](https://www.gov.uk/whistleblowing/treated-unfairly-after-whistleblowing) because you 'blow the whistle'.\n" +
                "\n" +
                "You can raise your concern at any time about an incident that happened in the past, is happening now, or you believe will happen in the near future.\n" +
                "\n" +
                "Who is protected by law\n" +
                "-----------------------\n" +
                "\n" +
                "You're protected if [you're a worker](https://www.gov.uk/employment-status/worker), for example you're:\n" +
                "\n" +
                "-   an employee, such as a police officer, NHS employee, office worker, factory worker\n" +
                "-   a trainee, such as a student nurse\n" +
                "-   an agency worker\n" +
                "-   a member of a [Limited Liability Partnership](https://www.gov.uk/business-legal-structures/limited-partnership-and-limited-liability-partnership) (LLP)\n" +
                "\n" +
                "Get independent advice if you're not sure you're protected, for example from [Citizens' Advice.](http://www.adviceguide.org.uk/)\n" +
                "\n" +
                "A confidentiality clause or 'gagging clause' in a settlement agreement is not valid if you're a whistleblower.\n" +
                "\n" +
                "Complaints that count as whistleblowing\n" +
                "---------------------------------------\n" +
                "\n" +
                "You're protected by law if you report any of the following:\n" +
                "\n" +
                "-   a criminal offence, for example fraud\n" +
                "-   someone's health and safety is in danger\n" +
                "-   risk or actual damage to the environment\n" +
                "-   a miscarriage of justice\n" +
                "-   the company is breaking the law, for example does not have the right insurance\n" +
                "-   you believe someone is covering up wrongdoing\n" +
                "\n" +
                "Complaints that do not count as whistleblowing\n" +
                "----------------------------------------------\n" +
                "\n" +
                "Personal grievances (for example bullying, harassment, discrimination) are not covered by whistleblowing law, unless your particular case is in the public interest.\n" +
                "\n" +
                "Report these under your [employer's grievance policy](https://www.gov.uk/solve-workplace-dispute).\n" +
                "\n" +
                "Contact the [Advisory, Conciliation and Arbitration Service (Acas)](https://www.gov.uk/acas) for help and advice on resolving a workplace dispute.");
        whistleBlowing = whistleBlowingLocal;
    }

    private void initDictionary() {
        dictionary.clear();
        DictionaryItem dictionaryItem1 = new DictionaryItem();
        dictionaryItem1.setDefinition("Definition 1");
        dictionaryItem1.setTitle("Term 1");

        DictionaryItem dictionaryItem2 = new DictionaryItem();
        dictionaryItem2.setDefinition("Definition 2");
        dictionaryItem2.setTitle("Term 2");

        dictionary.add(dictionaryItem1);
        dictionary.add(dictionaryItem2);
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));
        dictionary.add(new DictionaryItem("asdasd", "asdada"));

        Collections.sort(dictionary, (s1, s2) -> s1.getTitle().compareToIgnoreCase(s2.getTitle()));
    }
}