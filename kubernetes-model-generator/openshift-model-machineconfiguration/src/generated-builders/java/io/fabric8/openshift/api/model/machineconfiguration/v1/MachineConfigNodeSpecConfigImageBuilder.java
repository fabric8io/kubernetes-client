package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineConfigNodeSpecConfigImageBuilder extends MachineConfigNodeSpecConfigImageFluent<MachineConfigNodeSpecConfigImageBuilder> implements VisitableBuilder<MachineConfigNodeSpecConfigImage,MachineConfigNodeSpecConfigImageBuilder>{

  MachineConfigNodeSpecConfigImageFluent<?> fluent;

  public MachineConfigNodeSpecConfigImageBuilder() {
    this(new MachineConfigNodeSpecConfigImage());
  }
  
  public MachineConfigNodeSpecConfigImageBuilder(MachineConfigNodeSpecConfigImageFluent<?> fluent) {
    this(fluent, new MachineConfigNodeSpecConfigImage());
  }
  
  public MachineConfigNodeSpecConfigImageBuilder(MachineConfigNodeSpecConfigImage instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineConfigNodeSpecConfigImageBuilder(MachineConfigNodeSpecConfigImageFluent<?> fluent,MachineConfigNodeSpecConfigImage instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineConfigNodeSpecConfigImage build() {
    MachineConfigNodeSpecConfigImage buildable = new MachineConfigNodeSpecConfigImage(fluent.getDesiredImage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}