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
	"errors"
	"net/url"

	"github.com/spf13/pflag"

	restclient "k8s.io/client-go/rest"
	"k8s.io/client-go/tools/clientcmd"

	"github.com/openshift/origin/pkg/cmd/flagtypes"
)

type KubeConnectionArgs struct {
	KubernetesAddr flagtypes.Addr

	// ClientConfig is used when connecting to Kubernetes from the master, or
	// when connecting to the master from a detached node. If StartKube is true,
	// this value is not used.
	ClientConfig clientcmd.ClientConfig
	// ClientConfigLoadingRules is the ruleset used to load the client config.
	// Only the CommandLinePath is expected to be used.
	ClientConfigLoadingRules clientcmd.ClientConfigLoadingRules
}

// BindKubeConnectionArgs binds values to the given arguments by using flags
func BindKubeConnectionArgs(args *KubeConnectionArgs, flags *pflag.FlagSet, prefix string) {
	// TODO remove entirely
	flags.Var(&args.KubernetesAddr, prefix+"kubernetes", "removed in favor of --"+prefix+"kubeconfig")
	flags.StringVar(&args.ClientConfigLoadingRules.ExplicitPath, prefix+"kubeconfig", "", "Path to the kubeconfig file to use for requests to the Kubernetes API.")
}

// NewDefaultKubeConnectionArgs returns a new set of default connection
// arguments for Kubernetes
func NewDefaultKubeConnectionArgs() *KubeConnectionArgs {
	config := &KubeConnectionArgs{}

	config.KubernetesAddr = flagtypes.Addr{Value: "localhost:8443", DefaultScheme: "https", DefaultPort: 8443, AllowPrefix: true}.Default()
	config.ClientConfig = clientcmd.NewNonInteractiveDeferredLoadingClientConfig(&config.ClientConfigLoadingRules, &clientcmd.ConfigOverrides{})

	return config
}

func (args KubeConnectionArgs) Validate() error {
	if args.KubernetesAddr.Provided {
		return errors.New("--kubernetes is no longer allowed, try using --kubeconfig")
	}

	return nil
}

func (args KubeConnectionArgs) GetExternalKubernetesClientConfig() (*restclient.Config, bool, error) {
	if len(args.ClientConfigLoadingRules.ExplicitPath) == 0 || args.ClientConfig == nil {
		return nil, false, nil
	}
	clientConfig, err := args.ClientConfig.ClientConfig()
	if err != nil {
		return nil, false, err
	}
	return clientConfig, true, nil
}

func (args KubeConnectionArgs) GetKubernetesAddress(defaultAddress *url.URL) (*url.URL, error) {
	config, ok, err := args.GetExternalKubernetesClientConfig()
	if err != nil {
		return nil, err
	}
	if ok && len(config.Host) > 0 {
		return url.Parse(config.Host)
	}
	return defaultAddress, nil
}
