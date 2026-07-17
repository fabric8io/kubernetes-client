package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class NodeDisruptionPolicySpecActionFluent<A extends io.fabric8.openshift.api.model.operator.v1.NodeDisruptionPolicySpecActionFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ReloadServiceBuilder reload;
  private RestartServiceBuilder restart;
  private String type;

  public NodeDisruptionPolicySpecActionFluent() {
  }
  
  public NodeDisruptionPolicySpecActionFluent(NodeDisruptionPolicySpecAction instance) {
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
  
  public ReloadService buildReload() {
    return this.reload != null ? this.reload.build() : null;
  }
  
  public RestartService buildRestart() {
    return this.restart != null ? this.restart.build() : null;
  }
  
  protected void copyInstance(NodeDisruptionPolicySpecAction instance) {
    instance = instance != null ? instance : new NodeDisruptionPolicySpecAction();
    if (instance != null) {
        this.withReload(instance.getReload());
        this.withRestart(instance.getRestart());
        this.withType(instance.getType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ReloadNested<A> editOrNewReload() {
    return this.withNewReloadLike(Optional.ofNullable(this.buildReload()).orElse(new ReloadServiceBuilder().build()));
  }
  
  public ReloadNested<A> editOrNewReloadLike(ReloadService item) {
    return this.withNewReloadLike(Optional.ofNullable(this.buildReload()).orElse(item));
  }
  
  public RestartNested<A> editOrNewRestart() {
    return this.withNewRestartLike(Optional.ofNullable(this.buildRestart()).orElse(new RestartServiceBuilder().build()));
  }
  
  public RestartNested<A> editOrNewRestartLike(RestartService item) {
    return this.withNewRestartLike(Optional.ofNullable(this.buildRestart()).orElse(item));
  }
  
  public ReloadNested<A> editReload() {
    return this.withNewReloadLike(Optional.ofNullable(this.buildReload()).orElse(null));
  }
  
  public RestartNested<A> editRestart() {
    return this.withNewRestartLike(Optional.ofNullable(this.buildRestart()).orElse(null));
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
    NodeDisruptionPolicySpecActionFluent that = (NodeDisruptionPolicySpecActionFluent) o;
    if (!(Objects.equals(reload, that.reload))) {
      return false;
    }
    if (!(Objects.equals(restart, that.restart))) {
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
  
  public boolean hasReload() {
    return this.reload != null;
  }
  
  public boolean hasRestart() {
    return this.restart != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public int hashCode() {
    return Objects.hash(reload, restart, type, additionalProperties);
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
    if (!(reload == null)) {
        sb.append("reload:");
        sb.append(reload);
        sb.append(",");
    }
    if (!(restart == null)) {
        sb.append("restart:");
        sb.append(restart);
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
  
  public ReloadNested<A> withNewReload() {
    return new ReloadNested(null);
  }
  
  public A withNewReload(String serviceName) {
    return (A) this.withReload(new ReloadService(serviceName));
  }
  
  public ReloadNested<A> withNewReloadLike(ReloadService item) {
    return new ReloadNested(item);
  }
  
  public RestartNested<A> withNewRestart() {
    return new RestartNested(null);
  }
  
  public A withNewRestart(String serviceName) {
    return (A) this.withRestart(new RestartService(serviceName));
  }
  
  public RestartNested<A> withNewRestartLike(RestartService item) {
    return new RestartNested(item);
  }
  
  public A withReload(ReloadService reload) {
    this._visitables.remove("reload");
    if (reload != null) {
        this.reload = new ReloadServiceBuilder(reload);
        this._visitables.get("reload").add(this.reload);
    } else {
        this.reload = null;
        this._visitables.get("reload").remove(this.reload);
    }
    return (A) this;
  }
  
  public A withRestart(RestartService restart) {
    this._visitables.remove("restart");
    if (restart != null) {
        this.restart = new RestartServiceBuilder(restart);
        this._visitables.get("restart").add(this.restart);
    } else {
        this.restart = null;
        this._visitables.get("restart").remove(this.restart);
    }
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
    return (A) this;
  }
  public class ReloadNested<N> extends ReloadServiceFluent<ReloadNested<N>> implements Nested<N>{
  
    ReloadServiceBuilder builder;
  
    ReloadNested(ReloadService item) {
      this.builder = new ReloadServiceBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeDisruptionPolicySpecActionFluent.this.withReload(builder.build());
    }
    
    public N endReload() {
      return and();
    }
    
  }
  public class RestartNested<N> extends RestartServiceFluent<RestartNested<N>> implements Nested<N>{
  
    RestartServiceBuilder builder;
  
    RestartNested(RestartService item) {
      this.builder = new RestartServiceBuilder(this, item);
    }
  
    public N and() {
      return (N) NodeDisruptionPolicySpecActionFluent.this.withRestart(builder.build());
    }
    
    public N endRestart() {
      return and();
    }
    
  }
}