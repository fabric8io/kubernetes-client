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
public class PerspectiveVisibilityFluent<A extends io.fabric8.openshift.api.model.operator.v1.PerspectiveVisibilityFluent<A>> extends BaseFluent<A>{

  private ResourceAttributesAccessReviewBuilder accessReview;
  private Map<String,Object> additionalProperties;
  private String state;

  public PerspectiveVisibilityFluent() {
  }
  
  public PerspectiveVisibilityFluent(PerspectiveVisibility instance) {
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
  
  public ResourceAttributesAccessReview buildAccessReview() {
    return this.accessReview != null ? this.accessReview.build() : null;
  }
  
  protected void copyInstance(PerspectiveVisibility instance) {
    instance = instance != null ? instance : new PerspectiveVisibility();
    if (instance != null) {
        this.withAccessReview(instance.getAccessReview());
        this.withState(instance.getState());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AccessReviewNested<A> editAccessReview() {
    return this.withNewAccessReviewLike(Optional.ofNullable(this.buildAccessReview()).orElse(null));
  }
  
  public AccessReviewNested<A> editOrNewAccessReview() {
    return this.withNewAccessReviewLike(Optional.ofNullable(this.buildAccessReview()).orElse(new ResourceAttributesAccessReviewBuilder().build()));
  }
  
  public AccessReviewNested<A> editOrNewAccessReviewLike(ResourceAttributesAccessReview item) {
    return this.withNewAccessReviewLike(Optional.ofNullable(this.buildAccessReview()).orElse(item));
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
    PerspectiveVisibilityFluent that = (PerspectiveVisibilityFluent) o;
    if (!(Objects.equals(accessReview, that.accessReview))) {
      return false;
    }
    if (!(Objects.equals(state, that.state))) {
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
  
  public String getState() {
    return this.state;
  }
  
  public boolean hasAccessReview() {
    return this.accessReview != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasState() {
    return this.state != null;
  }
  
  public int hashCode() {
    return Objects.hash(accessReview, state, additionalProperties);
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
    if (!(accessReview == null)) {
        sb.append("accessReview:");
        sb.append(accessReview);
        sb.append(",");
    }
    if (!(state == null)) {
        sb.append("state:");
        sb.append(state);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccessReview(ResourceAttributesAccessReview accessReview) {
    this._visitables.remove("accessReview");
    if (accessReview != null) {
        this.accessReview = new ResourceAttributesAccessReviewBuilder(accessReview);
        this._visitables.get("accessReview").add(this.accessReview);
    } else {
        this.accessReview = null;
        this._visitables.get("accessReview").remove(this.accessReview);
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public AccessReviewNested<A> withNewAccessReview() {
    return new AccessReviewNested(null);
  }
  
  public AccessReviewNested<A> withNewAccessReviewLike(ResourceAttributesAccessReview item) {
    return new AccessReviewNested(item);
  }
  
  public A withState(String state) {
    this.state = state;
    return (A) this;
  }
  public class AccessReviewNested<N> extends ResourceAttributesAccessReviewFluent<AccessReviewNested<N>> implements Nested<N>{
  
    ResourceAttributesAccessReviewBuilder builder;
  
    AccessReviewNested(ResourceAttributesAccessReview item) {
      this.builder = new ResourceAttributesAccessReviewBuilder(this, item);
    }
  
    public N and() {
      return (N) PerspectiveVisibilityFluent.this.withAccessReview(builder.build());
    }
    
    public N endAccessReview() {
      return and();
    }
    
  }
}