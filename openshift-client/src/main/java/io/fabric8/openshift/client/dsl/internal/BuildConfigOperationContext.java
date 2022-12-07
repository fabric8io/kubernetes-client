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
package io.fabric8.openshift.client.dsl.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BuildConfigOperationContext {

  private String secret;
  private String triggerType;

  private String authorName;
  private String authorEmail;
  private String committerName;
  private String committerEmail;
  private String commit;
  private String message;
  private String asFile;

  public BuildConfigOperationContext withSecret(String secret) {
    return toBuilder().secret(secret).build();
  }

  public BuildConfigOperationContext withTriggerType(String triggerType) {
    return toBuilder().triggerType(triggerType).build();
  }

  public BuildConfigOperationContext withAuthorName(String authorName) {
    return toBuilder().authorName(authorName).build();
  }

  public BuildConfigOperationContext withAuthorEmail(String authorEmail) {
    return toBuilder().authorEmail(authorEmail).build();
  }

  public BuildConfigOperationContext withCommitterName(String committerName) {
    return toBuilder().committerName(committerName).build();
  }

  public BuildConfigOperationContext withCommitterEmail(String committerEmail) {
    return toBuilder().committerEmail(committerEmail).build();
  }

  public BuildConfigOperationContext withCommit(String commit) {
    return toBuilder().commit(commit).build();
  }

  public BuildConfigOperationContext withMessage(String message) {
    return toBuilder().message(message).build();
  }

  public BuildConfigOperationContext withAsFile(String asFile) {
    return toBuilder().asFile(asFile).build();
  }

}
