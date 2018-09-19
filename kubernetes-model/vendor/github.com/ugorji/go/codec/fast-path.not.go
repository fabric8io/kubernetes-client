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
// +build notfastpath

package codec

import "reflect"

const fastpathEnabled = false

// The generated fast-path code is very large, and adds a few seconds to the build time.
// This causes test execution, execution of small tools which use codec, etc
// to take a long time.
//
// To mitigate, we now support the notfastpath tag.
// This tag disables fastpath during build, allowing for faster build, test execution,
// short-program runs, etc.

func fastpathDecodeTypeSwitch(iv interface{}, d *Decoder) bool      { return false }
func fastpathEncodeTypeSwitch(iv interface{}, e *Encoder) bool      { return false }
func fastpathEncodeTypeSwitchSlice(iv interface{}, e *Encoder) bool { return false }
func fastpathEncodeTypeSwitchMap(iv interface{}, e *Encoder) bool   { return false }

type fastpathT struct{}
type fastpathE struct {
	rtid  uintptr
	rt    reflect.Type
	encfn func(*encFnInfo, reflect.Value)
	decfn func(*decFnInfo, reflect.Value)
}
type fastpathA [0]fastpathE

func (x fastpathA) index(rtid uintptr) int { return -1 }

var fastpathAV fastpathA
var fastpathTV fastpathT
