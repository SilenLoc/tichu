FROM gitpod/workspace-full-vnc@sha256:bf7d8ce01ddc0d0a1f369bdd5a7d4622678be8dab9f1a33fd0c2b46bf9b284e4

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*