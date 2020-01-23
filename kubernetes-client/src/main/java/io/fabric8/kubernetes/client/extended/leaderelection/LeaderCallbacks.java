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
package io.fabric8.kubernetes.client.extended.leaderelection;

import java.util.Objects;
import java.util.function.Consumer;

public class LeaderCallbacks {

  private Runnable onStartLeading;
  private Runnable onStopLeading;
  private Consumer<String> onNewLeader;

  public LeaderCallbacks(Runnable onStartLeading, Runnable onStopLeading, Consumer<String> onNewLeader) {
    this.onStartLeading = Objects.requireNonNull(onStartLeading, "onStartLeading callback is required");
    this.onStopLeading = Objects.requireNonNull(onStopLeading, "onStopLeading callback is required");
    this.onNewLeader = Objects.requireNonNull(onNewLeader, "onNewLeader callback is required");
  }

  public void onStartLeading() {
    onStartLeading.run();
  }

  public void onStopLeading() {
    onStopLeading.run();
  }

  public void onNewLeader(String id) {
    onNewLeader.accept(id);
  }
}
