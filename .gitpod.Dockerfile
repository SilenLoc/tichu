FROM gitpod/workspace-full-vnc@sha256:c185cae111c4e6ed38e85bb9415d4337151d2f3cc70b5a8ac8d6952b406b74cb

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*