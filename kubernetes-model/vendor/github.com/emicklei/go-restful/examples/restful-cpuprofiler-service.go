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
	"github.com/emicklei/go-restful"
	"io"
	"log"
	"os"
	"runtime/pprof"
)

// ProfilingService is a WebService that can start/stop a CPU profile and write results to a file
// 	GET /{rootPath}/start will activate CPU profiling
//	GET /{rootPath}/stop will stop profiling
//
// NewProfileService("/profiler", "ace.prof").AddWebServiceTo(restful.DefaultContainer)
//
type ProfilingService struct {
	rootPath   string   // the base (root) of the service, e.g. /profiler
	cpuprofile string   // the output filename to write profile results, e.g. myservice.prof
	cpufile    *os.File // if not nil, then profiling is active
}

func NewProfileService(rootPath string, outputFilename string) *ProfilingService {
	ps := new(ProfilingService)
	ps.rootPath = rootPath
	ps.cpuprofile = outputFilename
	return ps
}

// Add this ProfileService to a restful Container
func (p ProfilingService) AddWebServiceTo(container *restful.Container) {
	ws := new(restful.WebService)
	ws.Path(p.rootPath).Consumes("*/*").Produces(restful.MIME_JSON)
	ws.Route(ws.GET("/start").To(p.startProfiler))
	ws.Route(ws.GET("/stop").To(p.stopProfiler))
	container.Add(ws)
}

func (p *ProfilingService) startProfiler(req *restful.Request, resp *restful.Response) {
	if p.cpufile != nil {
		io.WriteString(resp.ResponseWriter, "[restful] CPU profiling already running")
		return // error?
	}
	cpufile, err := os.Create(p.cpuprofile)
	if err != nil {
		log.Fatal(err)
	}
	// remember for close
	p.cpufile = cpufile
	pprof.StartCPUProfile(cpufile)
	io.WriteString(resp.ResponseWriter, "[restful] CPU profiling started, writing on:"+p.cpuprofile)
}

func (p *ProfilingService) stopProfiler(req *restful.Request, resp *restful.Response) {
	if p.cpufile == nil {
		io.WriteString(resp.ResponseWriter, "[restful] CPU profiling not active")
		return // error?
	}
	pprof.StopCPUProfile()
	p.cpufile.Close()
	p.cpufile = nil
	io.WriteString(resp.ResponseWriter, "[restful] CPU profiling stopped, closing:"+p.cpuprofile)
}

func main() {} // exists for example compilation only
