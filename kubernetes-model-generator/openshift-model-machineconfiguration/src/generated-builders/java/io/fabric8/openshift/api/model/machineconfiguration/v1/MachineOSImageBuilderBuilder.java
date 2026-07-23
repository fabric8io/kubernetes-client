package io.fabric8.openshift.api.model.machineconfiguration.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachineOSImageBuilderBuilder extends MachineOSImageBuilderFluent<MachineOSImageBuilderBuilder> implements VisitableBuilder<MachineOSImageBuilder,MachineOSImageBuilderBuilder>{

  MachineOSImageBuilderFluent<?> fluent;

  public MachineOSImageBuilderBuilder() {
    this(new MachineOSImageBuilder());
  }
  
  public MachineOSImageBuilderBuilder(MachineOSImageBuilderFluent<?> fluent) {
    this(fluent, new MachineOSImageBuilder());
  }
  
  public MachineOSImageBuilderBuilder(MachineOSImageBuilder instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachineOSImageBuilderBuilder(MachineOSImageBuilderFluent<?> fluent,MachineOSImageBuilder instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachineOSImageBuilder build() {
    MachineOSImageBuilder buildable = new MachineOSImageBuilder(fluent.getImageBuilderType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}