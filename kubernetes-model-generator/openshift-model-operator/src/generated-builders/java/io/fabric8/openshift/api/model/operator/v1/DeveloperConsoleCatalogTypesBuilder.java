package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DeveloperConsoleCatalogTypesBuilder extends DeveloperConsoleCatalogTypesFluent<DeveloperConsoleCatalogTypesBuilder> implements VisitableBuilder<DeveloperConsoleCatalogTypes,DeveloperConsoleCatalogTypesBuilder>{

  DeveloperConsoleCatalogTypesFluent<?> fluent;

  public DeveloperConsoleCatalogTypesBuilder() {
    this(new DeveloperConsoleCatalogTypes());
  }
  
  public DeveloperConsoleCatalogTypesBuilder(DeveloperConsoleCatalogTypesFluent<?> fluent) {
    this(fluent, new DeveloperConsoleCatalogTypes());
  }
  
  public DeveloperConsoleCatalogTypesBuilder(DeveloperConsoleCatalogTypes instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DeveloperConsoleCatalogTypesBuilder(DeveloperConsoleCatalogTypesFluent<?> fluent,DeveloperConsoleCatalogTypes instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DeveloperConsoleCatalogTypes build() {
    DeveloperConsoleCatalogTypes buildable = new DeveloperConsoleCatalogTypes(fluent.getDisabled(), fluent.getEnabled(), fluent.getState());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}