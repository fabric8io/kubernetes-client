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
import static org.junit.jupiter.api.Assertions.assertEquals
import static org.junit.jupiter.api.Assertions.assertTrue


new File(basedir, "/expected").eachFile { it ->
	var javaFileName = it.name.replaceAll("\\.expected\$", ".java")
	var javaFile = new File(basedir, sprintf("/src/generated/java/io/fabric8/kubernetes/api/model/gatewayapi/v1/%s", javaFileName))
	assertTrue(javaFile.exists(), sprintf("File %s does not exist", javaFile))
	assertEquals(
			it
			.getText("UTF-8")
			.replace("\r\n", "\n")
			.replaceAll(" +\n", "\n")
			.trim(),
			javaFile.getText("UTF-8").replace("\r\n", "\n").replaceAll(" +\n", "\n").trim(),
			sprintf("File %s does not match expected content", it)
			)
}

true
