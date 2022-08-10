FROM gitpod/workspace-full-vnc@sha256:9e71dcf496435d3a9386541b628eb60735337ea5faa27f580c38c943f326c413

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*