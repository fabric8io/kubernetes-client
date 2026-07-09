package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class SortOptionsBuilder extends SortOptionsFluent<SortOptionsBuilder> implements VisitableBuilder<SortOptions,SortOptionsBuilder>{

  SortOptionsFluent<?> fluent;

  public SortOptionsBuilder() {
    this(new SortOptions());
  }
  
  public SortOptionsBuilder(SortOptionsFluent<?> fluent) {
    this(fluent, new SortOptions());
  }
  
  public SortOptionsBuilder(SortOptions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public SortOptionsBuilder(SortOptionsFluent<?> fluent,SortOptions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public SortOptions build() {
    SortOptions buildable = new SortOptions(fluent.buildLegacySortOptions(), fluent.getOrder());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}