FROM gitpod/workspace-full-vnc@sha256:e6c98cacdd270067f6c64de51ea3c4994d4d28f56979623678e4beadfad5400c

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*