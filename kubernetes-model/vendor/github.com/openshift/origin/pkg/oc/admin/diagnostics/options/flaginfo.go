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
package options

import (
	"strconv"

	"github.com/spf13/pflag"
	kclientcmd "k8s.io/client-go/tools/clientcmd"
)

// FlagInfos serve as a customizable intermediary between the command flags and
// the options object they feed into. This enables reuse of the flags and options
// with tweaked definitions in different contexts if necessary.
// The kube type is reused to add binding methods.
type FlagInfo kclientcmd.FlagInfo

// kube method
func (i FlagInfo) BindStringFlag(flags *pflag.FlagSet, target *string) {
	kclientcmd.FlagInfo(i).BindStringFlag(flags, target)
}

// kube method
func (i FlagInfo) BindBoolFlag(flags *pflag.FlagSet, target *bool) {
	kclientcmd.FlagInfo(i).BindBoolFlag(flags, target)
}

// BindIntFlag binds a flag that expects an integer value.
func (i FlagInfo) BindIntFlag(flags *pflag.FlagSet, target *int) {
	// assume flags with no longname are not desired
	if len(i.LongName) > 0 {
		// try to parse Default as an int.  If it fails, assume 0
		intVal, _ := strconv.ParseInt(i.Default, 10, 0)
		flags.IntVarP(target, i.LongName, i.ShortName, int(intVal), i.Description)
	}
}

// BindListFlag binds a flag that expects a kube list value. Note that if the target
// comes pre-populated, that list is not erased; anything the user puts in the flag
// is added on. This is probably a bug in k8s impl of StringList.
func (i FlagInfo) BindListFlag(flags *pflag.FlagSet, target *[]string) {
	// assume flags with no longname are not desired
	if len(i.LongName) > 0 {
		flags.StringSliceVarP(target, i.LongName, i.ShortName, *target, i.Description)
	}
}

// Constants for names of flags on the command (if not k8s flags).
const (
	FlagMasterConfigName        = "master-config"
	FlagNodeConfigName          = "node-config"
	FlagClusterContextName      = "cluster-context"
	FlagLevelName               = "diaglevel"
	FlagIsHostName              = "host"
	FlagPreventModificationName = "prevent-modification"
)
