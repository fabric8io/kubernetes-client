package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HostUpdatePolicySpecBuilder extends HostUpdatePolicySpecFluent<HostUpdatePolicySpecBuilder> implements VisitableBuilder<HostUpdatePolicySpec,HostUpdatePolicySpecBuilder>{

  HostUpdatePolicySpecFluent<?> fluent;

  public HostUpdatePolicySpecBuilder() {
    this(new HostUpdatePolicySpec());
  }
  
  public HostUpdatePolicySpecBuilder(HostUpdatePolicySpecFluent<?> fluent) {
    this(fluent, new HostUpdatePolicySpec());
  }
  
  public HostUpdatePolicySpecBuilder(HostUpdatePolicySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HostUpdatePolicySpecBuilder(HostUpdatePolicySpecFluent<?> fluent,HostUpdatePolicySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HostUpdatePolicySpec build() {
    HostUpdatePolicySpec buildable = new HostUpdatePolicySpec(fluent.getFirmwareSettings(), fluent.getFirmwareUpdates());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}