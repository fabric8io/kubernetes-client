package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigBuilder extends MachineConfigFluent<MachineConfigBuilder> implements VisitableBuilder<MachineConfig,MachineConfigBuilder>{

  MachineConfigFluent<?> fluent;

  public MachineConfigBuilder() {
    this(new MachineConfig());
  }
  
  public MachineConfigBuilder(MachineConfigFluent<?> fluent) {
    this(fluent, new MachineConfig());
  }
  
  public MachineConfigBuilder(MachineConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigBuilder(MachineConfigFluent<?> fluent,MachineConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfig build() {
    MachineConfig buildable = new MachineConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}