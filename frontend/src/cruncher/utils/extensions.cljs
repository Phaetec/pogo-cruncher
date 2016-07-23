(ns cruncher.utils.extensions
  "Extending JS types to be better accessible in CLJS.")

(def types [js/NodeList
            js/HTMLCollection
            js/HTMLDocument
            js/HTMLDivElement
            js/HTMLParagraphElement
            js/HTMLSpanElement])

(defn extend-type-fn
  "Given a type t, apply extensions."
  [t]
  (extend-type t
    ISeqable
    (-seq [array] (array-seq array 0))
    ICounted
    (-count [a] (alength a))
    IIndexed
    (-nth
      ([array n]
       (if (< n (alength array)) (aget array n)))
      ([array n not-found]
       (if (< n (alength array)) (aget array n)
                                 not-found)))
    ILookup
    (-lookup
      ([array k]
       (aget array k))
      ([array k not-found]
       (-nth array k not-found)))
    IReduce
    (-reduce
      ([array f]
       (ci-reduce array f))
      ([array f start]
       (ci-reduce array f start)))))

(doall (map extend-type-fn types))
