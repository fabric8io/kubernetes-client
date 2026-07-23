package io.fabric8.istio.api.api.networking.v1alpha3;

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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class GatewayFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.GatewayFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Map<String,String> selector;
  private ArrayList<ServerBuilder> servers = new ArrayList<ServerBuilder>();

  public GatewayFluent() {
  }
  
  public GatewayFluent(Gateway instance) {
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
  
  public A addToSelector(Map<String,String> map) {
    if (this.selector == null && map != null) {
      this.selector = new LinkedHashMap();
    }
    if (map != null) {
      this.selector.putAll(map);
    }
    return (A) this;
  }
  
  public A addToSelector(String key,String value) {
    if (this.selector == null && key != null && value != null) {
      this.selector = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.selector.put(key, value);
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
  
  public Server buildServer(int index) {
    return this.servers.get(index).build();
  }
  
  public List<Server> buildServers() {
    return this.servers != null ? build(servers) : null;
  }
  
  protected void copyInstance(Gateway instance) {
    instance = instance != null ? instance : new Gateway();
    if (instance != null) {
        this.withSelector(instance.getSelector());
        this.withServers(instance.getServers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
  
  public ServersNested<A> editServer(int index) {
    if (servers.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "servers"));
    }
    return this.setNewServerLike(index, this.buildServer(index));
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
    GatewayFluent that = (GatewayFluent) o;
    if (!(Objects.equals(selector, that.selector))) {
      return false;
    }
    if (!(Objects.equals(servers, that.servers))) {
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
  
  public Map<String,String> getSelector() {
    return this.selector;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingServer(Predicate<ServerBuilder> predicate) {
      for (ServerBuilder item : servers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasSelector() {
    return this.selector != null;
  }
  
  public boolean hasServers() {
    return this.servers != null && !(this.servers.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(selector, servers, additionalProperties);
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
  
  public A removeFromSelector(String key) {
    if (this.selector == null) {
      return (A) this;
    }
    if (key != null && this.selector != null) {
      this.selector.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromSelector(Map<String,String> map) {
    if (this.selector == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.selector != null) {
          this.selector.remove(key);
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
    if (!(selector == null) && !(selector.isEmpty())) {
        sb.append("selector:");
        sb.append(selector);
        sb.append(",");
    }
    if (!(servers == null) && !(servers.isEmpty())) {
        sb.append("servers:");
        sb.append(servers);
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
  
  public <K,V>A withSelector(Map<String,String> selector) {
    if (selector == null) {
      this.selector = null;
    } else {
      this.selector = new LinkedHashMap(selector);
    }
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
  public class ServersNested<N> extends ServerFluent<ServersNested<N>> implements Nested<N>{
  
    ServerBuilder builder;
    int index;
  
    ServersNested(int index,Server item) {
      this.index = index;
      this.builder = new ServerBuilder(this, item);
    }
  
    public N and() {
      return (N) GatewayFluent.this.setToServers(index, builder.build());
    }
    
    public N endServer() {
      return and();
    }
    
  }
}