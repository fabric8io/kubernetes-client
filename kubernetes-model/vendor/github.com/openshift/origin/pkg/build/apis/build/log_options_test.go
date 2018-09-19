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
	"reflect"
	"testing"

	kapi "k8s.io/kubernetes/pkg/apis/core"
)

func TestLogOptionsDrift(t *testing.T) {
	popts := reflect.TypeOf(kapi.PodLogOptions{})
	bopts := reflect.TypeOf(BuildLogOptions{})

	for i := 0; i < popts.NumField(); i++ {
		// Verify name
		name := popts.Field(i).Name
		boptsField, found := bopts.FieldByName(name)
		if !found {
			t.Errorf("buildLogOptions drifting from podLogOptions! Field %q wasn't found!", name)
		}
		// Verify type
		if should, is := popts.Field(i).Type, boptsField.Type; is != should {
			t.Errorf("buildLogOptions drifting from podLogOptions! Field %q should be a %s but is %s!", name, should.String(), is.String())
		}
	}
}
