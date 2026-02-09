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
import groovy.json.JsonSlurper

def configFile = new File(basedir, 'target/classes/META-INF/native-image/io.fabric8/simple-jackson-project/reflect-config.json')

assert configFile.exists() : "reflect-config.json should exist"

def json = new JsonSlurper().parse(configFile)

assert json.size() == 1 : "Should have 1 reflection entry"

def personEntry = json.find { it.name == 'io.fabric8.test.Person' }
assert personEntry != null : "Should have entry for Person class"
assert personEntry.condition != null : "Should have condition"
assert personEntry.condition.typeReachable == 'io.fabric8.test.Person' : "Should have typeReachable condition"
assert personEntry.allDeclaredConstructors == true : "Should enable all declared constructors"
assert personEntry.allDeclaredMethods == true : "Should enable all declared methods"
assert personEntry.allDeclaredFields == true : "Should enable all declared fields"

println "Integration test passed: Jackson annotations detected and configuration generated"
