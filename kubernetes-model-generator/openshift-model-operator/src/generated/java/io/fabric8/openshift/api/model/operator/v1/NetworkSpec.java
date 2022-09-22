
package io.fabric8.openshift.api.model.operator.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "additionalNetworks",
    "clusterNetwork",
    "defaultNetwork",
    "deployKubeProxy",
    "disableMultiNetwork",
    "disableNetworkDiagnostics",
    "exportNetworkFlows",
    "kubeProxyConfig",
    "logLevel",
    "managementState",
    "migration",
    "observedConfig",
    "operatorLogLevel",
    "serviceNetwork",
    "unsupportedConfigOverrides",
    "useMultiNetworkPolicy"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class NetworkSpec implements KubernetesResource
{

    @JsonProperty("additionalNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AdditionalNetworkDefinition> additionalNetworks = new ArrayList<AdditionalNetworkDefinition>();
    @JsonProperty("clusterNetwork")
    private List<ClusterNetworkEntry> clusterNetwork = new ArrayList<ClusterNetworkEntry>();
    @JsonProperty("defaultNetwork")
    private DefaultNetworkDefinition defaultNetwork;
    @JsonProperty("deployKubeProxy")
    private Boolean deployKubeProxy;
    @JsonProperty("disableMultiNetwork")
    private Boolean disableMultiNetwork;
    @JsonProperty("disableNetworkDiagnostics")
    private Boolean disableNetworkDiagnostics;
    @JsonProperty("exportNetworkFlows")
    private ExportNetworkFlows exportNetworkFlows;
    @JsonProperty("kubeProxyConfig")
    private ProxyConfig kubeProxyConfig;
    @JsonProperty("logLevel")
    private String logLevel;
    @JsonProperty("managementState")
    private String managementState;
    @JsonProperty("migration")
    private NetworkMigration migration;
    @JsonProperty("observedConfig")
    private KubernetesResource observedConfig;
    @JsonProperty("operatorLogLevel")
    private String operatorLogLevel;
    @JsonProperty("serviceNetwork")
    private List<String> serviceNetwork = new ArrayList<String>();
    @JsonProperty("unsupportedConfigOverrides")
    private KubernetesResource unsupportedConfigOverrides;
    @JsonProperty("useMultiNetworkPolicy")
    private Boolean useMultiNetworkPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NetworkSpec() {
    }

    /**
     * 
     * @param useMultiNetworkPolicy
     * @param exportNetworkFlows
     * @param clusterNetwork
     * @param operatorLogLevel
     * @param kubeProxyConfig
     * @param observedConfig
     * @param deployKubeProxy
     * @param logLevel
     * @param additionalNetworks
     * @param defaultNetwork
     * @param migration
     * @param unsupportedConfigOverrides
     * @param serviceNetwork
     * @param disableNetworkDiagnostics
     * @param disableMultiNetwork
     * @param managementState
     */
    public NetworkSpec(List<AdditionalNetworkDefinition> additionalNetworks, List<ClusterNetworkEntry> clusterNetwork, DefaultNetworkDefinition defaultNetwork, Boolean deployKubeProxy, Boolean disableMultiNetwork, Boolean disableNetworkDiagnostics, ExportNetworkFlows exportNetworkFlows, ProxyConfig kubeProxyConfig, String logLevel, String managementState, NetworkMigration migration, KubernetesResource observedConfig, String operatorLogLevel, List<String> serviceNetwork, KubernetesResource unsupportedConfigOverrides, Boolean useMultiNetworkPolicy) {
        super();
        this.additionalNetworks = additionalNetworks;
        this.clusterNetwork = clusterNetwork;
        this.defaultNetwork = defaultNetwork;
        this.deployKubeProxy = deployKubeProxy;
        this.disableMultiNetwork = disableMultiNetwork;
        this.disableNetworkDiagnostics = disableNetworkDiagnostics;
        this.exportNetworkFlows = exportNetworkFlows;
        this.kubeProxyConfig = kubeProxyConfig;
        this.logLevel = logLevel;
        this.managementState = managementState;
        this.migration = migration;
        this.observedConfig = observedConfig;
        this.operatorLogLevel = operatorLogLevel;
        this.serviceNetwork = serviceNetwork;
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
        this.useMultiNetworkPolicy = useMultiNetworkPolicy;
    }

    @JsonProperty("additionalNetworks")
    public List<AdditionalNetworkDefinition> getAdditionalNetworks() {
        return additionalNetworks;
    }

    @JsonProperty("additionalNetworks")
    public void setAdditionalNetworks(List<AdditionalNetworkDefinition> additionalNetworks) {
        this.additionalNetworks = additionalNetworks;
    }

    @JsonProperty("clusterNetwork")
    public List<ClusterNetworkEntry> getClusterNetwork() {
        return clusterNetwork;
    }

    @JsonProperty("clusterNetwork")
    public void setClusterNetwork(List<ClusterNetworkEntry> clusterNetwork) {
        this.clusterNetwork = clusterNetwork;
    }

    @JsonProperty("defaultNetwork")
    public DefaultNetworkDefinition getDefaultNetwork() {
        return defaultNetwork;
    }

    @JsonProperty("defaultNetwork")
    public void setDefaultNetwork(DefaultNetworkDefinition defaultNetwork) {
        this.defaultNetwork = defaultNetwork;
    }

    @JsonProperty("deployKubeProxy")
    public Boolean getDeployKubeProxy() {
        return deployKubeProxy;
    }

    @JsonProperty("deployKubeProxy")
    public void setDeployKubeProxy(Boolean deployKubeProxy) {
        this.deployKubeProxy = deployKubeProxy;
    }

    @JsonProperty("disableMultiNetwork")
    public Boolean getDisableMultiNetwork() {
        return disableMultiNetwork;
    }

    @JsonProperty("disableMultiNetwork")
    public void setDisableMultiNetwork(Boolean disableMultiNetwork) {
        this.disableMultiNetwork = disableMultiNetwork;
    }

    @JsonProperty("disableNetworkDiagnostics")
    public Boolean getDisableNetworkDiagnostics() {
        return disableNetworkDiagnostics;
    }

    @JsonProperty("disableNetworkDiagnostics")
    public void setDisableNetworkDiagnostics(Boolean disableNetworkDiagnostics) {
        this.disableNetworkDiagnostics = disableNetworkDiagnostics;
    }

    @JsonProperty("exportNetworkFlows")
    public ExportNetworkFlows getExportNetworkFlows() {
        return exportNetworkFlows;
    }

    @JsonProperty("exportNetworkFlows")
    public void setExportNetworkFlows(ExportNetworkFlows exportNetworkFlows) {
        this.exportNetworkFlows = exportNetworkFlows;
    }

    @JsonProperty("kubeProxyConfig")
    public ProxyConfig getKubeProxyConfig() {
        return kubeProxyConfig;
    }

    @JsonProperty("kubeProxyConfig")
    public void setKubeProxyConfig(ProxyConfig kubeProxyConfig) {
        this.kubeProxyConfig = kubeProxyConfig;
    }

    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @JsonProperty("managementState")
    public String getManagementState() {
        return managementState;
    }

    @JsonProperty("managementState")
    public void setManagementState(String managementState) {
        this.managementState = managementState;
    }

    @JsonProperty("migration")
    public NetworkMigration getMigration() {
        return migration;
    }

    @JsonProperty("migration")
    public void setMigration(NetworkMigration migration) {
        this.migration = migration;
    }

    @JsonProperty("observedConfig")
    public KubernetesResource getObservedConfig() {
        return observedConfig;
    }

    @JsonProperty("observedConfig")
    public void setObservedConfig(KubernetesResource observedConfig) {
        this.observedConfig = observedConfig;
    }

    @JsonProperty("operatorLogLevel")
    public String getOperatorLogLevel() {
        return operatorLogLevel;
    }

    @JsonProperty("operatorLogLevel")
    public void setOperatorLogLevel(String operatorLogLevel) {
        this.operatorLogLevel = operatorLogLevel;
    }

    @JsonProperty("serviceNetwork")
    public List<String> getServiceNetwork() {
        return serviceNetwork;
    }

    @JsonProperty("serviceNetwork")
    public void setServiceNetwork(List<String> serviceNetwork) {
        this.serviceNetwork = serviceNetwork;
    }

    @JsonProperty("unsupportedConfigOverrides")
    public KubernetesResource getUnsupportedConfigOverrides() {
        return unsupportedConfigOverrides;
    }

    @JsonProperty("unsupportedConfigOverrides")
    public void setUnsupportedConfigOverrides(KubernetesResource unsupportedConfigOverrides) {
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    @JsonProperty("useMultiNetworkPolicy")
    public Boolean getUseMultiNetworkPolicy() {
        return useMultiNetworkPolicy;
    }

    @JsonProperty("useMultiNetworkPolicy")
    public void setUseMultiNetworkPolicy(Boolean useMultiNetworkPolicy) {
        this.useMultiNetworkPolicy = useMultiNetworkPolicy;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
