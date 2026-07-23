package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class PerNodeAPIRequestLogBuilder extends PerNodeAPIRequestLogFluent<PerNodeAPIRequestLogBuilder> implements VisitableBuilder<PerNodeAPIRequestLog,PerNodeAPIRequestLogBuilder>{

  PerNodeAPIRequestLogFluent<?> fluent;

  public PerNodeAPIRequestLogBuilder() {
    this(new PerNodeAPIRequestLog());
  }
  
  public PerNodeAPIRequestLogBuilder(PerNodeAPIRequestLogFluent<?> fluent) {
    this(fluent, new PerNodeAPIRequestLog());
  }
  
  public PerNodeAPIRequestLogBuilder(PerNodeAPIRequestLog instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public PerNodeAPIRequestLogBuilder(PerNodeAPIRequestLogFluent<?> fluent,PerNodeAPIRequestLog instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public PerNodeAPIRequestLog build() {
    PerNodeAPIRequestLog buildable = new PerNodeAPIRequestLog(fluent.buildByUser(), fluent.getNodeName(), fluent.getRequestCount());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}