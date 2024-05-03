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
package io.fabric8.crd.generator.cli.examples.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BasicSpec {
  private int myInt;

  public int getMyInt() {
    return myInt;
  }

  public void setMyInt(int myInt) {
    this.myInt = myInt;
  }

  private long myLong;

  public long getMyLong() {
    return myLong;
  }

  public void setMyLong(long myLong) {
    this.myLong = myLong;
  }

  private double myDouble;

  public double getMyDouble() {
    return myDouble;
  }

  public void setMyDouble(long myDouble) {
    this.myDouble = myDouble;
  }

  private float myFloat;

  public float getMyFloat() {
    return myFloat;
  }

  public void setMyFloat(long myFloat) {
    this.myFloat = myFloat;
  }

  @JsonIgnore
  public Class<?> clazz;
}
