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
package openshift

import (
	"fmt"

	"github.com/openshift/origin/pkg/oc/bootstrap/docker/errors"
)

// ErrOpenShiftFailedToStart is thrown when the OpenShift server failed to start
func ErrOpenShiftFailedToStart(container string) errors.Error {
	return errors.NewError("could not start OpenShift container %q", container)
}

// ErrTimedOutWaitingForStart is thrown when the OpenShift server can't be pinged after reasonable
// amount of time.
func ErrTimedOutWaitingForStart(container string) errors.Error {
	return errors.NewError("timed out waiting for OpenShift container %q", container)
}

type errPortsNotAvailable struct {
	ports []int
}

func (e *errPortsNotAvailable) Error() string {
	return fmt.Sprintf("ports in use: %v", e.ports)
}

func ErrPortsNotAvailable(ports []int) error {
	return &errPortsNotAvailable{
		ports: ports,
	}
}

func IsPortsNotAvailableErr(err error) bool {
	_, ok := err.(*errPortsNotAvailable)
	return ok
}

func UnavailablePorts(err error) []int {
	e, ok := err.(*errPortsNotAvailable)
	if !ok {
		return []int{}
	}
	return e.ports
}
