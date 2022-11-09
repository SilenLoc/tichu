FROM gitpod/workspace-full-vnc@sha256:f38b1c48ccc63f9a9401fbaf8c9c2e59729a22129adf464e3eb178dfc4c1b98e

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*