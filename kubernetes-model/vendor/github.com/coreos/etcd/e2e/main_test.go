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
// Copyright 2013 The Go Authors. All rights reserved.
// Use of this source code is governed by a BSD-style
// license that can be found in the LICENSE file.

package e2e

import (
	"flag"
	"os"
	"runtime"
	"testing"

	"github.com/coreos/etcd/pkg/testutil"
)

var binDir string
var certDir string

func TestMain(m *testing.M) {
	os.Setenv("ETCD_UNSUPPORTED_ARCH", runtime.GOARCH)
	os.Unsetenv("ETCDCTL_API")

	flag.StringVar(&binDir, "bin-dir", "../bin", "The directory for store etcd and etcdctl binaries.")
	flag.StringVar(&certDir, "cert-dir", "../integration/fixtures", "The directory for store certificate files.")
	flag.Parse()

	v := m.Run()
	if v == 0 && testutil.CheckLeakedGoroutine() {
		os.Exit(1)
	}
	os.Exit(v)
}
