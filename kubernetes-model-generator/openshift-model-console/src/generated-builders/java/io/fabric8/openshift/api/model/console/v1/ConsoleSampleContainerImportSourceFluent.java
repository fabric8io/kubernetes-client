package io.fabric8.openshift.api.model.console.v1;

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
public class ConsoleSampleContainerImportSourceFluent<A extends io.fabric8.openshift.api.model.console.v1.ConsoleSampleContainerImportSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String image;
  private ConsoleSampleContainerImportSourceServiceBuilder service;

  public ConsoleSampleContainerImportSourceFluent() {
  }
  
  public ConsoleSampleContainerImportSourceFluent(ConsoleSampleContainerImportSource instance) {
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
  
  public ConsoleSampleContainerImportSourceService buildService() {
    return this.service != null ? this.service.build() : null;
  }
  
  protected void copyInstance(ConsoleSampleContainerImportSource instance) {
    instance = instance != null ? instance : new ConsoleSampleContainerImportSource();
    if (instance != null) {
        this.withImage(instance.getImage());
        this.withService(instance.getService());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServiceNested<A> editOrNewService() {
    return this.withNewServiceLike(Optional.ofNullable(this.buildService()).orElse(new ConsoleSampleContainerImportSourceServiceBuilder().build()));
  }
  
  public ServiceNested<A> editOrNewServiceLike(ConsoleSampleContainerImportSourceService item) {
    return this.withNewServiceLike(Optional.ofNullable(this.buildService()).orElse(item));
  }
  
  public ServiceNested<A> editService() {
    return this.withNewServiceLike(Optional.ofNullable(this.buildService()).orElse(null));
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
    ConsoleSampleContainerImportSourceFluent that = (ConsoleSampleContainerImportSourceFluent) o;
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(service, that.service))) {
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
  
  public String getImage() {
    return this.image;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasService() {
    return this.service != null;
  }
  
  public int hashCode() {
    return Objects.hash(image, service, additionalProperties);
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
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(service == null)) {
        sb.append("service:");
        sb.append(service);
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
  
  public A withImage(String image) {
    this.image = image;
    return (A) this;
  }
  
  public ServiceNested<A> withNewService() {
    return new ServiceNested(null);
  }
  
  public A withNewService(Integer targetPort) {
    return (A) this.withService(new ConsoleSampleContainerImportSourceService(targetPort));
  }
  
  public ServiceNested<A> withNewServiceLike(ConsoleSampleContainerImportSourceService item) {
    return new ServiceNested(item);
  }
  
  public A withService(ConsoleSampleContainerImportSourceService service) {
    this._visitables.remove("service");
    if (service != null) {
        this.service = new ConsoleSampleContainerImportSourceServiceBuilder(service);
        this._visitables.get("service").add(this.service);
    } else {
        this.service = null;
        this._visitables.get("service").remove(this.service);
    }
    return (A) this;
  }
  public class ServiceNested<N> extends ConsoleSampleContainerImportSourceServiceFluent<ServiceNested<N>> implements Nested<N>{
  
    ConsoleSampleContainerImportSourceServiceBuilder builder;
  
    ServiceNested(ConsoleSampleContainerImportSourceService item) {
      this.builder = new ConsoleSampleContainerImportSourceServiceBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleSampleContainerImportSourceFluent.this.withService(builder.build());
    }
    
    public N endService() {
      return and();
    }
    
  }
}