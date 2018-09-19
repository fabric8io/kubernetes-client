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
package stdtypes

import (
	"io/ioutil"
	"sync"
	"testing"

	"github.com/gogo/protobuf/proto"
)

func TestConcurrentTextMarshal(t *testing.T) {
	// Verify that there are no race conditions when calling
	// TextMarshaler.Marshal on a protobuf message that contains a StdDuration

	std := StdTypes{}
	var wg sync.WaitGroup

	tm := proto.TextMarshaler{}

	for i := 0; i < 2; i++ {
		wg.Add(1)
		go func() {
			defer wg.Done()
			err := tm.Marshal(ioutil.Discard, &std)
			if err != nil {
				t.Fatal(err)
			}
		}()
	}
	wg.Wait()
}
