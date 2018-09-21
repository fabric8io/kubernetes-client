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
package dockercfg

import (
	"io/ioutil"
	"os"
	"path/filepath"
	"testing"
)

func TestGetDockerAuth(t *testing.T) {
	var (
		configJsonFileName = "config.json"
		testEnvKey         = "TMP_PULL_DOCKER_CFG_AUTH_ENV_FOO_BAR"
	)
	var fileInfo *os.File

	content := "{ \"auths\": { \"test-server-1.tld\":{\"auth\":\"Zm9vOmJhcgo=\",\"email\":\"test@email.test.com\"}}}"

	tmpDirPath, err := ioutil.TempDir("", "test_foo_bar_")
	if err != nil {
		t.Fatalf("Creating tmp dir fail: %v", err)
		return
	}
	defer os.RemoveAll(tmpDirPath)

	absDockerConfigFileLocation, err := filepath.Abs(filepath.Join(tmpDirPath, configJsonFileName))
	if err != nil {
		t.Fatalf("while trying to canonicalize %s: %v", tmpDirPath, err)
		return
	}

	if _, err = os.Stat(absDockerConfigFileLocation); os.IsNotExist(err) {
		//create test cfg file
		fileInfo, err = os.OpenFile(absDockerConfigFileLocation, os.O_CREATE|os.O_RDWR, 0664)
		if err != nil {
			t.Fatalf("while trying to create file %s: %v", absDockerConfigFileLocation, err)
			return
		}
		defer fileInfo.Close()

		os.Setenv(testEnvKey, tmpDirPath)
		defer os.Unsetenv(testEnvKey)
	}

	fileInfo.WriteString(content)

	_, ok := NewHelper().GetDockerAuth("test-server-1.tld/foo/bar", testEnvKey)
	if !ok {
		t.Errorf("unexpected value getting docker auth fail")
		return
	}
}
