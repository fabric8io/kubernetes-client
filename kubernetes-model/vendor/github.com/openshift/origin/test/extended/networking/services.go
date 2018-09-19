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

var _ = Describe("[Area:Networking] services", func() {
	Context("basic functionality", func() {
		f1 := e2e.NewDefaultFramework("net-services1")

		It("should allow connections to another pod on the same node via a service IP", func() {
			Expect(checkServiceConnectivity(f1, f1, SAME_NODE)).To(Succeed())
		})

		It("should allow connections to another pod on a different node via a service IP", func() {
			Expect(checkServiceConnectivity(f1, f1, DIFFERENT_NODE)).To(Succeed())
		})
	})

	InSingleTenantContext(func() {
		f1 := e2e.NewDefaultFramework("net-services1")
		f2 := e2e.NewDefaultFramework("net-services2")

		It("should allow connections to pods in different namespaces on the same node via service IPs", func() {
			Expect(checkServiceConnectivity(f1, f2, SAME_NODE)).To(Succeed())
		})

		It("should allow connections to pods in different namespaces on different nodes via service IPs", func() {
			Expect(checkServiceConnectivity(f1, f2, DIFFERENT_NODE)).To(Succeed())
		})
	})

	InMultiTenantContext(func() {
		f1 := e2e.NewDefaultFramework("net-services1")
		f2 := e2e.NewDefaultFramework("net-services2")

		It("should prevent connections to pods in different namespaces on the same node via service IPs", func() {
			Expect(checkServiceConnectivity(f1, f2, SAME_NODE)).NotTo(Succeed())
		})

		It("should prevent connections to pods in different namespaces on different nodes via service IPs", func() {
			Expect(checkServiceConnectivity(f1, f2, DIFFERENT_NODE)).NotTo(Succeed())
		})

		It("should allow connections to services in the default namespace from a pod in another namespace on the same node", func() {
			makeNamespaceGlobal(f1.Namespace)
			Expect(checkServiceConnectivity(f1, f2, SAME_NODE)).To(Succeed())
		})
		It("should allow connections to services in the default namespace from a pod in another namespace on a different node", func() {
			makeNamespaceGlobal(f1.Namespace)
			Expect(checkServiceConnectivity(f1, f2, DIFFERENT_NODE)).To(Succeed())
		})
		It("should allow connections from pods in the default namespace to a service in another namespace on the same node", func() {
			makeNamespaceGlobal(f2.Namespace)
			Expect(checkServiceConnectivity(f1, f2, SAME_NODE)).To(Succeed())
		})
		It("should allow connections from pods in the default namespace to a service in another namespace on a different node", func() {
			makeNamespaceGlobal(f2.Namespace)
			Expect(checkServiceConnectivity(f1, f2, DIFFERENT_NODE)).To(Succeed())
		})
	})
})
