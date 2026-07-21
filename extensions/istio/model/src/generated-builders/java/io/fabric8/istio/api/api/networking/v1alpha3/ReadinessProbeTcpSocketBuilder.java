package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class ReadinessProbeTcpSocketBuilder extends ReadinessProbeTcpSocketFluent<ReadinessProbeTcpSocketBuilder> implements VisitableBuilder<ReadinessProbeTcpSocket,ReadinessProbeTcpSocketBuilder>{

  ReadinessProbeTcpSocketFluent<?> fluent;

  public ReadinessProbeTcpSocketBuilder() {
    this(new ReadinessProbeTcpSocket());
  }
  
  public ReadinessProbeTcpSocketBuilder(ReadinessProbeTcpSocketFluent<?> fluent) {
    this(fluent, new ReadinessProbeTcpSocket());
  }
  
  public ReadinessProbeTcpSocketBuilder(ReadinessProbeTcpSocket instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public ReadinessProbeTcpSocketBuilder(ReadinessProbeTcpSocketFluent<?> fluent,ReadinessProbeTcpSocket instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public ReadinessProbeTcpSocket build() {
    ReadinessProbeTcpSocket buildable = new ReadinessProbeTcpSocket(fluent.buildTcpSocket());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}