package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class StatusCheckTemplateBuilder extends StatusCheckTemplateFluent<StatusCheckTemplateBuilder> implements VisitableBuilder<StatusCheckTemplate,StatusCheckTemplateBuilder>{

  StatusCheckTemplateFluent<?> fluent;

  public StatusCheckTemplateBuilder() {
    this(new StatusCheckTemplate());
  }
  
  public StatusCheckTemplateBuilder(StatusCheckTemplateFluent<?> fluent) {
    this(fluent, new StatusCheckTemplate());
  }
  
  public StatusCheckTemplateBuilder(StatusCheckTemplate instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public StatusCheckTemplateBuilder(StatusCheckTemplateFluent<?> fluent,StatusCheckTemplate instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public StatusCheckTemplate build() {
    StatusCheckTemplate buildable = new StatusCheckTemplate(fluent.getDuration(), fluent.getFailureThreshold(), fluent.buildHttp(), fluent.getIntervalSeconds(), fluent.getMode(), fluent.getRecordsHistoryLimit(), fluent.getSuccessThreshold(), fluent.getTimeoutSeconds(), fluent.getType());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}