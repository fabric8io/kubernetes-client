/*
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

import groovy.xml.XmlSlurper

def targetDir = new File(basedir, "target/classes")

// Verify BOM was generated
def bomFile = new File(targetDir, "release-repo-bom/pom.xml")
assert bomFile.exists() : "release-repo-bom/pom.xml was not generated"

def bom = new XmlSlurper().parse(bomFile)

// Verify distribution management includes both repositories
assert bom.distributionManagement.repository.id.text() == "releases" : "Release repo id should be 'releases'"
assert bom.distributionManagement.repository.name.text() == "Release Repository" : "Release repo name should match"
assert bom.distributionManagement.repository.url.text() == "https://repo.example.com/releases/" : "Release repo url should match"

assert bom.distributionManagement.snapshotRepository.id.text() == "snapshots" : "Snapshot repo id should be 'snapshots'"
assert bom.distributionManagement.snapshotRepository.name.text() == "Snapshot Repository" : "Snapshot repo name should match"
assert bom.distributionManagement.snapshotRepository.url.text() == "https://repo.example.com/snapshots/" : "Snapshot repo url should match"

println "with-release-repo verification passed - both release and snapshot repos copied!"
return true
