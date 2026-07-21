package io.fabric8.openclustermanagement.api.model.search.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SearchSpecBuilder extends SearchSpecFluent<SearchSpecBuilder> implements VisitableBuilder<SearchSpec,SearchSpecBuilder>{

  SearchSpecFluent<?> fluent;

  public SearchSpecBuilder() {
    this(new SearchSpec());
  }
  
  public SearchSpecBuilder(SearchSpecFluent<?> fluent) {
    this(fluent, new SearchSpec());
  }
  
  public SearchSpecBuilder(SearchSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SearchSpecBuilder(SearchSpecFluent<?> fluent,SearchSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SearchSpec build() {
    SearchSpec buildable = new SearchSpec(fluent.getAvailabilityConfig(), fluent.getDbConfig(), fluent.buildDbStorage(), fluent.buildDeployments(), fluent.getExternalDBInstance(), fluent.getImagePullPolicy(), fluent.getImagePullSecret(), fluent.getNodeSelector(), fluent.getTolerations());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}