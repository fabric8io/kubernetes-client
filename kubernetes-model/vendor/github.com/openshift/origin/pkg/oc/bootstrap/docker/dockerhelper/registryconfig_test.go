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
package dockerhelper

import (
	"net"
	"testing"

	"github.com/docker/engine-api/types"
	"github.com/docker/engine-api/types/registry"
)

// NetIPNet is a helper function for converting a CIDR string to a corresponding NetIPNet
func NetIPNet(cidr string) *registry.NetIPNet {
	_, result, _ := net.ParseCIDR(cidr)
	return (*registry.NetIPNet)(result)
}

func TestContainsInsecureRegistryCIDR(t *testing.T) {

	tests := []struct {
		expectedResult bool
		dockerInfo     *types.Info
	}{
		{
			expectedResult: true,
			dockerInfo: &types.Info{
				RegistryConfig: &registry.ServiceConfig{
					InsecureRegistryCIDRs: []*registry.NetIPNet{NetIPNet("127.0.0.0/8"), NetIPNet("172.0.0.0/8")},
				},
			},
		},
		{
			expectedResult: true,
			dockerInfo: &types.Info{
				RegistryConfig: &registry.ServiceConfig{
					InsecureRegistryCIDRs: []*registry.NetIPNet{NetIPNet("127.0.0.0/8"), NetIPNet("172.30.0.0/15")},
				},
			},
		},
		{
			expectedResult: true,
			dockerInfo: &types.Info{
				RegistryConfig: &registry.ServiceConfig{
					InsecureRegistryCIDRs: []*registry.NetIPNet{NetIPNet("127.0.0.0/8"), NetIPNet("172.30.0.0/16")},
				},
			},
		},
		{
			expectedResult: false,
			dockerInfo: &types.Info{
				RegistryConfig: &registry.ServiceConfig{
					InsecureRegistryCIDRs: []*registry.NetIPNet{NetIPNet("127.0.0.0/8"), NetIPNet("172.30.0.0/24")},
				},
			},
		},
		{
			expectedResult: false,
			dockerInfo: &types.Info{
				RegistryConfig: &registry.ServiceConfig{
					InsecureRegistryCIDRs: []*registry.NetIPNet{NetIPNet("127.0.0.0/8"), NetIPNet("172.28.0.0/16")},
				},
			},
		},
		{
			expectedResult: false,
			dockerInfo: &types.Info{
				RegistryConfig: &registry.ServiceConfig{
					InsecureRegistryCIDRs: []*registry.NetIPNet{NetIPNet("127.0.0.0/8"), NetIPNet("10.15.0.0/16")},
				},
			},
		},
		{
			expectedResult: true,
			dockerInfo: &types.Info{
				RegistryConfig: &registry.ServiceConfig{
					InsecureRegistryCIDRs: []*registry.NetIPNet{NetIPNet("127.0.0.0/8"), NetIPNet("172.30.0.0/18"), NetIPNet("172.30.64.0/18"), NetIPNet("172.30.128.0/17")},
				},
			},
		},
		{
			expectedResult: true,
			dockerInfo: &types.Info{
				RegistryConfig: &registry.ServiceConfig{
					InsecureRegistryCIDRs: []*registry.NetIPNet{NetIPNet("127.0.0.0/8"), NetIPNet("0.0.0.0/0")},
				},
			},
		},
	}

	for _, test := range tests {
		thisRegistryConfig := NewRegistryConfig(test.dockerInfo)
		result, _ := thisRegistryConfig.ContainsInsecureRegistryCIDR("172.30.0.0/16")
		if result != test.expectedResult {
			t.Errorf("Unexpected output. Expected result %t, but got %t for %#v", test.expectedResult, result, test)
		}
	}
}

func TestHasCustomInsecureRegistryCIDRs(t *testing.T) {

	tests := []struct {
		expectedResult bool
		dockerInfo     *types.Info
	}{
		{
			expectedResult: false,
			dockerInfo: &types.Info{
				RegistryConfig: &registry.ServiceConfig{
					InsecureRegistryCIDRs: []*registry.NetIPNet{NetIPNet("127.0.0.0/8")},
				},
			},
		},
		{
			expectedResult: true,
			dockerInfo: &types.Info{
				RegistryConfig: &registry.ServiceConfig{
					InsecureRegistryCIDRs: []*registry.NetIPNet{NetIPNet("127.0.0.0/8"), NetIPNet("172.30.0.0/16")},
				},
			},
		},
	}

	for _, test := range tests {
		thisRegistryConfig := NewRegistryConfig(test.dockerInfo)
		result := thisRegistryConfig.HasCustomInsecureRegistryCIDRs()
		if result != test.expectedResult {
			t.Errorf("Unexpected output. Expected result %t, but got %t for %#v", test.expectedResult, result, test)
		}
	}
}
