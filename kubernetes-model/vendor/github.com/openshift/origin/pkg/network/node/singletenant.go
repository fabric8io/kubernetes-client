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
// +build linux

package node

import (
	"github.com/openshift/origin/pkg/network"
	networkapi "github.com/openshift/origin/pkg/network/apis/network"
)

type singleTenantPlugin struct{}

func NewSingleTenantPlugin() osdnPolicy {
	return &singleTenantPlugin{}
}

func (sp *singleTenantPlugin) Name() string {
	return network.SingleTenantPluginName
}

func (sp *singleTenantPlugin) SupportsVNIDs() bool {
	return false
}

func (sp *singleTenantPlugin) Start(node *OsdnNode) error {
	otx := node.oc.NewTransaction()
	otx.AddFlow("table=80, priority=200, actions=output:NXM_NX_REG2[]")
	return otx.EndTransaction()
}

func (sp *singleTenantPlugin) AddNetNamespace(netns *networkapi.NetNamespace) {
}

func (sp *singleTenantPlugin) UpdateNetNamespace(netns *networkapi.NetNamespace, oldNetID uint32) {
}

func (sp *singleTenantPlugin) DeleteNetNamespace(netns *networkapi.NetNamespace) {
}

func (sp *singleTenantPlugin) GetVNID(namespace string) (uint32, error) {
	return 0, nil
}

func (sp *singleTenantPlugin) GetNamespaces(vnid uint32) []string {
	return nil
}

func (sp *singleTenantPlugin) GetMulticastEnabled(vnid uint32) bool {
	return false
}

func (sp *singleTenantPlugin) EnsureVNIDRules(vnid uint32) {
}

func (sp *singleTenantPlugin) SyncVNIDRules() {
}
