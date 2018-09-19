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
package prune

import (
	"io/ioutil"
	"testing"

	buildfake "github.com/openshift/origin/pkg/build/generated/internalclientset/fake"
)

func TestBuildPruneNamespaced(t *testing.T) {
	osFake := buildfake.NewSimpleClientset()
	opts := &PruneBuildsOptions{
		Namespace: "foo",

		BuildClient: osFake,
		Out:         ioutil.Discard,
	}

	if err := opts.Run(); err != nil {
		t.Errorf("Unexpected error: %v", err)
	}

	if len(osFake.Actions()) == 0 {
		t.Errorf("Missing get build actions")
	}
	for _, a := range osFake.Actions() {
		if a.GetNamespace() != "foo" {
			t.Errorf("Unexpected namespace while pruning %s: %s", a.GetResource(), a.GetNamespace())
		}
	}
}
