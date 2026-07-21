package io.fabric8.openclustermanagement.api.model.search.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SearchStatusBuilder extends SearchStatusFluent<SearchStatusBuilder> implements VisitableBuilder<SearchStatus,SearchStatusBuilder>{

  SearchStatusFluent<?> fluent;

  public SearchStatusBuilder() {
    this(new SearchStatus());
  }
  
  public SearchStatusBuilder(SearchStatusFluent<?> fluent) {
    this(fluent, new SearchStatus());
  }
  
  public SearchStatusBuilder(SearchStatus instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SearchStatusBuilder(SearchStatusFluent<?> fluent,SearchStatus instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SearchStatus build() {
    SearchStatus buildable = new SearchStatus(fluent.getConditions(), fluent.getDb(), fluent.getStorage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}