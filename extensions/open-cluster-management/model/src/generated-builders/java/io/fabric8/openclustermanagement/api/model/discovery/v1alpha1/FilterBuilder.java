package io.fabric8.openclustermanagement.api.model.discovery.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class FilterBuilder extends FilterFluent<FilterBuilder> implements VisitableBuilder<Filter,FilterBuilder>{

  FilterFluent<?> fluent;

  public FilterBuilder() {
    this(new Filter());
  }
  
  public FilterBuilder(FilterFluent<?> fluent) {
    this(fluent, new Filter());
  }
  
  public FilterBuilder(Filter instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public FilterBuilder(FilterFluent<?> fluent,Filter instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Filter build() {
    Filter buildable = new Filter(fluent.getLastActive(), fluent.getOpenShiftVersions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}