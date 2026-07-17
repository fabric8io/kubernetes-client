package io.fabric8.openshift.api.model.operator.v1;

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
public class LoggingDestinationFluent<A extends io.fabric8.openshift.api.model.operator.v1.LoggingDestinationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ContainerLoggingDestinationParametersBuilder container;
  private SyslogLoggingDestinationParametersBuilder syslog;
  private String type;

  public LoggingDestinationFluent() {
  }
  
  public LoggingDestinationFluent(LoggingDestination instance) {
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
  
  public ContainerLoggingDestinationParameters buildContainer() {
    return this.container != null ? this.container.build() : null;
  }
  
  public SyslogLoggingDestinationParameters buildSyslog() {
    return this.syslog != null ? this.syslog.build() : null;
  }
  
  protected void copyInstance(LoggingDestination instance) {
    instance = instance != null ? instance : new LoggingDestination();
    if (instance != null) {
        this.withContainer(instance.getContainer());
        this.withSyslog(instance.getSyslog());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ContainerNested<A> editContainer() {
    return this.withNewContainerLike(Optional.ofNullable(this.buildContainer()).orElse(null));
  }
  
  public ContainerNested<A> editOrNewContainer() {
    return this.withNewContainerLike(Optional.ofNullable(this.buildContainer()).orElse(new ContainerLoggingDestinationParametersBuilder().build()));
  }
  
  public ContainerNested<A> editOrNewContainerLike(ContainerLoggingDestinationParameters item) {
    return this.withNewContainerLike(Optional.ofNullable(this.buildContainer()).orElse(item));
  }
  
  public SyslogNested<A> editOrNewSyslog() {
    return this.withNewSyslogLike(Optional.ofNullable(this.buildSyslog()).orElse(new SyslogLoggingDestinationParametersBuilder().build()));
  }
  
  public SyslogNested<A> editOrNewSyslogLike(SyslogLoggingDestinationParameters item) {
    return this.withNewSyslogLike(Optional.ofNullable(this.buildSyslog()).orElse(item));
  }
  
  public SyslogNested<A> editSyslog() {
    return this.withNewSyslogLike(Optional.ofNullable(this.buildSyslog()).orElse(null));
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
    LoggingDestinationFluent that = (LoggingDestinationFluent) o;
    if (!(Objects.equals(container, that.container))) {
      return false;
    }
    if (!(Objects.equals(syslog, that.syslog))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
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
  
  public String getType() {
    return this.type;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasContainer() {
    return this.container != null;
  }
  
  public boolean hasSyslog() {
    return this.syslog != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(container, syslog, type, additionalProperties);
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
    if (!(container == null)) {
        sb.append("container:");
        sb.append(container);
        sb.append(",");
    }
    if (!(syslog == null)) {
        sb.append("syslog:");
        sb.append(syslog);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
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
  
  public A withContainer(ContainerLoggingDestinationParameters container) {
    this._visitables.remove("container");
    if (container != null) {
        this.container = new ContainerLoggingDestinationParametersBuilder(container);
        this._visitables.get("container").add(this.container);
    } else {
        this.container = null;
        this._visitables.get("container").remove(this.container);
    }
    return (A) this;
  }
  
  public ContainerNested<A> withNewContainer() {
    return new ContainerNested(null);
  }
  
  public A withNewContainer(Integer maxLength) {
    return (A) this.withContainer(new ContainerLoggingDestinationParameters(maxLength));
  }
  
  public ContainerNested<A> withNewContainerLike(ContainerLoggingDestinationParameters item) {
    return new ContainerNested(item);
  }
  
  public SyslogNested<A> withNewSyslog() {
    return new SyslogNested(null);
  }
  
  public A withNewSyslog(String address,String facility,Long maxLength,Long port) {
    return (A) this.withSyslog(new SyslogLoggingDestinationParameters(address, facility, maxLength, port));
  }
  
  public SyslogNested<A> withNewSyslogLike(SyslogLoggingDestinationParameters item) {
    return new SyslogNested(item);
  }
  
  public A withSyslog(SyslogLoggingDestinationParameters syslog) {
    this._visitables.remove("syslog");
    if (syslog != null) {
        this.syslog = new SyslogLoggingDestinationParametersBuilder(syslog);
        this._visitables.get("syslog").add(this.syslog);
    } else {
        this.syslog = null;
        this._visitables.get("syslog").remove(this.syslog);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ContainerNested<N> extends ContainerLoggingDestinationParametersFluent<ContainerNested<N>> implements Nested<N>{
  
    ContainerLoggingDestinationParametersBuilder builder;
  
    ContainerNested(ContainerLoggingDestinationParameters item) {
      this.builder = new ContainerLoggingDestinationParametersBuilder(this, item);
    }
  
    public N and() {
      return (N) LoggingDestinationFluent.this.withContainer(builder.build());
    }
    
    public N endContainer() {
      return and();
    }
    
  }
  public class SyslogNested<N> extends SyslogLoggingDestinationParametersFluent<SyslogNested<N>> implements Nested<N>{
  
    SyslogLoggingDestinationParametersBuilder builder;
  
    SyslogNested(SyslogLoggingDestinationParameters item) {
      this.builder = new SyslogLoggingDestinationParametersBuilder(this, item);
    }
  
    public N and() {
      return (N) LoggingDestinationFluent.this.withSyslog(builder.build());
    }
    
    public N endSyslog() {
      return and();
    }
    
  }
}