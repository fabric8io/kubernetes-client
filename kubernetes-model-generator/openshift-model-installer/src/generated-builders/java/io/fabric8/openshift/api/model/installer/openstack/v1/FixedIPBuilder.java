package io.fabric8.openshift.api.model.installer.openstack.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FixedIPBuilder extends FixedIPFluent<FixedIPBuilder> implements VisitableBuilder<FixedIP,FixedIPBuilder>{

  FixedIPFluent<?> fluent;

  public FixedIPBuilder() {
    this(new FixedIP());
  }
  
  public FixedIPBuilder(FixedIPFluent<?> fluent) {
    this(fluent, new FixedIP());
  }
  
  public FixedIPBuilder(FixedIP instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FixedIPBuilder(FixedIPFluent<?> fluent,FixedIP instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FixedIP build() {
    FixedIP buildable = new FixedIP(fluent.buildSubnet());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}