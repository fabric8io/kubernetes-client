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
package api

import (
	"regexp"

	"k8s.io/apimachinery/pkg/api/validation"
	"k8s.io/apimachinery/pkg/util/validation/field"
)

func ValidateProvisionRequest(preq *ProvisionRequest) field.ErrorList {
	errors := ValidateUUID(field.NewPath("service_id"), preq.ServiceID)
	errors = append(errors, ValidateUUID(field.NewPath("plan_id"), preq.PlanID)...)

	if preq.Context.Platform == "" {
		errors = append(errors, field.Required(field.NewPath("context.platform"), ""))
	} else if preq.Context.Platform != ContextPlatformKubernetes {
		errors = append(errors, field.Invalid(field.NewPath("context.platform"), preq.Context.Platform, "must equal "+ContextPlatformKubernetes))
	}

	if preq.Context.Namespace == "" {
		errors = append(errors, field.Required(field.NewPath("context.namespace"), ""))
	} else {
		for _, msg := range validation.ValidateNamespaceName(preq.Context.Namespace, false) {
			errors = append(errors, field.Invalid(field.NewPath("context.namespace"), preq.Context.Namespace, msg))
		}
	}

	return errors
}

func ValidateBindRequest(breq *BindRequest) field.ErrorList {
	errors := ValidateUUID(field.NewPath("service_id"), breq.ServiceID)
	errors = append(errors, ValidateUUID(field.NewPath("plan_id"), breq.PlanID)...)

	return errors
}

var uuidRegex = regexp.MustCompile("^(?i)[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$")

func ValidateUUID(path *field.Path, uuid string) field.ErrorList {
	if uuidRegex.MatchString(uuid) {
		return nil
	}
	return field.ErrorList{field.Invalid(path, uuid, "must be a valid UUID")}
}
