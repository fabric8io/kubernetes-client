package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CatalogSourceSpecBuilder extends CatalogSourceSpecFluent<CatalogSourceSpecBuilder> implements VisitableBuilder<CatalogSourceSpec,CatalogSourceSpecBuilder>{

  CatalogSourceSpecFluent<?> fluent;

  public CatalogSourceSpecBuilder() {
    this(new CatalogSourceSpec());
  }
  
  public CatalogSourceSpecBuilder(CatalogSourceSpecFluent<?> fluent) {
    this(fluent, new CatalogSourceSpec());
  }
  
  public CatalogSourceSpecBuilder(CatalogSourceSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CatalogSourceSpecBuilder(CatalogSourceSpecFluent<?> fluent,CatalogSourceSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CatalogSourceSpec build() {
    CatalogSourceSpec buildable = new CatalogSourceSpec(fluent.getAddress(), fluent.getConfigMap(), fluent.getDescription(), fluent.getDisplayName(), fluent.buildGrpcPodConfig(), fluent.buildIcon(), fluent.getImage(), fluent.getPriority(), fluent.getPublisher(), fluent.getSecrets(), fluent.getSourceType(), fluent.buildUpdateStrategy());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}