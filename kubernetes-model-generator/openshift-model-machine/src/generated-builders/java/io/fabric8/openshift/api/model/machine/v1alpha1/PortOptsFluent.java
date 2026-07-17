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
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PortOptsFluent<A extends io.fabric8.openshift.api.model.machine.v1alpha1.PortOptsFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Boolean adminStateUp;
  private ArrayList<AddressPairBuilder> allowedAddressPairs = new ArrayList<AddressPairBuilder>();
  private String description;
  private ArrayList<FixedIPsBuilder> fixedIPs = new ArrayList<FixedIPsBuilder>();
  private String hostID;
  private String macAddress;
  private String nameSuffix;
  private String networkID;
  private Boolean portSecurity;
  private Map<String,String> profile;
  private String projectID;
  private List<String> securityGroups = new ArrayList<String>();
  private List<String> tags = new ArrayList<String>();
  private String tenantID;
  private Boolean trunk;
  private String vnicType;

  public PortOptsFluent() {
  }
  
  public PortOptsFluent(PortOpts instance) {
    this.copyInstance(instance);
  }

  public A addAllToAllowedAddressPairs(Collection<AddressPair> items) {
    if (this.allowedAddressPairs == null) {
      this.allowedAddressPairs = new ArrayList();
    }
    for (AddressPair item : items) {
        AddressPairBuilder builder = new AddressPairBuilder(item);
        _visitables.get("allowedAddressPairs").add(builder);
        this.allowedAddressPairs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFixedIPs(Collection<FixedIPs> items) {
    if (this.fixedIPs == null) {
      this.fixedIPs = new ArrayList();
    }
    for (FixedIPs item : items) {
        FixedIPsBuilder builder = new FixedIPsBuilder(item);
        _visitables.get("fixedIPs").add(builder);
        this.fixedIPs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToSecurityGroups(Collection<String> items) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    for (String item : items) {
      this.securityGroups.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTags(Collection<String> items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (String item : items) {
      this.tags.add(item);
    }
    return (A) this;
  }
  
  public AllowedAddressPairsNested<A> addNewAllowedAddressPair() {
    return new AllowedAddressPairsNested(-1, null);
  }
  
  public A addNewAllowedAddressPair(String ipAddress,String macAddress) {
    return (A) this.addToAllowedAddressPairs(new AddressPair(ipAddress, macAddress));
  }
  
  public AllowedAddressPairsNested<A> addNewAllowedAddressPairLike(AddressPair item) {
    return new AllowedAddressPairsNested(-1, item);
  }
  
  public FixedIPsNested<A> addNewFixedIP() {
    return new FixedIPsNested(-1, null);
  }
  
  public A addNewFixedIP(String ipAddress,String subnetID) {
    return (A) this.addToFixedIPs(new FixedIPs(ipAddress, subnetID));
  }
  
  public FixedIPsNested<A> addNewFixedIPLike(FixedIPs item) {
    return new FixedIPsNested(-1, item);
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
  
  public A addToAllowedAddressPairs(AddressPair... items) {
    if (this.allowedAddressPairs == null) {
      this.allowedAddressPairs = new ArrayList();
    }
    for (AddressPair item : items) {
        AddressPairBuilder builder = new AddressPairBuilder(item);
        _visitables.get("allowedAddressPairs").add(builder);
        this.allowedAddressPairs.add(builder);
    }
    return (A) this;
  }
  
  public A addToAllowedAddressPairs(int index,AddressPair item) {
    if (this.allowedAddressPairs == null) {
      this.allowedAddressPairs = new ArrayList();
    }
    AddressPairBuilder builder = new AddressPairBuilder(item);
    if (index < 0 || index >= allowedAddressPairs.size()) {
        _visitables.get("allowedAddressPairs").add(builder);
        allowedAddressPairs.add(builder);
    } else {
        _visitables.get("allowedAddressPairs").add(builder);
        allowedAddressPairs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToFixedIPs(FixedIPs... items) {
    if (this.fixedIPs == null) {
      this.fixedIPs = new ArrayList();
    }
    for (FixedIPs item : items) {
        FixedIPsBuilder builder = new FixedIPsBuilder(item);
        _visitables.get("fixedIPs").add(builder);
        this.fixedIPs.add(builder);
    }
    return (A) this;
  }
  
  public A addToFixedIPs(int index,FixedIPs item) {
    if (this.fixedIPs == null) {
      this.fixedIPs = new ArrayList();
    }
    FixedIPsBuilder builder = new FixedIPsBuilder(item);
    if (index < 0 || index >= fixedIPs.size()) {
        _visitables.get("fixedIPs").add(builder);
        fixedIPs.add(builder);
    } else {
        _visitables.get("fixedIPs").add(builder);
        fixedIPs.add(index, builder);
    }
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
  
  public A addToSecurityGroups(String... items) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    for (String item : items) {
      this.securityGroups.add(item);
    }
    return (A) this;
  }
  
  public A addToSecurityGroups(int index,String item) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    this.securityGroups.add(index, item);
    return (A) this;
  }
  
  public A addToTags(String... items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (String item : items) {
      this.tags.add(item);
    }
    return (A) this;
  }
  
  public A addToTags(int index,String item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    this.tags.add(index, item);
    return (A) this;
  }
  
  public AddressPair buildAllowedAddressPair(int index) {
    return this.allowedAddressPairs.get(index).build();
  }
  
  public List<AddressPair> buildAllowedAddressPairs() {
    return this.allowedAddressPairs != null ? build(allowedAddressPairs) : null;
  }
  
  public AddressPair buildFirstAllowedAddressPair() {
    return this.allowedAddressPairs.get(0).build();
  }
  
  public FixedIPs buildFirstFixedIP() {
    return this.fixedIPs.get(0).build();
  }
  
  public FixedIPs buildFixedIP(int index) {
    return this.fixedIPs.get(index).build();
  }
  
  public List<FixedIPs> buildFixedIPs() {
    return this.fixedIPs != null ? build(fixedIPs) : null;
  }
  
  public AddressPair buildLastAllowedAddressPair() {
    return this.allowedAddressPairs.get(allowedAddressPairs.size() - 1).build();
  }
  
  public FixedIPs buildLastFixedIP() {
    return this.fixedIPs.get(fixedIPs.size() - 1).build();
  }
  
  public AddressPair buildMatchingAllowedAddressPair(Predicate<AddressPairBuilder> predicate) {
      for (AddressPairBuilder item : allowedAddressPairs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public FixedIPs buildMatchingFixedIP(Predicate<FixedIPsBuilder> predicate) {
      for (FixedIPsBuilder item : fixedIPs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(PortOpts instance) {
    instance = instance != null ? instance : new PortOpts();
    if (instance != null) {
        this.withAdminStateUp(instance.getAdminStateUp());
        this.withAllowedAddressPairs(instance.getAllowedAddressPairs());
        this.withDescription(instance.getDescription());
        this.withFixedIPs(instance.getFixedIPs());
        this.withHostID(instance.getHostID());
        this.withMacAddress(instance.getMacAddress());
        this.withNameSuffix(instance.getNameSuffix());
        this.withNetworkID(instance.getNetworkID());
        this.withPortSecurity(instance.getPortSecurity());
        this.withProfile(instance.getProfile());
        this.withProjectID(instance.getProjectID());
        this.withSecurityGroups(instance.getSecurityGroups());
        this.withTags(instance.getTags());
        this.withTenantID(instance.getTenantID());
        this.withTrunk(instance.getTrunk());
        this.withVnicType(instance.getVnicType());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AllowedAddressPairsNested<A> editAllowedAddressPair(int index) {
    if (allowedAddressPairs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "allowedAddressPairs"));
    }
    return this.setNewAllowedAddressPairLike(index, this.buildAllowedAddressPair(index));
  }
  
  public AllowedAddressPairsNested<A> editFirstAllowedAddressPair() {
    if (allowedAddressPairs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "allowedAddressPairs"));
    }
    return this.setNewAllowedAddressPairLike(0, this.buildAllowedAddressPair(0));
  }
  
  public FixedIPsNested<A> editFirstFixedIP() {
    if (fixedIPs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "fixedIPs"));
    }
    return this.setNewFixedIPLike(0, this.buildFixedIP(0));
  }
  
  public FixedIPsNested<A> editFixedIP(int index) {
    if (fixedIPs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "fixedIPs"));
    }
    return this.setNewFixedIPLike(index, this.buildFixedIP(index));
  }
  
  public AllowedAddressPairsNested<A> editLastAllowedAddressPair() {
    int index = allowedAddressPairs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "allowedAddressPairs"));
    }
    return this.setNewAllowedAddressPairLike(index, this.buildAllowedAddressPair(index));
  }
  
  public FixedIPsNested<A> editLastFixedIP() {
    int index = fixedIPs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "fixedIPs"));
    }
    return this.setNewFixedIPLike(index, this.buildFixedIP(index));
  }
  
  public AllowedAddressPairsNested<A> editMatchingAllowedAddressPair(Predicate<AddressPairBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < allowedAddressPairs.size();i++) {
      if (predicate.test(allowedAddressPairs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "allowedAddressPairs"));
    }
    return this.setNewAllowedAddressPairLike(index, this.buildAllowedAddressPair(index));
  }
  
  public FixedIPsNested<A> editMatchingFixedIP(Predicate<FixedIPsBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < fixedIPs.size();i++) {
      if (predicate.test(fixedIPs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "fixedIPs"));
    }
    return this.setNewFixedIPLike(index, this.buildFixedIP(index));
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
    PortOptsFluent that = (PortOptsFluent) o;
    if (!(Objects.equals(adminStateUp, that.adminStateUp))) {
      return false;
    }
    if (!(Objects.equals(allowedAddressPairs, that.allowedAddressPairs))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(fixedIPs, that.fixedIPs))) {
      return false;
    }
    if (!(Objects.equals(hostID, that.hostID))) {
      return false;
    }
    if (!(Objects.equals(macAddress, that.macAddress))) {
      return false;
    }
    if (!(Objects.equals(nameSuffix, that.nameSuffix))) {
      return false;
    }
    if (!(Objects.equals(networkID, that.networkID))) {
      return false;
    }
    if (!(Objects.equals(portSecurity, that.portSecurity))) {
      return false;
    }
    if (!(Objects.equals(profile, that.profile))) {
      return false;
    }
    if (!(Objects.equals(projectID, that.projectID))) {
      return false;
    }
    if (!(Objects.equals(securityGroups, that.securityGroups))) {
      return false;
    }
    if (!(Objects.equals(tags, that.tags))) {
      return false;
    }
    if (!(Objects.equals(tenantID, that.tenantID))) {
      return false;
    }
    if (!(Objects.equals(trunk, that.trunk))) {
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
  
  public Boolean getAdminStateUp() {
    return this.adminStateUp;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public String getFirstSecurityGroup() {
    return this.securityGroups.get(0);
  }
  
  public String getFirstTag() {
    return this.tags.get(0);
  }
  
  public String getHostID() {
    return this.hostID;
  }
  
  public String getLastSecurityGroup() {
    return this.securityGroups.get(securityGroups.size() - 1);
  }
  
  public String getLastTag() {
    return this.tags.get(tags.size() - 1);
  }
  
  public String getMacAddress() {
    return this.macAddress;
  }
  
  public String getMatchingSecurityGroup(Predicate<String> predicate) {
      for (String item : securityGroups) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingTag(Predicate<String> predicate) {
      for (String item : tags) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNameSuffix() {
    return this.nameSuffix;
  }
  
  public String getNetworkID() {
    return this.networkID;
  }
  
  public Boolean getPortSecurity() {
    return this.portSecurity;
  }
  
  public Map<String,String> getProfile() {
    return this.profile;
  }
  
  public String getProjectID() {
    return this.projectID;
  }
  
  public String getSecurityGroup(int index) {
    return this.securityGroups.get(index);
  }
  
  public List<String> getSecurityGroups() {
    return this.securityGroups;
  }
  
  public String getTag(int index) {
    return this.tags.get(index);
  }
  
  public List<String> getTags() {
    return this.tags;
  }
  
  public String getTenantID() {
    return this.tenantID;
  }
  
  public Boolean getTrunk() {
    return this.trunk;
  }
  
  public String getVnicType() {
    return this.vnicType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdminStateUp() {
    return this.adminStateUp != null;
  }
  
  public boolean hasAllowedAddressPairs() {
    return this.allowedAddressPairs != null && !(this.allowedAddressPairs.isEmpty());
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasFixedIPs() {
    return this.fixedIPs != null && !(this.fixedIPs.isEmpty());
  }
  
  public boolean hasHostID() {
    return this.hostID != null;
  }
  
  public boolean hasMacAddress() {
    return this.macAddress != null;
  }
  
  public boolean hasMatchingAllowedAddressPair(Predicate<AddressPairBuilder> predicate) {
      for (AddressPairBuilder item : allowedAddressPairs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFixedIP(Predicate<FixedIPsBuilder> predicate) {
      for (FixedIPsBuilder item : fixedIPs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingSecurityGroup(Predicate<String> predicate) {
      for (String item : securityGroups) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTag(Predicate<String> predicate) {
      for (String item : tags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNameSuffix() {
    return this.nameSuffix != null;
  }
  
  public boolean hasNetworkID() {
    return this.networkID != null;
  }
  
  public boolean hasPortSecurity() {
    return this.portSecurity != null;
  }
  
  public boolean hasProfile() {
    return this.profile != null;
  }
  
  public boolean hasProjectID() {
    return this.projectID != null;
  }
  
  public boolean hasSecurityGroups() {
    return this.securityGroups != null && !(this.securityGroups.isEmpty());
  }
  
  public boolean hasTags() {
    return this.tags != null && !(this.tags.isEmpty());
  }
  
  public boolean hasTenantID() {
    return this.tenantID != null;
  }
  
  public boolean hasTrunk() {
    return this.trunk != null;
  }
  
  public boolean hasVnicType() {
    return this.vnicType != null;
  }
  
  public int hashCode() {
    return Objects.hash(adminStateUp, allowedAddressPairs, description, fixedIPs, hostID, macAddress, nameSuffix, networkID, portSecurity, profile, projectID, securityGroups, tags, tenantID, trunk, vnicType, additionalProperties);
  }
  
  public A removeAllFromAllowedAddressPairs(Collection<AddressPair> items) {
    if (this.allowedAddressPairs == null) {
      return (A) this;
    }
    for (AddressPair item : items) {
        AddressPairBuilder builder = new AddressPairBuilder(item);
        _visitables.get("allowedAddressPairs").remove(builder);
        this.allowedAddressPairs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFixedIPs(Collection<FixedIPs> items) {
    if (this.fixedIPs == null) {
      return (A) this;
    }
    for (FixedIPs item : items) {
        FixedIPsBuilder builder = new FixedIPsBuilder(item);
        _visitables.get("fixedIPs").remove(builder);
        this.fixedIPs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromSecurityGroups(Collection<String> items) {
    if (this.securityGroups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.securityGroups.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTags(Collection<String> items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tags.remove(item);
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
  
  public A removeFromAllowedAddressPairs(AddressPair... items) {
    if (this.allowedAddressPairs == null) {
      return (A) this;
    }
    for (AddressPair item : items) {
        AddressPairBuilder builder = new AddressPairBuilder(item);
        _visitables.get("allowedAddressPairs").remove(builder);
        this.allowedAddressPairs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromFixedIPs(FixedIPs... items) {
    if (this.fixedIPs == null) {
      return (A) this;
    }
    for (FixedIPs item : items) {
        FixedIPsBuilder builder = new FixedIPsBuilder(item);
        _visitables.get("fixedIPs").remove(builder);
        this.fixedIPs.remove(builder);
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
  
  public A removeFromSecurityGroups(String... items) {
    if (this.securityGroups == null) {
      return (A) this;
    }
    for (String item : items) {
      this.securityGroups.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTags(String... items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tags.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAllowedAddressPairs(Predicate<AddressPairBuilder> predicate) {
    if (allowedAddressPairs == null) {
      return (A) this;
    }
    Iterator<AddressPairBuilder> each = allowedAddressPairs.iterator();
    List visitables = _visitables.get("allowedAddressPairs");
    while (each.hasNext()) {
        AddressPairBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromFixedIPs(Predicate<FixedIPsBuilder> predicate) {
    if (fixedIPs == null) {
      return (A) this;
    }
    Iterator<FixedIPsBuilder> each = fixedIPs.iterator();
    List visitables = _visitables.get("fixedIPs");
    while (each.hasNext()) {
        FixedIPsBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AllowedAddressPairsNested<A> setNewAllowedAddressPairLike(int index,AddressPair item) {
    return new AllowedAddressPairsNested(index, item);
  }
  
  public FixedIPsNested<A> setNewFixedIPLike(int index,FixedIPs item) {
    return new FixedIPsNested(index, item);
  }
  
  public A setToAllowedAddressPairs(int index,AddressPair item) {
    if (this.allowedAddressPairs == null) {
      this.allowedAddressPairs = new ArrayList();
    }
    AddressPairBuilder builder = new AddressPairBuilder(item);
    if (index < 0 || index >= allowedAddressPairs.size()) {
        _visitables.get("allowedAddressPairs").add(builder);
        allowedAddressPairs.add(builder);
    } else {
        _visitables.get("allowedAddressPairs").add(builder);
        allowedAddressPairs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFixedIPs(int index,FixedIPs item) {
    if (this.fixedIPs == null) {
      this.fixedIPs = new ArrayList();
    }
    FixedIPsBuilder builder = new FixedIPsBuilder(item);
    if (index < 0 || index >= fixedIPs.size()) {
        _visitables.get("fixedIPs").add(builder);
        fixedIPs.add(builder);
    } else {
        _visitables.get("fixedIPs").add(builder);
        fixedIPs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToSecurityGroups(int index,String item) {
    if (this.securityGroups == null) {
      this.securityGroups = new ArrayList();
    }
    this.securityGroups.set(index, item);
    return (A) this;
  }
  
  public A setToTags(int index,String item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    this.tags.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(adminStateUp == null)) {
        sb.append("adminStateUp:");
        sb.append(adminStateUp);
        sb.append(",");
    }
    if (!(allowedAddressPairs == null) && !(allowedAddressPairs.isEmpty())) {
        sb.append("allowedAddressPairs:");
        sb.append(allowedAddressPairs);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(fixedIPs == null) && !(fixedIPs.isEmpty())) {
        sb.append("fixedIPs:");
        sb.append(fixedIPs);
        sb.append(",");
    }
    if (!(hostID == null)) {
        sb.append("hostID:");
        sb.append(hostID);
        sb.append(",");
    }
    if (!(macAddress == null)) {
        sb.append("macAddress:");
        sb.append(macAddress);
        sb.append(",");
    }
    if (!(nameSuffix == null)) {
        sb.append("nameSuffix:");
        sb.append(nameSuffix);
        sb.append(",");
    }
    if (!(networkID == null)) {
        sb.append("networkID:");
        sb.append(networkID);
        sb.append(",");
    }
    if (!(portSecurity == null)) {
        sb.append("portSecurity:");
        sb.append(portSecurity);
        sb.append(",");
    }
    if (!(profile == null) && !(profile.isEmpty())) {
        sb.append("profile:");
        sb.append(profile);
        sb.append(",");
    }
    if (!(projectID == null)) {
        sb.append("projectID:");
        sb.append(projectID);
        sb.append(",");
    }
    if (!(securityGroups == null) && !(securityGroups.isEmpty())) {
        sb.append("securityGroups:");
        sb.append(securityGroups);
        sb.append(",");
    }
    if (!(tags == null) && !(tags.isEmpty())) {
        sb.append("tags:");
        sb.append(tags);
        sb.append(",");
    }
    if (!(tenantID == null)) {
        sb.append("tenantID:");
        sb.append(tenantID);
        sb.append(",");
    }
    if (!(trunk == null)) {
        sb.append("trunk:");
        sb.append(trunk);
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
  
  public A withAdminStateUp() {
    return withAdminStateUp(true);
  }
  
  public A withAdminStateUp(Boolean adminStateUp) {
    this.adminStateUp = adminStateUp;
    return (A) this;
  }
  
  public A withAllowedAddressPairs(List<AddressPair> allowedAddressPairs) {
    if (this.allowedAddressPairs != null) {
      this._visitables.get("allowedAddressPairs").clear();
    }
    if (allowedAddressPairs != null) {
        this.allowedAddressPairs = new ArrayList();
        for (AddressPair item : allowedAddressPairs) {
          this.addToAllowedAddressPairs(item);
        }
    } else {
      this.allowedAddressPairs = null;
    }
    return (A) this;
  }
  
  public A withAllowedAddressPairs(AddressPair... allowedAddressPairs) {
    if (this.allowedAddressPairs != null) {
        this.allowedAddressPairs.clear();
        _visitables.remove("allowedAddressPairs");
    }
    if (allowedAddressPairs != null) {
      for (AddressPair item : allowedAddressPairs) {
        this.addToAllowedAddressPairs(item);
      }
    }
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withFixedIPs(List<FixedIPs> fixedIPs) {
    if (this.fixedIPs != null) {
      this._visitables.get("fixedIPs").clear();
    }
    if (fixedIPs != null) {
        this.fixedIPs = new ArrayList();
        for (FixedIPs item : fixedIPs) {
          this.addToFixedIPs(item);
        }
    } else {
      this.fixedIPs = null;
    }
    return (A) this;
  }
  
  public A withFixedIPs(FixedIPs... fixedIPs) {
    if (this.fixedIPs != null) {
        this.fixedIPs.clear();
        _visitables.remove("fixedIPs");
    }
    if (fixedIPs != null) {
      for (FixedIPs item : fixedIPs) {
        this.addToFixedIPs(item);
      }
    }
    return (A) this;
  }
  
  public A withHostID(String hostID) {
    this.hostID = hostID;
    return (A) this;
  }
  
  public A withMacAddress(String macAddress) {
    this.macAddress = macAddress;
    return (A) this;
  }
  
  public A withNameSuffix(String nameSuffix) {
    this.nameSuffix = nameSuffix;
    return (A) this;
  }
  
  public A withNetworkID(String networkID) {
    this.networkID = networkID;
    return (A) this;
  }
  
  public A withPortSecurity() {
    return withPortSecurity(true);
  }
  
  public A withPortSecurity(Boolean portSecurity) {
    this.portSecurity = portSecurity;
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
  
  public A withProjectID(String projectID) {
    this.projectID = projectID;
    return (A) this;
  }
  
  public A withSecurityGroups(List<String> securityGroups) {
    if (securityGroups != null) {
        this.securityGroups = new ArrayList();
        for (String item : securityGroups) {
          this.addToSecurityGroups(item);
        }
    } else {
      this.securityGroups = null;
    }
    return (A) this;
  }
  
  public A withSecurityGroups(String... securityGroups) {
    if (this.securityGroups != null) {
        this.securityGroups.clear();
        _visitables.remove("securityGroups");
    }
    if (securityGroups != null) {
      for (String item : securityGroups) {
        this.addToSecurityGroups(item);
      }
    }
    return (A) this;
  }
  
  public A withTags(List<String> tags) {
    if (tags != null) {
        this.tags = new ArrayList();
        for (String item : tags) {
          this.addToTags(item);
        }
    } else {
      this.tags = null;
    }
    return (A) this;
  }
  
  public A withTags(String... tags) {
    if (this.tags != null) {
        this.tags.clear();
        _visitables.remove("tags");
    }
    if (tags != null) {
      for (String item : tags) {
        this.addToTags(item);
      }
    }
    return (A) this;
  }
  
  public A withTenantID(String tenantID) {
    this.tenantID = tenantID;
    return (A) this;
  }
  
  public A withTrunk() {
    return withTrunk(true);
  }
  
  public A withTrunk(Boolean trunk) {
    this.trunk = trunk;
    return (A) this;
  }
  
  public A withVnicType(String vnicType) {
    this.vnicType = vnicType;
    return (A) this;
  }
  public class AllowedAddressPairsNested<N> extends AddressPairFluent<AllowedAddressPairsNested<N>> implements Nested<N>{
  
    AddressPairBuilder builder;
    int index;
  
    AllowedAddressPairsNested(int index,AddressPair item) {
      this.index = index;
      this.builder = new AddressPairBuilder(this, item);
    }
  
    public N and() {
      return (N) PortOptsFluent.this.setToAllowedAddressPairs(index, builder.build());
    }
    
    public N endAllowedAddressPair() {
      return and();
    }
    
  }
  public class FixedIPsNested<N> extends FixedIPsFluent<FixedIPsNested<N>> implements Nested<N>{
  
    FixedIPsBuilder builder;
    int index;
  
    FixedIPsNested(int index,FixedIPs item) {
      this.index = index;
      this.builder = new FixedIPsBuilder(this, item);
    }
  
    public N and() {
      return (N) PortOptsFluent.this.setToFixedIPs(index, builder.build());
    }
    
    public N endFixedIP() {
      return and();
    }
    
  }
}