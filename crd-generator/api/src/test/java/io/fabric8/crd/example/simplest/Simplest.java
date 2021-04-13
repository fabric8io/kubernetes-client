package io.fabric8.crd.example.simplest;

import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

@Group("samples.fabric8.io")
@Version("v1alpha1")
public class Simplest extends CustomResource<SimplestSpec,SimplestStatus> {

}
