package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class NutanixMachineProviderStatusBuilder extends NutanixMachineProviderStatusFluent<NutanixMachineProviderStatusBuilder> implements VisitableBuilder<NutanixMachineProviderStatus,NutanixMachineProviderStatusBuilder>{

  NutanixMachineProviderStatusFluent<?> fluent;

  public NutanixMachineProviderStatusBuilder() {
    this(new NutanixMachineProviderStatus());
  }
  
  public NutanixMachineProviderStatusBuilder(NutanixMachineProviderStatusFluent<?> fluent) {
    this(fluent, new NutanixMachineProviderStatus());
  }
  
  public NutanixMachineProviderStatusBuilder(NutanixMachineProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public NutanixMachineProviderStatusBuilder(NutanixMachineProviderStatusFluent<?> fluent,NutanixMachineProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public NutanixMachineProviderStatus build() {
    NutanixMachineProviderStatus buildable = new NutanixMachineProviderStatus(fluent.getApiVersion(), fluent.getConditions(), fluent.getKind(), fluent.getVmUUID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}