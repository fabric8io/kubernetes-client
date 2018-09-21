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
// +build !noresumabledigest

package storage

import (
	"testing"

	digest "github.com/opencontainers/go-digest"
	"github.com/stevvooe/resumable"
	_ "github.com/stevvooe/resumable/sha256"
)

// TestResumableDetection just ensures that the resumable capability of a hash
// is exposed through the digester type, which is just a hash plus a Digest
// method.
func TestResumableDetection(t *testing.T) {
	d := digest.Canonical.Digester()

	if _, ok := d.Hash().(resumable.Hash); !ok {
		t.Fatalf("expected digester to implement resumable.Hash: %#v, %v", d, d.Hash())
	}
}
