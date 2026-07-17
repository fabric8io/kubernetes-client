package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class DNSSpecFluent<A extends io.fabric8.openshift.api.model.operator.v1.DNSSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private DNSCacheBuilder cache;
  private String logLevel;
  private String managementState;
  private DNSNodePlacementBuilder nodePlacement;
  private String operatorLogLevel;
  private ArrayList<ServerBuilder> servers = new ArrayList<ServerBuilder>();
  private UpstreamResolversBuilder upstreamResolvers;

  public DNSSpecFluent() {
  }
  
  public DNSSpecFluent(DNSSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToServers(Collection<Server> items) {
    if (this.servers == null) {
      this.servers = new ArrayList();
    }
    for (Server item : items) {
        ServerBuilder builder = new ServerBuilder(item);
        _visitables.get("servers").add(builder);
        this.servers.add(builder);
    }
    return (A) this;
  }
  
  public ServersNested<A> addNewServer() {
    return new ServersNested(-1, null);
  }
  
  public ServersNested<A> addNewServerLike(Server item) {
    return new ServersNested(-1, item);
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
  
  public A addToServers(Server... items) {
    if (this.servers == null) {
      this.servers = new ArrayList();
    }
    for (Server item : items) {
        ServerBuilder builder = new ServerBuilder(item);
        _visitables.get("servers").add(builder);
        this.servers.add(builder);
    }
    return (A) this;
  }
  
  public A addToServers(int index,Server item) {
    if (this.servers == null) {
      this.servers = new ArrayList();
    }
    ServerBuilder builder = new ServerBuilder(item);
    if (index < 0 || index >= servers.size()) {
        _visitables.get("servers").add(builder);
        servers.add(builder);
    } else {
        _visitables.get("servers").add(builder);
        servers.add(index, builder);
    }
    return (A) this;
  }
  
  public DNSCache buildCache() {
    return this.cache != null ? this.cache.build() : null;
  }
  
  public Server buildFirstServer() {
    return this.servers.get(0).build();
  }
  
  public Server buildLastServer() {
    return this.servers.get(servers.size() - 1).build();
  }
  
  public Server buildMatchingServer(Predicate<ServerBuilder> predicate) {
      for (ServerBuilder item : servers) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public DNSNodePlacement buildNodePlacement() {
    return this.nodePlacement != null ? this.nodePlacement.build() : null;
  }
  
  public Server buildServer(int index) {
    return this.servers.get(index).build();
  }
  
  public List<Server> buildServers() {
    return this.servers != null ? build(servers) : null;
  }
  
  public UpstreamResolvers buildUpstreamResolvers() {
    return this.upstreamResolvers != null ? this.upstreamResolvers.build() : null;
  }
  
  protected void copyInstance(DNSSpec instance) {
    instance = instance != null ? instance : new DNSSpec();
    if (instance != null) {
        this.withCache(instance.getCache());
        this.withLogLevel(instance.getLogLevel());
        this.withManagementState(instance.getManagementState());
        this.withNodePlacement(instance.getNodePlacement());
        this.withOperatorLogLevel(instance.getOperatorLogLevel());
        this.withServers(instance.getServers());
        this.withUpstreamResolvers(instance.getUpstreamResolvers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CacheNested<A> editCache() {
    return this.withNewCacheLike(Optional.ofNullable(this.buildCache()).orElse(null));
  }
  
  public ServersNested<A> editFirstServer() {
    if (servers.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "servers"));
    }
    return this.setNewServerLike(0, this.buildServer(0));
  }
  
  public ServersNested<A> editLastServer() {
    int index = servers.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "servers"));
    }
    return this.setNewServerLike(index, this.buildServer(index));
  }
  
  public ServersNested<A> editMatchingServer(Predicate<ServerBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < servers.size();i++) {
      if (predicate.test(servers.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "servers"));
    }
    return this.setNewServerLike(index, this.buildServer(index));
  }
  
  public NodePlacementNested<A> editNodePlacement() {
    return this.withNewNodePlacementLike(Optional.ofNullable(this.buildNodePlacement()).orElse(null));
  }
  
  public CacheNested<A> editOrNewCache() {
    return this.withNewCacheLike(Optional.ofNullable(this.buildCache()).orElse(new DNSCacheBuilder().build()));
  }
  
  public CacheNested<A> editOrNewCacheLike(DNSCache item) {
    return this.withNewCacheLike(Optional.ofNullable(this.buildCache()).orElse(item));
  }
  
  public NodePlacementNested<A> editOrNewNodePlacement() {
    return this.withNewNodePlacementLike(Optional.ofNullable(this.buildNodePlacement()).orElse(new DNSNodePlacementBuilder().build()));
  }
  
  public NodePlacementNested<A> editOrNewNodePlacementLike(DNSNodePlacement item) {
    return this.withNewNodePlacementLike(Optional.ofNullable(this.buildNodePlacement()).orElse(item));
  }
  
  public UpstreamResolversNested<A> editOrNewUpstreamResolvers() {
    return this.withNewUpstreamResolversLike(Optional.ofNullable(this.buildUpstreamResolvers()).orElse(new UpstreamResolversBuilder().build()));
  }
  
  public UpstreamResolversNested<A> editOrNewUpstreamResolversLike(UpstreamResolvers item) {
    return this.withNewUpstreamResolversLike(Optional.ofNullable(this.buildUpstreamResolvers()).orElse(item));
  }
  
  public ServersNested<A> editServer(int index) {
    if (servers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "servers"));
    }
    return this.setNewServerLike(index, this.buildServer(index));
  }
  
  public UpstreamResolversNested<A> editUpstreamResolvers() {
    return this.withNewUpstreamResolversLike(Optional.ofNullable(this.buildUpstreamResolvers()).orElse(null));
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
    DNSSpecFluent that = (DNSSpecFluent) o;
    if (!(Objects.equals(cache, that.cache))) {
      return false;
    }
    if (!(Objects.equals(logLevel, that.logLevel))) {
      return false;
    }
    if (!(Objects.equals(managementState, that.managementState))) {
      return false;
    }
    if (!(Objects.equals(nodePlacement, that.nodePlacement))) {
      return false;
    }
    if (!(Objects.equals(operatorLogLevel, that.operatorLogLevel))) {
      return false;
    }
    if (!(Objects.equals(servers, that.servers))) {
      return false;
    }
    if (!(Objects.equals(upstreamResolvers, that.upstreamResolvers))) {
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
  
  public String getLogLevel() {
    return this.logLevel;
  }
  
  public String getManagementState() {
    return this.managementState;
  }
  
  public String getOperatorLogLevel() {
    return this.operatorLogLevel;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCache() {
    return this.cache != null;
  }
  
  public boolean hasLogLevel() {
    return this.logLevel != null;
  }
  
  public boolean hasManagementState() {
    return this.managementState != null;
  }
  
  public boolean hasMatchingServer(Predicate<ServerBuilder> predicate) {
      for (ServerBuilder item : servers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNodePlacement() {
    return this.nodePlacement != null;
  }
  
  public boolean hasOperatorLogLevel() {
    return this.operatorLogLevel != null;
  }
  
  public boolean hasServers() {
    return this.servers != null && !(this.servers.isEmpty());
  }
  
  public boolean hasUpstreamResolvers() {
    return this.upstreamResolvers != null;
  }
  
  public int hashCode() {
    return Objects.hash(cache, logLevel, managementState, nodePlacement, operatorLogLevel, servers, upstreamResolvers, additionalProperties);
  }
  
  public A removeAllFromServers(Collection<Server> items) {
    if (this.servers == null) {
      return (A) this;
    }
    for (Server item : items) {
        ServerBuilder builder = new ServerBuilder(item);
        _visitables.get("servers").remove(builder);
        this.servers.remove(builder);
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
  
  public A removeFromServers(Server... items) {
    if (this.servers == null) {
      return (A) this;
    }
    for (Server item : items) {
        ServerBuilder builder = new ServerBuilder(item);
        _visitables.get("servers").remove(builder);
        this.servers.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromServers(Predicate<ServerBuilder> predicate) {
    if (servers == null) {
      return (A) this;
    }
    Iterator<ServerBuilder> each = servers.iterator();
    List visitables = _visitables.get("servers");
    while (each.hasNext()) {
        ServerBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ServersNested<A> setNewServerLike(int index,Server item) {
    return new ServersNested(index, item);
  }
  
  public A setToServers(int index,Server item) {
    if (this.servers == null) {
      this.servers = new ArrayList();
    }
    ServerBuilder builder = new ServerBuilder(item);
    if (index < 0 || index >= servers.size()) {
        _visitables.get("servers").add(builder);
        servers.add(builder);
    } else {
        _visitables.get("servers").add(builder);
        servers.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cache == null)) {
        sb.append("cache:");
        sb.append(cache);
        sb.append(",");
    }
    if (!(logLevel == null)) {
        sb.append("logLevel:");
        sb.append(logLevel);
        sb.append(",");
    }
    if (!(managementState == null)) {
        sb.append("managementState:");
        sb.append(managementState);
        sb.append(",");
    }
    if (!(nodePlacement == null)) {
        sb.append("nodePlacement:");
        sb.append(nodePlacement);
        sb.append(",");
    }
    if (!(operatorLogLevel == null)) {
        sb.append("operatorLogLevel:");
        sb.append(operatorLogLevel);
        sb.append(",");
    }
    if (!(servers == null) && !(servers.isEmpty())) {
        sb.append("servers:");
        sb.append(servers);
        sb.append(",");
    }
    if (!(upstreamResolvers == null)) {
        sb.append("upstreamResolvers:");
        sb.append(upstreamResolvers);
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
  
  public A withCache(DNSCache cache) {
    this._visitables.remove("cache");
    if (cache != null) {
        this.cache = new DNSCacheBuilder(cache);
        this._visitables.get("cache").add(this.cache);
    } else {
        this.cache = null;
        this._visitables.get("cache").remove(this.cache);
    }
    return (A) this;
  }
  
  public A withLogLevel(String logLevel) {
    this.logLevel = logLevel;
    return (A) this;
  }
  
  public A withManagementState(String managementState) {
    this.managementState = managementState;
    return (A) this;
  }
  
  public CacheNested<A> withNewCache() {
    return new CacheNested(null);
  }
  
  public A withNewCache(String negativeTTL,String positiveTTL) {
    return (A) this.withCache(new DNSCache(negativeTTL, positiveTTL));
  }
  
  public CacheNested<A> withNewCacheLike(DNSCache item) {
    return new CacheNested(item);
  }
  
  public NodePlacementNested<A> withNewNodePlacement() {
    return new NodePlacementNested(null);
  }
  
  public NodePlacementNested<A> withNewNodePlacementLike(DNSNodePlacement item) {
    return new NodePlacementNested(item);
  }
  
  public UpstreamResolversNested<A> withNewUpstreamResolvers() {
    return new UpstreamResolversNested(null);
  }
  
  public UpstreamResolversNested<A> withNewUpstreamResolversLike(UpstreamResolvers item) {
    return new UpstreamResolversNested(item);
  }
  
  public A withNodePlacement(DNSNodePlacement nodePlacement) {
    this._visitables.remove("nodePlacement");
    if (nodePlacement != null) {
        this.nodePlacement = new DNSNodePlacementBuilder(nodePlacement);
        this._visitables.get("nodePlacement").add(this.nodePlacement);
    } else {
        this.nodePlacement = null;
        this._visitables.get("nodePlacement").remove(this.nodePlacement);
    }
    return (A) this;
  }
  
  public A withOperatorLogLevel(String operatorLogLevel) {
    this.operatorLogLevel = operatorLogLevel;
    return (A) this;
  }
  
  public A withServers(List<Server> servers) {
    if (this.servers != null) {
      this._visitables.get("servers").clear();
    }
    if (servers != null) {
        this.servers = new ArrayList();
        for (Server item : servers) {
          this.addToServers(item);
        }
    } else {
      this.servers = null;
    }
    return (A) this;
  }
  
  public A withServers(Server... servers) {
    if (this.servers != null) {
        this.servers.clear();
        _visitables.remove("servers");
    }
    if (servers != null) {
      for (Server item : servers) {
        this.addToServers(item);
      }
    }
    return (A) this;
  }
  
  public A withUpstreamResolvers(UpstreamResolvers upstreamResolvers) {
    this._visitables.remove("upstreamResolvers");
    if (upstreamResolvers != null) {
        this.upstreamResolvers = new UpstreamResolversBuilder(upstreamResolvers);
        this._visitables.get("upstreamResolvers").add(this.upstreamResolvers);
    } else {
        this.upstreamResolvers = null;
        this._visitables.get("upstreamResolvers").remove(this.upstreamResolvers);
    }
    return (A) this;
  }
  public class CacheNested<N> extends DNSCacheFluent<CacheNested<N>> implements Nested<N>{
  
    DNSCacheBuilder builder;
  
    CacheNested(DNSCache item) {
      this.builder = new DNSCacheBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSSpecFluent.this.withCache(builder.build());
    }
    
    public N endCache() {
      return and();
    }
    
  }
  public class NodePlacementNested<N> extends DNSNodePlacementFluent<NodePlacementNested<N>> implements Nested<N>{
  
    DNSNodePlacementBuilder builder;
  
    NodePlacementNested(DNSNodePlacement item) {
      this.builder = new DNSNodePlacementBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSSpecFluent.this.withNodePlacement(builder.build());
    }
    
    public N endNodePlacement() {
      return and();
    }
    
  }
  public class ServersNested<N> extends ServerFluent<ServersNested<N>> implements Nested<N>{
  
    ServerBuilder builder;
    int index;
  
    ServersNested(int index,Server item) {
      this.index = index;
      this.builder = new ServerBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSSpecFluent.this.setToServers(index, builder.build());
    }
    
    public N endServer() {
      return and();
    }
    
  }
  public class UpstreamResolversNested<N> extends UpstreamResolversFluent<UpstreamResolversNested<N>> implements Nested<N>{
  
    UpstreamResolversBuilder builder;
  
    UpstreamResolversNested(UpstreamResolvers item) {
      this.builder = new UpstreamResolversBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSSpecFluent.this.withUpstreamResolvers(builder.build());
    }
    
    public N endUpstreamResolvers() {
      return and();
    }
    
  }
}