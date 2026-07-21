package io.fabric8.volcano.api.model.flow.v1alpha1;

import io.fabric8.kubernetes.api.builder.VisitableBuilder;
import java.lang.Object;
public class TcpSocketBuilder extends TcpSocketFluent<TcpSocketBuilder> implements VisitableBuilder<TcpSocket,TcpSocketBuilder>{

  TcpSocketFluent<?> fluent;

  public TcpSocketBuilder() {
    this(new TcpSocket());
  }
  
  public TcpSocketBuilder(TcpSocketFluent<?> fluent) {
    this(fluent, new TcpSocket());
  }
  
  public TcpSocketBuilder(TcpSocket instance) {
    this.fluent = this;
    this.copyInstance(instance);
  }
  
  public TcpSocketBuilder(TcpSocketFluent<?> fluent,TcpSocket instance) {
    this.fluent = fluent;
    fluent.copyInstance(instance);
  }

  public TcpSocket build() {
    TcpSocket buildable = new TcpSocket(fluent.getPort(), fluent.getTaskName());
    buildable.setAdditionalProperties(fluent.getAdditionalProperties());
    return buildable;
  }
  
}