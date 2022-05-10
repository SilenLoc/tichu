FROM gitpod/workspace-full-vnc@sha256:8697bf95299f0a2da49e3a9a1d44e87e90517d7180013e34bc4d9927c0533cb3

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*