package io.fabric8.kubernetes.api.model.admissionregistration.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ApplyConfigurationBuilder extends ApplyConfigurationFluent<ApplyConfigurationBuilder> implements VisitableBuilder<ApplyConfiguration,ApplyConfigurationBuilder>{

  ApplyConfigurationFluent<?> fluent;

  public ApplyConfigurationBuilder() {
    this(new ApplyConfiguration());
  }
  
  public ApplyConfigurationBuilder(ApplyConfigurationFluent<?> fluent) {
    this(fluent, new ApplyConfiguration());
  }
  
  public ApplyConfigurationBuilder(ApplyConfiguration instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ApplyConfigurationBuilder(ApplyConfigurationFluent<?> fluent,ApplyConfiguration instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ApplyConfiguration build() {
    ApplyConfiguration buildable = new ApplyConfiguration(fluent.getExpression());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}