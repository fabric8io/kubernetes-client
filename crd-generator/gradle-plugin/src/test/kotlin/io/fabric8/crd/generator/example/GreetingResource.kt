package io.fabric8.crd.generator.example

import io.fabric8.kubernetes.client.CustomResource
import io.fabric8.kubernetes.model.annotation.Group
import io.fabric8.kubernetes.model.annotation.Kind
import io.fabric8.kubernetes.model.annotation.Version

@Group("example.com")
@Version("v1")
@Kind("Greeting")
class GreetingResource : CustomResource<GreetingResource.Spec, GreetingResource.Status>() {
    data class Spec(
        val hello: String = "",
    )

    class Status(
        val greeting: String = "",
    )
}
