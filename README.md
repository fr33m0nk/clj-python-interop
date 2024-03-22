## Demo of inter-op with Python package from Clojure (JVM)

This demo uses excellent scraping package for Python [`Trafilatura`]() 

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
