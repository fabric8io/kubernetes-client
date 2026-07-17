package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigPoolStatusConfigurationBuilder extends MachineConfigPoolStatusConfigurationFluent<MachineConfigPoolStatusConfigurationBuilder> implements VisitableBuilder<MachineConfigPoolStatusConfiguration,MachineConfigPoolStatusConfigurationBuilder>{

  MachineConfigPoolStatusConfigurationFluent<?> fluent;

  public MachineConfigPoolStatusConfigurationBuilder() {
    this(new MachineConfigPoolStatusConfiguration());
  }
  
  public MachineConfigPoolStatusConfigurationBuilder(MachineConfigPoolStatusConfigurationFluent<?> fluent) {
    this(fluent, new MachineConfigPoolStatusConfiguration());
  }
  
  public MachineConfigPoolStatusConfigurationBuilder(MachineConfigPoolStatusConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigPoolStatusConfigurationBuilder(MachineConfigPoolStatusConfigurationFluent<?> fluent,MachineConfigPoolStatusConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigPoolStatusConfiguration build() {
    MachineConfigPoolStatusConfiguration buildable = new MachineConfigPoolStatusConfiguration(fluent.getApiVersion(), fluent.getFieldPath(), fluent.getKind(), fluent.getName(), fluent.getNamespace(), fluent.getResourceVersion(), fluent.buildSource(), fluent.getUid());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}