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
package extended

import (
	"testing"

	_ "k8s.io/kubernetes/test/e2e"

	_ "github.com/openshift/origin/test/extended/builds"
	_ "github.com/openshift/origin/test/extended/cli"
	_ "github.com/openshift/origin/test/extended/cluster"
	_ "github.com/openshift/origin/test/extended/deployments"
	_ "github.com/openshift/origin/test/extended/dns"
	_ "github.com/openshift/origin/test/extended/idling"
	_ "github.com/openshift/origin/test/extended/image_ecosystem"
	_ "github.com/openshift/origin/test/extended/imageapis"
	_ "github.com/openshift/origin/test/extended/images"
	_ "github.com/openshift/origin/test/extended/images/trigger"
	_ "github.com/openshift/origin/test/extended/jobs"
	_ "github.com/openshift/origin/test/extended/localquota"
	_ "github.com/openshift/origin/test/extended/networking"
	_ "github.com/openshift/origin/test/extended/prometheus"
	_ "github.com/openshift/origin/test/extended/router"
	_ "github.com/openshift/origin/test/extended/security"
	_ "github.com/openshift/origin/test/extended/templates"

	exutil "github.com/openshift/origin/test/extended/util"
)

// init initialize the extended testing suite.
func init() {
	exutil.InitTest()
}

func TestExtended(t *testing.T) {
	exutil.ExecuteTest(t, "Extended")
}
