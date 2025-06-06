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
package io.fabric8.crd.example.joke;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import io.fabric8.crd.generator.annotation.PrinterColumn;
import io.fabric8.crd.generator.annotation.PrinterColumnFormat;

public class JokeRequestSpec {

  public enum Category {
    Any,
    Misc,
    Programming,
    Dark,
    Pun,
    Spooky,
    Christmas
  }

  public enum ExcludedTopic {
    nsfw,
    religious,
    political,
    racist,
    sexist,
    explicit
  }

  @PrinterColumn(name = "jokeCategory", priority = 1)
  @JsonPropertyDescription("category-description")
  private Category category = Category.Any;
  @PrinterColumn(name = "excludedTopics")
  private ExcludedTopic[] excluded = new ExcludedTopic[] { ExcludedTopic.nsfw, ExcludedTopic.racist,
      ExcludedTopic.sexist };
  private boolean safe;

  @PrinterColumn(format = PrinterColumnFormat.DATE_TIME)
  private String createdAt;

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public ExcludedTopic[] getExcluded() {
    return excluded;
  }

  public void setExcluded(ExcludedTopic[] excluded) {
    this.excluded = excluded;
  }

  public boolean isSafe() {
    return safe;
  }

  public void setSafe(boolean safe) {
    this.safe = safe;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }
}
