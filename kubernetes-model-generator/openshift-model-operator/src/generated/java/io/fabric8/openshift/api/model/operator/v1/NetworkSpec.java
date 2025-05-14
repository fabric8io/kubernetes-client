
package io.fabric8.openshift.api.model.operator.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
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

/**
 * NetworkSpec is the top-level network configuration object.
 */
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
public class NetworkSpec implements Editable<NetworkSpecBuilder>, KubernetesResource
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

    /**
     * additionalNetworks is a list of extra networks to make available to pods when multiple networks are enabled.
     */
    @JsonProperty("additionalNetworks")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AdditionalNetworkDefinition> getAdditionalNetworks() {
        return additionalNetworks;
    }

    /**
     * additionalNetworks is a list of extra networks to make available to pods when multiple networks are enabled.
     */
    @JsonProperty("additionalNetworks")
    public void setAdditionalNetworks(List<AdditionalNetworkDefinition> additionalNetworks) {
        this.additionalNetworks = additionalNetworks;
    }

    /**
     * NetworkSpec is the top-level network configuration object.
     */
    @JsonProperty("additionalRoutingCapabilities")
    public AdditionalRoutingCapabilities getAdditionalRoutingCapabilities() {
        return additionalRoutingCapabilities;
    }

    /**
     * NetworkSpec is the top-level network configuration object.
     */
    @JsonProperty("additionalRoutingCapabilities")
    public void setAdditionalRoutingCapabilities(AdditionalRoutingCapabilities additionalRoutingCapabilities) {
        this.additionalRoutingCapabilities = additionalRoutingCapabilities;
    }

    /**
     * clusterNetwork is the IP address pool to use for pod IPs. Some network providers support multiple ClusterNetworks. Others only support one. This is equivalent to the cluster-cidr.
     */
    @JsonProperty("clusterNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClusterNetworkEntry> getClusterNetwork() {
        return clusterNetwork;
    }

    /**
     * clusterNetwork is the IP address pool to use for pod IPs. Some network providers support multiple ClusterNetworks. Others only support one. This is equivalent to the cluster-cidr.
     */
    @JsonProperty("clusterNetwork")
    public void setClusterNetwork(List<ClusterNetworkEntry> clusterNetwork) {
        this.clusterNetwork = clusterNetwork;
    }

    /**
     * NetworkSpec is the top-level network configuration object.
     */
    @JsonProperty("defaultNetwork")
    public DefaultNetworkDefinition getDefaultNetwork() {
        return defaultNetwork;
    }

    /**
     * NetworkSpec is the top-level network configuration object.
     */
    @JsonProperty("defaultNetwork")
    public void setDefaultNetwork(DefaultNetworkDefinition defaultNetwork) {
        this.defaultNetwork = defaultNetwork;
    }

    /**
     * deployKubeProxy specifies whether or not a standalone kube-proxy should be deployed by the operator. Some network providers include kube-proxy or similar functionality. If unset, the plugin will attempt to select the correct value, which is false when ovn-kubernetes is used and true otherwise.
     */
    @JsonProperty("deployKubeProxy")
    public Boolean getDeployKubeProxy() {
        return deployKubeProxy;
    }

    /**
     * deployKubeProxy specifies whether or not a standalone kube-proxy should be deployed by the operator. Some network providers include kube-proxy or similar functionality. If unset, the plugin will attempt to select the correct value, which is false when ovn-kubernetes is used and true otherwise.
     */
    @JsonProperty("deployKubeProxy")
    public void setDeployKubeProxy(Boolean deployKubeProxy) {
        this.deployKubeProxy = deployKubeProxy;
    }

    /**
     * disableMultiNetwork specifies whether or not multiple pod network support should be disabled. If unset, this property defaults to 'false' and multiple network support is enabled.
     */
    @JsonProperty("disableMultiNetwork")
    public Boolean getDisableMultiNetwork() {
        return disableMultiNetwork;
    }

    /**
     * disableMultiNetwork specifies whether or not multiple pod network support should be disabled. If unset, this property defaults to 'false' and multiple network support is enabled.
     */
    @JsonProperty("disableMultiNetwork")
    public void setDisableMultiNetwork(Boolean disableMultiNetwork) {
        this.disableMultiNetwork = disableMultiNetwork;
    }

    /**
     * disableNetworkDiagnostics specifies whether or not PodNetworkConnectivityCheck CRs from a test pod to every node, apiserver and LB should be disabled or not. If unset, this property defaults to 'false' and network diagnostics is enabled. Setting this to 'true' would reduce the additional load of the pods performing the checks.
     */
    @JsonProperty("disableNetworkDiagnostics")
    public Boolean getDisableNetworkDiagnostics() {
        return disableNetworkDiagnostics;
    }

    /**
     * disableNetworkDiagnostics specifies whether or not PodNetworkConnectivityCheck CRs from a test pod to every node, apiserver and LB should be disabled or not. If unset, this property defaults to 'false' and network diagnostics is enabled. Setting this to 'true' would reduce the additional load of the pods performing the checks.
     */
    @JsonProperty("disableNetworkDiagnostics")
    public void setDisableNetworkDiagnostics(Boolean disableNetworkDiagnostics) {
        this.disableNetworkDiagnostics = disableNetworkDiagnostics;
    }

    /**
     * NetworkSpec is the top-level network configuration object.
     */
    @JsonProperty("exportNetworkFlows")
    public ExportNetworkFlows getExportNetworkFlows() {
        return exportNetworkFlows;
    }

    /**
     * NetworkSpec is the top-level network configuration object.
     */
    @JsonProperty("exportNetworkFlows")
    public void setExportNetworkFlows(ExportNetworkFlows exportNetworkFlows) {
        this.exportNetworkFlows = exportNetworkFlows;
    }

    /**
     * NetworkSpec is the top-level network configuration object.
     */
    @JsonProperty("kubeProxyConfig")
    public ProxyConfig getKubeProxyConfig() {
        return kubeProxyConfig;
    }

    /**
     * NetworkSpec is the top-level network configuration object.
     */
    @JsonProperty("kubeProxyConfig")
    public void setKubeProxyConfig(ProxyConfig kubeProxyConfig) {
        this.kubeProxyConfig = kubeProxyConfig;
    }

    /**
     * logLevel is an intent based logging for an overall component.  It does not give fine grained control, but it is a simple way to manage coarse grained logging choices that operators have to interpret for their operands.<br><p> <br><p> Valid values are: "Normal", "Debug", "Trace", "TraceAll". Defaults to "Normal".
     */
    @JsonProperty("logLevel")
    public String getLogLevel() {
        return logLevel;
    }

    /**
     * logLevel is an intent based logging for an overall component.  It does not give fine grained control, but it is a simple way to manage coarse grained logging choices that operators have to interpret for their operands.<br><p> <br><p> Valid values are: "Normal", "Debug", "Trace", "TraceAll". Defaults to "Normal".
     */
    @JsonProperty("logLevel")
    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    /**
     * managementState indicates whether and how the operator should manage the component
     */
    @JsonProperty("managementState")
    public String getManagementState() {
        return managementState;
    }

    /**
     * managementState indicates whether and how the operator should manage the component
     */
    @JsonProperty("managementState")
    public void setManagementState(String managementState) {
        this.managementState = managementState;
    }

    /**
     * NetworkSpec is the top-level network configuration object.
     */
    @JsonProperty("migration")
    public NetworkMigration getMigration() {
        return migration;
    }

    /**
     * NetworkSpec is the top-level network configuration object.
     */
    @JsonProperty("migration")
    public void setMigration(NetworkMigration migration) {
        this.migration = migration;
    }

    /**
     * NetworkSpec is the top-level network configuration object.
     */
    @JsonProperty("observedConfig")
    public Object getObservedConfig() {
        return observedConfig;
    }

    /**
     * NetworkSpec is the top-level network configuration object.
     */
    @JsonProperty("observedConfig")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setObservedConfig(Object observedConfig) {
        this.observedConfig = observedConfig;
    }

    /**
     * operatorLogLevel is an intent based logging for the operator itself.  It does not give fine grained control, but it is a simple way to manage coarse grained logging choices that operators have to interpret for themselves.<br><p> <br><p> Valid values are: "Normal", "Debug", "Trace", "TraceAll". Defaults to "Normal".
     */
    @JsonProperty("operatorLogLevel")
    public String getOperatorLogLevel() {
        return operatorLogLevel;
    }

    /**
     * operatorLogLevel is an intent based logging for the operator itself.  It does not give fine grained control, but it is a simple way to manage coarse grained logging choices that operators have to interpret for themselves.<br><p> <br><p> Valid values are: "Normal", "Debug", "Trace", "TraceAll". Defaults to "Normal".
     */
    @JsonProperty("operatorLogLevel")
    public void setOperatorLogLevel(String operatorLogLevel) {
        this.operatorLogLevel = operatorLogLevel;
    }

    /**
     * serviceNetwork is the ip address pool to use for Service IPs Currently, all existing network providers only support a single value here, but this is an array to allow for growth.
     */
    @JsonProperty("serviceNetwork")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getServiceNetwork() {
        return serviceNetwork;
    }

    /**
     * serviceNetwork is the ip address pool to use for Service IPs Currently, all existing network providers only support a single value here, but this is an array to allow for growth.
     */
    @JsonProperty("serviceNetwork")
    public void setServiceNetwork(List<String> serviceNetwork) {
        this.serviceNetwork = serviceNetwork;
    }

    /**
     * NetworkSpec is the top-level network configuration object.
     */
    @JsonProperty("unsupportedConfigOverrides")
    public Object getUnsupportedConfigOverrides() {
        return unsupportedConfigOverrides;
    }

    /**
     * NetworkSpec is the top-level network configuration object.
     */
    @JsonProperty("unsupportedConfigOverrides")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setUnsupportedConfigOverrides(Object unsupportedConfigOverrides) {
        this.unsupportedConfigOverrides = unsupportedConfigOverrides;
    }

    /**
     * useMultiNetworkPolicy enables a controller which allows for MultiNetworkPolicy objects to be used on additional networks as created by Multus CNI. MultiNetworkPolicy are similar to NetworkPolicy objects, but NetworkPolicy objects only apply to the primary interface. With MultiNetworkPolicy, you can control the traffic that a pod can receive over the secondary interfaces. If unset, this property defaults to 'false' and MultiNetworkPolicy objects are ignored. If 'disableMultiNetwork' is 'true' then the value of this field is ignored.
     */
    @JsonProperty("useMultiNetworkPolicy")
    public Boolean getUseMultiNetworkPolicy() {
        return useMultiNetworkPolicy;
    }

    /**
     * useMultiNetworkPolicy enables a controller which allows for MultiNetworkPolicy objects to be used on additional networks as created by Multus CNI. MultiNetworkPolicy are similar to NetworkPolicy objects, but NetworkPolicy objects only apply to the primary interface. With MultiNetworkPolicy, you can control the traffic that a pod can receive over the secondary interfaces. If unset, this property defaults to 'false' and MultiNetworkPolicy objects are ignored. If 'disableMultiNetwork' is 'true' then the value of this field is ignored.
     */
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
    @JsonIgnore
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
