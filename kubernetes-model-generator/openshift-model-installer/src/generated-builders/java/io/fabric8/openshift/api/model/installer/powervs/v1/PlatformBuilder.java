package io.fabric8.openshift.api.model.installer.powervs.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PlatformBuilder extends PlatformFluent<PlatformBuilder> implements VisitableBuilder<Platform,PlatformBuilder>{

  PlatformFluent<?> fluent;

  public PlatformBuilder() {
    this(new Platform());
  }
  
  public PlatformBuilder(PlatformFluent<?> fluent) {
    this(fluent, new Platform());
  }
  
  public PlatformBuilder(Platform instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PlatformBuilder(PlatformFluent<?> fluent,Platform instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Platform build() {
    Platform buildable = new Platform(fluent.getClusterOSImage(), fluent.buildDefaultMachinePlatform(), fluent.getPowervsResourceGroup(), fluent.getRegion(), fluent.getServiceEndpoints(), fluent.getServiceInstanceGUID(), fluent.getTgName(), fluent.getUserID(), fluent.getVpcName(), fluent.getVpcRegion(), fluent.getVpcSubnets(), fluent.getZone());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}