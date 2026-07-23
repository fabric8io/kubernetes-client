package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class GCPMachineProviderStatusBuilder extends GCPMachineProviderStatusFluent<GCPMachineProviderStatusBuilder> implements VisitableBuilder<GCPMachineProviderStatus,GCPMachineProviderStatusBuilder>{

  GCPMachineProviderStatusFluent<?> fluent;

  public GCPMachineProviderStatusBuilder() {
    this(new GCPMachineProviderStatus());
  }
  
  public GCPMachineProviderStatusBuilder(GCPMachineProviderStatusFluent<?> fluent) {
    this(fluent, new GCPMachineProviderStatus());
  }
  
  public GCPMachineProviderStatusBuilder(GCPMachineProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public GCPMachineProviderStatusBuilder(GCPMachineProviderStatusFluent<?> fluent,GCPMachineProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public GCPMachineProviderStatus build() {
    GCPMachineProviderStatus buildable = new GCPMachineProviderStatus(fluent.getApiVersion(), fluent.getConditions(), fluent.getInstanceId(), fluent.getInstanceState(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}