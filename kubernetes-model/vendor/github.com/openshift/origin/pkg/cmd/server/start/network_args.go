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
package start

import (
	"github.com/spf13/pflag"
)

// NetworkArgs is a struct that the command stores flag values into.
type NetworkArgs struct {
	// NetworkPluginName is the name of the networking plugin to be used for networking.
	NetworkPluginName string
	// ClusterNetworkCIDR is the CIDR string representing the network that all containers
	// should belong to.
	ClusterNetworkCIDR string
	// HostSubnetLength is the length of subnet each host is given from the network-cidr.
	HostSubnetLength uint32
	// ServiceNetworkCIDR is the CIDR string representing the network that service IP
	// addresses will be allocated from
	ServiceNetworkCIDR string
}

// BindNetworkArgs binds values to the given arguments by using flags
func BindNetworkArgs(args *NetworkArgs, flags *pflag.FlagSet, prefix string) {
	flags.StringVar(&args.NetworkPluginName, prefix+"network-plugin", args.NetworkPluginName, "The name of the networking plugin to be used for networking.")
	flags.StringVar(&args.ClusterNetworkCIDR, prefix+"network-cidr", args.ClusterNetworkCIDR, "The CIDR string representing the network that all containers should belong to.")
	flags.Uint32Var(&args.HostSubnetLength, prefix+"host-subnet-length", args.HostSubnetLength, "The length of subnet each host is given from the network-cidr.")
	flags.StringVar(&args.ServiceNetworkCIDR, prefix+"portal-net", args.ServiceNetworkCIDR, "The CIDR string representing the network that portal/service IPs will be assigned from. This must not overlap with any IP ranges assigned to nodes for pods.")
}

// NewDefaultNetworkArgs returns a new set of network arguments
func NewDefaultNetworkArgs() *NetworkArgs {
	config := &NetworkArgs{
		NetworkPluginName:  "",
		ClusterNetworkCIDR: "10.128.0.0/14",
		HostSubnetLength:   9,
		ServiceNetworkCIDR: "172.30.0.0/16",
	}

	return config
}
