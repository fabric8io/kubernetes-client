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
package io.fabric8.kubeapitest.junit;

import io.fabric8.kubeapitest.KubeAPIServerConfig;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * For docs of attributes see {@link KubeAPIServerConfig}.
 */
@ExtendWith(KubeAPIServerExtension.class)
@Target({ TYPE, METHOD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Inherited
public @interface EnableKubeAPIServer {

  String NOT_SET = "NOT_SET";

  String kubeAPIVersion() default NOT_SET;

  String[] apiServerFlags() default {};

  boolean updateKubeConfigFile() default false;
}
