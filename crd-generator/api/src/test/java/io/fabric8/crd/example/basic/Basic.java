package io.fabric8.crd.example.basic;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

@Group("sample.fabric8.io")
@Version("v1alpha1")
public class Basic extends CustomResource<BasicSpec, BasicStatus> implements Namespaced {

}
