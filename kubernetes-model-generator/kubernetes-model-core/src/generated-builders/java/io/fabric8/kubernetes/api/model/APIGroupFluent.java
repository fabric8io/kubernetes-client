package io.fabric8.kubernetes.api.model;

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
public class APIGroupFluent<A extends io.fabric8.kubernetes.api.model.APIGroupFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String apiVersion;
  private String kind;
  private String name;
  private GroupVersionForDiscoveryBuilder preferredVersion;
  private ArrayList<ServerAddressByClientCIDRBuilder> serverAddressByClientCIDRs = new ArrayList<ServerAddressByClientCIDRBuilder>();
  private ArrayList<GroupVersionForDiscoveryBuilder> versions = new ArrayList<GroupVersionForDiscoveryBuilder>();

  public APIGroupFluent() {
  }
  
  public APIGroupFluent(APIGroup instance) {
    this.copyInstance(instance);
  }

  public A addAllToServerAddressByClientCIDRs(Collection<ServerAddressByClientCIDR> items) {
    if (this.serverAddressByClientCIDRs == null) {
      this.serverAddressByClientCIDRs = new ArrayList();
    }
    for (ServerAddressByClientCIDR item : items) {
        ServerAddressByClientCIDRBuilder builder = new ServerAddressByClientCIDRBuilder(item);
        _visitables.get("serverAddressByClientCIDRs").add(builder);
        this.serverAddressByClientCIDRs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVersions(Collection<GroupVersionForDiscovery> items) {
    if (this.versions == null) {
      this.versions = new ArrayList();
    }
    for (GroupVersionForDiscovery item : items) {
        GroupVersionForDiscoveryBuilder builder = new GroupVersionForDiscoveryBuilder(item);
        _visitables.get("versions").add(builder);
        this.versions.add(builder);
    }
    return (A) this;
  }
  
  public ServerAddressByClientCIDRsNested<A> addNewServerAddressByClientCIDR() {
    return new ServerAddressByClientCIDRsNested(-1, null);
  }
  
  public A addNewServerAddressByClientCIDR(String clientCIDR,String serverAddress) {
    return (A) this.addToServerAddressByClientCIDRs(new ServerAddressByClientCIDR(clientCIDR, serverAddress));
  }
  
  public ServerAddressByClientCIDRsNested<A> addNewServerAddressByClientCIDRLike(ServerAddressByClientCIDR item) {
    return new ServerAddressByClientCIDRsNested(-1, item);
  }
  
  public VersionsNested<A> addNewVersion() {
    return new VersionsNested(-1, null);
  }
  
  public A addNewVersion(String groupVersion,String version) {
    return (A) this.addToVersions(new GroupVersionForDiscovery(groupVersion, version));
  }
  
  public VersionsNested<A> addNewVersionLike(GroupVersionForDiscovery item) {
    return new VersionsNested(-1, item);
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
  
  public A addToServerAddressByClientCIDRs(ServerAddressByClientCIDR... items) {
    if (this.serverAddressByClientCIDRs == null) {
      this.serverAddressByClientCIDRs = new ArrayList();
    }
    for (ServerAddressByClientCIDR item : items) {
        ServerAddressByClientCIDRBuilder builder = new ServerAddressByClientCIDRBuilder(item);
        _visitables.get("serverAddressByClientCIDRs").add(builder);
        this.serverAddressByClientCIDRs.add(builder);
    }
    return (A) this;
  }
  
  public A addToServerAddressByClientCIDRs(int index,ServerAddressByClientCIDR item) {
    if (this.serverAddressByClientCIDRs == null) {
      this.serverAddressByClientCIDRs = new ArrayList();
    }
    ServerAddressByClientCIDRBuilder builder = new ServerAddressByClientCIDRBuilder(item);
    if (index < 0 || index >= serverAddressByClientCIDRs.size()) {
        _visitables.get("serverAddressByClientCIDRs").add(builder);
        serverAddressByClientCIDRs.add(builder);
    } else {
        _visitables.get("serverAddressByClientCIDRs").add(builder);
        serverAddressByClientCIDRs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToVersions(GroupVersionForDiscovery... items) {
    if (this.versions == null) {
      this.versions = new ArrayList();
    }
    for (GroupVersionForDiscovery item : items) {
        GroupVersionForDiscoveryBuilder builder = new GroupVersionForDiscoveryBuilder(item);
        _visitables.get("versions").add(builder);
        this.versions.add(builder);
    }
    return (A) this;
  }
  
  public A addToVersions(int index,GroupVersionForDiscovery item) {
    if (this.versions == null) {
      this.versions = new ArrayList();
    }
    GroupVersionForDiscoveryBuilder builder = new GroupVersionForDiscoveryBuilder(item);
    if (index < 0 || index >= versions.size()) {
        _visitables.get("versions").add(builder);
        versions.add(builder);
    } else {
        _visitables.get("versions").add(builder);
        versions.add(index, builder);
    }
    return (A) this;
  }
  
  public ServerAddressByClientCIDR buildFirstServerAddressByClientCIDR() {
    return this.serverAddressByClientCIDRs.get(0).build();
  }
  
  public GroupVersionForDiscovery buildFirstVersion() {
    return this.versions.get(0).build();
  }
  
  public ServerAddressByClientCIDR buildLastServerAddressByClientCIDR() {
    return this.serverAddressByClientCIDRs.get(serverAddressByClientCIDRs.size() - 1).build();
  }
  
  public GroupVersionForDiscovery buildLastVersion() {
    return this.versions.get(versions.size() - 1).build();
  }
  
  public ServerAddressByClientCIDR buildMatchingServerAddressByClientCIDR(Predicate<ServerAddressByClientCIDRBuilder> predicate) {
      for (ServerAddressByClientCIDRBuilder item : serverAddressByClientCIDRs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GroupVersionForDiscovery buildMatchingVersion(Predicate<GroupVersionForDiscoveryBuilder> predicate) {
      for (GroupVersionForDiscoveryBuilder item : versions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GroupVersionForDiscovery buildPreferredVersion() {
    return this.preferredVersion != null ? this.preferredVersion.build() : null;
  }
  
  public ServerAddressByClientCIDR buildServerAddressByClientCIDR(int index) {
    return this.serverAddressByClientCIDRs.get(index).build();
  }
  
  public List<ServerAddressByClientCIDR> buildServerAddressByClientCIDRs() {
    return this.serverAddressByClientCIDRs != null ? build(serverAddressByClientCIDRs) : null;
  }
  
  public GroupVersionForDiscovery buildVersion(int index) {
    return this.versions.get(index).build();
  }
  
  public List<GroupVersionForDiscovery> buildVersions() {
    return this.versions != null ? build(versions) : null;
  }
  
  protected void copyInstance(APIGroup instance) {
    instance = instance != null ? instance : new APIGroup();
    if (instance != null) {
        this.withApiVersion(instance.getApiVersion());
        this.withKind(instance.getKind());
        this.withName(instance.getName());
        this.withPreferredVersion(instance.getPreferredVersion());
        this.withServerAddressByClientCIDRs(instance.getServerAddressByClientCIDRs());
        this.withVersions(instance.getVersions());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ServerAddressByClientCIDRsNested<A> editFirstServerAddressByClientCIDR() {
    if (serverAddressByClientCIDRs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "serverAddressByClientCIDRs"));
    }
    return this.setNewServerAddressByClientCIDRLike(0, this.buildServerAddressByClientCIDR(0));
  }
  
  public VersionsNested<A> editFirstVersion() {
    if (versions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "versions"));
    }
    return this.setNewVersionLike(0, this.buildVersion(0));
  }
  
  public ServerAddressByClientCIDRsNested<A> editLastServerAddressByClientCIDR() {
    int index = serverAddressByClientCIDRs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "serverAddressByClientCIDRs"));
    }
    return this.setNewServerAddressByClientCIDRLike(index, this.buildServerAddressByClientCIDR(index));
  }
  
  public VersionsNested<A> editLastVersion() {
    int index = versions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "versions"));
    }
    return this.setNewVersionLike(index, this.buildVersion(index));
  }
  
  public ServerAddressByClientCIDRsNested<A> editMatchingServerAddressByClientCIDR(Predicate<ServerAddressByClientCIDRBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < serverAddressByClientCIDRs.size();i++) {
      if (predicate.test(serverAddressByClientCIDRs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "serverAddressByClientCIDRs"));
    }
    return this.setNewServerAddressByClientCIDRLike(index, this.buildServerAddressByClientCIDR(index));
  }
  
  public VersionsNested<A> editMatchingVersion(Predicate<GroupVersionForDiscoveryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < versions.size();i++) {
      if (predicate.test(versions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "versions"));
    }
    return this.setNewVersionLike(index, this.buildVersion(index));
  }
  
  public PreferredVersionNested<A> editOrNewPreferredVersion() {
    return this.withNewPreferredVersionLike(Optional.ofNullable(this.buildPreferredVersion()).orElse(new GroupVersionForDiscoveryBuilder().build()));
  }
  
  public PreferredVersionNested<A> editOrNewPreferredVersionLike(GroupVersionForDiscovery item) {
    return this.withNewPreferredVersionLike(Optional.ofNullable(this.buildPreferredVersion()).orElse(item));
  }
  
  public PreferredVersionNested<A> editPreferredVersion() {
    return this.withNewPreferredVersionLike(Optional.ofNullable(this.buildPreferredVersion()).orElse(null));
  }
  
  public ServerAddressByClientCIDRsNested<A> editServerAddressByClientCIDR(int index) {
    if (serverAddressByClientCIDRs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "serverAddressByClientCIDRs"));
    }
    return this.setNewServerAddressByClientCIDRLike(index, this.buildServerAddressByClientCIDR(index));
  }
  
  public VersionsNested<A> editVersion(int index) {
    if (versions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "versions"));
    }
    return this.setNewVersionLike(index, this.buildVersion(index));
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
    APIGroupFluent that = (APIGroupFluent) o;
    if (!(Objects.equals(apiVersion, that.apiVersion))) {
      return false;
    }
    if (!(Objects.equals(kind, that.kind))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(preferredVersion, that.preferredVersion))) {
      return false;
    }
    if (!(Objects.equals(serverAddressByClientCIDRs, that.serverAddressByClientCIDRs))) {
      return false;
    }
    if (!(Objects.equals(versions, that.versions))) {
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
  
  public String getApiVersion() {
    return this.apiVersion;
  }
  
  public String getKind() {
    return this.kind;
  }
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiVersion() {
    return this.apiVersion != null;
  }
  
  public boolean hasKind() {
    return this.kind != null;
  }
  
  public boolean hasMatchingServerAddressByClientCIDR(Predicate<ServerAddressByClientCIDRBuilder> predicate) {
      for (ServerAddressByClientCIDRBuilder item : serverAddressByClientCIDRs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVersion(Predicate<GroupVersionForDiscoveryBuilder> predicate) {
      for (GroupVersionForDiscoveryBuilder item : versions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasPreferredVersion() {
    return this.preferredVersion != null;
  }
  
  public boolean hasServerAddressByClientCIDRs() {
    return this.serverAddressByClientCIDRs != null && !(this.serverAddressByClientCIDRs.isEmpty());
  }
  
  public boolean hasVersions() {
    return this.versions != null && !(this.versions.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(apiVersion, kind, name, preferredVersion, serverAddressByClientCIDRs, versions, additionalProperties);
  }
  
  public A removeAllFromServerAddressByClientCIDRs(Collection<ServerAddressByClientCIDR> items) {
    if (this.serverAddressByClientCIDRs == null) {
      return (A) this;
    }
    for (ServerAddressByClientCIDR item : items) {
        ServerAddressByClientCIDRBuilder builder = new ServerAddressByClientCIDRBuilder(item);
        _visitables.get("serverAddressByClientCIDRs").remove(builder);
        this.serverAddressByClientCIDRs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVersions(Collection<GroupVersionForDiscovery> items) {
    if (this.versions == null) {
      return (A) this;
    }
    for (GroupVersionForDiscovery item : items) {
        GroupVersionForDiscoveryBuilder builder = new GroupVersionForDiscoveryBuilder(item);
        _visitables.get("versions").remove(builder);
        this.versions.remove(builder);
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
  
  public A removeFromServerAddressByClientCIDRs(ServerAddressByClientCIDR... items) {
    if (this.serverAddressByClientCIDRs == null) {
      return (A) this;
    }
    for (ServerAddressByClientCIDR item : items) {
        ServerAddressByClientCIDRBuilder builder = new ServerAddressByClientCIDRBuilder(item);
        _visitables.get("serverAddressByClientCIDRs").remove(builder);
        this.serverAddressByClientCIDRs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromVersions(GroupVersionForDiscovery... items) {
    if (this.versions == null) {
      return (A) this;
    }
    for (GroupVersionForDiscovery item : items) {
        GroupVersionForDiscoveryBuilder builder = new GroupVersionForDiscoveryBuilder(item);
        _visitables.get("versions").remove(builder);
        this.versions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromServerAddressByClientCIDRs(Predicate<ServerAddressByClientCIDRBuilder> predicate) {
    if (serverAddressByClientCIDRs == null) {
      return (A) this;
    }
    Iterator<ServerAddressByClientCIDRBuilder> each = serverAddressByClientCIDRs.iterator();
    List visitables = _visitables.get("serverAddressByClientCIDRs");
    while (each.hasNext()) {
        ServerAddressByClientCIDRBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVersions(Predicate<GroupVersionForDiscoveryBuilder> predicate) {
    if (versions == null) {
      return (A) this;
    }
    Iterator<GroupVersionForDiscoveryBuilder> each = versions.iterator();
    List visitables = _visitables.get("versions");
    while (each.hasNext()) {
        GroupVersionForDiscoveryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ServerAddressByClientCIDRsNested<A> setNewServerAddressByClientCIDRLike(int index,ServerAddressByClientCIDR item) {
    return new ServerAddressByClientCIDRsNested(index, item);
  }
  
  public VersionsNested<A> setNewVersionLike(int index,GroupVersionForDiscovery item) {
    return new VersionsNested(index, item);
  }
  
  public A setToServerAddressByClientCIDRs(int index,ServerAddressByClientCIDR item) {
    if (this.serverAddressByClientCIDRs == null) {
      this.serverAddressByClientCIDRs = new ArrayList();
    }
    ServerAddressByClientCIDRBuilder builder = new ServerAddressByClientCIDRBuilder(item);
    if (index < 0 || index >= serverAddressByClientCIDRs.size()) {
        _visitables.get("serverAddressByClientCIDRs").add(builder);
        serverAddressByClientCIDRs.add(builder);
    } else {
        _visitables.get("serverAddressByClientCIDRs").add(builder);
        serverAddressByClientCIDRs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVersions(int index,GroupVersionForDiscovery item) {
    if (this.versions == null) {
      this.versions = new ArrayList();
    }
    GroupVersionForDiscoveryBuilder builder = new GroupVersionForDiscoveryBuilder(item);
    if (index < 0 || index >= versions.size()) {
        _visitables.get("versions").add(builder);
        versions.add(builder);
    } else {
        _visitables.get("versions").add(builder);
        versions.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(apiVersion == null)) {
        sb.append("apiVersion:");
        sb.append(apiVersion);
        sb.append(",");
    }
    if (!(kind == null)) {
        sb.append("kind:");
        sb.append(kind);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(preferredVersion == null)) {
        sb.append("preferredVersion:");
        sb.append(preferredVersion);
        sb.append(",");
    }
    if (!(serverAddressByClientCIDRs == null) && !(serverAddressByClientCIDRs.isEmpty())) {
        sb.append("serverAddressByClientCIDRs:");
        sb.append(serverAddressByClientCIDRs);
        sb.append(",");
    }
    if (!(versions == null) && !(versions.isEmpty())) {
        sb.append("versions:");
        sb.append(versions);
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
  
  public A withApiVersion(String apiVersion) {
    this.apiVersion = apiVersion;
    return (A) this;
  }
  
  public A withKind(String kind) {
    this.kind = kind;
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public PreferredVersionNested<A> withNewPreferredVersion() {
    return new PreferredVersionNested(null);
  }
  
  public A withNewPreferredVersion(String groupVersion,String version) {
    return (A) this.withPreferredVersion(new GroupVersionForDiscovery(groupVersion, version));
  }
  
  public PreferredVersionNested<A> withNewPreferredVersionLike(GroupVersionForDiscovery item) {
    return new PreferredVersionNested(item);
  }
  
  public A withPreferredVersion(GroupVersionForDiscovery preferredVersion) {
    this._visitables.remove("preferredVersion");
    if (preferredVersion != null) {
        this.preferredVersion = new GroupVersionForDiscoveryBuilder(preferredVersion);
        this._visitables.get("preferredVersion").add(this.preferredVersion);
    } else {
        this.preferredVersion = null;
        this._visitables.get("preferredVersion").remove(this.preferredVersion);
    }
    return (A) this;
  }
  
  public A withServerAddressByClientCIDRs(List<ServerAddressByClientCIDR> serverAddressByClientCIDRs) {
    if (this.serverAddressByClientCIDRs != null) {
      this._visitables.get("serverAddressByClientCIDRs").clear();
    }
    if (serverAddressByClientCIDRs != null) {
        this.serverAddressByClientCIDRs = new ArrayList();
        for (ServerAddressByClientCIDR item : serverAddressByClientCIDRs) {
          this.addToServerAddressByClientCIDRs(item);
        }
    } else {
      this.serverAddressByClientCIDRs = null;
    }
    return (A) this;
  }
  
  public A withServerAddressByClientCIDRs(ServerAddressByClientCIDR... serverAddressByClientCIDRs) {
    if (this.serverAddressByClientCIDRs != null) {
        this.serverAddressByClientCIDRs.clear();
        _visitables.remove("serverAddressByClientCIDRs");
    }
    if (serverAddressByClientCIDRs != null) {
      for (ServerAddressByClientCIDR item : serverAddressByClientCIDRs) {
        this.addToServerAddressByClientCIDRs(item);
      }
    }
    return (A) this;
  }
  
  public A withVersions(List<GroupVersionForDiscovery> versions) {
    if (this.versions != null) {
      this._visitables.get("versions").clear();
    }
    if (versions != null) {
        this.versions = new ArrayList();
        for (GroupVersionForDiscovery item : versions) {
          this.addToVersions(item);
        }
    } else {
      this.versions = null;
    }
    return (A) this;
  }
  
  public A withVersions(GroupVersionForDiscovery... versions) {
    if (this.versions != null) {
        this.versions.clear();
        _visitables.remove("versions");
    }
    if (versions != null) {
      for (GroupVersionForDiscovery item : versions) {
        this.addToVersions(item);
      }
    }
    return (A) this;
  }
  public class PreferredVersionNested<N> extends GroupVersionForDiscoveryFluent<PreferredVersionNested<N>> implements Nested<N>{
  
    GroupVersionForDiscoveryBuilder builder;
  
    PreferredVersionNested(GroupVersionForDiscovery item) {
      this.builder = new GroupVersionForDiscoveryBuilder(this, item);
    }
  
    public N and() {
      return (N) APIGroupFluent.this.withPreferredVersion(builder.build());
    }
    
    public N endPreferredVersion() {
      return and();
    }
    
  }
  public class ServerAddressByClientCIDRsNested<N> extends ServerAddressByClientCIDRFluent<ServerAddressByClientCIDRsNested<N>> implements Nested<N>{
  
    ServerAddressByClientCIDRBuilder builder;
    int index;
  
    ServerAddressByClientCIDRsNested(int index,ServerAddressByClientCIDR item) {
      this.index = index;
      this.builder = new ServerAddressByClientCIDRBuilder(this, item);
    }
  
    public N and() {
      return (N) APIGroupFluent.this.setToServerAddressByClientCIDRs(index, builder.build());
    }
    
    public N endServerAddressByClientCIDR() {
      return and();
    }
    
  }
  public class VersionsNested<N> extends GroupVersionForDiscoveryFluent<VersionsNested<N>> implements Nested<N>{
  
    GroupVersionForDiscoveryBuilder builder;
    int index;
  
    VersionsNested(int index,GroupVersionForDiscovery item) {
      this.index = index;
      this.builder = new GroupVersionForDiscoveryBuilder(this, item);
    }
  
    public N and() {
      return (N) APIGroupFluent.this.setToVersions(index, builder.build());
    }
    
    public N endVersion() {
      return and();
    }
    
  }
}