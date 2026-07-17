package io.fabric8.openshift.api.model.monitoring.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class WebConfigFileFieldsBuilder extends WebConfigFileFieldsFluent<WebConfigFileFieldsBuilder> implements VisitableBuilder<WebConfigFileFields,WebConfigFileFieldsBuilder>{

  WebConfigFileFieldsFluent<?> fluent;

  public WebConfigFileFieldsBuilder() {
    this(new WebConfigFileFields());
  }
  
  public WebConfigFileFieldsBuilder(WebConfigFileFieldsFluent<?> fluent) {
    this(fluent, new WebConfigFileFields());
  }
  
  public WebConfigFileFieldsBuilder(WebConfigFileFields instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public WebConfigFileFieldsBuilder(WebConfigFileFieldsFluent<?> fluent,WebConfigFileFields instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public WebConfigFileFields build() {
    WebConfigFileFields buildable = new WebConfigFileFields(fluent.buildHttpConfig(), fluent.buildTlsConfig());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}