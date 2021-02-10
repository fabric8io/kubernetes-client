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
package io.fabric8.crd.generator.decorator;

import io.fabric8.kubernetes.api.builder.TypedVisitor;

public abstract class Decorator<T> extends TypedVisitor<T> implements Comparable<Decorator> {

  public Class<? extends Decorator>[] after() {
    return new Class[0];
  }

  public Class<? extends Decorator>[] before() {
    return new Class[0];
  }

  @Override
  public int compareTo(Decorator o) {
    Class c = o.getClass();
    //1st pass: ours
    for (Class b : before()) {
      if (b.isAssignableFrom(c)) {
        return -1;
      }
    }
    for (Class a : after()) {
      if (a.isAssignableFrom(c)) {
        return 1;
      }
    }
    //2nd pass: their
    for (Class b : o.before()) {
      if (b.isAssignableFrom(getClass())) {
        return 1;
      }
    }
    for (Class a : o.after()) {
      if (a.isAssignableFrom(getClass())) {
        return -1;
      }
    }
    //We only want to return 0 if decorators are equal.
    //If we return 0 otherwise The TreeSet that holds the Decorators will drop o.
    if (this.equals(o)) {
      return 0;
    }
    return -1;
  }
}
