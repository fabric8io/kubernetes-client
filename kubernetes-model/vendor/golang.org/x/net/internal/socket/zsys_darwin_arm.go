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
// cgo -godefs defs_darwin.go

package socket

const (
	sysAF_UNSPEC = 0x0
	sysAF_INET   = 0x2
	sysAF_INET6  = 0x1e

	sysSOCK_RAW = 0x3
)

type iovec struct {
	Base *byte
	Len  uint32
}

type msghdr struct {
	Name       *byte
	Namelen    uint32
	Iov        *iovec
	Iovlen     int32
	Control    *byte
	Controllen uint32
	Flags      int32
}

type cmsghdr struct {
	Len   uint32
	Level int32
	Type  int32
}

type sockaddrInet struct {
	Len    uint8
	Family uint8
	Port   uint16
	Addr   [4]byte /* in_addr */
	Zero   [8]int8
}

type sockaddrInet6 struct {
	Len      uint8
	Family   uint8
	Port     uint16
	Flowinfo uint32
	Addr     [16]byte /* in6_addr */
	Scope_id uint32
}

const (
	sizeofIovec   = 0x8
	sizeofMsghdr  = 0x1c
	sizeofCmsghdr = 0xc

	sizeofSockaddrInet  = 0x10
	sizeofSockaddrInet6 = 0x1c
)
