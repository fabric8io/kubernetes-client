package io.fabric8.crd.generator.datetime;

import io.fabric8.crd.generator.annotation.SchemaSwap;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.ShortNames;
import io.fabric8.kubernetes.model.annotation.Version;

@Group("org.example")
@Version("v1alpha1")
@ShortNames("ex")
@SchemaSwap(originalType = java.time.zone.ZoneRules.class, fieldName = "lastRulesCache")
public class Example extends CustomResource<ExampleSpec, Void> implements Namespaced {
}
