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
// +build x

// Copyright (c) 2012-2015 Ugorji Nwoke. All rights reserved.
// Use of this source code is governed by a MIT license found in the LICENSE file.

package codec

// These tests are used to verify msgpack and cbor implementations against their python libraries.
// If you have the library installed, you can enable the tests back by running: go test -tags=x .
// Look at test.py for how to setup your environment.

import (
	"testing"
)

func TestMsgpackPythonGenStreams(t *testing.T) {
	doTestPythonGenStreams(t, "msgpack", testMsgpackH)
}

func TestCborPythonGenStreams(t *testing.T) {
	doTestPythonGenStreams(t, "cbor", testCborH)
}

func TestMsgpackRpcSpecGoClientToPythonSvc(t *testing.T) {
	doTestMsgpackRpcSpecGoClientToPythonSvc(t)
}

func TestMsgpackRpcSpecPythonClientToGoSvc(t *testing.T) {
	doTestMsgpackRpcSpecPythonClientToGoSvc(t)
}
