FROM gitpod/workspace-full-vnc@sha256:170a4642fb7157feb9e8ec63ad139af3c1ddce532e5f7dcd40158de7a976b71a

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*