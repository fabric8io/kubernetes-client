package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import java.lang.Long;
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
public class L4MatchAttributesFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.L4MatchAttributesFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> destinationSubnets = new ArrayList<String>();
  private List<String> gateways = new ArrayList<String>();
  private Long port;
  private Map<String,String> sourceLabels;
  private String sourceNamespace;
  private String sourceSubnet;

  public L4MatchAttributesFluent() {
  }
  
  public L4MatchAttributesFluent(L4MatchAttributes instance) {
    this.copyInstance(instance);
  }

  public A addAllToDestinationSubnets(Collection<String> items) {
    if (this.destinationSubnets == null) {
      this.destinationSubnets = new ArrayList();
    }
    for (String item : items) {
      this.destinationSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addAllToGateways(Collection<String> items) {
    if (this.gateways == null) {
      this.gateways = new ArrayList();
    }
    for (String item : items) {
      this.gateways.add(item);
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
  
  public A addToDestinationSubnets(String... items) {
    if (this.destinationSubnets == null) {
      this.destinationSubnets = new ArrayList();
    }
    for (String item : items) {
      this.destinationSubnets.add(item);
    }
    return (A) this;
  }
  
  public A addToDestinationSubnets(int index,String item) {
    if (this.destinationSubnets == null) {
      this.destinationSubnets = new ArrayList();
    }
    this.destinationSubnets.add(index, item);
    return (A) this;
  }
  
  public A addToGateways(String... items) {
    if (this.gateways == null) {
      this.gateways = new ArrayList();
    }
    for (String item : items) {
      this.gateways.add(item);
    }
    return (A) this;
  }
  
  public A addToGateways(int index,String item) {
    if (this.gateways == null) {
      this.gateways = new ArrayList();
    }
    this.gateways.add(index, item);
    return (A) this;
  }
  
  public A addToSourceLabels(Map<String,String> map) {
    if (this.sourceLabels == null && map != null) {
      this.sourceLabels = new LinkedHashMap();
    }
    if (map != null) {
      this.sourceLabels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToSourceLabels(String key,String value) {
    if (this.sourceLabels == null && key != null && value != null) {
      this.sourceLabels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.sourceLabels.put(key, value);
    }
    return (A) this;
  }
  
  protected void copyInstance(L4MatchAttributes instance) {
    instance = instance != null ? instance : new L4MatchAttributes();
    if (instance != null) {
        this.withDestinationSubnets(instance.getDestinationSubnets());
        this.withGateways(instance.getGateways());
        this.withPort(instance.getPort());
        this.withSourceLabels(instance.getSourceLabels());
        this.withSourceNamespace(instance.getSourceNamespace());
        this.withSourceSubnet(instance.getSourceSubnet());
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
    L4MatchAttributesFluent that = (L4MatchAttributesFluent) o;
    if (!(Objects.equals(destinationSubnets, that.destinationSubnets))) {
      return false;
    }
    if (!(Objects.equals(gateways, that.gateways))) {
      return false;
    }
    if (!(Objects.equals(port, that.port))) {
      return false;
    }
    if (!(Objects.equals(sourceLabels, that.sourceLabels))) {
      return false;
    }
    if (!(Objects.equals(sourceNamespace, that.sourceNamespace))) {
      return false;
    }
    if (!(Objects.equals(sourceSubnet, that.sourceSubnet))) {
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
  
  public String getDestinationSubnet(int index) {
    return this.destinationSubnets.get(index);
  }
  
  public List<String> getDestinationSubnets() {
    return this.destinationSubnets;
  }
  
  public String getFirstDestinationSubnet() {
    return this.destinationSubnets.get(0);
  }
  
  public String getFirstGateway() {
    return this.gateways.get(0);
  }
  
  public String getGateway(int index) {
    return this.gateways.get(index);
  }
  
  public List<String> getGateways() {
    return this.gateways;
  }
  
  public String getLastDestinationSubnet() {
    return this.destinationSubnets.get(destinationSubnets.size() - 1);
  }
  
  public String getLastGateway() {
    return this.gateways.get(gateways.size() - 1);
  }
  
  public String getMatchingDestinationSubnet(Predicate<String> predicate) {
      for (String item : destinationSubnets) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingGateway(Predicate<String> predicate) {
      for (String item : gateways) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Long getPort() {
    return this.port;
  }
  
  public Map<String,String> getSourceLabels() {
    return this.sourceLabels;
  }
  
  public String getSourceNamespace() {
    return this.sourceNamespace;
  }
  
  public String getSourceSubnet() {
    return this.sourceSubnet;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasDestinationSubnets() {
    return this.destinationSubnets != null && !(this.destinationSubnets.isEmpty());
  }
  
  public boolean hasGateways() {
    return this.gateways != null && !(this.gateways.isEmpty());
  }
  
  public boolean hasMatchingDestinationSubnet(Predicate<String> predicate) {
      for (String item : destinationSubnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingGateway(Predicate<String> predicate) {
      for (String item : gateways) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPort() {
    return this.port != null;
  }
  
  public boolean hasSourceLabels() {
    return this.sourceLabels != null;
  }
  
  public boolean hasSourceNamespace() {
    return this.sourceNamespace != null;
  }
  
  public boolean hasSourceSubnet() {
    return this.sourceSubnet != null;
  }
  
  public int hashCode() {
    return Objects.hash(destinationSubnets, gateways, port, sourceLabels, sourceNamespace, sourceSubnet, additionalProperties);
  }
  
  public A removeAllFromDestinationSubnets(Collection<String> items) {
    if (this.destinationSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.destinationSubnets.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromGateways(Collection<String> items) {
    if (this.gateways == null) {
      return (A) this;
    }
    for (String item : items) {
      this.gateways.remove(item);
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
  
  public A removeFromDestinationSubnets(String... items) {
    if (this.destinationSubnets == null) {
      return (A) this;
    }
    for (String item : items) {
      this.destinationSubnets.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromGateways(String... items) {
    if (this.gateways == null) {
      return (A) this;
    }
    for (String item : items) {
      this.gateways.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromSourceLabels(String key) {
    if (this.sourceLabels == null) {
      return (A) this;
    }
    if (key != null && this.sourceLabels != null) {
      this.sourceLabels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromSourceLabels(Map<String,String> map) {
    if (this.sourceLabels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.sourceLabels != null) {
          this.sourceLabels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToDestinationSubnets(int index,String item) {
    if (this.destinationSubnets == null) {
      this.destinationSubnets = new ArrayList();
    }
    this.destinationSubnets.set(index, item);
    return (A) this;
  }
  
  public A setToGateways(int index,String item) {
    if (this.gateways == null) {
      this.gateways = new ArrayList();
    }
    this.gateways.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(destinationSubnets == null) && !(destinationSubnets.isEmpty())) {
        sb.append("destinationSubnets:");
        sb.append(destinationSubnets);
        sb.append(",");
    }
    if (!(gateways == null) && !(gateways.isEmpty())) {
        sb.append("gateways:");
        sb.append(gateways);
        sb.append(",");
    }
    if (!(port == null)) {
        sb.append("port:");
        sb.append(port);
        sb.append(",");
    }
    if (!(sourceLabels == null) && !(sourceLabels.isEmpty())) {
        sb.append("sourceLabels:");
        sb.append(sourceLabels);
        sb.append(",");
    }
    if (!(sourceNamespace == null)) {
        sb.append("sourceNamespace:");
        sb.append(sourceNamespace);
        sb.append(",");
    }
    if (!(sourceSubnet == null)) {
        sb.append("sourceSubnet:");
        sb.append(sourceSubnet);
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
  
  public A withDestinationSubnets(List<String> destinationSubnets) {
    if (destinationSubnets != null) {
        this.destinationSubnets = new ArrayList();
        for (String item : destinationSubnets) {
          this.addToDestinationSubnets(item);
        }
    } else {
      this.destinationSubnets = null;
    }
    return (A) this;
  }
  
  public A withDestinationSubnets(String... destinationSubnets) {
    if (this.destinationSubnets != null) {
        this.destinationSubnets.clear();
        _visitables.remove("destinationSubnets");
    }
    if (destinationSubnets != null) {
      for (String item : destinationSubnets) {
        this.addToDestinationSubnets(item);
      }
    }
    return (A) this;
  }
  
  public A withGateways(List<String> gateways) {
    if (gateways != null) {
        this.gateways = new ArrayList();
        for (String item : gateways) {
          this.addToGateways(item);
        }
    } else {
      this.gateways = null;
    }
    return (A) this;
  }
  
  public A withGateways(String... gateways) {
    if (this.gateways != null) {
        this.gateways.clear();
        _visitables.remove("gateways");
    }
    if (gateways != null) {
      for (String item : gateways) {
        this.addToGateways(item);
      }
    }
    return (A) this;
  }
  
  public A withPort(Long port) {
    this.port = port;
    return (A) this;
  }
  
  public <K,V>A withSourceLabels(Map<String,String> sourceLabels) {
    if (sourceLabels == null) {
      this.sourceLabels = null;
    } else {
      this.sourceLabels = new LinkedHashMap(sourceLabels);
    }
    return (A) this;
  }
  
  public A withSourceNamespace(String sourceNamespace) {
    this.sourceNamespace = sourceNamespace;
    return (A) this;
  }
  
  public A withSourceSubnet(String sourceSubnet) {
    this.sourceSubnet = sourceSubnet;
    return (A) this;
  }
  
}