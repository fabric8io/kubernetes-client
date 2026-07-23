package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.ObjectReferenceFluent;
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
public class Metal3DataClaimStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.Metal3DataClaimStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String errorMessage;
  private ObjectReferenceBuilder renderedData;

  public Metal3DataClaimStatusFluent() {
  }
  
  public Metal3DataClaimStatusFluent(Metal3DataClaimStatus instance) {
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
  
  public ObjectReference buildRenderedData() {
    return this.renderedData != null ? this.renderedData.build() : null;
  }
  
  protected void copyInstance(Metal3DataClaimStatus instance) {
    instance = instance != null ? instance : new Metal3DataClaimStatus();
    if (instance != null) {
        this.withErrorMessage(instance.getErrorMessage());
        this.withRenderedData(instance.getRenderedData());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RenderedDataNested<A> editOrNewRenderedData() {
    return this.withNewRenderedDataLike(Optional.ofNullable(this.buildRenderedData()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public RenderedDataNested<A> editOrNewRenderedDataLike(ObjectReference item) {
    return this.withNewRenderedDataLike(Optional.ofNullable(this.buildRenderedData()).orElse(item));
  }
  
  public RenderedDataNested<A> editRenderedData() {
    return this.withNewRenderedDataLike(Optional.ofNullable(this.buildRenderedData()).orElse(null));
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
    Metal3DataClaimStatusFluent that = (Metal3DataClaimStatusFluent) o;
    if (!(Objects.equals(errorMessage, that.errorMessage))) {
      return false;
    }
    if (!(Objects.equals(renderedData, that.renderedData))) {
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
  
  public String getErrorMessage() {
    return this.errorMessage;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasErrorMessage() {
    return this.errorMessage != null;
  }
  
  public boolean hasRenderedData() {
    return this.renderedData != null;
  }
  
  public int hashCode() {
    return Objects.hash(errorMessage, renderedData, additionalProperties);
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
    if (!(errorMessage == null)) {
        sb.append("errorMessage:");
        sb.append(errorMessage);
        sb.append(",");
    }
    if (!(renderedData == null)) {
        sb.append("renderedData:");
        sb.append(renderedData);
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
  
  public A withErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return (A) this;
  }
  
  public RenderedDataNested<A> withNewRenderedData() {
    return new RenderedDataNested(null);
  }
  
  public RenderedDataNested<A> withNewRenderedDataLike(ObjectReference item) {
    return new RenderedDataNested(item);
  }
  
  public A withRenderedData(ObjectReference renderedData) {
    this._visitables.remove("renderedData");
    if (renderedData != null) {
        this.renderedData = new ObjectReferenceBuilder(renderedData);
        this._visitables.get("renderedData").add(this.renderedData);
    } else {
        this.renderedData = null;
        this._visitables.get("renderedData").remove(this.renderedData);
    }
    return (A) this;
  }
  public class RenderedDataNested<N> extends ObjectReferenceFluent<RenderedDataNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    RenderedDataNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) Metal3DataClaimStatusFluent.this.withRenderedData(builder.build());
    }
    
    public N endRenderedData() {
      return and();
    }
    
  }
}