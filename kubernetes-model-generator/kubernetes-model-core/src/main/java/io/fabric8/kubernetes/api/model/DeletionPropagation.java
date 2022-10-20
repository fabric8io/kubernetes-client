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
package io.fabric8.kubernetes.api.model;

/*
 * DeletionPropagation decides if a deletion will propagate to the dependents of
 * the object, and how the garbage collector will handle the propagation.
 *
 * Ported from https://github.com/kubernetes/apimachinery/blob/master/pkg/apis/meta/v1/types.go#L436
 */
public enum DeletionPropagation {
  /*
   * Orphans the dependents.
   */
  ORPHAN("Orphan"),
  /*
   * Deletes the object from the key-value store, the garbage collector will
   * delete the dependents in the background.
   */
  BACKGROUND("Background"),
  /*
   * The object exists in the key-value store until the garbage collector
   * deletes all the dependents whose ownerReference.blockOwnerDeletion=true
   * from the key-value store. API sever will put the "foregroundDeletion"
   * finalizer on the object, and sets its deletionTimestamp. This policy is
   * cascading, i.e., the dependents will be deleted with Foreground.
   */
  FOREGROUND("Foreground");

  private final String value;

  DeletionPropagation(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return value;
  }
}
