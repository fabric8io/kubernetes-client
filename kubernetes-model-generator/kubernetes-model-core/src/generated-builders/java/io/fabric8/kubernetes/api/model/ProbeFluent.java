package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ProbeFluent<A extends io.fabric8.kubernetes.api.model.ProbeFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ExecActionBuilder exec;
  private Integer failureThreshold;
  private GRPCActionBuilder grpc;
  private HTTPGetActionBuilder httpGet;
  private Integer initialDelaySeconds;
  private Integer periodSeconds;
  private Integer successThreshold;
  private TCPSocketActionBuilder tcpSocket;
  private Long terminationGracePeriodSeconds;
  private Integer timeoutSeconds;

  public ProbeFluent() {
  }
  
  public ProbeFluent(Probe instance) {
    this.copyInstance(instance);
  }

  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public ExecAction buildExec() {
    return this.exec != null ? this.exec.build() : null;
  }
  
  public GRPCAction buildGrpc() {
    return this.grpc != null ? this.grpc.build() : null;
  }
  
  public HTTPGetAction buildHttpGet() {
    return this.httpGet != null ? this.httpGet.build() : null;
  }
  
  public TCPSocketAction buildTcpSocket() {
    return this.tcpSocket != null ? this.tcpSocket.build() : null;
  }
  
  protected void copyInstance(Probe instance) {
    instance = instance != null ? instance : new Probe();
    if (instance != null) {
        this.withExec(instance.getExec());
        this.withFailureThreshold(instance.getFailureThreshold());
        this.withGrpc(instance.getGrpc());
        this.withHttpGet(instance.getHttpGet());
        this.withInitialDelaySeconds(instance.getInitialDelaySeconds());
        this.withPeriodSeconds(instance.getPeriodSeconds());
        this.withSuccessThreshold(instance.getSuccessThreshold());
        this.withTcpSocket(instance.getTcpSocket());
        this.withTerminationGracePeriodSeconds(instance.getTerminationGracePeriodSeconds());
        this.withTimeoutSeconds(instance.getTimeoutSeconds());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExecNested<A> editExec() {
    return this.withNewExecLike(Optional.ofNullable(this.buildExec()).orElse(null));
  }
  
  public GrpcNested<A> editGrpc() {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(null));
  }
  
  public HttpGetNested<A> editHttpGet() {
    return this.withNewHttpGetLike(Optional.ofNullable(this.buildHttpGet()).orElse(null));
  }
  
  public ExecNested<A> editOrNewExec() {
    return this.withNewExecLike(Optional.ofNullable(this.buildExec()).orElse(new ExecActionBuilder().build()));
  }
  
  public ExecNested<A> editOrNewExecLike(ExecAction item) {
    return this.withNewExecLike(Optional.ofNullable(this.buildExec()).orElse(item));
  }
  
  public GrpcNested<A> editOrNewGrpc() {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(new GRPCActionBuilder().build()));
  }
  
  public GrpcNested<A> editOrNewGrpcLike(GRPCAction item) {
    return this.withNewGrpcLike(Optional.ofNullable(this.buildGrpc()).orElse(item));
  }
  
  public HttpGetNested<A> editOrNewHttpGet() {
    return this.withNewHttpGetLike(Optional.ofNullable(this.buildHttpGet()).orElse(new HTTPGetActionBuilder().build()));
  }
  
  public HttpGetNested<A> editOrNewHttpGetLike(HTTPGetAction item) {
    return this.withNewHttpGetLike(Optional.ofNullable(this.buildHttpGet()).orElse(item));
  }
  
  public TcpSocketNested<A> editOrNewTcpSocket() {
    return this.withNewTcpSocketLike(Optional.ofNullable(this.buildTcpSocket()).orElse(new TCPSocketActionBuilder().build()));
  }
  
  public TcpSocketNested<A> editOrNewTcpSocketLike(TCPSocketAction item) {
    return this.withNewTcpSocketLike(Optional.ofNullable(this.buildTcpSocket()).orElse(item));
  }
  
  public TcpSocketNested<A> editTcpSocket() {
    return this.withNewTcpSocketLike(Optional.ofNullable(this.buildTcpSocket()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    ProbeFluent that = (ProbeFluent) o;
    if (!(Objects.equals(exec, that.exec))) {
      return false;
    }
    if (!(Objects.equals(failureThreshold, that.failureThreshold))) {
      return false;
    }
    if (!(Objects.equals(grpc, that.grpc))) {
      return false;
    }
    if (!(Objects.equals(httpGet, that.httpGet))) {
      return false;
    }
    if (!(Objects.equals(initialDelaySeconds, that.initialDelaySeconds))) {
      return false;
    }
    if (!(Objects.equals(periodSeconds, that.periodSeconds))) {
      return false;
    }
    if (!(Objects.equals(successThreshold, that.successThreshold))) {
      return false;
    }
    if (!(Objects.equals(tcpSocket, that.tcpSocket))) {
      return false;
    }
    if (!(Objects.equals(terminationGracePeriodSeconds, that.terminationGracePeriodSeconds))) {
      return false;
    }
    if (!(Objects.equals(timeoutSeconds, that.timeoutSeconds))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Integer getFailureThreshold() {
    return this.failureThreshold;
  }
  
  public Integer getInitialDelaySeconds() {
    return this.initialDelaySeconds;
  }
  
  public Integer getPeriodSeconds() {
    return this.periodSeconds;
  }
  
  public Integer getSuccessThreshold() {
    return this.successThreshold;
  }
  
  public Long getTerminationGracePeriodSeconds() {
    return this.terminationGracePeriodSeconds;
  }
  
  public Integer getTimeoutSeconds() {
    return this.timeoutSeconds;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExec() {
    return this.exec != null;
  }
  
  public boolean hasFailureThreshold() {
    return this.failureThreshold != null;
  }
  
  public boolean hasGrpc() {
    return this.grpc != null;
  }
  
  public boolean hasHttpGet() {
    return this.httpGet != null;
  }
  
  public boolean hasInitialDelaySeconds() {
    return this.initialDelaySeconds != null;
  }
  
  public boolean hasPeriodSeconds() {
    return this.periodSeconds != null;
  }
  
  public boolean hasSuccessThreshold() {
    return this.successThreshold != null;
  }
  
  public boolean hasTcpSocket() {
    return this.tcpSocket != null;
  }
  
  public boolean hasTerminationGracePeriodSeconds() {
    return this.terminationGracePeriodSeconds != null;
  }
  
  public boolean hasTimeoutSeconds() {
    return this.timeoutSeconds != null;
  }
  
  public int hashCode() {
    return Objects.hash(exec, failureThreshold, grpc, httpGet, initialDelaySeconds, periodSeconds, successThreshold, tcpSocket, terminationGracePeriodSeconds, timeoutSeconds, additionalProperties);
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(exec == null)) {
        sb.append("exec:");
        sb.append(exec);
        sb.append(",");
    }
    if (!(failureThreshold == null)) {
        sb.append("failureThreshold:");
        sb.append(failureThreshold);
        sb.append(",");
    }
    if (!(grpc == null)) {
        sb.append("grpc:");
        sb.append(grpc);
        sb.append(",");
    }
    if (!(httpGet == null)) {
        sb.append("httpGet:");
        sb.append(httpGet);
        sb.append(",");
    }
    if (!(initialDelaySeconds == null)) {
        sb.append("initialDelaySeconds:");
        sb.append(initialDelaySeconds);
        sb.append(",");
    }
    if (!(periodSeconds == null)) {
        sb.append("periodSeconds:");
        sb.append(periodSeconds);
        sb.append(",");
    }
    if (!(successThreshold == null)) {
        sb.append("successThreshold:");
        sb.append(successThreshold);
        sb.append(",");
    }
    if (!(tcpSocket == null)) {
        sb.append("tcpSocket:");
        sb.append(tcpSocket);
        sb.append(",");
    }
    if (!(terminationGracePeriodSeconds == null)) {
        sb.append("terminationGracePeriodSeconds:");
        sb.append(terminationGracePeriodSeconds);
        sb.append(",");
    }
    if (!(timeoutSeconds == null)) {
        sb.append("timeoutSeconds:");
        sb.append(timeoutSeconds);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withExec(ExecAction exec) {
    this._visitables.remove("exec");
    if (exec != null) {
        this.exec = new ExecActionBuilder(exec);
        this._visitables.get("exec").add(this.exec);
    } else {
        this.exec = null;
        this._visitables.get("exec").remove(this.exec);
    }
    return (A) this;
  }
  
  public A withFailureThreshold(Integer failureThreshold) {
    this.failureThreshold = failureThreshold;
    return (A) this;
  }
  
  public A withGrpc(GRPCAction grpc) {
    this._visitables.remove("grpc");
    if (grpc != null) {
        this.grpc = new GRPCActionBuilder(grpc);
        this._visitables.get("grpc").add(this.grpc);
    } else {
        this.grpc = null;
        this._visitables.get("grpc").remove(this.grpc);
    }
    return (A) this;
  }
  
  public A withHttpGet(HTTPGetAction httpGet) {
    this._visitables.remove("httpGet");
    if (httpGet != null) {
        this.httpGet = new HTTPGetActionBuilder(httpGet);
        this._visitables.get("httpGet").add(this.httpGet);
    } else {
        this.httpGet = null;
        this._visitables.get("httpGet").remove(this.httpGet);
    }
    return (A) this;
  }
  
  public A withInitialDelaySeconds(Integer initialDelaySeconds) {
    this.initialDelaySeconds = initialDelaySeconds;
    return (A) this;
  }
  
  public ExecNested<A> withNewExec() {
    return new ExecNested(null);
  }
  
  public ExecNested<A> withNewExecLike(ExecAction item) {
    return new ExecNested(item);
  }
  
  public GrpcNested<A> withNewGrpc() {
    return new GrpcNested(null);
  }
  
  public A withNewGrpc(Integer port,String service) {
    return (A) this.withGrpc(new GRPCAction(port, service));
  }
  
  public GrpcNested<A> withNewGrpcLike(GRPCAction item) {
    return new GrpcNested(item);
  }
  
  public HttpGetNested<A> withNewHttpGet() {
    return new HttpGetNested(null);
  }
  
  public HttpGetNested<A> withNewHttpGetLike(HTTPGetAction item) {
    return new HttpGetNested(item);
  }
  
  public TcpSocketNested<A> withNewTcpSocket() {
    return new TcpSocketNested(null);
  }
  
  public TcpSocketNested<A> withNewTcpSocketLike(TCPSocketAction item) {
    return new TcpSocketNested(item);
  }
  
  public A withPeriodSeconds(Integer periodSeconds) {
    this.periodSeconds = periodSeconds;
    return (A) this;
  }
  
  public A withSuccessThreshold(Integer successThreshold) {
    this.successThreshold = successThreshold;
    return (A) this;
  }
  
  public A withTcpSocket(TCPSocketAction tcpSocket) {
    this._visitables.remove("tcpSocket");
    if (tcpSocket != null) {
        this.tcpSocket = new TCPSocketActionBuilder(tcpSocket);
        this._visitables.get("tcpSocket").add(this.tcpSocket);
    } else {
        this.tcpSocket = null;
        this._visitables.get("tcpSocket").remove(this.tcpSocket);
    }
    return (A) this;
  }
  
  public A withTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
    this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
    return (A) this;
  }
  
  public A withTimeoutSeconds(Integer timeoutSeconds) {
    this.timeoutSeconds = timeoutSeconds;
    return (A) this;
  }
  public class ExecNested<N> extends ExecActionFluent<ExecNested<N>> implements Nested<N>{
  
    ExecActionBuilder builder;
  
    ExecNested(ExecAction item) {
      this.builder = new ExecActionBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeFluent.this.withExec(builder.build());
    }
    
    public N endExec() {
      return and();
    }
    
  }
  public class GrpcNested<N> extends GRPCActionFluent<GrpcNested<N>> implements Nested<N>{
  
    GRPCActionBuilder builder;
  
    GrpcNested(GRPCAction item) {
      this.builder = new GRPCActionBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeFluent.this.withGrpc(builder.build());
    }
    
    public N endGrpc() {
      return and();
    }
    
  }
  public class HttpGetNested<N> extends HTTPGetActionFluent<HttpGetNested<N>> implements Nested<N>{
  
    HTTPGetActionBuilder builder;
  
    HttpGetNested(HTTPGetAction item) {
      this.builder = new HTTPGetActionBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeFluent.this.withHttpGet(builder.build());
    }
    
    public N endHttpGet() {
      return and();
    }
    
  }
  public class TcpSocketNested<N> extends TCPSocketActionFluent<TcpSocketNested<N>> implements Nested<N>{
  
    TCPSocketActionBuilder builder;
  
    TcpSocketNested(TCPSocketAction item) {
      this.builder = new TCPSocketActionBuilder(this, item);
    }
  
    public N and() {
      return (N) ProbeFluent.this.withTcpSocket(builder.build());
    }
    
    public N endTcpSocket() {
      return and();
    }
    
  }
}