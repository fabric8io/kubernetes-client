package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class AWSClusterDeprovisionBuilder extends AWSClusterDeprovisionFluent<AWSClusterDeprovisionBuilder> implements VisitableBuilder<AWSClusterDeprovision,AWSClusterDeprovisionBuilder>{

  AWSClusterDeprovisionFluent<?> fluent;

  public AWSClusterDeprovisionBuilder() {
    this(new AWSClusterDeprovision());
  }
  
  public AWSClusterDeprovisionBuilder(AWSClusterDeprovisionFluent<?> fluent) {
    this(fluent, new AWSClusterDeprovision());
  }
  
  public AWSClusterDeprovisionBuilder(AWSClusterDeprovision instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public AWSClusterDeprovisionBuilder(AWSClusterDeprovisionFluent<?> fluent,AWSClusterDeprovision instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public AWSClusterDeprovision build() {
    AWSClusterDeprovision buildable = new AWSClusterDeprovision(fluent.buildCredentialsAssumeRole(), fluent.buildCredentialsSecretRef(), fluent.getHostedZoneRole(), fluent.getRegion());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}