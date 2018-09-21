#!/bin/bash
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

source /run/$NAME-env

MAINPID=`sed -n -e "/^PPid/ s|PPid:\t||p" /proc/$$/status`

# openvswitch 2.4 has no systemd-notify support, so add it here.
# Workaround for a bug in systemd-notify 219.  Whenever used with --pid, systemd-notify 219
# sends an incorrect packet to $NOTIFY_SOCKET and the process hangs.
# Newer versions of systemd-notify don't have this issue, and also this change in runc,
# even if addressing another issue: https://github.com/opencontainers/runc/pull/1308
# will ensure once it gets in a release that the notify events are properly propagated.
if test -n ${NOTIFY_SOCKET-}; then
    /usr/share/openvswitch/scripts/ovs-ctl status
    while /usr/share/openvswitch/scripts/ovs-ctl status | grep -q "not running"; do
        sleep 1
    done
    ps aux | grep $MAINPID
    python - << EOF
import socket
import os
s = socket.socket(socket.AF_UNIX, socket.SOCK_DGRAM)
e = os.getenv('NOTIFY_SOCKET')
s.connect(e)
s.sendall('MAINPID=%i\nREADY=1\n' % $MAINPID)
s.close()
EOF
fi &

exec /usr/local/bin/ovs-run.sh
