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
package serviceability

import (
	"testing"
	"time"

	utilruntime "k8s.io/apimachinery/pkg/util/runtime"
)

func TestPanicDelayingDeath(t *testing.T) {
	BehaviorOnPanic(`["crash-after-delay:10s"]`)

	utilruntime.ReallyCrash = false
	go func() {
		defer utilruntime.HandleCrash()
		panic("not dead yet!")
	}()

	select {
	case <-time.After(5 * time.Second):
		t.Log("beat death!")
	}
}
