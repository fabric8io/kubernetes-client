package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CatalogSourceListBuilder extends CatalogSourceListFluent<CatalogSourceListBuilder> implements VisitableBuilder<CatalogSourceList,CatalogSourceListBuilder>{

  CatalogSourceListFluent<?> fluent;

  public CatalogSourceListBuilder() {
    this(new CatalogSourceList());
  }
  
  public CatalogSourceListBuilder(CatalogSourceListFluent<?> fluent) {
    this(fluent, new CatalogSourceList());
  }
  
  public CatalogSourceListBuilder(CatalogSourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CatalogSourceListBuilder(CatalogSourceListFluent<?> fluent,CatalogSourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CatalogSourceList build() {
    CatalogSourceList buildable = new CatalogSourceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}