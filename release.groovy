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
def updateDependencies(source){

  def properties = []
  properties << ['<kubernetes.model.version>','io/fabric8/kubernetes-model']
  properties << ['<mockwebserver.version>','io/fabric8/mockwebserver']

  updatePropertyVersion{
    updates = properties
    repository = source
    project = 'fabric8io/kubernetes-client'
  }
}

def stage(){
  return stageProject{
    project = 'fabric8io/kubernetes-client'
    useGitTagForNextVersion = true
  }
}

def approveRelease(project){
  def releaseVersion = project[1]
  approve{
    room = null
    version = releaseVersion
    console = null
    environment = 'fabric8'
  }
}

def release(project){
  releaseProject{
    stagedProject = project
    useGitTagForNextVersion = true
    helmPush = false
    groupId = 'io.fabric8'
    githubOrganisation = 'fabric8io'
    artifactIdToWatchInCentral = 'kubernetes-client'
    artifactExtensionToWatchInCentral = 'jar'
  }
}

def mergePullRequest(prId){
  mergeAndWaitForPullRequest{
    project = 'fabric8io/kubernetes-client'
    pullRequestId = prId
  }
}

def updateDownstreamDependencies(stagedProject) {
  pushPomPropertyChangePR {
    propertyName = 'kubernetes-client.version'
    projects = [
            'fabric8io/fabric8',
            'fabric8io/fabric8-platform',
            'jenkinsci/kubernetes-pipeline-plugin'
    ]
    version = stagedProject[1]
  }
  pushPomPropertyChangePR {
    propertyName = 'openshift-client.version'
    projects = [
            'fabric8io/jenkins-sync-plugin'
    ]
    version = stagedProject[1]
  }
  pushPomPropertyChangePR {
    parentPomLocation = 'parent/pom.xml'
    propertyName = 'version.kubernetes-client'
    projects = [
            'fabric8io/fabric8-maven-plugin'
    ]    
  }
  version.kubernetes-client
}
return this;
