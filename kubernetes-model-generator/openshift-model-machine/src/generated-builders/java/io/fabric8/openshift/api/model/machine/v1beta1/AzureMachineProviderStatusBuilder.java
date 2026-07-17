package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AzureMachineProviderStatusBuilder extends AzureMachineProviderStatusFluent<AzureMachineProviderStatusBuilder> implements VisitableBuilder<AzureMachineProviderStatus,AzureMachineProviderStatusBuilder>{

  AzureMachineProviderStatusFluent<?> fluent;

  public AzureMachineProviderStatusBuilder() {
    this(new AzureMachineProviderStatus());
  }
  
  public AzureMachineProviderStatusBuilder(AzureMachineProviderStatusFluent<?> fluent) {
    this(fluent, new AzureMachineProviderStatus());
  }
  
  public AzureMachineProviderStatusBuilder(AzureMachineProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AzureMachineProviderStatusBuilder(AzureMachineProviderStatusFluent<?> fluent,AzureMachineProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AzureMachineProviderStatus build() {
    AzureMachineProviderStatus buildable = new AzureMachineProviderStatus(fluent.getApiVersion(), fluent.getConditions(), fluent.getKind(), fluent.buildMetadata(), fluent.getVmId(), fluent.getVmState());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}