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
package build

import (
	"sort"
	"testing"
	"time"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
)

func TestSortBuildSliceByCreationTimestamp(t *testing.T) {
	present := metav1.Now()
	past := metav1.NewTime(present.Add(-time.Minute))
	builds := []Build{
		{
			ObjectMeta: metav1.ObjectMeta{
				Name:              "present",
				CreationTimestamp: present,
			},
		},
		{
			ObjectMeta: metav1.ObjectMeta{
				Name:              "past",
				CreationTimestamp: past,
			},
		},
	}
	sort.Sort(BuildSliceByCreationTimestamp(builds))
	if [2]string{builds[0].Name, builds[1].Name} != [2]string{"past", "present"} {
		t.Errorf("Unexpected sort order")
	}
}

func TestSortBuildPtrSliceByCreationTimestamp(t *testing.T) {
	present := metav1.Now()
	past := metav1.NewTime(present.Add(-time.Minute))
	builds := []*Build{
		{
			ObjectMeta: metav1.ObjectMeta{
				Name:              "present",
				CreationTimestamp: present,
			},
		},
		{
			ObjectMeta: metav1.ObjectMeta{
				Name:              "past",
				CreationTimestamp: past,
			},
		},
	}
	sort.Sort(BuildPtrSliceByCreationTimestamp(builds))
	if [2]string{builds[0].Name, builds[1].Name} != [2]string{"past", "present"} {
		t.Errorf("Unexpected sort order")
	}
}
