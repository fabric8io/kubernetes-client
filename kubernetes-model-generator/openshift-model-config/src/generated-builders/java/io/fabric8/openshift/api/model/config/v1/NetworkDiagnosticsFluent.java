package io.fabric8.openshift.api.model.config.v1;

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
public class NetworkDiagnosticsFluent<A extends io.fabric8.openshift.api.model.config.v1.NetworkDiagnosticsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String mode;
  private NetworkDiagnosticsSourcePlacementBuilder sourcePlacement;
  private NetworkDiagnosticsTargetPlacementBuilder targetPlacement;

  public NetworkDiagnosticsFluent() {
  }
  
  public NetworkDiagnosticsFluent(NetworkDiagnostics instance) {
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
  
  public NetworkDiagnosticsSourcePlacement buildSourcePlacement() {
    return this.sourcePlacement != null ? this.sourcePlacement.build() : null;
  }
  
  public NetworkDiagnosticsTargetPlacement buildTargetPlacement() {
    return this.targetPlacement != null ? this.targetPlacement.build() : null;
  }
  
  protected void copyInstance(NetworkDiagnostics instance) {
    instance = instance != null ? instance : new NetworkDiagnostics();
    if (instance != null) {
        this.withMode(instance.getMode());
        this.withSourcePlacement(instance.getSourcePlacement());
        this.withTargetPlacement(instance.getTargetPlacement());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public SourcePlacementNested<A> editOrNewSourcePlacement() {
    return this.withNewSourcePlacementLike(Optional.ofNullable(this.buildSourcePlacement()).orElse(new NetworkDiagnosticsSourcePlacementBuilder().build()));
  }
  
  public SourcePlacementNested<A> editOrNewSourcePlacementLike(NetworkDiagnosticsSourcePlacement item) {
    return this.withNewSourcePlacementLike(Optional.ofNullable(this.buildSourcePlacement()).orElse(item));
  }
  
  public TargetPlacementNested<A> editOrNewTargetPlacement() {
    return this.withNewTargetPlacementLike(Optional.ofNullable(this.buildTargetPlacement()).orElse(new NetworkDiagnosticsTargetPlacementBuilder().build()));
  }
  
  public TargetPlacementNested<A> editOrNewTargetPlacementLike(NetworkDiagnosticsTargetPlacement item) {
    return this.withNewTargetPlacementLike(Optional.ofNullable(this.buildTargetPlacement()).orElse(item));
  }
  
  public SourcePlacementNested<A> editSourcePlacement() {
    return this.withNewSourcePlacementLike(Optional.ofNullable(this.buildSourcePlacement()).orElse(null));
  }
  
  public TargetPlacementNested<A> editTargetPlacement() {
    return this.withNewTargetPlacementLike(Optional.ofNullable(this.buildTargetPlacement()).orElse(null));
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
    NetworkDiagnosticsFluent that = (NetworkDiagnosticsFluent) o;
    if (!(Objects.equals(mode, that.mode))) {
      return false;
    }
    if (!(Objects.equals(sourcePlacement, that.sourcePlacement))) {
      return false;
    }
    if (!(Objects.equals(targetPlacement, that.targetPlacement))) {
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
  
  public String getMode() {
    return this.mode;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMode() {
    return this.mode != null;
  }
  
  public boolean hasSourcePlacement() {
    return this.sourcePlacement != null;
  }
  
  public boolean hasTargetPlacement() {
    return this.targetPlacement != null;
  }
  
  public int hashCode() {
    return Objects.hash(mode, sourcePlacement, targetPlacement, additionalProperties);
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
    if (!(mode == null)) {
        sb.append("mode:");
        sb.append(mode);
        sb.append(",");
    }
    if (!(sourcePlacement == null)) {
        sb.append("sourcePlacement:");
        sb.append(sourcePlacement);
        sb.append(",");
    }
    if (!(targetPlacement == null)) {
        sb.append("targetPlacement:");
        sb.append(targetPlacement);
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
  
  public A withMode(String mode) {
    this.mode = mode;
    return (A) this;
  }
  
  public SourcePlacementNested<A> withNewSourcePlacement() {
    return new SourcePlacementNested(null);
  }
  
  public SourcePlacementNested<A> withNewSourcePlacementLike(NetworkDiagnosticsSourcePlacement item) {
    return new SourcePlacementNested(item);
  }
  
  public TargetPlacementNested<A> withNewTargetPlacement() {
    return new TargetPlacementNested(null);
  }
  
  public TargetPlacementNested<A> withNewTargetPlacementLike(NetworkDiagnosticsTargetPlacement item) {
    return new TargetPlacementNested(item);
  }
  
  public A withSourcePlacement(NetworkDiagnosticsSourcePlacement sourcePlacement) {
    this._visitables.remove("sourcePlacement");
    if (sourcePlacement != null) {
        this.sourcePlacement = new NetworkDiagnosticsSourcePlacementBuilder(sourcePlacement);
        this._visitables.get("sourcePlacement").add(this.sourcePlacement);
    } else {
        this.sourcePlacement = null;
        this._visitables.get("sourcePlacement").remove(this.sourcePlacement);
    }
    return (A) this;
  }
  
  public A withTargetPlacement(NetworkDiagnosticsTargetPlacement targetPlacement) {
    this._visitables.remove("targetPlacement");
    if (targetPlacement != null) {
        this.targetPlacement = new NetworkDiagnosticsTargetPlacementBuilder(targetPlacement);
        this._visitables.get("targetPlacement").add(this.targetPlacement);
    } else {
        this.targetPlacement = null;
        this._visitables.get("targetPlacement").remove(this.targetPlacement);
    }
    return (A) this;
  }
  public class SourcePlacementNested<N> extends NetworkDiagnosticsSourcePlacementFluent<SourcePlacementNested<N>> implements Nested<N>{
  
    NetworkDiagnosticsSourcePlacementBuilder builder;
  
    SourcePlacementNested(NetworkDiagnosticsSourcePlacement item) {
      this.builder = new NetworkDiagnosticsSourcePlacementBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkDiagnosticsFluent.this.withSourcePlacement(builder.build());
    }
    
    public N endSourcePlacement() {
      return and();
    }
    
  }
  public class TargetPlacementNested<N> extends NetworkDiagnosticsTargetPlacementFluent<TargetPlacementNested<N>> implements Nested<N>{
  
    NetworkDiagnosticsTargetPlacementBuilder builder;
  
    TargetPlacementNested(NetworkDiagnosticsTargetPlacement item) {
      this.builder = new NetworkDiagnosticsTargetPlacementBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkDiagnosticsFluent.this.withTargetPlacement(builder.build());
    }
    
    public N endTargetPlacement() {
      return and();
    }
    
  }
}