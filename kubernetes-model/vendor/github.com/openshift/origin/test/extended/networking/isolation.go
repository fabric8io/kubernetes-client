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
package networking

import (
	e2e "k8s.io/kubernetes/test/e2e/framework"

	. "github.com/onsi/ginkgo"
	. "github.com/onsi/gomega"
)

var _ = Describe("[Area:Networking] network isolation", func() {
	InSingleTenantContext(func() {
		f1 := e2e.NewDefaultFramework("net-isolation1")
		f2 := e2e.NewDefaultFramework("net-isolation2")

		It("should allow communication between pods in different namespaces on the same node", func() {
			Expect(checkPodIsolation(f1, f2, SAME_NODE)).To(Succeed())
		})

		It("should allow communication between pods in different namespaces on different nodes", func() {
			Expect(checkPodIsolation(f1, f2, DIFFERENT_NODE)).To(Succeed())
		})
	})

	InMultiTenantContext(func() {
		f1 := e2e.NewDefaultFramework("net-isolation1")
		f2 := e2e.NewDefaultFramework("net-isolation2")

		It("should prevent communication between pods in different namespaces on the same node", func() {
			Expect(checkPodIsolation(f1, f2, SAME_NODE)).NotTo(Succeed())
		})

		It("should prevent communication between pods in different namespaces on different nodes", func() {
			Expect(checkPodIsolation(f1, f2, DIFFERENT_NODE)).NotTo(Succeed())
		})

		// The test framework doesn't allow us to easily make use of the actual "default"
		// namespace, so we test default namespace behavior by changing either f1's or
		// f2's NetNamespace to have VNID 0 instead. But this only works under the
		// multi-tenant plugin since the single-tenant one doesn't create NetNamespaces at
		// all (and so there's not really any point in even running these tests anyway).
		It("should allow communication from default to non-default namespace on the same node", func() {
			makeNamespaceGlobal(f2.Namespace)
			Expect(checkPodIsolation(f1, f2, SAME_NODE)).To(Succeed())
		})
		It("should allow communication from default to non-default namespace on a different node", func() {
			makeNamespaceGlobal(f2.Namespace)
			Expect(checkPodIsolation(f1, f2, DIFFERENT_NODE)).To(Succeed())
		})
		It("should allow communication from non-default to default namespace on the same node", func() {
			makeNamespaceGlobal(f1.Namespace)
			Expect(checkPodIsolation(f1, f2, SAME_NODE)).To(Succeed())
		})
		It("should allow communication from non-default to default namespace on a different node", func() {
			makeNamespaceGlobal(f1.Namespace)
			Expect(checkPodIsolation(f1, f2, DIFFERENT_NODE)).To(Succeed())
		})
	})
})
