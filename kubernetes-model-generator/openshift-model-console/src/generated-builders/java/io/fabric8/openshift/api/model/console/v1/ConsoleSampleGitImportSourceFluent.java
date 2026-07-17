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
public class ConsoleSampleGitImportSourceFluent<A extends io.fabric8.openshift.api.model.console.v1.ConsoleSampleGitImportSourceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ConsoleSampleGitImportSourceRepositoryBuilder repository;
  private ConsoleSampleGitImportSourceServiceBuilder service;

  public ConsoleSampleGitImportSourceFluent() {
  }
  
  public ConsoleSampleGitImportSourceFluent(ConsoleSampleGitImportSource instance) {
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
  
  public ConsoleSampleGitImportSourceRepository buildRepository() {
    return this.repository != null ? this.repository.build() : null;
  }
  
  public ConsoleSampleGitImportSourceService buildService() {
    return this.service != null ? this.service.build() : null;
  }
  
  protected void copyInstance(ConsoleSampleGitImportSource instance) {
    instance = instance != null ? instance : new ConsoleSampleGitImportSource();
    if (instance != null) {
        this.withRepository(instance.getRepository());
        this.withService(instance.getService());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public RepositoryNested<A> editOrNewRepository() {
    return this.withNewRepositoryLike(Optional.ofNullable(this.buildRepository()).orElse(new ConsoleSampleGitImportSourceRepositoryBuilder().build()));
  }
  
  public RepositoryNested<A> editOrNewRepositoryLike(ConsoleSampleGitImportSourceRepository item) {
    return this.withNewRepositoryLike(Optional.ofNullable(this.buildRepository()).orElse(item));
  }
  
  public ServiceNested<A> editOrNewService() {
    return this.withNewServiceLike(Optional.ofNullable(this.buildService()).orElse(new ConsoleSampleGitImportSourceServiceBuilder().build()));
  }
  
  public ServiceNested<A> editOrNewServiceLike(ConsoleSampleGitImportSourceService item) {
    return this.withNewServiceLike(Optional.ofNullable(this.buildService()).orElse(item));
  }
  
  public RepositoryNested<A> editRepository() {
    return this.withNewRepositoryLike(Optional.ofNullable(this.buildRepository()).orElse(null));
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
    ConsoleSampleGitImportSourceFluent that = (ConsoleSampleGitImportSourceFluent) o;
    if (!(Objects.equals(repository, that.repository))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasRepository() {
    return this.repository != null;
  }
  
  public boolean hasService() {
    return this.service != null;
  }
  
  public int hashCode() {
    return Objects.hash(repository, service, additionalProperties);
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
    if (!(repository == null)) {
        sb.append("repository:");
        sb.append(repository);
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
  
  public RepositoryNested<A> withNewRepository() {
    return new RepositoryNested(null);
  }
  
  public A withNewRepository(String contextDir,String revision,String url) {
    return (A) this.withRepository(new ConsoleSampleGitImportSourceRepository(contextDir, revision, url));
  }
  
  public RepositoryNested<A> withNewRepositoryLike(ConsoleSampleGitImportSourceRepository item) {
    return new RepositoryNested(item);
  }
  
  public ServiceNested<A> withNewService() {
    return new ServiceNested(null);
  }
  
  public A withNewService(Integer targetPort) {
    return (A) this.withService(new ConsoleSampleGitImportSourceService(targetPort));
  }
  
  public ServiceNested<A> withNewServiceLike(ConsoleSampleGitImportSourceService item) {
    return new ServiceNested(item);
  }
  
  public A withRepository(ConsoleSampleGitImportSourceRepository repository) {
    this._visitables.remove("repository");
    if (repository != null) {
        this.repository = new ConsoleSampleGitImportSourceRepositoryBuilder(repository);
        this._visitables.get("repository").add(this.repository);
    } else {
        this.repository = null;
        this._visitables.get("repository").remove(this.repository);
    }
    return (A) this;
  }
  
  public A withService(ConsoleSampleGitImportSourceService service) {
    this._visitables.remove("service");
    if (service != null) {
        this.service = new ConsoleSampleGitImportSourceServiceBuilder(service);
        this._visitables.get("service").add(this.service);
    } else {
        this.service = null;
        this._visitables.get("service").remove(this.service);
    }
    return (A) this;
  }
  public class RepositoryNested<N> extends ConsoleSampleGitImportSourceRepositoryFluent<RepositoryNested<N>> implements Nested<N>{
  
    ConsoleSampleGitImportSourceRepositoryBuilder builder;
  
    RepositoryNested(ConsoleSampleGitImportSourceRepository item) {
      this.builder = new ConsoleSampleGitImportSourceRepositoryBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleSampleGitImportSourceFluent.this.withRepository(builder.build());
    }
    
    public N endRepository() {
      return and();
    }
    
  }
  public class ServiceNested<N> extends ConsoleSampleGitImportSourceServiceFluent<ServiceNested<N>> implements Nested<N>{
  
    ConsoleSampleGitImportSourceServiceBuilder builder;
  
    ServiceNested(ConsoleSampleGitImportSourceService item) {
      this.builder = new ConsoleSampleGitImportSourceServiceBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleSampleGitImportSourceFluent.this.withService(builder.build());
    }
    
    public N endService() {
      return and();
    }
    
  }
}