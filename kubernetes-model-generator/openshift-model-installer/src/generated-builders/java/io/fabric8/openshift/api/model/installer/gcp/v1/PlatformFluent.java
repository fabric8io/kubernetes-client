package io.fabric8.openshift.api.model.installer.gcp.v1;

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
public class PlatformFluent<A extends io.fabric8.openshift.api.model.installer.gcp.v1.PlatformFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String computeSubnet;
  private String controlPlaneSubnet;
  private MachinePoolBuilder defaultMachinePlatform;
  private DNSBuilder dns;
  private PSCEndpointBuilder endpoint;
  private String firewallRulesManagement;
  private String network;
  private String networkProjectID;
  private String projectID;
  private String region;
  private ArrayList<UserLabelBuilder> userLabels = new ArrayList<UserLabelBuilder>();
  private String userProvisionedDNS;
  private ArrayList<UserTagBuilder> userTags = new ArrayList<UserTagBuilder>();

  public PlatformFluent() {
  }
  
  public PlatformFluent(Platform instance) {
    this.copyInstance(instance);
  }

  public A addAllToUserLabels(Collection<UserLabel> items) {
    if (this.userLabels == null) {
      this.userLabels = new ArrayList();
    }
    for (UserLabel item : items) {
        UserLabelBuilder builder = new UserLabelBuilder(item);
        _visitables.get("userLabels").add(builder);
        this.userLabels.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToUserTags(Collection<UserTag> items) {
    if (this.userTags == null) {
      this.userTags = new ArrayList();
    }
    for (UserTag item : items) {
        UserTagBuilder builder = new UserTagBuilder(item);
        _visitables.get("userTags").add(builder);
        this.userTags.add(builder);
    }
    return (A) this;
  }
  
  public UserLabelsNested<A> addNewUserLabel() {
    return new UserLabelsNested(-1, null);
  }
  
  public A addNewUserLabel(String key,String value) {
    return (A) this.addToUserLabels(new UserLabel(key, value));
  }
  
  public UserLabelsNested<A> addNewUserLabelLike(UserLabel item) {
    return new UserLabelsNested(-1, item);
  }
  
  public UserTagsNested<A> addNewUserTag() {
    return new UserTagsNested(-1, null);
  }
  
  public A addNewUserTag(String key,String parentID,String value) {
    return (A) this.addToUserTags(new UserTag(key, parentID, value));
  }
  
  public UserTagsNested<A> addNewUserTagLike(UserTag item) {
    return new UserTagsNested(-1, item);
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
  
  public A addToUserLabels(UserLabel... items) {
    if (this.userLabels == null) {
      this.userLabels = new ArrayList();
    }
    for (UserLabel item : items) {
        UserLabelBuilder builder = new UserLabelBuilder(item);
        _visitables.get("userLabels").add(builder);
        this.userLabels.add(builder);
    }
    return (A) this;
  }
  
  public A addToUserLabels(int index,UserLabel item) {
    if (this.userLabels == null) {
      this.userLabels = new ArrayList();
    }
    UserLabelBuilder builder = new UserLabelBuilder(item);
    if (index < 0 || index >= userLabels.size()) {
        _visitables.get("userLabels").add(builder);
        userLabels.add(builder);
    } else {
        _visitables.get("userLabels").add(builder);
        userLabels.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToUserTags(UserTag... items) {
    if (this.userTags == null) {
      this.userTags = new ArrayList();
    }
    for (UserTag item : items) {
        UserTagBuilder builder = new UserTagBuilder(item);
        _visitables.get("userTags").add(builder);
        this.userTags.add(builder);
    }
    return (A) this;
  }
  
  public A addToUserTags(int index,UserTag item) {
    if (this.userTags == null) {
      this.userTags = new ArrayList();
    }
    UserTagBuilder builder = new UserTagBuilder(item);
    if (index < 0 || index >= userTags.size()) {
        _visitables.get("userTags").add(builder);
        userTags.add(builder);
    } else {
        _visitables.get("userTags").add(builder);
        userTags.add(index, builder);
    }
    return (A) this;
  }
  
  public MachinePool buildDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null ? this.defaultMachinePlatform.build() : null;
  }
  
  public DNS buildDns() {
    return this.dns != null ? this.dns.build() : null;
  }
  
  public PSCEndpoint buildEndpoint() {
    return this.endpoint != null ? this.endpoint.build() : null;
  }
  
  public UserLabel buildFirstUserLabel() {
    return this.userLabels.get(0).build();
  }
  
  public UserTag buildFirstUserTag() {
    return this.userTags.get(0).build();
  }
  
  public UserLabel buildLastUserLabel() {
    return this.userLabels.get(userLabels.size() - 1).build();
  }
  
  public UserTag buildLastUserTag() {
    return this.userTags.get(userTags.size() - 1).build();
  }
  
  public UserLabel buildMatchingUserLabel(Predicate<UserLabelBuilder> predicate) {
      for (UserLabelBuilder item : userLabels) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public UserTag buildMatchingUserTag(Predicate<UserTagBuilder> predicate) {
      for (UserTagBuilder item : userTags) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public UserLabel buildUserLabel(int index) {
    return this.userLabels.get(index).build();
  }
  
  public List<UserLabel> buildUserLabels() {
    return this.userLabels != null ? build(userLabels) : null;
  }
  
  public UserTag buildUserTag(int index) {
    return this.userTags.get(index).build();
  }
  
  public List<UserTag> buildUserTags() {
    return this.userTags != null ? build(userTags) : null;
  }
  
  protected void copyInstance(Platform instance) {
    instance = instance != null ? instance : new Platform();
    if (instance != null) {
        this.withComputeSubnet(instance.getComputeSubnet());
        this.withControlPlaneSubnet(instance.getControlPlaneSubnet());
        this.withDefaultMachinePlatform(instance.getDefaultMachinePlatform());
        this.withDns(instance.getDns());
        this.withEndpoint(instance.getEndpoint());
        this.withFirewallRulesManagement(instance.getFirewallRulesManagement());
        this.withNetwork(instance.getNetwork());
        this.withNetworkProjectID(instance.getNetworkProjectID());
        this.withProjectID(instance.getProjectID());
        this.withRegion(instance.getRegion());
        this.withUserLabels(instance.getUserLabels());
        this.withUserProvisionedDNS(instance.getUserProvisionedDNS());
        this.withUserTags(instance.getUserTags());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public DefaultMachinePlatformNested<A> editDefaultMachinePlatform() {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(null));
  }
  
  public DnsNested<A> editDns() {
    return this.withNewDnsLike(Optional.ofNullable(this.buildDns()).orElse(null));
  }
  
  public EndpointNested<A> editEndpoint() {
    return this.withNewEndpointLike(Optional.ofNullable(this.buildEndpoint()).orElse(null));
  }
  
  public UserLabelsNested<A> editFirstUserLabel() {
    if (userLabels.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "userLabels"));
    }
    return this.setNewUserLabelLike(0, this.buildUserLabel(0));
  }
  
  public UserTagsNested<A> editFirstUserTag() {
    if (userTags.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "userTags"));
    }
    return this.setNewUserTagLike(0, this.buildUserTag(0));
  }
  
  public UserLabelsNested<A> editLastUserLabel() {
    int index = userLabels.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "userLabels"));
    }
    return this.setNewUserLabelLike(index, this.buildUserLabel(index));
  }
  
  public UserTagsNested<A> editLastUserTag() {
    int index = userTags.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "userTags"));
    }
    return this.setNewUserTagLike(index, this.buildUserTag(index));
  }
  
  public UserLabelsNested<A> editMatchingUserLabel(Predicate<UserLabelBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < userLabels.size();i++) {
      if (predicate.test(userLabels.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "userLabels"));
    }
    return this.setNewUserLabelLike(index, this.buildUserLabel(index));
  }
  
  public UserTagsNested<A> editMatchingUserTag(Predicate<UserTagBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < userTags.size();i++) {
      if (predicate.test(userTags.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "userTags"));
    }
    return this.setNewUserTagLike(index, this.buildUserTag(index));
  }
  
  public DefaultMachinePlatformNested<A> editOrNewDefaultMachinePlatform() {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(new MachinePoolBuilder().build()));
  }
  
  public DefaultMachinePlatformNested<A> editOrNewDefaultMachinePlatformLike(MachinePool item) {
    return this.withNewDefaultMachinePlatformLike(Optional.ofNullable(this.buildDefaultMachinePlatform()).orElse(item));
  }
  
  public DnsNested<A> editOrNewDns() {
    return this.withNewDnsLike(Optional.ofNullable(this.buildDns()).orElse(new DNSBuilder().build()));
  }
  
  public DnsNested<A> editOrNewDnsLike(DNS item) {
    return this.withNewDnsLike(Optional.ofNullable(this.buildDns()).orElse(item));
  }
  
  public EndpointNested<A> editOrNewEndpoint() {
    return this.withNewEndpointLike(Optional.ofNullable(this.buildEndpoint()).orElse(new PSCEndpointBuilder().build()));
  }
  
  public EndpointNested<A> editOrNewEndpointLike(PSCEndpoint item) {
    return this.withNewEndpointLike(Optional.ofNullable(this.buildEndpoint()).orElse(item));
  }
  
  public UserLabelsNested<A> editUserLabel(int index) {
    if (userLabels.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "userLabels"));
    }
    return this.setNewUserLabelLike(index, this.buildUserLabel(index));
  }
  
  public UserTagsNested<A> editUserTag(int index) {
    if (userTags.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "userTags"));
    }
    return this.setNewUserTagLike(index, this.buildUserTag(index));
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
    PlatformFluent that = (PlatformFluent) o;
    if (!(Objects.equals(computeSubnet, that.computeSubnet))) {
      return false;
    }
    if (!(Objects.equals(controlPlaneSubnet, that.controlPlaneSubnet))) {
      return false;
    }
    if (!(Objects.equals(defaultMachinePlatform, that.defaultMachinePlatform))) {
      return false;
    }
    if (!(Objects.equals(dns, that.dns))) {
      return false;
    }
    if (!(Objects.equals(endpoint, that.endpoint))) {
      return false;
    }
    if (!(Objects.equals(firewallRulesManagement, that.firewallRulesManagement))) {
      return false;
    }
    if (!(Objects.equals(network, that.network))) {
      return false;
    }
    if (!(Objects.equals(networkProjectID, that.networkProjectID))) {
      return false;
    }
    if (!(Objects.equals(projectID, that.projectID))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
      return false;
    }
    if (!(Objects.equals(userLabels, that.userLabels))) {
      return false;
    }
    if (!(Objects.equals(userProvisionedDNS, that.userProvisionedDNS))) {
      return false;
    }
    if (!(Objects.equals(userTags, that.userTags))) {
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
  
  public String getComputeSubnet() {
    return this.computeSubnet;
  }
  
  public String getControlPlaneSubnet() {
    return this.controlPlaneSubnet;
  }
  
  public String getFirewallRulesManagement() {
    return this.firewallRulesManagement;
  }
  
  public String getNetwork() {
    return this.network;
  }
  
  public String getNetworkProjectID() {
    return this.networkProjectID;
  }
  
  public String getProjectID() {
    return this.projectID;
  }
  
  public String getRegion() {
    return this.region;
  }
  
  public String getUserProvisionedDNS() {
    return this.userProvisionedDNS;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasComputeSubnet() {
    return this.computeSubnet != null;
  }
  
  public boolean hasControlPlaneSubnet() {
    return this.controlPlaneSubnet != null;
  }
  
  public boolean hasDefaultMachinePlatform() {
    return this.defaultMachinePlatform != null;
  }
  
  public boolean hasDns() {
    return this.dns != null;
  }
  
  public boolean hasEndpoint() {
    return this.endpoint != null;
  }
  
  public boolean hasFirewallRulesManagement() {
    return this.firewallRulesManagement != null;
  }
  
  public boolean hasMatchingUserLabel(Predicate<UserLabelBuilder> predicate) {
      for (UserLabelBuilder item : userLabels) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingUserTag(Predicate<UserTagBuilder> predicate) {
      for (UserTagBuilder item : userTags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetwork() {
    return this.network != null;
  }
  
  public boolean hasNetworkProjectID() {
    return this.networkProjectID != null;
  }
  
  public boolean hasProjectID() {
    return this.projectID != null;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public boolean hasUserLabels() {
    return this.userLabels != null && !(this.userLabels.isEmpty());
  }
  
  public boolean hasUserProvisionedDNS() {
    return this.userProvisionedDNS != null;
  }
  
  public boolean hasUserTags() {
    return this.userTags != null && !(this.userTags.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(computeSubnet, controlPlaneSubnet, defaultMachinePlatform, dns, endpoint, firewallRulesManagement, network, networkProjectID, projectID, region, userLabels, userProvisionedDNS, userTags, additionalProperties);
  }
  
  public A removeAllFromUserLabels(Collection<UserLabel> items) {
    if (this.userLabels == null) {
      return (A) this;
    }
    for (UserLabel item : items) {
        UserLabelBuilder builder = new UserLabelBuilder(item);
        _visitables.get("userLabels").remove(builder);
        this.userLabels.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromUserTags(Collection<UserTag> items) {
    if (this.userTags == null) {
      return (A) this;
    }
    for (UserTag item : items) {
        UserTagBuilder builder = new UserTagBuilder(item);
        _visitables.get("userTags").remove(builder);
        this.userTags.remove(builder);
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
  
  public A removeFromUserLabels(UserLabel... items) {
    if (this.userLabels == null) {
      return (A) this;
    }
    for (UserLabel item : items) {
        UserLabelBuilder builder = new UserLabelBuilder(item);
        _visitables.get("userLabels").remove(builder);
        this.userLabels.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromUserTags(UserTag... items) {
    if (this.userTags == null) {
      return (A) this;
    }
    for (UserTag item : items) {
        UserTagBuilder builder = new UserTagBuilder(item);
        _visitables.get("userTags").remove(builder);
        this.userTags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromUserLabels(Predicate<UserLabelBuilder> predicate) {
    if (userLabels == null) {
      return (A) this;
    }
    Iterator<UserLabelBuilder> each = userLabels.iterator();
    List visitables = _visitables.get("userLabels");
    while (each.hasNext()) {
        UserLabelBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromUserTags(Predicate<UserTagBuilder> predicate) {
    if (userTags == null) {
      return (A) this;
    }
    Iterator<UserTagBuilder> each = userTags.iterator();
    List visitables = _visitables.get("userTags");
    while (each.hasNext()) {
        UserTagBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public UserLabelsNested<A> setNewUserLabelLike(int index,UserLabel item) {
    return new UserLabelsNested(index, item);
  }
  
  public UserTagsNested<A> setNewUserTagLike(int index,UserTag item) {
    return new UserTagsNested(index, item);
  }
  
  public A setToUserLabels(int index,UserLabel item) {
    if (this.userLabels == null) {
      this.userLabels = new ArrayList();
    }
    UserLabelBuilder builder = new UserLabelBuilder(item);
    if (index < 0 || index >= userLabels.size()) {
        _visitables.get("userLabels").add(builder);
        userLabels.add(builder);
    } else {
        _visitables.get("userLabels").add(builder);
        userLabels.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToUserTags(int index,UserTag item) {
    if (this.userTags == null) {
      this.userTags = new ArrayList();
    }
    UserTagBuilder builder = new UserTagBuilder(item);
    if (index < 0 || index >= userTags.size()) {
        _visitables.get("userTags").add(builder);
        userTags.add(builder);
    } else {
        _visitables.get("userTags").add(builder);
        userTags.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(computeSubnet == null)) {
        sb.append("computeSubnet:");
        sb.append(computeSubnet);
        sb.append(",");
    }
    if (!(controlPlaneSubnet == null)) {
        sb.append("controlPlaneSubnet:");
        sb.append(controlPlaneSubnet);
        sb.append(",");
    }
    if (!(defaultMachinePlatform == null)) {
        sb.append("defaultMachinePlatform:");
        sb.append(defaultMachinePlatform);
        sb.append(",");
    }
    if (!(dns == null)) {
        sb.append("dns:");
        sb.append(dns);
        sb.append(",");
    }
    if (!(endpoint == null)) {
        sb.append("endpoint:");
        sb.append(endpoint);
        sb.append(",");
    }
    if (!(firewallRulesManagement == null)) {
        sb.append("firewallRulesManagement:");
        sb.append(firewallRulesManagement);
        sb.append(",");
    }
    if (!(network == null)) {
        sb.append("network:");
        sb.append(network);
        sb.append(",");
    }
    if (!(networkProjectID == null)) {
        sb.append("networkProjectID:");
        sb.append(networkProjectID);
        sb.append(",");
    }
    if (!(projectID == null)) {
        sb.append("projectID:");
        sb.append(projectID);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
        sb.append(",");
    }
    if (!(userLabels == null) && !(userLabels.isEmpty())) {
        sb.append("userLabels:");
        sb.append(userLabels);
        sb.append(",");
    }
    if (!(userProvisionedDNS == null)) {
        sb.append("userProvisionedDNS:");
        sb.append(userProvisionedDNS);
        sb.append(",");
    }
    if (!(userTags == null) && !(userTags.isEmpty())) {
        sb.append("userTags:");
        sb.append(userTags);
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
  
  public A withComputeSubnet(String computeSubnet) {
    this.computeSubnet = computeSubnet;
    return (A) this;
  }
  
  public A withControlPlaneSubnet(String controlPlaneSubnet) {
    this.controlPlaneSubnet = controlPlaneSubnet;
    return (A) this;
  }
  
  public A withDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
    this._visitables.remove("defaultMachinePlatform");
    if (defaultMachinePlatform != null) {
        this.defaultMachinePlatform = new MachinePoolBuilder(defaultMachinePlatform);
        this._visitables.get("defaultMachinePlatform").add(this.defaultMachinePlatform);
    } else {
        this.defaultMachinePlatform = null;
        this._visitables.get("defaultMachinePlatform").remove(this.defaultMachinePlatform);
    }
    return (A) this;
  }
  
  public A withDns(DNS dns) {
    this._visitables.remove("dns");
    if (dns != null) {
        this.dns = new DNSBuilder(dns);
        this._visitables.get("dns").add(this.dns);
    } else {
        this.dns = null;
        this._visitables.get("dns").remove(this.dns);
    }
    return (A) this;
  }
  
  public A withEndpoint(PSCEndpoint endpoint) {
    this._visitables.remove("endpoint");
    if (endpoint != null) {
        this.endpoint = new PSCEndpointBuilder(endpoint);
        this._visitables.get("endpoint").add(this.endpoint);
    } else {
        this.endpoint = null;
        this._visitables.get("endpoint").remove(this.endpoint);
    }
    return (A) this;
  }
  
  public A withFirewallRulesManagement(String firewallRulesManagement) {
    this.firewallRulesManagement = firewallRulesManagement;
    return (A) this;
  }
  
  public A withNetwork(String network) {
    this.network = network;
    return (A) this;
  }
  
  public A withNetworkProjectID(String networkProjectID) {
    this.networkProjectID = networkProjectID;
    return (A) this;
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatform() {
    return new DefaultMachinePlatformNested(null);
  }
  
  public DefaultMachinePlatformNested<A> withNewDefaultMachinePlatformLike(MachinePool item) {
    return new DefaultMachinePlatformNested(item);
  }
  
  public DnsNested<A> withNewDns() {
    return new DnsNested(null);
  }
  
  public DnsNested<A> withNewDnsLike(DNS item) {
    return new DnsNested(item);
  }
  
  public EndpointNested<A> withNewEndpoint() {
    return new EndpointNested(null);
  }
  
  public A withNewEndpoint(Boolean clusterUseOnly,String name,String region) {
    return (A) this.withEndpoint(new PSCEndpoint(clusterUseOnly, name, region));
  }
  
  public EndpointNested<A> withNewEndpointLike(PSCEndpoint item) {
    return new EndpointNested(item);
  }
  
  public A withProjectID(String projectID) {
    this.projectID = projectID;
    return (A) this;
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  
  public A withUserLabels(List<UserLabel> userLabels) {
    if (this.userLabels != null) {
      this._visitables.get("userLabels").clear();
    }
    if (userLabels != null) {
        this.userLabels = new ArrayList();
        for (UserLabel item : userLabels) {
          this.addToUserLabels(item);
        }
    } else {
      this.userLabels = null;
    }
    return (A) this;
  }
  
  public A withUserLabels(UserLabel... userLabels) {
    if (this.userLabels != null) {
        this.userLabels.clear();
        _visitables.remove("userLabels");
    }
    if (userLabels != null) {
      for (UserLabel item : userLabels) {
        this.addToUserLabels(item);
      }
    }
    return (A) this;
  }
  
  public A withUserProvisionedDNS(String userProvisionedDNS) {
    this.userProvisionedDNS = userProvisionedDNS;
    return (A) this;
  }
  
  public A withUserTags(List<UserTag> userTags) {
    if (this.userTags != null) {
      this._visitables.get("userTags").clear();
    }
    if (userTags != null) {
        this.userTags = new ArrayList();
        for (UserTag item : userTags) {
          this.addToUserTags(item);
        }
    } else {
      this.userTags = null;
    }
    return (A) this;
  }
  
  public A withUserTags(UserTag... userTags) {
    if (this.userTags != null) {
        this.userTags.clear();
        _visitables.remove("userTags");
    }
    if (userTags != null) {
      for (UserTag item : userTags) {
        this.addToUserTags(item);
      }
    }
    return (A) this;
  }
  public class DefaultMachinePlatformNested<N> extends MachinePoolFluent<DefaultMachinePlatformNested<N>> implements Nested<N>{
  
    MachinePoolBuilder builder;
  
    DefaultMachinePlatformNested(MachinePool item) {
      this.builder = new MachinePoolBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withDefaultMachinePlatform(builder.build());
    }
    
    public N endDefaultMachinePlatform() {
      return and();
    }
    
  }
  public class DnsNested<N> extends DNSFluent<DnsNested<N>> implements Nested<N>{
  
    DNSBuilder builder;
  
    DnsNested(DNS item) {
      this.builder = new DNSBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withDns(builder.build());
    }
    
    public N endDns() {
      return and();
    }
    
  }
  public class EndpointNested<N> extends PSCEndpointFluent<EndpointNested<N>> implements Nested<N>{
  
    PSCEndpointBuilder builder;
  
    EndpointNested(PSCEndpoint item) {
      this.builder = new PSCEndpointBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.withEndpoint(builder.build());
    }
    
    public N endEndpoint() {
      return and();
    }
    
  }
  public class UserLabelsNested<N> extends UserLabelFluent<UserLabelsNested<N>> implements Nested<N>{
  
    UserLabelBuilder builder;
    int index;
  
    UserLabelsNested(int index,UserLabel item) {
      this.index = index;
      this.builder = new UserLabelBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.setToUserLabels(index, builder.build());
    }
    
    public N endUserLabel() {
      return and();
    }
    
  }
  public class UserTagsNested<N> extends UserTagFluent<UserTagsNested<N>> implements Nested<N>{
  
    UserTagBuilder builder;
    int index;
  
    UserTagsNested(int index,UserTag item) {
      this.index = index;
      this.builder = new UserTagBuilder(this, item);
    }
  
    public N and() {
      return (N) PlatformFluent.this.setToUserTags(index, builder.build());
    }
    
    public N endUserTag() {
      return and();
    }
    
  }
}