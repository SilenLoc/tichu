FROM gitpod/workspace-full-vnc@sha256:efaeed9777c920c0158f2bb25ccfacdb6c286a9bc004b4bab3daf2bb4024958a

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*