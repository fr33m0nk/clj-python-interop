(ns fr33m0nk.trafilatura
  (:require
    [libpython-clj2.python :as py :refer [py. py.. py.-]]
    [libpython-clj2.require :refer [require-python]]))

(require-python '[trafilatura :as tf])

(defn scrape!
  [url]
  (-> (tf/fetch_url url)
      (tf/extract)))
