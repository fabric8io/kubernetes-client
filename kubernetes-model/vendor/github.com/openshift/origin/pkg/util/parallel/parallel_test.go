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
package parallel

import (
	"fmt"
	"sync/atomic"
	"testing"
)

func TestRun(t *testing.T) {
	i := int32(0)
	errs := Run(
		func() error {
			atomic.AddInt32(&i, 1)
			return nil
		},
		func() error {
			atomic.AddInt32(&i, 5)
			return nil
		},
	)
	if len(errs) != 0 || i != 6 {
		t.Error("unexpected run")
	}

	testErr := fmt.Errorf("an error")
	i = int32(0)
	errs = Run(
		func() error {
			return testErr
		},
		func() error {
			atomic.AddInt32(&i, 5)
			return nil
		},
	)
	if len(errs) != 1 && errs[0] != testErr && i != 5 {
		t.Error("unexpected run")
	}
}
