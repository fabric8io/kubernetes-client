package io.fabric8.openshift.api.model;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthClientListBuilder extends OAuthClientListFluent<OAuthClientListBuilder> implements VisitableBuilder<OAuthClientList,OAuthClientListBuilder>{

  OAuthClientListFluent<?> fluent;

  public OAuthClientListBuilder() {
    this(new OAuthClientList());
  }
  
  public OAuthClientListBuilder(OAuthClientListFluent<?> fluent) {
    this(fluent, new OAuthClientList());
  }
  
  public OAuthClientListBuilder(OAuthClientList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthClientListBuilder(OAuthClientListFluent<?> fluent,OAuthClientList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthClientList build() {
    OAuthClientList buildable = new OAuthClientList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}