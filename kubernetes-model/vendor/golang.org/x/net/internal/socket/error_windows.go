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
// Copyright 2017 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package socket

import "syscall"

var (
	errERROR_IO_PENDING error = syscall.ERROR_IO_PENDING
	errEINVAL           error = syscall.EINVAL
)

// errnoErr returns common boxed Errno values, to prevent allocations
// at runtime.
func errnoErr(errno syscall.Errno) error {
	switch errno {
	case 0:
		return nil
	case syscall.ERROR_IO_PENDING:
		return errERROR_IO_PENDING
	case syscall.EINVAL:
		return errEINVAL
	}
	return errno
}
