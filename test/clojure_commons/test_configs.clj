(ns clojure-commons.test-configs
  (:require [clojure-commons.config :refer :all]))

(def props
  "The example properties to use for testing. Note that the properties aren't actually loaded
   into the reference until after the configuration settings are defined. This simulates the
   most common usage, in which a service loads the configuration properties after the namespace
   that defines the configuration settings has been loaded."
  (ref nil))

(def config-valid
  "A flag indicating that the configuration is valid."
  (ref true))

(def configs
  "A vector of configuration settings."
  (ref []))

(defprop-boolean enabled-flag
  "Description of enabled-flag."
  [props config-valid configs]
  "enabled-flag")

(defprop-boolean disabled-flag
  "Description of disabled-flag."
  [props config-valid configs]
  "disabled-flag")

(defprop-str foo
  "Description of foo."
  [props config-valid configs]
  "foo")

(defprop-str baz
  "Description of baz."
  [props config-valid configs]
  "baz")

(defprop-str enabled-string
  "String property with enabled feature flag."
  [props config-valid configs enabled-flag]
  "enabled-string")

(defprop-str disabled-string
  "String property with disabled feature flag."
  [props config-valid configs disabled-flag]
  "disabled-string")

(defprop-optstr defined-optional-string
  "Defined optional string."
  [props config-valid configs]
  "defined-optional-string")

(defprop-optstr undefined-optional-string
  "Undefined optional string."
  [props config-valid configs]
  "undefined-optional-string")

(defprop-optstr undefined-optional-string-with-default
  "Undefined optional string with default value."
  [props config-valid configs]
  "undefined-optional-string-with-default"
  "The foo is in the bar.")

(defprop-optstr enabled-optional-string
  "Enabled optional string"
  [props config-valid configs enabled-flag]
  "enabled-optional-string")

(defprop-optstr enabled-optional-string-with-default
  "Enabled optional string with default."
  [props config-valid configs enabled-flag]
  "enabled-optional-string-with-default"
  "This is an enabled optional string.")

(defprop-optstr disabled-optional-string
  "Disabled optional string."
  [props config-valid configs disabled-flag]
  "disabled-optional-string")

(defprop-optstr disabled-optional-string-with-default
  "Disabled optional string with default."
  [props config-valid configs disabled-flag]
  "disabled-optional-string-with-default"
  "This is a disabled optional string.")

(defprop-vec required-vector
  "Required vector."
  [props config-valid configs]
  "required-vector")

(defprop-vec enabled-vector
  "Enabled vector."
  [props config-valid configs enabled-flag]
  "enabled-vector")

(defprop-vec disabled-vector
  "Disabled vector."
  [props config-valid configs disabled-flag]
  "disabled-vector")

(defprop-optvec defined-optional-vector
  "Defined optional vector."
  [props config-valid configs]
  "defined-optional-vector")

(defprop-optvec undefined-optional-vector
  "Undefined optional vector."
  [props config-valid configs]
  "undefined-optional-vector")

(defprop-optvec undefined-optional-vector-with-default
  "Undefined optional vector with default value."
  [props config-valid configs]
  "undefined-optional-vector-with-default"
  (mapv str (range 5)))

(defprop-optvec enabled-optional-vector
  "Enabled optional vector."
  [props config-valid configs enabled-flag]
  "enabled-optional-vector")

(defprop-optvec enabled-optional-vector-with-default
  "enabled optional vector with default."
  [props config-valid configs enabled-flag]
  "enabled-optional-vector-with-default"
  (mapv str (range 10)))

(defprop-optvec disabled-optional-vector
  "Disabled optional vector."
  [props config-valid configs disabled-flag]
  "disabled-optional-vector")

(defprop-optvec disabled-optional-vector-with-default
  "Disabled optional vector with default."
  [props config-valid configs disabled-flag]
  "disabled-optional-vector-with-default"
  (mapv str (range 10)))

(defprop-int required-int
  "Required integer."
  [props config-valid configs]
  "required-int")

(defprop-int enabled-int
  "Enabled required integer."
  [props config-valid configs enabled-flag]
  "enabled-int")

(defprop-int disabled-int
  "Disabled required integer."
  [props config-valid configs disabled-flag]
  "disabled-int")

(defprop-optint defined-optional-int
  "Defined optional integer."
  [props config-valid configs]
  "defined-optional-int")

(defprop-optint undefined-optional-int
  "Undefined optional integer."
  [props config-valid configs]
  "undefined-optional-int")

(defprop-optint undefined-optional-int-with-default
  "Undefined optional integer with default value."
  [props config-valid configs]
  "undefined-optional-int-with-default"
  42)

(defprop-optint enabled-optional-int
  "Enabled optional integer."
  [props config-valid configs enabled-flag]
  "enabled-optional-int")

(defprop-optint enabled-optional-int-with-default
  "Enabled optional integer with default."
  [props config-valid configs enabled-flag]
  "enabled-optional-int-with-default"
  55)

(defprop-optint disabled-optional-int
  "Disabled optional integer."
  [props config-valid configs disabled-flag]
  "disabled-optional-int")

(defprop-optint disabled-optional-int-with-default
  "Disabled optional integer with default."
  [props config-valid configs disabled-flag]
  77)

(defprop-long required-long
  "Required long integer."
  [props config-valid configs]
  "required-long")

(defprop-long enabled-long
  "Enabled long integer."
  [props config-valid configs enabled-flag]
  "enabled-long")

(defprop-long disabled-long
  "Disabled long integer."
  [props config-valid configs disabled-flag]
  "disabled-long")

(defprop-optlong defined-optional-long
  "Defined optional long integer."
  [props config-valid configs]
  "defined-optional-long")

(defprop-optlong undefined-optional-long
  "Undefined optional long integer."
  [props config-valid configs]
  "undefined-optional-long")

(defprop-optlong enabled-optional-long
  "Enabled optional long integer."
  [props config-valid configs enabled-flag]
  "enabled-optional-long")

(defprop-optlong enabled-optional-long-with-default
  "Enabled optional long integer with default."
  [props config-valid configs enabled-flag]
  "enabled-optional-long-with-default"
  99)

(defprop-optlong disabled-optional-long
  "Disabled optional long integer."
  [props config-valid configs disabled-flag]
  "disabled-optional-long")

(defprop-optlong disabled-optional-long-with-default
  "Disabled optional long integer with default."
  [props config-valid configs disabled-flag]
  "disabled-optional-long-with-default"
  101)

(defprop-boolean required-boolean
  "Required boolean."
  [props config-valid configs]
  "required-boolean")

(defprop-boolean enabled-boolean
  "Enabled boolean."
  [props config-valid configs enabled-flag]
  "enabled-boolean")

(defprop-boolean disabled-boolean
  "Disabled boolean."
  [props config-valid configs disabled-flag]
  "disabled-boolean")

(defprop-optboolean defined-optional-boolean
  "Defined optional boolean."
  [props config-valid configs]
  "defined-optional-boolean")

(defprop-optboolean undefined-optional-boolean
  "Undefined optional boolean."
  [props config-valid configs]
  "undefined-optional-boolean")

(defprop-optboolean undefined-optional-boolean-with-default
  "Undefined optional boolean with default value."
  [props config-valid configs]
  "undefined-optional-boolean-with-default"
  true)

(defprop-optboolean enabled-optional-boolean
  "Enabled optional boolean."
  [props config-valid configs enabled-flag]
  "enabled-optional-boolean")

(defprop-optboolean enabled-optional-boolean-with-default
  "Enabled optional boolean with default."
  [props config-valid configs enabled-flag]
  "enabled-optional-boolean-with-default"
  true)

(defprop-optboolean disabled-optional-boolean
  "Disabled optional boolean."
  [props config-valid configs disabled-flag]
  "disabled-optional-boolean")

(defprop-optboolean disabled-optional-boolean-with-default
  "Disbled optional boolean with default."
  [props config-valid configs disabled-flag]
  "disabled-optional-boolean-with-default"
  true)

(defprop-optstr multiple-enabled-flags
  "Flagged property with multiple enabled flags."
  [props config-valid configs enabled-flag enabled-flag]
  "multiple-enabled-flags"
  "multiple-enabled-flags")

(defprop-optstr mixed-feature-flags
  "Flagged property with one disabled flag and one enabled flag."
  [props config-valid configs enabled-flag disabled-flag]
  "mixed-feature-flags"
  "mixed-feature-flags")

(defprop-optstr multiple-disabled-flags
  "Flagged property with multiple disabled flags."
  [props config-valid configs disabled-flag disabled-flag]
  "multiple-disabled-flags"
  "multiple-disabled-flags")

(defn load-from-file [path]
  (load-config-from-file path props))

(defn load-from-map [m]
  (load-config-from-map m props))

(defn configs-valid? []
  (validate-config configs config-valid))

(defn configs-defined? []
  (= [#'enabled-flag
      #'disabled-flag
      #'foo
      #'baz
      #'enabled-string
      #'disabled-string
      #'defined-optional-string
      #'undefined-optional-string
      #'undefined-optional-string-with-default
      #'enabled-optional-string
      #'enabled-optional-string-with-default
      #'disabled-optional-string
      #'disabled-optional-string-with-default
      #'required-vector
      #'enabled-vector
      #'disabled-vector
      #'defined-optional-vector
      #'undefined-optional-vector
      #'undefined-optional-vector-with-default
      #'enabled-optional-vector
      #'enabled-optional-vector-with-default
      #'disabled-optional-vector
      #'disabled-optional-vector-with-default
      #'required-int
      #'enabled-int
      #'disabled-int
      #'defined-optional-int
      #'undefined-optional-int
      #'undefined-optional-int-with-default
      #'enabled-optional-int
      #'enabled-optional-int-with-default
      #'disabled-optional-int
      #'disabled-optional-int-with-default
      #'required-long
      #'enabled-long
      #'disabled-long
      #'defined-optional-long
      #'undefined-optional-long
      #'enabled-optional-long
      #'enabled-optional-long-with-default
      #'disabled-optional-long
      #'disabled-optional-long-with-default
      #'required-boolean
      #'enabled-boolean
      #'disabled-boolean
      #'defined-optional-boolean
      #'undefined-optional-boolean
      #'undefined-optional-boolean-with-default
      #'enabled-optional-boolean
      #'enabled-optional-boolean-with-default
      #'disabled-optional-boolean
      #'disabled-optional-boolean-with-default
      #'multiple-enabled-flags
      #'mixed-feature-flags
      #'multiple-disabled-flags]
     @configs))
