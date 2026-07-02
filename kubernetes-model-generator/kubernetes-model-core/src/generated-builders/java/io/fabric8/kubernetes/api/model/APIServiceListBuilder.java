package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServiceListBuilder extends APIServiceListFluent<APIServiceListBuilder> implements VisitableBuilder<APIServiceList,APIServiceListBuilder>{

  APIServiceListFluent<?> fluent;

  public APIServiceListBuilder() {
    this(new APIServiceList());
  }
  
  public APIServiceListBuilder(APIServiceListFluent<?> fluent) {
    this(fluent, new APIServiceList());
  }
  
  public APIServiceListBuilder(APIServiceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServiceListBuilder(APIServiceListFluent<?> fluent,APIServiceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIServiceList build() {
    APIServiceList buildable = new APIServiceList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.buildMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}