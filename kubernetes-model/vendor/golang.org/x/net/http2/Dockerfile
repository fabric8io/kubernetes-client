#
# Copyright (C) 2015 Red Hat, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#         http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

#
# This Dockerfile builds a recent curl with HTTP/2 client support, using
# a recent nghttp2 build.
#
# See the Makefile for how to tag it. If Docker and that image is found, the
# Go tests use this curl binary for integration tests.
#

FROM ubuntu:trusty

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y git-core build-essential wget

RUN apt-get install -y --no-install-recommends \
       autotools-dev libtool pkg-config zlib1g-dev \
       libcunit1-dev libssl-dev libxml2-dev libevent-dev \
       automake autoconf

# The list of packages nghttp2 recommends for h2load:
RUN apt-get install -y --no-install-recommends make binutils \
        autoconf automake autotools-dev \
        libtool pkg-config zlib1g-dev libcunit1-dev libssl-dev libxml2-dev \
        libev-dev libevent-dev libjansson-dev libjemalloc-dev \
        cython python3.4-dev python-setuptools

# Note: setting NGHTTP2_VER before the git clone, so an old git clone isn't cached:
ENV NGHTTP2_VER 895da9a
RUN cd /root && git clone https://github.com/tatsuhiro-t/nghttp2.git

WORKDIR /root/nghttp2
RUN git reset --hard $NGHTTP2_VER
RUN autoreconf -i
RUN automake
RUN autoconf
RUN ./configure
RUN make
RUN make install

WORKDIR /root
RUN wget http://curl.haxx.se/download/curl-7.45.0.tar.gz
RUN tar -zxvf curl-7.45.0.tar.gz
WORKDIR /root/curl-7.45.0
RUN ./configure --with-ssl --with-nghttp2=/usr/local
RUN make
RUN make install
RUN ldconfig

CMD ["-h"]
ENTRYPOINT ["/usr/local/bin/curl"]

