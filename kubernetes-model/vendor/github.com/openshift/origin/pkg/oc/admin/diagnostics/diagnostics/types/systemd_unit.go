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
package types

// SystemdUnit represents the information we gather about a single systemd unit of interest.
type SystemdUnit struct {
	// The systemd unit name, e.g. "openshift-master"
	Name string
	// Whether it is present on the system at all
	Exists bool
	// Whether it is enabled (starts on its own at boot)
	Enabled bool
	// Whether it is currently started (and not crashed)
	Active bool
	// If it's not active, the exit code from its last execution
	ExitStatus int
}
