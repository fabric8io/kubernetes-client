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

// Verify that when no BOM configurations are provided, the plugin skips gracefully
// and doesn't create any output directory

def outputDir = new File(basedir, "target/classes")

// The output directory might exist but should not contain any BOM directories
if (outputDir.exists()) {
	def bomDirs = outputDir.listFiles()?.findAll { it.isDirectory() && it.name.endsWith("-bom") }
	assert bomDirs == null || bomDirs.isEmpty() : "No BOM directories should be created when no boms are configured"
}

println "no-bom-config verification passed - plugin skipped gracefully!"
return true
