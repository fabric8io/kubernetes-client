package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
public class NetworkDataFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.NetworkDataFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private NetworkDataLinkBuilder links;
  private NetworkDataNetworkBuilder networks;
  private NetworkDataServiceBuilder services;

  public NetworkDataFluent() {
  }
  
  public NetworkDataFluent(NetworkData instance) {
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
  
  public NetworkDataLink buildLinks() {
    return this.links != null ? this.links.build() : null;
  }
  
  public NetworkDataNetwork buildNetworks() {
    return this.networks != null ? this.networks.build() : null;
  }
  
  public NetworkDataService buildServices() {
    return this.services != null ? this.services.build() : null;
  }
  
  protected void copyInstance(NetworkData instance) {
    instance = instance != null ? instance : new NetworkData();
    if (instance != null) {
        this.withLinks(instance.getLinks());
        this.withNetworks(instance.getNetworks());
        this.withServices(instance.getServices());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public LinksNested<A> editLinks() {
    return this.withNewLinksLike(Optional.ofNullable(this.buildLinks()).orElse(null));
  }
  
  public NetworksNested<A> editNetworks() {
    return this.withNewNetworksLike(Optional.ofNullable(this.buildNetworks()).orElse(null));
  }
  
  public LinksNested<A> editOrNewLinks() {
    return this.withNewLinksLike(Optional.ofNullable(this.buildLinks()).orElse(new NetworkDataLinkBuilder().build()));
  }
  
  public LinksNested<A> editOrNewLinksLike(NetworkDataLink item) {
    return this.withNewLinksLike(Optional.ofNullable(this.buildLinks()).orElse(item));
  }
  
  public NetworksNested<A> editOrNewNetworks() {
    return this.withNewNetworksLike(Optional.ofNullable(this.buildNetworks()).orElse(new NetworkDataNetworkBuilder().build()));
  }
  
  public NetworksNested<A> editOrNewNetworksLike(NetworkDataNetwork item) {
    return this.withNewNetworksLike(Optional.ofNullable(this.buildNetworks()).orElse(item));
  }
  
  public ServicesNested<A> editOrNewServices() {
    return this.withNewServicesLike(Optional.ofNullable(this.buildServices()).orElse(new NetworkDataServiceBuilder().build()));
  }
  
  public ServicesNested<A> editOrNewServicesLike(NetworkDataService item) {
    return this.withNewServicesLike(Optional.ofNullable(this.buildServices()).orElse(item));
  }
  
  public ServicesNested<A> editServices() {
    return this.withNewServicesLike(Optional.ofNullable(this.buildServices()).orElse(null));
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
    NetworkDataFluent that = (NetworkDataFluent) o;
    if (!(Objects.equals(links, that.links))) {
      return false;
    }
    if (!(Objects.equals(networks, that.networks))) {
      return false;
    }
    if (!(Objects.equals(services, that.services))) {
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
  
  public boolean hasLinks() {
    return this.links != null;
  }
  
  public boolean hasNetworks() {
    return this.networks != null;
  }
  
  public boolean hasServices() {
    return this.services != null;
  }
  
  public int hashCode() {
    return Objects.hash(links, networks, services, additionalProperties);
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
    if (!(links == null)) {
        sb.append("links:");
        sb.append(links);
        sb.append(",");
    }
    if (!(networks == null)) {
        sb.append("networks:");
        sb.append(networks);
        sb.append(",");
    }
    if (!(services == null)) {
        sb.append("services:");
        sb.append(services);
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
  
  public A withLinks(NetworkDataLink links) {
    this._visitables.remove("links");
    if (links != null) {
        this.links = new NetworkDataLinkBuilder(links);
        this._visitables.get("links").add(this.links);
    } else {
        this.links = null;
        this._visitables.get("links").remove(this.links);
    }
    return (A) this;
  }
  
  public A withNetworks(NetworkDataNetwork networks) {
    this._visitables.remove("networks");
    if (networks != null) {
        this.networks = new NetworkDataNetworkBuilder(networks);
        this._visitables.get("networks").add(this.networks);
    } else {
        this.networks = null;
        this._visitables.get("networks").remove(this.networks);
    }
    return (A) this;
  }
  
  public LinksNested<A> withNewLinks() {
    return new LinksNested(null);
  }
  
  public LinksNested<A> withNewLinksLike(NetworkDataLink item) {
    return new LinksNested(item);
  }
  
  public NetworksNested<A> withNewNetworks() {
    return new NetworksNested(null);
  }
  
  public NetworksNested<A> withNewNetworksLike(NetworkDataNetwork item) {
    return new NetworksNested(item);
  }
  
  public ServicesNested<A> withNewServices() {
    return new ServicesNested(null);
  }
  
  public ServicesNested<A> withNewServicesLike(NetworkDataService item) {
    return new ServicesNested(item);
  }
  
  public A withServices(NetworkDataService services) {
    this._visitables.remove("services");
    if (services != null) {
        this.services = new NetworkDataServiceBuilder(services);
        this._visitables.get("services").add(this.services);
    } else {
        this.services = null;
        this._visitables.get("services").remove(this.services);
    }
    return (A) this;
  }
  public class LinksNested<N> extends NetworkDataLinkFluent<LinksNested<N>> implements Nested<N>{
  
    NetworkDataLinkBuilder builder;
  
    LinksNested(NetworkDataLink item) {
      this.builder = new NetworkDataLinkBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataFluent.this.withLinks(builder.build());
    }
    
    public N endLinks() {
      return and();
    }
    
  }
  public class NetworksNested<N> extends NetworkDataNetworkFluent<NetworksNested<N>> implements Nested<N>{
  
    NetworkDataNetworkBuilder builder;
  
    NetworksNested(NetworkDataNetwork item) {
      this.builder = new NetworkDataNetworkBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataFluent.this.withNetworks(builder.build());
    }
    
    public N endNetworks() {
      return and();
    }
    
  }
  public class ServicesNested<N> extends NetworkDataServiceFluent<ServicesNested<N>> implements Nested<N>{
  
    NetworkDataServiceBuilder builder;
  
    ServicesNested(NetworkDataService item) {
      this.builder = new NetworkDataServiceBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataFluent.this.withServices(builder.build());
    }
    
    public N endServices() {
      return and();
    }
    
  }
}