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
package io.fabric8.crd.generator.approvaltests.validation;

import io.fabric8.generator.annotation.Max;
import io.fabric8.generator.annotation.Min;
import io.fabric8.generator.annotation.Pattern;
import io.fabric8.generator.annotation.Size;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ValidationSpec {

  private ValidationOnInteger onInteger;
  private ValidationOnIntegerPrim onIntegerPrim;
  private ValidationOnLong onLong;
  private ValidationOnLongPrim onLongPrim;
  private ValidationOnFloat onFloat;
  private ValidationOnFloatPrim onFloatPrim;
  private ValidationOnDouble onDouble;
  private ValidationOnDoublePrim onDoublePrim;
  private ValidationOnString onString;
  private ValidationOnList onList;
  private ValidationOnMap onMap;

  @Data
  static class ValidationOnInteger {
    @Min(1)
    private Integer minimum1;
    @Min(value = 1, inclusive = false)
    private Integer minimumExclusive1;
    @Max(1)
    private Integer maximum1;
    @Max(value = 1, inclusive = false)
    private Integer maximumExclusive1;
    @Min(1)
    @Max(3)
    private Integer minimum1Maximum3;
    @Min(value = 1, inclusive = false)
    @Max(value = 3, inclusive = false)
    private Integer minimumExclusive1MaximumExclusive3;
  }

  @Data
  static class ValidationOnIntegerPrim {
    @Min(1)
    private int minimum1;
    @Min(value = 1, inclusive = false)
    private int minimumExclusive1;
    @Max(1)
    private int maximum1;
    @Max(value = 1, inclusive = false)
    private int maximumExclusive1;
    @Min(1)
    @Max(3)
    private int minimum1Maximum3;
    @Min(value = 1, inclusive = false)
    @Max(value = 3, inclusive = false)
    private int minimumExclusive1MaximumExclusive3;
  }

  @Data
  static class ValidationOnLong {
    @Min(1)
    private Long minimum1;
    @Min(value = 1, inclusive = false)
    private Long minimumExclusive1;
    @Max(1)
    private Long maximum1;
    @Max(value = 1, inclusive = false)
    private Long maximumExclusive1;
    @Min(1)
    @Max(3)
    private Long minimum1Maximum3;
    @Min(value = 1, inclusive = false)
    @Max(value = 3, inclusive = false)
    private Long minimumExclusive1MaximumExclusive3;
  }

  @Data
  static class ValidationOnLongPrim {
    @Min(1)
    private long minimum1;
    @Min(value = 1, inclusive = false)
    private long minimumExclusive1;
    @Max(1)
    private long maximum1;
    @Max(value = 1, inclusive = false)
    private long maximumExclusive1;
    @Min(1)
    @Max(3)
    private long minimum1Maximum3;
    @Min(value = 1, inclusive = false)
    @Max(value = 3, inclusive = false)
    private long minimumExclusive1MaximumExclusive3;
  }

  @Data
  static class ValidationOnFloat {
    @Min(1)
    private Float minimum1;
    @Min(value = 1, inclusive = false)
    private Float minimumExclusive1;
    @Max(1)
    private Float maximum1;
    @Max(value = 1, inclusive = false)
    private Float maximumExclusive1;
    @Min(1)
    @Max(3)
    private Float minimum1Maximum3;
    @Min(value = 1, inclusive = false)
    @Max(value = 3, inclusive = false)
    private Float minimumExclusive1MaximumExclusive3;
  }

  @Data
  static class ValidationOnFloatPrim {
    @Min(1)
    private float minimum1;
    @Min(value = 1, inclusive = false)
    private float minimumExclusive1;
    @Max(1)
    private float maximum1;
    @Max(value = 1, inclusive = false)
    private float maximumExclusive1;
    @Min(1)
    @Max(3)
    private float minimum1Maximum3;
    @Min(value = 1, inclusive = false)
    @Max(value = 3, inclusive = false)
    private float minimumExclusive1MaximumExclusive3;
  }

  @Data
  static class ValidationOnDouble {
    @Min(1)
    private Double minimum1;
    @Min(value = 1, inclusive = false)
    private Double minimumExclusive1;
    @Max(1)
    private Double maximum1;
    @Max(value = 1, inclusive = false)
    private Double maximumExclusive1;
    @Min(1)
    @Max(3)
    private Double minimum1Maximum3;
    @Min(value = 1, inclusive = false)
    @Max(value = 3, inclusive = false)
    private Double minimumExclusive1MaximumExclusive3;
  }

  @Data
  static class ValidationOnDoublePrim {
    @Min(1)
    private double minimum1;
    @Min(value = 1, inclusive = false)
    private double minimumExclusive1;
    @Max(1)
    private double maximum1;
    @Max(value = 1, inclusive = false)
    private double maximumExclusive1;
    @Min(1)
    @Max(3)
    private double minimum1Maximum3;
    @Min(value = 1, inclusive = false)
    @Max(value = 3, inclusive = false)
    private double minimumExclusive1MaximumExclusive3;
  }

  @Data
  static class ValidationOnString {
    @Pattern("(a|b)+")
    private String pattern;

    @Size(min = 1)
    private String minLength1;
    @Size(max = 1)
    private String maxLength1;
    @Size(min = 1, max = 3)
    private String minLength1maxLength3;
  }

  @Data
  static class ValidationOnList {
    @Size(min = 1)
    private List<String> minItems1;
    @Size(max = 1)
    private List<String> maxItems1;
    @Size(min = 1, max = 3)
    private List<String> minItems1maxItems3;
  }

  @Data
  static class ValidationOnMap {
    @Size(min = 1)
    private Map<String, String> minItems1;
    @Size(max = 1)
    private Map<String, String> maxItems1;
    @Size(min = 1, max = 3)
    private Map<String, String> minItems1maxItems3;
  }

}
