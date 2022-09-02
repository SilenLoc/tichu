FROM gitpod/workspace-full-vnc@sha256:7e800c350e80b565ebc895b6d69458056c40b5d79de9700a30b361656b5c4219

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*