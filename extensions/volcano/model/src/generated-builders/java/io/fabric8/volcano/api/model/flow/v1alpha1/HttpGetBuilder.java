package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class HttpGetBuilder extends HttpGetFluent<HttpGetBuilder> implements VisitableBuilder<HttpGet,HttpGetBuilder>{

  HttpGetFluent<?> fluent;

  public HttpGetBuilder() {
    this(new HttpGet());
  }
  
  public HttpGetBuilder(HttpGetFluent<?> fluent) {
    this(fluent, new HttpGet());
  }
  
  public HttpGetBuilder(HttpGet instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public HttpGetBuilder(HttpGetFluent<?> fluent,HttpGet instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public HttpGet build() {
    HttpGet buildable = new HttpGet(fluent.getHttpHeader(), fluent.getPath(), fluent.getPort(), fluent.getTaskName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}