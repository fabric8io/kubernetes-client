package io.fabric8.openclustermanagement.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Integer;
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
public class RegistrationConfigurationFluent<A extends io.fabric8.openclustermanagement.api.model.operator.v1.RegistrationConfigurationFluent<A>> extends BaseFluent<A>{

  private AddOnRegistrationDriverBuilder addOnKubeClientRegistrationDriver;
  private Map<String,Object> additionalProperties;
  private BootstrapKubeConfigsBuilder bootstrapKubeConfigs;
  private Integer clientCertExpirationSeconds;
  private Map<String,String> clusterAnnotations;
  private ClusterClaimConfigurationBuilder clusterClaimConfiguration;
  private Map<String,String> clusterLabels;
  private ArrayList<FeatureGateBuilder> featureGates = new ArrayList<FeatureGateBuilder>();
  private Integer kubeAPIBurst;
  private Integer kubeAPIQPS;
  private RegistrationDriverBuilder registrationDriver;

  public RegistrationConfigurationFluent() {
  }
  
  public RegistrationConfigurationFluent(RegistrationConfiguration instance) {
    this.copyInstance(instance);
  }

  public A addAllToFeatureGates(Collection<FeatureGate> items) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    for (FeatureGate item : items) {
        FeatureGateBuilder builder = new FeatureGateBuilder(item);
        _visitables.get("featureGates").add(builder);
        this.featureGates.add(builder);
    }
    return (A) this;
  }
  
  public FeatureGatesNested<A> addNewFeatureGate() {
    return new FeatureGatesNested(-1, null);
  }
  
  public A addNewFeatureGate(String feature,String mode) {
    return (A) this.addToFeatureGates(new FeatureGate(feature, mode));
  }
  
  public FeatureGatesNested<A> addNewFeatureGateLike(FeatureGate item) {
    return new FeatureGatesNested(-1, item);
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
  
  public A addToClusterAnnotations(Map<String,String> map) {
    if (this.clusterAnnotations == null && map != null) {
      this.clusterAnnotations = new LinkedHashMap();
    }
    if (map != null) {
      this.clusterAnnotations.putAll(map);
    }
    return (A) this;
  }
  
  public A addToClusterAnnotations(String key,String value) {
    if (this.clusterAnnotations == null && key != null && value != null) {
      this.clusterAnnotations = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.clusterAnnotations.put(key, value);
    }
    return (A) this;
  }
  
  public A addToClusterLabels(Map<String,String> map) {
    if (this.clusterLabels == null && map != null) {
      this.clusterLabels = new LinkedHashMap();
    }
    if (map != null) {
      this.clusterLabels.putAll(map);
    }
    return (A) this;
  }
  
  public A addToClusterLabels(String key,String value) {
    if (this.clusterLabels == null && key != null && value != null) {
      this.clusterLabels = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.clusterLabels.put(key, value);
    }
    return (A) this;
  }
  
  public A addToFeatureGates(FeatureGate... items) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    for (FeatureGate item : items) {
        FeatureGateBuilder builder = new FeatureGateBuilder(item);
        _visitables.get("featureGates").add(builder);
        this.featureGates.add(builder);
    }
    return (A) this;
  }
  
  public A addToFeatureGates(int index,FeatureGate item) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    FeatureGateBuilder builder = new FeatureGateBuilder(item);
    if (index < 0 || index >= featureGates.size()) {
        _visitables.get("featureGates").add(builder);
        featureGates.add(builder);
    } else {
        _visitables.get("featureGates").add(builder);
        featureGates.add(index, builder);
    }
    return (A) this;
  }
  
  public AddOnRegistrationDriver buildAddOnKubeClientRegistrationDriver() {
    return this.addOnKubeClientRegistrationDriver != null ? this.addOnKubeClientRegistrationDriver.build() : null;
  }
  
  public BootstrapKubeConfigs buildBootstrapKubeConfigs() {
    return this.bootstrapKubeConfigs != null ? this.bootstrapKubeConfigs.build() : null;
  }
  
  public ClusterClaimConfiguration buildClusterClaimConfiguration() {
    return this.clusterClaimConfiguration != null ? this.clusterClaimConfiguration.build() : null;
  }
  
  public FeatureGate buildFeatureGate(int index) {
    return this.featureGates.get(index).build();
  }
  
  public List<FeatureGate> buildFeatureGates() {
    return this.featureGates != null ? build(featureGates) : null;
  }
  
  public FeatureGate buildFirstFeatureGate() {
    return this.featureGates.get(0).build();
  }
  
  public FeatureGate buildLastFeatureGate() {
    return this.featureGates.get(featureGates.size() - 1).build();
  }
  
  public FeatureGate buildMatchingFeatureGate(Predicate<FeatureGateBuilder> predicate) {
      for (FeatureGateBuilder item : featureGates) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public RegistrationDriver buildRegistrationDriver() {
    return this.registrationDriver != null ? this.registrationDriver.build() : null;
  }
  
  protected void copyInstance(RegistrationConfiguration instance) {
    instance = instance != null ? instance : new RegistrationConfiguration();
    if (instance != null) {
        this.withAddOnKubeClientRegistrationDriver(instance.getAddOnKubeClientRegistrationDriver());
        this.withBootstrapKubeConfigs(instance.getBootstrapKubeConfigs());
        this.withClientCertExpirationSeconds(instance.getClientCertExpirationSeconds());
        this.withClusterAnnotations(instance.getClusterAnnotations());
        this.withClusterClaimConfiguration(instance.getClusterClaimConfiguration());
        this.withClusterLabels(instance.getClusterLabels());
        this.withFeatureGates(instance.getFeatureGates());
        this.withKubeAPIBurst(instance.getKubeAPIBurst());
        this.withKubeAPIQPS(instance.getKubeAPIQPS());
        this.withRegistrationDriver(instance.getRegistrationDriver());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AddOnKubeClientRegistrationDriverNested<A> editAddOnKubeClientRegistrationDriver() {
    return this.withNewAddOnKubeClientRegistrationDriverLike(Optional.ofNullable(this.buildAddOnKubeClientRegistrationDriver()).orElse(null));
  }
  
  public BootstrapKubeConfigsNested<A> editBootstrapKubeConfigs() {
    return this.withNewBootstrapKubeConfigsLike(Optional.ofNullable(this.buildBootstrapKubeConfigs()).orElse(null));
  }
  
  public ClusterClaimConfigurationNested<A> editClusterClaimConfiguration() {
    return this.withNewClusterClaimConfigurationLike(Optional.ofNullable(this.buildClusterClaimConfiguration()).orElse(null));
  }
  
  public FeatureGatesNested<A> editFeatureGate(int index) {
    if (featureGates.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "featureGates"));
    }
    return this.setNewFeatureGateLike(index, this.buildFeatureGate(index));
  }
  
  public FeatureGatesNested<A> editFirstFeatureGate() {
    if (featureGates.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "featureGates"));
    }
    return this.setNewFeatureGateLike(0, this.buildFeatureGate(0));
  }
  
  public FeatureGatesNested<A> editLastFeatureGate() {
    int index = featureGates.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "featureGates"));
    }
    return this.setNewFeatureGateLike(index, this.buildFeatureGate(index));
  }
  
  public FeatureGatesNested<A> editMatchingFeatureGate(Predicate<FeatureGateBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < featureGates.size();i++) {
      if (predicate.test(featureGates.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "featureGates"));
    }
    return this.setNewFeatureGateLike(index, this.buildFeatureGate(index));
  }
  
  public AddOnKubeClientRegistrationDriverNested<A> editOrNewAddOnKubeClientRegistrationDriver() {
    return this.withNewAddOnKubeClientRegistrationDriverLike(Optional.ofNullable(this.buildAddOnKubeClientRegistrationDriver()).orElse(new AddOnRegistrationDriverBuilder().build()));
  }
  
  public AddOnKubeClientRegistrationDriverNested<A> editOrNewAddOnKubeClientRegistrationDriverLike(AddOnRegistrationDriver item) {
    return this.withNewAddOnKubeClientRegistrationDriverLike(Optional.ofNullable(this.buildAddOnKubeClientRegistrationDriver()).orElse(item));
  }
  
  public BootstrapKubeConfigsNested<A> editOrNewBootstrapKubeConfigs() {
    return this.withNewBootstrapKubeConfigsLike(Optional.ofNullable(this.buildBootstrapKubeConfigs()).orElse(new BootstrapKubeConfigsBuilder().build()));
  }
  
  public BootstrapKubeConfigsNested<A> editOrNewBootstrapKubeConfigsLike(BootstrapKubeConfigs item) {
    return this.withNewBootstrapKubeConfigsLike(Optional.ofNullable(this.buildBootstrapKubeConfigs()).orElse(item));
  }
  
  public ClusterClaimConfigurationNested<A> editOrNewClusterClaimConfiguration() {
    return this.withNewClusterClaimConfigurationLike(Optional.ofNullable(this.buildClusterClaimConfiguration()).orElse(new ClusterClaimConfigurationBuilder().build()));
  }
  
  public ClusterClaimConfigurationNested<A> editOrNewClusterClaimConfigurationLike(ClusterClaimConfiguration item) {
    return this.withNewClusterClaimConfigurationLike(Optional.ofNullable(this.buildClusterClaimConfiguration()).orElse(item));
  }
  
  public RegistrationDriverNested<A> editOrNewRegistrationDriver() {
    return this.withNewRegistrationDriverLike(Optional.ofNullable(this.buildRegistrationDriver()).orElse(new RegistrationDriverBuilder().build()));
  }
  
  public RegistrationDriverNested<A> editOrNewRegistrationDriverLike(RegistrationDriver item) {
    return this.withNewRegistrationDriverLike(Optional.ofNullable(this.buildRegistrationDriver()).orElse(item));
  }
  
  public RegistrationDriverNested<A> editRegistrationDriver() {
    return this.withNewRegistrationDriverLike(Optional.ofNullable(this.buildRegistrationDriver()).orElse(null));
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
    RegistrationConfigurationFluent that = (RegistrationConfigurationFluent) o;
    if (!(Objects.equals(addOnKubeClientRegistrationDriver, that.addOnKubeClientRegistrationDriver))) {
      return false;
    }
    if (!(Objects.equals(bootstrapKubeConfigs, that.bootstrapKubeConfigs))) {
      return false;
    }
    if (!(Objects.equals(clientCertExpirationSeconds, that.clientCertExpirationSeconds))) {
      return false;
    }
    if (!(Objects.equals(clusterAnnotations, that.clusterAnnotations))) {
      return false;
    }
    if (!(Objects.equals(clusterClaimConfiguration, that.clusterClaimConfiguration))) {
      return false;
    }
    if (!(Objects.equals(clusterLabels, that.clusterLabels))) {
      return false;
    }
    if (!(Objects.equals(featureGates, that.featureGates))) {
      return false;
    }
    if (!(Objects.equals(kubeAPIBurst, that.kubeAPIBurst))) {
      return false;
    }
    if (!(Objects.equals(kubeAPIQPS, that.kubeAPIQPS))) {
      return false;
    }
    if (!(Objects.equals(registrationDriver, that.registrationDriver))) {
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
  
  public Integer getClientCertExpirationSeconds() {
    return this.clientCertExpirationSeconds;
  }
  
  public Map<String,String> getClusterAnnotations() {
    return this.clusterAnnotations;
  }
  
  public Map<String,String> getClusterLabels() {
    return this.clusterLabels;
  }
  
  public Integer getKubeAPIBurst() {
    return this.kubeAPIBurst;
  }
  
  public Integer getKubeAPIQPS() {
    return this.kubeAPIQPS;
  }
  
  public boolean hasAddOnKubeClientRegistrationDriver() {
    return this.addOnKubeClientRegistrationDriver != null;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBootstrapKubeConfigs() {
    return this.bootstrapKubeConfigs != null;
  }
  
  public boolean hasClientCertExpirationSeconds() {
    return this.clientCertExpirationSeconds != null;
  }
  
  public boolean hasClusterAnnotations() {
    return this.clusterAnnotations != null;
  }
  
  public boolean hasClusterClaimConfiguration() {
    return this.clusterClaimConfiguration != null;
  }
  
  public boolean hasClusterLabels() {
    return this.clusterLabels != null;
  }
  
  public boolean hasFeatureGates() {
    return this.featureGates != null && !(this.featureGates.isEmpty());
  }
  
  public boolean hasKubeAPIBurst() {
    return this.kubeAPIBurst != null;
  }
  
  public boolean hasKubeAPIQPS() {
    return this.kubeAPIQPS != null;
  }
  
  public boolean hasMatchingFeatureGate(Predicate<FeatureGateBuilder> predicate) {
      for (FeatureGateBuilder item : featureGates) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasRegistrationDriver() {
    return this.registrationDriver != null;
  }
  
  public int hashCode() {
    return Objects.hash(addOnKubeClientRegistrationDriver, bootstrapKubeConfigs, clientCertExpirationSeconds, clusterAnnotations, clusterClaimConfiguration, clusterLabels, featureGates, kubeAPIBurst, kubeAPIQPS, registrationDriver, additionalProperties);
  }
  
  public A removeAllFromFeatureGates(Collection<FeatureGate> items) {
    if (this.featureGates == null) {
      return (A) this;
    }
    for (FeatureGate item : items) {
        FeatureGateBuilder builder = new FeatureGateBuilder(item);
        _visitables.get("featureGates").remove(builder);
        this.featureGates.remove(builder);
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
  
  public A removeFromClusterAnnotations(String key) {
    if (this.clusterAnnotations == null) {
      return (A) this;
    }
    if (key != null && this.clusterAnnotations != null) {
      this.clusterAnnotations.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromClusterAnnotations(Map<String,String> map) {
    if (this.clusterAnnotations == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.clusterAnnotations != null) {
          this.clusterAnnotations.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromClusterLabels(String key) {
    if (this.clusterLabels == null) {
      return (A) this;
    }
    if (key != null && this.clusterLabels != null) {
      this.clusterLabels.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromClusterLabels(Map<String,String> map) {
    if (this.clusterLabels == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.clusterLabels != null) {
          this.clusterLabels.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromFeatureGates(FeatureGate... items) {
    if (this.featureGates == null) {
      return (A) this;
    }
    for (FeatureGate item : items) {
        FeatureGateBuilder builder = new FeatureGateBuilder(item);
        _visitables.get("featureGates").remove(builder);
        this.featureGates.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromFeatureGates(Predicate<FeatureGateBuilder> predicate) {
    if (featureGates == null) {
      return (A) this;
    }
    Iterator<FeatureGateBuilder> each = featureGates.iterator();
    List visitables = _visitables.get("featureGates");
    while (each.hasNext()) {
        FeatureGateBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public FeatureGatesNested<A> setNewFeatureGateLike(int index,FeatureGate item) {
    return new FeatureGatesNested(index, item);
  }
  
  public A setToFeatureGates(int index,FeatureGate item) {
    if (this.featureGates == null) {
      this.featureGates = new ArrayList();
    }
    FeatureGateBuilder builder = new FeatureGateBuilder(item);
    if (index < 0 || index >= featureGates.size()) {
        _visitables.get("featureGates").add(builder);
        featureGates.add(builder);
    } else {
        _visitables.get("featureGates").add(builder);
        featureGates.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(addOnKubeClientRegistrationDriver == null)) {
        sb.append("addOnKubeClientRegistrationDriver:");
        sb.append(addOnKubeClientRegistrationDriver);
        sb.append(",");
    }
    if (!(bootstrapKubeConfigs == null)) {
        sb.append("bootstrapKubeConfigs:");
        sb.append(bootstrapKubeConfigs);
        sb.append(",");
    }
    if (!(clientCertExpirationSeconds == null)) {
        sb.append("clientCertExpirationSeconds:");
        sb.append(clientCertExpirationSeconds);
        sb.append(",");
    }
    if (!(clusterAnnotations == null) && !(clusterAnnotations.isEmpty())) {
        sb.append("clusterAnnotations:");
        sb.append(clusterAnnotations);
        sb.append(",");
    }
    if (!(clusterClaimConfiguration == null)) {
        sb.append("clusterClaimConfiguration:");
        sb.append(clusterClaimConfiguration);
        sb.append(",");
    }
    if (!(clusterLabels == null) && !(clusterLabels.isEmpty())) {
        sb.append("clusterLabels:");
        sb.append(clusterLabels);
        sb.append(",");
    }
    if (!(featureGates == null) && !(featureGates.isEmpty())) {
        sb.append("featureGates:");
        sb.append(featureGates);
        sb.append(",");
    }
    if (!(kubeAPIBurst == null)) {
        sb.append("kubeAPIBurst:");
        sb.append(kubeAPIBurst);
        sb.append(",");
    }
    if (!(kubeAPIQPS == null)) {
        sb.append("kubeAPIQPS:");
        sb.append(kubeAPIQPS);
        sb.append(",");
    }
    if (!(registrationDriver == null)) {
        sb.append("registrationDriver:");
        sb.append(registrationDriver);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAddOnKubeClientRegistrationDriver(AddOnRegistrationDriver addOnKubeClientRegistrationDriver) {
    this._visitables.remove("addOnKubeClientRegistrationDriver");
    if (addOnKubeClientRegistrationDriver != null) {
        this.addOnKubeClientRegistrationDriver = new AddOnRegistrationDriverBuilder(addOnKubeClientRegistrationDriver);
        this._visitables.get("addOnKubeClientRegistrationDriver").add(this.addOnKubeClientRegistrationDriver);
    } else {
        this.addOnKubeClientRegistrationDriver = null;
        this._visitables.get("addOnKubeClientRegistrationDriver").remove(this.addOnKubeClientRegistrationDriver);
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withBootstrapKubeConfigs(BootstrapKubeConfigs bootstrapKubeConfigs) {
    this._visitables.remove("bootstrapKubeConfigs");
    if (bootstrapKubeConfigs != null) {
        this.bootstrapKubeConfigs = new BootstrapKubeConfigsBuilder(bootstrapKubeConfigs);
        this._visitables.get("bootstrapKubeConfigs").add(this.bootstrapKubeConfigs);
    } else {
        this.bootstrapKubeConfigs = null;
        this._visitables.get("bootstrapKubeConfigs").remove(this.bootstrapKubeConfigs);
    }
    return (A) this;
  }
  
  public A withClientCertExpirationSeconds(Integer clientCertExpirationSeconds) {
    this.clientCertExpirationSeconds = clientCertExpirationSeconds;
    return (A) this;
  }
  
  public <K,V>A withClusterAnnotations(Map<String,String> clusterAnnotations) {
    if (clusterAnnotations == null) {
      this.clusterAnnotations = null;
    } else {
      this.clusterAnnotations = new LinkedHashMap(clusterAnnotations);
    }
    return (A) this;
  }
  
  public A withClusterClaimConfiguration(ClusterClaimConfiguration clusterClaimConfiguration) {
    this._visitables.remove("clusterClaimConfiguration");
    if (clusterClaimConfiguration != null) {
        this.clusterClaimConfiguration = new ClusterClaimConfigurationBuilder(clusterClaimConfiguration);
        this._visitables.get("clusterClaimConfiguration").add(this.clusterClaimConfiguration);
    } else {
        this.clusterClaimConfiguration = null;
        this._visitables.get("clusterClaimConfiguration").remove(this.clusterClaimConfiguration);
    }
    return (A) this;
  }
  
  public <K,V>A withClusterLabels(Map<String,String> clusterLabels) {
    if (clusterLabels == null) {
      this.clusterLabels = null;
    } else {
      this.clusterLabels = new LinkedHashMap(clusterLabels);
    }
    return (A) this;
  }
  
  public A withFeatureGates(List<FeatureGate> featureGates) {
    if (this.featureGates != null) {
      this._visitables.get("featureGates").clear();
    }
    if (featureGates != null) {
        this.featureGates = new ArrayList();
        for (FeatureGate item : featureGates) {
          this.addToFeatureGates(item);
        }
    } else {
      this.featureGates = null;
    }
    return (A) this;
  }
  
  public A withFeatureGates(FeatureGate... featureGates) {
    if (this.featureGates != null) {
        this.featureGates.clear();
        _visitables.remove("featureGates");
    }
    if (featureGates != null) {
      for (FeatureGate item : featureGates) {
        this.addToFeatureGates(item);
      }
    }
    return (A) this;
  }
  
  public A withKubeAPIBurst(Integer kubeAPIBurst) {
    this.kubeAPIBurst = kubeAPIBurst;
    return (A) this;
  }
  
  public A withKubeAPIQPS(Integer kubeAPIQPS) {
    this.kubeAPIQPS = kubeAPIQPS;
    return (A) this;
  }
  
  public AddOnKubeClientRegistrationDriverNested<A> withNewAddOnKubeClientRegistrationDriver() {
    return new AddOnKubeClientRegistrationDriverNested(null);
  }
  
  public AddOnKubeClientRegistrationDriverNested<A> withNewAddOnKubeClientRegistrationDriverLike(AddOnRegistrationDriver item) {
    return new AddOnKubeClientRegistrationDriverNested(item);
  }
  
  public BootstrapKubeConfigsNested<A> withNewBootstrapKubeConfigs() {
    return new BootstrapKubeConfigsNested(null);
  }
  
  public BootstrapKubeConfigsNested<A> withNewBootstrapKubeConfigsLike(BootstrapKubeConfigs item) {
    return new BootstrapKubeConfigsNested(item);
  }
  
  public ClusterClaimConfigurationNested<A> withNewClusterClaimConfiguration() {
    return new ClusterClaimConfigurationNested(null);
  }
  
  public ClusterClaimConfigurationNested<A> withNewClusterClaimConfigurationLike(ClusterClaimConfiguration item) {
    return new ClusterClaimConfigurationNested(item);
  }
  
  public RegistrationDriverNested<A> withNewRegistrationDriver() {
    return new RegistrationDriverNested(null);
  }
  
  public RegistrationDriverNested<A> withNewRegistrationDriverLike(RegistrationDriver item) {
    return new RegistrationDriverNested(item);
  }
  
  public A withRegistrationDriver(RegistrationDriver registrationDriver) {
    this._visitables.remove("registrationDriver");
    if (registrationDriver != null) {
        this.registrationDriver = new RegistrationDriverBuilder(registrationDriver);
        this._visitables.get("registrationDriver").add(this.registrationDriver);
    } else {
        this.registrationDriver = null;
        this._visitables.get("registrationDriver").remove(this.registrationDriver);
    }
    return (A) this;
  }
  public class AddOnKubeClientRegistrationDriverNested<N> extends AddOnRegistrationDriverFluent<AddOnKubeClientRegistrationDriverNested<N>> implements Nested<N>{
  
    AddOnRegistrationDriverBuilder builder;
  
    AddOnKubeClientRegistrationDriverNested(AddOnRegistrationDriver item) {
      this.builder = new AddOnRegistrationDriverBuilder(this, item);
    }
  
    public N and() {
      return (N) RegistrationConfigurationFluent.this.withAddOnKubeClientRegistrationDriver(builder.build());
    }
    
    public N endAddOnKubeClientRegistrationDriver() {
      return and();
    }
    
  }
  public class BootstrapKubeConfigsNested<N> extends BootstrapKubeConfigsFluent<BootstrapKubeConfigsNested<N>> implements Nested<N>{
  
    BootstrapKubeConfigsBuilder builder;
  
    BootstrapKubeConfigsNested(BootstrapKubeConfigs item) {
      this.builder = new BootstrapKubeConfigsBuilder(this, item);
    }
  
    public N and() {
      return (N) RegistrationConfigurationFluent.this.withBootstrapKubeConfigs(builder.build());
    }
    
    public N endBootstrapKubeConfigs() {
      return and();
    }
    
  }
  public class ClusterClaimConfigurationNested<N> extends ClusterClaimConfigurationFluent<ClusterClaimConfigurationNested<N>> implements Nested<N>{
  
    ClusterClaimConfigurationBuilder builder;
  
    ClusterClaimConfigurationNested(ClusterClaimConfiguration item) {
      this.builder = new ClusterClaimConfigurationBuilder(this, item);
    }
  
    public N and() {
      return (N) RegistrationConfigurationFluent.this.withClusterClaimConfiguration(builder.build());
    }
    
    public N endClusterClaimConfiguration() {
      return and();
    }
    
  }
  public class FeatureGatesNested<N> extends FeatureGateFluent<FeatureGatesNested<N>> implements Nested<N>{
  
    FeatureGateBuilder builder;
    int index;
  
    FeatureGatesNested(int index,FeatureGate item) {
      this.index = index;
      this.builder = new FeatureGateBuilder(this, item);
    }
  
    public N and() {
      return (N) RegistrationConfigurationFluent.this.setToFeatureGates(index, builder.build());
    }
    
    public N endFeatureGate() {
      return and();
    }
    
  }
  public class RegistrationDriverNested<N> extends RegistrationDriverFluent<RegistrationDriverNested<N>> implements Nested<N>{
  
    RegistrationDriverBuilder builder;
  
    RegistrationDriverNested(RegistrationDriver item) {
      this.builder = new RegistrationDriverBuilder(this, item);
    }
  
    public N and() {
      return (N) RegistrationConfigurationFluent.this.withRegistrationDriver(builder.build());
    }
    
    public N endRegistrationDriver() {
      return and();
    }
    
  }
}