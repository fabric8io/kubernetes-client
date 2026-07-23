package io.fabric8.openshift.api.model.hive.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Long;
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
public class DNSZoneStatusFluent<A extends io.fabric8.openshift.api.model.hive.v1.DNSZoneStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AWSDNSZoneStatusBuilder aws;
  private AzureDNSZoneStatusBuilder azure;
  private ArrayList<DNSZoneConditionBuilder> conditions = new ArrayList<DNSZoneConditionBuilder>();
  private GCPDNSZoneStatusBuilder gcp;
  private Long lastSyncGeneration;
  private String lastSyncTimestamp;
  private List<String> nameServers = new ArrayList<String>();

  public DNSZoneStatusFluent() {
  }
  
  public DNSZoneStatusFluent(DNSZoneStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<DNSZoneCondition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (DNSZoneCondition item : items) {
        DNSZoneConditionBuilder builder = new DNSZoneConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToNameServers(Collection<String> items) {
    if (this.nameServers == null) {
      this.nameServers = new ArrayList();
    }
    for (String item : items) {
      this.nameServers.add(item);
    }
    return (A) this;
  }
  
  public ConditionsNested<A> addNewCondition() {
    return new ConditionsNested(-1, null);
  }
  
  public ConditionsNested<A> addNewConditionLike(DNSZoneCondition item) {
    return new ConditionsNested(-1, item);
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
  
  public A addToConditions(DNSZoneCondition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (DNSZoneCondition item : items) {
        DNSZoneConditionBuilder builder = new DNSZoneConditionBuilder(item);
        _visitables.get("conditions").add(builder);
        this.conditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,DNSZoneCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    DNSZoneConditionBuilder builder = new DNSZoneConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToNameServers(String... items) {
    if (this.nameServers == null) {
      this.nameServers = new ArrayList();
    }
    for (String item : items) {
      this.nameServers.add(item);
    }
    return (A) this;
  }
  
  public A addToNameServers(int index,String item) {
    if (this.nameServers == null) {
      this.nameServers = new ArrayList();
    }
    this.nameServers.add(index, item);
    return (A) this;
  }
  
  public AWSDNSZoneStatus buildAws() {
    return this.aws != null ? this.aws.build() : null;
  }
  
  public AzureDNSZoneStatus buildAzure() {
    return this.azure != null ? this.azure.build() : null;
  }
  
  public DNSZoneCondition buildCondition(int index) {
    return this.conditions.get(index).build();
  }
  
  public List<DNSZoneCondition> buildConditions() {
    return this.conditions != null ? build(conditions) : null;
  }
  
  public DNSZoneCondition buildFirstCondition() {
    return this.conditions.get(0).build();
  }
  
  public GCPDNSZoneStatus buildGcp() {
    return this.gcp != null ? this.gcp.build() : null;
  }
  
  public DNSZoneCondition buildLastCondition() {
    return this.conditions.get(conditions.size() - 1).build();
  }
  
  public DNSZoneCondition buildMatchingCondition(Predicate<DNSZoneConditionBuilder> predicate) {
      for (DNSZoneConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(DNSZoneStatus instance) {
    instance = instance != null ? instance : new DNSZoneStatus();
    if (instance != null) {
        this.withAws(instance.getAws());
        this.withAzure(instance.getAzure());
        this.withConditions(instance.getConditions());
        this.withGcp(instance.getGcp());
        this.withLastSyncGeneration(instance.getLastSyncGeneration());
        this.withLastSyncTimestamp(instance.getLastSyncTimestamp());
        this.withNameServers(instance.getNameServers());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsNested<A> editAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(null));
  }
  
  public AzureNested<A> editAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(null));
  }
  
  public ConditionsNested<A> editCondition(int index) {
    if (conditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editFirstCondition() {
    if (conditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(0, this.buildCondition(0));
  }
  
  public GcpNested<A> editGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(null));
  }
  
  public ConditionsNested<A> editLastCondition() {
    int index = conditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public ConditionsNested<A> editMatchingCondition(Predicate<DNSZoneConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < conditions.size();i++) {
      if (predicate.test(conditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "conditions"));
    }
    return this.setNewConditionLike(index, this.buildCondition(index));
  }
  
  public AwsNested<A> editOrNewAws() {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(new AWSDNSZoneStatusBuilder().build()));
  }
  
  public AwsNested<A> editOrNewAwsLike(AWSDNSZoneStatus item) {
    return this.withNewAwsLike(Optional.ofNullable(this.buildAws()).orElse(item));
  }
  
  public AzureNested<A> editOrNewAzure() {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(new AzureDNSZoneStatusBuilder().build()));
  }
  
  public AzureNested<A> editOrNewAzureLike(AzureDNSZoneStatus item) {
    return this.withNewAzureLike(Optional.ofNullable(this.buildAzure()).orElse(item));
  }
  
  public GcpNested<A> editOrNewGcp() {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(new GCPDNSZoneStatusBuilder().build()));
  }
  
  public GcpNested<A> editOrNewGcpLike(GCPDNSZoneStatus item) {
    return this.withNewGcpLike(Optional.ofNullable(this.buildGcp()).orElse(item));
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
    DNSZoneStatusFluent that = (DNSZoneStatusFluent) o;
    if (!(Objects.equals(aws, that.aws))) {
      return false;
    }
    if (!(Objects.equals(azure, that.azure))) {
      return false;
    }
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(gcp, that.gcp))) {
      return false;
    }
    if (!(Objects.equals(lastSyncGeneration, that.lastSyncGeneration))) {
      return false;
    }
    if (!(Objects.equals(lastSyncTimestamp, that.lastSyncTimestamp))) {
      return false;
    }
    if (!(Objects.equals(nameServers, that.nameServers))) {
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
  
  public String getFirstNameServer() {
    return this.nameServers.get(0);
  }
  
  public String getLastNameServer() {
    return this.nameServers.get(nameServers.size() - 1);
  }
  
  public Long getLastSyncGeneration() {
    return this.lastSyncGeneration;
  }
  
  public String getLastSyncTimestamp() {
    return this.lastSyncTimestamp;
  }
  
  public String getMatchingNameServer(Predicate<String> predicate) {
      for (String item : nameServers) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getNameServer(int index) {
    return this.nameServers.get(index);
  }
  
  public List<String> getNameServers() {
    return this.nameServers;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAws() {
    return this.aws != null;
  }
  
  public boolean hasAzure() {
    return this.azure != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasGcp() {
    return this.gcp != null;
  }
  
  public boolean hasLastSyncGeneration() {
    return this.lastSyncGeneration != null;
  }
  
  public boolean hasLastSyncTimestamp() {
    return this.lastSyncTimestamp != null;
  }
  
  public boolean hasMatchingCondition(Predicate<DNSZoneConditionBuilder> predicate) {
      for (DNSZoneConditionBuilder item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNameServer(Predicate<String> predicate) {
      for (String item : nameServers) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNameServers() {
    return this.nameServers != null && !(this.nameServers.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(aws, azure, conditions, gcp, lastSyncGeneration, lastSyncTimestamp, nameServers, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<DNSZoneCondition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (DNSZoneCondition item : items) {
        DNSZoneConditionBuilder builder = new DNSZoneConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromNameServers(Collection<String> items) {
    if (this.nameServers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nameServers.remove(item);
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
  
  public A removeFromConditions(DNSZoneCondition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (DNSZoneCondition item : items) {
        DNSZoneConditionBuilder builder = new DNSZoneConditionBuilder(item);
        _visitables.get("conditions").remove(builder);
        this.conditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromNameServers(String... items) {
    if (this.nameServers == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nameServers.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromConditions(Predicate<DNSZoneConditionBuilder> predicate) {
    if (conditions == null) {
      return (A) this;
    }
    Iterator<DNSZoneConditionBuilder> each = conditions.iterator();
    List visitables = _visitables.get("conditions");
    while (each.hasNext()) {
        DNSZoneConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ConditionsNested<A> setNewConditionLike(int index,DNSZoneCondition item) {
    return new ConditionsNested(index, item);
  }
  
  public A setToConditions(int index,DNSZoneCondition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    DNSZoneConditionBuilder builder = new DNSZoneConditionBuilder(item);
    if (index < 0 || index >= conditions.size()) {
        _visitables.get("conditions").add(builder);
        conditions.add(builder);
    } else {
        _visitables.get("conditions").add(builder);
        conditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToNameServers(int index,String item) {
    if (this.nameServers == null) {
      this.nameServers = new ArrayList();
    }
    this.nameServers.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(aws == null)) {
        sb.append("aws:");
        sb.append(aws);
        sb.append(",");
    }
    if (!(azure == null)) {
        sb.append("azure:");
        sb.append(azure);
        sb.append(",");
    }
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(gcp == null)) {
        sb.append("gcp:");
        sb.append(gcp);
        sb.append(",");
    }
    if (!(lastSyncGeneration == null)) {
        sb.append("lastSyncGeneration:");
        sb.append(lastSyncGeneration);
        sb.append(",");
    }
    if (!(lastSyncTimestamp == null)) {
        sb.append("lastSyncTimestamp:");
        sb.append(lastSyncTimestamp);
        sb.append(",");
    }
    if (!(nameServers == null) && !(nameServers.isEmpty())) {
        sb.append("nameServers:");
        sb.append(nameServers);
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
  
  public A withAws(AWSDNSZoneStatus aws) {
    this._visitables.remove("aws");
    if (aws != null) {
        this.aws = new AWSDNSZoneStatusBuilder(aws);
        this._visitables.get("aws").add(this.aws);
    } else {
        this.aws = null;
        this._visitables.get("aws").remove(this.aws);
    }
    return (A) this;
  }
  
  public A withAzure(AzureDNSZoneStatus azure) {
    this._visitables.remove("azure");
    if (azure != null) {
        this.azure = new AzureDNSZoneStatusBuilder(azure);
        this._visitables.get("azure").add(this.azure);
    } else {
        this.azure = null;
        this._visitables.get("azure").remove(this.azure);
    }
    return (A) this;
  }
  
  public A withConditions(List<DNSZoneCondition> conditions) {
    if (this.conditions != null) {
      this._visitables.get("conditions").clear();
    }
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (DNSZoneCondition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(DNSZoneCondition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (DNSZoneCondition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withGcp(GCPDNSZoneStatus gcp) {
    this._visitables.remove("gcp");
    if (gcp != null) {
        this.gcp = new GCPDNSZoneStatusBuilder(gcp);
        this._visitables.get("gcp").add(this.gcp);
    } else {
        this.gcp = null;
        this._visitables.get("gcp").remove(this.gcp);
    }
    return (A) this;
  }
  
  public A withLastSyncGeneration(Long lastSyncGeneration) {
    this.lastSyncGeneration = lastSyncGeneration;
    return (A) this;
  }
  
  public A withLastSyncTimestamp(String lastSyncTimestamp) {
    this.lastSyncTimestamp = lastSyncTimestamp;
    return (A) this;
  }
  
  public A withNameServers(List<String> nameServers) {
    if (nameServers != null) {
        this.nameServers = new ArrayList();
        for (String item : nameServers) {
          this.addToNameServers(item);
        }
    } else {
      this.nameServers = null;
    }
    return (A) this;
  }
  
  public A withNameServers(String... nameServers) {
    if (this.nameServers != null) {
        this.nameServers.clear();
        _visitables.remove("nameServers");
    }
    if (nameServers != null) {
      for (String item : nameServers) {
        this.addToNameServers(item);
      }
    }
    return (A) this;
  }
  
  public AwsNested<A> withNewAws() {
    return new AwsNested(null);
  }
  
  public A withNewAws(String zoneID) {
    return (A) this.withAws(new AWSDNSZoneStatus(zoneID));
  }
  
  public AwsNested<A> withNewAwsLike(AWSDNSZoneStatus item) {
    return new AwsNested(item);
  }
  
  public AzureNested<A> withNewAzure() {
    return new AzureNested(null);
  }
  
  public AzureNested<A> withNewAzureLike(AzureDNSZoneStatus item) {
    return new AzureNested(item);
  }
  
  public GcpNested<A> withNewGcp() {
    return new GcpNested(null);
  }
  
  public A withNewGcp(String zoneName) {
    return (A) this.withGcp(new GCPDNSZoneStatus(zoneName));
  }
  
  public GcpNested<A> withNewGcpLike(GCPDNSZoneStatus item) {
    return new GcpNested(item);
  }
  public class AwsNested<N> extends AWSDNSZoneStatusFluent<AwsNested<N>> implements Nested<N>{
  
    AWSDNSZoneStatusBuilder builder;
  
    AwsNested(AWSDNSZoneStatus item) {
      this.builder = new AWSDNSZoneStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSZoneStatusFluent.this.withAws(builder.build());
    }
    
    public N endAws() {
      return and();
    }
    
  }
  public class AzureNested<N> extends AzureDNSZoneStatusFluent<AzureNested<N>> implements Nested<N>{
  
    AzureDNSZoneStatusBuilder builder;
  
    AzureNested(AzureDNSZoneStatus item) {
      this.builder = new AzureDNSZoneStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSZoneStatusFluent.this.withAzure(builder.build());
    }
    
    public N endAzure() {
      return and();
    }
    
  }
  public class ConditionsNested<N> extends DNSZoneConditionFluent<ConditionsNested<N>> implements Nested<N>{
  
    DNSZoneConditionBuilder builder;
    int index;
  
    ConditionsNested(int index,DNSZoneCondition item) {
      this.index = index;
      this.builder = new DNSZoneConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSZoneStatusFluent.this.setToConditions(index, builder.build());
    }
    
    public N endCondition() {
      return and();
    }
    
  }
  public class GcpNested<N> extends GCPDNSZoneStatusFluent<GcpNested<N>> implements Nested<N>{
  
    GCPDNSZoneStatusBuilder builder;
  
    GcpNested(GCPDNSZoneStatus item) {
      this.builder = new GCPDNSZoneStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) DNSZoneStatusFluent.this.withGcp(builder.build());
    }
    
    public N endGcp() {
      return and();
    }
    
  }
}