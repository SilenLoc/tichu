FROM gitpod/workspace-full-vnc@sha256:bf9089dda57e9ee42ff827ac61937559f7ed87f83c8dbca7ef377d156ea8a791

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*