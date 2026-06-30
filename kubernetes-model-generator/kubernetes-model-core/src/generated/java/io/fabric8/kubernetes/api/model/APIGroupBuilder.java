package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIGroupBuilder extends APIGroupFluent<APIGroupBuilder> implements VisitableBuilder<APIGroup,APIGroupBuilder>{

  APIGroupFluent<?> fluent;

  public APIGroupBuilder() {
    this(new APIGroup());
  }
  
  public APIGroupBuilder(APIGroupFluent<?> fluent) {
    this(fluent, new APIGroup());
  }
  
  public APIGroupBuilder(APIGroup instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIGroupBuilder(APIGroupFluent<?> fluent,APIGroup instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIGroup build() {
    APIGroup buildable = new APIGroup(fluent.getApiVersion(), fluent.getKind(), fluent.getName(), fluent.buildPreferredVersion(), fluent.buildServerAddressByClientCIDRs(), fluent.buildVersions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}