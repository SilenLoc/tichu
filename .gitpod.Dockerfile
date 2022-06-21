FROM gitpod/workspace-full-vnc@sha256:452b2d5d604c51fa39273668dc26c83b114e1611e4415ebe10443faf2a72cab6

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*