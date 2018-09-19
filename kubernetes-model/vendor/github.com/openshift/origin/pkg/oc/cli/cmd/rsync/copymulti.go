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
package rsync

import (
	"bytes"
	"fmt"
	"io"
	"strings"

	"github.com/golang/glog"
	"k8s.io/apimachinery/pkg/util/errors"
)

// copyStrategies is an ordered list of copyStrategy objects that behaves as a single
// strategy. If a strategy fails with a setup error, it continues on to the next strategy.
type copyStrategies []copyStrategy

// ensure copyStrategies implements the copyStrategy interface
var _ copyStrategy = copyStrategies{}

// Copy will call copy for strategies in list order. If a strategySetupError results from a copy,
// the next strategy will be attempted. Otherwise the error is returned.
func (ss copyStrategies) Copy(source, destination *pathSpec, out, errOut io.Writer) error {
	var err error
	foundStrategy := false

	for _, s := range ss {
		errBuf := &bytes.Buffer{}
		err = s.Copy(source, destination, out, errBuf)
		if _, isSetupError := err.(strategySetupError); isSetupError {
			glog.V(4).Infof("Error output:\n%s", errBuf.String())
			fmt.Fprintf(errOut, "WARNING: cannot use %s: %v\n", s.String(), err.Error())
			continue
		}

		io.Copy(errOut, errBuf)
		foundStrategy = true
		break
	}

	if !foundStrategy {
		err = strategySetupError("No available strategies to copy.")
	}

	return err
}

// Validate will call Validate on all strategies and return an aggregate of their errors
func (ss copyStrategies) Validate() error {
	var errs []error
	for _, s := range ss {
		err := s.Validate()
		if err != nil {
			errs = append(errs, fmt.Errorf("invalid %v strategy: %v", s, err))
		}
	}
	return errors.NewAggregate(errs)
}

// String will return a comma-separated list of strategy names
func (ss copyStrategies) String() string {
	names := []string{}
	for _, s := range ss {
		names = append(names, s.String())
	}
	return strings.Join(names, ",")
}

// strategySetupError is an error that occurred while setting up a strategy
// (as opposed to actually executing a copy and getting an error from normal copy execution)
type strategySetupError string

func (e strategySetupError) Error() string { return string(e) }
