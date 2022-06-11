package com.example.myapplication.ui.main.data;

import java.util.ArrayList;
import java.util.Collections;

public class State {

    public static final ArrayList<Theory> theoriesList = new ArrayList<>();
    public static final ArrayList<DictionaryItem> dictionary = new ArrayList<>();
    public static CSR CSR = new CSR();
    public static WhistleBlowing whistleBlowing = new WhistleBlowing();
    public static Discrimination discrimination = new Discrimination();
    public static AffirmativeAction affirmativeAction = new AffirmativeAction();
    public static SexualHarassment sexualHarassment = new SexualHarassment();
    public static Advertising advertising = new Advertising();
    public static Employment employment = new Employment();
    public static ProductSafety productSafety = new ProductSafety();
    public static CorporateGovernance corporateGovernance = new CorporateGovernance();

    public State() {
        initTheories();
        initCSR();
        initDiscrimination();
        initDictionary();
        initWhistleBlowing();
        initAffirmativeAction();
        initSexualHarassment();
        initAdvertising();
        initEmployment();
        initProductSafety();
        initCorporateGovernance();
    }

    private void initDiscrimination() {
        Discrimination discriminationLocal = new Discrimination();
        discriminationLocal.setContent("### Ethical Discrimination in the Workplace\n" +
                "----------------------------------------------\n" +
                "It's never ethical to discriminate in the workplace. In the United States, however, discrimination against people based on their ethnicity, racial or cultural orientation is strictly forbidden under federal and state laws in all sectors, including the employment sector. According to research conducted by the National Conference for Community and Justice, approximately 70 percent of Americans accept that there are racism issues in the workplace. Ethical discrimination may result in the breeding of ill feelings at work, as well as reduced productivity. To eliminate these ramifications, small-business owners need to put forth increased effort in curbing ethical discrimination in the employment sector.\n" +
                "\n" +
                "Discrimination Policies\n" +
                "-----------------------\n" +
                "\n" +
                "1.  Discrimination based on a person's ethnicity, race or culture may manifest itself in a number of ways in the workplace. For example, when the policies for a business discriminate against persons of certain ethnicities or races, or when an individual receives unequal treatment due to his ethnicity, this is known as disparate impact and disparate treatment, respectively. This may include grouping employees based on race and having differing standards on promotions, punishment, and hiring and placement of employees based on ethnicity, race or cultural orientation.\n" +
                "\n" +
                "Employment Discrimination Laws\n" +
                "------------------------------\n" +
                "\n" +
                "1.  Federal and state laws prohibit discrimination in the workplace under Title VII of the Civil Rights Act. The United States Equal Employment Opportunity Commission is in charge of overseeing the enforcement of the rules and regulations governing this act, which specifies that employers should award equal opportunities to all their employees regardless of their race or ethnicity. Additionally, the Civil Service Reform Act supports the Civil Rights Act through a provision that forbids punishment of an individual who reports ethnic discrimination acts.\n" +
                "\n" +
                "Discrimination Reports\n" +
                "----------------------\n" +
                "\n" +
                "1.  An individual who suffers workplace discrimination based on her ethnicity can report these actions through the Equal Employment Opportunity Commission office for proper address. She must file a charge of discrimination stating the nature of the discrimination act, her contacts and her employer's contacts. She may also consult a lawyer to direct her on legal actions.\n" +
                "\n" +
                "Compensation for Discrimination\n" +
                "-------------------------------\n" +
                "\n" +
                "1.  The Equal Employment Opportunity Commission investigates the alleged discrimination issue and decides whether to settle the claim with the parties or present the case in court. Once the commission or the court rules in favor of an employee in a discriminatory case, it determines the compensation to be awarded to the employee. This may be in the form of payment fees, job hiring and placement, reinstatement or a promotion. In cases where the plaintiff suffered emotional distress or monetary expenses such as medical fees for stress-related issues --- e.g., high blood pressure --- the court may award damages. The court may also issue an order to the employer to design an exercise in the workplace to address discrimination practices and prevent retaliation against the employee by individuals who took part in discriminatory actions.");
        discrimination = discriminationLocal;
    }

    private void initAffirmativeAction() {
        AffirmativeAction affirmativeActionLocal = new AffirmativeAction();
        affirmativeActionLocal.setContent("### What Affirmative Action Means for Businesses\n" +
                "----------------------------------------------\n" +
                "\n" +
                "How affirmative action programs operate in the workplace\n" +
                "--------------------------------------------------------\n" +
                "\n" +
                "What Is Affirmative Action?\n" +
                "---------------------------\n" +
                "\n" +
                "Affirmative action refers to policies and programs that are designed to actively promote equal opportunity in the workplace or in education for people regardless of their race, gender, national origin, sexual orientation, and other factors. Affirmative action took hold in the 1960s when it became clear that anti-discrimination laws alone weren't enough to counter past discrimination against groups that have been historically disadvantaged.1\n" +
                "\n" +
                "Businesses implement affirmative action programs to ensure that people from groups that have been historically discriminated against or overlooked have equal opportunity---and are not underrepresented---in their workplaces. Businesses that contract with the federal government are required to have affirmative action programs.\n" +
                "\n" +
                "### KEY TAKEAWAYS\n" +
                "\n" +
                "-   Affirmative action is a policy to promote equal opportunity in the workplace or in education.\n" +
                "-   The rules are intended to level the playing field for groups that have been historically discriminated against or overlooked in the workplace because of race, gender, sexual orientation, disability, and/or other factors.\n" +
                "-   Affirmative action is often considered a means of correcting historical discrimination against these groups.\n" +
                "-   Businesses that contract with the federal government are required to have affirmative action programs, while other employers can implement them voluntarily.\n" +
                "-   Employers must be aware of these laws and similar rules aimed at equal opportunity and fairness.\n" +
                "\n" +
                "History of Affirmative Action\n" +
                "-----------------------------\n" +
                "\n" +
                "The first mention of \"affirmative action\" was in 1961, in President John F. Kennedy's Executive Order 10925 requiring government contractors to \"take affirmative action to ensure that applicants are employed, and that employees are [fairly] treated during employment, without regard to their race, creed, color, or national origin.\"2\n" +
                "\n" +
                "Four years later, President Lyndon Johnson signed the [Civil Rights Act of 1964](https://www.investopedia.com/terms/c/civil-rights-act-1964.asp), which aimed to end discrimination in various spheres of American life. Title VII of the Act specifically addresses equal employment opportunity.3 Johnson then followed this with Executive Order 11246, requiring government employers to take \"affirmative action\" to \"hire without regard to race, religion and national origin,\" and put Cabinet-level authority, under the secretary of labor, behind implementing its affirmative action and non-discrimination provisions.4 The landmark order has been amended and strengthened over the years. Gender was added to the definition in 1967, people with disabilities in subsequent years, and in 2014, sexual orientation and gender identity were included.52\n" +
                "\n" +
                "Companies that don't do business with the government are not required to implement affirmative action programs, although some do voluntarily.\n" +
                "\n" +
                "The Businesses Affirmative Action Affects\n" +
                "-----------------------------------------\n" +
                "\n" +
                "Executive Order 11246, according to the Department of Labor (DOL) website, requires that federal contractors and federally assisted construction contractors who conduct at least $10,000 in government business in a one-year time period take affirmative action to ensure that equal opportunity is provided in all aspects of their employment.6 One-fifth of the U.S. workforce is employed by companies that do business with the federal government, so the order has a broad reach.2 It also applies to subcontractors that supply components to companies with federal contracts, such as manufacturers of engine parts for makers of vehicles purchased by the Department of Defense.6 Financial institutions with deposit accounts for [federal funds](https://www.investopedia.com/terms/f/federalfunds.asp)---or that sell or cash U.S. [savings bonds](https://www.investopedia.com/terms/u/ussavingsbonds.asp)---must also maintain an affirmative action plan.7\n" +
                "\n" +
                "Private companies can also voluntarily adopt affirmative action plans to increase the diversity of their workforces. They just have to make sure their plans comply with Title VII.3 The Supreme Court has developed a three-part test for them:8\n" +
                "\n" +
                "**1\\. ** **The plan must show there has been past discrimination**. Companies don't have to admit they discriminated in the past, but some factual basis for the plan must exist. Statistical data can make the case, say, that there's a \"conspicuous imbalance\" in a traditionally segregated job sector that needs to be corrected.9\n" +
                "\n" +
                "**2\\.  The plan must not \"unnecessarily trammel\" the rights of incumbent workers**. For instance, a company can't lay off a group of White men and replace them all with Black and women workers.\n" +
                "\n" +
                "**3.** **The plan must be temporary**. It should last only as long as it takes to correct past discrimination.\n" +
                "\n" +
                "How Businesses Implement Affirmative Action Plans\n" +
                "-------------------------------------------------\n" +
                "\n" +
                "The premise of affirmative action programs is that, in the absence of discrimination, the employee profile breakdown at a company would accurately reflect the broader labor pools available to it. A written affirmative action plan (AAP) is a management tool that employs various means to analyze and achieve this. A typical AAP for a business, as outlined by the Code of Federal Regulations, would include:10\n" +
                "\n" +
                "-   **Analysis: **a profile of the company that identifies the gender and race/ethnicity of each employee, in the context of an organization chart with job roles and how they relate to one another.\n" +
                "-   **Availability:** calculations of target minorities working at the company in contrast to the population (labor pool) with the right skills for the available positions.\n" +
                "-   **Comparison:** incumbent employees to available candidates as a basis for making tangible recruitment and promotion goals.\n" +
                "-   **Responsibility:** specific managers who will track these goals.\n" +
                "-   **Problem areas: **list them. For instance, underrepresentation of Black, Latinx, or women workers in specific departments or job categories, lack of promotions for these groups to managerial roles, and so on.\n" +
                "-   **Corrective actions**: tangible, action-oriented steps. These often include aggressive educational and outreach efforts aimed at recruiting more employees from underrepresented populations---but also [equal treatment during recruitment interviews](https://www.investopedia.com/financial-edge/0910/8-things-employers-arent-allowed-to-ask-you.aspx), and across compensation, training, advancement, and all other components of the workplace experience.\n" +
                "\n" +
                "-   **Internal auditing and reporting systems**: track progress and measure the effectiveness of the actions the company has taken toward achieving a more diverse workforce.11\n" +
                "\n" +
                "How Affirmative Action Is Enforced\n" +
                "----------------------------------\n" +
                "\n" +
                "Affirmative action plans that are required of federal contractors and subcontractors are enforced by the Office of Federal Contract Compliance Programs (OFCCP) under the DOL umbrella.12\n" +
                "\n" +
                "OFCCP conducts compliance reviews to study the employment practices of government-contracted businesses. A compliance officer may scrutinize a contractor's affirmative action program by looking at personnel rosters, payroll figures, and other records in addition to interviewing staffers and management executives. If problems are discovered, OFCCP will recommend corrective action and suggest ways to achieve the desired equal employment opportunity.13\n" +
                "\n" +
                "The Advantages and Disadvantages of Affirmative Action\n" +
                "------------------------------------------------------\n" +
                "\n" +
                "Discrimination and disparities in opportunity persist as a problem in the American workforce. Over the years there has been controversy over whether affirmative action is the right approach to fixing this. Claims of \"reverse discrimination\" have been litigated up to the Supreme Court.14 The impact of affirmation action policies has been questioned: Do guidelines that require covered employers to meet certain timetables for hiring and promoting minorities and women pressure them to make hiring decisions based on numbers? Are there negative psychological ramifications of affirmative action policies, stigmatizing women and [minority employees](https://www.investopedia.com/) as \"affirmative action\" hires?\n" +
                "\n" +
                "Supporters of affirmative action argue that it is essential to correct past discrimination, and there's work still to be done. The business case for affirmative action has grown over the years, too: From a [profitability](https://www.investopedia.com/terms/p/profit.asp) standpoint, studies show that diversity in the workplace is good for a company's bottom line---especially when it comes to increasing the number of women and racial and ethnic minorities in leadership roles and board positions.151617\n" +
                "\n" +
                "The [groupthink](https://www.investopedia.com/terms/g/groupthink.asp) mentality of old-boy networks doesn't necessarily bring about the freshest ideas to solve difficult business challenges.15 Case in point: A 2019 study shows that when you reach a critical mass of 30% or more women on a board of directors, behaviors begin to change, governance improves, and discussions become richer. And though sometimes it takes outside forces for higher-ups to shed their \"hire-like-me\" habits, when they observe the positive consequence, they tend to embrace change willingly.18\n" +
                "\n" +
                "Finally, although the availability of [government contracts](https://www.investopedia.com/discrimination-in-small-business-contracts-5113819) varies by administration and federal budgetary outlooks, such accounts are potentially lucrative opportunities for the businesses that win them. As a result, businesses that comply with equal opportunity law may be setting the stage for their own company's success.\n" +
                "\n" +
                "The Bottom Line\n" +
                "---------------\n" +
                "\n" +
                "Though affirmative action continues to be a source of controversy for some, such programs are a reality for all government contracted businesses. What's more, many other employers choose to implement affirmative action programs as a helpful way to foster transparency in hiring and promotions and diversity in the workplace.");
        affirmativeAction = affirmativeActionLocal;
    }

    private void initSexualHarassment() {
        SexualHarassment sexualHarassmentLocal = new SexualHarassment();
        sexualHarassmentLocal.setContent("### Sexual Harassment in the Workplace\n" +
                "----------------------------------------------------------------------------------------------------------------\n" +
                "\n" +
                "**Dealing with Sexual Harassment in the Workplace**\n" +
                "\n" +
                "This is the first of a two-part series on workplace issues. Today I deal with sexual harassment in the workplace. In tomorrow's blog I will address what to do about the increasing stress we all feel on the job due to economic conditions and sometimes excessive employer expectations.\n" +
                "\n" +
                "What should you do if you think your boss may be doing something improper? Is it sexual harassment? It's a question I deal with all the time in my ethics class. Sexual harassment is a form of sex discrimination. The legal definition of sexual harassment is \"unwelcome verbal, visual, or physical conduct of a sexual nature that is severe or pervasive and affects working conditions or creates a hostile work environment.\" Two specific legal definitions of sexual harassment have been established in employment law: quid pro quo harassment and hostile environment sexual harassment. \n" +
                "\n" +
                "*Quid Pro Quo Harassment*:  \"Something for something.\" Let's assume your boss threatens to stifle your career advancement unless you sleep with him. This is unlawful whether you submit and avoid the threatened harm or resist and suffer the consequences. Your first step should be to make it clear to your boss this is an unwelcomed advance. At the same time, you should determine the company policy on reporting such matters. If the offensive behavior persists, I recommend you talk to a trusted advisor and/or attorney. It may become a legal issue pending resolution of the matter. In all likelihood your advisor will tell you to go to the Human Resources department where Equal Employment Opportunity Commission (EEOC) matters are dealt with. Be sure to document your concerns -- what did he do or say? When did he do it or say it? What did you say to him? How did he react to your concerns? Give a copy of the document to a trusted advisor or lawyer for possible use in a future legal action. The advisor can attest to the fact you provided the document on a specific day so that it wasn't created after the fact. If the HR department does nothing or your boss doesn't change his behavior, it's time to file a formal sexual harassment complaint with the federal EEOC and/or your state's fair employment agency. You must first file with the EEOC before you file a lawsuit in federal or state court. Generally, you have 180 days to file the complaint. After you file a formal complaint with the EEOC or your state's fair employment agency, you can also consider filing a lawsuit. You can sue for money damages, to get your job back, and you can also ask the court to make your employer change its practices to prevent future sexual harassment from occurring.\n" +
                "\n" +
                "*Hostile Environment Sexual Harassment*: This occurs when an employee is subjected to\\\n" +
                "comments of a sexual nature, offensive sexual materials, or unwelcome physical contact as a regular part of the work environment. [![Sexual harassment](https://ethicssage.typepad.com/.a/6a0133f440106f970b01538de0dbe8970b-320wi \"Sexual harassment\")](http://ethicssage.typepad.com/.a/6a0133f440106f970b01538de0dbe8970b-pi)Let's assume your boss has a habit of sizing you up. He looks up and down your body with a sexually suggestive facial expression. Tell him it's unwanted and unwelcome behavior and that it makes you feel uncomfortable. If he persists in being a jerk, then follow the steps above. Generally speaking, a single isolated incident will not be considered a hostile work environment. The courts look to see whether the conduct is both serious and frequent. Supervisors, managers, co-workers and even customers can be responsible for creating a hostile environment.\n" +
                "\n" +
                "A recent Louis Harris & Associates poll indicates that 62% of sexual harassment targets took no action. Remember, it's ethically improper and outright wrong for someone to use his or her power and authority over you to exact favors or create a hostile work environment. Speak out if this happens to you. Do not show any kind of interest in going along with advances or tolerating repeated offensive gestures, comments, or actions. Once you start to demonstrate by your words or actions (or inactions) that it is acceptable behavior, it becomes much more difficult to take appropriate action to end it in the future.");
        sexualHarassment = sexualHarassmentLocal;
    }

    private void initAdvertising() {
        Advertising advertisingLocal = new Advertising();
        advertisingLocal.setContent("### Advertising Ethics: What They Are and How They Apply\n" +
                "----------------------------------------------\n" +
                "\n" +
                "Ethics guide people in all professions across all industries, serving as the moral principles for how someone behaves or conducts certain activities. Understanding the role of ethics in advertising can help you better understand what general rules may apply in this area of business. Certain standards for ethical advertisement apply to those working in the marketing and advertising field, and the violation of those standards can lead to legal repercussions. In this article, we will discuss advertising ethics and the role they play in creating ads that appeal to consumers.\n" +
                "\n" +
                "[Find the best companies to work for on Indeed](https://www.indeed.com/companies?from=careerguidepromo-US)\n" +
                "\n" +
                "Get access to millions of company ratings and reviews\n" +
                "\n" +
                "What are advertising ethics?\n" +
                "----------------------------\n" +
                "\n" +
                "Advertising ethics are the moral principles that govern how a business communicates with members of its target audience. Advertising has a set of defined principles that outline the type of communication that can take place between a potential buyer and a seller of goods or services. An example of ethical advertising is an ad that presents true statements in a decent manner, although the definition of decency may vary between individuals.\n" +
                "\n" +
                "The purpose of advertising is to increase sales and generate more brand awareness. Good advertising can appeal to a wide audience and generate more demand for a product or service. Companies may claim that what they sell is better than what competitors sell, but ethics come into play when a business cannot back up their claims or use unacceptable methods to generate brand awareness.\n" +
                "\n" +
                "Applying ethics in advertising can pose a challenge because the ethical beliefs that people hold vary, based on their background and moral beliefs. For example, one consumer might feel tricked by an advertisement that shows someone snapping their fingers and having a home full of new furniture appear, while another consumer would understand that this advertisement is not attempting to show reality. Certain regulations do apply to advertisers, who must exercise caution when creating ads to avoid facing legal issues or consumer backlash.\n" +
                "\n" +
                "Related: [Developing Personal Ethics: Examples and Tips](https://www.indeed.com/career-advice/career-development/developing-personal-ethics)\n" +
                "\n" +
                "Ethical standards for advertising\n" +
                "---------------------------------\n" +
                "\n" +
                "Some of the key ethical standards for advertising apply to all brands and industries, requiring those involved in the creation and rollout of ads to carefully review what they produce and avoid violations. The following eight standards were established by the Institute for Advertising Ethics (IAE) and administered by the American Advertising Federation in partnership with two key journalism institutions located in the U.S.\n" +
                "\n" +
                "Related: [Complete Guide for Advertising Agents](https://www.indeed.com/career-advice/finding-a-job/advertising-agents)\n" +
                "\n" +
                "### Share a common objective of truth\n" +
                "\n" +
                "One ethical standard for advertising is that all involved in the creation of an ad, including those in the advertising, public relations, communications, editorial and news departments should share a common objective of truth. Consumers value ethical and honest advertising, so maintaining an objective to share the truth can help advertisers better appeal to a wide audience while maintaining their ethics.\n" +
                "\n" +
                "### Obligation to high personal ethics in creating and sharing commercial information\n" +
                "\n" +
                "When creating and sharing information, advertisers have an obligation to exercise the highest personal ethics. The mission of the IAE is to provide education to professionals in the advertisement industry to produce true and ethical advertisements while demonstrating a high level of professionalism.\n" +
                "\n" +
                "Related: [Social Responsibility: Definition and Examples](https://www.indeed.com/career-advice/career-development/social-responsibility)\n" +
                "\n" +
                "### Clearly disclose all material conditions and endorsement identities\n" +
                "\n" +
                "An advertisement may offer something for free in exchange for an action taken by the consumer, but this type of advertisement should clearly disclose the conditions of such an exchange to maintain a high ethical standard. Any endorsers should also be clearly identified in advertisements in the interest of transparency and full disclosure. Social media has added a new layer of complexity to advertising in the form of influencers, or people who share their opinions about products and services in exchange for compensation and/or free products and services.\n" +
                "\n" +
                "When using influencers or endorsers or offering something for free, advertisers must maintain transparency about the conditions of this deal and whether the people presented in the ad receive any compensation for their participation. Presenting this information clearly allows a consumer to make an informed decision about moving forward with the brand.\n" +
                "\n" +
                "### Distinguish between advertising and news or editorial content\n" +
                "\n" +
                "One area in which consumers have been treated unethically more frequently is the differentiation between advertising and editorial content or news. A press release should be presented differently than an advertisement, but companies have started to mislead consumers by presenting advertising content as editorial content to create confusion.\n" +
                "\n" +
                "### Transparent usage of personal information\n" +
                "\n" +
                "Advertisers have an obligation to consumers to provide transparency around the usage of their personal information, as well as provide details on how any information they provide will be used. As marketers use enhanced methods to target online behaviors and actions, consumers continue to worry about their privacy and how companies will use their information. Government regulations have shifted the way marketers obtain and use private information, affording more control to consumers over what they have to share with businesses.\n" +
                "\n" +
                "### Fair treatment of consumers\n" +
                "\n" +
                "An advertiser must treat all consumers fairly, although stricter rules apply to the audience to whom ads are directed and the nature of the services or products being represented. For example, products geared toward children may have stricter advertising regulations in place because they are more vulnerable and prone to being misled. The same rules may apply to the elderly. Prescription drugs and alcohol also have unique regulations applied to their advertising because of the potentially sensitive nature of these products.\n" +
                "\n" +
                "### Permission to discuss ethical concerns\n" +
                "\n" +
                "Those working in advertising should have permission to bring up any potential ethical concerns when developing and rolling out ad campaigns. Practicing and applying the highest ethical standards requires those involved in the development of advertising campaigns to take the time to analyze the key standards for ethics in advertising and ensure that what they share with consumers adheres to those standards. When making considerations, ethical advertisers should always think about what is best for the consumer and allow that mindset to drive their actions.\n" +
                "\n" +
                "### Follow all legal regulations\n" +
                "\n" +
                "All advertisers must follow the legal regulations that apply to the industry, including any local, state and federal laws. Various self-regulatory bodies and programs exist to address and resolve issues in advertising, including the Better Business Bureau and the Federal Trade Commission. Many advertisers rely on these programs to guide their actions and better understand the importance of ethics in advertising. The National Advertising Review Council is a regulatory body established within the advertising industry that reviews ads geared toward all age groups and target audiences.");
        advertising = advertisingLocal;
    }

    private void initEmployment() {
        Employment employmentLocal = new Employment();
        employmentLocal.setContent("### Professional Ethics - Rights of an Employee\n" +
                "----------------------------------------------\n" +
                "\n" +
                "Employees are an asset to the company and any ethical organization would like its employees to be happy and prosperous by providing them a safe and happy working environment, steady work, reasonable modifications to work time, and a healthy work-life balance.\n" +
                "\n" +
                "Many companies that top the chart when it comes to providing ideal environments to its employees credit their good employee management and retention programs as the key to their success.\n" +
                "\n" +
                "An employee is, at the very least, entitled to the following rights at his workplace -\n" +
                "\n" +
                "-   No discrimination at work, especially on the basis of gender, nationality, religion, medical condition, and political affiliation.\n" +
                "\n" +
                "-   Healthy work-life balance, which means no long hours at work. Employees can also report if their employer makes unnecessary delays in delegating work.\n" +
                "\n" +
                "-   Protection of job for people with disabilities and medical conditions.\n" +
                "\n" +
                "-   Complete protection against sexual harassment of any kind and immunity from being forced to exchange favors for benefits.\n" +
                "\n" +
                "-   Freedom to discuss the terms and conditions of the employment with other employees and negotiating wages to suit lifestyle as per changing times.\n" +
                "\n" +
                "-   Right to ask for safe working conditions and reservation to answering questions on age, religion, nationality, and medical condition.\n" +
                "\n" +
                "-   Demanding certain changes and modifications regarding the working conditions to accommodate situations that might crop up due to their prevailing medical conditions.\n" +
                "\n" +
                "-   Right to form or participate a union that aims to improve the wages, lifestyle, working environment, and emphasizes on employee rights at the workplaces.");
        employment = employmentLocal;
    }

    private void initProductSafety() {
        ProductSafety productSafetyLocal = new ProductSafety();
        productSafetyLocal.setContent("### Examples of Product Safety in the Real World\n" +
                "----------------------------------------------\n" +
                "\n" +
                "As a consumer, you might not be aware of all the research, features, and guidelines that go into the products you use every day. Product safety is specifically designed to keep you, the consumer, safe when using a product. Retailers and producers of consumer goods are responsible for ensuring safety for their products and preventing harm or accident from befalling their customers as a result of their products.\n" +
                "\n" +
                "Today we will be talking about some of the most common product safety precautions to take when dealing with consumer-driven products.\n" +
                "\n" +
                "### Safety Standards and Regulations\n" +
                "\n" +
                "As a regular person, you probably won't be able to evaluate safety on your own. Instead, you rely on these companies to do product research and create safety standards and regulations on your behalf. When a company is creating, designing, or manufacturing a product, they seek a wide range of safety certifications in order to create products that are safe to use for consumers. Often, these standards will depend on the individual product. For example, car seats for children require their own standards for safety and testing, whereas food items will have different standards specific to them.\n" +
                "\n" +
                "### Preventing Human Error\n" +
                "\n" +
                "A lot of products are designed and manufactured to stop or prevent human error. A good example of this would be a safety belt that is created so that it's impossible to put it on wrong.\n" +
                "\n" +
                "### Childproof Products\n" +
                "\n" +
                "When we talk about human error, it's important to remember that an extra layer of protection must often be added for children, who can easily come to harm through seemingly innocuous products. Childproofing will have two important aspects:\n" +
                "\n" +
                "1.  Creating, designing and manufacturing products that are safe for children or do not contain loose or small parts that can create a choking hazard.\n" +
                "2.  If a product does have loose or small parts, a warning should be placed on said product.\n" +
                "\n" +
                "### Safety Features\n" +
                "\n" +
                "Most products that deal with hazards, such as electricity, will include safety features so that injury or death can be prevented. The product should also contain warnings on the label. A good example of this would be outdoor versus indoor lights. Outdoor lights have a heavy duty wire coating and a seal on the bulb socket to prevent disasters that might result from exposure to the elements.\n" +
                "\n" +
                "### Error Tolerance\n" +
                "\n" +
                "This type of product safety deals with a product or item that will continue to work even when an error happens. An example of this is a vehicle that is overheated. The car will display a warning sign and might restrict the speed so that the driver can get to a safer spot and get out of the vehicle.\n" +
                "\n" +
                "### Product Information\n" +
                "\n" +
                "These days most all products will have clear instructions, warnings, and labeling. The product might also have several different languages on the labeling so that anyone who uses it, no matter their language, will be able to comprehend the instructions and warnings on the product packaging.\n" +
                "\n" +
                "While most products contain these guidelines and labels, there are some products that do not. Even worse, there are recalls every single day for products that were manufactured and had defects that are injuring people.");
        productSafety = productSafetyLocal;
    }

    private void initCorporateGovernance() {
        CorporateGovernance corporateGovernanceLocal = new CorporateGovernance();
        corporateGovernanceLocal.setContent("### Corporate Governance\n" +
                "----------------------------------------------\n" +
                "\n" +
                "What Is Corporate Governance?\n" +
                "\n" +
                "Corporate governance is the [system of rules, practices, and processes](https://www.investopedia.com/terms/m/mckinsey-7s-model.asp) by which a firm is directed and controlled. Corporate governance essentially involves balancing the interests of a company's many [stakeholders](https://www.investopedia.com/terms/s/stakeholder.asp), such as shareholders, senior management executives, customers, suppliers, financiers, the government, and the community.\n" +
                "\n" +
                "Since corporate governance also provides the framework for attaining a company's objectives, it encompasses practically every sphere of management, from action plans and [internal controls](https://www.investopedia.com/terms/i/internalcontrols.asp) to performance measurement and corporate [disclosure](https://www.investopedia.com/terms/d/disclosure.asp).\n" +
                "\n" +
                "### KEY TAKEAWAYS\n" +
                "\n" +
                "-   Corporate governance is the structure of rules, practices, and processes used to direct and manage a company.\n" +
                "-   A company's board of directors is the primary force influencing corporate governance.\n" +
                "-   Bad corporate governance can cast doubt on a company's operations and its ultimate profitability.\n" +
                "-   Corporate governance entails the areas of environmental awareness, ethical behavior, corporate strategy, compensation, and risk management.\n" +
                "-   The basic principles of corporate governance are accountability, transparency, fairness, and responsibility.\n" +
                "\n" +
                "Understanding Corporate Governance\n" +
                "----------------------------------\n" +
                "\n" +
                "Governance refers specifically to the set of rules, controls, policies, and resolutions put in place to dictate corporate behavior. Proxy advisors and [shareholders](https://www.investopedia.com/terms/s/shareholder.asp) are important stakeholders who indirectly affect governance, but these are not examples of governance itself. The board of directors is pivotal in governance, and it can have major ramifications for equity valuation.\n" +
                "\n" +
                "A company's corporate governance is important to investors since it shows a company's direction and business integrity. Good corporate governance helps companies build trust with investors and the community. As a result, corporate governance helps promote financial viability by creating a long-term investment opportunity for market participants.\n" +
                "\n" +
                "Communicating a firm's corporate governance is a key component of community and [investor relations](https://www.investopedia.com/terms/i/investorrelations.asp). On Apple Inc.'s investor relations site, for example, the firm outlines its corporate leadership---its executive team, its board of directors---and its corporate governance, including its committee charters and governance documents, such as bylaws, stock ownership guidelines, and [articles of incorporation](https://www.investopedia.com/terms/a/articlesofincorporation.asp).1\uFEFF\n" +
                "\n" +
                "Most companies strive to have a high level of corporate governance. For many shareholders, it is not enough for a company to merely be profitable; it also needs to demonstrate good [corporate citizenship](https://www.investopedia.com/terms/c/corporatecitizenship.asp) through environmental awareness, ethical behavior, and [sound corporate governance practices](https://www.investopedia.com/terms/b/best_practices.asp). Good corporate governance creates a transparent set of rules and controls in which shareholders, directors, and officers have aligned incentives.\n" +
                "\n" +
                "Corporate Governance and the Board of Directors\n" +
                "-----------------------------------------------\n" +
                "\n" +
                "The [board of directors](https://www.investopedia.com/terms/b/boardofdirectors.asp) is the primary direct stakeholder influencing corporate governance. Directors are elected by shareholders or appointed by other board members, and they represent shareholders of the company.\n" +
                "\n" +
                "The board is tasked with making important decisions, such as corporate officer appointments, executive compensation, and dividend policy. In some instances, board obligations stretch beyond financial optimization, as when shareholder resolutions call for certain social or environmental concerns to be prioritized.\n" +
                "\n" +
                "A board of directors should consist of a diverse group of individuals, those that have skills and knowledge of the business, as well as those who can bring a fresh perspective from outside of the company and industry.\n" +
                "\n" +
                "Boards are often made up of inside and independent members. Insiders are major shareholders, founders, and executives. Independent directors do not share the ties of the insiders, but they are chosen because of their experience managing or directing other large companies. Independents are considered helpful for governance because they dilute the concentration of power and help align shareholder interests with those of the insiders.\n" +
                "\n" +
                "The board of directors must ensure that the company's corporate governance policies incorporate the corporate strategy, risk management, accountability, transparency, and ethical business practices.\n" +
                "\n" +
                "Examples of Corporate Governance\n" +
                "--------------------------------\n" +
                "\n" +
                "### Volkswagen AG\n" +
                "\n" +
                "Bad corporate governance can cast doubt on a company's reliability, integrity, or obligation to shareholders; all of which can have implications on the firm's financial health. Tolerance or support of illegal activities can create scandals like the one that rocked Volkswagen AG starting in September 2015.\n" +
                "\n" +
                "The development of the details of \"Dieselgate\" (as the affair came to be known) revealed that for years the automaker had deliberately and systematically rigged engine emission equipment in its cars in order to manipulate pollution test results in America and Europe. Volkswagen saw its stock shed nearly half its value in the days following the start of the scandal, and its global sales in the first full month following the news fell 4.5%.2\n" +
                "\n" +
                "VW's board structure was a reason for how the emissions rigging took place and was not caught earlier. In contrast to a one-tier board system that is common in most companies, VW has a two-tier board system, which consists of a management board and a supervisory board. The supervisory board was meant to monitor management and approve corporate decisions; however, it lacked the independence and authority to be able to carry out these roles.3\n" +
                "\n" +
                "The supervisory board comprised a large portion of shareholders. Ninety percent of shareholder voting rights were controlled by members of the supervisory board. There was no real independent supervisor; shareholders were in control of the supervisory board, which canceled out the purpose of the supervisory board, which was to oversee management and employees and how they operate within the company, which of course, included rigging emissions.3\n" +
                "\n" +
                "### Enron and Worldcom\n" +
                "\n" +
                "Public and government concern about corporate governance tends to wax and wane. Often, however, highly publicized revelations of corporate malfeasance revive interest in the subject. For example, corporate governance became a pressing issue in the United States at the turn of the 21st century, after fraudulent practices bankrupted high-profile companies such as [Enron](https://www.investopedia.com/terms/e/enron.asp) and [WorldCom](https://www.investopedia.com/terms/w/worldcom.asp).\n" +
                "\n" +
                "The problem with Enron was that its board of directors waived many rules related to conflicts of interest by allowing the chief financial officer (CFO), Andrew Fastow, to create independent, private partnerships to do business with Enron. What actually happened was that these private partnerships were used to hide Enron's debts and liabilities, which would have reduced the company's profits significantly.4\n" +
                "\n" +
                "What happened at Enron was clearly a lack of corporate governance that should have prevented the creation of these entities that hid the losses. The company also had a corporate atmosphere that had dishonest people at the top (Fastow) down to its traders who made illegal moves in the markets.\n" +
                "\n" +
                "Both the Enron and Worldcom scandals resulted in the 2002 passage of the [Sarbanes-Oxley Act](https://www.investopedia.com/terms/s/sarbanesoxleyact.asp), which imposed more stringent recordkeeping requirements on companies, along with stiff criminal penalties for violating them and other securities laws. The aim was to restore public confidence in public companies and how they operate.\n" +
                "\n" +
                "### PepsiCo\n" +
                "\n" +
                "It's common to hear of bad corporate governance examples, mainly because it is the reason some companies blow up and end up in the news. It's rare to hear of companies with good corporate governance because it is the good corporate governance that keeps them out of the news as no scandal has occurred.\n" +
                "\n" +
                "One company that has consistently practiced good corporate governance and seeks to update it often is PepsiCo. In drafting its 2020 proxy statement, PepsiCo took input from investors to focus on six areas:\n" +
                "\n" +
                "-   Board composition, diversity, and refreshment, and leadership structure\n" +
                "-   Long-term strategy, corporate purpose, and [sustainability](https://www.investopedia.com/terms/s/sustainability.asp) issues\n" +
                "-   Good governance practices and ethical corporate culture\n" +
                "-   Human capital management\n" +
                "-   Compensation discussion and analysis\n" +
                "-   Shareholder and stakeholder engagement5\n" +
                "\n" +
                "The company included in its proxy statement a side-by-side graphic that depicted the current leadership structure, which shows a combined chair and CEO along with an independent presiding director, and a link between the compensation of the company's \"Winning With Purpose\" vision and changes to the executive compensation program.5\n" +
                "\n" +
                "Special Considerations\n" +
                "----------------------\n" +
                "\n" +
                "As an investor, you want to ensure that the company you are looking to buy shares of practices good corporate governance, in the hope of avoiding losses in cases such as Enron and Worldcom. There are certain areas that an investor can focus on to determine whether a company is practicing good corporate governance or not.\n" +
                "\n" +
                "These areas include disclosure practices, executive compensation structure (is it tied only to performance or other metrics?), risk management (what are the checks and balances of making decisions in the company?), policies and procedures on reconciling conflicts of interest (how does a company approach business decisions that might conflict with its mission statement?), the members of the board of the directors (do they have a stake in profits?), contractual and social obligations (how do they approach areas such as climate change?), relationships with [vendors](https://www.investopedia.com/terms/v/vendor.asp), complaints received from shareholders and how they were addressed, and audits (how often are internal and external audits conducted and how have issues been handled?).\n" +
                "\n" +
                "Types of bad governance practices include:\n" +
                "\n" +
                "-   Companies that do not cooperate sufficiently with auditors or do not select auditors with the appropriate scale, resulting in the publication of spurious or noncompliant financial documents\n" +
                "-   Bad executive compensation packages that fail to create an optimal incentive for corporate officers\n" +
                "-   Poorly structured boards that make it too difficult for shareholders to oust ineffective incumbents\n" +
                "\n" +
                "These are all areas an investor can research before making an investment decision.\n" +
                "\n" +
                "Corporate Governance FAQs\n" +
                "-------------------------\n" +
                "\n" +
                "### What Are the 4 Ps of Corporate Governance?\n" +
                "\n" +
                "The four P's of corporate governance are people, process, performance, and purpose.\n" +
                "\n" +
                "### Why Is Corporate Governance Important?\n" +
                "\n" +
                "Corporate governance is important because it creates a system of rules and practices that determine how a company operates and how it aligns the interest of all its stakeholders. Good corporate governance leads to ethical business practices, which leads to financial viability.\n" +
                "\n" +
                "### What Are the Basic Principles of Corporate Governance?\n" +
                "\n" +
                "The basic principles of corporate governance are accountability, transparency, fairness, and responsibility.\n" +
                "\n" +
                "### What Are Examples of Corporate Governance?\n" +
                "\n" +
                "Examples of corporate governance include the Anglo-US model, the German model, and the Japanese model.\n" +
                "\n" +
                "The Bottom Line\n" +
                "---------------\n" +
                "\n" +
                "Corporate governance consists of the guiding principles that a company puts in place to direct all of its operations, from compensation to risk management to employee treatment to reporting unfair practices to its impact on the climate, and more.\n" +
                "\n" +
                "A strong, transparent corporate governance leads a company to make ethical decisions that benefit all of its stakeholders, allowing the company to place itself as an attractive option to investors if its financials are also healthy. Bad corporate governance leads to a breakdown of a company, often resulting in scandals and bankruptcy.");
        corporateGovernance = corporateGovernanceLocal;
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
        csrLocal.setContent("### What Is Corporate Social Responsibility (CSR)?\n" +
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
        whistleBlowingLocal.setContent("### Whistleblowing for employees\n" +
                "----------------------------------------------\n" +
                "\n" +
                "What is a whistleblower\n" +
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