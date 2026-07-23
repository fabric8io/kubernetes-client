package io.fabric8.istio.api.api.networking.v1beta1;

import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelector;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorBuilder;
import io.fabric8.istio.api.api.type.v1beta1.WorkloadSelectorFluent;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class ProxyConfigFluent<A extends io.fabric8.istio.api.api.networking.v1beta1.ProxyConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer concurrency;
  private Map<String,String> environmentVariables;
  private ProxyImageBuilder image;
  private WorkloadSelectorBuilder selector;

  public ProxyConfigFluent() {
  }
  
  public ProxyConfigFluent(ProxyConfig instance) {
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
  
  public A addToEnvironmentVariables(Map<String,String> map) {
    if (this.environmentVariables == null && map != null) {
      this.environmentVariables = new LinkedHashMap();
    }
    if (map != null) {
      this.environmentVariables.putAll(map);
    }
    return (A) this;
  }
  
  public A addToEnvironmentVariables(String key,String value) {
    if (this.environmentVariables == null && key != null && value != null) {
      this.environmentVariables = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.environmentVariables.put(key, value);
    }
    return (A) this;
  }
  
  public ProxyImage buildImage() {
    return this.image != null ? this.image.build() : null;
  }
  
  public WorkloadSelector buildSelector() {
    return this.selector != null ? this.selector.build() : null;
  }
  
  protected void copyInstance(ProxyConfig instance) {
    instance = instance != null ? instance : new ProxyConfig();
    if (instance != null) {
        this.withConcurrency(instance.getConcurrency());
        this.withEnvironmentVariables(instance.getEnvironmentVariables());
        this.withImage(instance.getImage());
        this.withSelector(instance.getSelector());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ImageNested<A> editImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(null));
  }
  
  public ImageNested<A> editOrNewImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(new ProxyImageBuilder().build()));
  }
  
  public ImageNested<A> editOrNewImageLike(ProxyImage item) {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(item));
  }
  
  public SelectorNested<A> editOrNewSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(new WorkloadSelectorBuilder().build()));
  }
  
  public SelectorNested<A> editOrNewSelectorLike(WorkloadSelector item) {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(item));
  }
  
  public SelectorNested<A> editSelector() {
    return this.withNewSelectorLike(Optional.ofNullable(this.buildSelector()).orElse(null));
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
    ProxyConfigFluent that = (ProxyConfigFluent) o;
    if (!(Objects.equals(concurrency, that.concurrency))) {
      return false;
    }
    if (!(Objects.equals(environmentVariables, that.environmentVariables))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(selector, that.selector))) {
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
  
  public Integer getConcurrency() {
    return this.concurrency;
  }
  
  public Map<String,String> getEnvironmentVariables() {
    return this.environmentVariables;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConcurrency() {
    return this.concurrency != null;
  }
  
  public boolean hasEnvironmentVariables() {
    return this.environmentVariables != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public int hashCode() {
    return Objects.hash(concurrency, environmentVariables, image, selector, additionalProperties);
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
  
  public A removeFromEnvironmentVariables(String key) {
    if (this.environmentVariables == null) {
      return (A) this;
    }
    if (key != null && this.environmentVariables != null) {
      this.environmentVariables.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromEnvironmentVariables(Map<String,String> map) {
    if (this.environmentVariables == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.environmentVariables != null) {
          this.environmentVariables.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(concurrency == null)) {
        sb.append("concurrency:");
        sb.append(concurrency);
        sb.append(",");
    }
    if (!(environmentVariables == null) && !(environmentVariables.isEmpty())) {
        sb.append("environmentVariables:");
        sb.append(environmentVariables);
        sb.append(",");
    }
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(selector == null)) {
        sb.append("selector:");
        sb.append(selector);
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
  
  public A withConcurrency(Integer concurrency) {
    this.concurrency = concurrency;
    return (A) this;
  }
  
  public <K,V>A withEnvironmentVariables(Map<String,String> environmentVariables) {
    if (environmentVariables == null) {
      this.environmentVariables = null;
    } else {
      this.environmentVariables = new LinkedHashMap(environmentVariables);
    }
    return (A) this;
  }
  
  public A withImage(ProxyImage image) {
    this._visitables.remove("image");
    if (image != null) {
        this.image = new ProxyImageBuilder(image);
        this._visitables.get("image").add(this.image);
    } else {
        this.image = null;
        this._visitables.get("image").remove(this.image);
    }
    return (A) this;
  }
  
  public ImageNested<A> withNewImage() {
    return new ImageNested(null);
  }
  
  public A withNewImage(String imageType) {
    return (A) this.withImage(new ProxyImage(imageType));
  }
  
  public ImageNested<A> withNewImageLike(ProxyImage item) {
    return new ImageNested(item);
  }
  
  public SelectorNested<A> withNewSelector() {
    return new SelectorNested(null);
  }
  
  public SelectorNested<A> withNewSelectorLike(WorkloadSelector item) {
    return new SelectorNested(item);
  }
  
  public A withSelector(WorkloadSelector selector) {
    this._visitables.remove("selector");
    if (selector != null) {
        this.selector = new WorkloadSelectorBuilder(selector);
        this._visitables.get("selector").add(this.selector);
    } else {
        this.selector = null;
        this._visitables.get("selector").remove(this.selector);
    }
    return (A) this;
  }
  public class ImageNested<N> extends ProxyImageFluent<ImageNested<N>> implements Nested<N>{
  
    ProxyImageBuilder builder;
  
    ImageNested(ProxyImage item) {
      this.builder = new ProxyImageBuilder(this, item);
    }
  
    public N and() {
      return (N) ProxyConfigFluent.this.withImage(builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
  public class SelectorNested<N> extends WorkloadSelectorFluent<SelectorNested<N>> implements Nested<N>{
  
    WorkloadSelectorBuilder builder;
  
    SelectorNested(WorkloadSelector item) {
      this.builder = new WorkloadSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ProxyConfigFluent.this.withSelector(builder.build());
    }
    
    public N endSelector() {
      return and();
    }
    
  }
}