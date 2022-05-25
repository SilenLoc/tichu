FROM gitpod/workspace-full-vnc@sha256:24e1a96580c315d8bfb3b796fdf8262667adece8d91dd09301abcca9c798bc1e

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*