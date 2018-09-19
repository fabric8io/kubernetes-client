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
	"crypto/x509"
	"fmt"
	"io/ioutil"
	"os"

	pemutil "github.com/openshift/origin/pkg/cmd/util/pem"
)

func GetStringSourceFileReferences(s *StringSource) []*string {
	if s == nil {
		return nil
	}
	return []*string{
		&s.File,
		&s.KeyFile,
	}
}

func ResolveStringValue(s StringSource) (string, error) {
	var value string
	switch {
	case len(s.Value) > 0:
		value = s.Value
	case len(s.Env) > 0:
		value = os.Getenv(s.Env)
	case len(s.File) > 0:
		data, err := ioutil.ReadFile(s.File)
		if err != nil {
			return "", err
		}
		value = string(data)
	default:
		value = ""
	}

	if len(s.KeyFile) == 0 {
		// value is cleartext, return
		return value, nil
	}

	keyData, err := ioutil.ReadFile(s.KeyFile)
	if err != nil {
		return "", err
	}

	secretBlock, ok := pemutil.BlockFromBytes([]byte(value), StringSourceEncryptedBlockType)
	if !ok {
		return "", fmt.Errorf("no valid PEM block of type %q found in data", StringSourceEncryptedBlockType)
	}

	keyBlock, ok := pemutil.BlockFromBytes(keyData, StringSourceKeyBlockType)
	if !ok {
		return "", fmt.Errorf("no valid PEM block of type %q found in key", StringSourceKeyBlockType)
	}

	data, err := x509.DecryptPEMBlock(secretBlock, keyBlock.Bytes)
	return string(data), err
}
