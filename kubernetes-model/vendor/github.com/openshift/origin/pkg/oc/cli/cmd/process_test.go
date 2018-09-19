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
package cmd

import (
	"fmt"
	"testing"

	templateapi "github.com/openshift/origin/pkg/template/apis/template"
)

func TestInjectUserVars(t *testing.T) {
	template := &templateapi.Template{
		Parameters: []templateapi.Parameter{
			{Name: "parameter_foo_bar_exist", Value: "value_foo_bar_exist_old"},
			{Name: "parameter_foo_bar_2", Value: "value_foo_bar_2"}},
	}
	oldParameterNum := len(template.Parameters)
	testParam := map[string]string{
		"parameter_foo_bar_exist":    "value_foo_bar_exist_new",
		"parameter_foo_bar_no_exist": "value_foo_bar_no_exist",
		"parameter_foo_bar_error":    "value_foo_bar_error=value_foo_bar_error",
	}

	errors := injectUserVars(testParam, template, false)
	if len(errors) != 2 {
		for index, err := range errors {
			fmt.Printf("errors[%d] : %v\n", index, err)
		}
		t.Errorf("expect invalid parameter and unknown parameter errors")
	}
	if len(template.Parameters) != oldParameterNum {
		t.Errorf("expect parameters num : %d", oldParameterNum)
	}
	if !(template.Parameters[0].Name == "parameter_foo_bar_exist" &&
		template.Parameters[0].Value == "value_foo_bar_exist_new") {
		t.Errorf("expect Name : %q Value : %q get Name : %q Value : %q",
			"parameter_foo_bar_exist", "value_foo_bar_exist_new", template.Parameters[0].Name, template.Parameters[0].Value)
	}
	if !(template.Parameters[1].Name == "parameter_foo_bar_2" &&
		template.Parameters[1].Value == "value_foo_bar_2") {
		t.Errorf("expect Name : %q Value : %q get Name : %q Value : %q",
			"parameter_foo_bar_2", "value_foo_bar_2", template.Parameters[1].Name, template.Parameters[1].Value)
	}
}
