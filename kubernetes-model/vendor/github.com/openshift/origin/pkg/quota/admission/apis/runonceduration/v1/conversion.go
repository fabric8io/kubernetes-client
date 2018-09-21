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
package v1

import (
	"k8s.io/apimachinery/pkg/conversion"
	"k8s.io/apimachinery/pkg/runtime"

	internal "github.com/openshift/origin/pkg/quota/admission/apis/runonceduration"
)

func addConversionFuncs(scheme *runtime.Scheme) error {
	return scheme.AddConversionFuncs(
		func(in *RunOnceDurationConfig, out *internal.RunOnceDurationConfig, s conversion.Scope) error {
			out.ActiveDeadlineSecondsLimit = in.ActiveDeadlineSecondsOverride
			return nil
		},
		func(in *internal.RunOnceDurationConfig, out *RunOnceDurationConfig, s conversion.Scope) error {
			out.ActiveDeadlineSecondsOverride = in.ActiveDeadlineSecondsLimit
			return nil
		},
	)
}
