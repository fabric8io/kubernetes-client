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
package io.fabric8.kubernetes.client;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Snapshots the listed JVM system properties before each test and restores
 * them (including absent values) after each test.
 * <p>
 * Apply at the class level — {@code @Nested} test classes inherit the contract
 * via the enclosing-class walk in {@link RestoreSystemPropertiesExtension}.
 * <p>
 * Also declares a write lock on {@link Resources#SYSTEM_PROPERTIES}, so when
 * {@code junit.jupiter.execution.parallel.enabled=true} is set, annotated
 * tests serialize with each other and with any read-lock holders.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
@Inherited
@ExtendWith(RestoreSystemPropertiesExtension.class)
@ResourceLock(value = Resources.SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ_WRITE)
public @interface RestoreSystemProperties {
  String[] value();
}
