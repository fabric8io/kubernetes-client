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

// Verify core-bom was generated
def bomFile = new File(targetDir, "core-bom/pom.xml")
assert bomFile.exists() : "core-bom/pom.xml was not generated"

def bom = new XmlSlurper().parse(bomFile)

// Verify only included modules are present
def deps = bom.dependencyManagement.dependencies.dependency
def artifactIds = deps.collect { it.artifactId.text() }

assert artifactIds.contains("module-core") : "BOM should include module-core (in includes)"
assert artifactIds.contains("module-api") : "BOM should include module-api (in includes)"
assert !artifactIds.contains("module-extra") : "BOM should NOT include module-extra (not in includes)"

println "with-includes verification passed!"
return true
