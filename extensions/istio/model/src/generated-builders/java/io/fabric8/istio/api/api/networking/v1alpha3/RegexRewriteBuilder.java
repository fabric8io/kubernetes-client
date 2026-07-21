package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class RegexRewriteBuilder extends RegexRewriteFluent<RegexRewriteBuilder> implements VisitableBuilder<RegexRewrite,RegexRewriteBuilder>{

  RegexRewriteFluent<?> fluent;

  public RegexRewriteBuilder() {
    this(new RegexRewrite());
  }
  
  public RegexRewriteBuilder(RegexRewriteFluent<?> fluent) {
    this(fluent, new RegexRewrite());
  }
  
  public RegexRewriteBuilder(RegexRewrite instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public RegexRewriteBuilder(RegexRewriteFluent<?> fluent,RegexRewrite instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public RegexRewrite build() {
    RegexRewrite buildable = new RegexRewrite(fluent.getMatch(), fluent.getRewrite());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}