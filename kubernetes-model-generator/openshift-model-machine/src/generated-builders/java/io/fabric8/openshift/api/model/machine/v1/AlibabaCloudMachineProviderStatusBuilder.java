package io.fabric8.openshift.api.model.machine.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AlibabaCloudMachineProviderStatusBuilder extends AlibabaCloudMachineProviderStatusFluent<AlibabaCloudMachineProviderStatusBuilder> implements VisitableBuilder<AlibabaCloudMachineProviderStatus,AlibabaCloudMachineProviderStatusBuilder>{

  AlibabaCloudMachineProviderStatusFluent<?> fluent;

  public AlibabaCloudMachineProviderStatusBuilder() {
    this(new AlibabaCloudMachineProviderStatus());
  }
  
  public AlibabaCloudMachineProviderStatusBuilder(AlibabaCloudMachineProviderStatusFluent<?> fluent) {
    this(fluent, new AlibabaCloudMachineProviderStatus());
  }
  
  public AlibabaCloudMachineProviderStatusBuilder(AlibabaCloudMachineProviderStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AlibabaCloudMachineProviderStatusBuilder(AlibabaCloudMachineProviderStatusFluent<?> fluent,AlibabaCloudMachineProviderStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AlibabaCloudMachineProviderStatus build() {
    AlibabaCloudMachineProviderStatus buildable = new AlibabaCloudMachineProviderStatus(fluent.getApiVersion(), fluent.getConditions(), fluent.getInstanceId(), fluent.getInstanceState(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}