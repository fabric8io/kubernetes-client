package io.fabric8.kubernetes.api.model.batch.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class JobSchedulingConfigurationBuilder extends JobSchedulingConfigurationFluent<JobSchedulingConfigurationBuilder> implements VisitableBuilder<JobSchedulingConfiguration,JobSchedulingConfigurationBuilder>{

  JobSchedulingConfigurationFluent<?> fluent;

  public JobSchedulingConfigurationBuilder() {
    this(new JobSchedulingConfiguration());
  }
  
  public JobSchedulingConfigurationBuilder(JobSchedulingConfigurationFluent<?> fluent) {
    this(fluent, new JobSchedulingConfiguration());
  }
  
  public JobSchedulingConfigurationBuilder(JobSchedulingConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public JobSchedulingConfigurationBuilder(JobSchedulingConfigurationFluent<?> fluent,JobSchedulingConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public JobSchedulingConfiguration build() {
    JobSchedulingConfiguration buildable = new JobSchedulingConfiguration(fluent.getDisruptionMode(), fluent.getResourceClaims(), fluent.getSchedulingConstraints(), fluent.getSchedulingPolicy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}