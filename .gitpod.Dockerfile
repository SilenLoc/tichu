FROM gitpod/workspace-full-vnc@sha256:0ac4490f4d0cbf6f94795024d522c48bf6df4db77823cfe99368d508b2b790e5

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*