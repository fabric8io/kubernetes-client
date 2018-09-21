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
package controller

import (
	"testing"

	"k8s.io/api/core/v1"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/runtime/schema"
	clientgotesting "k8s.io/client-go/testing"

	projectapiv1 "github.com/openshift/api/project/v1"
	"k8s.io/client-go/kubernetes/fake"
)

func TestSyncNamespaceThatIsTerminating(t *testing.T) {
	mockKubeClient := &fake.Clientset{}
	nm := &ProjectFinalizerController{
		client: mockKubeClient,
	}
	now := metav1.Now()
	testNamespace := &v1.Namespace{
		ObjectMeta: metav1.ObjectMeta{
			Name:              "test",
			ResourceVersion:   "1",
			DeletionTimestamp: &now,
		},
		Spec: v1.NamespaceSpec{
			Finalizers: []v1.FinalizerName{v1.FinalizerKubernetes, projectapiv1.FinalizerOrigin},
		},
		Status: v1.NamespaceStatus{
			Phase: v1.NamespaceTerminating,
		},
	}
	err := nm.finalize(testNamespace)
	if err != nil {
		t.Errorf("Unexpected error when handling namespace %v", err)
	}

	// TODO: we will expect a finalize namespace call after rebase
	expectedActionSet := []clientgotesting.Action{
		clientgotesting.NewListAction(
			schema.GroupVersionResource{Group: "", Version: "v1", Resource: "namespace"},
			schema.GroupVersionKind{Group: "", Version: "v1", Kind: "Namespace"},
			"", metav1.ListOptions{}),
	}
	kubeActionSet := []clientgotesting.Action{}
	for i := range mockKubeClient.Actions() {
		kubeActionSet = append(kubeActionSet, mockKubeClient.Actions()[i])
	}

	if (len(kubeActionSet)) != len(expectedActionSet) {
		t.Errorf("Expected actions: %v, but got: %v", expectedActionSet, kubeActionSet)
	}
}

func TestSyncNamespaceThatIsActive(t *testing.T) {
	mockKubeClient := &fake.Clientset{}
	nm := &ProjectFinalizerController{
		client: mockKubeClient,
	}
	testNamespace := &v1.Namespace{
		ObjectMeta: metav1.ObjectMeta{
			Name:            "test",
			ResourceVersion: "1",
		},
		Spec: v1.NamespaceSpec{
			Finalizers: []v1.FinalizerName{v1.FinalizerKubernetes, projectapiv1.FinalizerOrigin},
		},
		Status: v1.NamespaceStatus{
			Phase: v1.NamespaceActive,
		},
	}
	err := nm.finalize(testNamespace)
	if err != nil {
		t.Errorf("Unexpected error when handling namespace %v", err)
	}
	kubeActionSet := []clientgotesting.Action{}
	for i := range mockKubeClient.Actions() {
		kubeActionSet = append(kubeActionSet, mockKubeClient.Actions()[i])
	}

	if (len(kubeActionSet)) != 0 {
		t.Errorf("Expected no actions from contoller, but got: %#v", kubeActionSet)
	}
}
