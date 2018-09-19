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
package master

import (
	"testing"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"

	"github.com/openshift/origin/pkg/network"
)

func TestMasterVNIDMap(t *testing.T) {
	vmap := newMasterVNIDMap(true)

	// empty vmap
	checkCurrentVNIDs(t, vmap, 0, 0)

	// assign vnids
	_, _, err := vmap.allocateNetID(metav1.NamespaceDefault)
	checkNoErr(t, err)
	_, exists, err := vmap.allocateNetID("alpha")
	checkNoErr(t, err)
	if exists {
		t.Fatalf("expected netid not to exists")
	}
	_, exists, err = vmap.allocateNetID("alpha")
	checkNoErr(t, err)
	if !exists {
		t.Fatalf("expected allocated netid to exists")
	}
	_, _, err = vmap.allocateNetID("bravo")
	checkNoErr(t, err)
	_, _, err = vmap.allocateNetID("charlie")
	checkNoErr(t, err)
	checkCurrentVNIDs(t, vmap, 4, 3)

	// update vnids
	_, err = vmap.updateNetID("alpha", network.JoinPodNetwork, "bravo")
	checkNoErr(t, err)
	_, err = vmap.updateNetID("alpha", network.JoinPodNetwork, "bogus")
	checkErr(t, err)
	_, err = vmap.updateNetID("bogus", network.JoinPodNetwork, "alpha")
	checkErr(t, err)
	checkCurrentVNIDs(t, vmap, 4, 2)

	_, err = vmap.updateNetID("alpha", network.GlobalPodNetwork, "")
	checkNoErr(t, err)
	_, err = vmap.updateNetID("charlie", network.GlobalPodNetwork, "")
	checkNoErr(t, err)
	_, err = vmap.updateNetID("bogus", network.GlobalPodNetwork, "")
	checkErr(t, err)
	checkCurrentVNIDs(t, vmap, 4, 1)

	_, err = vmap.updateNetID("alpha", network.IsolatePodNetwork, "")
	checkNoErr(t, err)
	_, err = vmap.updateNetID("bravo", network.IsolatePodNetwork, "")
	checkNoErr(t, err)
	_, err = vmap.updateNetID("bogus", network.IsolatePodNetwork, "")
	checkErr(t, err)
	checkCurrentVNIDs(t, vmap, 4, 2)

	// release vnids
	checkNoErr(t, vmap.releaseNetID("alpha"))
	checkNoErr(t, vmap.releaseNetID("bravo"))
	checkNoErr(t, vmap.releaseNetID("charlie"))
	checkNoErr(t, vmap.releaseNetID(metav1.NamespaceDefault))
	checkErr(t, vmap.releaseNetID("bogus"))
	checkCurrentVNIDs(t, vmap, 0, 0)
}

func checkNoErr(t *testing.T, err error) {
	if err != nil {
		t.Fatal(err)
	}
}

func checkErr(t *testing.T, err error) {
	if err == nil {
		t.Fatalf("Expected error is missing!")
	}
}

func checkCurrentVNIDs(t *testing.T, vmap *masterVNIDMap, expectedMapCount, expectedAllocatorCount int) {
	if len(vmap.ids) != expectedMapCount {
		t.Fatalf("Wrong number of VNIDs: %d vs %d", len(vmap.ids), expectedMapCount)
	}

	// Check bitmap allocator
	expected_free := int(network.MaxVNID-network.MinVNID) + 1 - expectedAllocatorCount
	if vmap.netIDManager.Free() != expected_free {
		t.Fatalf("Allocator mismatch: %d vs %d", vmap.netIDManager.Free(), expected_free)
	}
	for _, id := range vmap.ids {
		if id == network.GlobalVNID {
			continue
		}
		if !vmap.netIDManager.Has(id) {
			t.Fatalf("Missing VNID: %d", id)
		}
	}
}
