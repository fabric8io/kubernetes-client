package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class CSRConfigBuilder extends CSRConfigFluent<CSRConfigBuilder> implements VisitableBuilder<CSRConfig,CSRConfigBuilder>{

  CSRConfigFluent<?> fluent;

  public CSRConfigBuilder() {
    this(new CSRConfig());
  }
  
  public CSRConfigBuilder(CSRConfigFluent<?> fluent) {
    this(fluent, new CSRConfig());
  }
  
  public CSRConfigBuilder(CSRConfig instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public CSRConfigBuilder(CSRConfigFluent<?> fluent,CSRConfig instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public CSRConfig build() {
    CSRConfig buildable = new CSRConfig(fluent.getAutoApprovedIdentities());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}