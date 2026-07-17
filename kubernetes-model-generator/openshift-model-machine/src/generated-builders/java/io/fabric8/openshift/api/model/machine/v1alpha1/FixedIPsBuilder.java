package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FixedIPsBuilder extends FixedIPsFluent<FixedIPsBuilder> implements VisitableBuilder<FixedIPs,FixedIPsBuilder>{

  FixedIPsFluent<?> fluent;

  public FixedIPsBuilder() {
    this(new FixedIPs());
  }
  
  public FixedIPsBuilder(FixedIPsFluent<?> fluent) {
    this(fluent, new FixedIPs());
  }
  
  public FixedIPsBuilder(FixedIPs instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FixedIPsBuilder(FixedIPsFluent<?> fluent,FixedIPs instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public FixedIPs build() {
    FixedIPs buildable = new FixedIPs(fluent.getIpAddress(), fluent.getSubnetID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}