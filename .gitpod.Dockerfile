FROM gitpod/workspace-full-vnc@sha256:6f4627e82ae573e682cad201e87f039ec5a633c176341a236f1d6ca31c1913f0

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*