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
package util

import (
	"io/ioutil"
	"os"
	"regexp"
	"strings"

	"k8s.io/apimachinery/pkg/runtime"
	"k8s.io/apimachinery/pkg/util/sets"
	kyaml "k8s.io/apimachinery/pkg/util/yaml"
	"k8s.io/kubernetes/pkg/api/legacyscheme"

	imageapi "github.com/openshift/origin/pkg/image/apis/image"
	templateapi "github.com/openshift/origin/pkg/template/apis/template"
)

const additionalAllowedRegistriesEnvVar = "ADDITIONAL_ALLOWED_REGISTRIES"

func GetTemplateFixture(filename string) (*templateapi.Template, error) {
	data, err := ioutil.ReadFile(filename)
	if err != nil {
		return nil, err
	}
	jsonData, err := kyaml.ToJSON(data)
	if err != nil {
		return nil, err
	}
	obj, err := runtime.Decode(legacyscheme.Codecs.UniversalDecoder(), jsonData)
	if err != nil {
		return nil, err
	}
	return obj.(*templateapi.Template), nil
}

func GetImageFixture(filename string) (*imageapi.Image, error) {
	data, err := ioutil.ReadFile(filename)
	if err != nil {
		return nil, err
	}
	jsonData, err := kyaml.ToJSON(data)
	if err != nil {
		return nil, err
	}
	obj, err := runtime.Decode(legacyscheme.Codecs.UniversalDecoder(), jsonData)
	if err != nil {
		return nil, err
	}
	return obj.(*imageapi.Image), nil
}

func SetAdditionalAllowedRegistries(hostPortGlobs ...string) {
	os.Setenv(additionalAllowedRegistriesEnvVar, strings.Join(hostPortGlobs, ","))
}

func AddAdditionalAllowedRegistries(hostPortGlobs ...string) {
	regs := GetAdditionalAllowedRegistries()
	regs.Insert(hostPortGlobs...)
	SetAdditionalAllowedRegistries(regs.List()...)
}

func GetAdditionalAllowedRegistries() sets.String {
	regs := sets.NewString()
	for _, r := range regexp.MustCompile(`[[:space:],]+`).Split(os.Getenv(additionalAllowedRegistriesEnvVar), -1) {
		if len(r) > 0 {
			regs.Insert(r)
		}
	}
	return regs
}
