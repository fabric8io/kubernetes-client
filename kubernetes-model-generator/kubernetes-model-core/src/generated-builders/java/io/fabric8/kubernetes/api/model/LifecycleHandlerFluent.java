package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class LifecycleHandlerFluent<A extends io.fabric8.kubernetes.api.model.LifecycleHandlerFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ExecActionBuilder exec;
  private HTTPGetActionBuilder httpGet;
  private SleepActionBuilder sleep;
  private TCPSocketActionBuilder tcpSocket;

  public LifecycleHandlerFluent() {
  }
  
  public LifecycleHandlerFluent(LifecycleHandler instance) {
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
  
  public HTTPGetAction buildHttpGet() {
    return this.httpGet != null ? this.httpGet.build() : null;
  }
  
  public SleepAction buildSleep() {
    return this.sleep != null ? this.sleep.build() : null;
  }
  
  public TCPSocketAction buildTcpSocket() {
    return this.tcpSocket != null ? this.tcpSocket.build() : null;
  }
  
  protected void copyInstance(LifecycleHandler instance) {
    instance = instance != null ? instance : new LifecycleHandler();
    if (instance != null) {
        this.withExec(instance.getExec());
        this.withHttpGet(instance.getHttpGet());
        this.withSleep(instance.getSleep());
        this.withTcpSocket(instance.getTcpSocket());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ExecNested<A> editExec() {
    return this.withNewExecLike(Optional.ofNullable(this.buildExec()).orElse(null));
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
  
  public HttpGetNested<A> editOrNewHttpGet() {
    return this.withNewHttpGetLike(Optional.ofNullable(this.buildHttpGet()).orElse(new HTTPGetActionBuilder().build()));
  }
  
  public HttpGetNested<A> editOrNewHttpGetLike(HTTPGetAction item) {
    return this.withNewHttpGetLike(Optional.ofNullable(this.buildHttpGet()).orElse(item));
  }
  
  public SleepNested<A> editOrNewSleep() {
    return this.withNewSleepLike(Optional.ofNullable(this.buildSleep()).orElse(new SleepActionBuilder().build()));
  }
  
  public SleepNested<A> editOrNewSleepLike(SleepAction item) {
    return this.withNewSleepLike(Optional.ofNullable(this.buildSleep()).orElse(item));
  }
  
  public TcpSocketNested<A> editOrNewTcpSocket() {
    return this.withNewTcpSocketLike(Optional.ofNullable(this.buildTcpSocket()).orElse(new TCPSocketActionBuilder().build()));
  }
  
  public TcpSocketNested<A> editOrNewTcpSocketLike(TCPSocketAction item) {
    return this.withNewTcpSocketLike(Optional.ofNullable(this.buildTcpSocket()).orElse(item));
  }
  
  public SleepNested<A> editSleep() {
    return this.withNewSleepLike(Optional.ofNullable(this.buildSleep()).orElse(null));
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
    LifecycleHandlerFluent that = (LifecycleHandlerFluent) o;
    if (!(Objects.equals(exec, that.exec))) {
      return false;
    }
    if (!(Objects.equals(httpGet, that.httpGet))) {
      return false;
    }
    if (!(Objects.equals(sleep, that.sleep))) {
      return false;
    }
    if (!(Objects.equals(tcpSocket, that.tcpSocket))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasExec() {
    return this.exec != null;
  }
  
  public boolean hasHttpGet() {
    return this.httpGet != null;
  }
  
  public boolean hasSleep() {
    return this.sleep != null;
  }
  
  public boolean hasTcpSocket() {
    return this.tcpSocket != null;
  }
  
  public int hashCode() {
    return Objects.hash(exec, httpGet, sleep, tcpSocket, additionalProperties);
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
    if (!(httpGet == null)) {
        sb.append("httpGet:");
        sb.append(httpGet);
        sb.append(",");
    }
    if (!(sleep == null)) {
        sb.append("sleep:");
        sb.append(sleep);
        sb.append(",");
    }
    if (!(tcpSocket == null)) {
        sb.append("tcpSocket:");
        sb.append(tcpSocket);
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
  
  public ExecNested<A> withNewExec() {
    return new ExecNested(null);
  }
  
  public ExecNested<A> withNewExecLike(ExecAction item) {
    return new ExecNested(item);
  }
  
  public HttpGetNested<A> withNewHttpGet() {
    return new HttpGetNested(null);
  }
  
  public HttpGetNested<A> withNewHttpGetLike(HTTPGetAction item) {
    return new HttpGetNested(item);
  }
  
  public SleepNested<A> withNewSleep() {
    return new SleepNested(null);
  }
  
  public A withNewSleep(Long seconds) {
    return (A) this.withSleep(new SleepAction(seconds));
  }
  
  public SleepNested<A> withNewSleepLike(SleepAction item) {
    return new SleepNested(item);
  }
  
  public TcpSocketNested<A> withNewTcpSocket() {
    return new TcpSocketNested(null);
  }
  
  public TcpSocketNested<A> withNewTcpSocketLike(TCPSocketAction item) {
    return new TcpSocketNested(item);
  }
  
  public A withSleep(SleepAction sleep) {
    this._visitables.remove("sleep");
    if (sleep != null) {
        this.sleep = new SleepActionBuilder(sleep);
        this._visitables.get("sleep").add(this.sleep);
    } else {
        this.sleep = null;
        this._visitables.get("sleep").remove(this.sleep);
    }
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
  public class ExecNested<N> extends ExecActionFluent<ExecNested<N>> implements Nested<N>{
  
    ExecActionBuilder builder;
  
    ExecNested(ExecAction item) {
      this.builder = new ExecActionBuilder(this, item);
    }
  
    public N and() {
      return (N) LifecycleHandlerFluent.this.withExec(builder.build());
    }
    
    public N endExec() {
      return and();
    }
    
  }
  public class HttpGetNested<N> extends HTTPGetActionFluent<HttpGetNested<N>> implements Nested<N>{
  
    HTTPGetActionBuilder builder;
  
    HttpGetNested(HTTPGetAction item) {
      this.builder = new HTTPGetActionBuilder(this, item);
    }
  
    public N and() {
      return (N) LifecycleHandlerFluent.this.withHttpGet(builder.build());
    }
    
    public N endHttpGet() {
      return and();
    }
    
  }
  public class SleepNested<N> extends SleepActionFluent<SleepNested<N>> implements Nested<N>{
  
    SleepActionBuilder builder;
  
    SleepNested(SleepAction item) {
      this.builder = new SleepActionBuilder(this, item);
    }
  
    public N and() {
      return (N) LifecycleHandlerFluent.this.withSleep(builder.build());
    }
    
    public N endSleep() {
      return and();
    }
    
  }
  public class TcpSocketNested<N> extends TCPSocketActionFluent<TcpSocketNested<N>> implements Nested<N>{
  
    TCPSocketActionBuilder builder;
  
    TcpSocketNested(TCPSocketAction item) {
      this.builder = new TCPSocketActionBuilder(this, item);
    }
  
    public N and() {
      return (N) LifecycleHandlerFluent.this.withTcpSocket(builder.build());
    }
    
    public N endTcpSocket() {
      return and();
    }
    
  }
}