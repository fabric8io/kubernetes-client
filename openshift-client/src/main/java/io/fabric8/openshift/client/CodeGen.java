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
package io.fabric8.openshift.client;

import io.sundr.codegen.annotations.ResourceSelector;
import io.sundr.transform.annotations.VelocityTransformation;
import io.sundr.transform.annotations.VelocityTransformations;

@VelocityTransformations(
        value = {
                @VelocityTransformation("/resource-operation.vm"),
                @VelocityTransformation("/resource-handler.vm"),
                @VelocityTransformation(value = "/resource-handler-services.vm", gather = true, outputPath = "META-INF/services/io.fabric8.kubernetes.client.ResourceHandler")
        },
        resources = {
                @ResourceSelector("clusterautoscaling.properties"),
                @ResourceSelector("openshift.properties"),
                @ResourceSelector("operator.properties"),
                @ResourceSelector("operatorhub.properties"),
                @ResourceSelector("machine.properties"),
                @ResourceSelector("monitoring.properties"),
                @ResourceSelector("console.properties"),
                @ResourceSelector("machineconfig.properties"),
                @ResourceSelector("tuned.properties"),
        }

)
public class CodeGen {
}
