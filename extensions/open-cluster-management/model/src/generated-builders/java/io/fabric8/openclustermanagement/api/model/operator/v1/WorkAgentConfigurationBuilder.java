package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WorkAgentConfigurationBuilder extends WorkAgentConfigurationFluent<WorkAgentConfigurationBuilder> implements VisitableBuilder<WorkAgentConfiguration,WorkAgentConfigurationBuilder>{

  WorkAgentConfigurationFluent<?> fluent;

  public WorkAgentConfigurationBuilder() {
    this(new WorkAgentConfiguration());
  }
  
  public WorkAgentConfigurationBuilder(WorkAgentConfigurationFluent<?> fluent) {
    this(fluent, new WorkAgentConfiguration());
  }
  
  public WorkAgentConfigurationBuilder(WorkAgentConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WorkAgentConfigurationBuilder(WorkAgentConfigurationFluent<?> fluent,WorkAgentConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WorkAgentConfiguration build() {
    WorkAgentConfiguration buildable = new WorkAgentConfiguration(fluent.getAppliedManifestWorkEvictionGracePeriod(), fluent.buildFeatureGates(), fluent.getHubKubeAPIBurst(), fluent.getHubKubeAPIQPS(), fluent.getKubeAPIBurst(), fluent.getKubeAPIQPS(), fluent.getStatusSyncInterval());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}