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
package reaper

import (
	"time"

	"github.com/golang/glog"
	kerrors "k8s.io/apimachinery/pkg/api/errors"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/kubernetes/pkg/kubectl"

	authclient "github.com/openshift/origin/pkg/authorization/generated/internalclientset/typed/authorization/internalversion"
)

func NewRoleReaper(roleClient authclient.RolesGetter, bindingClient authclient.RoleBindingsGetter) kubectl.Reaper {
	return &RoleReaper{
		roleClient:    roleClient,
		bindingClient: bindingClient,
	}
}

type RoleReaper struct {
	roleClient    authclient.RolesGetter
	bindingClient authclient.RoleBindingsGetter
}

// Stop on a reaper is actually used for deletion.  In this case, we'll delete referencing rolebindings
// then delete the role.
func (r *RoleReaper) Stop(namespace, name string, timeout time.Duration, gracePeriod *metav1.DeleteOptions) error {
	bindings, err := r.bindingClient.RoleBindings(namespace).List(metav1.ListOptions{})
	if err != nil {
		return err
	}

	for _, binding := range bindings.Items {
		if binding.RoleRef.Namespace == namespace && binding.RoleRef.Name == name {
			if err := r.bindingClient.RoleBindings(namespace).Delete(binding.Name, &metav1.DeleteOptions{}); err != nil && !kerrors.IsNotFound(err) {
				glog.Infof("Cannot delete rolebinding/%s: %v", binding.Name, err)
			}
		}
	}

	if err := r.roleClient.Roles(namespace).Delete(name, &metav1.DeleteOptions{}); err != nil && !kerrors.IsNotFound(err) {
		return err
	}

	return nil
}
