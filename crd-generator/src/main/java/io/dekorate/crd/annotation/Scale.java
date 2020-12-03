/**
 * Copyright 2018 The original authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
**/

package io.dekorate.crd.annotation;

import io.dekorate.crd.Defaults;

public @interface Scale {

  String specReplicasPath() default Defaults.SPEC_REPLICAS_PATH;

  String statusReplicasPath() default Defaults.STATUS_REPLICAS_PATH;

  String labelSelectorPath() default Defaults.LABEL_SELECTOR_PATH;
}
