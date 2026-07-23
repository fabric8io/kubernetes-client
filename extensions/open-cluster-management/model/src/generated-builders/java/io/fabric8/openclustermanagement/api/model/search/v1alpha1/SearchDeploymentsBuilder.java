package io.fabric8.openclustermanagement.api.model.search.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SearchDeploymentsBuilder extends SearchDeploymentsFluent<SearchDeploymentsBuilder> implements VisitableBuilder<SearchDeployments,SearchDeploymentsBuilder>{

  SearchDeploymentsFluent<?> fluent;

  public SearchDeploymentsBuilder() {
    this(new SearchDeployments());
  }
  
  public SearchDeploymentsBuilder(SearchDeploymentsFluent<?> fluent) {
    this(fluent, new SearchDeployments());
  }
  
  public SearchDeploymentsBuilder(SearchDeployments instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SearchDeploymentsBuilder(SearchDeploymentsFluent<?> fluent,SearchDeployments instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SearchDeployments build() {
    SearchDeployments buildable = new SearchDeployments(fluent.buildCollector(), fluent.buildDatabase(), fluent.buildIndexer(), fluent.buildQueryapi());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}