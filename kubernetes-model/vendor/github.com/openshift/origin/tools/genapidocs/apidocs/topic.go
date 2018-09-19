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
package apidocs

import (
	"path/filepath"
	"sort"
	"strings"
)

// Topic represents an asciibinder topic
type Topic struct {
	Name    string  `yaml:"Name"`
	File    string  `yaml:"File,omitempty"`
	Dir     string  `yaml:"Dir,omitempty"`
	Distros string  `yaml:"Distros,omitempty"`
	Topics  []Topic `yaml:"Topics,omitempty"`
}

func BuildTopics(pages Pages) []Topic {
	m := make(map[string]Topic)

	for _, page := range pages {
		path := page.OutputPath()

		parentName := page.ParentTopicName()
		parent, found := m[parentName]
		if !found {
			parent = Topic{
				Name: parentName,
				Dir:  filepath.Base(filepath.Dir(path)),
			}
		}

		child := Topic{
			Name: page.Title(),
			File: strings.TrimSuffix(filepath.Base(path), ".adoc"),
		}
		parent.Topics = append(parent.Topics, child)

		m[parentName] = parent
	}

	parents := make([]Topic, 0, len(m))
	for _, parent := range m {
		sort.Sort(childTopicsByName(parent.Topics))
		parents = append(parents, parent)
	}
	sort.Sort(parentTopicsByVersion(parents))
	sort.Stable(parentTopicsByGroup(parents))
	sort.Stable(parentTopicsByRoot(parents))

	return parents
}
