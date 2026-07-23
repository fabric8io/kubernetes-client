package io.fabric8.openshift.api.model.hive.gcp.v1;

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
public class MachinePoolFluent<A extends io.fabric8.openshift.api.model.hive.gcp.v1.MachinePoolFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String networkProjectID;
  private String onHostMaintenance;
  private OSDiskBuilder osDisk;
  private String secureBoot;
  private String serviceAccount;
  private String type;
  private ArrayList<UserTagBuilder> userTags = new ArrayList<UserTagBuilder>();
  private List<String> zones = new ArrayList<String>();

  public MachinePoolFluent() {
  }
  
  public MachinePoolFluent(MachinePool instance) {
    this.copyInstance(instance);
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
  
  public A addAllToZones(Collection<String> items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (String item : items) {
      this.zones.add(item);
    }
    return (A) this;
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
  
  public A addToZones(String... items) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    for (String item : items) {
      this.zones.add(item);
    }
    return (A) this;
  }
  
  public A addToZones(int index,String item) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    this.zones.add(index, item);
    return (A) this;
  }
  
  public UserTag buildFirstUserTag() {
    return this.userTags.get(0).build();
  }
  
  public UserTag buildLastUserTag() {
    return this.userTags.get(userTags.size() - 1).build();
  }
  
  public UserTag buildMatchingUserTag(Predicate<UserTagBuilder> predicate) {
      for (UserTagBuilder item : userTags) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public OSDisk buildOsDisk() {
    return this.osDisk != null ? this.osDisk.build() : null;
  }
  
  public UserTag buildUserTag(int index) {
    return this.userTags.get(index).build();
  }
  
  public List<UserTag> buildUserTags() {
    return this.userTags != null ? build(userTags) : null;
  }
  
  protected void copyInstance(MachinePool instance) {
    instance = instance != null ? instance : new MachinePool();
    if (instance != null) {
        this.withNetworkProjectID(instance.getNetworkProjectID());
        this.withOnHostMaintenance(instance.getOnHostMaintenance());
        this.withOsDisk(instance.getOsDisk());
        this.withSecureBoot(instance.getSecureBoot());
        this.withServiceAccount(instance.getServiceAccount());
        this.withType(instance.getType());
        this.withUserTags(instance.getUserTags());
        this.withZones(instance.getZones());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public UserTagsNested<A> editFirstUserTag() {
    if (userTags.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "userTags"));
    }
    return this.setNewUserTagLike(0, this.buildUserTag(0));
  }
  
  public UserTagsNested<A> editLastUserTag() {
    int index = userTags.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "userTags"));
    }
    return this.setNewUserTagLike(index, this.buildUserTag(index));
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
  
  public OsDiskNested<A> editOrNewOsDisk() {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(new OSDiskBuilder().build()));
  }
  
  public OsDiskNested<A> editOrNewOsDiskLike(OSDisk item) {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(item));
  }
  
  public OsDiskNested<A> editOsDisk() {
    return this.withNewOsDiskLike(Optional.ofNullable(this.buildOsDisk()).orElse(null));
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
    MachinePoolFluent that = (MachinePoolFluent) o;
    if (!(Objects.equals(networkProjectID, that.networkProjectID))) {
      return false;
    }
    if (!(Objects.equals(onHostMaintenance, that.onHostMaintenance))) {
      return false;
    }
    if (!(Objects.equals(osDisk, that.osDisk))) {
      return false;
    }
    if (!(Objects.equals(secureBoot, that.secureBoot))) {
      return false;
    }
    if (!(Objects.equals(serviceAccount, that.serviceAccount))) {
      return false;
    }
    if (!(Objects.equals(type, that.type))) {
      return false;
    }
    if (!(Objects.equals(userTags, that.userTags))) {
      return false;
    }
    if (!(Objects.equals(zones, that.zones))) {
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
  
  public String getFirstZone() {
    return this.zones.get(0);
  }
  
  public String getLastZone() {
    return this.zones.get(zones.size() - 1);
  }
  
  public String getMatchingZone(Predicate<String> predicate) {
      for (String item : zones) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNetworkProjectID() {
    return this.networkProjectID;
  }
  
  public String getOnHostMaintenance() {
    return this.onHostMaintenance;
  }
  
  public String getSecureBoot() {
    return this.secureBoot;
  }
  
  public String getServiceAccount() {
    return this.serviceAccount;
  }
  
  public String getType() {
    return this.type;
  }
  
  public String getZone(int index) {
    return this.zones.get(index);
  }
  
  public List<String> getZones() {
    return this.zones;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingUserTag(Predicate<UserTagBuilder> predicate) {
      for (UserTagBuilder item : userTags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingZone(Predicate<String> predicate) {
      for (String item : zones) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNetworkProjectID() {
    return this.networkProjectID != null;
  }
  
  public boolean hasOnHostMaintenance() {
    return this.onHostMaintenance != null;
  }
  
  public boolean hasOsDisk() {
    return this.osDisk != null;
  }
  
  public boolean hasSecureBoot() {
    return this.secureBoot != null;
  }
  
  public boolean hasServiceAccount() {
    return this.serviceAccount != null;
  }
  
  public boolean hasType() {
    return this.type != null;
  }
  
  public boolean hasUserTags() {
    return this.userTags != null && !(this.userTags.isEmpty());
  }
  
  public boolean hasZones() {
    return this.zones != null && !(this.zones.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(networkProjectID, onHostMaintenance, osDisk, secureBoot, serviceAccount, type, userTags, zones, additionalProperties);
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
  
  public A removeAllFromZones(Collection<String> items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.zones.remove(item);
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
  
  public A removeFromZones(String... items) {
    if (this.zones == null) {
      return (A) this;
    }
    for (String item : items) {
      this.zones.remove(item);
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
  
  public UserTagsNested<A> setNewUserTagLike(int index,UserTag item) {
    return new UserTagsNested(index, item);
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
  
  public A setToZones(int index,String item) {
    if (this.zones == null) {
      this.zones = new ArrayList();
    }
    this.zones.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(networkProjectID == null)) {
        sb.append("networkProjectID:");
        sb.append(networkProjectID);
        sb.append(",");
    }
    if (!(onHostMaintenance == null)) {
        sb.append("onHostMaintenance:");
        sb.append(onHostMaintenance);
        sb.append(",");
    }
    if (!(osDisk == null)) {
        sb.append("osDisk:");
        sb.append(osDisk);
        sb.append(",");
    }
    if (!(secureBoot == null)) {
        sb.append("secureBoot:");
        sb.append(secureBoot);
        sb.append(",");
    }
    if (!(serviceAccount == null)) {
        sb.append("serviceAccount:");
        sb.append(serviceAccount);
        sb.append(",");
    }
    if (!(type == null)) {
        sb.append("type:");
        sb.append(type);
        sb.append(",");
    }
    if (!(userTags == null) && !(userTags.isEmpty())) {
        sb.append("userTags:");
        sb.append(userTags);
        sb.append(",");
    }
    if (!(zones == null) && !(zones.isEmpty())) {
        sb.append("zones:");
        sb.append(zones);
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
  
  public A withNetworkProjectID(String networkProjectID) {
    this.networkProjectID = networkProjectID;
    return (A) this;
  }
  
  public OsDiskNested<A> withNewOsDisk() {
    return new OsDiskNested(null);
  }
  
  public OsDiskNested<A> withNewOsDiskLike(OSDisk item) {
    return new OsDiskNested(item);
  }
  
  public A withOnHostMaintenance(String onHostMaintenance) {
    this.onHostMaintenance = onHostMaintenance;
    return (A) this;
  }
  
  public A withOsDisk(OSDisk osDisk) {
    this._visitables.remove("osDisk");
    if (osDisk != null) {
        this.osDisk = new OSDiskBuilder(osDisk);
        this._visitables.get("osDisk").add(this.osDisk);
    } else {
        this.osDisk = null;
        this._visitables.get("osDisk").remove(this.osDisk);
    }
    return (A) this;
  }
  
  public A withSecureBoot(String secureBoot) {
    this.secureBoot = secureBoot;
    return (A) this;
  }
  
  public A withServiceAccount(String serviceAccount) {
    this.serviceAccount = serviceAccount;
    return (A) this;
  }
  
  public A withType(String type) {
    this.type = type;
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
  
  public A withZones(List<String> zones) {
    if (zones != null) {
        this.zones = new ArrayList();
        for (String item : zones) {
          this.addToZones(item);
        }
    } else {
      this.zones = null;
    }
    return (A) this;
  }
  
  public A withZones(String... zones) {
    if (this.zones != null) {
        this.zones.clear();
        _visitables.remove("zones");
    }
    if (zones != null) {
      for (String item : zones) {
        this.addToZones(item);
      }
    }
    return (A) this;
  }
  public class OsDiskNested<N> extends OSDiskFluent<OsDiskNested<N>> implements Nested<N>{
  
    OSDiskBuilder builder;
  
    OsDiskNested(OSDisk item) {
      this.builder = new OSDiskBuilder(this, item);
    }
  
    public N and() {
      return (N) MachinePoolFluent.this.withOsDisk(builder.build());
    }
    
    public N endOsDisk() {
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
      return (N) MachinePoolFluent.this.setToUserTags(index, builder.build());
    }
    
    public N endUserTag() {
      return and();
    }
    
  }
}