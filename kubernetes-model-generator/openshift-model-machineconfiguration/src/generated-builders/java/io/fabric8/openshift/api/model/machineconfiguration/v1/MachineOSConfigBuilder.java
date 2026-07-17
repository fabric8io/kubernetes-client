package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineOSConfigBuilder extends MachineOSConfigFluent<MachineOSConfigBuilder> implements VisitableBuilder<MachineOSConfig,MachineOSConfigBuilder>{

  MachineOSConfigFluent<?> fluent;

  public MachineOSConfigBuilder() {
    this(new MachineOSConfig());
  }
  
  public MachineOSConfigBuilder(MachineOSConfigFluent<?> fluent) {
    this(fluent, new MachineOSConfig());
  }
  
  public MachineOSConfigBuilder(MachineOSConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineOSConfigBuilder(MachineOSConfigFluent<?> fluent,MachineOSConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineOSConfig build() {
    MachineOSConfig buildable = new MachineOSConfig(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}