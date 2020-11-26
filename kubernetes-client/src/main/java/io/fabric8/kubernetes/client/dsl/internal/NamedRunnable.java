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
package io.fabric8.kubernetes.client.dsl.internal;

import java.util.Objects;

abstract class NamedRunnable implements Runnable {
  private final String name;

  NamedRunnable(String name) {
    this.name = Objects.requireNonNull(name);
  }

  private void tryToSetName(String value) {
    try {
      Thread.currentThread().setName(value);
    } catch (SecurityException ignored) {
      // Ignored
    }
  }

  public final void run() {
    String oldName = Thread.currentThread().getName();
    tryToSetName(this.name + "|" + oldName);
    try {
      execute();
    } finally {
      tryToSetName(oldName);
    }
  }

  protected abstract void execute();
}
