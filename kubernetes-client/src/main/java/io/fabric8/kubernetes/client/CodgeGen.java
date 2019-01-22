package io.fabric8.kubernetes.client;

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
                @ResourceSelector("kubernetes.properties")
        }

)
public class CodgeGen {
}
