package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthListBuilder extends OAuthListFluent<OAuthListBuilder> implements VisitableBuilder<OAuthList,OAuthListBuilder>{

  OAuthListFluent<?> fluent;

  public OAuthListBuilder() {
    this(new OAuthList());
  }
  
  public OAuthListBuilder(OAuthListFluent<?> fluent) {
    this(fluent, new OAuthList());
  }
  
  public OAuthListBuilder(OAuthList instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthListBuilder(OAuthListFluent<?> fluent,OAuthList instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthList build() {
    OAuthList buildable = new OAuthList(fluent.getApiVersion(), fluent.buildItems(), fluent.getKind(), fluent.getMetadata());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}