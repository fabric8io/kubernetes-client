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
/*
This test file is part of the spew package rather than than the spew_test
package because it needs access to internals to properly test certain cases
which are not possible via the public interface since they should never happen.
*/

package spew

import (
	"bytes"
	"reflect"
	"testing"
)

// dummyFmtState implements a fake fmt.State to use for testing invalid
// reflect.Value handling.  This is necessary because the fmt package catches
// invalid values before invoking the formatter on them.
type dummyFmtState struct {
	bytes.Buffer
}

func (dfs *dummyFmtState) Flag(f int) bool {
	if f == int('+') {
		return true
	}
	return false
}

func (dfs *dummyFmtState) Precision() (int, bool) {
	return 0, false
}

func (dfs *dummyFmtState) Width() (int, bool) {
	return 0, false
}

// TestInvalidReflectValue ensures the dump and formatter code handles an
// invalid reflect value properly.  This needs access to internal state since it
// should never happen in real code and therefore can't be tested via the public
// API.
func TestInvalidReflectValue(t *testing.T) {
	i := 1

	// Dump invalid reflect value.
	v := new(reflect.Value)
	buf := new(bytes.Buffer)
	d := dumpState{w: buf, cs: &Config}
	d.dump(*v)
	s := buf.String()
	want := "<invalid>"
	if s != want {
		t.Errorf("InvalidReflectValue #%d\n got: %s want: %s", i, s, want)
	}
	i++

	// Formatter invalid reflect value.
	buf2 := new(dummyFmtState)
	f := formatState{value: *v, cs: &Config, fs: buf2}
	f.format(*v)
	s = buf2.String()
	want = "<invalid>"
	if s != want {
		t.Errorf("InvalidReflectValue #%d got: %s want: %s", i, s, want)
	}
}

// SortValues makes the internal sortValues function available to the test
// package.
func SortValues(values []reflect.Value, cs *ConfigState) {
	sortValues(values, cs)
}
