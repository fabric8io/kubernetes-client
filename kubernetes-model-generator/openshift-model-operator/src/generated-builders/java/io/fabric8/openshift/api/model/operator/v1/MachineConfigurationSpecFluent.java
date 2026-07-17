package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class MachineConfigurationSpecFluent<A extends io.fabric8.openshift.api.model.operator.v1.MachineConfigurationSpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private Integer failedRevisionLimit;
  private String forceRedeploymentReason;
  private IrreconcilableValidationOverridesBuilder irreconcilableValidationOverrides;
  private String logLevel;
  private ManagedBootImagesBuilder managedBootImages;
  private String managementState;
  private NodeDisruptionPolicyConfigBuilder nodeDisruptionPolicy;
  private Object observedConfig;
  private String operatorLogLevel;
  private Integer succeededRevisionLimit;
  private Object unsupportedConfigOverrides;

  public MachineConfigurationSpecFluent() {
  }
  
  public MachineConfigurationSpecFluent(MachineConfigurationSpec instance) {
    this.copyInstance(instance);
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
  
  public IrreconcilableValidationOverrides buildIrreconcilableValidationOverrides() {
    return this.irreconcilableValidationOverrides != null ? this.irreconcilableValidationOverrides.build() : null;
  }
  
  public ManagedBootImages buildManagedBootImages() {
    return this.managedBootImages != null ? this.managedBootImages.build() : null;
  }
  
  public NodeDisruptionPolicyConfig buildNodeDisruptionPolicy() {
    return this.nodeDisruptionPolicy != null ? this.nodeDisruptionPolicy.build() : null;
  }
  
  protected void copyInstance(MachineConfigurationSpec instance) {
    instance = instance != null ? instance : new MachineConfigurationSpec();
    if (instance != null) {
        this.withFailedRevisionLimit(instance.getFailedRevisionLimit());
        this.withForceRedeploymentReason(instance.getForceRedeploymentReason());
        this.withIrreconcilableValidationOverrides(instance.getIrreconcilableValidationOverrides());
        this.withLogLevel(instance.getLogLevel());
        this.withManagedBootImages(instance.getManagedBootImages());
        this.withManagementState(instance.getManagementState());
        this.withNodeDisruptionPolicy(instance.getNodeDisruptionPolicy());
        this.withObservedConfig(instance.getObservedConfig());
        this.withOperatorLogLevel(instance.getOperatorLogLevel());
        this.withSucceededRevisionLimit(instance.getSucceededRevisionLimit());
        this.withUnsupportedConfigOverrides(instance.getUnsupportedConfigOverrides());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public IrreconcilableValidationOverridesNested<A> editIrreconcilableValidationOverrides() {
    return this.withNewIrreconcilableValidationOverridesLike(Optional.ofNullable(this.buildIrreconcilableValidationOverrides()).orElse(null));
  }
  
  public ManagedBootImagesNested<A> editManagedBootImages() {
    return this.withNewManagedBootImagesLike(Optional.ofNullable(this.buildManagedBootImages()).orElse(null));
  }
  
  public NodeDisruptionPolicyNested<A> editNodeDisruptionPolicy() {
    return this.withNewNodeDisruptionPolicyLike(Optional.ofNullable(this.buildNodeDisruptionPolicy()).orElse(null));
  }
  
  public IrreconcilableValidationOverridesNested<A> editOrNewIrreconcilableValidationOverrides() {
    return this.withNewIrreconcilableValidationOverridesLike(Optional.ofNullable(this.buildIrreconcilableValidationOverrides()).orElse(new IrreconcilableValidationOverridesBuilder().build()));
  }
  
  public IrreconcilableValidationOverridesNested<A> editOrNewIrreconcilableValidationOverridesLike(IrreconcilableValidationOverrides item) {
    return this.withNewIrreconcilableValidationOverridesLike(Optional.ofNullable(this.buildIrreconcilableValidationOverrides()).orElse(item));
  }
  
  public ManagedBootImagesNested<A> editOrNewManagedBootImages() {
    return this.withNewManagedBootImagesLike(Optional.ofNullable(this.buildManagedBootImages()).orElse(new ManagedBootImagesBuilder().build()));
  }
  
  public ManagedBootImagesNested<A> editOrNewManagedBootImagesLike(ManagedBootImages item) {
    return this.withNewManagedBootImagesLike(Optional.ofNullable(this.buildManagedBootImages()).orElse(item));
  }
  
  public NodeDisruptionPolicyNested<A> editOrNewNodeDisruptionPolicy() {
    return this.withNewNodeDisruptionPolicyLike(Optional.ofNullable(this.buildNodeDisruptionPolicy()).orElse(new NodeDisruptionPolicyConfigBuilder().build()));
  }
  
  public NodeDisruptionPolicyNested<A> editOrNewNodeDisruptionPolicyLike(NodeDisruptionPolicyConfig item) {
    return this.withNewNodeDisruptionPolicyLike(Optional.ofNullable(this.buildNodeDisruptionPolicy()).orElse(item));
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
    MachineConfigurationSpecFluent that = (MachineConfigurationSpecFluent) o;
    if (!(Objects.equals(failedRevisionLimit, that.failedRevisionLimit))) {
      return false;
    }
    if (!(Objects.equals(forceRedeploymentReason, that.forceRedeploymentReason))) {
      return false;
    }
    if (!(Objects.equals(irreconcilableValidationOverrides, that.irreconcilableValidationOverrides))) {
      return false;
    }
    if (!(Objects.equals(logLevel, that.logLevel))) {
      return false;
    }
    if (!(Objects.equals(managedBootImages, that.managedBootImages))) {
      return false;
    }
    if (!(Objects.equals(managementState, that.managementState))) {
      return false;
    }
    if (!(Objects.equals(nodeDisruptionPolicy, that.nodeDisruptionPolicy))) {
      return false;
    }
    if (!(Objects.equals(observedConfig, that.observedConfig))) {
      return false;
    }
    if (!(Objects.equals(operatorLogLevel, that.operatorLogLevel))) {
      return false;
    }
    if (!(Objects.equals(succeededRevisionLimit, that.succeededRevisionLimit))) {
      return false;
    }
    if (!(Objects.equals(unsupportedConfigOverrides, that.unsupportedConfigOverrides))) {
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
  
  public Integer getFailedRevisionLimit() {
    return this.failedRevisionLimit;
  }
  
  public String getForceRedeploymentReason() {
    return this.forceRedeploymentReason;
  }
  
  public String getLogLevel() {
    return this.logLevel;
  }
  
  public String getManagementState() {
    return this.managementState;
  }
  
  public Object getObservedConfig() {
    return this.observedConfig;
  }
  
  public String getOperatorLogLevel() {
    return this.operatorLogLevel;
  }
  
  public Integer getSucceededRevisionLimit() {
    return this.succeededRevisionLimit;
  }
  
  public Object getUnsupportedConfigOverrides() {
    return this.unsupportedConfigOverrides;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFailedRevisionLimit() {
    return this.failedRevisionLimit != null;
  }
  
  public boolean hasForceRedeploymentReason() {
    return this.forceRedeploymentReason != null;
  }
  
  public boolean hasIrreconcilableValidationOverrides() {
    return this.irreconcilableValidationOverrides != null;
  }
  
  public boolean hasLogLevel() {
    return this.logLevel != null;
  }
  
  public boolean hasManagedBootImages() {
    return this.managedBootImages != null;
  }
  
  public boolean hasManagementState() {
    return this.managementState != null;
  }
  
  public boolean hasNodeDisruptionPolicy() {
    return this.nodeDisruptionPolicy != null;
  }
  
  public boolean hasObservedConfig() {
    return this.observedConfig != null;
  }
  
  public boolean hasOperatorLogLevel() {
    return this.operatorLogLevel != null;
  }
  
  public boolean hasSucceededRevisionLimit() {
    return this.succeededRevisionLimit != null;
  }
  
  public boolean hasUnsupportedConfigOverrides() {
    return this.unsupportedConfigOverrides != null;
  }
  
  public int hashCode() {
    return Objects.hash(failedRevisionLimit, forceRedeploymentReason, irreconcilableValidationOverrides, logLevel, managedBootImages, managementState, nodeDisruptionPolicy, observedConfig, operatorLogLevel, succeededRevisionLimit, unsupportedConfigOverrides, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(failedRevisionLimit == null)) {
        sb.append("failedRevisionLimit:");
        sb.append(failedRevisionLimit);
        sb.append(",");
    }
    if (!(forceRedeploymentReason == null)) {
        sb.append("forceRedeploymentReason:");
        sb.append(forceRedeploymentReason);
        sb.append(",");
    }
    if (!(irreconcilableValidationOverrides == null)) {
        sb.append("irreconcilableValidationOverrides:");
        sb.append(irreconcilableValidationOverrides);
        sb.append(",");
    }
    if (!(logLevel == null)) {
        sb.append("logLevel:");
        sb.append(logLevel);
        sb.append(",");
    }
    if (!(managedBootImages == null)) {
        sb.append("managedBootImages:");
        sb.append(managedBootImages);
        sb.append(",");
    }
    if (!(managementState == null)) {
        sb.append("managementState:");
        sb.append(managementState);
        sb.append(",");
    }
    if (!(nodeDisruptionPolicy == null)) {
        sb.append("nodeDisruptionPolicy:");
        sb.append(nodeDisruptionPolicy);
        sb.append(",");
    }
    if (!(observedConfig == null)) {
        sb.append("observedConfig:");
        sb.append(observedConfig);
        sb.append(",");
    }
    if (!(operatorLogLevel == null)) {
        sb.append("operatorLogLevel:");
        sb.append(operatorLogLevel);
        sb.append(",");
    }
    if (!(succeededRevisionLimit == null)) {
        sb.append("succeededRevisionLimit:");
        sb.append(succeededRevisionLimit);
        sb.append(",");
    }
    if (!(unsupportedConfigOverrides == null)) {
        sb.append("unsupportedConfigOverrides:");
        sb.append(unsupportedConfigOverrides);
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
  
  public A withFailedRevisionLimit(Integer failedRevisionLimit) {
    this.failedRevisionLimit = failedRevisionLimit;
    return (A) this;
  }
  
  public A withForceRedeploymentReason(String forceRedeploymentReason) {
    this.forceRedeploymentReason = forceRedeploymentReason;
    return (A) this;
  }
  
  public A withIrreconcilableValidationOverrides(IrreconcilableValidationOverrides irreconcilableValidationOverrides) {
    this._visitables.remove("irreconcilableValidationOverrides");
    if (irreconcilableValidationOverrides != null) {
        this.irreconcilableValidationOverrides = new IrreconcilableValidationOverridesBuilder(irreconcilableValidationOverrides);
        this._visitables.get("irreconcilableValidationOverrides").add(this.irreconcilableValidationOverrides);
    } else {
        this.irreconcilableValidationOverrides = null;
        this._visitables.get("irreconcilableValidationOverrides").remove(this.irreconcilableValidationOverrides);
    }
    return (A) this;
  }
  
  public A withLogLevel(String logLevel) {
    this.logLevel = logLevel;
    return (A) this;
  }
  
  public A withManagedBootImages(ManagedBootImages managedBootImages) {
    this._visitables.remove("managedBootImages");
    if (managedBootImages != null) {
        this.managedBootImages = new ManagedBootImagesBuilder(managedBootImages);
        this._visitables.get("managedBootImages").add(this.managedBootImages);
    } else {
        this.managedBootImages = null;
        this._visitables.get("managedBootImages").remove(this.managedBootImages);
    }
    return (A) this;
  }
  
  public A withManagementState(String managementState) {
    this.managementState = managementState;
    return (A) this;
  }
  
  public IrreconcilableValidationOverridesNested<A> withNewIrreconcilableValidationOverrides() {
    return new IrreconcilableValidationOverridesNested(null);
  }
  
  public IrreconcilableValidationOverridesNested<A> withNewIrreconcilableValidationOverridesLike(IrreconcilableValidationOverrides item) {
    return new IrreconcilableValidationOverridesNested(item);
  }
  
  public ManagedBootImagesNested<A> withNewManagedBootImages() {
    return new ManagedBootImagesNested(null);
  }
  
  public ManagedBootImagesNested<A> withNewManagedBootImagesLike(ManagedBootImages item) {
    return new ManagedBootImagesNested(item);
  }
  
  public NodeDisruptionPolicyNested<A> withNewNodeDisruptionPolicy() {
    return new NodeDisruptionPolicyNested(null);
  }
  
  public NodeDisruptionPolicyNested<A> withNewNodeDisruptionPolicyLike(NodeDisruptionPolicyConfig item) {
    return new NodeDisruptionPolicyNested(item);
  }
  
  public A withNodeDisruptionPolicy(NodeDisruptionPolicyConfig nodeDisruptionPolicy) {
    this._visitables.remove("nodeDisruptionPolicy");
    if (nodeDisruptionPolicy != null) {
        this.nodeDisruptionPolicy = new NodeDisruptionPolicyConfigBuilder(nodeDisruptionPolicy);
        this._visitables.get("nodeDisruptionPolicy").add(this.nodeDisruptionPolicy);
    } else {
        this.nodeDisruptionPolicy = null;
        this._visitables.get("nodeDisruptionPolicy").remove(this.nodeDisruptionPolicy);
    }
    return (A) this;
  }
  
  public A withObservedConfig(Object observedConfig) {
    this.observedConfig = observedConfig;
    return (A) this;
  }
  
  public A withOperatorLogLevel(String operatorLogLevel) {
    this.operatorLogLevel = operatorLogLevel;
    return (A) this;
  }
  
  public A withSucceededRevisionLimit(Integer succeededRevisionLimit) {
    this.succeededRevisionLimit = succeededRevisionLimit;
    return (A) this;
  }
  
  public A withUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
    this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    return (A) this;
  }
  public class IrreconcilableValidationOverridesNested<N> extends IrreconcilableValidationOverridesFluent<IrreconcilableValidationOverridesNested<N>> implements Nested<N>{
  
    IrreconcilableValidationOverridesBuilder builder;
  
    IrreconcilableValidationOverridesNested(IrreconcilableValidationOverrides item) {
      this.builder = new IrreconcilableValidationOverridesBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigurationSpecFluent.this.withIrreconcilableValidationOverrides(builder.build());
    }
    
    public N endIrreconcilableValidationOverrides() {
      return and();
    }
    
  }
  public class ManagedBootImagesNested<N> extends ManagedBootImagesFluent<ManagedBootImagesNested<N>> implements Nested<N>{
  
    ManagedBootImagesBuilder builder;
  
    ManagedBootImagesNested(ManagedBootImages item) {
      this.builder = new ManagedBootImagesBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigurationSpecFluent.this.withManagedBootImages(builder.build());
    }
    
    public N endManagedBootImages() {
      return and();
    }
    
  }
  public class NodeDisruptionPolicyNested<N> extends NodeDisruptionPolicyConfigFluent<NodeDisruptionPolicyNested<N>> implements Nested<N>{
  
    NodeDisruptionPolicyConfigBuilder builder;
  
    NodeDisruptionPolicyNested(NodeDisruptionPolicyConfig item) {
      this.builder = new NodeDisruptionPolicyConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) MachineConfigurationSpecFluent.this.withNodeDisruptionPolicy(builder.build());
    }
    
    public N endNodeDisruptionPolicy() {
      return and();
    }
    
  }
}