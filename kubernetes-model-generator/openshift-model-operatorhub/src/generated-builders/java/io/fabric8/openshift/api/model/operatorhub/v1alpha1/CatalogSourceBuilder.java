package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CatalogSourceBuilder extends CatalogSourceFluent<CatalogSourceBuilder> implements VisitableBuilder<CatalogSource,CatalogSourceBuilder>{

  CatalogSourceFluent<?> fluent;

  public CatalogSourceBuilder() {
    this(new CatalogSource());
  }
  
  public CatalogSourceBuilder(CatalogSourceFluent<?> fluent) {
    this(fluent, new CatalogSource());
  }
  
  public CatalogSourceBuilder(CatalogSource instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CatalogSourceBuilder(CatalogSourceFluent<?> fluent,CatalogSource instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CatalogSource build() {
    CatalogSource buildable = new CatalogSource(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}