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
// +build x,codecgen

package codec

import (
	"fmt"
	"testing"
)

func _TestCodecgenJson1(t *testing.T) {
	// This is just a simplistic test for codecgen.
	// It is typically disabled. We only enable it for debugging purposes.
	const callCodecgenDirect bool = true
	v := newTestStruc(2, false, !testSkipIntf, false)
	var bs []byte
	e := NewEncoderBytes(&bs, testJsonH)
	if callCodecgenDirect {
		v.CodecEncodeSelf(e)
		e.w.atEndOfEncode()
	} else {
		e.MustEncode(v)
	}
	fmt.Printf("%s\n", bs)
}
