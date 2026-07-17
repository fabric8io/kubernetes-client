package io.fabric8.openshift.api.model.installer.vsphere.v1;

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
public class MetadataFluent<A extends io.fabric8.openshift.api.model.installer.vsphere.v1.MetadataFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String password;
  private String terraformPlatform;
  private String username;
  private String vCenter;
  private ArrayList<VCentersBuilder> vCenters = new ArrayList<VCentersBuilder>();

  public MetadataFluent() {
  }
  
  public MetadataFluent(Metadata instance) {
    this.copyInstance(instance);
  }

  public A addAllToVCenters(Collection<VCenters> items) {
    if (this.vCenters == null) {
      this.vCenters = new ArrayList();
    }
    for (VCenters item : items) {
        VCentersBuilder builder = new VCentersBuilder(item);
        _visitables.get("vCenters").add(builder);
        this.vCenters.add(builder);
    }
    return (A) this;
  }
  
  public VCentersNested<A> addNewVCenter() {
    return new VCentersNested(-1, null);
  }
  
  public A addNewVCenter(String password,String username,String vCenter) {
    return (A) this.addToVCenters(new VCenters(password, username, vCenter));
  }
  
  public VCentersNested<A> addNewVCenterLike(VCenters item) {
    return new VCentersNested(-1, item);
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
  
  public A addToVCenters(VCenters... items) {
    if (this.vCenters == null) {
      this.vCenters = new ArrayList();
    }
    for (VCenters item : items) {
        VCentersBuilder builder = new VCentersBuilder(item);
        _visitables.get("vCenters").add(builder);
        this.vCenters.add(builder);
    }
    return (A) this;
  }
  
  public A addToVCenters(int index,VCenters item) {
    if (this.vCenters == null) {
      this.vCenters = new ArrayList();
    }
    VCentersBuilder builder = new VCentersBuilder(item);
    if (index < 0 || index >= vCenters.size()) {
        _visitables.get("vCenters").add(builder);
        vCenters.add(builder);
    } else {
        _visitables.get("vCenters").add(builder);
        vCenters.add(index, builder);
    }
    return (A) this;
  }
  
  public VCenters buildFirstVCenter() {
    return this.vCenters.get(0).build();
  }
  
  public VCenters buildLastVCenter() {
    return this.vCenters.get(vCenters.size() - 1).build();
  }
  
  public VCenters buildMatchingVCenter(Predicate<VCentersBuilder> predicate) {
      for (VCentersBuilder item : vCenters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public VCenters buildVCenter(int index) {
    return this.vCenters.get(index).build();
  }
  
  public List<VCenters> buildVCenters() {
    return this.vCenters != null ? build(vCenters) : null;
  }
  
  protected void copyInstance(Metadata instance) {
    instance = instance != null ? instance : new Metadata();
    if (instance != null) {
        this.withVCenters(instance.getVCenters());
        this.withPassword(instance.getPassword());
        this.withTerraformPlatform(instance.getTerraformPlatform());
        this.withUsername(instance.getUsername());
        this.withVCenter(instance.getVCenter());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public VCentersNested<A> editFirstVCenter() {
    if (vCenters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "vCenters"));
    }
    return this.setNewVCenterLike(0, this.buildVCenter(0));
  }
  
  public VCentersNested<A> editLastVCenter() {
    int index = vCenters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "vCenters"));
    }
    return this.setNewVCenterLike(index, this.buildVCenter(index));
  }
  
  public VCentersNested<A> editMatchingVCenter(Predicate<VCentersBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < vCenters.size();i++) {
      if (predicate.test(vCenters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "vCenters"));
    }
    return this.setNewVCenterLike(index, this.buildVCenter(index));
  }
  
  public VCentersNested<A> editVCenter(int index) {
    if (vCenters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "vCenters"));
    }
    return this.setNewVCenterLike(index, this.buildVCenter(index));
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
    MetadataFluent that = (MetadataFluent) o;
    if (!(Objects.equals(vCenters, that.vCenters))) {
      return false;
    }
    if (!(Objects.equals(password, that.password))) {
      return false;
    }
    if (!(Objects.equals(terraformPlatform, that.terraformPlatform))) {
      return false;
    }
    if (!(Objects.equals(username, that.username))) {
      return false;
    }
    if (!(Objects.equals(vCenter, that.vCenter))) {
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
  
  public String getPassword() {
    return this.password;
  }
  
  public String getTerraformPlatform() {
    return this.terraformPlatform;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public String getVCenter() {
    return this.vCenter;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasMatchingVCenter(Predicate<VCentersBuilder> predicate) {
      for (VCentersBuilder item : vCenters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasPassword() {
    return this.password != null;
  }
  
  public boolean hasTerraformPlatform() {
    return this.terraformPlatform != null;
  }
  
  public boolean hasUsername() {
    return this.username != null;
  }
  
  public boolean hasVCenter() {
    return this.vCenter != null;
  }
  
  public boolean hasVCenters() {
    return this.vCenters != null && !(this.vCenters.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(vCenters, password, terraformPlatform, username, vCenter, additionalProperties);
  }
  
  public A removeAllFromVCenters(Collection<VCenters> items) {
    if (this.vCenters == null) {
      return (A) this;
    }
    for (VCenters item : items) {
        VCentersBuilder builder = new VCentersBuilder(item);
        _visitables.get("vCenters").remove(builder);
        this.vCenters.remove(builder);
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
  
  public A removeFromVCenters(VCenters... items) {
    if (this.vCenters == null) {
      return (A) this;
    }
    for (VCenters item : items) {
        VCentersBuilder builder = new VCentersBuilder(item);
        _visitables.get("vCenters").remove(builder);
        this.vCenters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromVCenters(Predicate<VCentersBuilder> predicate) {
    if (vCenters == null) {
      return (A) this;
    }
    Iterator<VCentersBuilder> each = vCenters.iterator();
    List visitables = _visitables.get("vCenters");
    while (each.hasNext()) {
        VCentersBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public VCentersNested<A> setNewVCenterLike(int index,VCenters item) {
    return new VCentersNested(index, item);
  }
  
  public A setToVCenters(int index,VCenters item) {
    if (this.vCenters == null) {
      this.vCenters = new ArrayList();
    }
    VCentersBuilder builder = new VCentersBuilder(item);
    if (index < 0 || index >= vCenters.size()) {
        _visitables.get("vCenters").add(builder);
        vCenters.add(builder);
    } else {
        _visitables.get("vCenters").add(builder);
        vCenters.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(vCenters == null) && !(vCenters.isEmpty())) {
        sb.append("vCenters:");
        sb.append(vCenters);
        sb.append(",");
    }
    if (!(password == null)) {
        sb.append("password:");
        sb.append(password);
        sb.append(",");
    }
    if (!(terraformPlatform == null)) {
        sb.append("terraformPlatform:");
        sb.append(terraformPlatform);
        sb.append(",");
    }
    if (!(username == null)) {
        sb.append("username:");
        sb.append(username);
        sb.append(",");
    }
    if (!(vCenter == null)) {
        sb.append("vCenter:");
        sb.append(vCenter);
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
  
  public A withPassword(String password) {
    this.password = password;
    return (A) this;
  }
  
  public A withTerraformPlatform(String terraformPlatform) {
    this.terraformPlatform = terraformPlatform;
    return (A) this;
  }
  
  public A withUsername(String username) {
    this.username = username;
    return (A) this;
  }
  
  public A withVCenter(String vCenter) {
    this.vCenter = vCenter;
    return (A) this;
  }
  
  public A withVCenters(List<VCenters> vCenters) {
    if (this.vCenters != null) {
      this._visitables.get("vCenters").clear();
    }
    if (vCenters != null) {
        this.vCenters = new ArrayList();
        for (VCenters item : vCenters) {
          this.addToVCenters(item);
        }
    } else {
      this.vCenters = null;
    }
    return (A) this;
  }
  
  public A withVCenters(VCenters... vCenters) {
    if (this.vCenters != null) {
        this.vCenters.clear();
        _visitables.remove("vCenters");
    }
    if (vCenters != null) {
      for (VCenters item : vCenters) {
        this.addToVCenters(item);
      }
    }
    return (A) this;
  }
  public class VCentersNested<N> extends VCentersFluent<VCentersNested<N>> implements Nested<N>{
  
    VCentersBuilder builder;
    int index;
  
    VCentersNested(int index,VCenters item) {
      this.index = index;
      this.builder = new VCentersBuilder(this, item);
    }
  
    public N and() {
      return (N) MetadataFluent.this.setToVCenters(index, builder.build());
    }
    
    public N endVCenter() {
      return and();
    }
    
  }
}