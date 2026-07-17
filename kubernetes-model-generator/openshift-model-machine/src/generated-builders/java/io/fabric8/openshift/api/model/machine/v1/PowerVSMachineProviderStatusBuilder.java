package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PowerVSMachineProviderStatusBuilder extends PowerVSMachineProviderStatusFluent<PowerVSMachineProviderStatusBuilder> implements VisitableBuilder<PowerVSMachineProviderStatus,PowerVSMachineProviderStatusBuilder>{

  PowerVSMachineProviderStatusFluent<?> fluent;

  public PowerVSMachineProviderStatusBuilder() {
    this(new PowerVSMachineProviderStatus());
  }
  
  public PowerVSMachineProviderStatusBuilder(PowerVSMachineProviderStatusFluent<?> fluent) {
    this(fluent, new PowerVSMachineProviderStatus());
  }
  
  public PowerVSMachineProviderStatusBuilder(PowerVSMachineProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PowerVSMachineProviderStatusBuilder(PowerVSMachineProviderStatusFluent<?> fluent,PowerVSMachineProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PowerVSMachineProviderStatus build() {
    PowerVSMachineProviderStatus buildable = new PowerVSMachineProviderStatus(fluent.getApiVersion(), fluent.getConditions(), fluent.getInstanceId(), fluent.getInstanceState(), fluent.getKind(), fluent.getServiceInstanceID());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}