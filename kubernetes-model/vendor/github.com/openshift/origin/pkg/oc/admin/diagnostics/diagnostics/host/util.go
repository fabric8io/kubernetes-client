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
package host

import (
	"fmt"

	configapi "github.com/openshift/origin/pkg/cmd/server/apis/config"
	configapilatest "github.com/openshift/origin/pkg/cmd/server/apis/config/latest"
	"github.com/openshift/origin/pkg/oc/admin/diagnostics/diagnostics/log"
)

// this would be bad practice if there were ever a need to load more than one master config for diagnostics.
// however we will proceed with the assumption that will never be necessary.
var (
	masterConfigLoaded    = false
	masterConfig          *configapi.MasterConfig
	masterConfigLoadError error
)

func GetMasterConfig(masterConfigFile string, logger *log.Logger) (*configapi.MasterConfig, error) {
	if masterConfigLoaded { // no need to do this more than once
		if masterConfigLoadError != nil {
			printMasterConfigLoadError(masterConfigFile, logger)
		}
		return masterConfig, masterConfigLoadError
	}
	logger.Debug("DH0001", fmt.Sprintf("Looking for master config file at '%s'", masterConfigFile))
	masterConfigLoaded = true
	masterConfig, masterConfigLoadError = configapilatest.ReadAndResolveMasterConfig(masterConfigFile)
	if masterConfigLoadError != nil {
		printMasterConfigLoadError(masterConfigFile, logger)
	} else {
		logger.Debug("DH0003", fmt.Sprintf("Found a master config file: %[1]s", masterConfigFile))
	}
	return masterConfig, masterConfigLoadError
}

func printMasterConfigLoadError(masterConfigFile string, logger *log.Logger) {
	logger.Error("DH0002", fmt.Sprintf("Could not read master config file '%s':\n(%T) %[2]v", masterConfigFile, masterConfigLoadError))
}
