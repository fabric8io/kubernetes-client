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

	"github.com/openshift/api/security/v1"
	securityapi "github.com/openshift/origin/pkg/security/apis/security"
)

func addConversionFuncs(scheme *runtime.Scheme) error {
	err := scheme.AddConversionFuncs(
		Convert_v1_SecurityContextConstraints_To_security_SecurityContextConstraints,
		Convert_security_SecurityContextConstraints_To_v1_SecurityContextConstraints,
	)
	if err != nil {
		return err
	}

	return nil
}

func Convert_v1_SecurityContextConstraints_To_security_SecurityContextConstraints(in *v1.SecurityContextConstraints, out *securityapi.SecurityContextConstraints, s conversion.Scope) error {
	return autoConvert_v1_SecurityContextConstraints_To_security_SecurityContextConstraints(in, out, s)
}

func Convert_security_SecurityContextConstraints_To_v1_SecurityContextConstraints(in *securityapi.SecurityContextConstraints, out *v1.SecurityContextConstraints, s conversion.Scope) error {
	if err := autoConvert_security_SecurityContextConstraints_To_v1_SecurityContextConstraints(in, out, s); err != nil {
		return err
	}

	if in.Volumes != nil {
		for _, v := range in.Volumes {
			// set the Allow* fields based on the existence in the volume slice
			switch v {
			case securityapi.FSTypeHostPath, securityapi.FSTypeAll:
				out.AllowHostDirVolumePlugin = true
			}
		}
	}
	return nil
}
