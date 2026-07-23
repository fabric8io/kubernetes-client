package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIRequestCountListBuilder extends APIRequestCountListFluent<APIRequestCountListBuilder> implements VisitableBuilder<APIRequestCountList,APIRequestCountListBuilder>{

  APIRequestCountListFluent<?> fluent;

  public APIRequestCountListBuilder() {
    this(new APIRequestCountList());
  }
  
  public APIRequestCountListBuilder(APIRequestCountListFluent<?> fluent) {
    this(fluent, new APIRequestCountList());
  }
  
  public APIRequestCountListBuilder(APIRequestCountList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIRequestCountListBuilder(APIRequestCountListFluent<?> fluent,APIRequestCountList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIRequestCountList build() {
    APIRequestCountList buildable = new APIRequestCountList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}