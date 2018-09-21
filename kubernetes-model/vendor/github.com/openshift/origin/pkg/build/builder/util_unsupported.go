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
// +build !linux

package builder

import (
	"errors"

	s2iapi "github.com/openshift/source-to-image/pkg/api"
)

// getContainerNetworkConfig determines whether the builder is running as a container
// by examining /proc/self/cgroup. This context is then passed to source-to-image.
// It returns a suitable argument for NetworkMode.  If the container platform is
// CRI-O, it also returns a path for /etc/resolv.conf, suitable for bindmounting.
func getContainerNetworkConfig() (string, string, error) {
	return "", "", errors.New("getContainerNetworkConfig is unsupported on this platform")
}

// GetCGroupLimits returns a struct populated with cgroup limit values gathered
// from the local /sys/fs/cgroup filesystem.  Overflow values are set to
// math.MaxInt64.
func GetCGroupLimits() (*s2iapi.CGroupLimits, error) {
	return nil, errors.New("GetCGroupLimits is unsupported on this platform")
}

// getCgroupParent determines the parent cgroup for a container from
// within that container.
func getCgroupParent() (string, error) {
	return "", errors.New("getCgroupParent is unsupported on this platform")
}
