package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigNodeStatusConfigImageBuilder extends MachineConfigNodeStatusConfigImageFluent<MachineConfigNodeStatusConfigImageBuilder> implements VisitableBuilder<MachineConfigNodeStatusConfigImage,MachineConfigNodeStatusConfigImageBuilder>{

  MachineConfigNodeStatusConfigImageFluent<?> fluent;

  public MachineConfigNodeStatusConfigImageBuilder() {
    this(new MachineConfigNodeStatusConfigImage());
  }
  
  public MachineConfigNodeStatusConfigImageBuilder(MachineConfigNodeStatusConfigImageFluent<?> fluent) {
    this(fluent, new MachineConfigNodeStatusConfigImage());
  }
  
  public MachineConfigNodeStatusConfigImageBuilder(MachineConfigNodeStatusConfigImage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigNodeStatusConfigImageBuilder(MachineConfigNodeStatusConfigImageFluent<?> fluent,MachineConfigNodeStatusConfigImage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigNodeStatusConfigImage build() {
    MachineConfigNodeStatusConfigImage buildable = new MachineConfigNodeStatusConfigImage(fluent.getCurrentImage(), fluent.getDesiredImage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}