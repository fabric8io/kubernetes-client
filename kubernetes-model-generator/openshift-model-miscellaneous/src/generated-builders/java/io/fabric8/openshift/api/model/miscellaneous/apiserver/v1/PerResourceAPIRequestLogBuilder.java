package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PerResourceAPIRequestLogBuilder extends PerResourceAPIRequestLogFluent<PerResourceAPIRequestLogBuilder> implements VisitableBuilder<PerResourceAPIRequestLog,PerResourceAPIRequestLogBuilder>{

  PerResourceAPIRequestLogFluent<?> fluent;

  public PerResourceAPIRequestLogBuilder() {
    this(new PerResourceAPIRequestLog());
  }
  
  public PerResourceAPIRequestLogBuilder(PerResourceAPIRequestLogFluent<?> fluent) {
    this(fluent, new PerResourceAPIRequestLog());
  }
  
  public PerResourceAPIRequestLogBuilder(PerResourceAPIRequestLog instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PerResourceAPIRequestLogBuilder(PerResourceAPIRequestLogFluent<?> fluent,PerResourceAPIRequestLog instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PerResourceAPIRequestLog build() {
    PerResourceAPIRequestLog buildable = new PerResourceAPIRequestLog(fluent.buildByNode(), fluent.getRequestCount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}