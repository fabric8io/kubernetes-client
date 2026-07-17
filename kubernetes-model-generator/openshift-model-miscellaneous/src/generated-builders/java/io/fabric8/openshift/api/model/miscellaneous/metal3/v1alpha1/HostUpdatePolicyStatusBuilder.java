package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostUpdatePolicyStatusBuilder extends HostUpdatePolicyStatusFluent<HostUpdatePolicyStatusBuilder> implements VisitableBuilder<HostUpdatePolicyStatus,HostUpdatePolicyStatusBuilder>{

  HostUpdatePolicyStatusFluent<?> fluent;

  public HostUpdatePolicyStatusBuilder() {
    this(new HostUpdatePolicyStatus());
  }
  
  public HostUpdatePolicyStatusBuilder(HostUpdatePolicyStatusFluent<?> fluent) {
    this(fluent, new HostUpdatePolicyStatus());
  }
  
  public HostUpdatePolicyStatusBuilder(HostUpdatePolicyStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostUpdatePolicyStatusBuilder(HostUpdatePolicyStatusFluent<?> fluent,HostUpdatePolicyStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostUpdatePolicyStatus build() {
    HostUpdatePolicyStatus buildable = new HostUpdatePolicyStatus();
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}