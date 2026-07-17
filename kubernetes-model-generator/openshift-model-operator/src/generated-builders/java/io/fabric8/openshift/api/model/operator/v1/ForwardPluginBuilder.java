package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ForwardPluginBuilder extends ForwardPluginFluent<ForwardPluginBuilder> implements VisitableBuilder<ForwardPlugin,ForwardPluginBuilder>{

  ForwardPluginFluent<?> fluent;

  public ForwardPluginBuilder() {
    this(new ForwardPlugin());
  }
  
  public ForwardPluginBuilder(ForwardPluginFluent<?> fluent) {
    this(fluent, new ForwardPlugin());
  }
  
  public ForwardPluginBuilder(ForwardPlugin instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ForwardPluginBuilder(ForwardPluginFluent<?> fluent,ForwardPlugin instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ForwardPlugin build() {
    ForwardPlugin buildable = new ForwardPlugin(fluent.getPolicy(), fluent.getProtocolStrategy(), fluent.buildTransportConfig(), fluent.getUpstreams());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}