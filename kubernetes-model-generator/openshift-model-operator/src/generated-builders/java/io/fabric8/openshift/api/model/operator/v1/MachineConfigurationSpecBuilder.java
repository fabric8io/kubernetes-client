package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigurationSpecBuilder extends MachineConfigurationSpecFluent<MachineConfigurationSpecBuilder> implements VisitableBuilder<MachineConfigurationSpec,MachineConfigurationSpecBuilder>{

  MachineConfigurationSpecFluent<?> fluent;

  public MachineConfigurationSpecBuilder() {
    this(new MachineConfigurationSpec());
  }
  
  public MachineConfigurationSpecBuilder(MachineConfigurationSpecFluent<?> fluent) {
    this(fluent, new MachineConfigurationSpec());
  }
  
  public MachineConfigurationSpecBuilder(MachineConfigurationSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigurationSpecBuilder(MachineConfigurationSpecFluent<?> fluent,MachineConfigurationSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigurationSpec build() {
    MachineConfigurationSpec buildable = new MachineConfigurationSpec(fluent.getFailedRevisionLimit(), fluent.getForceRedeploymentReason(), fluent.buildIrreconcilableValidationOverrides(), fluent.getLogLevel(), fluent.buildManagedBootImages(), fluent.getManagementState(), fluent.buildNodeDisruptionPolicy(), fluent.getObservedConfig(), fluent.getOperatorLogLevel(), fluent.getSucceededRevisionLimit(), fluent.getUnsupportedConfigOverrides());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}