package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeveloperConsoleCatalogCategoryBuilder extends DeveloperConsoleCatalogCategoryFluent<DeveloperConsoleCatalogCategoryBuilder> implements VisitableBuilder<DeveloperConsoleCatalogCategory,DeveloperConsoleCatalogCategoryBuilder>{

  DeveloperConsoleCatalogCategoryFluent<?> fluent;

  public DeveloperConsoleCatalogCategoryBuilder() {
    this(new DeveloperConsoleCatalogCategory());
  }
  
  public DeveloperConsoleCatalogCategoryBuilder(DeveloperConsoleCatalogCategoryFluent<?> fluent) {
    this(fluent, new DeveloperConsoleCatalogCategory());
  }
  
  public DeveloperConsoleCatalogCategoryBuilder(DeveloperConsoleCatalogCategory instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeveloperConsoleCatalogCategoryBuilder(DeveloperConsoleCatalogCategoryFluent<?> fluent,DeveloperConsoleCatalogCategory instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeveloperConsoleCatalogCategory build() {
    DeveloperConsoleCatalogCategory buildable = new DeveloperConsoleCatalogCategory(fluent.getId(), fluent.getLabel(), fluent.buildSubcategories(), fluent.getTags());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}