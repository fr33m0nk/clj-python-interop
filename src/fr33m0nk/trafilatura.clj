(ns fr33m0nk.trafilatura
  (:require
    [libpython-clj2.python :as py :refer [py. py.. py.-]]
    [libpython-clj2.require :refer [require-python]]))

(require-python '[trafilatura :as tf])
(require-python '[trafilatura.feeds :as feeds])
(require-python '[trafilatura.sitemaps :as sitemaps])


(defn feed->urls
  [feed-url]
  (-> (feeds/find_feed_urls feed-url)
      (py/->jvm)))

(defn sitemaps->urls
  [sitemap-url]
  (-> (sitemaps/sitemap_search sitemap-url)
      (py/->jvm)))

(defn scrape!
  [url]
  (-> (tf/fetch_url url)
      (tf/extract)))

(comment
  (->> (feed->urls "https://www.prlog.org/news/de/rss.xml")
       (into []
             (map scrape!)))

  (sitemaps->urls "https://www.theguardian.com/")
  )
