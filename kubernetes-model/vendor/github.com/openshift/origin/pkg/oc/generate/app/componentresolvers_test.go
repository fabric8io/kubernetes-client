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
	"fmt"
	"testing"
)

type mockSearcher struct {
	numResults int
}

func (m mockSearcher) Type() string {
	return ""
}

func (m mockSearcher) Search(precise bool, terms ...string) (ComponentMatches, []error) {
	results := ComponentMatches{}
	for i := 0; i < m.numResults; i++ {
		results = append(results, &ComponentMatch{Argument: fmt.Sprintf("match%d", i), Score: 0.0})
	}

	return results, nil
}

func TestWeightedResolvers(t *testing.T) {
	resolver1 := WeightedResolver{mockSearcher{2}, 1.0}
	resolver2 := WeightedResolver{mockSearcher{3}, 1.0}
	wr := PerfectMatchWeightedResolver{resolver1, resolver2}

	_, err := wr.Resolve("image")
	if err == nil {
		t.Error("expected a multiple match error, got no error")
	}
	if _, ok := err.(ErrMultipleMatches); !ok {
		t.Errorf("expected a multiple match error, got error %v instead", err)
	}
	multiError := err.(ErrMultipleMatches)
	if len(multiError.Matches) != 5 {
		t.Errorf("expected %v matches, got %v", 5, len(multiError.Matches))
	}
}
