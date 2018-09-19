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
package builds

import (
	"fmt"

	g "github.com/onsi/ginkgo"
	o "github.com/onsi/gomega"

	exutil "github.com/openshift/origin/test/extended/util"
)

var _ = g.Describe("[Feature:Builds][pullsecret][Conformance] docker build using a pull secret", func() {
	defer g.GinkgoRecover()
	const (
		buildTestPod     = "build-test-pod"
		buildTestService = "build-test-svc"
	)

	var (
		buildFixture = exutil.FixturePath("testdata", "builds", "test-docker-build-pullsecret.json")
		oc           = exutil.NewCLI("docker-build-pullsecret", exutil.KubeConfigPath())
	)

	g.Context("", func() {

		g.BeforeEach(func() {
			exutil.DumpDockerInfo()
		})

		g.JustBeforeEach(func() {
			g.By("waiting for builder service account")
			err := exutil.WaitForBuilderAccount(oc.AdminKubeClient().Core().ServiceAccounts(oc.Namespace()))
			o.Expect(err).NotTo(o.HaveOccurred())
		})

		g.AfterEach(func() {
			if g.CurrentGinkgoTestDescription().Failed {
				exutil.DumpPodStates(oc)
				exutil.DumpPodLogsStartingWith("", oc)
			}
		})

		g.Describe("Building from a template", func() {
			g.It("should create a docker build that pulls using a secret run it", func() {
				oc.SetOutputDir(exutil.TestContext.OutputDir)

				g.By(fmt.Sprintf("calling oc create -f %q", buildFixture))
				err := oc.Run("create").Args("-f", buildFixture).Execute()
				o.Expect(err).NotTo(o.HaveOccurred())

				g.By("starting a build")
				br, err := exutil.StartBuildAndWait(oc, "docker-build")
				o.Expect(err).NotTo(o.HaveOccurred())
				br.AssertSuccess()

				g.By("starting a second build that pulls the image from the first build")
				br, err = exutil.StartBuildAndWait(oc, "docker-build-pull")
				o.Expect(err).NotTo(o.HaveOccurred())
				br.AssertSuccess()

			})
		})
	})
})
