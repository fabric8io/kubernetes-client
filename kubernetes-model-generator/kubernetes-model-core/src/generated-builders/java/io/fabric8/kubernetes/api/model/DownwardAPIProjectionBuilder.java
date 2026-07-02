package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class DownwardAPIProjectionBuilder extends DownwardAPIProjectionFluent<DownwardAPIProjectionBuilder> implements VisitableBuilder<DownwardAPIProjection,DownwardAPIProjectionBuilder>{

  DownwardAPIProjectionFluent<?> fluent;

  public DownwardAPIProjectionBuilder() {
    this(new DownwardAPIProjection());
  }
  
  public DownwardAPIProjectionBuilder(DownwardAPIProjectionFluent<?> fluent) {
    this(fluent, new DownwardAPIProjection());
  }
  
  public DownwardAPIProjectionBuilder(DownwardAPIProjection instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public DownwardAPIProjectionBuilder(DownwardAPIProjectionFluent<?> fluent,DownwardAPIProjection instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public DownwardAPIProjection build() {
    DownwardAPIProjection buildable = new DownwardAPIProjection(fluent.buildItems());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}