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
package io.fabric8.openshift.client.dsl.internal.core;

final class CharRange {
  private final char start;
  private final char end;

  private CharRange(char start, char end) {
    this.start = start;
    this.end = end;
  }

  public char start() {
    return start;
  }

  public char end() {
    return end;
  }

  public String rangeStr() {
    return new String(new char[]{start, end});
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {
    private char start;
    private char end;

    Builder() {}

    public Builder withStart(char start) {
      this.start = start;
      return this;
    }

    public Builder withEnd(char end) {
      this.end = end;
      return this;
    }

    public CharRange build() {
      return new CharRange(start, end);
    }
  }
}
