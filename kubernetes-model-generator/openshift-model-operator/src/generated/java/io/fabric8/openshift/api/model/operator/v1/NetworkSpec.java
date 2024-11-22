
package io.fabric8.openshift.api.model.operator.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalNetworks",
    "additionalRoutingCapabilities",
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class NetworkSpec implements Editable<NetworkSpecBuilder> , KubernetesResource
{

    @JsonProperty("additionalNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AdditionalNetworkDefinition> additionalNetworks = new ArrayList<>();
    @JsonProperty("additionalRoutingCapabilities")
    private AdditionalRoutingCapabilities additionalRoutingCapabilities;
    @JsonProperty("clusterNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClusterNetworkEntry> clusterNetwork = new ArrayList<>();
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
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object observedConfig;
    @JsonProperty("operatorLogLevel")
    private String operatorLogLevel;
    @JsonProperty("serviceNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> serviceNetwork = new ArrayList<>();
    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object unsupportedConfigOverrides;
    @JsonProperty("useMultiNetworkPolicy")
    private Boolean useMultiNetworkPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public NetworkSpec() {
    }

    public NetworkSpec(List<AdditionalNetworkDefinition> additionalNetworks, AdditionalRoutingCapabilities additionalRoutingCapabilities, List<ClusterNetworkEntry> clusterNetwork, DefaultNetworkDefinition defaultNetwork, Boolean deployKubeProxy, Boolean disableMultiNetwork, Boolean disableNetworkDiagnostics, ExportNetworkFlows exportNetworkFlows, ProxyConfig kubeProxyConfig, String logLevel, String managementState, NetworkMigration migration, Object observedConfig, String operatorLogLevel, List<String> serviceNetwork, Object unsupportedConfigOverrides, Boolean useMultiNetworkPolicy) {
        super();
        this.additionalNetworks = additionalNetworks;
        this.additionalRoutingCapabilities = additionalRoutingCapabilities;
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AdditionalNetworkDefinition> getAdditionalNetworks() {
        return additionalNetworks;
    }

    @JsonProperty("additionalNetworks")
    public void setAdditionalNetworks(List<AdditionalNetworkDefinition> additionalNetworks) {
        this.additionalNetworks = additionalNetworks;
    }

    @JsonProperty("additionalRoutingCapabilities")
    public AdditionalRoutingCapabilities getAdditionalRoutingCapabilities() {
        return additionalRoutingCapabilities;
    }

    @JsonProperty("additionalRoutingCapabilities")
    public void setAdditionalRoutingCapabilities(AdditionalRoutingCapabilities additionalRoutingCapabilities) {
        this.additionalRoutingCapabilities = additionalRoutingCapabilities;
    }

    @JsonProperty("clusterNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    public Object getObservedConfig() {
        return observedConfig;
    }

    @JsonProperty("observedConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setObservedConfig(Object observedConfig) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getServiceNetwork() {
        return serviceNetwork;
    }

    @JsonProperty("serviceNetwork")
    public void setServiceNetwork(List<String> serviceNetwork) {
        this.serviceNetwork = serviceNetwork;
    }

    @JsonProperty("unsupportedConfigOverrides")
    public Object getUnsupportedConfigOverrides() {
        return unsupportedConfigOverrides;
    }

    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
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

    @JsonIgnore
    public NetworkSpecBuilder edit() {
        return new NetworkSpecBuilder(this);
    }

    @JsonIgnore
    public NetworkSpecBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
