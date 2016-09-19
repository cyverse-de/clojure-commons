FROM clojure
COPY ./docker/profiles.clj /root/.lein/profiles.clj
WORKDIR /usr/src/clojure-commons

COPY project.clj /usr/src/clojure-commons/
RUN lein deps

COPY . /usr/src/clojure-commons
CMD ["lein", "test"]
