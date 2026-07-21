package io.fabric8.tekton.triggers.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TriggerInterceptorBuilder extends TriggerInterceptorFluent<TriggerInterceptorBuilder> implements VisitableBuilder<TriggerInterceptor,TriggerInterceptorBuilder>{

  TriggerInterceptorFluent<?> fluent;

  public TriggerInterceptorBuilder() {
    this(new TriggerInterceptor());
  }
  
  public TriggerInterceptorBuilder(TriggerInterceptorFluent<?> fluent) {
    this(fluent, new TriggerInterceptor());
  }
  
  public TriggerInterceptorBuilder(TriggerInterceptor instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TriggerInterceptorBuilder(TriggerInterceptorFluent<?> fluent,TriggerInterceptor instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TriggerInterceptor build() {
    TriggerInterceptor buildable = new TriggerInterceptor(fluent.buildBitbucket(), fluent.buildCel(), fluent.buildGithub(), fluent.buildGitlab(), fluent.getName(), fluent.buildParams(), fluent.buildRef(), fluent.buildWebhook());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}