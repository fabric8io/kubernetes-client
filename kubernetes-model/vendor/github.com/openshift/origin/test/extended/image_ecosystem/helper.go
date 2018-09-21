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
package image_ecosystem

import (
	"fmt"
	"strings"
	"time"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/labels"

	g "github.com/onsi/ginkgo"

	exutil "github.com/openshift/origin/test/extended/util"
)

// RunInPodContainer will run provided command in the specified pod container.
func RunInPodContainer(oc *exutil.CLI, selector labels.Selector, cmd []string) error {
	pods, err := exutil.WaitForPods(oc.KubeClient().CoreV1().Pods(oc.Namespace()), selector, exutil.CheckPodIsRunningFn, 1, 4*time.Minute)
	if err != nil {
		return err
	}
	if len(pods) != 1 {
		return fmt.Errorf("Got %d pods for selector %v, expected 1", len(pods), selector)
	}

	pod, err := oc.KubeClient().CoreV1().Pods(oc.Namespace()).Get(pods[0], metav1.GetOptions{})
	if err != nil {
		return err
	}
	args := []string{pod.Name, "-c", pod.Spec.Containers[0].Name, "--"}
	args = append(args, cmd...)
	output, err := oc.Run("exec").Args(args...).Output()
	if err == nil {
		fmt.Fprintf(g.GinkgoWriter, "RunInPodContainer exec output: %s\n", output)
	}
	return err
}

// CheckPageContains makes a http request for an example application and checks
// that the result contains given string
func CheckPageContains(oc *exutil.CLI, endpoint, path, contents string) (bool, error) {
	address, err := exutil.GetEndpointAddress(oc, endpoint)
	if err != nil {
		return false, err
	}

	response, err := exutil.FetchURL(fmt.Sprintf("http://%s/%s", address, path), 3*time.Minute)
	if err != nil {
		return false, err
	}
	success := strings.Contains(response, contents)
	if !success {
		fmt.Fprintf(g.GinkgoWriter, "CheckPageContains was looking for %s but got %s\n", contents, response)
	}
	return success, nil
}

func cleanup(oc *exutil.CLI) {
	if err := exutil.CleanupHostPathVolumes(oc.AdminKubeClient().Core().PersistentVolumes(), oc.Namespace()); err != nil {
		ginkgolog("WARNING: couldn't cleanup persistent volumes: %v", err)
	}
}
