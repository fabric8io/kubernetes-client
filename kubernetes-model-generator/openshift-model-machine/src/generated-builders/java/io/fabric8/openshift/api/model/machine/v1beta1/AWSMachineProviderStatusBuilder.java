package io.fabric8.openshift.api.model.machine.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSMachineProviderStatusBuilder extends AWSMachineProviderStatusFluent<AWSMachineProviderStatusBuilder> implements VisitableBuilder<AWSMachineProviderStatus,AWSMachineProviderStatusBuilder>{

  AWSMachineProviderStatusFluent<?> fluent;

  public AWSMachineProviderStatusBuilder() {
    this(new AWSMachineProviderStatus());
  }
  
  public AWSMachineProviderStatusBuilder(AWSMachineProviderStatusFluent<?> fluent) {
    this(fluent, new AWSMachineProviderStatus());
  }
  
  public AWSMachineProviderStatusBuilder(AWSMachineProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSMachineProviderStatusBuilder(AWSMachineProviderStatusFluent<?> fluent,AWSMachineProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSMachineProviderStatus build() {
    AWSMachineProviderStatus buildable = new AWSMachineProviderStatus(fluent.getApiVersion(), fluent.getConditions(), fluent.getInstanceId(), fluent.getInstanceState(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}