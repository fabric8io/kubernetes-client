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
node{
  ws{
    checkout scm
    sh "git remote set-url origin git@github.com:fabric8io/kubernetes-client.git"

    def pipeline = load 'release.groovy'

    stage 'Updating dependencies'
    def prId = pipeline.updateDependencies('http://central.maven.org/maven2/')

    stage 'Stage'
    def stagedProject = pipeline.stage()

    stage 'Approve'
    pipeline.approveRelease(stagedProject)

    stage 'Promote'
    pipeline.release(stagedProject)
    if (prId != null){
      pipeline.mergePullRequest(prId)
    }    
  }
}
