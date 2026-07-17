package io.fabric8.openshift.api.model.installer.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterMetadataBuilder extends ClusterMetadataFluent<ClusterMetadataBuilder> implements VisitableBuilder<ClusterMetadata,ClusterMetadataBuilder>{

  ClusterMetadataFluent<?> fluent;

  public ClusterMetadataBuilder() {
    this(new ClusterMetadata());
  }
  
  public ClusterMetadataBuilder(ClusterMetadataFluent<?> fluent) {
    this(fluent, new ClusterMetadata());
  }
  
  public ClusterMetadataBuilder(ClusterMetadata instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterMetadataBuilder(ClusterMetadataFluent<?> fluent,ClusterMetadata instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterMetadata build() {
    ClusterMetadata buildable = new ClusterMetadata(fluent.buildAws(), fluent.getAzure(), fluent.buildBaremetal(), fluent.getClusterID(), fluent.getClusterName(), fluent.getCustomFeatureSet(), fluent.getFeatureSet(), fluent.buildGcp(), fluent.buildIbmcloud(), fluent.getInfraID(), fluent.buildNutanix(), fluent.buildOpenstack(), fluent.buildOvirt(), fluent.buildPowervc(), fluent.buildPowervs(), fluent.buildVsphere());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}