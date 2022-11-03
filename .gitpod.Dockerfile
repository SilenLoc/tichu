FROM gitpod/workspace-full-vnc@sha256:0d15a70a5f5ca5040e74df4b2d3f912a5455ef4e247a9e9fe4ddc1af18950df6

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*