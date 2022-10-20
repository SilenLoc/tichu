FROM gitpod/workspace-full-vnc@sha256:5f2f296ebd129fc134bb338677311657f8e0c55b6d120d71d7d9aac0bedb8ae1

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*