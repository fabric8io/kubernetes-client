package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
import io.fabric8.openshift.api.model.hive.aws.v1.AssumeRole;
import io.fabric8.openshift.api.model.hive.aws.v1.AssumeRoleBuilder;
import io.fabric8.openshift.api.model.hive.aws.v1.AssumeRoleFluent;
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
public class AWSDNSZoneSpecFluent<A extends io.fabric8.openshift.api.model.hive.v1.AWSDNSZoneSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<AWSResourceTagBuilder> additionalTags = new ArrayList<AWSResourceTagBuilder>();
  private AssumeRoleBuilder credentialsAssumeRole;
  private LocalObjectReferenceBuilder credentialsSecretRef;
  private String region;

  public AWSDNSZoneSpecFluent() {
  }
  
  public AWSDNSZoneSpecFluent(AWSDNSZoneSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalTags(Collection<AWSResourceTag> items) {
    if (this.additionalTags == null) {
      this.additionalTags = new ArrayList();
    }
    for (AWSResourceTag item : items) {
        AWSResourceTagBuilder builder = new AWSResourceTagBuilder(item);
        _visitables.get("additionalTags").add(builder);
        this.additionalTags.add(builder);
    }
    return (A) this;
  }
  
  public AdditionalTagsNested<A> addNewAdditionalTag() {
    return new AdditionalTagsNested(-1, null);
  }
  
  public A addNewAdditionalTag(String key,String value) {
    return (A) this.addToAdditionalTags(new AWSResourceTag(key, value));
  }
  
  public AdditionalTagsNested<A> addNewAdditionalTagLike(AWSResourceTag item) {
    return new AdditionalTagsNested(-1, item);
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
  
  public A addToAdditionalTags(AWSResourceTag... items) {
    if (this.additionalTags == null) {
      this.additionalTags = new ArrayList();
    }
    for (AWSResourceTag item : items) {
        AWSResourceTagBuilder builder = new AWSResourceTagBuilder(item);
        _visitables.get("additionalTags").add(builder);
        this.additionalTags.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalTags(int index,AWSResourceTag item) {
    if (this.additionalTags == null) {
      this.additionalTags = new ArrayList();
    }
    AWSResourceTagBuilder builder = new AWSResourceTagBuilder(item);
    if (index < 0 || index >= additionalTags.size()) {
        _visitables.get("additionalTags").add(builder);
        additionalTags.add(builder);
    } else {
        _visitables.get("additionalTags").add(builder);
        additionalTags.add(index, builder);
    }
    return (A) this;
  }
  
  public AWSResourceTag buildAdditionalTag(int index) {
    return this.additionalTags.get(index).build();
  }
  
  public List<AWSResourceTag> buildAdditionalTags() {
    return this.additionalTags != null ? build(additionalTags) : null;
  }
  
  public AssumeRole buildCredentialsAssumeRole() {
    return this.credentialsAssumeRole != null ? this.credentialsAssumeRole.build() : null;
  }
  
  public LocalObjectReference buildCredentialsSecretRef() {
    return this.credentialsSecretRef != null ? this.credentialsSecretRef.build() : null;
  }
  
  public AWSResourceTag buildFirstAdditionalTag() {
    return this.additionalTags.get(0).build();
  }
  
  public AWSResourceTag buildLastAdditionalTag() {
    return this.additionalTags.get(additionalTags.size() - 1).build();
  }
  
  public AWSResourceTag buildMatchingAdditionalTag(Predicate<AWSResourceTagBuilder> predicate) {
      for (AWSResourceTagBuilder item : additionalTags) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(AWSDNSZoneSpec instance) {
    instance = instance != null ? instance : new AWSDNSZoneSpec();
    if (instance != null) {
        this.withAdditionalTags(instance.getAdditionalTags());
        this.withCredentialsAssumeRole(instance.getCredentialsAssumeRole());
        this.withCredentialsSecretRef(instance.getCredentialsSecretRef());
        this.withRegion(instance.getRegion());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdditionalTagsNested<A> editAdditionalTag(int index) {
    if (additionalTags.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "additionalTags"));
    }
    return this.setNewAdditionalTagLike(index, this.buildAdditionalTag(index));
  }
  
  public CredentialsAssumeRoleNested<A> editCredentialsAssumeRole() {
    return this.withNewCredentialsAssumeRoleLike(Optional.ofNullable(this.buildCredentialsAssumeRole()).orElse(null));
  }
  
  public CredentialsSecretRefNested<A> editCredentialsSecretRef() {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(null));
  }
  
  public AdditionalTagsNested<A> editFirstAdditionalTag() {
    if (additionalTags.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "additionalTags"));
    }
    return this.setNewAdditionalTagLike(0, this.buildAdditionalTag(0));
  }
  
  public AdditionalTagsNested<A> editLastAdditionalTag() {
    int index = additionalTags.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "additionalTags"));
    }
    return this.setNewAdditionalTagLike(index, this.buildAdditionalTag(index));
  }
  
  public AdditionalTagsNested<A> editMatchingAdditionalTag(Predicate<AWSResourceTagBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < additionalTags.size();i++) {
      if (predicate.test(additionalTags.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "additionalTags"));
    }
    return this.setNewAdditionalTagLike(index, this.buildAdditionalTag(index));
  }
  
  public CredentialsAssumeRoleNested<A> editOrNewCredentialsAssumeRole() {
    return this.withNewCredentialsAssumeRoleLike(Optional.ofNullable(this.buildCredentialsAssumeRole()).orElse(new AssumeRoleBuilder().build()));
  }
  
  public CredentialsAssumeRoleNested<A> editOrNewCredentialsAssumeRoleLike(AssumeRole item) {
    return this.withNewCredentialsAssumeRoleLike(Optional.ofNullable(this.buildCredentialsAssumeRole()).orElse(item));
  }
  
  public CredentialsSecretRefNested<A> editOrNewCredentialsSecretRef() {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(new LocalObjectReferenceBuilder().build()));
  }
  
  public CredentialsSecretRefNested<A> editOrNewCredentialsSecretRefLike(LocalObjectReference item) {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(item));
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
    AWSDNSZoneSpecFluent that = (AWSDNSZoneSpecFluent) o;
    if (!(Objects.equals(additionalTags, that.additionalTags))) {
      return false;
    }
    if (!(Objects.equals(credentialsAssumeRole, that.credentialsAssumeRole))) {
      return false;
    }
    if (!(Objects.equals(credentialsSecretRef, that.credentialsSecretRef))) {
      return false;
    }
    if (!(Objects.equals(region, that.region))) {
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
  
  public String getRegion() {
    return this.region;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdditionalTags() {
    return this.additionalTags != null && !(this.additionalTags.isEmpty());
  }
  
  public boolean hasCredentialsAssumeRole() {
    return this.credentialsAssumeRole != null;
  }
  
  public boolean hasCredentialsSecretRef() {
    return this.credentialsSecretRef != null;
  }
  
  public boolean hasMatchingAdditionalTag(Predicate<AWSResourceTagBuilder> predicate) {
      for (AWSResourceTagBuilder item : additionalTags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRegion() {
    return this.region != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalTags, credentialsAssumeRole, credentialsSecretRef, region, additionalProperties);
  }
  
  public A removeAllFromAdditionalTags(Collection<AWSResourceTag> items) {
    if (this.additionalTags == null) {
      return (A) this;
    }
    for (AWSResourceTag item : items) {
        AWSResourceTagBuilder builder = new AWSResourceTagBuilder(item);
        _visitables.get("additionalTags").remove(builder);
        this.additionalTags.remove(builder);
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
  
  public A removeFromAdditionalTags(AWSResourceTag... items) {
    if (this.additionalTags == null) {
      return (A) this;
    }
    for (AWSResourceTag item : items) {
        AWSResourceTagBuilder builder = new AWSResourceTagBuilder(item);
        _visitables.get("additionalTags").remove(builder);
        this.additionalTags.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAdditionalTags(Predicate<AWSResourceTagBuilder> predicate) {
    if (additionalTags == null) {
      return (A) this;
    }
    Iterator<AWSResourceTagBuilder> each = additionalTags.iterator();
    List visitables = _visitables.get("additionalTags");
    while (each.hasNext()) {
        AWSResourceTagBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AdditionalTagsNested<A> setNewAdditionalTagLike(int index,AWSResourceTag item) {
    return new AdditionalTagsNested(index, item);
  }
  
  public A setToAdditionalTags(int index,AWSResourceTag item) {
    if (this.additionalTags == null) {
      this.additionalTags = new ArrayList();
    }
    AWSResourceTagBuilder builder = new AWSResourceTagBuilder(item);
    if (index < 0 || index >= additionalTags.size()) {
        _visitables.get("additionalTags").add(builder);
        additionalTags.add(builder);
    } else {
        _visitables.get("additionalTags").add(builder);
        additionalTags.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalTags == null) && !(additionalTags.isEmpty())) {
        sb.append("additionalTags:");
        sb.append(additionalTags);
        sb.append(",");
    }
    if (!(credentialsAssumeRole == null)) {
        sb.append("credentialsAssumeRole:");
        sb.append(credentialsAssumeRole);
        sb.append(",");
    }
    if (!(credentialsSecretRef == null)) {
        sb.append("credentialsSecretRef:");
        sb.append(credentialsSecretRef);
        sb.append(",");
    }
    if (!(region == null)) {
        sb.append("region:");
        sb.append(region);
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
  
  public A withAdditionalTags(List<AWSResourceTag> additionalTags) {
    if (this.additionalTags != null) {
      this._visitables.get("additionalTags").clear();
    }
    if (additionalTags != null) {
        this.additionalTags = new ArrayList();
        for (AWSResourceTag item : additionalTags) {
          this.addToAdditionalTags(item);
        }
    } else {
      this.additionalTags = null;
    }
    return (A) this;
  }
  
  public A withAdditionalTags(AWSResourceTag... additionalTags) {
    if (this.additionalTags != null) {
        this.additionalTags.clear();
        _visitables.remove("additionalTags");
    }
    if (additionalTags != null) {
      for (AWSResourceTag item : additionalTags) {
        this.addToAdditionalTags(item);
      }
    }
    return (A) this;
  }
  
  public A withCredentialsAssumeRole(AssumeRole credentialsAssumeRole) {
    this._visitables.remove("credentialsAssumeRole");
    if (credentialsAssumeRole != null) {
        this.credentialsAssumeRole = new AssumeRoleBuilder(credentialsAssumeRole);
        this._visitables.get("credentialsAssumeRole").add(this.credentialsAssumeRole);
    } else {
        this.credentialsAssumeRole = null;
        this._visitables.get("credentialsAssumeRole").remove(this.credentialsAssumeRole);
    }
    return (A) this;
  }
  
  public A withCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
    this._visitables.remove("credentialsSecretRef");
    if (credentialsSecretRef != null) {
        this.credentialsSecretRef = new LocalObjectReferenceBuilder(credentialsSecretRef);
        this._visitables.get("credentialsSecretRef").add(this.credentialsSecretRef);
    } else {
        this.credentialsSecretRef = null;
        this._visitables.get("credentialsSecretRef").remove(this.credentialsSecretRef);
    }
    return (A) this;
  }
  
  public CredentialsAssumeRoleNested<A> withNewCredentialsAssumeRole() {
    return new CredentialsAssumeRoleNested(null);
  }
  
  public A withNewCredentialsAssumeRole(String externalID,String roleARN) {
    return (A) this.withCredentialsAssumeRole(new AssumeRole(externalID, roleARN));
  }
  
  public CredentialsAssumeRoleNested<A> withNewCredentialsAssumeRoleLike(AssumeRole item) {
    return new CredentialsAssumeRoleNested(item);
  }
  
  public CredentialsSecretRefNested<A> withNewCredentialsSecretRef() {
    return new CredentialsSecretRefNested(null);
  }
  
  public A withNewCredentialsSecretRef(String name) {
    return (A) this.withCredentialsSecretRef(new LocalObjectReference(name));
  }
  
  public CredentialsSecretRefNested<A> withNewCredentialsSecretRefLike(LocalObjectReference item) {
    return new CredentialsSecretRefNested(item);
  }
  
  public A withRegion(String region) {
    this.region = region;
    return (A) this;
  }
  public class AdditionalTagsNested<N> extends AWSResourceTagFluent<AdditionalTagsNested<N>> implements Nested<N>{
  
    AWSResourceTagBuilder builder;
    int index;
  
    AdditionalTagsNested(int index,AWSResourceTag item) {
      this.index = index;
      this.builder = new AWSResourceTagBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSDNSZoneSpecFluent.this.setToAdditionalTags(index, builder.build());
    }
    
    public N endAdditionalTag() {
      return and();
    }
    
  }
  public class CredentialsAssumeRoleNested<N> extends AssumeRoleFluent<CredentialsAssumeRoleNested<N>> implements Nested<N>{
  
    AssumeRoleBuilder builder;
  
    CredentialsAssumeRoleNested(AssumeRole item) {
      this.builder = new AssumeRoleBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSDNSZoneSpecFluent.this.withCredentialsAssumeRole(builder.build());
    }
    
    public N endCredentialsAssumeRole() {
      return and();
    }
    
  }
  public class CredentialsSecretRefNested<N> extends LocalObjectReferenceFluent<CredentialsSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSDNSZoneSpecFluent.this.withCredentialsSecretRef(builder.build());
    }
    
    public N endCredentialsSecretRef() {
      return and();
    }
    
  }
}