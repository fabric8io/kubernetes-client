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
package io.fabric8.crd.example.person;

import java.util.List;
import java.util.Optional;

public class Person {

  private String firstName;
  private Optional<String> middleName;
  private String lastName;
  private int birthYear;
  private List<String> hobbies;
  private List<Address> addresses;
  private Type type;

  public enum Type {
    crazy, crazier
  }
}
