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

package io.fabric8.kubeapitest.binary.repo;

import java.util.List;

public class ObjectList {

  private List<ObjectListItem> items;

  public List<ObjectListItem> getItems() {
    return items;
  }

  public ObjectList setItems(List<ObjectListItem> items) {
    this.items = items;
    return this;
  }
}
