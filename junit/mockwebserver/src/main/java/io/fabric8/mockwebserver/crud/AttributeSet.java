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
package io.fabric8.mockwebserver.crud;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AttributeSet {

  // Package-private for testing
  final Map<Key, Attribute> attributes;

  public static AttributeSet merge(AttributeSet... attributeSets) {
    Map<Key, Attribute> all = new HashMap<>();
    if (attributeSets != null) {
      for (AttributeSet f : attributeSets) {
        if (f != null && f.attributes != null) {
          all.putAll(f.attributes);
        }
      }
    }
    return new AttributeSet(all);
  }

  public static AttributeSet map(Attribute... attributes) {
    Map<Key, Attribute> all = new HashMap<>();
    if (attributes != null) {
      for (Attribute a : attributes) {
        all.put(a.getKey(), a);
      }
    }
    return new AttributeSet(all);
  }

  public AttributeSet(Attribute... attributes) {
    this(Arrays.asList(attributes));
  }

  public AttributeSet(Collection<Attribute> attributes) {
    this(AttributeSet.map(attributes.toArray(new Attribute[0])).attributes);
  }

  public AttributeSet(Map<Key, Attribute> attributes) {
    this.attributes = attributes;
  }

  public AttributeSet add(Attribute... attr) {
    Map<Key, Attribute> all = new HashMap<>(attributes);
    for (Attribute a : attr) {
      all.put(a.getKey(), a);
    }
    return new AttributeSet(all);
  }

  public boolean containsKey(String key) {
    return containsKey(new Key(key));
  }

  public boolean containsKey(Key key) {
    return attributes.containsKey(key);
  }

  /**
   * matches if attributes in db has (or doesn't if WITHOUT command) a set of candidate attributes
   * Also supports EXISTS and NOT_EXISTS operations
   * 
   * @param candidate - set of candidate attributes
   * @return match
   */
  public boolean matches(AttributeSet candidate) {
    return candidate.attributes.values()
        .stream()
        .allMatch(this::satisfiesAttribute);
  }

  private boolean satisfiesAttribute(Attribute c) {
    switch (c.getType()) {
      case EXISTS:
        return attributes.containsKey(c.getKey());
      case NOT_EXISTS:
        return !attributes.containsKey(c.getKey());
      case IN: {
        if (attributes.containsKey(c.getKey())) {
          if (attributes.get(c.getKey()).getValues().size() > 1) {
            throw new IllegalArgumentException("Attribute " + c.getKey() + " has multiple values, can't use IN operation");
          }
          return c.getValues().contains(attributes.get(c.getKey()).getValues().iterator().next());
        }
        return false;
      }
      case NOT_IN: {
        if (attributes.containsKey(c.getKey())) {
          if (attributes.get(c.getKey()).getValues().size() > 1) {
            throw new IllegalArgumentException("Attribute " + c.getKey() + " has multiple values, can't use NOT_IN operation");
          }
          return !c.getValues().contains(attributes.get(c.getKey()).getValues().iterator().next());
        }
        return true;
      }
      case WITHOUT:
        return !attributes.containsValue(c);
      case WITH:
      default:
        return attributes.containsValue(c);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    AttributeSet that = (AttributeSet) o;
    return Objects.equals(attributes, that.attributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attributes);
  }

  public Attribute getAttribute(String key) {
    return attributes.get(new Key(key));
  }

  @Override
  public String toString() {
    return "{" +
        "attributes: " + attributes +
        '}';
  }
}
