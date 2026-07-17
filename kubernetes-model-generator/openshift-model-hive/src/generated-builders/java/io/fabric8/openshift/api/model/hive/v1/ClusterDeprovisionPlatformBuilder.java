package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterDeprovisionPlatformBuilder extends ClusterDeprovisionPlatformFluent<ClusterDeprovisionPlatformBuilder> implements VisitableBuilder<ClusterDeprovisionPlatform,ClusterDeprovisionPlatformBuilder>{

  ClusterDeprovisionPlatformFluent<?> fluent;

  public ClusterDeprovisionPlatformBuilder() {
    this(new ClusterDeprovisionPlatform());
  }
  
  public ClusterDeprovisionPlatformBuilder(ClusterDeprovisionPlatformFluent<?> fluent) {
    this(fluent, new ClusterDeprovisionPlatform());
  }
  
  public ClusterDeprovisionPlatformBuilder(ClusterDeprovisionPlatform instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterDeprovisionPlatformBuilder(ClusterDeprovisionPlatformFluent<?> fluent,ClusterDeprovisionPlatform instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterDeprovisionPlatform build() {
    ClusterDeprovisionPlatform buildable = new ClusterDeprovisionPlatform(fluent.buildAws(), fluent.buildAzure(), fluent.buildGcp(), fluent.buildIbmcloud(), fluent.buildOpenstack(), fluent.buildOvirt(), fluent.buildVsphere());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}