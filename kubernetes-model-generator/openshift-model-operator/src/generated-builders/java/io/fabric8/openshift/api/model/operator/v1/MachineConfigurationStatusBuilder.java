package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigurationStatusBuilder extends MachineConfigurationStatusFluent<MachineConfigurationStatusBuilder> implements VisitableBuilder<MachineConfigurationStatus,MachineConfigurationStatusBuilder>{

  MachineConfigurationStatusFluent<?> fluent;

  public MachineConfigurationStatusBuilder() {
    this(new MachineConfigurationStatus());
  }
  
  public MachineConfigurationStatusBuilder(MachineConfigurationStatusFluent<?> fluent) {
    this(fluent, new MachineConfigurationStatus());
  }
  
  public MachineConfigurationStatusBuilder(MachineConfigurationStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigurationStatusBuilder(MachineConfigurationStatusFluent<?> fluent,MachineConfigurationStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigurationStatus build() {
    MachineConfigurationStatus buildable = new MachineConfigurationStatus(fluent.getConditions(), fluent.buildManagedBootImagesStatus(), fluent.buildNodeDisruptionPolicyStatus(), fluent.getObservedGeneration());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}