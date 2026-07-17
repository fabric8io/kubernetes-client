package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class LinkBuilder extends LinkFluent<LinkBuilder> implements VisitableBuilder<Link,LinkBuilder>{

  LinkFluent<?> fluent;

  public LinkBuilder() {
    this(new Link());
  }
  
  public LinkBuilder(LinkFluent<?> fluent) {
    this(fluent, new Link());
  }
  
  public LinkBuilder(Link instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public LinkBuilder(LinkFluent<?> fluent,Link instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public Link build() {
    Link buildable = new Link(fluent.getHref(), fluent.getText());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}