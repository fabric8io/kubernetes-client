package io.fabric8.kubernetes.api.model.discovery.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.fabric8.kubernetes.api.model.ObjectMetaFluent;
import java.lang.Integer;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class EndpointSliceFluent<A extends io.fabric8.kubernetes.api.model.discovery.v1beta1.EndpointSliceFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String addressType;
  private String apiVersion;
  private ArrayList<EndpointBuilder> endpoints = new ArrayList<EndpointBuilder>();
  private String kind;
  private ObjectMetaBuilder metadata;
  private ArrayList<EndpointPortBuilder> ports = new ArrayList<EndpointPortBuilder>();

  public EndpointSliceFluent() {
  }
  
  public EndpointSliceFluent(EndpointSlice instance) {
    this.copyInstance(instance);
  }

  public A addAllToEndpoints(Collection<Endpoint> items) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList();
    }
    for (Endpoint item : items) {
        EndpointBuilder builder = new EndpointBuilder(item);
        _visitables.get("endpoints").add(builder);
        this.endpoints.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToPorts(Collection<EndpointPort> items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (EndpointPort item : items) {
        EndpointPortBuilder builder = new EndpointPortBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public EndpointsNested<A> addNewEndpoint() {
    return new EndpointsNested(-1, null);
  }
  
  public EndpointsNested<A> addNewEndpointLike(Endpoint item) {
    return new EndpointsNested(-1, item);
  }
  
  public PortsNested<A> addNewPort() {
    return new PortsNested(-1, null);
  }
  
  public A addNewPort(String appProtocol,String name,Integer port,String protocol) {
    return (A) this.addToPorts(new EndpointPort(appProtocol, name, port, protocol));
  }
  
  public PortsNested<A> addNewPortLike(EndpointPort item) {
    return new PortsNested(-1, item);
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
  
  public A addToEndpoints(Endpoint... items) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList();
    }
    for (Endpoint item : items) {
        EndpointBuilder builder = new EndpointBuilder(item);
        _visitables.get("endpoints").add(builder);
        this.endpoints.add(builder);
    }
    return (A) this;
  }
  
  public A addToEndpoints(int index,Endpoint item) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList();
    }
    EndpointBuilder builder = new EndpointBuilder(item);
    if (index < 0 || index >= endpoints.size()) {
        _visitables.get("endpoints").add(builder);
        endpoints.add(builder);
    } else {
        _visitables.get("endpoints").add(builder);
        endpoints.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToPorts(EndpointPort... items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (EndpointPort item : items) {
        EndpointPortBuilder builder = new EndpointPortBuilder(item);
        _visitables.get("ports").add(builder);
        this.ports.add(builder);
    }
    return (A) this;
  }
  
  public A addToPorts(int index,EndpointPort item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    EndpointPortBuilder builder = new EndpointPortBuilder(item);
    if (index < 0 || index >= ports.size()) {
        _visitables.get("ports").add(builder);
        ports.add(builder);
    } else {
        _visitables.get("ports").add(builder);
        ports.add(index, builder);
    }
    return (A) this;
  }
  
  public Endpoint buildEndpoint(int index) {
    return this.endpoints.get(index).build();
  }
  
  public List<Endpoint> buildEndpoints() {
    return this.endpoints != null ? build(endpoints) : null;
  }
  
  public Endpoint buildFirstEndpoint() {
    return this.endpoints.get(0).build();
  }
  
  public EndpointPort buildFirstPort() {
    return this.ports.get(0).build();
  }
  
  public Endpoint buildLastEndpoint() {
    return this.endpoints.get(endpoints.size() - 1).build();
  }
  
  public EndpointPort buildLastPort() {
    return this.ports.get(ports.size() - 1).build();
  }
  
  public Endpoint buildMatchingEndpoint(Predicate<EndpointBuilder> predicate) {
      for (EndpointBuilder item : endpoints) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public EndpointPort buildMatchingPort(Predicate<EndpointPortBuilder> predicate) {
      for (EndpointPortBuilder item : ports) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ObjectMeta buildMetadata() {
    return this.metadata != null ? this.metadata.build() : null;
  }
  
  public EndpointPort buildPort(int index) {
    return this.ports.get(index).build();
  }
  
  public List<EndpointPort> buildPorts() {
    return this.ports != null ? build(ports) : null;
  }
  
  protected void copyInstance(EndpointSlice instance) {
    instance = instance != null ? instance : new EndpointSlice();
    if (instance != null) {
        this.withAddressType(instance.getAddressType());
        this.withApiVersion(instance.getApiVersion());
        this.withEndpoints(instance.getEndpoints());
        this.withKind(instance.getKind());
        this.withMetadata(instance.getMetadata());
        this.withPorts(instance.getPorts());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EndpointsNested<A> editEndpoint(int index) {
    if (endpoints.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "endpoints"));
    }
    return this.setNewEndpointLike(index, this.buildEndpoint(index));
  }
  
  public EndpointsNested<A> editFirstEndpoint() {
    if (endpoints.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "endpoints"));
    }
    return this.setNewEndpointLike(0, this.buildEndpoint(0));
  }
  
  public PortsNested<A> editFirstPort() {
    if (ports.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(0, this.buildPort(0));
  }
  
  public EndpointsNested<A> editLastEndpoint() {
    int index = endpoints.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "endpoints"));
    }
    return this.setNewEndpointLike(index, this.buildEndpoint(index));
  }
  
  public PortsNested<A> editLastPort() {
    int index = ports.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public EndpointsNested<A> editMatchingEndpoint(Predicate<EndpointBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < endpoints.size();i++) {
      if (predicate.test(endpoints.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "endpoints"));
    }
    return this.setNewEndpointLike(index, this.buildEndpoint(index));
  }
  
  public PortsNested<A> editMatchingPort(Predicate<EndpointPortBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < ports.size();i++) {
      if (predicate.test(ports.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
  }
  
  public MetadataNested<A> editMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(null));
  }
  
  public MetadataNested<A> editOrNewMetadata() {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(new ObjectMetaBuilder().build()));
  }
  
  public MetadataNested<A> editOrNewMetadataLike(ObjectMeta item) {
    return this.withNewMetadataLike(Optional.ofNullable(this.buildMetadata()).orElse(item));
  }
  
  public PortsNested<A> editPort(int index) {
    if (ports.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "ports"));
    }
    return this.setNewPortLike(index, this.buildPort(index));
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
    EndpointSliceFluent that = (EndpointSliceFluent) o;
    if (!(Objects.equals(addressType, that.addressType))) {
      return false;
    }
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(endpoints, that.endpoints))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(metadata, that.metadata))) {
      return false;
    }
    if (!(Objects.equals(ports, that.ports))) {
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
  
  public String getAddressType() {
    return this.addressType;
  }
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAddressType() {
    return this.addressType != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasEndpoints() {
    return this.endpoints != null && !(this.endpoints.isEmpty());
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingEndpoint(Predicate<EndpointBuilder> predicate) {
      for (EndpointBuilder item : endpoints) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPort(Predicate<EndpointPortBuilder> predicate) {
      for (EndpointPortBuilder item : ports) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMetadata() {
    return this.metadata != null;
  }
  
  public boolean hasPorts() {
    return this.ports != null && !(this.ports.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(addressType, apiVersion, endpoints, kind, metadata, ports, additionalProperties);
  }
  
  public A removeAllFromEndpoints(Collection<Endpoint> items) {
    if (this.endpoints == null) {
      return (A) this;
    }
    for (Endpoint item : items) {
        EndpointBuilder builder = new EndpointBuilder(item);
        _visitables.get("endpoints").remove(builder);
        this.endpoints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromPorts(Collection<EndpointPort> items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (EndpointPort item : items) {
        EndpointPortBuilder builder = new EndpointPortBuilder(item);
        _visitables.get("ports").remove(builder);
        this.ports.remove(builder);
    }
    return (A) this;
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
  
  public A removeFromEndpoints(Endpoint... items) {
    if (this.endpoints == null) {
      return (A) this;
    }
    for (Endpoint item : items) {
        EndpointBuilder builder = new EndpointBuilder(item);
        _visitables.get("endpoints").remove(builder);
        this.endpoints.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromPorts(EndpointPort... items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (EndpointPort item : items) {
        EndpointPortBuilder builder = new EndpointPortBuilder(item);
        _visitables.get("ports").remove(builder);
        this.ports.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEndpoints(Predicate<EndpointBuilder> predicate) {
    if (endpoints == null) {
      return (A) this;
    }
    Iterator<EndpointBuilder> each = endpoints.iterator();
    List visitables = _visitables.get("endpoints");
    while (each.hasNext()) {
        EndpointBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromPorts(Predicate<EndpointPortBuilder> predicate) {
    if (ports == null) {
      return (A) this;
    }
    Iterator<EndpointPortBuilder> each = ports.iterator();
    List visitables = _visitables.get("ports");
    while (each.hasNext()) {
        EndpointPortBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EndpointsNested<A> setNewEndpointLike(int index,Endpoint item) {
    return new EndpointsNested(index, item);
  }
  
  public PortsNested<A> setNewPortLike(int index,EndpointPort item) {
    return new PortsNested(index, item);
  }
  
  public A setToEndpoints(int index,Endpoint item) {
    if (this.endpoints == null) {
      this.endpoints = new ArrayList();
    }
    EndpointBuilder builder = new EndpointBuilder(item);
    if (index < 0 || index >= endpoints.size()) {
        _visitables.get("endpoints").add(builder);
        endpoints.add(builder);
    } else {
        _visitables.get("endpoints").add(builder);
        endpoints.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToPorts(int index,EndpointPort item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    EndpointPortBuilder builder = new EndpointPortBuilder(item);
    if (index < 0 || index >= ports.size()) {
        _visitables.get("ports").add(builder);
        ports.add(builder);
    } else {
        _visitables.get("ports").add(builder);
        ports.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(addressType == null)) {
        sb.append("addressType:");
        sb.append(addressType);
        sb.append(",");
    }
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(endpoints == null) && !(endpoints.isEmpty())) {
        sb.append("endpoints:");
        sb.append(endpoints);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(metadata == null)) {
        sb.append("metadata:");
        sb.append(metadata);
        sb.append(",");
    }
    if (!(ports == null) && !(ports.isEmpty())) {
        sb.append("ports:");
        sb.append(ports);
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
  
  public A withAddressType(String addressType) {
    this.addressType = addressType;
    return (A) this;
  }
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withEndpoints(List<Endpoint> endpoints) {
    if (this.endpoints != null) {
      this._visitables.get("endpoints").clear();
    }
    if (endpoints != null) {
        this.endpoints = new ArrayList();
        for (Endpoint item : endpoints) {
          this.addToEndpoints(item);
        }
    } else {
      this.endpoints = null;
    }
    return (A) this;
  }
  
  public A withEndpoints(Endpoint... endpoints) {
    if (this.endpoints != null) {
        this.endpoints.clear();
        _visitables.remove("endpoints");
    }
    if (endpoints != null) {
      for (Endpoint item : endpoints) {
        this.addToEndpoints(item);
      }
    }
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withMetadata(ObjectMeta metadata) {
    this._visitables.remove("metadata");
    if (metadata != null) {
        this.metadata = new ObjectMetaBuilder(metadata);
        this._visitables.get("metadata").add(this.metadata);
    } else {
        this.metadata = null;
        this._visitables.get("metadata").remove(this.metadata);
    }
    return (A) this;
  }
  
  public MetadataNested<A> withNewMetadata() {
    return new MetadataNested(null);
  }
  
  public MetadataNested<A> withNewMetadataLike(ObjectMeta item) {
    return new MetadataNested(item);
  }
  
  public A withPorts(List<EndpointPort> ports) {
    if (this.ports != null) {
      this._visitables.get("ports").clear();
    }
    if (ports != null) {
        this.ports = new ArrayList();
        for (EndpointPort item : ports) {
          this.addToPorts(item);
        }
    } else {
      this.ports = null;
    }
    return (A) this;
  }
  
  public A withPorts(EndpointPort... ports) {
    if (this.ports != null) {
        this.ports.clear();
        _visitables.remove("ports");
    }
    if (ports != null) {
      for (EndpointPort item : ports) {
        this.addToPorts(item);
      }
    }
    return (A) this;
  }
  public class EndpointsNested<N> extends EndpointFluent<EndpointsNested<N>> implements Nested<N>{
  
    EndpointBuilder builder;
    int index;
  
    EndpointsNested(int index,Endpoint item) {
      this.index = index;
      this.builder = new EndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointSliceFluent.this.setToEndpoints(index, builder.build());
    }
    
    public N endEndpoint() {
      return and();
    }
    
  }
  public class MetadataNested<N> extends ObjectMetaFluent<MetadataNested<N>> implements Nested<N>{
  
    ObjectMetaBuilder builder;
  
    MetadataNested(ObjectMeta item) {
      this.builder = new ObjectMetaBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointSliceFluent.this.withMetadata(builder.build());
    }
    
    public N endMetadata() {
      return and();
    }
    
  }
  public class PortsNested<N> extends EndpointPortFluent<PortsNested<N>> implements Nested<N>{
  
    EndpointPortBuilder builder;
    int index;
  
    PortsNested(int index,EndpointPort item) {
      this.index = index;
      this.builder = new EndpointPortBuilder(this, item);
    }
  
    public N and() {
      return (N) EndpointSliceFluent.this.setToPorts(index, builder.build());
    }
    
    public N endPort() {
      return and();
    }
    
  }
}