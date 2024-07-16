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
package io.fabric8.kubernetes.schema.generator;

import java.util.Comparator;
import java.util.List;

public class PropertyOrderComparator<T> implements Comparator<T> {
  private final List<T> preferredOrder;

  public PropertyOrderComparator(List<T> preferredOrder) {
    this.preferredOrder = preferredOrder;
  }

  @Override
  public int compare(T o1, T o2) {
    final int index1 = preferredOrder.indexOf(o1);
    final int index2 = preferredOrder.indexOf(o2);
    if (index1 != -1 && index2 != -1) {
      return Integer.compare(index1, index2);
    } else if (index1 != -1) {
      return -1;
    } else if (index2 != -1) {
      return 1;
    } else {
      // Neither key is in the preferred keys list, maintain their insertion order
      return 0;
    }
  }
}
