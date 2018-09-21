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
package importer

import (
	"github.com/hashicorp/golang-lru"
)

const (
	DefaultImageStreamLayerCacheSize = 2048
)

type ImageStreamLayerCache struct {
	*lru.Cache
}

// ImageStreamLayerCache creates a new LRU cache of layer digests
func NewImageStreamLayerCache(size int) (ImageStreamLayerCache, error) {
	c, err := lru.New(size)
	if err != nil {
		return ImageStreamLayerCache{}, err
	}
	return ImageStreamLayerCache{
		Cache: c,
	}, nil
}
