FROM gitpod/workspace-full-vnc@sha256:6bd3bc450e4dbb08459099266b2ca2147aa9f90958c03d85cc6a63b6ea2115f7

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*