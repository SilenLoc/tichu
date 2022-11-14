FROM gitpod/workspace-full-vnc@sha256:46de24ee7942ecfa7e52fc1b1eb716615bb3f97d7b94df12eaa761243ecad060

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*