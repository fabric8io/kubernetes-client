package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class VSphereMachineProviderStatusBuilder extends VSphereMachineProviderStatusFluent<VSphereMachineProviderStatusBuilder> implements VisitableBuilder<VSphereMachineProviderStatus,VSphereMachineProviderStatusBuilder>{

  VSphereMachineProviderStatusFluent<?> fluent;

  public VSphereMachineProviderStatusBuilder() {
    this(new VSphereMachineProviderStatus());
  }
  
  public VSphereMachineProviderStatusBuilder(VSphereMachineProviderStatusFluent<?> fluent) {
    this(fluent, new VSphereMachineProviderStatus());
  }
  
  public VSphereMachineProviderStatusBuilder(VSphereMachineProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public VSphereMachineProviderStatusBuilder(VSphereMachineProviderStatusFluent<?> fluent,VSphereMachineProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public VSphereMachineProviderStatus build() {
    VSphereMachineProviderStatus buildable = new VSphereMachineProviderStatus(fluent.getApiVersion(), fluent.getConditions(), fluent.getInstanceId(), fluent.getInstanceState(), fluent.getKind(), fluent.getTaskRef());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}