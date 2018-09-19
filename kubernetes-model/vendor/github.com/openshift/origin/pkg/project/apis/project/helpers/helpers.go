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
package helpers

import (
	"fmt"

	oapi "github.com/openshift/origin/pkg/api"
	projectapi "github.com/openshift/origin/pkg/project/apis/project"
)

const displayNameOldAnnotation = "displayName"

// DisplayNameAndNameForProject returns a formatted string containing the name
// of the project and includes the display name if it differs.
func DisplayNameAndNameForProject(project *projectapi.Project) string {
	displayName := project.Annotations[oapi.OpenShiftDisplayName]
	if len(displayName) == 0 {
		displayName = project.Annotations[displayNameOldAnnotation]
	}
	if len(displayName) > 0 && displayName != project.Name {
		return fmt.Sprintf("%s (%s)", displayName, project.Name)
	}
	return project.Name
}
