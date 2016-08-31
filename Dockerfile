FROM clojure
COPY . /usr/src/clojure-commons
COPY ./docker/profiles.clj /root/.lein/profiles.clj
WORKDIR /usr/src/clojure-commons
RUN lein deps
CMD ["lein", "test"]
