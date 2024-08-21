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

import java.io.File;
import io.fabric8.kubernetes.api.model.Config;
import lombok.Getter;

@Getter
public class KubeConfigFile {
    private final File file;
    private final Config config;

    /** for testing purposes **/
    public KubeConfigFile(File file, Config config) {
      this.file = file;
      this.config = config;
    }
 }