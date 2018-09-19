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
package scmauth

import (
	"fmt"
	"io/ioutil"
	"path/filepath"

	"github.com/golang/glog"
	s2igit "github.com/openshift/source-to-image/pkg/scm/git"
)

const (
	CACertName   = "ca.crt"
	CACertConfig = `# SSL cert
[http]
   sslCAInfo = %[1]s
`
)

// CACert implements SCMAuth interface for using a custom certificate authority
type CACert struct {
	SourceURL s2igit.URL
}

// Setup creates a .gitconfig fragment that points to the given ca.crt
func (s CACert) Setup(baseDir string, context SCMAuthContext) error {
	if !(s.SourceURL.Type == s2igit.URLTypeURL && s.SourceURL.URL.Scheme == "https" && s.SourceURL.URL.Opaque == "") {
		return nil
	}
	gitconfig, err := ioutil.TempFile("", "ca.crt.")
	if err != nil {
		return err
	}
	defer gitconfig.Close()
	content := fmt.Sprintf(CACertConfig, filepath.Join(baseDir, CACertName))
	glog.V(5).Infof("Adding CACert Auth to %s:\n%s\n", gitconfig.Name(), content)
	gitconfig.WriteString(content)

	return ensureGitConfigIncludes(gitconfig.Name(), context)
}

// Name returns the name of this auth method.
func (_ CACert) Name() string {
	return CACertName
}

// Handles returns true if the secret is a CA certificate
func (_ CACert) Handles(name string) bool {
	return name == CACertName
}
