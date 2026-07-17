package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

import com.fasterxml.jackson.databind.JsonNode;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class NetworkDataLinkBondFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1.NetworkDataLinkBondFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<String> bondLinks = new ArrayList<String>();
  private String bondMode;
  private String bondXmitHashPolicy;
  private String id;
  private NetworkLinkEthernetMacBuilder macAddress;
  private Integer mtu;
  private String name;
  private Map<String,JsonNode> parameters;

  public NetworkDataLinkBondFluent() {
  }
  
  public NetworkDataLinkBondFluent(NetworkDataLinkBond instance) {
    this.copyInstance(instance);
  }

  public A addAllToBondLinks(Collection<String> items) {
    if (this.bondLinks == null) {
      this.bondLinks = new ArrayList();
    }
    for (String item : items) {
      this.bondLinks.add(item);
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
  
  public A addToBondLinks(String... items) {
    if (this.bondLinks == null) {
      this.bondLinks = new ArrayList();
    }
    for (String item : items) {
      this.bondLinks.add(item);
    }
    return (A) this;
  }
  
  public A addToBondLinks(int index,String item) {
    if (this.bondLinks == null) {
      this.bondLinks = new ArrayList();
    }
    this.bondLinks.add(index, item);
    return (A) this;
  }
  
  public A addToParameters(Map<String,JsonNode> map) {
    if (this.parameters == null && map != null) {
      this.parameters = new LinkedHashMap();
    }
    if (map != null) {
      this.parameters.putAll(map);
    }
    return (A) this;
  }
  
  public A addToParameters(String key,JsonNode value) {
    if (this.parameters == null && key != null && value != null) {
      this.parameters = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.parameters.put(key, value);
    }
    return (A) this;
  }
  
  public NetworkLinkEthernetMac buildMacAddress() {
    return this.macAddress != null ? this.macAddress.build() : null;
  }
  
  protected void copyInstance(NetworkDataLinkBond instance) {
    instance = instance != null ? instance : new NetworkDataLinkBond();
    if (instance != null) {
        this.withBondLinks(instance.getBondLinks());
        this.withBondMode(instance.getBondMode());
        this.withBondXmitHashPolicy(instance.getBondXmitHashPolicy());
        this.withId(instance.getId());
        this.withMacAddress(instance.getMacAddress());
        this.withMtu(instance.getMtu());
        this.withName(instance.getName());
        this.withParameters(instance.getParameters());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MacAddressNested<A> editMacAddress() {
    return this.withNewMacAddressLike(Optional.ofNullable(this.buildMacAddress()).orElse(null));
  }
  
  public MacAddressNested<A> editOrNewMacAddress() {
    return this.withNewMacAddressLike(Optional.ofNullable(this.buildMacAddress()).orElse(new NetworkLinkEthernetMacBuilder().build()));
  }
  
  public MacAddressNested<A> editOrNewMacAddressLike(NetworkLinkEthernetMac item) {
    return this.withNewMacAddressLike(Optional.ofNullable(this.buildMacAddress()).orElse(item));
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
    NetworkDataLinkBondFluent that = (NetworkDataLinkBondFluent) o;
    if (!(Objects.equals(bondLinks, that.bondLinks))) {
      return false;
    }
    if (!(Objects.equals(bondMode, that.bondMode))) {
      return false;
    }
    if (!(Objects.equals(bondXmitHashPolicy, that.bondXmitHashPolicy))) {
      return false;
    }
    if (!(Objects.equals(id, that.id))) {
      return false;
    }
    if (!(Objects.equals(macAddress, that.macAddress))) {
      return false;
    }
    if (!(Objects.equals(mtu, that.mtu))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(parameters, that.parameters))) {
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
  
  public String getBondLink(int index) {
    return this.bondLinks.get(index);
  }
  
  public List<String> getBondLinks() {
    return this.bondLinks;
  }
  
  public String getBondMode() {
    return this.bondMode;
  }
  
  public String getBondXmitHashPolicy() {
    return this.bondXmitHashPolicy;
  }
  
  public String getFirstBondLink() {
    return this.bondLinks.get(0);
  }
  
  public String getId() {
    return this.id;
  }
  
  public String getLastBondLink() {
    return this.bondLinks.get(bondLinks.size() - 1);
  }
  
  public String getMatchingBondLink(Predicate<String> predicate) {
      for (String item : bondLinks) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Integer getMtu() {
    return this.mtu;
  }
  
  public String getName() {
    return this.name;
  }
  
  public Map<String,JsonNode> getParameters() {
    return this.parameters;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBondLinks() {
    return this.bondLinks != null && !(this.bondLinks.isEmpty());
  }
  
  public boolean hasBondMode() {
    return this.bondMode != null;
  }
  
  public boolean hasBondXmitHashPolicy() {
    return this.bondXmitHashPolicy != null;
  }
  
  public boolean hasId() {
    return this.id != null;
  }
  
  public boolean hasMacAddress() {
    return this.macAddress != null;
  }
  
  public boolean hasMatchingBondLink(Predicate<String> predicate) {
      for (String item : bondLinks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMtu() {
    return this.mtu != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasParameters() {
    return this.parameters != null;
  }
  
  public int hashCode() {
    return Objects.hash(bondLinks, bondMode, bondXmitHashPolicy, id, macAddress, mtu, name, parameters, additionalProperties);
  }
  
  public A removeAllFromBondLinks(Collection<String> items) {
    if (this.bondLinks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bondLinks.remove(item);
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
  
  public A removeFromBondLinks(String... items) {
    if (this.bondLinks == null) {
      return (A) this;
    }
    for (String item : items) {
      this.bondLinks.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromParameters(String key) {
    if (this.parameters == null) {
      return (A) this;
    }
    if (key != null && this.parameters != null) {
      this.parameters.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromParameters(Map<String,JsonNode> map) {
    if (this.parameters == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.parameters != null) {
          this.parameters.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A setToBondLinks(int index,String item) {
    if (this.bondLinks == null) {
      this.bondLinks = new ArrayList();
    }
    this.bondLinks.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(bondLinks == null) && !(bondLinks.isEmpty())) {
        sb.append("bondLinks:");
        sb.append(bondLinks);
        sb.append(",");
    }
    if (!(bondMode == null)) {
        sb.append("bondMode:");
        sb.append(bondMode);
        sb.append(",");
    }
    if (!(bondXmitHashPolicy == null)) {
        sb.append("bondXmitHashPolicy:");
        sb.append(bondXmitHashPolicy);
        sb.append(",");
    }
    if (!(id == null)) {
        sb.append("id:");
        sb.append(id);
        sb.append(",");
    }
    if (!(macAddress == null)) {
        sb.append("macAddress:");
        sb.append(macAddress);
        sb.append(",");
    }
    if (!(mtu == null)) {
        sb.append("mtu:");
        sb.append(mtu);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(parameters == null) && !(parameters.isEmpty())) {
        sb.append("parameters:");
        sb.append(parameters);
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
  
  public A withBondLinks(List<String> bondLinks) {
    if (bondLinks != null) {
        this.bondLinks = new ArrayList();
        for (String item : bondLinks) {
          this.addToBondLinks(item);
        }
    } else {
      this.bondLinks = null;
    }
    return (A) this;
  }
  
  public A withBondLinks(String... bondLinks) {
    if (this.bondLinks != null) {
        this.bondLinks.clear();
        _visitables.remove("bondLinks");
    }
    if (bondLinks != null) {
      for (String item : bondLinks) {
        this.addToBondLinks(item);
      }
    }
    return (A) this;
  }
  
  public A withBondMode(String bondMode) {
    this.bondMode = bondMode;
    return (A) this;
  }
  
  public A withBondXmitHashPolicy(String bondXmitHashPolicy) {
    this.bondXmitHashPolicy = bondXmitHashPolicy;
    return (A) this;
  }
  
  public A withId(String id) {
    this.id = id;
    return (A) this;
  }
  
  public A withMacAddress(NetworkLinkEthernetMac macAddress) {
    this._visitables.remove("macAddress");
    if (macAddress != null) {
        this.macAddress = new NetworkLinkEthernetMacBuilder(macAddress);
        this._visitables.get("macAddress").add(this.macAddress);
    } else {
        this.macAddress = null;
        this._visitables.get("macAddress").remove(this.macAddress);
    }
    return (A) this;
  }
  
  public A withMtu(Integer mtu) {
    this.mtu = mtu;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public MacAddressNested<A> withNewMacAddress() {
    return new MacAddressNested(null);
  }
  
  public MacAddressNested<A> withNewMacAddressLike(NetworkLinkEthernetMac item) {
    return new MacAddressNested(item);
  }
  
  public <K,V>A withParameters(Map<String,JsonNode> parameters) {
    if (parameters == null) {
      this.parameters = null;
    } else {
      this.parameters = new LinkedHashMap(parameters);
    }
    return (A) this;
  }
  public class MacAddressNested<N> extends NetworkLinkEthernetMacFluent<MacAddressNested<N>> implements Nested<N>{
  
    NetworkLinkEthernetMacBuilder builder;
  
    MacAddressNested(NetworkLinkEthernetMac item) {
      this.builder = new NetworkLinkEthernetMacBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkDataLinkBondFluent.this.withMacAddress(builder.build());
    }
    
    public N endMacAddress() {
      return and();
    }
    
  }
}