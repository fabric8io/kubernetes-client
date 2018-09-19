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
package internalversion

import (
	"k8s.io/client-go/rest"

	templateapi "github.com/openshift/origin/pkg/template/apis/template"
)

// TemplateConfigInterface is an interface for processing template client.
type TemplateProcessorInterface interface {
	Process(*templateapi.Template) (*templateapi.Template, error)
}

// NewTemplateProcessorClient returns a client capable of processing the templates.
func NewTemplateProcessorClient(c rest.Interface, ns string) TemplateProcessorInterface {
	return &templateProcessor{client: c, ns: ns}
}

type templateProcessor struct {
	client rest.Interface
	ns     string
}

// Process takes an unprocessed template and returns a processed
// template with all parameters substituted.
func (c *templateProcessor) Process(in *templateapi.Template) (*templateapi.Template, error) {
	template := &templateapi.Template{}
	err := c.client.Post().
		Namespace(c.ns).
		Resource("processedTemplates").
		Body(in).Do().Into(template)
	return template, err
}
