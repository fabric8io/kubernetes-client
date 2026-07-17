package io.fabric8.openshift.api.model.machine.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class NetworkParamFluent<A extends io.fabric8.openshift.api.model.machine.v1alpha1.NetworkParamFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private FilterBuilder filter;
  private String fixedIp;
  private Boolean noAllowedAddressPairs;
  private Boolean portSecurity;
  private List<String> portTags = new ArrayList<String>();
  private Map<String,String> profile;
  private ArrayList<SubnetParamBuilder> subnets = new ArrayList<SubnetParamBuilder>();
  private String uuid;
  private String vnicType;

  public NetworkParamFluent() {
  }
  
  public NetworkParamFluent(NetworkParam instance) {
    this.copyInstance(instance);
  }

  public A addAllToPortTags(Collection<String> items) {
    if (this.portTags == null) {
      this.portTags = new ArrayList();
    }
    for (String item : items) {
      this.portTags.add(item);
    }
    return (A) this;
  }
  
  public A addAllToSubnets(Collection<SubnetParam> items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (SubnetParam item : items) {
        SubnetParamBuilder builder = new SubnetParamBuilder(item);
        _visitables.get("subnets").add(builder);
        this.subnets.add(builder);
    }
    return (A) this;
  }
  
  public SubnetsNested<A> addNewSubnet() {
    return new SubnetsNested(-1, null);
  }
  
  public SubnetsNested<A> addNewSubnetLike(SubnetParam item) {
    return new SubnetsNested(-1, item);
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
  
  public A addToPortTags(String... items) {
    if (this.portTags == null) {
      this.portTags = new ArrayList();
    }
    for (String item : items) {
      this.portTags.add(item);
    }
    return (A) this;
  }
  
  public A addToPortTags(int index,String item) {
    if (this.portTags == null) {
      this.portTags = new ArrayList();
    }
    this.portTags.add(index, item);
    return (A) this;
  }
  
  public A addToProfile(Map<String,String> map) {
    if (this.profile == null && map != null) {
      this.profile = new LinkedHashMap();
    }
    if (map != null) {
      this.profile.putAll(map);
    }
    return (A) this;
  }
  
  public A addToProfile(String key,String value) {
    if (this.profile == null && key != null && value != null) {
      this.profile = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.profile.put(key, value);
    }
    return (A) this;
  }
  
  public A addToSubnets(SubnetParam... items) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    for (SubnetParam item : items) {
        SubnetParamBuilder builder = new SubnetParamBuilder(item);
        _visitables.get("subnets").add(builder);
        this.subnets.add(builder);
    }
    return (A) this;
  }
  
  public A addToSubnets(int index,SubnetParam item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    SubnetParamBuilder builder = new SubnetParamBuilder(item);
    if (index < 0 || index >= subnets.size()) {
        _visitables.get("subnets").add(builder);
        subnets.add(builder);
    } else {
        _visitables.get("subnets").add(builder);
        subnets.add(index, builder);
    }
    return (A) this;
  }
  
  public Filter buildFilter() {
    return this.filter != null ? this.filter.build() : null;
  }
  
  public SubnetParam buildFirstSubnet() {
    return this.subnets.get(0).build();
  }
  
  public SubnetParam buildLastSubnet() {
    return this.subnets.get(subnets.size() - 1).build();
  }
  
  public SubnetParam buildMatchingSubnet(Predicate<SubnetParamBuilder> predicate) {
      for (SubnetParamBuilder item : subnets) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SubnetParam buildSubnet(int index) {
    return this.subnets.get(index).build();
  }
  
  public List<SubnetParam> buildSubnets() {
    return this.subnets != null ? build(subnets) : null;
  }
  
  protected void copyInstance(NetworkParam instance) {
    instance = instance != null ? instance : new NetworkParam();
    if (instance != null) {
        this.withFilter(instance.getFilter());
        this.withFixedIp(instance.getFixedIp());
        this.withNoAllowedAddressPairs(instance.getNoAllowedAddressPairs());
        this.withPortSecurity(instance.getPortSecurity());
        this.withPortTags(instance.getPortTags());
        this.withProfile(instance.getProfile());
        this.withSubnets(instance.getSubnets());
        this.withUuid(instance.getUuid());
        this.withVnicType(instance.getVnicType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public FilterNested<A> editFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(null));
  }
  
  public SubnetsNested<A> editFirstSubnet() {
    if (subnets.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "subnets"));
    }
    return this.setNewSubnetLike(0, this.buildSubnet(0));
  }
  
  public SubnetsNested<A> editLastSubnet() {
    int index = subnets.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "subnets"));
    }
    return this.setNewSubnetLike(index, this.buildSubnet(index));
  }
  
  public SubnetsNested<A> editMatchingSubnet(Predicate<SubnetParamBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < subnets.size();i++) {
      if (predicate.test(subnets.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "subnets"));
    }
    return this.setNewSubnetLike(index, this.buildSubnet(index));
  }
  
  public FilterNested<A> editOrNewFilter() {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(new FilterBuilder().build()));
  }
  
  public FilterNested<A> editOrNewFilterLike(Filter item) {
    return this.withNewFilterLike(Optional.ofNullable(this.buildFilter()).orElse(item));
  }
  
  public SubnetsNested<A> editSubnet(int index) {
    if (subnets.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "subnets"));
    }
    return this.setNewSubnetLike(index, this.buildSubnet(index));
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
    NetworkParamFluent that = (NetworkParamFluent) o;
    if (!(Objects.equals(filter, that.filter))) {
      return false;
    }
    if (!(Objects.equals(fixedIp, that.fixedIp))) {
      return false;
    }
    if (!(Objects.equals(noAllowedAddressPairs, that.noAllowedAddressPairs))) {
      return false;
    }
    if (!(Objects.equals(portSecurity, that.portSecurity))) {
      return false;
    }
    if (!(Objects.equals(portTags, that.portTags))) {
      return false;
    }
    if (!(Objects.equals(profile, that.profile))) {
      return false;
    }
    if (!(Objects.equals(subnets, that.subnets))) {
      return false;
    }
    if (!(Objects.equals(uuid, that.uuid))) {
      return false;
    }
    if (!(Objects.equals(vnicType, that.vnicType))) {
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
  
  public String getFirstPortTag() {
    return this.portTags.get(0);
  }
  
  public String getFixedIp() {
    return this.fixedIp;
  }
  
  public String getLastPortTag() {
    return this.portTags.get(portTags.size() - 1);
  }
  
  public String getMatchingPortTag(Predicate<String> predicate) {
      for (String item : portTags) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Boolean getNoAllowedAddressPairs() {
    return this.noAllowedAddressPairs;
  }
  
  public Boolean getPortSecurity() {
    return this.portSecurity;
  }
  
  public String getPortTag(int index) {
    return this.portTags.get(index);
  }
  
  public List<String> getPortTags() {
    return this.portTags;
  }
  
  public Map<String,String> getProfile() {
    return this.profile;
  }
  
  public String getUuid() {
    return this.uuid;
  }
  
  public String getVnicType() {
    return this.vnicType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFilter() {
    return this.filter != null;
  }
  
  public boolean hasFixedIp() {
    return this.fixedIp != null;
  }
  
  public boolean hasMatchingPortTag(Predicate<String> predicate) {
      for (String item : portTags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSubnet(Predicate<SubnetParamBuilder> predicate) {
      for (SubnetParamBuilder item : subnets) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNoAllowedAddressPairs() {
    return this.noAllowedAddressPairs != null;
  }
  
  public boolean hasPortSecurity() {
    return this.portSecurity != null;
  }
  
  public boolean hasPortTags() {
    return this.portTags != null && !(this.portTags.isEmpty());
  }
  
  public boolean hasProfile() {
    return this.profile != null;
  }
  
  public boolean hasSubnets() {
    return this.subnets != null && !(this.subnets.isEmpty());
  }
  
  public boolean hasUuid() {
    return this.uuid != null;
  }
  
  public boolean hasVnicType() {
    return this.vnicType != null;
  }
  
  public int hashCode() {
    return Objects.hash(filter, fixedIp, noAllowedAddressPairs, portSecurity, portTags, profile, subnets, uuid, vnicType, additionalProperties);
  }
  
  public A removeAllFromPortTags(Collection<String> items) {
    if (this.portTags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.portTags.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromSubnets(Collection<SubnetParam> items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (SubnetParam item : items) {
        SubnetParamBuilder builder = new SubnetParamBuilder(item);
        _visitables.get("subnets").remove(builder);
        this.subnets.remove(builder);
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
  
  public A removeFromPortTags(String... items) {
    if (this.portTags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.portTags.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromProfile(String key) {
    if (this.profile == null) {
      return (A) this;
    }
    if (key != null && this.profile != null) {
      this.profile.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromProfile(Map<String,String> map) {
    if (this.profile == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.profile != null) {
          this.profile.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromSubnets(SubnetParam... items) {
    if (this.subnets == null) {
      return (A) this;
    }
    for (SubnetParam item : items) {
        SubnetParamBuilder builder = new SubnetParamBuilder(item);
        _visitables.get("subnets").remove(builder);
        this.subnets.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromSubnets(Predicate<SubnetParamBuilder> predicate) {
    if (subnets == null) {
      return (A) this;
    }
    Iterator<SubnetParamBuilder> each = subnets.iterator();
    List visitables = _visitables.get("subnets");
    while (each.hasNext()) {
        SubnetParamBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public SubnetsNested<A> setNewSubnetLike(int index,SubnetParam item) {
    return new SubnetsNested(index, item);
  }
  
  public A setToPortTags(int index,String item) {
    if (this.portTags == null) {
      this.portTags = new ArrayList();
    }
    this.portTags.set(index, item);
    return (A) this;
  }
  
  public A setToSubnets(int index,SubnetParam item) {
    if (this.subnets == null) {
      this.subnets = new ArrayList();
    }
    SubnetParamBuilder builder = new SubnetParamBuilder(item);
    if (index < 0 || index >= subnets.size()) {
        _visitables.get("subnets").add(builder);
        subnets.add(builder);
    } else {
        _visitables.get("subnets").add(builder);
        subnets.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(filter == null)) {
        sb.append("filter:");
        sb.append(filter);
        sb.append(",");
    }
    if (!(fixedIp == null)) {
        sb.append("fixedIp:");
        sb.append(fixedIp);
        sb.append(",");
    }
    if (!(noAllowedAddressPairs == null)) {
        sb.append("noAllowedAddressPairs:");
        sb.append(noAllowedAddressPairs);
        sb.append(",");
    }
    if (!(portSecurity == null)) {
        sb.append("portSecurity:");
        sb.append(portSecurity);
        sb.append(",");
    }
    if (!(portTags == null) && !(portTags.isEmpty())) {
        sb.append("portTags:");
        sb.append(portTags);
        sb.append(",");
    }
    if (!(profile == null) && !(profile.isEmpty())) {
        sb.append("profile:");
        sb.append(profile);
        sb.append(",");
    }
    if (!(subnets == null) && !(subnets.isEmpty())) {
        sb.append("subnets:");
        sb.append(subnets);
        sb.append(",");
    }
    if (!(uuid == null)) {
        sb.append("uuid:");
        sb.append(uuid);
        sb.append(",");
    }
    if (!(vnicType == null)) {
        sb.append("vnicType:");
        sb.append(vnicType);
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
  
  public A withFilter(Filter filter) {
    this._visitables.remove("filter");
    if (filter != null) {
        this.filter = new FilterBuilder(filter);
        this._visitables.get("filter").add(this.filter);
    } else {
        this.filter = null;
        this._visitables.get("filter").remove(this.filter);
    }
    return (A) this;
  }
  
  public A withFixedIp(String fixedIp) {
    this.fixedIp = fixedIp;
    return (A) this;
  }
  
  public FilterNested<A> withNewFilter() {
    return new FilterNested(null);
  }
  
  public FilterNested<A> withNewFilterLike(Filter item) {
    return new FilterNested(item);
  }
  
  public A withNoAllowedAddressPairs() {
    return withNoAllowedAddressPairs(true);
  }
  
  public A withNoAllowedAddressPairs(Boolean noAllowedAddressPairs) {
    this.noAllowedAddressPairs = noAllowedAddressPairs;
    return (A) this;
  }
  
  public A withPortSecurity() {
    return withPortSecurity(true);
  }
  
  public A withPortSecurity(Boolean portSecurity) {
    this.portSecurity = portSecurity;
    return (A) this;
  }
  
  public A withPortTags(List<String> portTags) {
    if (portTags != null) {
        this.portTags = new ArrayList();
        for (String item : portTags) {
          this.addToPortTags(item);
        }
    } else {
      this.portTags = null;
    }
    return (A) this;
  }
  
  public A withPortTags(String... portTags) {
    if (this.portTags != null) {
        this.portTags.clear();
        _visitables.remove("portTags");
    }
    if (portTags != null) {
      for (String item : portTags) {
        this.addToPortTags(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withProfile(Map<String,String> profile) {
    if (profile == null) {
      this.profile = null;
    } else {
      this.profile = new LinkedHashMap(profile);
    }
    return (A) this;
  }
  
  public A withSubnets(List<SubnetParam> subnets) {
    if (this.subnets != null) {
      this._visitables.get("subnets").clear();
    }
    if (subnets != null) {
        this.subnets = new ArrayList();
        for (SubnetParam item : subnets) {
          this.addToSubnets(item);
        }
    } else {
      this.subnets = null;
    }
    return (A) this;
  }
  
  public A withSubnets(SubnetParam... subnets) {
    if (this.subnets != null) {
        this.subnets.clear();
        _visitables.remove("subnets");
    }
    if (subnets != null) {
      for (SubnetParam item : subnets) {
        this.addToSubnets(item);
      }
    }
    return (A) this;
  }
  
  public A withUuid(String uuid) {
    this.uuid = uuid;
    return (A) this;
  }
  
  public A withVnicType(String vnicType) {
    this.vnicType = vnicType;
    return (A) this;
  }
  public class FilterNested<N> extends FilterFluent<FilterNested<N>> implements Nested<N>{
  
    FilterBuilder builder;
  
    FilterNested(Filter item) {
      this.builder = new FilterBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkParamFluent.this.withFilter(builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
  public class SubnetsNested<N> extends SubnetParamFluent<SubnetsNested<N>> implements Nested<N>{
  
    SubnetParamBuilder builder;
    int index;
  
    SubnetsNested(int index,SubnetParam item) {
      this.index = index;
      this.builder = new SubnetParamBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkParamFluent.this.setToSubnets(index, builder.build());
    }
    
    public N endSubnet() {
      return and();
    }
    
  }
}