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
	"fmt"
	"log"
	"net/http"
	"os"
)

var (
	version  string
	subtitle string
	color    string
)

const htmlContent = `<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Deployment Demonstration</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    HTML{height:100%%;}
    BODY{font-family:Helvetica,Arial;display:flex;display:-webkit-flex;align-items:center;justify-content:center;-webkit-align-items:center;-webkit-box-align:center;-webkit-justify-content:center;height:100%%;}
    .box{background:%[3]s;color:white;text-align:center;border-radius:10px;display:inline-block;}
    H1{font-size:10em;line-height:1.5em;margin:0 0.5em;}
    H2{margin-top:0;}
  </style>
</head>
<body>
<div class="box"><h1>%[1]s</h1><h2>%[2]s</h2></div>
</body>
</html>`

func deploymentHandler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, htmlContent, version, subtitle, color)
}

func healthHandler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintln(w, "ok")
}

func main() {
	version = "v1"
	if len(os.Args) > 1 {
		version = os.Args[1]
	}
	subtitle = os.Getenv("SUBTITLE")
	color = os.Getenv("COLOR")
	if len(color) == 0 {
		color = "#303030"
	}

	http.HandleFunc("/", deploymentHandler)

	http.HandleFunc("/_healthz", healthHandler)

	log.Printf("Listening on :8080 at %s ...", version)
	log.Fatal(http.ListenAndServe(":8080", nil))
}
