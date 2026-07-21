package io.fabric8.chaosmesh.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class RawIPSetFluent<A extends io.fabric8.chaosmesh.v1alpha1.RawIPSetFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<CidrAndPortBuilder> cidrAndPorts = new ArrayList<CidrAndPortBuilder>();
  private List<String> cidrs = new ArrayList<String>();
  private String ipsetType;
  private String name;
  private List<String> setNames = new ArrayList<String>();
  private String source;

  public RawIPSetFluent() {
  }
  
  public RawIPSetFluent(RawIPSet instance) {
    this.copyInstance(instance);
  }

  public A addAllToCidrAndPorts(Collection<CidrAndPort> items) {
    if (this.cidrAndPorts == null) {
      this.cidrAndPorts = new ArrayList();
    }
    for (CidrAndPort item : items) {
        CidrAndPortBuilder builder = new CidrAndPortBuilder(item);
        _visitables.get("cidrAndPorts").add(builder);
        this.cidrAndPorts.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToCidrs(Collection<String> items) {
    if (this.cidrs == null) {
      this.cidrs = new ArrayList();
    }
    for (String item : items) {
      this.cidrs.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSetNames(Collection<String> items) {
    if (this.setNames == null) {
      this.setNames = new ArrayList();
    }
    for (String item : items) {
      this.setNames.add(item);
    }
    return (A) this;
  }
  
  public CidrAndPortsNested<A> addNewCidrAndPort() {
    return new CidrAndPortsNested(-1, null);
  }
  
  public A addNewCidrAndPort(String cidr,Integer port) {
    return (A) this.addToCidrAndPorts(new CidrAndPort(cidr, port));
  }
  
  public CidrAndPortsNested<A> addNewCidrAndPortLike(CidrAndPort item) {
    return new CidrAndPortsNested(-1, item);
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
  
  public A addToCidrAndPorts(CidrAndPort... items) {
    if (this.cidrAndPorts == null) {
      this.cidrAndPorts = new ArrayList();
    }
    for (CidrAndPort item : items) {
        CidrAndPortBuilder builder = new CidrAndPortBuilder(item);
        _visitables.get("cidrAndPorts").add(builder);
        this.cidrAndPorts.add(builder);
    }
    return (A) this;
  }
  
  public A addToCidrAndPorts(int index,CidrAndPort item) {
    if (this.cidrAndPorts == null) {
      this.cidrAndPorts = new ArrayList();
    }
    CidrAndPortBuilder builder = new CidrAndPortBuilder(item);
    if (index < 0 || index >= cidrAndPorts.size()) {
        _visitables.get("cidrAndPorts").add(builder);
        cidrAndPorts.add(builder);
    } else {
        _visitables.get("cidrAndPorts").add(builder);
        cidrAndPorts.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToCidrs(String... items) {
    if (this.cidrs == null) {
      this.cidrs = new ArrayList();
    }
    for (String item : items) {
      this.cidrs.add(item);
    }
    return (A) this;
  }
  
  public A addToCidrs(int index,String item) {
    if (this.cidrs == null) {
      this.cidrs = new ArrayList();
    }
    this.cidrs.add(index, item);
    return (A) this;
  }
  
  public A addToSetNames(String... items) {
    if (this.setNames == null) {
      this.setNames = new ArrayList();
    }
    for (String item : items) {
      this.setNames.add(item);
    }
    return (A) this;
  }
  
  public A addToSetNames(int index,String item) {
    if (this.setNames == null) {
      this.setNames = new ArrayList();
    }
    this.setNames.add(index, item);
    return (A) this;
  }
  
  public CidrAndPort buildCidrAndPort(int index) {
    return this.cidrAndPorts.get(index).build();
  }
  
  public List<CidrAndPort> buildCidrAndPorts() {
    return this.cidrAndPorts != null ? build(cidrAndPorts) : null;
  }
  
  public CidrAndPort buildFirstCidrAndPort() {
    return this.cidrAndPorts.get(0).build();
  }
  
  public CidrAndPort buildLastCidrAndPort() {
    return this.cidrAndPorts.get(cidrAndPorts.size() - 1).build();
  }
  
  public CidrAndPort buildMatchingCidrAndPort(Predicate<CidrAndPortBuilder> predicate) {
      for (CidrAndPortBuilder item : cidrAndPorts) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(RawIPSet instance) {
    instance = instance != null ? instance : new RawIPSet();
    if (instance != null) {
        this.withCidrAndPorts(instance.getCidrAndPorts());
        this.withCidrs(instance.getCidrs());
        this.withIpsetType(instance.getIpsetType());
        this.withName(instance.getName());
        this.withSetNames(instance.getSetNames());
        this.withSource(instance.getSource());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CidrAndPortsNested<A> editCidrAndPort(int index) {
    if (cidrAndPorts.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "cidrAndPorts"));
    }
    return this.setNewCidrAndPortLike(index, this.buildCidrAndPort(index));
  }
  
  public CidrAndPortsNested<A> editFirstCidrAndPort() {
    if (cidrAndPorts.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "cidrAndPorts"));
    }
    return this.setNewCidrAndPortLike(0, this.buildCidrAndPort(0));
  }
  
  public CidrAndPortsNested<A> editLastCidrAndPort() {
    int index = cidrAndPorts.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "cidrAndPorts"));
    }
    return this.setNewCidrAndPortLike(index, this.buildCidrAndPort(index));
  }
  
  public CidrAndPortsNested<A> editMatchingCidrAndPort(Predicate<CidrAndPortBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < cidrAndPorts.size();i++) {
      if (predicate.test(cidrAndPorts.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "cidrAndPorts"));
    }
    return this.setNewCidrAndPortLike(index, this.buildCidrAndPort(index));
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
    RawIPSetFluent that = (RawIPSetFluent) o;
    if (!(Objects.equals(cidrAndPorts, that.cidrAndPorts))) {
      return false;
    }
    if (!(Objects.equals(cidrs, that.cidrs))) {
      return false;
    }
    if (!(Objects.equals(ipsetType, that.ipsetType))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(setNames, that.setNames))) {
      return false;
    }
    if (!(Objects.equals(source, that.source))) {
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
  
  public String getCidr(int index) {
    return this.cidrs.get(index);
  }
  
  public List<String> getCidrs() {
    return this.cidrs;
  }
  
  public String getFirstCidr() {
    return this.cidrs.get(0);
  }
  
  public String getFirstSetName() {
    return this.setNames.get(0);
  }
  
  public String getIpsetType() {
    return this.ipsetType;
  }
  
  public String getLastCidr() {
    return this.cidrs.get(cidrs.size() - 1);
  }
  
  public String getLastSetName() {
    return this.setNames.get(setNames.size() - 1);
  }
  
  public String getMatchingCidr(Predicate<String> predicate) {
      for (String item : cidrs) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingSetName(Predicate<String> predicate) {
      for (String item : setNames) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getSetName(int index) {
    return this.setNames.get(index);
  }
  
  public List<String> getSetNames() {
    return this.setNames;
  }
  
  public String getSource() {
    return this.source;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCidrAndPorts() {
    return this.cidrAndPorts != null && !(this.cidrAndPorts.isEmpty());
  }
  
  public boolean hasCidrs() {
    return this.cidrs != null && !(this.cidrs.isEmpty());
  }
  
  public boolean hasIpsetType() {
    return this.ipsetType != null;
  }
  
  public boolean hasMatchingCidr(Predicate<String> predicate) {
      for (String item : cidrs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingCidrAndPort(Predicate<CidrAndPortBuilder> predicate) {
      for (CidrAndPortBuilder item : cidrAndPorts) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSetName(Predicate<String> predicate) {
      for (String item : setNames) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasSetNames() {
    return this.setNames != null && !(this.setNames.isEmpty());
  }
  
  public boolean hasSource() {
    return this.source != null;
  }
  
  public int hashCode() {
    return Objects.hash(cidrAndPorts, cidrs, ipsetType, name, setNames, source, additionalProperties);
  }
  
  public A removeAllFromCidrAndPorts(Collection<CidrAndPort> items) {
    if (this.cidrAndPorts == null) {
      return (A) this;
    }
    for (CidrAndPort item : items) {
        CidrAndPortBuilder builder = new CidrAndPortBuilder(item);
        _visitables.get("cidrAndPorts").remove(builder);
        this.cidrAndPorts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromCidrs(Collection<String> items) {
    if (this.cidrs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.cidrs.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSetNames(Collection<String> items) {
    if (this.setNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.setNames.remove(item);
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
  
  public A removeFromCidrAndPorts(CidrAndPort... items) {
    if (this.cidrAndPorts == null) {
      return (A) this;
    }
    for (CidrAndPort item : items) {
        CidrAndPortBuilder builder = new CidrAndPortBuilder(item);
        _visitables.get("cidrAndPorts").remove(builder);
        this.cidrAndPorts.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromCidrs(String... items) {
    if (this.cidrs == null) {
      return (A) this;
    }
    for (String item : items) {
      this.cidrs.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSetNames(String... items) {
    if (this.setNames == null) {
      return (A) this;
    }
    for (String item : items) {
      this.setNames.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromCidrAndPorts(Predicate<CidrAndPortBuilder> predicate) {
    if (cidrAndPorts == null) {
      return (A) this;
    }
    Iterator<CidrAndPortBuilder> each = cidrAndPorts.iterator();
    List visitables = _visitables.get("cidrAndPorts");
    while (each.hasNext()) {
        CidrAndPortBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public CidrAndPortsNested<A> setNewCidrAndPortLike(int index,CidrAndPort item) {
    return new CidrAndPortsNested(index, item);
  }
  
  public A setToCidrAndPorts(int index,CidrAndPort item) {
    if (this.cidrAndPorts == null) {
      this.cidrAndPorts = new ArrayList();
    }
    CidrAndPortBuilder builder = new CidrAndPortBuilder(item);
    if (index < 0 || index >= cidrAndPorts.size()) {
        _visitables.get("cidrAndPorts").add(builder);
        cidrAndPorts.add(builder);
    } else {
        _visitables.get("cidrAndPorts").add(builder);
        cidrAndPorts.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToCidrs(int index,String item) {
    if (this.cidrs == null) {
      this.cidrs = new ArrayList();
    }
    this.cidrs.set(index, item);
    return (A) this;
  }
  
  public A setToSetNames(int index,String item) {
    if (this.setNames == null) {
      this.setNames = new ArrayList();
    }
    this.setNames.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(cidrAndPorts == null) && !(cidrAndPorts.isEmpty())) {
        sb.append("cidrAndPorts:");
        sb.append(cidrAndPorts);
        sb.append(",");
    }
    if (!(cidrs == null) && !(cidrs.isEmpty())) {
        sb.append("cidrs:");
        sb.append(cidrs);
        sb.append(",");
    }
    if (!(ipsetType == null)) {
        sb.append("ipsetType:");
        sb.append(ipsetType);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(setNames == null) && !(setNames.isEmpty())) {
        sb.append("setNames:");
        sb.append(setNames);
        sb.append(",");
    }
    if (!(source == null)) {
        sb.append("source:");
        sb.append(source);
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
  
  public A withCidrAndPorts(List<CidrAndPort> cidrAndPorts) {
    if (this.cidrAndPorts != null) {
      this._visitables.get("cidrAndPorts").clear();
    }
    if (cidrAndPorts != null) {
        this.cidrAndPorts = new ArrayList();
        for (CidrAndPort item : cidrAndPorts) {
          this.addToCidrAndPorts(item);
        }
    } else {
      this.cidrAndPorts = null;
    }
    return (A) this;
  }
  
  public A withCidrAndPorts(CidrAndPort... cidrAndPorts) {
    if (this.cidrAndPorts != null) {
        this.cidrAndPorts.clear();
        _visitables.remove("cidrAndPorts");
    }
    if (cidrAndPorts != null) {
      for (CidrAndPort item : cidrAndPorts) {
        this.addToCidrAndPorts(item);
      }
    }
    return (A) this;
  }
  
  public A withCidrs(List<String> cidrs) {
    if (cidrs != null) {
        this.cidrs = new ArrayList();
        for (String item : cidrs) {
          this.addToCidrs(item);
        }
    } else {
      this.cidrs = null;
    }
    return (A) this;
  }
  
  public A withCidrs(String... cidrs) {
    if (this.cidrs != null) {
        this.cidrs.clear();
        _visitables.remove("cidrs");
    }
    if (cidrs != null) {
      for (String item : cidrs) {
        this.addToCidrs(item);
      }
    }
    return (A) this;
  }
  
  public A withIpsetType(String ipsetType) {
    this.ipsetType = ipsetType;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public A withSetNames(List<String> setNames) {
    if (setNames != null) {
        this.setNames = new ArrayList();
        for (String item : setNames) {
          this.addToSetNames(item);
        }
    } else {
      this.setNames = null;
    }
    return (A) this;
  }
  
  public A withSetNames(String... setNames) {
    if (this.setNames != null) {
        this.setNames.clear();
        _visitables.remove("setNames");
    }
    if (setNames != null) {
      for (String item : setNames) {
        this.addToSetNames(item);
      }
    }
    return (A) this;
  }
  
  public A withSource(String source) {
    this.source = source;
    return (A) this;
  }
  public class CidrAndPortsNested<N> extends CidrAndPortFluent<CidrAndPortsNested<N>> implements Nested<N>{
  
    CidrAndPortBuilder builder;
    int index;
  
    CidrAndPortsNested(int index,CidrAndPort item) {
      this.index = index;
      this.builder = new CidrAndPortBuilder(this, item);
    }
  
    public N and() {
      return (N) RawIPSetFluent.this.setToCidrAndPorts(index, builder.build());
    }
    
    public N endCidrAndPort() {
      return and();
    }
    
  }
}