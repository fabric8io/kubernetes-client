package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class QuerySpecBuilder extends QuerySpecFluent<QuerySpecBuilder> implements VisitableBuilder<QuerySpec,QuerySpecBuilder>{

  QuerySpecFluent<?> fluent;

  public QuerySpecBuilder() {
    this(new QuerySpec());
  }
  
  public QuerySpecBuilder(QuerySpecFluent<?> fluent) {
    this(fluent, new QuerySpec());
  }
  
  public QuerySpecBuilder(QuerySpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public QuerySpecBuilder(QuerySpecFluent<?> fluent,QuerySpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public QuerySpec build() {
    QuerySpec buildable = new QuerySpec(fluent.getLookbackDelta(), fluent.getMaxConcurrency(), fluent.getMaxSamples(), fluent.getTimeout());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}