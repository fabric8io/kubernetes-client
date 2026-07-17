package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CatalogSourceStatusBuilder extends CatalogSourceStatusFluent<CatalogSourceStatusBuilder> implements VisitableBuilder<CatalogSourceStatus,CatalogSourceStatusBuilder>{

  CatalogSourceStatusFluent<?> fluent;

  public CatalogSourceStatusBuilder() {
    this(new CatalogSourceStatus());
  }
  
  public CatalogSourceStatusBuilder(CatalogSourceStatusFluent<?> fluent) {
    this(fluent, new CatalogSourceStatus());
  }
  
  public CatalogSourceStatusBuilder(CatalogSourceStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CatalogSourceStatusBuilder(CatalogSourceStatusFluent<?> fluent,CatalogSourceStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CatalogSourceStatus build() {
    CatalogSourceStatus buildable = new CatalogSourceStatus(fluent.getConditions(), fluent.buildConfigMapReference(), fluent.buildConnectionState(), fluent.getLatestImageRegistryPoll(), fluent.getMessage(), fluent.getReason(), fluent.buildRegistryService());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}