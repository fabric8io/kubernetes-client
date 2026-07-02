package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIResourceListBuilder extends APIResourceListFluent<APIResourceListBuilder> implements VisitableBuilder<APIResourceList,APIResourceListBuilder>{

  APIResourceListFluent<?> fluent;

  public APIResourceListBuilder() {
    this(new APIResourceList());
  }
  
  public APIResourceListBuilder(APIResourceListFluent<?> fluent) {
    this(fluent, new APIResourceList());
  }
  
  public APIResourceListBuilder(APIResourceList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIResourceListBuilder(APIResourceListFluent<?> fluent,APIResourceList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIResourceList build() {
    APIResourceList buildable = new APIResourceList(fluent.getApiVersion(), fluent.getGroupVersion(), fluent.getKind(), fluent.buildResources());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}