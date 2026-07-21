package io.fabric8.openclustermanagement.api.model.search.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SearchBuilder extends SearchFluent<SearchBuilder> implements VisitableBuilder<Search,SearchBuilder>{

  SearchFluent<?> fluent;

  public SearchBuilder() {
    this(new Search());
  }
  
  public SearchBuilder(SearchFluent<?> fluent) {
    this(fluent, new Search());
  }
  
  public SearchBuilder(Search instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SearchBuilder(SearchFluent<?> fluent,Search instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Search build() {
    Search buildable = new Search(fluent.getApiVersion(), fluent.getKind(), fluent.buildMetadata(), fluent.buildSpec(), fluent.buildStatus());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}