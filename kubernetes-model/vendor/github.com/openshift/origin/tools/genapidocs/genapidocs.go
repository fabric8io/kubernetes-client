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
	"fmt"
	"io/ioutil"
	"os"
	"path/filepath"

	yaml "gopkg.in/yaml.v2"

	"github.com/go-openapi/loads"
	"github.com/openshift/origin/tools/genapidocs/apidocs"
)

func writeAPIDocs(root string) error {
	err := os.RemoveAll(root)
	if err != nil {
		return err
	}

	doc, err := loads.JSONSpec("api/swagger-spec/openshift-openapi-spec.json")
	if err != nil {
		return err
	}

	pages, err := apidocs.BuildPages(doc.Spec())
	if err != nil {
		return err
	}

	err = pages.Write(root)
	if err != nil {
		return err
	}

	topics := apidocs.BuildTopics(pages)

	b, err := yaml.Marshal(topics)
	if err != nil {
		return err
	}

	return ioutil.WriteFile(filepath.Join(root, "_topic_map.yml"), b, 0666)
}

func main() {
	if len(os.Args) != 2 {
		fmt.Fprintf(os.Stderr, "%s: usage: %[1]s root\n", os.Args[0])
		os.Exit(1)
	}
	err := writeAPIDocs(os.Args[1])
	if err != nil {
		fmt.Fprintf(os.Stderr, "%s: %s\n", os.Args[0], err)
		os.Exit(1)
	}
}
