FROM gitpod/workspace-full-vnc@sha256:780853f4df8418fd24a9236bb3c9b2915cf6b28f6ebd13ce38696250b02bd370

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*