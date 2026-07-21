package io.fabric8.istio.api.api.security.v1beta1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class OperationFluent<A extends io.fabric8.istio.api.api.security.v1beta1.OperationFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> hosts = new ArrayList<String>();
  private List<String> methods = new ArrayList<String>();
  private List<String> notHosts = new ArrayList<String>();
  private List<String> notMethods = new ArrayList<String>();
  private List<String> notPaths = new ArrayList<String>();
  private List<String> notPorts = new ArrayList<String>();
  private List<String> paths = new ArrayList<String>();
  private List<String> ports = new ArrayList<String>();

  public OperationFluent() {
  }
  
  public OperationFluent(Operation instance) {
    this.copyInstance(instance);
  }

  public A addAllToHosts(Collection<String> items) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    for (String item : items) {
      this.hosts.add(item);
    }
    return (A) this;
  }
  
  public A addAllToMethods(Collection<String> items) {
    if (this.methods == null) {
      this.methods = new ArrayList();
    }
    for (String item : items) {
      this.methods.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNotHosts(Collection<String> items) {
    if (this.notHosts == null) {
      this.notHosts = new ArrayList();
    }
    for (String item : items) {
      this.notHosts.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNotMethods(Collection<String> items) {
    if (this.notMethods == null) {
      this.notMethods = new ArrayList();
    }
    for (String item : items) {
      this.notMethods.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNotPaths(Collection<String> items) {
    if (this.notPaths == null) {
      this.notPaths = new ArrayList();
    }
    for (String item : items) {
      this.notPaths.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNotPorts(Collection<String> items) {
    if (this.notPorts == null) {
      this.notPorts = new ArrayList();
    }
    for (String item : items) {
      this.notPorts.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPaths(Collection<String> items) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    for (String item : items) {
      this.paths.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPorts(Collection<String> items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (String item : items) {
      this.ports.add(item);
    }
    return (A) this;
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
  
  public A addToHosts(String... items) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    for (String item : items) {
      this.hosts.add(item);
    }
    return (A) this;
  }
  
  public A addToHosts(int index,String item) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    this.hosts.add(index, item);
    return (A) this;
  }
  
  public A addToMethods(String... items) {
    if (this.methods == null) {
      this.methods = new ArrayList();
    }
    for (String item : items) {
      this.methods.add(item);
    }
    return (A) this;
  }
  
  public A addToMethods(int index,String item) {
    if (this.methods == null) {
      this.methods = new ArrayList();
    }
    this.methods.add(index, item);
    return (A) this;
  }
  
  public A addToNotHosts(String... items) {
    if (this.notHosts == null) {
      this.notHosts = new ArrayList();
    }
    for (String item : items) {
      this.notHosts.add(item);
    }
    return (A) this;
  }
  
  public A addToNotHosts(int index,String item) {
    if (this.notHosts == null) {
      this.notHosts = new ArrayList();
    }
    this.notHosts.add(index, item);
    return (A) this;
  }
  
  public A addToNotMethods(String... items) {
    if (this.notMethods == null) {
      this.notMethods = new ArrayList();
    }
    for (String item : items) {
      this.notMethods.add(item);
    }
    return (A) this;
  }
  
  public A addToNotMethods(int index,String item) {
    if (this.notMethods == null) {
      this.notMethods = new ArrayList();
    }
    this.notMethods.add(index, item);
    return (A) this;
  }
  
  public A addToNotPaths(String... items) {
    if (this.notPaths == null) {
      this.notPaths = new ArrayList();
    }
    for (String item : items) {
      this.notPaths.add(item);
    }
    return (A) this;
  }
  
  public A addToNotPaths(int index,String item) {
    if (this.notPaths == null) {
      this.notPaths = new ArrayList();
    }
    this.notPaths.add(index, item);
    return (A) this;
  }
  
  public A addToNotPorts(String... items) {
    if (this.notPorts == null) {
      this.notPorts = new ArrayList();
    }
    for (String item : items) {
      this.notPorts.add(item);
    }
    return (A) this;
  }
  
  public A addToNotPorts(int index,String item) {
    if (this.notPorts == null) {
      this.notPorts = new ArrayList();
    }
    this.notPorts.add(index, item);
    return (A) this;
  }
  
  public A addToPaths(String... items) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    for (String item : items) {
      this.paths.add(item);
    }
    return (A) this;
  }
  
  public A addToPaths(int index,String item) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    this.paths.add(index, item);
    return (A) this;
  }
  
  public A addToPorts(String... items) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    for (String item : items) {
      this.ports.add(item);
    }
    return (A) this;
  }
  
  public A addToPorts(int index,String item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    this.ports.add(index, item);
    return (A) this;
  }
  
  protected void copyInstance(Operation instance) {
    instance = instance != null ? instance : new Operation();
    if (instance != null) {
        this.withHosts(instance.getHosts());
        this.withMethods(instance.getMethods());
        this.withNotHosts(instance.getNotHosts());
        this.withNotMethods(instance.getNotMethods());
        this.withNotPaths(instance.getNotPaths());
        this.withNotPorts(instance.getNotPorts());
        this.withPaths(instance.getPaths());
        this.withPorts(instance.getPorts());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
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
    OperationFluent that = (OperationFluent) o;
    if (!(Objects.equals(hosts, that.hosts))) {
      return false;
    }
    if (!(Objects.equals(methods, that.methods))) {
      return false;
    }
    if (!(Objects.equals(notHosts, that.notHosts))) {
      return false;
    }
    if (!(Objects.equals(notMethods, that.notMethods))) {
      return false;
    }
    if (!(Objects.equals(notPaths, that.notPaths))) {
      return false;
    }
    if (!(Objects.equals(notPorts, that.notPorts))) {
      return false;
    }
    if (!(Objects.equals(paths, that.paths))) {
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
  
  public String getFirstHost() {
    return this.hosts.get(0);
  }
  
  public String getFirstMethod() {
    return this.methods.get(0);
  }
  
  public String getFirstNotHost() {
    return this.notHosts.get(0);
  }
  
  public String getFirstNotMethod() {
    return this.notMethods.get(0);
  }
  
  public String getFirstNotPath() {
    return this.notPaths.get(0);
  }
  
  public String getFirstNotPort() {
    return this.notPorts.get(0);
  }
  
  public String getFirstPath() {
    return this.paths.get(0);
  }
  
  public String getFirstPort() {
    return this.ports.get(0);
  }
  
  public String getHost(int index) {
    return this.hosts.get(index);
  }
  
  public List<String> getHosts() {
    return this.hosts;
  }
  
  public String getLastHost() {
    return this.hosts.get(hosts.size() - 1);
  }
  
  public String getLastMethod() {
    return this.methods.get(methods.size() - 1);
  }
  
  public String getLastNotHost() {
    return this.notHosts.get(notHosts.size() - 1);
  }
  
  public String getLastNotMethod() {
    return this.notMethods.get(notMethods.size() - 1);
  }
  
  public String getLastNotPath() {
    return this.notPaths.get(notPaths.size() - 1);
  }
  
  public String getLastNotPort() {
    return this.notPorts.get(notPorts.size() - 1);
  }
  
  public String getLastPath() {
    return this.paths.get(paths.size() - 1);
  }
  
  public String getLastPort() {
    return this.ports.get(ports.size() - 1);
  }
  
  public String getMatchingHost(Predicate<String> predicate) {
      for (String item : hosts) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingMethod(Predicate<String> predicate) {
      for (String item : methods) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNotHost(Predicate<String> predicate) {
      for (String item : notHosts) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNotMethod(Predicate<String> predicate) {
      for (String item : notMethods) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNotPath(Predicate<String> predicate) {
      for (String item : notPaths) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNotPort(Predicate<String> predicate) {
      for (String item : notPorts) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPath(Predicate<String> predicate) {
      for (String item : paths) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPort(Predicate<String> predicate) {
      for (String item : ports) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMethod(int index) {
    return this.methods.get(index);
  }
  
  public List<String> getMethods() {
    return this.methods;
  }
  
  public String getNotHost(int index) {
    return this.notHosts.get(index);
  }
  
  public List<String> getNotHosts() {
    return this.notHosts;
  }
  
  public String getNotMethod(int index) {
    return this.notMethods.get(index);
  }
  
  public List<String> getNotMethods() {
    return this.notMethods;
  }
  
  public String getNotPath(int index) {
    return this.notPaths.get(index);
  }
  
  public List<String> getNotPaths() {
    return this.notPaths;
  }
  
  public String getNotPort(int index) {
    return this.notPorts.get(index);
  }
  
  public List<String> getNotPorts() {
    return this.notPorts;
  }
  
  public String getPath(int index) {
    return this.paths.get(index);
  }
  
  public List<String> getPaths() {
    return this.paths;
  }
  
  public String getPort(int index) {
    return this.ports.get(index);
  }
  
  public List<String> getPorts() {
    return this.ports;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasHosts() {
    return this.hosts != null && !(this.hosts.isEmpty());
  }
  
  public boolean hasMatchingHost(Predicate<String> predicate) {
      for (String item : hosts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMethod(Predicate<String> predicate) {
      for (String item : methods) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNotHost(Predicate<String> predicate) {
      for (String item : notHosts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNotMethod(Predicate<String> predicate) {
      for (String item : notMethods) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNotPath(Predicate<String> predicate) {
      for (String item : notPaths) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNotPort(Predicate<String> predicate) {
      for (String item : notPorts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPath(Predicate<String> predicate) {
      for (String item : paths) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPort(Predicate<String> predicate) {
      for (String item : ports) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMethods() {
    return this.methods != null && !(this.methods.isEmpty());
  }
  
  public boolean hasNotHosts() {
    return this.notHosts != null && !(this.notHosts.isEmpty());
  }
  
  public boolean hasNotMethods() {
    return this.notMethods != null && !(this.notMethods.isEmpty());
  }
  
  public boolean hasNotPaths() {
    return this.notPaths != null && !(this.notPaths.isEmpty());
  }
  
  public boolean hasNotPorts() {
    return this.notPorts != null && !(this.notPorts.isEmpty());
  }
  
  public boolean hasPaths() {
    return this.paths != null && !(this.paths.isEmpty());
  }
  
  public boolean hasPorts() {
    return this.ports != null && !(this.ports.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(hosts, methods, notHosts, notMethods, notPaths, notPorts, paths, ports, additionalProperties);
  }
  
  public A removeAllFromHosts(Collection<String> items) {
    if (this.hosts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.hosts.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromMethods(Collection<String> items) {
    if (this.methods == null) {
      return (A) this;
    }
    for (String item : items) {
      this.methods.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNotHosts(Collection<String> items) {
    if (this.notHosts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notHosts.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNotMethods(Collection<String> items) {
    if (this.notMethods == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notMethods.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNotPaths(Collection<String> items) {
    if (this.notPaths == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notPaths.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNotPorts(Collection<String> items) {
    if (this.notPorts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notPorts.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPaths(Collection<String> items) {
    if (this.paths == null) {
      return (A) this;
    }
    for (String item : items) {
      this.paths.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPorts(Collection<String> items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ports.remove(item);
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
  
  public A removeFromHosts(String... items) {
    if (this.hosts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.hosts.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromMethods(String... items) {
    if (this.methods == null) {
      return (A) this;
    }
    for (String item : items) {
      this.methods.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNotHosts(String... items) {
    if (this.notHosts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notHosts.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNotMethods(String... items) {
    if (this.notMethods == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notMethods.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNotPaths(String... items) {
    if (this.notPaths == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notPaths.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromNotPorts(String... items) {
    if (this.notPorts == null) {
      return (A) this;
    }
    for (String item : items) {
      this.notPorts.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPaths(String... items) {
    if (this.paths == null) {
      return (A) this;
    }
    for (String item : items) {
      this.paths.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPorts(String... items) {
    if (this.ports == null) {
      return (A) this;
    }
    for (String item : items) {
      this.ports.remove(item);
    }
    return (A) this;
  }
  
  public A setToHosts(int index,String item) {
    if (this.hosts == null) {
      this.hosts = new ArrayList();
    }
    this.hosts.set(index, item);
    return (A) this;
  }
  
  public A setToMethods(int index,String item) {
    if (this.methods == null) {
      this.methods = new ArrayList();
    }
    this.methods.set(index, item);
    return (A) this;
  }
  
  public A setToNotHosts(int index,String item) {
    if (this.notHosts == null) {
      this.notHosts = new ArrayList();
    }
    this.notHosts.set(index, item);
    return (A) this;
  }
  
  public A setToNotMethods(int index,String item) {
    if (this.notMethods == null) {
      this.notMethods = new ArrayList();
    }
    this.notMethods.set(index, item);
    return (A) this;
  }
  
  public A setToNotPaths(int index,String item) {
    if (this.notPaths == null) {
      this.notPaths = new ArrayList();
    }
    this.notPaths.set(index, item);
    return (A) this;
  }
  
  public A setToNotPorts(int index,String item) {
    if (this.notPorts == null) {
      this.notPorts = new ArrayList();
    }
    this.notPorts.set(index, item);
    return (A) this;
  }
  
  public A setToPaths(int index,String item) {
    if (this.paths == null) {
      this.paths = new ArrayList();
    }
    this.paths.set(index, item);
    return (A) this;
  }
  
  public A setToPorts(int index,String item) {
    if (this.ports == null) {
      this.ports = new ArrayList();
    }
    this.ports.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(hosts == null) && !(hosts.isEmpty())) {
        sb.append("hosts:");
        sb.append(hosts);
        sb.append(",");
    }
    if (!(methods == null) && !(methods.isEmpty())) {
        sb.append("methods:");
        sb.append(methods);
        sb.append(",");
    }
    if (!(notHosts == null) && !(notHosts.isEmpty())) {
        sb.append("notHosts:");
        sb.append(notHosts);
        sb.append(",");
    }
    if (!(notMethods == null) && !(notMethods.isEmpty())) {
        sb.append("notMethods:");
        sb.append(notMethods);
        sb.append(",");
    }
    if (!(notPaths == null) && !(notPaths.isEmpty())) {
        sb.append("notPaths:");
        sb.append(notPaths);
        sb.append(",");
    }
    if (!(notPorts == null) && !(notPorts.isEmpty())) {
        sb.append("notPorts:");
        sb.append(notPorts);
        sb.append(",");
    }
    if (!(paths == null) && !(paths.isEmpty())) {
        sb.append("paths:");
        sb.append(paths);
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
  
  public A withHosts(List<String> hosts) {
    if (hosts != null) {
        this.hosts = new ArrayList();
        for (String item : hosts) {
          this.addToHosts(item);
        }
    } else {
      this.hosts = null;
    }
    return (A) this;
  }
  
  public A withHosts(String... hosts) {
    if (this.hosts != null) {
        this.hosts.clear();
        _visitables.remove("hosts");
    }
    if (hosts != null) {
      for (String item : hosts) {
        this.addToHosts(item);
      }
    }
    return (A) this;
  }
  
  public A withMethods(List<String> methods) {
    if (methods != null) {
        this.methods = new ArrayList();
        for (String item : methods) {
          this.addToMethods(item);
        }
    } else {
      this.methods = null;
    }
    return (A) this;
  }
  
  public A withMethods(String... methods) {
    if (this.methods != null) {
        this.methods.clear();
        _visitables.remove("methods");
    }
    if (methods != null) {
      for (String item : methods) {
        this.addToMethods(item);
      }
    }
    return (A) this;
  }
  
  public A withNotHosts(List<String> notHosts) {
    if (notHosts != null) {
        this.notHosts = new ArrayList();
        for (String item : notHosts) {
          this.addToNotHosts(item);
        }
    } else {
      this.notHosts = null;
    }
    return (A) this;
  }
  
  public A withNotHosts(String... notHosts) {
    if (this.notHosts != null) {
        this.notHosts.clear();
        _visitables.remove("notHosts");
    }
    if (notHosts != null) {
      for (String item : notHosts) {
        this.addToNotHosts(item);
      }
    }
    return (A) this;
  }
  
  public A withNotMethods(List<String> notMethods) {
    if (notMethods != null) {
        this.notMethods = new ArrayList();
        for (String item : notMethods) {
          this.addToNotMethods(item);
        }
    } else {
      this.notMethods = null;
    }
    return (A) this;
  }
  
  public A withNotMethods(String... notMethods) {
    if (this.notMethods != null) {
        this.notMethods.clear();
        _visitables.remove("notMethods");
    }
    if (notMethods != null) {
      for (String item : notMethods) {
        this.addToNotMethods(item);
      }
    }
    return (A) this;
  }
  
  public A withNotPaths(List<String> notPaths) {
    if (notPaths != null) {
        this.notPaths = new ArrayList();
        for (String item : notPaths) {
          this.addToNotPaths(item);
        }
    } else {
      this.notPaths = null;
    }
    return (A) this;
  }
  
  public A withNotPaths(String... notPaths) {
    if (this.notPaths != null) {
        this.notPaths.clear();
        _visitables.remove("notPaths");
    }
    if (notPaths != null) {
      for (String item : notPaths) {
        this.addToNotPaths(item);
      }
    }
    return (A) this;
  }
  
  public A withNotPorts(List<String> notPorts) {
    if (notPorts != null) {
        this.notPorts = new ArrayList();
        for (String item : notPorts) {
          this.addToNotPorts(item);
        }
    } else {
      this.notPorts = null;
    }
    return (A) this;
  }
  
  public A withNotPorts(String... notPorts) {
    if (this.notPorts != null) {
        this.notPorts.clear();
        _visitables.remove("notPorts");
    }
    if (notPorts != null) {
      for (String item : notPorts) {
        this.addToNotPorts(item);
      }
    }
    return (A) this;
  }
  
  public A withPaths(List<String> paths) {
    if (paths != null) {
        this.paths = new ArrayList();
        for (String item : paths) {
          this.addToPaths(item);
        }
    } else {
      this.paths = null;
    }
    return (A) this;
  }
  
  public A withPaths(String... paths) {
    if (this.paths != null) {
        this.paths.clear();
        _visitables.remove("paths");
    }
    if (paths != null) {
      for (String item : paths) {
        this.addToPaths(item);
      }
    }
    return (A) this;
  }
  
  public A withPorts(List<String> ports) {
    if (ports != null) {
        this.ports = new ArrayList();
        for (String item : ports) {
          this.addToPorts(item);
        }
    } else {
      this.ports = null;
    }
    return (A) this;
  }
  
  public A withPorts(String... ports) {
    if (this.ports != null) {
        this.ports.clear();
        _visitables.remove("ports");
    }
    if (ports != null) {
      for (String item : ports) {
        this.addToPorts(item);
      }
    }
    return (A) this;
  }
  
}