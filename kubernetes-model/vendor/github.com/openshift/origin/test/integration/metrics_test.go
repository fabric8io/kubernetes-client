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
package integration

import (
	"regexp"
	"testing"
	"time"

	"k8s.io/apimachinery/pkg/util/wait"

	testutil "github.com/openshift/origin/test/util"
	testserver "github.com/openshift/origin/test/util/server"
)

var metricsRegexp = regexp.MustCompile("(?m)^# HELP ([^ ]*)")

func TestMetrics(t *testing.T) {
	expectedMetrics := []string{
		"openshift_template_instance_total",
	}

	masterConfig, clusterAdminKubeConfig, err := testserver.StartTestMaster()
	if err != nil {
		t.Fatal(err)
	}
	defer testserver.CleanupMasterEtcd(t, masterConfig)

	clusterAdminClient, err := testutil.GetClusterAdminKubeClient(clusterAdminKubeConfig)
	if err != nil {
		t.Fatal(err)
	}

	var missingMetrics []string
	err = wait.Poll(time.Second, 30*time.Second, func() (bool, error) {
		missingMetrics = []string{}

		b, err := clusterAdminClient.Discovery().RESTClient().Get().RequestURI("/metrics").DoRaw()
		if err != nil {
			return false, err
		}

		metrics := map[string]struct{}{}
		for _, match := range metricsRegexp.FindAllStringSubmatch(string(b), -1) {
			metrics[match[1]] = struct{}{}
		}

		for _, metric := range expectedMetrics {
			if _, ok := metrics[metric]; !ok {
				missingMetrics = append(missingMetrics, metric)
			}
		}

		return len(missingMetrics) == 0, nil
	})
	if len(missingMetrics) > 0 {
		t.Error(missingMetrics)
	}
	if err != nil {
		t.Error(err)
	}
}
