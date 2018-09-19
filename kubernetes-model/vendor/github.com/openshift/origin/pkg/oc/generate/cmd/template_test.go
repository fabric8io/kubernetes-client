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
	"testing"

	templateapi "github.com/openshift/origin/pkg/template/apis/template"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
)

func TestTransformTemplate(t *testing.T) {
	templatefoobar := &templateapi.Template{
		ObjectMeta: metav1.ObjectMeta{
			Name:      "foo_bar_template_name",
			Namespace: "foo_bar_namespace",
		},
		Parameters: []templateapi.Parameter{
			{Name: "parameter_foo_bar_exist", Value: "value_foo_bar_exist_old"},
			{Name: "parameter_foo_bar_2", Value: "value_foo_bar_2"}},
	}
	oldParameterNum := len(templatefoobar.Parameters)
	testParamMap := map[string]string{}
	testParamMap["parameter_foo_bar_exist"] = "value_foo_bar_exist_new"

	template, err := TransformTemplate(templatefoobar, fakeTemplateProcessor{}, "foo_bar_namespace", testParamMap, false)
	if err != nil {
		t.Errorf("unexpect err : %v", err)
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

type fakeTemplateProcessor struct {
}

func (fakeTemplateProcessor) Process(in *templateapi.Template) (*templateapi.Template, error) {
	return in, nil
}
