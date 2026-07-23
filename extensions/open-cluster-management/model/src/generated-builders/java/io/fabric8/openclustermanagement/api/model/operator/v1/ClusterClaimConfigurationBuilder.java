package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ClusterClaimConfigurationBuilder extends ClusterClaimConfigurationFluent<ClusterClaimConfigurationBuilder> implements VisitableBuilder<ClusterClaimConfiguration,ClusterClaimConfigurationBuilder>{

  ClusterClaimConfigurationFluent<?> fluent;

  public ClusterClaimConfigurationBuilder() {
    this(new ClusterClaimConfiguration());
  }
  
  public ClusterClaimConfigurationBuilder(ClusterClaimConfigurationFluent<?> fluent) {
    this(fluent, new ClusterClaimConfiguration());
  }
  
  public ClusterClaimConfigurationBuilder(ClusterClaimConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ClusterClaimConfigurationBuilder(ClusterClaimConfigurationFluent<?> fluent,ClusterClaimConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ClusterClaimConfiguration build() {
    ClusterClaimConfiguration buildable = new ClusterClaimConfiguration(fluent.getMaxCustomClusterClaims(), fluent.getReservedClusterClaimSuffixes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}