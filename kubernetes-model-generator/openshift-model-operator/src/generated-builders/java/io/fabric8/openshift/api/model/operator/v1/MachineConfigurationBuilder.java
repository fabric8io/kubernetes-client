package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigurationBuilder extends MachineConfigurationFluent<MachineConfigurationBuilder> implements VisitableBuilder<MachineConfiguration,MachineConfigurationBuilder>{

  MachineConfigurationFluent<?> fluent;

  public MachineConfigurationBuilder() {
    this(new MachineConfiguration());
  }
  
  public MachineConfigurationBuilder(MachineConfigurationFluent<?> fluent) {
    this(fluent, new MachineConfiguration());
  }
  
  public MachineConfigurationBuilder(MachineConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigurationBuilder(MachineConfigurationFluent<?> fluent,MachineConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfiguration build() {
    MachineConfiguration buildable = new MachineConfiguration(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}