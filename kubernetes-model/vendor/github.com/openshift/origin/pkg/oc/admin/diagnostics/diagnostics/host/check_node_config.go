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
	"errors"
	"fmt"

	configapilatest "github.com/openshift/origin/pkg/cmd/server/apis/config/latest"
	configvalidation "github.com/openshift/origin/pkg/cmd/server/apis/config/validation"
	"github.com/openshift/origin/pkg/oc/admin/diagnostics/diagnostics/types"
)

// NodeConfigCheck is a Diagnostic to check that the node config file is valid
type NodeConfigCheck struct {
	NodeConfigFile string
}

const NodeConfigCheckName = "NodeConfigCheck"

func (d NodeConfigCheck) Name() string {
	return NodeConfigCheckName
}

func (d NodeConfigCheck) Description() string {
	return "Check the node config file"
}

func (d NodeConfigCheck) Requirements() (client bool, host bool) {
	return false, true
}

func (d NodeConfigCheck) CanRun() (bool, error) {
	if len(d.NodeConfigFile) == 0 {
		return false, errors.New("No node config file was detected")
	}

	return true, nil
}

func (d NodeConfigCheck) Check() types.DiagnosticResult {
	r := types.NewDiagnosticResult(NodeConfigCheckName)
	r.Debug("DH1001", fmt.Sprintf("Looking for node config file at '%s'", d.NodeConfigFile))
	nodeConfig, err := configapilatest.ReadAndResolveNodeConfig(d.NodeConfigFile)
	if err != nil {
		r.Error("DH1002", err, fmt.Sprintf("Could not read node config file '%s':\n(%T) %[2]v", d.NodeConfigFile, err))
		return r
	}

	r.Info("DH1003", fmt.Sprintf("Found a node config file: %[1]s", d.NodeConfigFile))

	results := configvalidation.ValidateNodeConfig(nodeConfig, nil)
	if len(results.Errors) > 0 {
		errText := fmt.Sprintf("Validation of node config file '%s' failed:\n", d.NodeConfigFile)
		for _, err := range results.Errors {
			errText += fmt.Sprintf("%v\n", err)
		}
		r.Error("DH1004", nil, errText)
	}
	if len(results.Warnings) > 0 {
		warnText := fmt.Sprintf("Validation of node config file '%s' warned:\n", d.NodeConfigFile)
		for _, warn := range results.Warnings {
			warnText += fmt.Sprintf("%v\n", warn)
		}
		r.Warn("DH1005", nil, warnText)
	}
	return r
}
