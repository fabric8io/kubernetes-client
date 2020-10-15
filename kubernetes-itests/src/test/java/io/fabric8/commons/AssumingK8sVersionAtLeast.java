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
package io.fabric8.commons;

import org.junit.AssumptionViolatedException;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class AssumingK8sVersionAtLeast implements TestRule {

  private final String majorVersion;
  private final String minorVersion;

  public AssumingK8sVersionAtLeast(String majorVersion, String minorVersion) {
    this.majorVersion = majorVersion;
    this.minorVersion = minorVersion;
  }

  @Override
  public Statement apply(Statement statement, Description description) {
    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        if (!ClusterEntity.kubernetesVersionAtLeast(majorVersion, minorVersion)){
          throw new AssumptionViolatedException(String.format(
            "Kubernetes version is below %s.%s.x, Tests are not applicable, Skipping!", majorVersion, minorVersion
          ));
        }
        statement.evaluate();
      }
    };
  }
}
