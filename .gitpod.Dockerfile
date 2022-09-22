FROM gitpod/workspace-full-vnc@sha256:ef9c9b2c51957c3be49c1821874a1ea11ea54628da23eb128294af4943e9c0fd

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*