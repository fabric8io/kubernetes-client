package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeveloperConsoleCatalogCategoryMetaBuilder extends DeveloperConsoleCatalogCategoryMetaFluent<DeveloperConsoleCatalogCategoryMetaBuilder> implements VisitableBuilder<DeveloperConsoleCatalogCategoryMeta,DeveloperConsoleCatalogCategoryMetaBuilder>{

  DeveloperConsoleCatalogCategoryMetaFluent<?> fluent;

  public DeveloperConsoleCatalogCategoryMetaBuilder() {
    this(new DeveloperConsoleCatalogCategoryMeta());
  }
  
  public DeveloperConsoleCatalogCategoryMetaBuilder(DeveloperConsoleCatalogCategoryMetaFluent<?> fluent) {
    this(fluent, new DeveloperConsoleCatalogCategoryMeta());
  }
  
  public DeveloperConsoleCatalogCategoryMetaBuilder(DeveloperConsoleCatalogCategoryMeta instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeveloperConsoleCatalogCategoryMetaBuilder(DeveloperConsoleCatalogCategoryMetaFluent<?> fluent,DeveloperConsoleCatalogCategoryMeta instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeveloperConsoleCatalogCategoryMeta build() {
    DeveloperConsoleCatalogCategoryMeta buildable = new DeveloperConsoleCatalogCategoryMeta(fluent.getId(), fluent.getLabel(), fluent.getTags());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}