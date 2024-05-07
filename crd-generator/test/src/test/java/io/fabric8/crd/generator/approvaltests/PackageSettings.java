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
package io.fabric8.crd.generator.approvaltests;

import org.approvaltests.core.ApprovalFailureReporter;
import org.approvaltests.reporters.QuietReporter;

/**
 * @see <a href=
 *      "https://github.com/approvals/ApprovalTests.Java/blob/master/approvaltests/docs/explanations/BestConfigurationPractices.md">
 *      ApprovalTests - Best Configuration Practices</a>
 */
public class PackageSettings {
  /**
   * Disable Diff-Reporter
   */
  @SuppressWarnings("unused")
  public static ApprovalFailureReporter UseReporter = new QuietReporter();
  public String ApprovalBaseDirectory = "../resources";
}
