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

// BuildSliceByCreationTimestamp implements sort.Interface for []Build
// based on the CreationTimestamp field.
type BuildSliceByCreationTimestamp []Build

func (b BuildSliceByCreationTimestamp) Len() int {
	return len(b)
}

func (b BuildSliceByCreationTimestamp) Less(i, j int) bool {
	return b[i].CreationTimestamp.Before(&b[j].CreationTimestamp)
}

func (b BuildSliceByCreationTimestamp) Swap(i, j int) {
	b[i], b[j] = b[j], b[i]
}

// BuildPtrSliceByCreationTimestamp implements sort.Interface for []*Build
// based on the CreationTimestamp field.
type BuildPtrSliceByCreationTimestamp []*Build

func (b BuildPtrSliceByCreationTimestamp) Len() int {
	return len(b)
}

func (b BuildPtrSliceByCreationTimestamp) Less(i, j int) bool {
	return b[i].CreationTimestamp.Before(&b[j].CreationTimestamp)
}

func (b BuildPtrSliceByCreationTimestamp) Swap(i, j int) {
	b[i], b[j] = b[j], b[i]
}
