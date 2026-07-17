package io.fabric8.openshift.api.model.installer.aws.v1;

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
    Platform buildable = new Platform(fluent.getAmiID(), fluent.getBestEffortDeleteIgnition(), fluent.buildDefaultMachinePlatform(), fluent.getHostedZone(), fluent.getHostedZoneRole(), fluent.getLbType(), fluent.getPreserveBootstrapIgnition(), fluent.getPropagateUserTags(), fluent.getPublicIpv4Pool(), fluent.getRegion(), fluent.buildServiceEndpoints(), fluent.getSubnets(), fluent.getUserProvisionedDNS(), fluent.getUserTags(), fluent.buildVpc());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}