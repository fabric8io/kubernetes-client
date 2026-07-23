package io.fabric8.openclustermanagement.api.model.search.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SearchListBuilder extends SearchListFluent<SearchListBuilder> implements VisitableBuilder<SearchList,SearchListBuilder>{

  SearchListFluent<?> fluent;

  public SearchListBuilder() {
    this(new SearchList());
  }
  
  public SearchListBuilder(SearchListFluent<?> fluent) {
    this(fluent, new SearchList());
  }
  
  public SearchListBuilder(SearchList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SearchListBuilder(SearchListFluent<?> fluent,SearchList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SearchList build() {
    SearchList buildable = new SearchList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}