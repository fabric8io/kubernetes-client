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
// Copyright 2014 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

// +build ignore

// +godefs map struct_in_addr [4]byte /* in_addr */

package ipv4

/*
#include <netinet/in.h>
*/
import "C"

const (
	sysIP_OPTIONS     = C.IP_OPTIONS
	sysIP_HDRINCL     = C.IP_HDRINCL
	sysIP_TOS         = C.IP_TOS
	sysIP_TTL         = C.IP_TTL
	sysIP_RECVOPTS    = C.IP_RECVOPTS
	sysIP_RECVRETOPTS = C.IP_RECVRETOPTS
	sysIP_RECVDSTADDR = C.IP_RECVDSTADDR
	sysIP_RETOPTS     = C.IP_RETOPTS
	sysIP_RECVIF      = C.IP_RECVIF
	sysIP_RECVTTL     = C.IP_RECVTTL

	sysIP_MULTICAST_IF    = C.IP_MULTICAST_IF
	sysIP_MULTICAST_TTL   = C.IP_MULTICAST_TTL
	sysIP_MULTICAST_LOOP  = C.IP_MULTICAST_LOOP
	sysIP_MULTICAST_VIF   = C.IP_MULTICAST_VIF
	sysIP_ADD_MEMBERSHIP  = C.IP_ADD_MEMBERSHIP
	sysIP_DROP_MEMBERSHIP = C.IP_DROP_MEMBERSHIP

	sizeofIPMreq = C.sizeof_struct_ip_mreq
)

type ipMreq C.struct_ip_mreq
