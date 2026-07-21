package io.fabric8.openclustermanagement.api.model.observability.v1beta2;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class QueryFrontendSpecBuilder extends QueryFrontendSpecFluent<QueryFrontendSpecBuilder> implements VisitableBuilder<QueryFrontendSpec,QueryFrontendSpecBuilder>{

  QueryFrontendSpecFluent<?> fluent;

  public QueryFrontendSpecBuilder() {
    this(new QueryFrontendSpec());
  }
  
  public QueryFrontendSpecBuilder(QueryFrontendSpecFluent<?> fluent) {
    this(fluent, new QueryFrontendSpec());
  }
  
  public QueryFrontendSpecBuilder(QueryFrontendSpec instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public QueryFrontendSpecBuilder(QueryFrontendSpecFluent<?> fluent,QueryFrontendSpec instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public QueryFrontendSpec build() {
    QueryFrontendSpec buildable = new QueryFrontendSpec(fluent.buildContainers(), fluent.getReplicas(), fluent.buildResources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}