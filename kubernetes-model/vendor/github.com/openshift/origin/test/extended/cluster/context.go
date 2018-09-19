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
package cluster

import (
	"path/filepath"
	"strings"
	"time"

	"github.com/spf13/viper"
)

// ContextType is the root config struct
type ContextType struct {
	ClusterLoader struct {
		Cleanup    bool
		Projects   []ClusterLoaderType
		Sync       SyncObjectType
		TuningSets []TuningSetType
	}
}

// ClusterLoaderType struct only used for Cluster Loader test config
type ClusterLoaderType struct {
	Number     int `mapstructure:"num"`
	Basename   string
	Tuning     string
	Configmaps map[string]interface{}
	Secrets    map[string]interface{}
	Pods       []ClusterLoaderObjectType
	Templates  []ClusterLoaderObjectType
}

// ClusterLoaderObjectType is nested object type for cluster loader struct
type ClusterLoaderObjectType struct {
	Total      int
	Number     int `mapstructure:"num"`
	Image      string
	Basename   string
	File       string
	Sync       SyncObjectType
	Parameters map[string]interface{}
}

// SyncObjectType is nested object type for cluster loader synchronisation functionality
type SyncObjectType struct {
	Server struct {
		Enabled bool
		Port    int
	}
	Running   bool
	Succeeded bool
	Selectors map[string]string
	Timeout   string
}

// TuningSetType is nested type for controlling Cluster Loader deployment pattern
type TuningSetType struct {
	Name      string
	Pods      TuningSetObjectType
	Templates TuningSetObjectType
}

// TuningSetObjectType is shared struct for Pods & Templates
type TuningSetObjectType struct {
	Stepping struct {
		StepSize int
		Pause    time.Duration
		Timeout  time.Duration
	}
	RateLimit struct {
		Delay time.Duration
	}
}

// ConfigContext variable of type ContextType
var ConfigContext ContextType

// PodCount struct keeps HTTP requst counts and state
type PodCount struct {
	Started  int
	Stopped  int
	Shutdown chan bool
}

// ServiceInfo struct to bundle env data
type ServiceInfo struct {
	Name string
	IP   string
	Port int32
}

// TestResult struct contains result data to be saved at end of run
type TestResult struct {
	Time time.Duration `json:"time"`
}

// ParseConfig will complete flag parsing as well as viper tasks
func ParseConfig(config string, isFixture bool) error {
	// This must be done after common flags are registered, since Viper is a flag option.
	if isFixture {
		dir, file := filepath.Split(config)
		s := strings.Split(file, ".")
		viper.SetConfigName(s[0])
		viper.AddConfigPath(dir)
	} else {
		viper.SetConfigName(config)
		viper.AddConfigPath(".")
	}
	err := viper.ReadInConfig()
	if err != nil {
		return err
	}
	viper.Unmarshal(&ConfigContext)
	return nil
}
