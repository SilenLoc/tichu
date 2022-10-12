FROM gitpod/workspace-full-vnc@sha256:d1594bc776fe945569a4838e2b34161f4c50dbbf643436bd8383aa4bfd68c9f4

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*