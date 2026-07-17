package io.fabric8.openshift.api.model.operator.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class NetworkSpecFluent<A extends io.fabric8.openshift.api.model.operator.v1.NetworkSpecFluent<A>> extends BaseFluent<A>{

  private ArrayList<AdditionalNetworkDefinitionBuilder> additionalNetworks = new ArrayList<AdditionalNetworkDefinitionBuilder>();
  private Map<String,Object> additionalProperties;
  private AdditionalRoutingCapabilitiesBuilder additionalRoutingCapabilities;
  private ArrayList<ClusterNetworkEntryBuilder> clusterNetwork = new ArrayList<ClusterNetworkEntryBuilder>();
  private DefaultNetworkDefinitionBuilder defaultNetwork;
  private Boolean deployKubeProxy;
  private Boolean disableMultiNetwork;
  private Boolean disableNetworkDiagnostics;
  private ExportNetworkFlowsBuilder exportNetworkFlows;
  private ProxyConfigBuilder kubeProxyConfig;
  private String logLevel;
  private String managementState;
  private NetworkMigrationBuilder migration;
  private Object observedConfig;
  private String operatorLogLevel;
  private List<String> serviceNetwork = new ArrayList<String>();
  private Object unsupportedConfigOverrides;
  private Boolean useMultiNetworkPolicy;

  public NetworkSpecFluent() {
  }
  
  public NetworkSpecFluent(NetworkSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAdditionalNetworks(Collection<AdditionalNetworkDefinition> items) {
    if (this.additionalNetworks == null) {
      this.additionalNetworks = new ArrayList();
    }
    for (AdditionalNetworkDefinition item : items) {
        AdditionalNetworkDefinitionBuilder builder = new AdditionalNetworkDefinitionBuilder(item);
        _visitables.get("additionalNetworks").add(builder);
        this.additionalNetworks.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToClusterNetwork(Collection<ClusterNetworkEntry> items) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").add(builder);
        this.clusterNetwork.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToServiceNetwork(Collection<String> items) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    for (String item : items) {
      this.serviceNetwork.add(item);
    }
    return (A) this;
  }
  
  public AdditionalNetworksNested<A> addNewAdditionalNetwork() {
    return new AdditionalNetworksNested(-1, null);
  }
  
  public AdditionalNetworksNested<A> addNewAdditionalNetworkLike(AdditionalNetworkDefinition item) {
    return new AdditionalNetworksNested(-1, item);
  }
  
  public ClusterNetworkNested<A> addNewClusterNetwork() {
    return new ClusterNetworkNested(-1, null);
  }
  
  public A addNewClusterNetwork(String cidr,Long hostPrefix) {
    return (A) this.addToClusterNetwork(new ClusterNetworkEntry(cidr, hostPrefix));
  }
  
  public ClusterNetworkNested<A> addNewClusterNetworkLike(ClusterNetworkEntry item) {
    return new ClusterNetworkNested(-1, item);
  }
  
  public A addToAdditionalNetworks(AdditionalNetworkDefinition... items) {
    if (this.additionalNetworks == null) {
      this.additionalNetworks = new ArrayList();
    }
    for (AdditionalNetworkDefinition item : items) {
        AdditionalNetworkDefinitionBuilder builder = new AdditionalNetworkDefinitionBuilder(item);
        _visitables.get("additionalNetworks").add(builder);
        this.additionalNetworks.add(builder);
    }
    return (A) this;
  }
  
  public A addToAdditionalNetworks(int index,AdditionalNetworkDefinition item) {
    if (this.additionalNetworks == null) {
      this.additionalNetworks = new ArrayList();
    }
    AdditionalNetworkDefinitionBuilder builder = new AdditionalNetworkDefinitionBuilder(item);
    if (index < 0 || index >= additionalNetworks.size()) {
        _visitables.get("additionalNetworks").add(builder);
        additionalNetworks.add(builder);
    } else {
        _visitables.get("additionalNetworks").add(builder);
        additionalNetworks.add(index, builder);
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
  
  public A addToClusterNetwork(ClusterNetworkEntry... items) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").add(builder);
        this.clusterNetwork.add(builder);
    }
    return (A) this;
  }
  
  public A addToClusterNetwork(int index,ClusterNetworkEntry item) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
    if (index < 0 || index >= clusterNetwork.size()) {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.add(builder);
    } else {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToServiceNetwork(String... items) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    for (String item : items) {
      this.serviceNetwork.add(item);
    }
    return (A) this;
  }
  
  public A addToServiceNetwork(int index,String item) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    this.serviceNetwork.add(index, item);
    return (A) this;
  }
  
  public AdditionalNetworkDefinition buildAdditionalNetwork(int index) {
    return this.additionalNetworks.get(index).build();
  }
  
  public List<AdditionalNetworkDefinition> buildAdditionalNetworks() {
    return this.additionalNetworks != null ? build(additionalNetworks) : null;
  }
  
  public AdditionalRoutingCapabilities buildAdditionalRoutingCapabilities() {
    return this.additionalRoutingCapabilities != null ? this.additionalRoutingCapabilities.build() : null;
  }
  
  public List<ClusterNetworkEntry> buildClusterNetwork() {
    return this.clusterNetwork != null ? build(clusterNetwork) : null;
  }
  
  public ClusterNetworkEntry buildClusterNetwork(int index) {
    return this.clusterNetwork.get(index).build();
  }
  
  public DefaultNetworkDefinition buildDefaultNetwork() {
    return this.defaultNetwork != null ? this.defaultNetwork.build() : null;
  }
  
  public ExportNetworkFlows buildExportNetworkFlows() {
    return this.exportNetworkFlows != null ? this.exportNetworkFlows.build() : null;
  }
  
  public AdditionalNetworkDefinition buildFirstAdditionalNetwork() {
    return this.additionalNetworks.get(0).build();
  }
  
  public ClusterNetworkEntry buildFirstClusterNetwork() {
    return this.clusterNetwork.get(0).build();
  }
  
  public ProxyConfig buildKubeProxyConfig() {
    return this.kubeProxyConfig != null ? this.kubeProxyConfig.build() : null;
  }
  
  public AdditionalNetworkDefinition buildLastAdditionalNetwork() {
    return this.additionalNetworks.get(additionalNetworks.size() - 1).build();
  }
  
  public ClusterNetworkEntry buildLastClusterNetwork() {
    return this.clusterNetwork.get(clusterNetwork.size() - 1).build();
  }
  
  public AdditionalNetworkDefinition buildMatchingAdditionalNetwork(Predicate<AdditionalNetworkDefinitionBuilder> predicate) {
      for (AdditionalNetworkDefinitionBuilder item : additionalNetworks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ClusterNetworkEntry buildMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
      for (ClusterNetworkEntryBuilder item : clusterNetwork) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public NetworkMigration buildMigration() {
    return this.migration != null ? this.migration.build() : null;
  }
  
  protected void copyInstance(NetworkSpec instance) {
    instance = instance != null ? instance : new NetworkSpec();
    if (instance != null) {
        this.withAdditionalNetworks(instance.getAdditionalNetworks());
        this.withAdditionalRoutingCapabilities(instance.getAdditionalRoutingCapabilities());
        this.withClusterNetwork(instance.getClusterNetwork());
        this.withDefaultNetwork(instance.getDefaultNetwork());
        this.withDeployKubeProxy(instance.getDeployKubeProxy());
        this.withDisableMultiNetwork(instance.getDisableMultiNetwork());
        this.withDisableNetworkDiagnostics(instance.getDisableNetworkDiagnostics());
        this.withExportNetworkFlows(instance.getExportNetworkFlows());
        this.withKubeProxyConfig(instance.getKubeProxyConfig());
        this.withLogLevel(instance.getLogLevel());
        this.withManagementState(instance.getManagementState());
        this.withMigration(instance.getMigration());
        this.withObservedConfig(instance.getObservedConfig());
        this.withOperatorLogLevel(instance.getOperatorLogLevel());
        this.withServiceNetwork(instance.getServiceNetwork());
        this.withUnsupportedConfigOverrides(instance.getUnsupportedConfigOverrides());
        this.withUseMultiNetworkPolicy(instance.getUseMultiNetworkPolicy());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AdditionalNetworksNested<A> editAdditionalNetwork(int index) {
    if (additionalNetworks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "additionalNetworks"));
    }
    return this.setNewAdditionalNetworkLike(index, this.buildAdditionalNetwork(index));
  }
  
  public AdditionalRoutingCapabilitiesNested<A> editAdditionalRoutingCapabilities() {
    return this.withNewAdditionalRoutingCapabilitiesLike(Optional.ofNullable(this.buildAdditionalRoutingCapabilities()).orElse(null));
  }
  
  public ClusterNetworkNested<A> editClusterNetwork(int index) {
    if (clusterNetwork.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public DefaultNetworkNested<A> editDefaultNetwork() {
    return this.withNewDefaultNetworkLike(Optional.ofNullable(this.buildDefaultNetwork()).orElse(null));
  }
  
  public ExportNetworkFlowsNested<A> editExportNetworkFlows() {
    return this.withNewExportNetworkFlowsLike(Optional.ofNullable(this.buildExportNetworkFlows()).orElse(null));
  }
  
  public AdditionalNetworksNested<A> editFirstAdditionalNetwork() {
    if (additionalNetworks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "additionalNetworks"));
    }
    return this.setNewAdditionalNetworkLike(0, this.buildAdditionalNetwork(0));
  }
  
  public ClusterNetworkNested<A> editFirstClusterNetwork() {
    if (clusterNetwork.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(0, this.buildClusterNetwork(0));
  }
  
  public KubeProxyConfigNested<A> editKubeProxyConfig() {
    return this.withNewKubeProxyConfigLike(Optional.ofNullable(this.buildKubeProxyConfig()).orElse(null));
  }
  
  public AdditionalNetworksNested<A> editLastAdditionalNetwork() {
    int index = additionalNetworks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "additionalNetworks"));
    }
    return this.setNewAdditionalNetworkLike(index, this.buildAdditionalNetwork(index));
  }
  
  public ClusterNetworkNested<A> editLastClusterNetwork() {
    int index = clusterNetwork.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public AdditionalNetworksNested<A> editMatchingAdditionalNetwork(Predicate<AdditionalNetworkDefinitionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < additionalNetworks.size();i++) {
      if (predicate.test(additionalNetworks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "additionalNetworks"));
    }
    return this.setNewAdditionalNetworkLike(index, this.buildAdditionalNetwork(index));
  }
  
  public ClusterNetworkNested<A> editMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < clusterNetwork.size();i++) {
      if (predicate.test(clusterNetwork.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "clusterNetwork"));
    }
    return this.setNewClusterNetworkLike(index, this.buildClusterNetwork(index));
  }
  
  public MigrationNested<A> editMigration() {
    return this.withNewMigrationLike(Optional.ofNullable(this.buildMigration()).orElse(null));
  }
  
  public AdditionalRoutingCapabilitiesNested<A> editOrNewAdditionalRoutingCapabilities() {
    return this.withNewAdditionalRoutingCapabilitiesLike(Optional.ofNullable(this.buildAdditionalRoutingCapabilities()).orElse(new AdditionalRoutingCapabilitiesBuilder().build()));
  }
  
  public AdditionalRoutingCapabilitiesNested<A> editOrNewAdditionalRoutingCapabilitiesLike(AdditionalRoutingCapabilities item) {
    return this.withNewAdditionalRoutingCapabilitiesLike(Optional.ofNullable(this.buildAdditionalRoutingCapabilities()).orElse(item));
  }
  
  public DefaultNetworkNested<A> editOrNewDefaultNetwork() {
    return this.withNewDefaultNetworkLike(Optional.ofNullable(this.buildDefaultNetwork()).orElse(new DefaultNetworkDefinitionBuilder().build()));
  }
  
  public DefaultNetworkNested<A> editOrNewDefaultNetworkLike(DefaultNetworkDefinition item) {
    return this.withNewDefaultNetworkLike(Optional.ofNullable(this.buildDefaultNetwork()).orElse(item));
  }
  
  public ExportNetworkFlowsNested<A> editOrNewExportNetworkFlows() {
    return this.withNewExportNetworkFlowsLike(Optional.ofNullable(this.buildExportNetworkFlows()).orElse(new ExportNetworkFlowsBuilder().build()));
  }
  
  public ExportNetworkFlowsNested<A> editOrNewExportNetworkFlowsLike(ExportNetworkFlows item) {
    return this.withNewExportNetworkFlowsLike(Optional.ofNullable(this.buildExportNetworkFlows()).orElse(item));
  }
  
  public KubeProxyConfigNested<A> editOrNewKubeProxyConfig() {
    return this.withNewKubeProxyConfigLike(Optional.ofNullable(this.buildKubeProxyConfig()).orElse(new ProxyConfigBuilder().build()));
  }
  
  public KubeProxyConfigNested<A> editOrNewKubeProxyConfigLike(ProxyConfig item) {
    return this.withNewKubeProxyConfigLike(Optional.ofNullable(this.buildKubeProxyConfig()).orElse(item));
  }
  
  public MigrationNested<A> editOrNewMigration() {
    return this.withNewMigrationLike(Optional.ofNullable(this.buildMigration()).orElse(new NetworkMigrationBuilder().build()));
  }
  
  public MigrationNested<A> editOrNewMigrationLike(NetworkMigration item) {
    return this.withNewMigrationLike(Optional.ofNullable(this.buildMigration()).orElse(item));
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
    NetworkSpecFluent that = (NetworkSpecFluent) o;
    if (!(Objects.equals(additionalNetworks, that.additionalNetworks))) {
      return false;
    }
    if (!(Objects.equals(additionalRoutingCapabilities, that.additionalRoutingCapabilities))) {
      return false;
    }
    if (!(Objects.equals(clusterNetwork, that.clusterNetwork))) {
      return false;
    }
    if (!(Objects.equals(defaultNetwork, that.defaultNetwork))) {
      return false;
    }
    if (!(Objects.equals(deployKubeProxy, that.deployKubeProxy))) {
      return false;
    }
    if (!(Objects.equals(disableMultiNetwork, that.disableMultiNetwork))) {
      return false;
    }
    if (!(Objects.equals(disableNetworkDiagnostics, that.disableNetworkDiagnostics))) {
      return false;
    }
    if (!(Objects.equals(exportNetworkFlows, that.exportNetworkFlows))) {
      return false;
    }
    if (!(Objects.equals(kubeProxyConfig, that.kubeProxyConfig))) {
      return false;
    }
    if (!(Objects.equals(logLevel, that.logLevel))) {
      return false;
    }
    if (!(Objects.equals(managementState, that.managementState))) {
      return false;
    }
    if (!(Objects.equals(migration, that.migration))) {
      return false;
    }
    if (!(Objects.equals(observedConfig, that.observedConfig))) {
      return false;
    }
    if (!(Objects.equals(operatorLogLevel, that.operatorLogLevel))) {
      return false;
    }
    if (!(Objects.equals(serviceNetwork, that.serviceNetwork))) {
      return false;
    }
    if (!(Objects.equals(unsupportedConfigOverrides, that.unsupportedConfigOverrides))) {
      return false;
    }
    if (!(Objects.equals(useMultiNetworkPolicy, that.useMultiNetworkPolicy))) {
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
  
  public Boolean getDeployKubeProxy() {
    return this.deployKubeProxy;
  }
  
  public Boolean getDisableMultiNetwork() {
    return this.disableMultiNetwork;
  }
  
  public Boolean getDisableNetworkDiagnostics() {
    return this.disableNetworkDiagnostics;
  }
  
  public String getFirstServiceNetwork() {
    return this.serviceNetwork.get(0);
  }
  
  public String getLastServiceNetwork() {
    return this.serviceNetwork.get(serviceNetwork.size() - 1);
  }
  
  public String getLogLevel() {
    return this.logLevel;
  }
  
  public String getManagementState() {
    return this.managementState;
  }
  
  public String getMatchingServiceNetwork(Predicate<String> predicate) {
      for (String item : serviceNetwork) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public Object getObservedConfig() {
    return this.observedConfig;
  }
  
  public String getOperatorLogLevel() {
    return this.operatorLogLevel;
  }
  
  public List<String> getServiceNetwork() {
    return this.serviceNetwork;
  }
  
  public String getServiceNetwork(int index) {
    return this.serviceNetwork.get(index);
  }
  
  public Object getUnsupportedConfigOverrides() {
    return this.unsupportedConfigOverrides;
  }
  
  public Boolean getUseMultiNetworkPolicy() {
    return this.useMultiNetworkPolicy;
  }
  
  public boolean hasAdditionalNetworks() {
    return this.additionalNetworks != null && !(this.additionalNetworks.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAdditionalRoutingCapabilities() {
    return this.additionalRoutingCapabilities != null;
  }
  
  public boolean hasClusterNetwork() {
    return this.clusterNetwork != null && !(this.clusterNetwork.isEmpty());
  }
  
  public boolean hasDefaultNetwork() {
    return this.defaultNetwork != null;
  }
  
  public boolean hasDeployKubeProxy() {
    return this.deployKubeProxy != null;
  }
  
  public boolean hasDisableMultiNetwork() {
    return this.disableMultiNetwork != null;
  }
  
  public boolean hasDisableNetworkDiagnostics() {
    return this.disableNetworkDiagnostics != null;
  }
  
  public boolean hasExportNetworkFlows() {
    return this.exportNetworkFlows != null;
  }
  
  public boolean hasKubeProxyConfig() {
    return this.kubeProxyConfig != null;
  }
  
  public boolean hasLogLevel() {
    return this.logLevel != null;
  }
  
  public boolean hasManagementState() {
    return this.managementState != null;
  }
  
  public boolean hasMatchingAdditionalNetwork(Predicate<AdditionalNetworkDefinitionBuilder> predicate) {
      for (AdditionalNetworkDefinitionBuilder item : additionalNetworks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
      for (ClusterNetworkEntryBuilder item : clusterNetwork) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingServiceNetwork(Predicate<String> predicate) {
      for (String item : serviceNetwork) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMigration() {
    return this.migration != null;
  }
  
  public boolean hasObservedConfig() {
    return this.observedConfig != null;
  }
  
  public boolean hasOperatorLogLevel() {
    return this.operatorLogLevel != null;
  }
  
  public boolean hasServiceNetwork() {
    return this.serviceNetwork != null && !(this.serviceNetwork.isEmpty());
  }
  
  public boolean hasUnsupportedConfigOverrides() {
    return this.unsupportedConfigOverrides != null;
  }
  
  public boolean hasUseMultiNetworkPolicy() {
    return this.useMultiNetworkPolicy != null;
  }
  
  public int hashCode() {
    return Objects.hash(additionalNetworks, additionalRoutingCapabilities, clusterNetwork, defaultNetwork, deployKubeProxy, disableMultiNetwork, disableNetworkDiagnostics, exportNetworkFlows, kubeProxyConfig, logLevel, managementState, migration, observedConfig, operatorLogLevel, serviceNetwork, unsupportedConfigOverrides, useMultiNetworkPolicy, additionalProperties);
  }
  
  public A removeAllFromAdditionalNetworks(Collection<AdditionalNetworkDefinition> items) {
    if (this.additionalNetworks == null) {
      return (A) this;
    }
    for (AdditionalNetworkDefinition item : items) {
        AdditionalNetworkDefinitionBuilder builder = new AdditionalNetworkDefinitionBuilder(item);
        _visitables.get("additionalNetworks").remove(builder);
        this.additionalNetworks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromClusterNetwork(Collection<ClusterNetworkEntry> items) {
    if (this.clusterNetwork == null) {
      return (A) this;
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").remove(builder);
        this.clusterNetwork.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromServiceNetwork(Collection<String> items) {
    if (this.serviceNetwork == null) {
      return (A) this;
    }
    for (String item : items) {
      this.serviceNetwork.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalNetworks(AdditionalNetworkDefinition... items) {
    if (this.additionalNetworks == null) {
      return (A) this;
    }
    for (AdditionalNetworkDefinition item : items) {
        AdditionalNetworkDefinitionBuilder builder = new AdditionalNetworkDefinitionBuilder(item);
        _visitables.get("additionalNetworks").remove(builder);
        this.additionalNetworks.remove(builder);
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
  
  public A removeFromClusterNetwork(ClusterNetworkEntry... items) {
    if (this.clusterNetwork == null) {
      return (A) this;
    }
    for (ClusterNetworkEntry item : items) {
        ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
        _visitables.get("clusterNetwork").remove(builder);
        this.clusterNetwork.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromServiceNetwork(String... items) {
    if (this.serviceNetwork == null) {
      return (A) this;
    }
    for (String item : items) {
      this.serviceNetwork.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromAdditionalNetworks(Predicate<AdditionalNetworkDefinitionBuilder> predicate) {
    if (additionalNetworks == null) {
      return (A) this;
    }
    Iterator<AdditionalNetworkDefinitionBuilder> each = additionalNetworks.iterator();
    List visitables = _visitables.get("additionalNetworks");
    while (each.hasNext()) {
        AdditionalNetworkDefinitionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromClusterNetwork(Predicate<ClusterNetworkEntryBuilder> predicate) {
    if (clusterNetwork == null) {
      return (A) this;
    }
    Iterator<ClusterNetworkEntryBuilder> each = clusterNetwork.iterator();
    List visitables = _visitables.get("clusterNetwork");
    while (each.hasNext()) {
        ClusterNetworkEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public AdditionalNetworksNested<A> setNewAdditionalNetworkLike(int index,AdditionalNetworkDefinition item) {
    return new AdditionalNetworksNested(index, item);
  }
  
  public ClusterNetworkNested<A> setNewClusterNetworkLike(int index,ClusterNetworkEntry item) {
    return new ClusterNetworkNested(index, item);
  }
  
  public A setToAdditionalNetworks(int index,AdditionalNetworkDefinition item) {
    if (this.additionalNetworks == null) {
      this.additionalNetworks = new ArrayList();
    }
    AdditionalNetworkDefinitionBuilder builder = new AdditionalNetworkDefinitionBuilder(item);
    if (index < 0 || index >= additionalNetworks.size()) {
        _visitables.get("additionalNetworks").add(builder);
        additionalNetworks.add(builder);
    } else {
        _visitables.get("additionalNetworks").add(builder);
        additionalNetworks.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToClusterNetwork(int index,ClusterNetworkEntry item) {
    if (this.clusterNetwork == null) {
      this.clusterNetwork = new ArrayList();
    }
    ClusterNetworkEntryBuilder builder = new ClusterNetworkEntryBuilder(item);
    if (index < 0 || index >= clusterNetwork.size()) {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.add(builder);
    } else {
        _visitables.get("clusterNetwork").add(builder);
        clusterNetwork.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToServiceNetwork(int index,String item) {
    if (this.serviceNetwork == null) {
      this.serviceNetwork = new ArrayList();
    }
    this.serviceNetwork.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(additionalNetworks == null) && !(additionalNetworks.isEmpty())) {
        sb.append("additionalNetworks:");
        sb.append(additionalNetworks);
        sb.append(",");
    }
    if (!(additionalRoutingCapabilities == null)) {
        sb.append("additionalRoutingCapabilities:");
        sb.append(additionalRoutingCapabilities);
        sb.append(",");
    }
    if (!(clusterNetwork == null) && !(clusterNetwork.isEmpty())) {
        sb.append("clusterNetwork:");
        sb.append(clusterNetwork);
        sb.append(",");
    }
    if (!(defaultNetwork == null)) {
        sb.append("defaultNetwork:");
        sb.append(defaultNetwork);
        sb.append(",");
    }
    if (!(deployKubeProxy == null)) {
        sb.append("deployKubeProxy:");
        sb.append(deployKubeProxy);
        sb.append(",");
    }
    if (!(disableMultiNetwork == null)) {
        sb.append("disableMultiNetwork:");
        sb.append(disableMultiNetwork);
        sb.append(",");
    }
    if (!(disableNetworkDiagnostics == null)) {
        sb.append("disableNetworkDiagnostics:");
        sb.append(disableNetworkDiagnostics);
        sb.append(",");
    }
    if (!(exportNetworkFlows == null)) {
        sb.append("exportNetworkFlows:");
        sb.append(exportNetworkFlows);
        sb.append(",");
    }
    if (!(kubeProxyConfig == null)) {
        sb.append("kubeProxyConfig:");
        sb.append(kubeProxyConfig);
        sb.append(",");
    }
    if (!(logLevel == null)) {
        sb.append("logLevel:");
        sb.append(logLevel);
        sb.append(",");
    }
    if (!(managementState == null)) {
        sb.append("managementState:");
        sb.append(managementState);
        sb.append(",");
    }
    if (!(migration == null)) {
        sb.append("migration:");
        sb.append(migration);
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
    if (!(serviceNetwork == null) && !(serviceNetwork.isEmpty())) {
        sb.append("serviceNetwork:");
        sb.append(serviceNetwork);
        sb.append(",");
    }
    if (!(unsupportedConfigOverrides == null)) {
        sb.append("unsupportedConfigOverrides:");
        sb.append(unsupportedConfigOverrides);
        sb.append(",");
    }
    if (!(useMultiNetworkPolicy == null)) {
        sb.append("useMultiNetworkPolicy:");
        sb.append(useMultiNetworkPolicy);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAdditionalNetworks(List<AdditionalNetworkDefinition> additionalNetworks) {
    if (this.additionalNetworks != null) {
      this._visitables.get("additionalNetworks").clear();
    }
    if (additionalNetworks != null) {
        this.additionalNetworks = new ArrayList();
        for (AdditionalNetworkDefinition item : additionalNetworks) {
          this.addToAdditionalNetworks(item);
        }
    } else {
      this.additionalNetworks = null;
    }
    return (A) this;
  }
  
  public A withAdditionalNetworks(AdditionalNetworkDefinition... additionalNetworks) {
    if (this.additionalNetworks != null) {
        this.additionalNetworks.clear();
        _visitables.remove("additionalNetworks");
    }
    if (additionalNetworks != null) {
      for (AdditionalNetworkDefinition item : additionalNetworks) {
        this.addToAdditionalNetworks(item);
      }
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
  
  public A withAdditionalRoutingCapabilities(AdditionalRoutingCapabilities additionalRoutingCapabilities) {
    this._visitables.remove("additionalRoutingCapabilities");
    if (additionalRoutingCapabilities != null) {
        this.additionalRoutingCapabilities = new AdditionalRoutingCapabilitiesBuilder(additionalRoutingCapabilities);
        this._visitables.get("additionalRoutingCapabilities").add(this.additionalRoutingCapabilities);
    } else {
        this.additionalRoutingCapabilities = null;
        this._visitables.get("additionalRoutingCapabilities").remove(this.additionalRoutingCapabilities);
    }
    return (A) this;
  }
  
  public A withClusterNetwork(List<ClusterNetworkEntry> clusterNetwork) {
    if (this.clusterNetwork != null) {
      this._visitables.get("clusterNetwork").clear();
    }
    if (clusterNetwork != null) {
        this.clusterNetwork = new ArrayList();
        for (ClusterNetworkEntry item : clusterNetwork) {
          this.addToClusterNetwork(item);
        }
    } else {
      this.clusterNetwork = null;
    }
    return (A) this;
  }
  
  public A withClusterNetwork(ClusterNetworkEntry... clusterNetwork) {
    if (this.clusterNetwork != null) {
        this.clusterNetwork.clear();
        _visitables.remove("clusterNetwork");
    }
    if (clusterNetwork != null) {
      for (ClusterNetworkEntry item : clusterNetwork) {
        this.addToClusterNetwork(item);
      }
    }
    return (A) this;
  }
  
  public A withDefaultNetwork(DefaultNetworkDefinition defaultNetwork) {
    this._visitables.remove("defaultNetwork");
    if (defaultNetwork != null) {
        this.defaultNetwork = new DefaultNetworkDefinitionBuilder(defaultNetwork);
        this._visitables.get("defaultNetwork").add(this.defaultNetwork);
    } else {
        this.defaultNetwork = null;
        this._visitables.get("defaultNetwork").remove(this.defaultNetwork);
    }
    return (A) this;
  }
  
  public A withDeployKubeProxy() {
    return withDeployKubeProxy(true);
  }
  
  public A withDeployKubeProxy(Boolean deployKubeProxy) {
    this.deployKubeProxy = deployKubeProxy;
    return (A) this;
  }
  
  public A withDisableMultiNetwork() {
    return withDisableMultiNetwork(true);
  }
  
  public A withDisableMultiNetwork(Boolean disableMultiNetwork) {
    this.disableMultiNetwork = disableMultiNetwork;
    return (A) this;
  }
  
  public A withDisableNetworkDiagnostics() {
    return withDisableNetworkDiagnostics(true);
  }
  
  public A withDisableNetworkDiagnostics(Boolean disableNetworkDiagnostics) {
    this.disableNetworkDiagnostics = disableNetworkDiagnostics;
    return (A) this;
  }
  
  public A withExportNetworkFlows(ExportNetworkFlows exportNetworkFlows) {
    this._visitables.remove("exportNetworkFlows");
    if (exportNetworkFlows != null) {
        this.exportNetworkFlows = new ExportNetworkFlowsBuilder(exportNetworkFlows);
        this._visitables.get("exportNetworkFlows").add(this.exportNetworkFlows);
    } else {
        this.exportNetworkFlows = null;
        this._visitables.get("exportNetworkFlows").remove(this.exportNetworkFlows);
    }
    return (A) this;
  }
  
  public A withKubeProxyConfig(ProxyConfig kubeProxyConfig) {
    this._visitables.remove("kubeProxyConfig");
    if (kubeProxyConfig != null) {
        this.kubeProxyConfig = new ProxyConfigBuilder(kubeProxyConfig);
        this._visitables.get("kubeProxyConfig").add(this.kubeProxyConfig);
    } else {
        this.kubeProxyConfig = null;
        this._visitables.get("kubeProxyConfig").remove(this.kubeProxyConfig);
    }
    return (A) this;
  }
  
  public A withLogLevel(String logLevel) {
    this.logLevel = logLevel;
    return (A) this;
  }
  
  public A withManagementState(String managementState) {
    this.managementState = managementState;
    return (A) this;
  }
  
  public A withMigration(NetworkMigration migration) {
    this._visitables.remove("migration");
    if (migration != null) {
        this.migration = new NetworkMigrationBuilder(migration);
        this._visitables.get("migration").add(this.migration);
    } else {
        this.migration = null;
        this._visitables.get("migration").remove(this.migration);
    }
    return (A) this;
  }
  
  public AdditionalRoutingCapabilitiesNested<A> withNewAdditionalRoutingCapabilities() {
    return new AdditionalRoutingCapabilitiesNested(null);
  }
  
  public AdditionalRoutingCapabilitiesNested<A> withNewAdditionalRoutingCapabilitiesLike(AdditionalRoutingCapabilities item) {
    return new AdditionalRoutingCapabilitiesNested(item);
  }
  
  public DefaultNetworkNested<A> withNewDefaultNetwork() {
    return new DefaultNetworkNested(null);
  }
  
  public DefaultNetworkNested<A> withNewDefaultNetworkLike(DefaultNetworkDefinition item) {
    return new DefaultNetworkNested(item);
  }
  
  public ExportNetworkFlowsNested<A> withNewExportNetworkFlows() {
    return new ExportNetworkFlowsNested(null);
  }
  
  public ExportNetworkFlowsNested<A> withNewExportNetworkFlowsLike(ExportNetworkFlows item) {
    return new ExportNetworkFlowsNested(item);
  }
  
  public KubeProxyConfigNested<A> withNewKubeProxyConfig() {
    return new KubeProxyConfigNested(null);
  }
  
  public KubeProxyConfigNested<A> withNewKubeProxyConfigLike(ProxyConfig item) {
    return new KubeProxyConfigNested(item);
  }
  
  public MigrationNested<A> withNewMigration() {
    return new MigrationNested(null);
  }
  
  public MigrationNested<A> withNewMigrationLike(NetworkMigration item) {
    return new MigrationNested(item);
  }
  
  public A withObservedConfig(Object observedConfig) {
    this.observedConfig = observedConfig;
    return (A) this;
  }
  
  public A withOperatorLogLevel(String operatorLogLevel) {
    this.operatorLogLevel = operatorLogLevel;
    return (A) this;
  }
  
  public A withServiceNetwork(List<String> serviceNetwork) {
    if (serviceNetwork != null) {
        this.serviceNetwork = new ArrayList();
        for (String item : serviceNetwork) {
          this.addToServiceNetwork(item);
        }
    } else {
      this.serviceNetwork = null;
    }
    return (A) this;
  }
  
  public A withServiceNetwork(String... serviceNetwork) {
    if (this.serviceNetwork != null) {
        this.serviceNetwork.clear();
        _visitables.remove("serviceNetwork");
    }
    if (serviceNetwork != null) {
      for (String item : serviceNetwork) {
        this.addToServiceNetwork(item);
      }
    }
    return (A) this;
  }
  
  public A withUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
    this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    return (A) this;
  }
  
  public A withUseMultiNetworkPolicy() {
    return withUseMultiNetworkPolicy(true);
  }
  
  public A withUseMultiNetworkPolicy(Boolean useMultiNetworkPolicy) {
    this.useMultiNetworkPolicy = useMultiNetworkPolicy;
    return (A) this;
  }
  public class AdditionalNetworksNested<N> extends AdditionalNetworkDefinitionFluent<AdditionalNetworksNested<N>> implements Nested<N>{
  
    AdditionalNetworkDefinitionBuilder builder;
    int index;
  
    AdditionalNetworksNested(int index,AdditionalNetworkDefinition item) {
      this.index = index;
      this.builder = new AdditionalNetworkDefinitionBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.setToAdditionalNetworks(index, builder.build());
    }
    
    public N endAdditionalNetwork() {
      return and();
    }
    
  }
  public class AdditionalRoutingCapabilitiesNested<N> extends AdditionalRoutingCapabilitiesFluent<AdditionalRoutingCapabilitiesNested<N>> implements Nested<N>{
  
    AdditionalRoutingCapabilitiesBuilder builder;
  
    AdditionalRoutingCapabilitiesNested(AdditionalRoutingCapabilities item) {
      this.builder = new AdditionalRoutingCapabilitiesBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.withAdditionalRoutingCapabilities(builder.build());
    }
    
    public N endAdditionalRoutingCapabilities() {
      return and();
    }
    
  }
  public class ClusterNetworkNested<N> extends ClusterNetworkEntryFluent<ClusterNetworkNested<N>> implements Nested<N>{
  
    ClusterNetworkEntryBuilder builder;
    int index;
  
    ClusterNetworkNested(int index,ClusterNetworkEntry item) {
      this.index = index;
      this.builder = new ClusterNetworkEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.setToClusterNetwork(index, builder.build());
    }
    
    public N endClusterNetwork() {
      return and();
    }
    
  }
  public class DefaultNetworkNested<N> extends DefaultNetworkDefinitionFluent<DefaultNetworkNested<N>> implements Nested<N>{
  
    DefaultNetworkDefinitionBuilder builder;
  
    DefaultNetworkNested(DefaultNetworkDefinition item) {
      this.builder = new DefaultNetworkDefinitionBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.withDefaultNetwork(builder.build());
    }
    
    public N endDefaultNetwork() {
      return and();
    }
    
  }
  public class ExportNetworkFlowsNested<N> extends ExportNetworkFlowsFluent<ExportNetworkFlowsNested<N>> implements Nested<N>{
  
    ExportNetworkFlowsBuilder builder;
  
    ExportNetworkFlowsNested(ExportNetworkFlows item) {
      this.builder = new ExportNetworkFlowsBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.withExportNetworkFlows(builder.build());
    }
    
    public N endExportNetworkFlows() {
      return and();
    }
    
  }
  public class KubeProxyConfigNested<N> extends ProxyConfigFluent<KubeProxyConfigNested<N>> implements Nested<N>{
  
    ProxyConfigBuilder builder;
  
    KubeProxyConfigNested(ProxyConfig item) {
      this.builder = new ProxyConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.withKubeProxyConfig(builder.build());
    }
    
    public N endKubeProxyConfig() {
      return and();
    }
    
  }
  public class MigrationNested<N> extends NetworkMigrationFluent<MigrationNested<N>> implements Nested<N>{
  
    NetworkMigrationBuilder builder;
  
    MigrationNested(NetworkMigration item) {
      this.builder = new NetworkMigrationBuilder(this, item);
    }
  
    public N and() {
      return (N) NetworkSpecFluent.this.withMigration(builder.build());
    }
    
    public N endMigration() {
      return and();
    }
    
  }
}