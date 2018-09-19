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
package trigger

import (
	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/client-go/tools/cache"

	"github.com/openshift/origin/pkg/image/apis/image/v1/trigger"
)

type CacheEntry struct {
	Key       string
	Namespace string
	Triggers  []trigger.ObjectFieldTrigger
}

type Indexer interface {
	// Index takes the given pair of objects and turns it into a key and a value. The returned key
	// will be used to store the object. obj is set on adds and updates, old is set on deletes and updates.
	// Changed should be true if the triggers changed.  Operations is a list of actions that should be sent
	// to the reaction.
	Index(obj, old interface{}) (key string, entry *CacheEntry, change cache.DeltaType, err error)
}

// TagRetriever returns information about a tag, including whether it exists
// and the observed resource version of the object at the time the tag was loaded.
type TagRetriever interface {
	ImageStreamTag(namespace, name string) (ref string, rv int64, ok bool)
}

type ImageReactor interface {
	ImageChanged(obj runtime.Object, tagRetriever TagRetriever) error
}
