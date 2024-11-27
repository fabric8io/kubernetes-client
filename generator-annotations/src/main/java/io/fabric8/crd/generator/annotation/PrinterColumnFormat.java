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
package io.fabric8.crd.generator.annotation;

/**
 * The format of a printer column.
 *
 * @see <a href=
 *      "https://kubernetes.io/docs/tasks/extend-kubernetes/custom-resources/custom-resource-definitions/#format">Kubernetes
 *      Docs - CRD - Printer Column - Format</a>
 */
public enum PrinterColumnFormat {

  NONE(null),
  INT32("int32"),
  INT64("int64"),
  FLOAT("float"),
  DOUBLE("double"),
  BYTE("byte"),
  DATE("date"),
  DATE_TIME("date-time"),
  PASSWORD("password");

  public final String value;

  PrinterColumnFormat(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
