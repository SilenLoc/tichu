FROM gitpod/workspace-full-vnc@sha256:0684d63d4dcf96d528ed9069c4cd12363b67c8f962f28943777874343a7cc408

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*