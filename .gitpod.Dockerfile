FROM gitpod/workspace-full-vnc@sha256:7b8cf2e855e5a1848a7776a8030bda015c289299107b9dc9d8c664c1f47c89e3

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*