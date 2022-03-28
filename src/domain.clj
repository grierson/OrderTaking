(ns domain
  (:require [clojure.spec.alpha :as spec]))

(spec/def ::widget-code #(re-find #"W\d{4}" %))
(spec/def ::gizmo-code #(re-find #"G\d{3}" %))
(spec/def ::product-code (spec/or :widget ::widget-code
                                  :gizmo ::gizmo-code))

(spec/def ::unit-quantity int?)
(spec/def ::kg-quantity decimal?)
(spec/def ::order-quantity (spec/or :unit ::unit-quantity
                                    :kilos ::kg-quantity))

(spec/def ::order-id any?)
(spec/def ::order-line-id any?)
(spec/def ::customer-id any?)

(spec/def ::customer-info any?)
(spec/def ::shipping-address any?)
(spec/def ::billing-address any?)
(spec/def ::price any?)
(spec/def ::billing-amount any?)

(spec/def ::order-line (spec/keys :req [::order-line-id
                                        ::order-id
                                        ::product-code
                                        ::order-quantity
                                        ::price]))

(spec/def ::order (spec/keys :req [::order-id
                                   ::customer-id
                                   ::shipping-address
                                   ::billing-address
                                   ::order-line
                                   ]))

