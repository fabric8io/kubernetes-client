/**
 * Copyright (C) 2015 Red Hat, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
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
 * determine the `apiVersion` field associated with the annotated resource.
 * See https://kubernetes.io/docs/reference/using-api/#api-versioning for more details.
 */

@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Version {
  
  /**
   * The name of this version.
   *
   * @return the name of this version
   */
  String value();
  
  /**
   * Whether or not this version corresponds to the persisted version for the associated CRD. Note that only one version can set
   * {@code storage} to {@code true} for a given CRD.
   *
   * @return {@code true} if this version corresponds to the persisted version for the associated CRD, {@code false} otherwise
   */
  boolean storage() default false;
  
  /**
   * Whether this version is served (i.e. enabled for consumption from the REST API) or not.
   *
   * @return {@code true} if this version is served by the REST API, {@code false} otherwise
   */
  boolean served() default true;
}
