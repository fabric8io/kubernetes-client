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

import (
	"fmt"

	"k8s.io/apimachinery/pkg/fields"
	runtime "k8s.io/apimachinery/pkg/runtime"
)

func BuildFieldSelector(obj runtime.Object, fieldSet fields.Set) error {
	build, ok := obj.(*Build)
	if !ok {
		return fmt.Errorf("%T not a Build", obj)
	}
	fieldSet["status"] = string(build.Status.Phase)
	fieldSet["podName"] = GetBuildPodName(build)

	return nil
}
