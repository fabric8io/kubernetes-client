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
package main

import (
	"flag"
	"math/rand"
	"os"
	"runtime"
	"time"

	"k8s.io/apimachinery/pkg/util/wait"
	"k8s.io/apiserver/pkg/util/logs"

	"github.com/golang/glog"
	"github.com/openshift/origin/pkg/cmd/util/serviceability"
	tsbcmd "github.com/openshift/origin/pkg/templateservicebroker/cmd/server"

	// install all APIs
	_ "github.com/openshift/origin/pkg/api/install"
	_ "k8s.io/kubernetes/pkg/apis/autoscaling/install"
	_ "k8s.io/kubernetes/pkg/apis/batch/install"
	_ "k8s.io/kubernetes/pkg/apis/core/install"
	_ "k8s.io/kubernetes/pkg/apis/extensions/install"
)

func main() {
	rand.Seed(time.Now().UTC().UnixNano())

	logs.InitLogs()
	defer logs.FlushLogs()

	if len(os.Getenv("GOMAXPROCS")) == 0 {
		runtime.GOMAXPROCS(runtime.NumCPU())
	}

	defer serviceability.BehaviorOnPanic(os.Getenv("OPENSHIFT_ON_PANIC"))()
	defer serviceability.Profile(os.Getenv("OPENSHIFT_PROFILE")).Stop()

	cmd := tsbcmd.NewCommandStartTemplateServiceBrokerServer(os.Stdout, os.Stderr, wait.NeverStop)
	cmd.Flags().AddGoFlagSet(flag.CommandLine)
	if err := cmd.Execute(); err != nil {
		glog.Fatal(err)
	}
}
