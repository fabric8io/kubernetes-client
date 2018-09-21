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
package config

import (
	"github.com/openshift/origin/pkg/cmd/util"
	clientcmdapi "k8s.io/client-go/tools/clientcmd/api"
)

// TODO should be moved upstream
func RelativizeClientConfigPaths(cfg *clientcmdapi.Config, base string) (err error) {
	for k, cluster := range cfg.Clusters {
		if len(cluster.CertificateAuthority) > 0 {
			if cluster.CertificateAuthority, err = util.MakeAbs(cluster.CertificateAuthority, ""); err != nil {
				return err
			}
			if cluster.CertificateAuthority, err = util.MakeRelative(cluster.CertificateAuthority, base); err != nil {
				return err
			}
			cfg.Clusters[k] = cluster
		}
	}
	for k, authInfo := range cfg.AuthInfos {
		if len(authInfo.ClientCertificate) > 0 {
			if authInfo.ClientCertificate, err = util.MakeAbs(authInfo.ClientCertificate, ""); err != nil {
				return err
			}
			if authInfo.ClientCertificate, err = util.MakeRelative(authInfo.ClientCertificate, base); err != nil {
				return err
			}
		}
		if len(authInfo.ClientKey) > 0 {
			if authInfo.ClientKey, err = util.MakeAbs(authInfo.ClientKey, ""); err != nil {
				return err
			}
			if authInfo.ClientKey, err = util.MakeRelative(authInfo.ClientKey, base); err != nil {
				return err
			}
		}
		cfg.AuthInfos[k] = authInfo
	}
	return nil
}
