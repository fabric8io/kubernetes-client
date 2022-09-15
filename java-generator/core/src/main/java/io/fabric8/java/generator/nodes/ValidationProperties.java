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
package io.fabric8.java.generator.nodes;

/**
 * This class instances store the values for a generic JSON schema validation related properties, like `minimum`,
 * `maximum`, etc.
 */
public class ValidationProperties {
  private final Double maximum;
  private final Double minimum;
  private final String pattern;

  private ValidationProperties(final Double maximum, final Double minimum, final String pattern) {
    this.maximum = maximum;
    this.minimum = minimum;
    this.pattern = pattern;
  }

  public Double getMaximum() {
    return maximum;
  }

  public Double getMinimum() {
    return minimum;
  }

  public String getPattern() {
    return pattern;
  }

  public static final class Builder {
    private Double maximum;
    private Double minimum;
    private String pattern;

    private Builder() {
    }

    public static Builder getInstance() {
      return new Builder();
    }

    public Builder withMaximum(final Double maximum) {
      this.maximum = maximum;
      return this;
    }

    public Builder withMinimum(final Double minimum) {
      this.minimum = minimum;
      return this;
    }

    public Builder withPattern(final String pattern) {
      this.pattern = pattern;
      return this;
    }

    public ValidationProperties build() {
      return new ValidationProperties(maximum, minimum, pattern);
    }
  }
}
