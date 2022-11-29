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
package io.fabric8.crd.generator;

import io.fabric8.crd.generator.v1.decorator.AddAdditionPrinterColumnDecorator;
import io.fabric8.crd.generator.v1.decorator.SortPrinterColumnsDecorator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResourcesTest {

  @Test
  public void shouldSupportMultiplePrinterColumns() {
    Resources r = new Resources();

    AddAdditionPrinterColumnDecorator dec1 = new AddAdditionPrinterColumnDecorator("resource", "v1", "string", "replicas",
        ".replicas", null, null);
    AddAdditionPrinterColumnDecorator dec2 = new AddAdditionPrinterColumnDecorator("resource", "v1", "boolean", "enabled",
        ".replicas", null, null);

    r.decorate(dec1);
    r.decorate(dec2);

    assertEquals(2, r.getDecorators().size());
    assertTrue(r.getDecorators().contains(dec1));
    assertTrue(r.getDecorators().contains(dec2));
  }

  @Test
  public void shouldSupportMultipleSortPrinterColums() {
    Resources r = new Resources();
    SortPrinterColumnsDecorator dec1 = new SortPrinterColumnsDecorator("my-crd", "v1");
    SortPrinterColumnsDecorator dec2 = new SortPrinterColumnsDecorator("my-crd", "v2");
    r.decorate(dec1);
    r.decorate(dec2);
    assertEquals(2, r.getDecorators().size());
    r.getDecorators().stream().forEach(d -> System.out.println(d));
    assertTrue(r.getDecorators().contains(dec1));
    assertTrue(r.getDecorators().contains(dec2));
  }
}
