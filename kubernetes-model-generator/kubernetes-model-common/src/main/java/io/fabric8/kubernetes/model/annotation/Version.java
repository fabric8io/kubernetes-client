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
package io.fabric8.kubernetes.model.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

/**
 * Allows to specify which version of the API the annotated class is defined under. Together with {@link Group}, this allows to
 * determine the {@code apiVersion} field associated with the annotated resource.
 * See <a href="https://kubernetes.io/docs/reference/using-api/#api-versioning">API versioning</a> for more details.
 */
@Target({ TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface Version {

  /**
   * The name of this version.
   *
   * @return the name of this version
   */
  String value();

  /**
   * Whether this version corresponds to the persisted version for the associated CRD. Note that only one version can set
   * {@code storage} to {@code true} for a given CRD.
   *
   * @return {@code true} if this version corresponds to the persisted version for the associated CRD, {@code false} otherwise
   */
  boolean storage() default true;

  /**
   * Whether this version is served (i.e. enabled for consumption from the REST API) or not.
   *
   * @return {@code true} if this version is served by the REST API, {@code false} otherwise
   */
  boolean served() default true;

  /**
   * Whether this version is deprecated. When API requests to a resource which is deprecated are made,
   * a warning message is returned in the API response as a header.
   * The warning message for this version can be customized by defining
   * a {@link Version#deprecationWarning} if desired.
   *
   * @return {@code true} if this version is deprecated.
   */
  boolean deprecated() default false;

  /**
   * The warning message to indicate the deprecation. Note that this message is only used
   * if {@link Version#deprecated} is {@code true}.
   * The warning message should indicate the deprecated API group, version, and kind,
   * and should indicate what API group, version, and kind should be used instead, if applicable.
   *
   * @return the deprecation warning
   */
  String deprecationWarning() default "";
}
