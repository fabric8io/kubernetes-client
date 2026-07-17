package io.fabric8.openshift.api.model.config.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class OAuthTemplatesBuilder extends OAuthTemplatesFluent<OAuthTemplatesBuilder> implements VisitableBuilder<OAuthTemplates,OAuthTemplatesBuilder>{

  OAuthTemplatesFluent<?> fluent;

  public OAuthTemplatesBuilder() {
    this(new OAuthTemplates());
  }
  
  public OAuthTemplatesBuilder(OAuthTemplatesFluent<?> fluent) {
    this(fluent, new OAuthTemplates());
  }
  
  public OAuthTemplatesBuilder(OAuthTemplates instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public OAuthTemplatesBuilder(OAuthTemplatesFluent<?> fluent,OAuthTemplates instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public OAuthTemplates build() {
    OAuthTemplates buildable = new OAuthTemplates(fluent.buildError(), fluent.buildLogin(), fluent.buildProviderSelection());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}