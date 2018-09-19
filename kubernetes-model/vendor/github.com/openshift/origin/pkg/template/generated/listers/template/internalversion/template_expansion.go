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
	templateapi "github.com/openshift/origin/pkg/template/apis/template"
	"k8s.io/apimachinery/pkg/api/errors"
)

// TemplateListerExpansion allows custom methods to be added to
// TemplateLister.
type TemplateListerExpansion interface {
	GetByUID(uid string) (*templateapi.Template, error)
}

// TemplateNamespaceListerExpansion allows custom methods to be added to
// TemplateNamespaceLister.
type TemplateNamespaceListerExpansion interface{}

func (s templateLister) GetByUID(uid string) (*templateapi.Template, error) {
	templates, err := s.indexer.ByIndex(templateapi.TemplateUIDIndex, uid)
	if err != nil {
		return nil, err
	}
	if len(templates) == 0 {
		return nil, errors.NewNotFound(templateapi.Resource("template"), uid)
	}
	return templates[0].(*templateapi.Template), nil
}
