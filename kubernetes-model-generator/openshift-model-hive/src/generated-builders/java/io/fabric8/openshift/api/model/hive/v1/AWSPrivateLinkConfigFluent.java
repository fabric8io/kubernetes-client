package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceBuilder;
import io.fabric8.kubernetes.api.model.LocalObjectReferenceFluent;
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
public class AWSPrivateLinkConfigFluent<A extends io.fabric8.openshift.api.model.hive.v1.AWSPrivateLinkConfigFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<AWSAssociatedVPCBuilder> associatedVPCs = new ArrayList<AWSAssociatedVPCBuilder>();
  private LocalObjectReferenceBuilder credentialsSecretRef;
  private String dnsRecordType;
  private ArrayList<AWSPrivateLinkInventoryBuilder> endpointVPCInventory = new ArrayList<AWSPrivateLinkInventoryBuilder>();

  public AWSPrivateLinkConfigFluent() {
  }
  
  public AWSPrivateLinkConfigFluent(AWSPrivateLinkConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToAssociatedVPCs(Collection<AWSAssociatedVPC> items) {
    if (this.associatedVPCs == null) {
      this.associatedVPCs = new ArrayList();
    }
    for (AWSAssociatedVPC item : items) {
        AWSAssociatedVPCBuilder builder = new AWSAssociatedVPCBuilder(item);
        _visitables.get("associatedVPCs").add(builder);
        this.associatedVPCs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToEndpointVPCInventory(Collection<AWSPrivateLinkInventory> items) {
    if (this.endpointVPCInventory == null) {
      this.endpointVPCInventory = new ArrayList();
    }
    for (AWSPrivateLinkInventory item : items) {
        AWSPrivateLinkInventoryBuilder builder = new AWSPrivateLinkInventoryBuilder(item);
        _visitables.get("endpointVPCInventory").add(builder);
        this.endpointVPCInventory.add(builder);
    }
    return (A) this;
  }
  
  public AssociatedVPCsNested<A> addNewAssociatedVPC() {
    return new AssociatedVPCsNested(-1, null);
  }
  
  public AssociatedVPCsNested<A> addNewAssociatedVPCLike(AWSAssociatedVPC item) {
    return new AssociatedVPCsNested(-1, item);
  }
  
  public EndpointVPCInventoryNested<A> addNewEndpointVPCInventory() {
    return new EndpointVPCInventoryNested(-1, null);
  }
  
  public EndpointVPCInventoryNested<A> addNewEndpointVPCInventoryLike(AWSPrivateLinkInventory item) {
    return new EndpointVPCInventoryNested(-1, item);
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
  
  public A addToAssociatedVPCs(AWSAssociatedVPC... items) {
    if (this.associatedVPCs == null) {
      this.associatedVPCs = new ArrayList();
    }
    for (AWSAssociatedVPC item : items) {
        AWSAssociatedVPCBuilder builder = new AWSAssociatedVPCBuilder(item);
        _visitables.get("associatedVPCs").add(builder);
        this.associatedVPCs.add(builder);
    }
    return (A) this;
  }
  
  public A addToAssociatedVPCs(int index,AWSAssociatedVPC item) {
    if (this.associatedVPCs == null) {
      this.associatedVPCs = new ArrayList();
    }
    AWSAssociatedVPCBuilder builder = new AWSAssociatedVPCBuilder(item);
    if (index < 0 || index >= associatedVPCs.size()) {
        _visitables.get("associatedVPCs").add(builder);
        associatedVPCs.add(builder);
    } else {
        _visitables.get("associatedVPCs").add(builder);
        associatedVPCs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToEndpointVPCInventory(AWSPrivateLinkInventory... items) {
    if (this.endpointVPCInventory == null) {
      this.endpointVPCInventory = new ArrayList();
    }
    for (AWSPrivateLinkInventory item : items) {
        AWSPrivateLinkInventoryBuilder builder = new AWSPrivateLinkInventoryBuilder(item);
        _visitables.get("endpointVPCInventory").add(builder);
        this.endpointVPCInventory.add(builder);
    }
    return (A) this;
  }
  
  public A addToEndpointVPCInventory(int index,AWSPrivateLinkInventory item) {
    if (this.endpointVPCInventory == null) {
      this.endpointVPCInventory = new ArrayList();
    }
    AWSPrivateLinkInventoryBuilder builder = new AWSPrivateLinkInventoryBuilder(item);
    if (index < 0 || index >= endpointVPCInventory.size()) {
        _visitables.get("endpointVPCInventory").add(builder);
        endpointVPCInventory.add(builder);
    } else {
        _visitables.get("endpointVPCInventory").add(builder);
        endpointVPCInventory.add(index, builder);
    }
    return (A) this;
  }
  
  public AWSAssociatedVPC buildAssociatedVPC(int index) {
    return this.associatedVPCs.get(index).build();
  }
  
  public List<AWSAssociatedVPC> buildAssociatedVPCs() {
    return this.associatedVPCs != null ? build(associatedVPCs) : null;
  }
  
  public LocalObjectReference buildCredentialsSecretRef() {
    return this.credentialsSecretRef != null ? this.credentialsSecretRef.build() : null;
  }
  
  public List<AWSPrivateLinkInventory> buildEndpointVPCInventory() {
    return this.endpointVPCInventory != null ? build(endpointVPCInventory) : null;
  }
  
  public AWSPrivateLinkInventory buildEndpointVPCInventory(int index) {
    return this.endpointVPCInventory.get(index).build();
  }
  
  public AWSAssociatedVPC buildFirstAssociatedVPC() {
    return this.associatedVPCs.get(0).build();
  }
  
  public AWSPrivateLinkInventory buildFirstEndpointVPCInventory() {
    return this.endpointVPCInventory.get(0).build();
  }
  
  public AWSAssociatedVPC buildLastAssociatedVPC() {
    return this.associatedVPCs.get(associatedVPCs.size() - 1).build();
  }
  
  public AWSPrivateLinkInventory buildLastEndpointVPCInventory() {
    return this.endpointVPCInventory.get(endpointVPCInventory.size() - 1).build();
  }
  
  public AWSAssociatedVPC buildMatchingAssociatedVPC(Predicate<AWSAssociatedVPCBuilder> predicate) {
      for (AWSAssociatedVPCBuilder item : associatedVPCs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public AWSPrivateLinkInventory buildMatchingEndpointVPCInventory(Predicate<AWSPrivateLinkInventoryBuilder> predicate) {
      for (AWSPrivateLinkInventoryBuilder item : endpointVPCInventory) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(AWSPrivateLinkConfig instance) {
    instance = instance != null ? instance : new AWSPrivateLinkConfig();
    if (instance != null) {
        this.withAssociatedVPCs(instance.getAssociatedVPCs());
        this.withCredentialsSecretRef(instance.getCredentialsSecretRef());
        this.withDnsRecordType(instance.getDnsRecordType());
        this.withEndpointVPCInventory(instance.getEndpointVPCInventory());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AssociatedVPCsNested<A> editAssociatedVPC(int index) {
    if (associatedVPCs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "associatedVPCs"));
    }
    return this.setNewAssociatedVPCLike(index, this.buildAssociatedVPC(index));
  }
  
  public CredentialsSecretRefNested<A> editCredentialsSecretRef() {
    return this.withNewCredentialsSecretRefLike(Optional.ofNullable(this.buildCredentialsSecretRef()).orElse(null));
  }
  
  public EndpointVPCInventoryNested<A> editEndpointVPCInventory(int index) {
    if (endpointVPCInventory.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "endpointVPCInventory"));
    }
    return this.setNewEndpointVPCInventoryLike(index, this.buildEndpointVPCInventory(index));
  }
  
  public AssociatedVPCsNested<A> editFirstAssociatedVPC() {
    if (associatedVPCs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "associatedVPCs"));
    }
    return this.setNewAssociatedVPCLike(0, this.buildAssociatedVPC(0));
  }
  
  public EndpointVPCInventoryNested<A> editFirstEndpointVPCInventory() {
    if (endpointVPCInventory.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "endpointVPCInventory"));
    }
    return this.setNewEndpointVPCInventoryLike(0, this.buildEndpointVPCInventory(0));
  }
  
  public AssociatedVPCsNested<A> editLastAssociatedVPC() {
    int index = associatedVPCs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "associatedVPCs"));
    }
    return this.setNewAssociatedVPCLike(index, this.buildAssociatedVPC(index));
  }
  
  public EndpointVPCInventoryNested<A> editLastEndpointVPCInventory() {
    int index = endpointVPCInventory.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "endpointVPCInventory"));
    }
    return this.setNewEndpointVPCInventoryLike(index, this.buildEndpointVPCInventory(index));
  }
  
  public AssociatedVPCsNested<A> editMatchingAssociatedVPC(Predicate<AWSAssociatedVPCBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < associatedVPCs.size();i++) {
      if (predicate.test(associatedVPCs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "associatedVPCs"));
    }
    return this.setNewAssociatedVPCLike(index, this.buildAssociatedVPC(index));
  }
  
  public EndpointVPCInventoryNested<A> editMatchingEndpointVPCInventory(Predicate<AWSPrivateLinkInventoryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < endpointVPCInventory.size();i++) {
      if (predicate.test(endpointVPCInventory.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "endpointVPCInventory"));
    }
    return this.setNewEndpointVPCInventoryLike(index, this.buildEndpointVPCInventory(index));
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
    AWSPrivateLinkConfigFluent that = (AWSPrivateLinkConfigFluent) o;
    if (!(Objects.equals(associatedVPCs, that.associatedVPCs))) {
      return false;
    }
    if (!(Objects.equals(credentialsSecretRef, that.credentialsSecretRef))) {
      return false;
    }
    if (!(Objects.equals(dnsRecordType, that.dnsRecordType))) {
      return false;
    }
    if (!(Objects.equals(endpointVPCInventory, that.endpointVPCInventory))) {
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
  
  public String getDnsRecordType() {
    return this.dnsRecordType;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAssociatedVPCs() {
    return this.associatedVPCs != null && !(this.associatedVPCs.isEmpty());
  }
  
  public boolean hasCredentialsSecretRef() {
    return this.credentialsSecretRef != null;
  }
  
  public boolean hasDnsRecordType() {
    return this.dnsRecordType != null;
  }
  
  public boolean hasEndpointVPCInventory() {
    return this.endpointVPCInventory != null && !(this.endpointVPCInventory.isEmpty());
  }
  
  public boolean hasMatchingAssociatedVPC(Predicate<AWSAssociatedVPCBuilder> predicate) {
      for (AWSAssociatedVPCBuilder item : associatedVPCs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingEndpointVPCInventory(Predicate<AWSPrivateLinkInventoryBuilder> predicate) {
      for (AWSPrivateLinkInventoryBuilder item : endpointVPCInventory) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public int hashCode() {
    return Objects.hash(associatedVPCs, credentialsSecretRef, dnsRecordType, endpointVPCInventory, additionalProperties);
  }
  
  public A removeAllFromAssociatedVPCs(Collection<AWSAssociatedVPC> items) {
    if (this.associatedVPCs == null) {
      return (A) this;
    }
    for (AWSAssociatedVPC item : items) {
        AWSAssociatedVPCBuilder builder = new AWSAssociatedVPCBuilder(item);
        _visitables.get("associatedVPCs").remove(builder);
        this.associatedVPCs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromEndpointVPCInventory(Collection<AWSPrivateLinkInventory> items) {
    if (this.endpointVPCInventory == null) {
      return (A) this;
    }
    for (AWSPrivateLinkInventory item : items) {
        AWSPrivateLinkInventoryBuilder builder = new AWSPrivateLinkInventoryBuilder(item);
        _visitables.get("endpointVPCInventory").remove(builder);
        this.endpointVPCInventory.remove(builder);
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
  
  public A removeFromAssociatedVPCs(AWSAssociatedVPC... items) {
    if (this.associatedVPCs == null) {
      return (A) this;
    }
    for (AWSAssociatedVPC item : items) {
        AWSAssociatedVPCBuilder builder = new AWSAssociatedVPCBuilder(item);
        _visitables.get("associatedVPCs").remove(builder);
        this.associatedVPCs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromEndpointVPCInventory(AWSPrivateLinkInventory... items) {
    if (this.endpointVPCInventory == null) {
      return (A) this;
    }
    for (AWSPrivateLinkInventory item : items) {
        AWSPrivateLinkInventoryBuilder builder = new AWSPrivateLinkInventoryBuilder(item);
        _visitables.get("endpointVPCInventory").remove(builder);
        this.endpointVPCInventory.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAssociatedVPCs(Predicate<AWSAssociatedVPCBuilder> predicate) {
    if (associatedVPCs == null) {
      return (A) this;
    }
    Iterator<AWSAssociatedVPCBuilder> each = associatedVPCs.iterator();
    List visitables = _visitables.get("associatedVPCs");
    while (each.hasNext()) {
        AWSAssociatedVPCBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromEndpointVPCInventory(Predicate<AWSPrivateLinkInventoryBuilder> predicate) {
    if (endpointVPCInventory == null) {
      return (A) this;
    }
    Iterator<AWSPrivateLinkInventoryBuilder> each = endpointVPCInventory.iterator();
    List visitables = _visitables.get("endpointVPCInventory");
    while (each.hasNext()) {
        AWSPrivateLinkInventoryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AssociatedVPCsNested<A> setNewAssociatedVPCLike(int index,AWSAssociatedVPC item) {
    return new AssociatedVPCsNested(index, item);
  }
  
  public EndpointVPCInventoryNested<A> setNewEndpointVPCInventoryLike(int index,AWSPrivateLinkInventory item) {
    return new EndpointVPCInventoryNested(index, item);
  }
  
  public A setToAssociatedVPCs(int index,AWSAssociatedVPC item) {
    if (this.associatedVPCs == null) {
      this.associatedVPCs = new ArrayList();
    }
    AWSAssociatedVPCBuilder builder = new AWSAssociatedVPCBuilder(item);
    if (index < 0 || index >= associatedVPCs.size()) {
        _visitables.get("associatedVPCs").add(builder);
        associatedVPCs.add(builder);
    } else {
        _visitables.get("associatedVPCs").add(builder);
        associatedVPCs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToEndpointVPCInventory(int index,AWSPrivateLinkInventory item) {
    if (this.endpointVPCInventory == null) {
      this.endpointVPCInventory = new ArrayList();
    }
    AWSPrivateLinkInventoryBuilder builder = new AWSPrivateLinkInventoryBuilder(item);
    if (index < 0 || index >= endpointVPCInventory.size()) {
        _visitables.get("endpointVPCInventory").add(builder);
        endpointVPCInventory.add(builder);
    } else {
        _visitables.get("endpointVPCInventory").add(builder);
        endpointVPCInventory.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(associatedVPCs == null) && !(associatedVPCs.isEmpty())) {
        sb.append("associatedVPCs:");
        sb.append(associatedVPCs);
        sb.append(",");
    }
    if (!(credentialsSecretRef == null)) {
        sb.append("credentialsSecretRef:");
        sb.append(credentialsSecretRef);
        sb.append(",");
    }
    if (!(dnsRecordType == null)) {
        sb.append("dnsRecordType:");
        sb.append(dnsRecordType);
        sb.append(",");
    }
    if (!(endpointVPCInventory == null) && !(endpointVPCInventory.isEmpty())) {
        sb.append("endpointVPCInventory:");
        sb.append(endpointVPCInventory);
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
  
  public A withAssociatedVPCs(List<AWSAssociatedVPC> associatedVPCs) {
    if (this.associatedVPCs != null) {
      this._visitables.get("associatedVPCs").clear();
    }
    if (associatedVPCs != null) {
        this.associatedVPCs = new ArrayList();
        for (AWSAssociatedVPC item : associatedVPCs) {
          this.addToAssociatedVPCs(item);
        }
    } else {
      this.associatedVPCs = null;
    }
    return (A) this;
  }
  
  public A withAssociatedVPCs(AWSAssociatedVPC... associatedVPCs) {
    if (this.associatedVPCs != null) {
        this.associatedVPCs.clear();
        _visitables.remove("associatedVPCs");
    }
    if (associatedVPCs != null) {
      for (AWSAssociatedVPC item : associatedVPCs) {
        this.addToAssociatedVPCs(item);
      }
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
  
  public A withDnsRecordType(String dnsRecordType) {
    this.dnsRecordType = dnsRecordType;
    return (A) this;
  }
  
  public A withEndpointVPCInventory(List<AWSPrivateLinkInventory> endpointVPCInventory) {
    if (this.endpointVPCInventory != null) {
      this._visitables.get("endpointVPCInventory").clear();
    }
    if (endpointVPCInventory != null) {
        this.endpointVPCInventory = new ArrayList();
        for (AWSPrivateLinkInventory item : endpointVPCInventory) {
          this.addToEndpointVPCInventory(item);
        }
    } else {
      this.endpointVPCInventory = null;
    }
    return (A) this;
  }
  
  public A withEndpointVPCInventory(AWSPrivateLinkInventory... endpointVPCInventory) {
    if (this.endpointVPCInventory != null) {
        this.endpointVPCInventory.clear();
        _visitables.remove("endpointVPCInventory");
    }
    if (endpointVPCInventory != null) {
      for (AWSPrivateLinkInventory item : endpointVPCInventory) {
        this.addToEndpointVPCInventory(item);
      }
    }
    return (A) this;
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
  public class AssociatedVPCsNested<N> extends AWSAssociatedVPCFluent<AssociatedVPCsNested<N>> implements Nested<N>{
  
    AWSAssociatedVPCBuilder builder;
    int index;
  
    AssociatedVPCsNested(int index,AWSAssociatedVPC item) {
      this.index = index;
      this.builder = new AWSAssociatedVPCBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSPrivateLinkConfigFluent.this.setToAssociatedVPCs(index, builder.build());
    }
    
    public N endAssociatedVPC() {
      return and();
    }
    
  }
  public class CredentialsSecretRefNested<N> extends LocalObjectReferenceFluent<CredentialsSecretRefNested<N>> implements Nested<N>{
  
    LocalObjectReferenceBuilder builder;
  
    CredentialsSecretRefNested(LocalObjectReference item) {
      this.builder = new LocalObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSPrivateLinkConfigFluent.this.withCredentialsSecretRef(builder.build());
    }
    
    public N endCredentialsSecretRef() {
      return and();
    }
    
  }
  public class EndpointVPCInventoryNested<N> extends AWSPrivateLinkInventoryFluent<EndpointVPCInventoryNested<N>> implements Nested<N>{
  
    AWSPrivateLinkInventoryBuilder builder;
    int index;
  
    EndpointVPCInventoryNested(int index,AWSPrivateLinkInventory item) {
      this.index = index;
      this.builder = new AWSPrivateLinkInventoryBuilder(this, item);
    }
  
    public N and() {
      return (N) AWSPrivateLinkConfigFluent.this.setToEndpointVPCInventory(index, builder.build());
    }
    
    public N endEndpointVPCInventory() {
      return and();
    }
    
  }
}