package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeveloperConsoleCatalogCustomizationBuilder extends DeveloperConsoleCatalogCustomizationFluent<DeveloperConsoleCatalogCustomizationBuilder> implements VisitableBuilder<DeveloperConsoleCatalogCustomization,DeveloperConsoleCatalogCustomizationBuilder>{

  DeveloperConsoleCatalogCustomizationFluent<?> fluent;

  public DeveloperConsoleCatalogCustomizationBuilder() {
    this(new DeveloperConsoleCatalogCustomization());
  }
  
  public DeveloperConsoleCatalogCustomizationBuilder(DeveloperConsoleCatalogCustomizationFluent<?> fluent) {
    this(fluent, new DeveloperConsoleCatalogCustomization());
  }
  
  public DeveloperConsoleCatalogCustomizationBuilder(DeveloperConsoleCatalogCustomization instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeveloperConsoleCatalogCustomizationBuilder(DeveloperConsoleCatalogCustomizationFluent<?> fluent,DeveloperConsoleCatalogCustomization instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeveloperConsoleCatalogCustomization build() {
    DeveloperConsoleCatalogCustomization buildable = new DeveloperConsoleCatalogCustomization(fluent.buildCategories(), fluent.buildTypes());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}