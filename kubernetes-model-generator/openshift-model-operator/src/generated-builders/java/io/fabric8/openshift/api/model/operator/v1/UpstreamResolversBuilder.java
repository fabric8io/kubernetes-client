package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class UpstreamResolversBuilder extends UpstreamResolversFluent<UpstreamResolversBuilder> implements VisitableBuilder<UpstreamResolvers,UpstreamResolversBuilder>{

  UpstreamResolversFluent<?> fluent;

  public UpstreamResolversBuilder() {
    this(new UpstreamResolvers());
  }
  
  public UpstreamResolversBuilder(UpstreamResolversFluent<?> fluent) {
    this(fluent, new UpstreamResolvers());
  }
  
  public UpstreamResolversBuilder(UpstreamResolvers instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public UpstreamResolversBuilder(UpstreamResolversFluent<?> fluent,UpstreamResolvers instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public UpstreamResolvers build() {
    UpstreamResolvers buildable = new UpstreamResolvers(fluent.getPolicy(), fluent.getProtocolStrategy(), fluent.buildTransportConfig(), fluent.buildUpstreams());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}