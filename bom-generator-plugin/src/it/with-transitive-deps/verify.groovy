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
def bomFile = new File(targetDir, "transitive-bom/pom.xml")
assert bomFile.exists() : "transitive-bom/pom.xml was not generated"

def bom = new XmlSlurper(false, false).parse(bomFile)

// Verify reactor modules are included
def deps = bom.dependencyManagement.dependencies.dependency
def allDeps = deps.collect { "${it.groupId.text()}:${it.artifactId.text()}".toString() }

assert allDeps.contains("io.fabric8.it:module-client") : "BOM should include module-client, found: ${allDeps}"
assert allDeps.contains("io.fabric8.it:module-server") : "BOM should include module-server, found: ${allDeps}"

// Verify transitive dependencies matching the include pattern are present
// (from dependencyManagement with resolved version)
def slf4jDeps = deps.findAll { it.groupId.text() == "org.slf4j" }
assert slf4jDeps.size() >= 1 : "BOM should include at least one slf4j dependency"

// Verify version is resolved (not a property placeholder)
slf4jDeps.each { dep ->
	def version = dep.version.text()
	assert !version.contains('${') : "slf4j dependency version should be resolved, got: ${version}"
	assert version == "2.0.9" : "slf4j version should be 2.0.9, got: ${version}"
}

println "with-transitive-deps verification passed!"
return true
