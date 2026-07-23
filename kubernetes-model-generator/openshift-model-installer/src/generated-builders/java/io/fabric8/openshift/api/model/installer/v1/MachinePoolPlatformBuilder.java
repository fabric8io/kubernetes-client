package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class MachinePoolPlatformBuilder extends MachinePoolPlatformFluent<MachinePoolPlatformBuilder> implements VisitableBuilder<MachinePoolPlatform,MachinePoolPlatformBuilder>{

  MachinePoolPlatformFluent<?> fluent;

  public MachinePoolPlatformBuilder() {
    this(new MachinePoolPlatform());
  }
  
  public MachinePoolPlatformBuilder(MachinePoolPlatformFluent<?> fluent) {
    this(fluent, new MachinePoolPlatform());
  }
  
  public MachinePoolPlatformBuilder(MachinePoolPlatform instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public MachinePoolPlatformBuilder(MachinePoolPlatformFluent<?> fluent,MachinePoolPlatform instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public MachinePoolPlatform build() {
    MachinePoolPlatform buildable = new MachinePoolPlatform(fluent.buildAws(), fluent.getAzure(), fluent.buildBaremetal(), fluent.buildGcp(), fluent.buildIbmcloud(), fluent.buildNutanix(), fluent.buildOpenstack(), fluent.buildOvirt(), fluent.buildPowervc(), fluent.buildPowervs(), fluent.buildVsphere());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}