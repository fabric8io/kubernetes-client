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
package io.fabric8.crd.generator.cli;

import io.fabric8.crd.generator.collector.CustomResourceClassLoaderException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import picocli.CommandLine;

class CRDGeneratorExecutionExceptionHandler implements CommandLine.IExecutionExceptionHandler {

  private static final Logger log = LoggerFactory.getLogger(CRDGeneratorExecutionExceptionHandler.class);

  private final CRDGeneratorCLI crdGeneratorCLI;

  CRDGeneratorExecutionExceptionHandler(CRDGeneratorCLI crdGeneratorCLI) {
    this.crdGeneratorCLI = crdGeneratorCLI;
  }

  @Override
  public int handleExecutionException(
      Exception ex,
      CommandLine commandLine,
      CommandLine.ParseResult fullParseResult) {

    commandLine.getErr().println(ex.getMessage());

    if (ex instanceof CustomResourceClassLoaderException) {
      commandLine.getErr().println();
      commandLine.getErr().println("The classloader could not load the Custom Resource class.\n" +
          "Check the list of classpath elements and add further JAR archives " +
          "or directories containing required classes " +
          "e.g. with `-cp my-dep.jar` or `-cp target/classes/`.");
      commandLine.getErr().print(crdGeneratorCLI.getDiagText());
      return CRDGeneratorExitCode.CR_CLASS_LOADING;
    }

    if (ex instanceof CRDGeneratorCLI.CustomResourceClassNotFoundException) {
      commandLine.getErr().println();
      commandLine.getErr().println("Check JAR files and directories considered to be scanned " +
          "as well as your filters. At least one Custom Resource class " +
          "must be retained after filtering.");
      commandLine.getErr().print(crdGeneratorCLI.getDiagText());
      return CRDGeneratorExitCode.NO_CR_CLASSES_RETAINED;
    }

    if (log.isDebugEnabled()) {
      commandLine.getErr().println(crdGeneratorCLI.getDiagText());
    }

    log.trace(ex.getMessage(), ex);
    return CRDGeneratorExitCode.SOFTWARE;
  }
}
