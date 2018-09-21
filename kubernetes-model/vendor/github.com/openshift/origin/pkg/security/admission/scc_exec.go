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
package admission

import (
	"fmt"
	"io"

	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	admission "k8s.io/apiserver/pkg/admission"
	kapi "k8s.io/kubernetes/pkg/apis/core"
	kclientset "k8s.io/kubernetes/pkg/client/clientset_generated/internalclientset"
	kadmission "k8s.io/kubernetes/pkg/kubeapiserver/admission"

	oadmission "github.com/openshift/origin/pkg/cmd/server/admission"
	securityinformer "github.com/openshift/origin/pkg/security/generated/informers/internalversion"
)

func RegisterSCCExecRestrictions(plugins *admission.Plugins) {
	plugins.Register("SCCExecRestrictions",
		func(config io.Reader) (admission.Interface, error) {
			execAdmitter := NewSCCExecRestrictions()
			return execAdmitter, nil
		})
}

var _ admission.Interface = &sccExecRestrictions{}
var _ = oadmission.WantsSecurityInformer(&constraint{})
var _ = kadmission.WantsInternalKubeClientSet(&sccExecRestrictions{})

// sccExecRestrictions is an implementation of admission.Interface which says no to a pod/exec on
// a pod that the user would not be allowed to create
type sccExecRestrictions struct {
	*admission.Handler
	constraintAdmission *constraint
	client              kclientset.Interface
}

func (d *sccExecRestrictions) Admit(a admission.Attributes) (err error) {
	if a.GetOperation() != admission.Connect {
		return nil
	}
	if a.GetResource().GroupResource() != kapi.Resource("pods") {
		return nil
	}
	if a.GetSubresource() != "attach" && a.GetSubresource() != "exec" {
		return nil
	}

	pod, err := d.client.Core().Pods(a.GetNamespace()).Get(a.GetName(), metav1.GetOptions{})
	if err != nil {
		return admission.NewForbidden(a, err)
	}

	// TODO, if we want to actually limit who can use which service account, then we'll need to add logic here to make sure that
	// we're allowed to use the SA the pod is using.  Otherwise, user-A creates pod and user-B (who can't use the SA) can exec into it.
	createAttributes := admission.NewAttributesRecord(pod, nil, kapi.Kind("Pod").WithVersion(""), a.GetNamespace(), a.GetName(), a.GetResource(), "", admission.Create, a.GetUserInfo())
	if err := d.constraintAdmission.Admit(createAttributes); err != nil {
		return admission.NewForbidden(a, fmt.Errorf("%s operation is not allowed because the pod's security context exceeds your permissions: %v", a.GetSubresource(), err))
	}

	return nil
}

// NewSCCExecRestrictions creates a new admission controller that denies an exec operation on a privileged pod
func NewSCCExecRestrictions() *sccExecRestrictions {
	return &sccExecRestrictions{
		Handler:             admission.NewHandler(admission.Connect),
		constraintAdmission: NewConstraint(),
	}
}

func (d *sccExecRestrictions) SetInternalKubeClientSet(c kclientset.Interface) {
	d.client = c
	d.constraintAdmission.SetInternalKubeClientSet(c)
}

func (d *sccExecRestrictions) SetSecurityInformers(informers securityinformer.SharedInformerFactory) {
	d.constraintAdmission.SetSecurityInformers(informers)
}

// Validate defines actions to validate sccExecRestrictions
func (d *sccExecRestrictions) ValidateInitialization() error {
	return d.constraintAdmission.ValidateInitialization()
}
