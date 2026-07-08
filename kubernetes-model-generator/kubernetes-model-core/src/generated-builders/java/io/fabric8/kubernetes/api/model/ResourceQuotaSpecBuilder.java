package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ResourceQuotaSpecBuilder extends ResourceQuotaSpecFluent<ResourceQuotaSpecBuilder> implements VisitableBuilder<ResourceQuotaSpec,ResourceQuotaSpecBuilder>{

  ResourceQuotaSpecFluent<?> fluent;

  public ResourceQuotaSpecBuilder() {
    this(new ResourceQuotaSpec());
  }
  
  public ResourceQuotaSpecBuilder(ResourceQuotaSpecFluent<?> fluent) {
    this(fluent, new ResourceQuotaSpec());
  }
  
  public ResourceQuotaSpecBuilder(ResourceQuotaSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ResourceQuotaSpecBuilder(ResourceQuotaSpecFluent<?> fluent,ResourceQuotaSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ResourceQuotaSpec build() {
    ResourceQuotaSpec buildable = new ResourceQuotaSpec(fluent.getHard(), fluent.buildScopeSelector(), fluent.getScopes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}