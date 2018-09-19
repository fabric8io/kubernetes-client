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
package image

import (
	"sort"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
)

type tag struct {
	Name    string
	Created metav1.Time
}

type byCreationTimestamp []tag

func (t byCreationTimestamp) Len() int {
	return len(t)
}

func (t byCreationTimestamp) Less(i, j int) bool {
	return t[i].Created.Time.After(t[j].Created.Time)
}

func (t byCreationTimestamp) Swap(i, j int) {
	t[i], t[j] = t[j], t[i]
}

// SortStatusTags sorts the status tags of an image stream based on
// the latest created
func SortStatusTags(tags map[string]TagEventList) []string {
	tagSlice := make([]tag, len(tags))
	index := 0
	for tag, list := range tags {
		tagSlice[index].Name = tag
		if len(list.Items) > 0 {
			tagSlice[index].Created = list.Items[0].Created
		}
		index++
	}

	sort.Sort(byCreationTimestamp(tagSlice))

	actual := make([]string, len(tagSlice))
	for i, tag := range tagSlice {
		actual[i] = tag.Name
	}

	return actual
}
