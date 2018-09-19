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
package storage

import (
	"github.com/docker/distribution/context"
	"github.com/docker/distribution/registry/storage/driver"
)

// Exists provides a utility method to test whether or not a path exists in
// the given driver.
func exists(ctx context.Context, drv driver.StorageDriver, path string) (bool, error) {
	if _, err := drv.Stat(ctx, path); err != nil {
		switch err := err.(type) {
		case driver.PathNotFoundError:
			return false, nil
		default:
			return false, err
		}
	}

	return true, nil
}
