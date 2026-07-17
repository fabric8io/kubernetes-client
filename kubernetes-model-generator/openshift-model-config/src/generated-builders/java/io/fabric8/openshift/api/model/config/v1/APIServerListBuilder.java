package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIServerListBuilder extends APIServerListFluent<APIServerListBuilder> implements VisitableBuilder<APIServerList,APIServerListBuilder>{

  APIServerListFluent<?> fluent;

  public APIServerListBuilder() {
    this(new APIServerList());
  }
  
  public APIServerListBuilder(APIServerListFluent<?> fluent) {
    this(fluent, new APIServerList());
  }
  
  public APIServerListBuilder(APIServerList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIServerListBuilder(APIServerListFluent<?> fluent,APIServerList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIServerList build() {
    APIServerList buildable = new APIServerList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}