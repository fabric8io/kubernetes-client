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
package app

import (
	"testing"

	"github.com/openshift/origin/pkg/oc/generate"
)

func TestAddBuildSecrets(t *testing.T) {
	type result struct{ name, dest string }
	type tc struct {
		in     []string
		expect []result
	}
	table := []tc{
		{
			in:     []string{"secret1"},
			expect: []result{{name: "secret1", dest: "."}},
		},
		{
			in: []string{"secret1", "secret1"},
		},
		{
			in:     []string{"secret1:/var/lib/foo"},
			expect: []result{{name: "secret1", dest: "/var/lib/foo"}},
		},
		{
			in: []string{"secret1", "secret2:/foo"},
			expect: []result{
				{
					name: "secret1",
					dest: ".",
				},
				{
					name: "secret2",
					dest: "/foo",
				},
			},
		},
	}
	repo := &SourceRepository{}
	repo.strategy = generate.StrategyDocker
	if err := repo.AddBuildSecrets([]string{"secret1:/absolute/path"}); err == nil {
		t.Errorf("expected error for docker strategy when destDir is absolute")
	}
	for _, item := range table {
		repo := &SourceRepository{}
		err := repo.AddBuildSecrets(item.in)
		if err != nil && len(item.expect) != 0 {
			t.Errorf("unexpected error: %v", err)
			continue
		}
		for _, expect := range item.expect {
			got := repo.Secrets()
			found := false
			for _, s := range got {
				if s.Secret.Name == expect.name && s.DestinationDir == expect.dest {
					found = true
					break
				}
			}
			if !found {
				t.Errorf("expected %+v secret in %#v not found", expect, got)
			}
		}
	}
}
