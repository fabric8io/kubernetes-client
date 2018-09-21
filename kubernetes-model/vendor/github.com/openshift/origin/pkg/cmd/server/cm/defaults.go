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
package cm

import (
	"github.com/spf13/pflag"

	kcmapp "k8s.io/kubernetes/cmd/kube-controller-manager/app"
	kcmoptions "k8s.io/kubernetes/cmd/kube-controller-manager/app/options"
)

var (
	// default to the same controllers as upstream
	ControllersDisabledByDefault = kcmapp.ControllersDisabledByDefault
)

func OriginControllerManagerAddFlags(cmserver *kcmoptions.CMServer) func(flags *pflag.FlagSet) {
	return func(flags *pflag.FlagSet) {
		cmserver.AddFlags(flags, kcmapp.KnownControllers(), ControllersDisabledByDefault.List())
	}
}
