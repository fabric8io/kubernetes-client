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
	g "github.com/onsi/ginkgo"
	o "github.com/onsi/gomega"

	exutil "github.com/openshift/origin/test/extended/util"
)

var _ = g.Describe("[Feature:Builds] buildconfig secret injector", func() {
	defer g.GinkgoRecover()

	var (
		itemsPath = exutil.FixturePath("testdata", "builds", "test-buildconfigsecretinjector.yaml")
		oc        = exutil.NewCLI("buildconfigsecretinjector", exutil.KubeConfigPath())
	)

	g.Context("", func() {
		g.BeforeEach(func() {
			exutil.DumpDockerInfo()
		})

		g.JustBeforeEach(func() {
			g.By("creating buildconfigs")
			err := oc.Run("create").Args("-f", itemsPath).Execute()
			o.Expect(err).NotTo(o.HaveOccurred())
		})

		g.AfterEach(func() {
			if g.CurrentGinkgoTestDescription().Failed {
				exutil.DumpPodStates(oc)
				exutil.DumpPodLogsStartingWith("", oc)
			}
		})

		g.It("should inject secrets to the appropriate buildconfigs", func() {
			out, err := oc.Run("get").Args("bc/test1", "-o", "template", "--template", "{{.spec.source.sourceSecret.name}}").Output()
			o.Expect(err).NotTo(o.HaveOccurred())
			o.Expect(out).To(o.Equal("secret1"))

			out, err = oc.Run("get").Args("bc/test2", "-o", "template", "--template", "{{.spec.source.sourceSecret.name}}").Output()
			o.Expect(err).NotTo(o.HaveOccurred())
			o.Expect(out).To(o.Equal("secret2"))

			out, err = oc.Run("get").Args("bc/test3", "-o", "template", "--template", "{{.spec.source.sourceSecret.name}}").Output()
			o.Expect(err).NotTo(o.HaveOccurred())
			o.Expect(out).To(o.Equal("secret3"))

			out, err = oc.Run("get").Args("bc/test4", "-o", "template", "--template", "{{.spec.source.sourceSecret.name}}").Output()
			o.Expect(err).NotTo(o.HaveOccurred())
			o.Expect(out).To(o.Equal("<no value>"))
		})
	})
})
