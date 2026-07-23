package io.fabric8.openshift.api.model.miscellaneous.cloudcredential.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CredentialsRequestListBuilder extends CredentialsRequestListFluent<CredentialsRequestListBuilder> implements VisitableBuilder<CredentialsRequestList,CredentialsRequestListBuilder>{

  CredentialsRequestListFluent<?> fluent;

  public CredentialsRequestListBuilder() {
    this(new CredentialsRequestList());
  }
  
  public CredentialsRequestListBuilder(CredentialsRequestListFluent<?> fluent) {
    this(fluent, new CredentialsRequestList());
  }
  
  public CredentialsRequestListBuilder(CredentialsRequestList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CredentialsRequestListBuilder(CredentialsRequestListFluent<?> fluent,CredentialsRequestList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CredentialsRequestList build() {
    CredentialsRequestList buildable = new CredentialsRequestList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}