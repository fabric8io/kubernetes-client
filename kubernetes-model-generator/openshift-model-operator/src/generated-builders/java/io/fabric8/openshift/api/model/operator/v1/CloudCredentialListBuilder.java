package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CloudCredentialListBuilder extends CloudCredentialListFluent<CloudCredentialListBuilder> implements VisitableBuilder<CloudCredentialList,CloudCredentialListBuilder>{

  CloudCredentialListFluent<?> fluent;

  public CloudCredentialListBuilder() {
    this(new CloudCredentialList());
  }
  
  public CloudCredentialListBuilder(CloudCredentialListFluent<?> fluent) {
    this(fluent, new CloudCredentialList());
  }
  
  public CloudCredentialListBuilder(CloudCredentialList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CloudCredentialListBuilder(CloudCredentialListFluent<?> fluent,CloudCredentialList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CloudCredentialList build() {
    CloudCredentialList buildable = new CloudCredentialList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}