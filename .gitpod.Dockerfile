FROM gitpod/workspace-full-vnc@sha256:0b342938773720a99a08ae202f13ba7861c5cb06d8605bbac3efc697175b45ea

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*