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
package main

import (
	"reflect"
	kustomize "sigs.k8s.io/kustomize/api/types"
)

type ApiVersion struct {
	List         bool
	GroupVersion string
	Plural       string
	Namespaced   bool
}

type Schema struct {
	Types []reflect.Type
	Name  string
	Paths map[reflect.Type]ApiVersion
}

var mappingOverrides = map[reflect.Type]string{
	reflect.TypeOf(kustomize.ObjectMeta{}): "#/components/schemas/io.k8s.apimachinery.pkg.apis.meta.v1.ObjectMeta",
}

func NewTypeSchema(types []reflect.Type, name string) Schema {
	return Schema{types, name, make(map[reflect.Type]ApiVersion)}
}

func NewPathSchema(paths map[reflect.Type]ApiVersion, name string) Schema {
	schema := Schema{make([]reflect.Type, 0), name, paths}
	for t := range paths {
		schema.Types = append(schema.Types, t)
	}
	return schema
}
