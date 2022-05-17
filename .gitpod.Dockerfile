FROM gitpod/workspace-full-vnc@sha256:9b871dfb7d4a8a23b7bef53b8ae04f58b17d346ebc412429297e6ba742895279

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*