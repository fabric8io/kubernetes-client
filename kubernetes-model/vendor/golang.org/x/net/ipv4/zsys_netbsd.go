/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Created by cgo -godefs - DO NOT EDIT
// cgo -godefs defs_netbsd.go

package ipv4

const (
	sysIP_OPTIONS     = 0x1
	sysIP_HDRINCL     = 0x2
	sysIP_TOS         = 0x3
	sysIP_TTL         = 0x4
	sysIP_RECVOPTS    = 0x5
	sysIP_RECVRETOPTS = 0x6
	sysIP_RECVDSTADDR = 0x7
	sysIP_RETOPTS     = 0x8
	sysIP_RECVIF      = 0x14
	sysIP_RECVTTL     = 0x17

	sysIP_MULTICAST_IF    = 0x9
	sysIP_MULTICAST_TTL   = 0xa
	sysIP_MULTICAST_LOOP  = 0xb
	sysIP_ADD_MEMBERSHIP  = 0xc
	sysIP_DROP_MEMBERSHIP = 0xd

	sizeofIPMreq = 0x8
)

type ipMreq struct {
	Multiaddr [4]byte /* in_addr */
	Interface [4]byte /* in_addr */
}
