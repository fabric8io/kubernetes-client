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
package io.fabric8.java.generator.cli;

import io.fabric8.java.generator.CRGeneratorRunner;
import java.io.File;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
        name = "java-gen",
        mixinStandardHelpOptions = true,
        helpCommand = true,
        versionProvider = KubernetesClientVersionProvider.class)
public class GenerateJavaSources implements Runnable {

    @Option(
            names = {"-crd", "--custom-resource-definition"},
            description = "The file with the CustomResourceDefinition to use",
            required = true)
    File crdFile;

    @Option(
            names = {"-dest", "--destination-folder"},
            description = "The folder to write the generated sources",
            required = true)
    File destFolder;

    @Override
    public void run() {
        CRGeneratorRunner runner = new CRGeneratorRunner();
        runner.run(crdFile, destFolder);
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new GenerateJavaSources()).execute(args);
        System.exit(exitCode);
    }
}
