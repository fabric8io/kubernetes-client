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
package dockermachine

import (
	"errors"

	starterrors "github.com/openshift/origin/pkg/oc/bootstrap/docker/errors"
)

var (
	// ErrDockerMachineExists is returned if a Docker machine you are trying to create already exists
	ErrDockerMachineExists = errors.New("Docker machine exists")

	// ErrDockerMachineNotAvailable is returned if the docker-machine command is not available in the PATH
	ErrDockerMachineNotAvailable = errors.New("docker-machine not available")
)

// ErrDockerMachineExec is an error that occurred while executing the docker-machine command
func ErrDockerMachineExec(cmd string, cause error) error {
	return starterrors.NewError("failed to execute docker-machine %s", cmd).WithCause(cause)
}
