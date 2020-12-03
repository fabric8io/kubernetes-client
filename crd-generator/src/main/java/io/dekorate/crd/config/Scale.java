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

package io.dekorate.crd.config;

import io.sundr.builder.annotations.Buildable;

@Buildable(builderPackage = "io.fabric8.kubernetes.api.builder")
public class Scale {

    private String specReplicasPath;
    private String statusReplicasPath;
    private String labelSelectorPath;

    public Scale(String specReplicasPath, String statusReplicasPath, String labelSelectorPath) {
        this.specReplicasPath = specReplicasPath;
        this.statusReplicasPath = statusReplicasPath;
        this.labelSelectorPath = labelSelectorPath;
    }

    public String getSpecReplicasPath() {
        return specReplicasPath;
    }

    public void setSpecReplicasPath(String specReplicasPath) {
        this.specReplicasPath = specReplicasPath;
    }

    public String getStatusReplicasPath() {
        return statusReplicasPath;
    }

    public void setStatusReplicasPath(String statusReplicasPath) {
        this.statusReplicasPath = statusReplicasPath;
    }

    public String getLabelSelectorPath() {
        return labelSelectorPath;
    }

    public void setLabelSelectorPath(String labelSelectorPath) {
        this.labelSelectorPath = labelSelectorPath;
    }
}
