
package io.fabric8.openshift.api.model.config.v1;

import java.util.LinkedHashMap;
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
 * InfrastructureStatus describes the infrastructure the cluster is leveraging.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiServerInternalURI",
    "apiServerURL",
    "controlPlaneTopology",
    "cpuPartitioning",
    "etcdDiscoveryDomain",
    "infrastructureName",
    "infrastructureTopology",
    "platform",
    "platformStatus"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class InfrastructureStatus implements Editable<InfrastructureStatusBuilder>, KubernetesResource
{

    @JsonProperty("apiServerInternalURI")
    private String apiServerInternalURI;
    @JsonProperty("apiServerURL")
    private String apiServerURL;
    @JsonProperty("controlPlaneTopology")
    private String controlPlaneTopology;
    @JsonProperty("cpuPartitioning")
    private String cpuPartitioning;
    @JsonProperty("etcdDiscoveryDomain")
    private String etcdDiscoveryDomain;
    @JsonProperty("infrastructureName")
    private String infrastructureName;
    @JsonProperty("infrastructureTopology")
    private String infrastructureTopology;
    @JsonProperty("platform")
    private String platform;
    @JsonProperty("platformStatus")
    private PlatformStatus platformStatus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public InfrastructureStatus() {
    }

    public InfrastructureStatus(String apiServerInternalURI, String apiServerURL, String controlPlaneTopology, String cpuPartitioning, String etcdDiscoveryDomain, String infrastructureName, String infrastructureTopology, String platform, PlatformStatus platformStatus) {
        super();
        this.apiServerInternalURI = apiServerInternalURI;
        this.apiServerURL = apiServerURL;
        this.controlPlaneTopology = controlPlaneTopology;
        this.cpuPartitioning = cpuPartitioning;
        this.etcdDiscoveryDomain = etcdDiscoveryDomain;
        this.infrastructureName = infrastructureName;
        this.infrastructureTopology = infrastructureTopology;
        this.platform = platform;
        this.platformStatus = platformStatus;
    }

    /**
     * apiServerInternalURL is a valid URI with scheme 'https', address and optionally a port (defaulting to 443).  apiServerInternalURL can be used by components like kubelets, to contact the Kubernetes API server using the infrastructure provider rather than Kubernetes networking.
     */
    @JsonProperty("apiServerInternalURI")
    public String getApiServerInternalURI() {
        return apiServerInternalURI;
    }

    /**
     * apiServerInternalURL is a valid URI with scheme 'https', address and optionally a port (defaulting to 443).  apiServerInternalURL can be used by components like kubelets, to contact the Kubernetes API server using the infrastructure provider rather than Kubernetes networking.
     */
    @JsonProperty("apiServerInternalURI")
    public void setApiServerInternalURI(String apiServerInternalURI) {
        this.apiServerInternalURI = apiServerInternalURI;
    }

    /**
     * apiServerURL is a valid URI with scheme 'https', address and optionally a port (defaulting to 443).  apiServerURL can be used by components like the web console to tell users where to find the Kubernetes API.
     */
    @JsonProperty("apiServerURL")
    public String getApiServerURL() {
        return apiServerURL;
    }

    /**
     * apiServerURL is a valid URI with scheme 'https', address and optionally a port (defaulting to 443).  apiServerURL can be used by components like the web console to tell users where to find the Kubernetes API.
     */
    @JsonProperty("apiServerURL")
    public void setApiServerURL(String apiServerURL) {
        this.apiServerURL = apiServerURL;
    }

    /**
     * controlPlaneTopology expresses the expectations for operands that normally run on control nodes. The default is 'HighlyAvailable', which represents the behavior operators have in a "normal" cluster. The 'SingleReplica' mode will be used in single-node deployments and the operators should not configure the operand for highly-available operation The 'External' mode indicates that the control plane is hosted externally to the cluster and that its components are not visible within the cluster.
     */
    @JsonProperty("controlPlaneTopology")
    public String getControlPlaneTopology() {
        return controlPlaneTopology;
    }

    /**
     * controlPlaneTopology expresses the expectations for operands that normally run on control nodes. The default is 'HighlyAvailable', which represents the behavior operators have in a "normal" cluster. The 'SingleReplica' mode will be used in single-node deployments and the operators should not configure the operand for highly-available operation The 'External' mode indicates that the control plane is hosted externally to the cluster and that its components are not visible within the cluster.
     */
    @JsonProperty("controlPlaneTopology")
    public void setControlPlaneTopology(String controlPlaneTopology) {
        this.controlPlaneTopology = controlPlaneTopology;
    }

    /**
     * cpuPartitioning expresses if CPU partitioning is a currently enabled feature in the cluster. CPU Partitioning means that this cluster can support partitioning workloads to specific CPU Sets. Valid values are "None" and "AllNodes". When omitted, the default value is "None". The default value of "None" indicates that no nodes will be setup with CPU partitioning. The "AllNodes" value indicates that all nodes have been setup with CPU partitioning, and can then be further configured via the PerformanceProfile API.
     */
    @JsonProperty("cpuPartitioning")
    public String getCpuPartitioning() {
        return cpuPartitioning;
    }

    /**
     * cpuPartitioning expresses if CPU partitioning is a currently enabled feature in the cluster. CPU Partitioning means that this cluster can support partitioning workloads to specific CPU Sets. Valid values are "None" and "AllNodes". When omitted, the default value is "None". The default value of "None" indicates that no nodes will be setup with CPU partitioning. The "AllNodes" value indicates that all nodes have been setup with CPU partitioning, and can then be further configured via the PerformanceProfile API.
     */
    @JsonProperty("cpuPartitioning")
    public void setCpuPartitioning(String cpuPartitioning) {
        this.cpuPartitioning = cpuPartitioning;
    }

    /**
     * etcdDiscoveryDomain is the domain used to fetch the SRV records for discovering etcd servers and clients. For more info: https://github.com/etcd-io/etcd/blob/329be66e8b3f9e2e6af83c123ff89297e49ebd15/Documentation/op-guide/clustering.md#dns-discovery deprecated: as of 4.7, this field is no longer set or honored.  It will be removed in a future release.
     */
    @JsonProperty("etcdDiscoveryDomain")
    public String getEtcdDiscoveryDomain() {
        return etcdDiscoveryDomain;
    }

    /**
     * etcdDiscoveryDomain is the domain used to fetch the SRV records for discovering etcd servers and clients. For more info: https://github.com/etcd-io/etcd/blob/329be66e8b3f9e2e6af83c123ff89297e49ebd15/Documentation/op-guide/clustering.md#dns-discovery deprecated: as of 4.7, this field is no longer set or honored.  It will be removed in a future release.
     */
    @JsonProperty("etcdDiscoveryDomain")
    public void setEtcdDiscoveryDomain(String etcdDiscoveryDomain) {
        this.etcdDiscoveryDomain = etcdDiscoveryDomain;
    }

    /**
     * infrastructureName uniquely identifies a cluster with a human friendly name. Once set it should not be changed. Must be of max length 27 and must have only alphanumeric or hyphen characters.
     */
    @JsonProperty("infrastructureName")
    public String getInfrastructureName() {
        return infrastructureName;
    }

    /**
     * infrastructureName uniquely identifies a cluster with a human friendly name. Once set it should not be changed. Must be of max length 27 and must have only alphanumeric or hyphen characters.
     */
    @JsonProperty("infrastructureName")
    public void setInfrastructureName(String infrastructureName) {
        this.infrastructureName = infrastructureName;
    }

    /**
     * infrastructureTopology expresses the expectations for infrastructure services that do not run on control plane nodes, usually indicated by a node selector for a `role` value other than `master`. The default is 'HighlyAvailable', which represents the behavior operators have in a "normal" cluster. The 'SingleReplica' mode will be used in single-node deployments and the operators should not configure the operand for highly-available operation NOTE: External topology mode is not applicable for this field.
     */
    @JsonProperty("infrastructureTopology")
    public String getInfrastructureTopology() {
        return infrastructureTopology;
    }

    /**
     * infrastructureTopology expresses the expectations for infrastructure services that do not run on control plane nodes, usually indicated by a node selector for a `role` value other than `master`. The default is 'HighlyAvailable', which represents the behavior operators have in a "normal" cluster. The 'SingleReplica' mode will be used in single-node deployments and the operators should not configure the operand for highly-available operation NOTE: External topology mode is not applicable for this field.
     */
    @JsonProperty("infrastructureTopology")
    public void setInfrastructureTopology(String infrastructureTopology) {
        this.infrastructureTopology = infrastructureTopology;
    }

    /**
     * platform is the underlying infrastructure provider for the cluster.<br><p> <br><p> Deprecated: Use platformStatus.type instead.
     */
    @JsonProperty("platform")
    public String getPlatform() {
        return platform;
    }

    /**
     * platform is the underlying infrastructure provider for the cluster.<br><p> <br><p> Deprecated: Use platformStatus.type instead.
     */
    @JsonProperty("platform")
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * InfrastructureStatus describes the infrastructure the cluster is leveraging.
     */
    @JsonProperty("platformStatus")
    public PlatformStatus getPlatformStatus() {
        return platformStatus;
    }

    /**
     * InfrastructureStatus describes the infrastructure the cluster is leveraging.
     */
    @JsonProperty("platformStatus")
    public void setPlatformStatus(PlatformStatus platformStatus) {
        this.platformStatus = platformStatus;
    }

    @JsonIgnore
    public InfrastructureStatusBuilder edit() {
        return new InfrastructureStatusBuilder(this);
    }

    @JsonIgnore
    public InfrastructureStatusBuilder toBuilder() {
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
