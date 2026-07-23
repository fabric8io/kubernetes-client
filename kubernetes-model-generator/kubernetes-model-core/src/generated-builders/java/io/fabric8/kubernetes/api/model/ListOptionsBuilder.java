package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ListOptionsBuilder extends ListOptionsFluent<ListOptionsBuilder> implements VisitableBuilder<ListOptions,ListOptionsBuilder>{

  ListOptionsFluent<?> fluent;

  public ListOptionsBuilder() {
    this(new ListOptions());
  }
  
  public ListOptionsBuilder(ListOptionsFluent<?> fluent) {
    this(fluent, new ListOptions());
  }
  
  public ListOptionsBuilder(ListOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ListOptionsBuilder(ListOptionsFluent<?> fluent,ListOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ListOptions build() {
    ListOptions buildable = new ListOptions(fluent.getAllowWatchBookmarks(), fluent.getApiVersion(), fluent.getContinue(), fluent.getFieldSelector(), fluent.getKind(), fluent.getLabelSelector(), fluent.getLimit(), fluent.getResourceVersion(), fluent.getResourceVersionMatch(), fluent.getSendInitialEvents(), fluent.getShardSelector(), fluent.getTimeoutSeconds(), fluent.getWatch());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}