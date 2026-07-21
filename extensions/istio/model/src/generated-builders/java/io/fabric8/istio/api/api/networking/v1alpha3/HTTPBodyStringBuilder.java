package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HTTPBodyStringBuilder extends HTTPBodyStringFluent<HTTPBodyStringBuilder> implements VisitableBuilder<HTTPBodyString,HTTPBodyStringBuilder>{

  HTTPBodyStringFluent<?> fluent;

  public HTTPBodyStringBuilder() {
    this(new HTTPBodyString());
  }
  
  public HTTPBodyStringBuilder(HTTPBodyStringFluent<?> fluent) {
    this(fluent, new HTTPBodyString());
  }
  
  public HTTPBodyStringBuilder(HTTPBodyString instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HTTPBodyStringBuilder(HTTPBodyStringFluent<?> fluent,HTTPBodyString instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HTTPBodyString build() {
    HTTPBodyString buildable = new HTTPBodyString(fluent.getString());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}