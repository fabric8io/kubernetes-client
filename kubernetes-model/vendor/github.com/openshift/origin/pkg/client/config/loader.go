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
package config

import (
	"os"
	"path"
	"path/filepath"
	"runtime"

	"k8s.io/client-go/tools/clientcmd"
	"k8s.io/client-go/util/homedir"
)

const (
	OpenShiftConfigPathEnvVar      = "KUBECONFIG"
	OpenShiftConfigFlagName        = "config"
	OpenShiftConfigHomeDir         = ".kube"
	OpenShiftConfigHomeFileName    = "config"
	OpenShiftConfigHomeDirFileName = OpenShiftConfigHomeDir + "/" + OpenShiftConfigHomeFileName
)

var RecommendedHomeFile = path.Join(homedir.HomeDir(), OpenShiftConfigHomeDirFileName)

// currentMigrationRules returns a map that holds the history of recommended home directories used in previous versions.
// Any future changes to RecommendedHomeFile and related are expected to add a migration rule here, in order to make
// sure existing config files are migrated to their new locations properly.
func CurrentMigrationRules() map[string]string {
	oldRecommendedHomeFile := path.Join(homedir.HomeDir(), ".kube/.config")
	oldRecommendedWindowsHomeFile := path.Join(os.Getenv("HOME"), OpenShiftConfigHomeDirFileName)

	migrationRules := map[string]string{}
	migrationRules[RecommendedHomeFile] = oldRecommendedHomeFile
	if runtime.GOOS == "windows" {
		migrationRules[RecommendedHomeFile] = oldRecommendedWindowsHomeFile
	}
	return migrationRules
}

// NewOpenShiftClientConfigLoadingRules returns file priority loading rules for OpenShift.
// 1. --config value
// 2. if KUBECONFIG env var has a value, use it. Otherwise, ~/.kube/config file
func NewOpenShiftClientConfigLoadingRules() *clientcmd.ClientConfigLoadingRules {
	chain := []string{}

	envVarFile := os.Getenv(OpenShiftConfigPathEnvVar)
	if len(envVarFile) != 0 {
		chain = append(chain, filepath.SplitList(envVarFile)...)
	} else {
		chain = append(chain, RecommendedHomeFile)
	}

	return &clientcmd.ClientConfigLoadingRules{
		Precedence:     chain,
		MigrationRules: CurrentMigrationRules(),
	}
}
