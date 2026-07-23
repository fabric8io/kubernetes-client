package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OvirtPlatformSpecBuilder extends OvirtPlatformSpecFluent<OvirtPlatformSpecBuilder> implements VisitableBuilder<OvirtPlatformSpec,OvirtPlatformSpecBuilder>{

  OvirtPlatformSpecFluent<?> fluent;

  public OvirtPlatformSpecBuilder() {
    this(new OvirtPlatformSpec());
  }
  
  public OvirtPlatformSpecBuilder(OvirtPlatformSpecFluent<?> fluent) {
    this(fluent, new OvirtPlatformSpec());
  }
  
  public OvirtPlatformSpecBuilder(OvirtPlatformSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OvirtPlatformSpecBuilder(OvirtPlatformSpecFluent<?> fluent,OvirtPlatformSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OvirtPlatformSpec build() {
    OvirtPlatformSpec buildable = new OvirtPlatformSpec();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}