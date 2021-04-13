package io.fabric8.crd.example.joke;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.fabric8.kubernetes.model.annotation.Version;

@Group("samples.javaoperatorsdk.io")
@Version("v1alpha1")
@ShortNames("jr")
public class JokeRequest extends CustomResource<JokeRequestSpec, JokeRequestStatus> implements Namespaced {

}
