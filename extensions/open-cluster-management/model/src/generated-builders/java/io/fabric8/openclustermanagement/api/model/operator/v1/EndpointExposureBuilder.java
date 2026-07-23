package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class EndpointExposureBuilder extends EndpointExposureFluent<EndpointExposureBuilder> implements VisitableBuilder<EndpointExposure,EndpointExposureBuilder>{

  EndpointExposureFluent<?> fluent;

  public EndpointExposureBuilder() {
    this(new EndpointExposure());
  }
  
  public EndpointExposureBuilder(EndpointExposureFluent<?> fluent) {
    this(fluent, new EndpointExposure());
  }
  
  public EndpointExposureBuilder(EndpointExposure instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public EndpointExposureBuilder(EndpointExposureFluent<?> fluent,EndpointExposure instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public EndpointExposure build() {
    EndpointExposure buildable = new EndpointExposure(fluent.buildGrpc(), fluent.buildHttps(), fluent.getProtocol(), fluent.getUsage());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}