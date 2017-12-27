#!/usr/bin/groovy
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
@Library('github.com/fabric8io/fabric8-pipeline-library@master')
def utils = new io.fabric8.Utils()
def ci = false
def cd = false
def pipeline
node {
  checkout scm
  readTrusted 'release.groovy'
  pipeline = load 'release.groovy'
  if (utils.isCI()) {
    ci = true
  } else if (utils.isCD()){
    cd = true
  }
}

if (ci){
  mavenNode{
    checkout scm
    mavenCI{}
  }
} else if (cd){
  releaseNode {
    checkout scm
    sh "git remote set-url origin git@github.com:fabric8io/kubernetes-client.git"

    pipeline = load 'release.groovy'

    stage 'Stage'
    def stagedProject = pipeline.stage()

    stage 'Promote'
    pipeline.release(stagedProject)
    
    stage 'Update downstream dependencies'
    pipeline.updateDownstreamDependencies(stagedProject)
  }
}
