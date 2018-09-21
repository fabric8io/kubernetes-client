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
	"fmt"

	"k8s.io/apimachinery/pkg/types"
	kerrors "k8s.io/apimachinery/pkg/util/errors"
	kprinters "k8s.io/kubernetes/pkg/printers"
)

type SchedulableOptions struct {
	Options *NodeOptions

	Schedulable bool
}

func (s *SchedulableOptions) Run() error {
	nodes, err := s.Options.GetNodes()
	if err != nil {
		return err
	}

	errList := []error{}
	var printer kprinters.ResourcePrinter
	unschedulable := !s.Schedulable
	for _, node := range nodes {
		if node.Spec.Unschedulable != unschedulable {
			patch := fmt.Sprintf(`{"spec":{"unschedulable":%t}}`, unschedulable)
			node, err = s.Options.KubeClient.Core().Nodes().Patch(node.Name, types.MergePatchType, []byte(patch))
			if err != nil {
				errList = append(errList, err)
				continue
			}
		}

		if printer == nil {
			p, err := s.Options.GetPrintersByObject(node)
			if err != nil {
				return err
			}
			printer = p
		}

		printer.PrintObj(node, s.Options.Writer)
	}
	return kerrors.NewAggregate(errList)
}
