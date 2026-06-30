package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIGroupListBuilder extends APIGroupListFluent<APIGroupListBuilder> implements VisitableBuilder<APIGroupList,APIGroupListBuilder>{

  APIGroupListFluent<?> fluent;

  public APIGroupListBuilder() {
    this(new APIGroupList());
  }
  
  public APIGroupListBuilder(APIGroupListFluent<?> fluent) {
    this(fluent, new APIGroupList());
  }
  
  public APIGroupListBuilder(APIGroupList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIGroupListBuilder(APIGroupListFluent<?> fluent,APIGroupList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIGroupList build() {
    APIGroupList buildable = new APIGroupList(fluent.getApiVersion(), fluent.buildGroups(), fluent.getKind());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}