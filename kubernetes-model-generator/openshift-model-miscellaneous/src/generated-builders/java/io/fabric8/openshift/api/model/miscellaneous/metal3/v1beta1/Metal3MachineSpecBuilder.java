package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class Metal3MachineSpecBuilder extends Metal3MachineSpecFluent<Metal3MachineSpecBuilder> implements VisitableBuilder<Metal3MachineSpec,Metal3MachineSpecBuilder>{

  Metal3MachineSpecFluent<?> fluent;

  public Metal3MachineSpecBuilder() {
    this(new Metal3MachineSpec());
  }
  
  public Metal3MachineSpecBuilder(Metal3MachineSpecFluent<?> fluent) {
    this(fluent, new Metal3MachineSpec());
  }
  
  public Metal3MachineSpecBuilder(Metal3MachineSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public Metal3MachineSpecBuilder(Metal3MachineSpecFluent<?> fluent,Metal3MachineSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Metal3MachineSpec build() {
    Metal3MachineSpec buildable = new Metal3MachineSpec(fluent.getAutomatedCleaningMode(), fluent.buildCustomDeploy(), fluent.buildDataTemplate(), fluent.getFailureDomain(), fluent.buildHostSelector(), fluent.buildImage(), fluent.getMetaData(), fluent.getNetworkData(), fluent.getProviderID(), fluent.getUserData());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}