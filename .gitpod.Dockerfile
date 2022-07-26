FROM gitpod/workspace-full-vnc@sha256:5ad8578723a341404e957ea8863c71ec20e7f58a9e0a550ea3916e3e0f67f92e

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*