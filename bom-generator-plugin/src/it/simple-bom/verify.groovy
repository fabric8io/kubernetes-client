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

// ============================================
// Verify test-bom was generated
// ============================================
def bomFile = new File(targetDir, "test-bom/pom.xml")
assert bomFile.exists() : "test-bom/pom.xml was not generated"

def bom = new XmlSlurper().parse(bomFile)

// Verify coordinates
assert bom.groupId.text() == "io.fabric8.it" : "BOM groupId should be io.fabric8.it"
assert bom.artifactId.text() == "test-bom" : "BOM artifactId should be test-bom"
assert bom.version.text() == "1.0.0" : "BOM version should be 1.0.0"
assert bom.packaging.text() == "pom" : "BOM packaging should be pom"
assert bom.name.text() == "IT :: Test BOM" : "BOM name should match configuration"

// Verify license info was copied
assert bom.licenses.license.size() == 1 : "BOM should have 1 license"
assert bom.licenses.license[0].name.text() == "Apache License, Version 2.0" : "License name should match"

// Verify developer info was copied
assert bom.developers.developer.size() == 1 : "BOM should have 1 developer"
assert bom.developers.developer[0].id.text() == "test" : "Developer id should match"
assert bom.developers.developer[0].name.text() == "Test Developer" : "Developer name should match"

// Verify SCM info was copied
assert bom.scm.connection.text() == "scm:git:git@github.com:test/test-project.git" : "SCM connection should match"
assert bom.scm.developerConnection.text() == "scm:git:git@github.com:test/test-project.git" : "SCM developerConnection should match"
assert bom.scm.tag.text() == "1.0.0" : "SCM tag should be resolved to version"
assert bom.scm.url.text() == "https://github.com/test/test-project/" : "SCM url should match"

// Verify distribution management was copied
assert bom.distributionManagement.snapshotRepository.id.text() == "snapshots" : "Snapshot repo id should match"
assert bom.distributionManagement.snapshotRepository.url.text() == "https://repo.example.com/snapshots/" : "Snapshot repo url should match"

// Verify dependency management includes all reactor modules
def deps = bom.dependencyManagement.dependencies.dependency
def artifactIds = deps.collect { it.artifactId.text() }
assert artifactIds.contains("module-a") : "BOM should include module-a"
assert artifactIds.contains("module-b") : "BOM should include module-b"
assert artifactIds.contains("module-plugin") : "BOM should include module-plugin"

// Verify versions are set correctly
deps.each { dep ->
	if (dep.groupId.text() == "io.fabric8.it") {
		assert dep.version.text() == "1.0.0" : "Module ${dep.artifactId.text()} version should be 1.0.0"
	}
}

// Verify maven-plugin type is set for plugin modules
def pluginDep = deps.find { it.artifactId.text() == "module-plugin" }
assert pluginDep.type.text() == "maven-plugin" : "module-plugin should have type=maven-plugin"

// Verify jar modules don't have maven-plugin type
def moduleADep = deps.find { it.artifactId.text() == "module-a" }
assert moduleADep.type.text() == "" || moduleADep.type.text() == "jar" : "module-a should not have type=maven-plugin"

// Verify plugins were copied from release profile
def plugins = bom.build.plugins.plugin
def pluginArtifactIds = plugins.collect { it.artifactId.text() }
assert pluginArtifactIds.contains("maven-gpg-plugin") : "BOM should include maven-gpg-plugin"
assert pluginArtifactIds.contains("central-publishing-maven-plugin") : "BOM should include central-publishing-maven-plugin"
assert pluginArtifactIds.contains("maven-release-plugin") : "BOM should include maven-release-plugin"
assert pluginArtifactIds.contains("maven-enforcer-plugin") : "BOM should include maven-enforcer-plugin"

// Verify plugin versions are resolved (not properties)
def gpgPlugin = plugins.find { it.artifactId.text() == "maven-gpg-plugin" }
assert gpgPlugin.version.text() == "3.2.8" : "maven-gpg-plugin version should be resolved to 3.2.8"

def centralPlugin = plugins.find { it.artifactId.text() == "central-publishing-maven-plugin" }
assert centralPlugin.version.text() == "0.9.0" : "central-publishing-maven-plugin version should be resolved to 0.9.0"

// Verify plugin configuration was copied
def gpgArgs = gpgPlugin.configuration.gpgArguments.arg
assert gpgArgs.size() == 3 : "maven-gpg-plugin should have 3 gpgArguments"

// Verify plugin executions were copied
def gpgExec = gpgPlugin.executions.execution[0]
assert gpgExec.id.text() == "sign-artifacts" : "Execution id should be sign-artifacts"
assert gpgExec.phase.text() == "verify" : "Execution phase should be verify"
assert gpgExec.goals.goal[0].text() == "sign" : "Execution goal should be sign"

println "test-bom verification passed!"

// ============================================
// Verify test-bom-filtered was generated with exclusions
// ============================================
def filteredBomFile = new File(targetDir, "test-bom-filtered/pom.xml")
assert filteredBomFile.exists() : "test-bom-filtered/pom.xml was not generated"

def filteredBom = new XmlSlurper().parse(filteredBomFile)

// Verify coordinates
assert filteredBom.artifactId.text() == "test-bom-filtered" : "Filtered BOM artifactId should be test-bom-filtered"
assert filteredBom.name.text() == "IT :: Test BOM Filtered" : "Filtered BOM name should match"

// Verify module-b is excluded
def filteredDeps = filteredBom.dependencyManagement.dependencies.dependency
def filteredArtifactIds = filteredDeps.collect { it.artifactId.text() }
assert filteredArtifactIds.contains("module-a") : "Filtered BOM should include module-a"
assert !filteredArtifactIds.contains("module-b") : "Filtered BOM should NOT include module-b (excluded)"
assert filteredArtifactIds.contains("module-plugin") : "Filtered BOM should include module-plugin"

println "test-bom-filtered verification passed!"

println "All verifications passed!"
return true
