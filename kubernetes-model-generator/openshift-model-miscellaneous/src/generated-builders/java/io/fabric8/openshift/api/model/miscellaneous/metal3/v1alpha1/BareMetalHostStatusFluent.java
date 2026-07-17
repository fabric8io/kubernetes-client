package io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.Condition;
import java.lang.Boolean;
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
public class BareMetalHostStatusFluent<A extends io.fabric8.openshift.api.model.miscellaneous.metal3.v1alpha1.BareMetalHostStatusFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private List<Condition> conditions = new ArrayList<Condition>();
  private Integer errorCount;
  private String errorMessage;
  private String errorType;
  private CredentialsStatusBuilder goodCredentials;
  private HardwareDetailsBuilder hardware;
  private String hardwareProfile;
  private String lastUpdated;
  private OperationHistoryBuilder operationHistory;
  private String operationalStatus;
  private Boolean poweredOn;
  private ProvisionStatusBuilder provisioning;
  private CredentialsStatusBuilder triedCredentials;

  public BareMetalHostStatusFluent() {
  }
  
  public BareMetalHostStatusFluent(BareMetalHostStatus instance) {
    this.copyInstance(instance);
  }

  public A addAllToConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
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
  
  public A addToConditions(Condition... items) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    for (Condition item : items) {
      this.conditions.add(item);
    }
    return (A) this;
  }
  
  public A addToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.add(index, item);
    return (A) this;
  }
  
  public CredentialsStatus buildGoodCredentials() {
    return this.goodCredentials != null ? this.goodCredentials.build() : null;
  }
  
  public HardwareDetails buildHardware() {
    return this.hardware != null ? this.hardware.build() : null;
  }
  
  public OperationHistory buildOperationHistory() {
    return this.operationHistory != null ? this.operationHistory.build() : null;
  }
  
  public ProvisionStatus buildProvisioning() {
    return this.provisioning != null ? this.provisioning.build() : null;
  }
  
  public CredentialsStatus buildTriedCredentials() {
    return this.triedCredentials != null ? this.triedCredentials.build() : null;
  }
  
  protected void copyInstance(BareMetalHostStatus instance) {
    instance = instance != null ? instance : new BareMetalHostStatus();
    if (instance != null) {
        this.withConditions(instance.getConditions());
        this.withErrorCount(instance.getErrorCount());
        this.withErrorMessage(instance.getErrorMessage());
        this.withErrorType(instance.getErrorType());
        this.withGoodCredentials(instance.getGoodCredentials());
        this.withHardware(instance.getHardware());
        this.withHardwareProfile(instance.getHardwareProfile());
        this.withLastUpdated(instance.getLastUpdated());
        this.withOperationHistory(instance.getOperationHistory());
        this.withOperationalStatus(instance.getOperationalStatus());
        this.withPoweredOn(instance.getPoweredOn());
        this.withProvisioning(instance.getProvisioning());
        this.withTriedCredentials(instance.getTriedCredentials());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public GoodCredentialsNested<A> editGoodCredentials() {
    return this.withNewGoodCredentialsLike(Optional.ofNullable(this.buildGoodCredentials()).orElse(null));
  }
  
  public HardwareNested<A> editHardware() {
    return this.withNewHardwareLike(Optional.ofNullable(this.buildHardware()).orElse(null));
  }
  
  public OperationHistoryNested<A> editOperationHistory() {
    return this.withNewOperationHistoryLike(Optional.ofNullable(this.buildOperationHistory()).orElse(null));
  }
  
  public GoodCredentialsNested<A> editOrNewGoodCredentials() {
    return this.withNewGoodCredentialsLike(Optional.ofNullable(this.buildGoodCredentials()).orElse(new CredentialsStatusBuilder().build()));
  }
  
  public GoodCredentialsNested<A> editOrNewGoodCredentialsLike(CredentialsStatus item) {
    return this.withNewGoodCredentialsLike(Optional.ofNullable(this.buildGoodCredentials()).orElse(item));
  }
  
  public HardwareNested<A> editOrNewHardware() {
    return this.withNewHardwareLike(Optional.ofNullable(this.buildHardware()).orElse(new HardwareDetailsBuilder().build()));
  }
  
  public HardwareNested<A> editOrNewHardwareLike(HardwareDetails item) {
    return this.withNewHardwareLike(Optional.ofNullable(this.buildHardware()).orElse(item));
  }
  
  public OperationHistoryNested<A> editOrNewOperationHistory() {
    return this.withNewOperationHistoryLike(Optional.ofNullable(this.buildOperationHistory()).orElse(new OperationHistoryBuilder().build()));
  }
  
  public OperationHistoryNested<A> editOrNewOperationHistoryLike(OperationHistory item) {
    return this.withNewOperationHistoryLike(Optional.ofNullable(this.buildOperationHistory()).orElse(item));
  }
  
  public ProvisioningNested<A> editOrNewProvisioning() {
    return this.withNewProvisioningLike(Optional.ofNullable(this.buildProvisioning()).orElse(new ProvisionStatusBuilder().build()));
  }
  
  public ProvisioningNested<A> editOrNewProvisioningLike(ProvisionStatus item) {
    return this.withNewProvisioningLike(Optional.ofNullable(this.buildProvisioning()).orElse(item));
  }
  
  public TriedCredentialsNested<A> editOrNewTriedCredentials() {
    return this.withNewTriedCredentialsLike(Optional.ofNullable(this.buildTriedCredentials()).orElse(new CredentialsStatusBuilder().build()));
  }
  
  public TriedCredentialsNested<A> editOrNewTriedCredentialsLike(CredentialsStatus item) {
    return this.withNewTriedCredentialsLike(Optional.ofNullable(this.buildTriedCredentials()).orElse(item));
  }
  
  public ProvisioningNested<A> editProvisioning() {
    return this.withNewProvisioningLike(Optional.ofNullable(this.buildProvisioning()).orElse(null));
  }
  
  public TriedCredentialsNested<A> editTriedCredentials() {
    return this.withNewTriedCredentialsLike(Optional.ofNullable(this.buildTriedCredentials()).orElse(null));
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
    BareMetalHostStatusFluent that = (BareMetalHostStatusFluent) o;
    if (!(Objects.equals(conditions, that.conditions))) {
      return false;
    }
    if (!(Objects.equals(errorCount, that.errorCount))) {
      return false;
    }
    if (!(Objects.equals(errorMessage, that.errorMessage))) {
      return false;
    }
    if (!(Objects.equals(errorType, that.errorType))) {
      return false;
    }
    if (!(Objects.equals(goodCredentials, that.goodCredentials))) {
      return false;
    }
    if (!(Objects.equals(hardware, that.hardware))) {
      return false;
    }
    if (!(Objects.equals(hardwareProfile, that.hardwareProfile))) {
      return false;
    }
    if (!(Objects.equals(lastUpdated, that.lastUpdated))) {
      return false;
    }
    if (!(Objects.equals(operationHistory, that.operationHistory))) {
      return false;
    }
    if (!(Objects.equals(operationalStatus, that.operationalStatus))) {
      return false;
    }
    if (!(Objects.equals(poweredOn, that.poweredOn))) {
      return false;
    }
    if (!(Objects.equals(provisioning, that.provisioning))) {
      return false;
    }
    if (!(Objects.equals(triedCredentials, that.triedCredentials))) {
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
  
  public Condition getCondition(int index) {
    return this.conditions.get(index);
  }
  
  public List<Condition> getConditions() {
    return this.conditions;
  }
  
  public Integer getErrorCount() {
    return this.errorCount;
  }
  
  public String getErrorMessage() {
    return this.errorMessage;
  }
  
  public String getErrorType() {
    return this.errorType;
  }
  
  public Condition getFirstCondition() {
    return this.conditions.get(0);
  }
  
  public String getHardwareProfile() {
    return this.hardwareProfile;
  }
  
  public Condition getLastCondition() {
    return this.conditions.get(conditions.size() - 1);
  }
  
  public String getLastUpdated() {
    return this.lastUpdated;
  }
  
  public Condition getMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getOperationalStatus() {
    return this.operationalStatus;
  }
  
  public Boolean getPoweredOn() {
    return this.poweredOn;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConditions() {
    return this.conditions != null && !(this.conditions.isEmpty());
  }
  
  public boolean hasErrorCount() {
    return this.errorCount != null;
  }
  
  public boolean hasErrorMessage() {
    return this.errorMessage != null;
  }
  
  public boolean hasErrorType() {
    return this.errorType != null;
  }
  
  public boolean hasGoodCredentials() {
    return this.goodCredentials != null;
  }
  
  public boolean hasHardware() {
    return this.hardware != null;
  }
  
  public boolean hasHardwareProfile() {
    return this.hardwareProfile != null;
  }
  
  public boolean hasLastUpdated() {
    return this.lastUpdated != null;
  }
  
  public boolean hasMatchingCondition(Predicate<Condition> predicate) {
      for (Condition item : conditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasOperationHistory() {
    return this.operationHistory != null;
  }
  
  public boolean hasOperationalStatus() {
    return this.operationalStatus != null;
  }
  
  public boolean hasPoweredOn() {
    return this.poweredOn != null;
  }
  
  public boolean hasProvisioning() {
    return this.provisioning != null;
  }
  
  public boolean hasTriedCredentials() {
    return this.triedCredentials != null;
  }
  
  public int hashCode() {
    return Objects.hash(conditions, errorCount, errorMessage, errorType, goodCredentials, hardware, hardwareProfile, lastUpdated, operationHistory, operationalStatus, poweredOn, provisioning, triedCredentials, additionalProperties);
  }
  
  public A removeAllFromConditions(Collection<Condition> items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
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
  
  public A removeFromConditions(Condition... items) {
    if (this.conditions == null) {
      return (A) this;
    }
    for (Condition item : items) {
      this.conditions.remove(item);
    }
    return (A) this;
  }
  
  public A setToConditions(int index,Condition item) {
    if (this.conditions == null) {
      this.conditions = new ArrayList();
    }
    this.conditions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(conditions == null) && !(conditions.isEmpty())) {
        sb.append("conditions:");
        sb.append(conditions);
        sb.append(",");
    }
    if (!(errorCount == null)) {
        sb.append("errorCount:");
        sb.append(errorCount);
        sb.append(",");
    }
    if (!(errorMessage == null)) {
        sb.append("errorMessage:");
        sb.append(errorMessage);
        sb.append(",");
    }
    if (!(errorType == null)) {
        sb.append("errorType:");
        sb.append(errorType);
        sb.append(",");
    }
    if (!(goodCredentials == null)) {
        sb.append("goodCredentials:");
        sb.append(goodCredentials);
        sb.append(",");
    }
    if (!(hardware == null)) {
        sb.append("hardware:");
        sb.append(hardware);
        sb.append(",");
    }
    if (!(hardwareProfile == null)) {
        sb.append("hardwareProfile:");
        sb.append(hardwareProfile);
        sb.append(",");
    }
    if (!(lastUpdated == null)) {
        sb.append("lastUpdated:");
        sb.append(lastUpdated);
        sb.append(",");
    }
    if (!(operationHistory == null)) {
        sb.append("operationHistory:");
        sb.append(operationHistory);
        sb.append(",");
    }
    if (!(operationalStatus == null)) {
        sb.append("operationalStatus:");
        sb.append(operationalStatus);
        sb.append(",");
    }
    if (!(poweredOn == null)) {
        sb.append("poweredOn:");
        sb.append(poweredOn);
        sb.append(",");
    }
    if (!(provisioning == null)) {
        sb.append("provisioning:");
        sb.append(provisioning);
        sb.append(",");
    }
    if (!(triedCredentials == null)) {
        sb.append("triedCredentials:");
        sb.append(triedCredentials);
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
  
  public A withConditions(List<Condition> conditions) {
    if (conditions != null) {
        this.conditions = new ArrayList();
        for (Condition item : conditions) {
          this.addToConditions(item);
        }
    } else {
      this.conditions = null;
    }
    return (A) this;
  }
  
  public A withConditions(Condition... conditions) {
    if (this.conditions != null) {
        this.conditions.clear();
        _visitables.remove("conditions");
    }
    if (conditions != null) {
      for (Condition item : conditions) {
        this.addToConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withErrorCount(Integer errorCount) {
    this.errorCount = errorCount;
    return (A) this;
  }
  
  public A withErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
    return (A) this;
  }
  
  public A withErrorType(String errorType) {
    this.errorType = errorType;
    return (A) this;
  }
  
  public A withGoodCredentials(CredentialsStatus goodCredentials) {
    this._visitables.remove("goodCredentials");
    if (goodCredentials != null) {
        this.goodCredentials = new CredentialsStatusBuilder(goodCredentials);
        this._visitables.get("goodCredentials").add(this.goodCredentials);
    } else {
        this.goodCredentials = null;
        this._visitables.get("goodCredentials").remove(this.goodCredentials);
    }
    return (A) this;
  }
  
  public A withHardware(HardwareDetails hardware) {
    this._visitables.remove("hardware");
    if (hardware != null) {
        this.hardware = new HardwareDetailsBuilder(hardware);
        this._visitables.get("hardware").add(this.hardware);
    } else {
        this.hardware = null;
        this._visitables.get("hardware").remove(this.hardware);
    }
    return (A) this;
  }
  
  public A withHardwareProfile(String hardwareProfile) {
    this.hardwareProfile = hardwareProfile;
    return (A) this;
  }
  
  public A withLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return (A) this;
  }
  
  public GoodCredentialsNested<A> withNewGoodCredentials() {
    return new GoodCredentialsNested(null);
  }
  
  public GoodCredentialsNested<A> withNewGoodCredentialsLike(CredentialsStatus item) {
    return new GoodCredentialsNested(item);
  }
  
  public HardwareNested<A> withNewHardware() {
    return new HardwareNested(null);
  }
  
  public HardwareNested<A> withNewHardwareLike(HardwareDetails item) {
    return new HardwareNested(item);
  }
  
  public OperationHistoryNested<A> withNewOperationHistory() {
    return new OperationHistoryNested(null);
  }
  
  public OperationHistoryNested<A> withNewOperationHistoryLike(OperationHistory item) {
    return new OperationHistoryNested(item);
  }
  
  public ProvisioningNested<A> withNewProvisioning() {
    return new ProvisioningNested(null);
  }
  
  public ProvisioningNested<A> withNewProvisioningLike(ProvisionStatus item) {
    return new ProvisioningNested(item);
  }
  
  public TriedCredentialsNested<A> withNewTriedCredentials() {
    return new TriedCredentialsNested(null);
  }
  
  public TriedCredentialsNested<A> withNewTriedCredentialsLike(CredentialsStatus item) {
    return new TriedCredentialsNested(item);
  }
  
  public A withOperationHistory(OperationHistory operationHistory) {
    this._visitables.remove("operationHistory");
    if (operationHistory != null) {
        this.operationHistory = new OperationHistoryBuilder(operationHistory);
        this._visitables.get("operationHistory").add(this.operationHistory);
    } else {
        this.operationHistory = null;
        this._visitables.get("operationHistory").remove(this.operationHistory);
    }
    return (A) this;
  }
  
  public A withOperationalStatus(String operationalStatus) {
    this.operationalStatus = operationalStatus;
    return (A) this;
  }
  
  public A withPoweredOn() {
    return withPoweredOn(true);
  }
  
  public A withPoweredOn(Boolean poweredOn) {
    this.poweredOn = poweredOn;
    return (A) this;
  }
  
  public A withProvisioning(ProvisionStatus provisioning) {
    this._visitables.remove("provisioning");
    if (provisioning != null) {
        this.provisioning = new ProvisionStatusBuilder(provisioning);
        this._visitables.get("provisioning").add(this.provisioning);
    } else {
        this.provisioning = null;
        this._visitables.get("provisioning").remove(this.provisioning);
    }
    return (A) this;
  }
  
  public A withTriedCredentials(CredentialsStatus triedCredentials) {
    this._visitables.remove("triedCredentials");
    if (triedCredentials != null) {
        this.triedCredentials = new CredentialsStatusBuilder(triedCredentials);
        this._visitables.get("triedCredentials").add(this.triedCredentials);
    } else {
        this.triedCredentials = null;
        this._visitables.get("triedCredentials").remove(this.triedCredentials);
    }
    return (A) this;
  }
  public class GoodCredentialsNested<N> extends CredentialsStatusFluent<GoodCredentialsNested<N>> implements Nested<N>{
  
    CredentialsStatusBuilder builder;
  
    GoodCredentialsNested(CredentialsStatus item) {
      this.builder = new CredentialsStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) BareMetalHostStatusFluent.this.withGoodCredentials(builder.build());
    }
    
    public N endGoodCredentials() {
      return and();
    }
    
  }
  public class HardwareNested<N> extends HardwareDetailsFluent<HardwareNested<N>> implements Nested<N>{
  
    HardwareDetailsBuilder builder;
  
    HardwareNested(HardwareDetails item) {
      this.builder = new HardwareDetailsBuilder(this, item);
    }
  
    public N and() {
      return (N) BareMetalHostStatusFluent.this.withHardware(builder.build());
    }
    
    public N endHardware() {
      return and();
    }
    
  }
  public class OperationHistoryNested<N> extends OperationHistoryFluent<OperationHistoryNested<N>> implements Nested<N>{
  
    OperationHistoryBuilder builder;
  
    OperationHistoryNested(OperationHistory item) {
      this.builder = new OperationHistoryBuilder(this, item);
    }
  
    public N and() {
      return (N) BareMetalHostStatusFluent.this.withOperationHistory(builder.build());
    }
    
    public N endOperationHistory() {
      return and();
    }
    
  }
  public class ProvisioningNested<N> extends ProvisionStatusFluent<ProvisioningNested<N>> implements Nested<N>{
  
    ProvisionStatusBuilder builder;
  
    ProvisioningNested(ProvisionStatus item) {
      this.builder = new ProvisionStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) BareMetalHostStatusFluent.this.withProvisioning(builder.build());
    }
    
    public N endProvisioning() {
      return and();
    }
    
  }
  public class TriedCredentialsNested<N> extends CredentialsStatusFluent<TriedCredentialsNested<N>> implements Nested<N>{
  
    CredentialsStatusBuilder builder;
  
    TriedCredentialsNested(CredentialsStatus item) {
      this.builder = new CredentialsStatusBuilder(this, item);
    }
  
    public N and() {
      return (N) BareMetalHostStatusFluent.this.withTriedCredentials(builder.build());
    }
    
    public N endTriedCredentials() {
      return and();
    }
    
  }
}