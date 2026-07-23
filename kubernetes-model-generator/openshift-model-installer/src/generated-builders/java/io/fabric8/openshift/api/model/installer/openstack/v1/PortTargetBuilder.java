package io.fabric8.openshift.api.model.installer.openstack.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PortTargetBuilder extends PortTargetFluent<PortTargetBuilder> implements VisitableBuilder<PortTarget,PortTargetBuilder>{

  PortTargetFluent<?> fluent;

  public PortTargetBuilder() {
    this(new PortTarget());
  }
  
  public PortTargetBuilder(PortTargetFluent<?> fluent) {
    this(fluent, new PortTarget());
  }
  
  public PortTargetBuilder(PortTarget instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PortTargetBuilder(PortTargetFluent<?> fluent,PortTarget instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PortTarget build() {
    PortTarget buildable = new PortTarget(fluent.buildFixedIPs(), fluent.buildNetwork());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}