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
package io.fabric8.crd.generator.example;

import com.spun.util.StringUtils;
import com.spun.util.tests.StackTraceReflectionResult;
import com.spun.util.tests.TestUtils;
import org.approvaltests.namer.ApprovalNamer;
import org.approvaltests.namer.AttributeStackSelector;
import org.approvaltests.namer.NamerFactory;
import org.approvaltests.writers.Writer;

import java.io.File;

class CRDGeneratorApprovalNamer implements ApprovalNamer {

  private final String implementationClassName;
  private final String baseDirectory;
  private final String additionalInformation;

  public CRDGeneratorApprovalNamer(Class<?> abstractClass, Class<?> implementationClass) {
    StackTraceReflectionResult info = TestUtils.getCurrentFileForMethod(new AttributeStackSelector());
    additionalInformation = NamerFactory.getAndClearAdditionalInformation();

    String abstractClassPath = abstractClass.getPackage().getName().replace('.', File.separatorChar);
    String implementationClassPath = implementationClass.getPackage().getName().replace('.', File.separatorChar);
    this.implementationClassName = implementationClass.getSimpleName();

    String abstractClassAbsolutePath = info.getSourceFile().getAbsolutePath();
    this.baseDirectory = abstractClassAbsolutePath.replace(abstractClassPath, File.separatorChar + implementationClassPath);
  }

  public CRDGeneratorApprovalNamer(String baseDirectory,
      String implementationClassName,
      String additionalInformation) {
    this.baseDirectory = baseDirectory;
    this.implementationClassName = implementationClassName;
    this.additionalInformation = additionalInformation;
  }

  @Override
  public String getApprovalName() {
    return String.format("%s%s", implementationClassName, additionalInformation);
  }

  @Override
  public String getSourceFilePath() {
    String sub = NamerFactory.getSubdirectory();
    String subdirectory = StringUtils.isEmpty(sub) ? "" : sub + File.separator;
    return baseDirectory + File.separator + subdirectory;
  }

  @Override
  public File getReceivedFile(String extensionWithDot) {
    return new File(getSourceFilePath() + File.separatorChar + getApprovalName() + Writer.received + extensionWithDot);
  }

  @Override
  public File getApprovedFile(String extensionWithDot) {
    return new File(getSourceFilePath() + File.separatorChar + getApprovalName() + Writer.approved + extensionWithDot);
  }

  public ApprovalNamer addAdditionalInformation(String additionalInformation) {
    return new CRDGeneratorApprovalNamer(this.baseDirectory, this.implementationClassName,
        this.additionalInformation + "." + additionalInformation);
  }
}
