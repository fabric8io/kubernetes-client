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
package flagtypes

import (
	"flag"

	"github.com/golang/glog"
	"github.com/spf13/pflag"
)

// GLog binds the log flags from the default Google "flag" package into a pflag.FlagSet.
func GLog(flags *pflag.FlagSet) {
	from := flag.CommandLine
	if flag := from.Lookup("v"); flag != nil {
		level := flag.Value.(*glog.Level)
		levelPtr := (*int32)(level)
		flags.Int32Var(levelPtr, "loglevel", 0, "Set the level of log output (0-10)")
		if flags.Lookup("v") == nil {
			flags.Int32Var(levelPtr, "v", 0, "Set the level of log output (0-10)")
		}
		flags.Lookup("v").Hidden = true
	}
	if flag := from.Lookup("vmodule"); flag != nil {
		value := flag.Value
		flags.Var(pflagValue{value}, "logspec", "Set per module logging with file|pattern=LEVEL,...")
		if flags.Lookup("vmodule") == nil {
			flags.Var(pflagValue{value}, "vmodule", "Set per module logging with file|pattern=LEVEL,...")
		}
		flags.Lookup("vmodule").Hidden = true
	}
}

type pflagValue struct {
	flag.Value
}

func (pflagValue) Type() string {
	return "string"
}
