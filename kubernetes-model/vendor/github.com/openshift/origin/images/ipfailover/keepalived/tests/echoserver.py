#!/usr/bin/env python
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


""" Echo server - reply back with the received message. """

import os
import signal
import socket
import sys


def sigusr1_handler(signum, frame):
    print 'signal %s received, exiting ...' % signum
    sys.exit(0)


def setup():
    signal.signal(signal.SIGUSR1, sigusr1_handler)


def runserver():
    sock = socket.socket()
    sock.bind(('0.0.0.0', int(os.environ.get('PORT', '12345'))))
    sock.listen(10)

    while True:
        c, raddr = sock.accept()
        try:
            d = c.recv(4096)
            c.send(d if d else '')
        finally:
            c.close()


if "__main__" == __name__:
    setup()
    runserver()
