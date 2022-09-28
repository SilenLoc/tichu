FROM gitpod/workspace-full-vnc@sha256:f4be9f7f9477c16211f513d28a547ac3f40fac58bc738cef146d31f2202add33

RUN apt-get update \
    && apt-get install -y openjfx libopenjfx-java matchbox \
    && apt-get clean && rm -rf /var/cache/apt/* && rm -rf /var/lib/apt/lists/* && rm -rf /tmp/*