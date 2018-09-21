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
package mcsallocator

import (
	"reflect"
	"testing"

	"k8s.io/apimachinery/pkg/util/sets"
	"k8s.io/kubernetes/pkg/registry/core/service/allocator"

	"github.com/openshift/origin/pkg/security/mcs"
)

func TestAllocate(t *testing.T) {
	ranger, _ := mcs.NewRange("s0:", 5, 2)
	r := New(ranger, func(max int, rangeSpec string) allocator.Interface {
		return allocator.NewContiguousAllocationMap(max, rangeSpec)
	})
	if f := r.Free(); f != 10 {
		t.Errorf("unexpected free %d", f)
	}
	found := sets.NewString()
	count := 0
	for r.Free() > 0 {
		label, err := r.AllocateNext()
		if err != nil {
			t.Fatalf("error @ %d: %v", count, err)
		}
		count++
		if !ranger.Contains(label) {
			t.Fatalf("allocated %s which is outside of %s", label, ranger)
		}
		if found.Has(label.String()) {
			t.Fatalf("allocated %s twice @ %d", label, count)
		}
		found.Insert(label.String())
	}
	if _, err := r.AllocateNext(); err != ErrFull {
		t.Fatal(err)
	}

	released, _ := ranger.LabelAt(3)
	if err := r.Release(released); err != nil {
		t.Fatal(err)
	}
	if f := r.Free(); f != 1 {
		t.Errorf("unexpected free %d", f)
	}
	label, err := r.AllocateNext()
	if err != nil {
		t.Fatal(err)
	}
	if !reflect.DeepEqual(released, label) {
		t.Errorf("unexpected %s : %s", label, released)
	}

	if err := r.Release(released); err != nil {
		t.Fatal(err)
	}
	badLabel, _ := ranger.LabelAt(30)
	if err := r.Allocate(badLabel); err != ErrNotInRange {
		t.Fatal(err)
	}
	if f := r.Free(); f != 1 {
		t.Errorf("unexpected free %d", f)
	}
	if err := r.Allocate(released); err != nil {
		t.Fatal(err)
	}
	if f := r.Free(); f != 0 {
		t.Errorf("unexpected free %d", f)
	}
}
