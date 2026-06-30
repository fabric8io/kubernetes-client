package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class APIVersionsBuilder extends APIVersionsFluent<APIVersionsBuilder> implements VisitableBuilder<APIVersions,APIVersionsBuilder>{

  APIVersionsFluent<?> fluent;

  public APIVersionsBuilder() {
    this(new APIVersions());
  }
  
  public APIVersionsBuilder(APIVersionsFluent<?> fluent) {
    this(fluent, new APIVersions());
  }
  
  public APIVersionsBuilder(APIVersions instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public APIVersionsBuilder(APIVersionsFluent<?> fluent,APIVersions instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public APIVersions build() {
    APIVersions buildable = new APIVersions(fluent.getApiVersion(), fluent.getKind(), fluent.buildServerAddressByClientCIDRs(), fluent.getVersions());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}