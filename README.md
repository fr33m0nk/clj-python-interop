## Demo of inter-op with Python package from Clojure (JVM)
  - The interop is done using the [libpython-clj](https://github.com/clj-python/libpython-clj)_library
  - This demo uses excellent scraping package for Python [`Trafilatura`]() 

## Steps
- Install Trafilatura package on machine
  - `pip install trafilatura`
  - [instructions](https://trafilatura.readthedocs.io/en/latest/installation.html)

- Fire up Clojure REPL

- Import necessary dependencies
```clojure
(require
    '[libpython-clj2.python :as py :refer [py. py.. py.-]]
    '[libpython-clj2.require :refer [require-python]])

(require-python '[trafilatura :as tf])
```

- See Trafilatura an action
```clojure

(-> (tf/fetch_url "https://github.blog/2019-03-29-leader-spotlight-erin-spiceland/")
    (tf/extract))

;; Output
;;=>
"Game Bytes · February 2024
 Game Bytes is our monthly series taking a peek at the world of gamedev on GitHub—featuring game engine updates, game jam details, open source games, mods, maps, and more. Game on! 🕹️
 We’re spending Women’s History Month with women leaders who are making history every day in the tech community. Read more about Erin Spiceland: Software Engineer at SpaceX.
 Every March we recognize the women who have shaped history—and now, we’re taking a look forward. From driving software development in large companies to maintaining thriving open source communities, we’re spending Women’s History Month with women leaders who are making history every day in the tech community. Erin Spiceland is a Software Engineer for SpaceX. Born and raised in rural south Georgia, she is a Choctaw and Chickasaw mother of two now living in downtown Los Angeles. Erin didn’t finish college—she’s a predominantly self-taught software engineer. In her spare time, she makes handmade Native American beadwork and regalia and attends powwows.
 My career has been a winding road through periods of stimulation and health as well as periods of personal misery. During it all, I’ve learned a variety of programming languages and technologies while working on a diverse array of products and services. I’m a domestic abuse survivor and a Choctaw bisexual polyamorous woman. I’m so proud of myself that I made it this far considering where I came from.
 In 2007, I had a three-year-old daughter and I was trying to finish my computer science degree one class at a time, all while keeping my house and family running smoothly. I found the math classes exciting and quickly finished my math minor, leaving only computer science classes. I was looking at about five years before I would graduate. Then, my husband at the time recommended me for an entry software developer position at a telecom and digital communications company.
 When faced with the choice between an expensive computer science degree and getting paid to do what I loved, I dropped out of college and accepted the job. I was hired to work on internal tooling, and eventually, products. I did a lot of development on product front-ends, embedded network devices, and a distributed platform-as-a-service. I learned Java/JSP, Python, JavaScript/CSS, Node.js, as well as MySQL, PostgreSQL, and distributed systems architecture. It was an intense experience that required a lot of self-teaching, asking others for help, and daycare, but it set me up for my later successes.
 I appreciate and admire technical, effective leaders who care for their reports as humans, not as lines on a burndown chart, and forego heavy-handed direction in favor of communication and mutual dialogue. I think it’s as important for a leader to concern herself with her coworkers’ personal well-being as it is for her to direct their performance.
 Last year I took a pay cut to move from a safe, easy job where I had security to work in a language I hadn’t seen in years and with systems more complicated than anything I’d worked with before. I moved from a place where I had a huge four bedroom house to a studio apartment that was twice the price. I moved away from my children, of who I share custody with my ex-husband. We fly across the U.S. to see each other now. I miss my children every day. However, I get to be a wonderful role model for them.
 I can’t wait to wake up every day with my partner who loves me so much. I’m looking forward to showing my children exactly how far they can go. I’m excited to keep exploring Los Angeles.
 Want to know more about Erin Spiceland? Follow them on GitHub or Twitter.
 Want to learn more about featured leaders for Women’s History Month? Read about:
 Check back in soon—we’ll be adding new interviews weekly throughout March."
```

- or thru the `XML` feed file
```clojure

(require-python '[trafilatura.feeds :as feeds])

(->> (feeds/find_feed_urls "https://www.prlog.org/news/de/rss.xml")
       (py/->jvm)
       (into []
             (map (fn [url]
                    (-> (tf/fetch_url url)
                        (tf/extract))))))



;; Output
;;=>
["Follow on Google News
  News By Tag
  Industry News
  News By Place
  Country(s)
  Industry News
  Follow on Google News
  PARTEX welcomes Assay.Works to its Digital Pharma Platform
  By: Partex NV
  Assay.Works was founded in 2016 inheriting the legacy of a major Biopharma's High-Throughput Screening (HTS) Center located in the BioPark Regensburg, Germany. The scientific team has more than 25 years of distinguished Pharma experience and expertise across a range of discovery disciplines including assay development, HTS, hit identification and validation, and compound management. Assay.Works operates with its own library of 150k lead-like, diverse small molecules as well as with compound collections provided by clients and partners. A broad range of biochemical, cell-based and phenotypic high-content assay technologies combined with state-of-the-
  PARTEX offers a unique proposition serving the entire Pharma and Biotech value chain through a holistic approach based on three strategic building blocks: Data (including real-world data), Decision Making (Artificial Intelligence together with validation) and Drug Assets.
  Dr. Ralf Schwandner, Assay.Works co-founder and CEO stated: \"We are excited to continue building upon what we have created at Assay.Works. PARTEX's mission perfectly fits our ambition to accelerate the research programs of our trusted customers and partners in Pharma and Biotech with best-in-class, science-driven services. Partnering with PARTEX will take us a significant step forward in achieving this vision.\"
  \"Joining forces with PARTEX presents a great opportunity to sustain and grow our potential.
  Leveraging synergies will help us focus on what we do best: Delivering quality experimental data facilitating knowledge-driven decision-making for Drug Discovery programs\" added Dr. Johannes Knop, co-founder and COO of Assay.Works.
  Dr. Gunjan Bhardwaj, PARTEX Founder and CEO commented: \"We are delighted to welcome Assay.Works' exceptional team of Drug Discovery experts to the PARTEX family. The addition of state-of-art experimental capabilities enables us to validate in-silico predictions and hypotheses and therefore represents an important evolutionary step towards our vision: create a new paradigm for humanity's health and longevity\"
  Contacts:
  Assay.Works
  T. +49 941 2000 1240
  E. contact@assay.works
  Assay.Works GmbH
  Am Biopark 11
  93053 Regensburg, Germany
  Partex
  T. +49 175 2273168
  E. tatiane.rsantana@
  Partex N.V.
  Frankfurter Straße 27
  65760 Eschborn
  About Assay.Works
  Assay.Works is a contract research organization (CRO) providing research services to
  pharmaceutical/
  Their mission is to accelerate their partner's research programs by developing and executing predictive and scalable assays to quantify the bioactivity of novel chemical and biological entities.
  They combine scientific rigor with their multi-decade domain expertise in laboratory automation, informatics, and industry best practices to turn challenging assays into quantitative, reproducible results.
  Assay.Works' service portfolio includes the development and optimization of biochemical and advanced cellular assays, High-Throughput and High-Content Screening (HTS/HCS) and bioactivity assessments.
  For more information, see: www.assay.works
  About Partex
  Partex is the first Digital Pharma: a Life Sciences platform that serves the entire biopharma value chain, driving the development of drugs and therapies through all inflection points.
  Partex's AI-powered platform will enable treatments of uncurable diseases and will alleviate information asymmetry between patients and physicians as well as amongst investors, regulators and Biotechs/Pharma. Partex has built the world's largest data ocean with public and proprietary data, including a real-world data ecosystem that provides patients free of charge essential, disease-relevant information as well as tailored services and fair rewards for licensing personal data.
  Their Artificial Intelligence (AI) algorithm with a state-of-the-
  Partex's vision is further enhanced by strategic acquisitions of companies that synergize their current capabilities while adding a unique edge to the Partex platform.
  For more information, see: www.partex.io
  Contact
  Tatiane Ribeiro de Santana
  tatiane.rsantana@
  End
  Account Email Address Account Phone Number Disclaimer Report Abuse"
 "Follow on Google News
  News By Tag
  Industry News
  News By Place
  Country(s)
  Industry News
  Follow on Google News
  \"Comedy never travels…\" \"What about German Comedy?\"
  German Globetrotter: 'Faraway' is Netflix's #2 Film Worldwide
  That said, there is a vibrant and unique comedic landscape in Germany which deserves to be celebrated. No joke. Last year saw Germany make an impactful entry into the 94th Academy Awards with the comedy, Ich bin dein Mensch (I'm Your Man). And then there was 2016's Toni Erdmann being met with widespread critical acclaim for its wit and social commentary (which Jack Nicholson once circled to star in its remake).
  For many, watching characters navigate places of paradise means living vicariously through them – experiencing escapism without departing the sofa. Maybe that's it – after years in a pandemic, ongoing geopolitical and natural earthquakes — audiences just want to feel good. And escape. If you allow yourself to be whisked away to Croatia and forget about the world's problems – could that work? \"Without a shadow of a doubt, the reason that people tune into rom-coms more during periods of crisis and stress is because of the distraction that these genres offer,\" Emma Kenny, a UK-based TV psychologist, says.
  Eat, Pray, Love is the Rom-Com travel classic – chronicling Julia Roberts as Liz Gilbert as she embarks on a journey to find balance in her life following a difficult divorce. Robert's more recent release, Ticket to Paradise, is also a romanticised ode to travel, grossing more than $172.1MM – making it the biggest Rom-Com to feature two over-50 leads since 2009's It's Complicated. Which begs the question whether an escapist experience as Faraway would have been better served in a cinema setting?
  We're now also in a world where older actresses are becoming unafraid of exploring their onscreen sexuality – exemplified by Emma Thompson in Good Luck to you, Leo Grande, and Kate Winslet in Mare of Easttown (who took a stand to ensure her 'visible belly' during a sex scene was not edited out). Now we find Faraway's Zeynap (Naomi Krauss) fearlessly embracing her age, which, in a very honest portrayal, might also serve as an ingredient in a sexy-secret-
  A wager fulfilled by Netflix dubbing Faraway for global audiences, Rom-Coms never fail to engage audiences – despite their language. And when combined with the romantic lure of travel, they become even more captivating. Love is, after all, a universal language, and there is just something spellbinding about a romance that unfolds in a destination faraway.
  Who knows, maybe we'll be seeing a remake with Roberts in the future.
  End
  Account Email Address Account Phone Number Disclaimer Report Abuse"
 "Axiros, a global leader in Device Management solutions, is pleased to announce that Alfanet, a prominent internet service provider in Ecuador has chosen Axiros' AXESS 5 ACS Software to elevate its network management capabilities and deliver an...
  Inventor says pairing overlapping bistable domes and artificial intelligence enables unique paper thin shape sensors, soft robots, and using thinner stronger metals to reduce vehicle weight and climate change.
  The provocative theory presented in the book \"Sex On the Wrong Brain\" as well as website and screenplay of the same name suggests that recent worldwide spikes in sexism, racism, and authoritarianism blamed on COVID shutdowns and isolation were fueled by..
  Pupex, a leading name in the pet care industry, is thrilled to announce the launch of its latest line of innovative products aimed at enhancing the health and well-being of our beloved furry companions.
  Axiros, a global leader in Device Management solutions, is pleased to announce that Alfanet, a prominent internet service provider in Ecuador has chosen Axiros' AXESS 5 ACS Software to elevate its network management capabilities and deliver an...
  Abusix, the leading provider of spam filtering services and network abuse management, is pleased to announce the successful completion of its System and Organization Controls (SOC) 2 Type II audit, achieving compliance with the leading industry standards.
  MDT Agrarservice GmbH, a pioneering force in the European agricultural machinery industry, is proud to announce its continued commitment to providing cutting-edge solutions for farmers across the continent.
  This metric, not found in any other field service solution, aims to provide new operational standards across the field service industry, offering precision in route planning which in turn significantly increases productivity.
  simpleshow continues to redefine simplicity when it comes to video creation with the integration of the Simplifier feature. Users can now upload and convert content into easy-to-understand explainer videos with just a few clicks.
  Inventor says pairing overlapping bistable domes and artificial intelligence enables unique paper thin shape sensors, soft robots, and using thinner stronger metals to reduce vehicle weight and climate change.
  About a multifaceted legal battle encompassing family law, immigration issues, and the inherent biases within the German legal system, contrasted with practices in other jurisdictions. At its core, it narrates the author's personal jou
  WEROCK Technologies GmbH presents the Rocksmart RSC622, a powerful addition to its Rocksmart RSC600 industrial panel PC family. The latest model boasts a 21.5-inch display and complements the existing RSC610, RSC612 and RSC616 models.
  The 9th IT-TRANS is scheduled for 14th to 16th May 2024 at Messe Karlsruhe. IT-TRANS 2024 will deliver an international conference and exhibition. The strong focus will be on IT solutions for intelligent public transport.
  ROB the voice - Mexicoma - Nights of desire - the new single 2024 - preorder now - out on 02/27/24 ROB the voice (Robert Adrian Steiner), is an international singer/songwriter and producer based in Bavaria/Germany."]

```
- or thru `sitemaps`
```clojure

(require-python '[trafilatura.sitemaps :as sitemaps])

(-> (sitemaps/sitemap_search "https://www.theguardian.com/")
    (py/->jvm))

;; Output
;;=>

["https://www.theguardian.com/world/video/2024/mar/22/the-moment-new-south-wales-banned-gay-conversion-practices-video"
 "https://www.theguardian.com/technology/video/2024/mar/21/us-government-sues-apple-iphone"
 "https://www.theguardian.com/global/video/2024/mar/21/hot-air-balloon-crashes-next-to-a-motorway-in-minnesota-video"
 "https://www.theguardian.com/society/video/2024/mar/21/neuralink-patient-plays-chess-using-brain-chip-video"
 "https://www.theguardian.com/sport/video/2024/mar/21/cat-interrupts-venus-williams-match-at-miami-open-video"
 "https://www.theguardian.com/guardian-live-events/video/2024/mar/21/mary-beard-on-the-emperors-of-rome"
 "https://www.theguardian.com/world/video/2024/mar/21/explosions-in-kyiv-as-capital-comes-under-renewed-russian-bombardment-video"
 "https://www.theguardian.com/sport/video/2024/mar/21/berrettini-almost-collapses-on-court-as-murray-fights-back-to-win-at-miami-open-video"
 "https://www.theguardian.com/australia-news/video/2024/mar/21/greens-mp-jenny-leong-kicked-out-of-nsw-question-time-after-clash-with-speaker-video"
 "https://www.theguardian.com/society/video/2024/mar/21/vapes-to-be-available-only-via-prescription-as-therapeutic-pathway-under-new-bill-video"
 "https://www.theguardian.com/world/video/2024/mar/21/australia-joins-drone-coalition-agreement-to-aid-in-ukraine-war-effort-video"
 "https://www.theguardian.com/australia-news/video/2024/mar/21/workers-in-northern-territory-town-take-boat-to-work-as-borroloola-faces-record-floods-video"
 "https://www.theguardian.com/us-news/video/2024/mar/20/arizona-senator-is-first-state-lawmaker-to-speak-about-fight-to-get-an-abortion-video"
 "https://www.theguardian.com/world/video/2024/mar/20/south-sudan-closes-schools-in-preparation-for-45c-heatwave-video"]

```
