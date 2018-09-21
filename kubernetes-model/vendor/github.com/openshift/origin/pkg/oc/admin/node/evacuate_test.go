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
package node

import (
	"strconv"
	"testing"

	"github.com/spf13/cobra"
)

func TestEvacuateFlags(t *testing.T) {
	defaults := NewEvacuateOptions(nil)

	tests := map[string]struct {
		flagName   string
		defaultVal string
	}{
		"dry run": {
			flagName:   flagDryRun,
			defaultVal: strconv.FormatBool(defaults.DryRun),
		},
		"force": {
			flagName:   flagForce,
			defaultVal: strconv.FormatBool(defaults.Force),
		},
		"grace period": {
			flagName:   flagGracePeriod,
			defaultVal: strconv.FormatInt(defaults.GracePeriod, 10),
		},
	}

	cmd := NewCommandManageNode(nil, ManageNodeCommandName, ManageNodeCommandName, nil, nil)
	for _, v := range tests {
		testFlag(cmd, v.flagName, v.defaultVal, t)
	}
}

func testFlag(cmd *cobra.Command, flagName string, defaultVal string, t *testing.T) {
	f := cmd.Flag(flagName)
	if f == nil {
		t.Fatalf("expected flag %s to be registered but found none", flagName)
	}

	if f.DefValue != defaultVal {
		t.Errorf("expected default value of %s for %s but found %s", defaultVal, flagName, f.DefValue)
	}
}

func TestEvacOptionsGracePeriod(t *testing.T) {
	opts := &EvacuateOptions{
		GracePeriod: 999,
	}

	// ensure delete options are created correctly
	deleteOptions := opts.makeDeleteOptions()
	if deleteOptions == nil {
		t.Fatalf("nil delete options were created")
	}
	if deleteOptions.GracePeriodSeconds == nil {
		t.Fatalf("delete options did not contain grace period %v", deleteOptions)
	}
	if *deleteOptions.GracePeriodSeconds != opts.GracePeriod {
		t.Errorf("expected %d grace period but found %d", opts.GracePeriod, *deleteOptions.GracePeriodSeconds)
	}
}
