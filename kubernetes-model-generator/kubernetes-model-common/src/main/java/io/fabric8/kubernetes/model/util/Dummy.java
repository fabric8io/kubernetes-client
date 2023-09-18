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

package io.fabric8.kubernetes.model.util;

import io.sundr.builder.annotations.Buildable;

/**
 * Only exists to trigger builder package generation
 */
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, builderPackage = "io.fabric8.kubernetes.api.builder")
class Dummy {

}
