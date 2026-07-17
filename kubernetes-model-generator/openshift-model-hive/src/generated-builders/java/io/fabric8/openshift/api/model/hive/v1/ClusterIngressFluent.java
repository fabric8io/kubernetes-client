package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LabelSelectorBuilder;
import io.fabric8.kubernetes.api.model.LabelSelectorFluent;
import io.fabric8.openshift.api.model.config.v1.ConfigMapNameReference;
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
public class ClusterIngressFluent<A extends io.fabric8.openshift.api.model.hive.v1.ClusterIngressFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String domain;
  private ConfigMapNameReference httpErrorCodePages;
  private String name;
  private LabelSelectorBuilder namespaceSelector;
  private LabelSelectorBuilder routeSelector;
  private String servingCertificate;

  public ClusterIngressFluent() {
  }
  
  public ClusterIngressFluent(ClusterIngress instance) {
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
  
  public LabelSelector buildNamespaceSelector() {
    return this.namespaceSelector != null ? this.namespaceSelector.build() : null;
  }
  
  public LabelSelector buildRouteSelector() {
    return this.routeSelector != null ? this.routeSelector.build() : null;
  }
  
  protected void copyInstance(ClusterIngress instance) {
    instance = instance != null ? instance : new ClusterIngress();
    if (instance != null) {
        this.withDomain(instance.getDomain());
        this.withHttpErrorCodePages(instance.getHttpErrorCodePages());
        this.withName(instance.getName());
        this.withNamespaceSelector(instance.getNamespaceSelector());
        this.withRouteSelector(instance.getRouteSelector());
        this.withServingCertificate(instance.getServingCertificate());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public NamespaceSelectorNested<A> editNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(null));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelector() {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public NamespaceSelectorNested<A> editOrNewNamespaceSelectorLike(LabelSelector item) {
    return this.withNewNamespaceSelectorLike(Optional.ofNullable(this.buildNamespaceSelector()).orElse(item));
  }
  
  public RouteSelectorNested<A> editOrNewRouteSelector() {
    return this.withNewRouteSelectorLike(Optional.ofNullable(this.buildRouteSelector()).orElse(new LabelSelectorBuilder().build()));
  }
  
  public RouteSelectorNested<A> editOrNewRouteSelectorLike(LabelSelector item) {
    return this.withNewRouteSelectorLike(Optional.ofNullable(this.buildRouteSelector()).orElse(item));
  }
  
  public RouteSelectorNested<A> editRouteSelector() {
    return this.withNewRouteSelectorLike(Optional.ofNullable(this.buildRouteSelector()).orElse(null));
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
    ClusterIngressFluent that = (ClusterIngressFluent) o;
    if (!(Objects.equals(domain, that.domain))) {
      return false;
    }
    if (!(Objects.equals(httpErrorCodePages, that.httpErrorCodePages))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(namespaceSelector, that.namespaceSelector))) {
      return false;
    }
    if (!(Objects.equals(routeSelector, that.routeSelector))) {
      return false;
    }
    if (!(Objects.equals(servingCertificate, that.servingCertificate))) {
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
  
  public String getDomain() {
    return this.domain;
  }
  
  public ConfigMapNameReference getHttpErrorCodePages() {
    return this.httpErrorCodePages;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getServingCertificate() {
    return this.servingCertificate;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDomain() {
    return this.domain != null;
  }
  
  public boolean hasHttpErrorCodePages() {
    return this.httpErrorCodePages != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNamespaceSelector() {
    return this.namespaceSelector != null;
  }
  
  public boolean hasRouteSelector() {
    return this.routeSelector != null;
  }
  
  public boolean hasServingCertificate() {
    return this.servingCertificate != null;
  }
  
  public int hashCode() {
    return Objects.hash(domain, httpErrorCodePages, name, namespaceSelector, routeSelector, servingCertificate, additionalProperties);
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
    if (!(domain == null)) {
        sb.append("domain:");
        sb.append(domain);
        sb.append(",");
    }
    if (!(httpErrorCodePages == null)) {
        sb.append("httpErrorCodePages:");
        sb.append(httpErrorCodePages);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(namespaceSelector == null)) {
        sb.append("namespaceSelector:");
        sb.append(namespaceSelector);
        sb.append(",");
    }
    if (!(routeSelector == null)) {
        sb.append("routeSelector:");
        sb.append(routeSelector);
        sb.append(",");
    }
    if (!(servingCertificate == null)) {
        sb.append("servingCertificate:");
        sb.append(servingCertificate);
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
  
  public A withDomain(String domain) {
    this.domain = domain;
    return (A) this;
  }
  
  public A withHttpErrorCodePages(ConfigMapNameReference httpErrorCodePages) {
    this.httpErrorCodePages = httpErrorCodePages;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withNamespaceSelector(LabelSelector namespaceSelector) {
    this._visitables.remove("namespaceSelector");
    if (namespaceSelector != null) {
        this.namespaceSelector = new LabelSelectorBuilder(namespaceSelector);
        this._visitables.get("namespaceSelector").add(this.namespaceSelector);
    } else {
        this.namespaceSelector = null;
        this._visitables.get("namespaceSelector").remove(this.namespaceSelector);
    }
    return (A) this;
  }
  
  public A withNewHttpErrorCodePages(String name) {
    return (A) this.withHttpErrorCodePages(new ConfigMapNameReference(name));
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelector() {
    return new NamespaceSelectorNested(null);
  }
  
  public NamespaceSelectorNested<A> withNewNamespaceSelectorLike(LabelSelector item) {
    return new NamespaceSelectorNested(item);
  }
  
  public RouteSelectorNested<A> withNewRouteSelector() {
    return new RouteSelectorNested(null);
  }
  
  public RouteSelectorNested<A> withNewRouteSelectorLike(LabelSelector item) {
    return new RouteSelectorNested(item);
  }
  
  public A withRouteSelector(LabelSelector routeSelector) {
    this._visitables.remove("routeSelector");
    if (routeSelector != null) {
        this.routeSelector = new LabelSelectorBuilder(routeSelector);
        this._visitables.get("routeSelector").add(this.routeSelector);
    } else {
        this.routeSelector = null;
        this._visitables.get("routeSelector").remove(this.routeSelector);
    }
    return (A) this;
  }
  
  public A withServingCertificate(String servingCertificate) {
    this.servingCertificate = servingCertificate;
    return (A) this;
  }
  public class NamespaceSelectorNested<N> extends LabelSelectorFluent<NamespaceSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    NamespaceSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterIngressFluent.this.withNamespaceSelector(builder.build());
    }
    
    public N endNamespaceSelector() {
      return and();
    }
    
  }
  public class RouteSelectorNested<N> extends LabelSelectorFluent<RouteSelectorNested<N>> implements Nested<N>{
  
    LabelSelectorBuilder builder;
  
    RouteSelectorNested(LabelSelector item) {
      this.builder = new LabelSelectorBuilder(this, item);
    }
  
    public N and() {
      return (N) ClusterIngressFluent.this.withRouteSelector(builder.build());
    }
    
    public N endRouteSelector() {
      return and();
    }
    
  }
}