
package io.fabric8.kubernetes.api.model.clusterapi.v1beta1;

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
 * AzureClusterSpec defines the desired state of AzureCluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalTags",
    "azureEnvironment",
    "bastionSpec",
    "cloudProviderConfigOverrides",
    "controlPlaneEnabled",
    "controlPlaneEndpoint",
    "extendedLocation",
    "failureDomains",
    "identityRef",
    "location",
    "networkSpec",
    "resourceGroup",
    "subscriptionID"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class AzureClusterSpec implements Editable<AzureClusterSpecBuilder>, KubernetesResource
{

    @JsonProperty("additionalTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> additionalTags = new LinkedHashMap<>();
    @JsonProperty("azureEnvironment")
    private String azureEnvironment;
    @JsonProperty("bastionSpec")
    private BastionSpec bastionSpec;
    @JsonProperty("cloudProviderConfigOverrides")
    private CloudProviderConfigOverrides cloudProviderConfigOverrides;
    @JsonProperty("controlPlaneEnabled")
    private Boolean controlPlaneEnabled;
    @JsonProperty("controlPlaneEndpoint")
    private APIEndpoint controlPlaneEndpoint;
    @JsonProperty("extendedLocation")
    private ExtendedLocationSpec extendedLocation;
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, FailureDomainSpec> failureDomains = new LinkedHashMap<>();
    @JsonProperty("identityRef")
    private ObjectReference identityRef;
    @JsonProperty("location")
    private String location;
    @JsonProperty("networkSpec")
    private NetworkSpec networkSpec;
    @JsonProperty("resourceGroup")
    private String resourceGroup;
    @JsonProperty("subscriptionID")
    private String subscriptionID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureClusterSpec() {
    }

    public AzureClusterSpec(Map<String, String> additionalTags, String azureEnvironment, BastionSpec bastionSpec, CloudProviderConfigOverrides cloudProviderConfigOverrides, Boolean controlPlaneEnabled, APIEndpoint controlPlaneEndpoint, ExtendedLocationSpec extendedLocation, Map<String, FailureDomainSpec> failureDomains, ObjectReference identityRef, String location, NetworkSpec networkSpec, String resourceGroup, String subscriptionID) {
        super();
        this.additionalTags = additionalTags;
        this.azureEnvironment = azureEnvironment;
        this.bastionSpec = bastionSpec;
        this.cloudProviderConfigOverrides = cloudProviderConfigOverrides;
        this.controlPlaneEnabled = controlPlaneEnabled;
        this.controlPlaneEndpoint = controlPlaneEndpoint;
        this.extendedLocation = extendedLocation;
        this.failureDomains = failureDomains;
        this.identityRef = identityRef;
        this.location = location;
        this.networkSpec = networkSpec;
        this.resourceGroup = resourceGroup;
        this.subscriptionID = subscriptionID;
    }

    /**
     * AdditionalTags is an optional set of tags to add to Azure resources managed by the Azure provider, in addition to the ones added by default.
     */
    @JsonProperty("additionalTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAdditionalTags() {
        return additionalTags;
    }

    /**
     * AdditionalTags is an optional set of tags to add to Azure resources managed by the Azure provider, in addition to the ones added by default.
     */
    @JsonProperty("additionalTags")
    public void setAdditionalTags(Map<String, String> additionalTags) {
        this.additionalTags = additionalTags;
    }

    /**
     * AzureEnvironment is the name of the AzureCloud to be used. The default value that would be used by most users is "AzurePublicCloud", other values are: - ChinaCloud: "AzureChinaCloud" - GermanCloud: "AzureGermanCloud" - PublicCloud: "AzurePublicCloud" - USGovernmentCloud: "AzureUSGovernmentCloud"<br><p> <br><p> Note that values other than the default must also be accompanied by corresponding changes to the aso-controller-settings Secret to configure ASO to refer to the non-Public cloud. ASO currently does not support referring to multiple different clouds in a single installation. The following fields must be defined in the Secret: - AZURE_AUTHORITY_HOST - AZURE_RESOURCE_MANAGER_ENDPOINT - AZURE_RESOURCE_MANAGER_AUDIENCE<br><p> <br><p> See the [ASO docs] for more details.<br><p> <br><p> [ASO docs]: https://azure.github.io/azure-service-operator/guide/aso-controller-settings-options/
     */
    @JsonProperty("azureEnvironment")
    public String getAzureEnvironment() {
        return azureEnvironment;
    }

    /**
     * AzureEnvironment is the name of the AzureCloud to be used. The default value that would be used by most users is "AzurePublicCloud", other values are: - ChinaCloud: "AzureChinaCloud" - GermanCloud: "AzureGermanCloud" - PublicCloud: "AzurePublicCloud" - USGovernmentCloud: "AzureUSGovernmentCloud"<br><p> <br><p> Note that values other than the default must also be accompanied by corresponding changes to the aso-controller-settings Secret to configure ASO to refer to the non-Public cloud. ASO currently does not support referring to multiple different clouds in a single installation. The following fields must be defined in the Secret: - AZURE_AUTHORITY_HOST - AZURE_RESOURCE_MANAGER_ENDPOINT - AZURE_RESOURCE_MANAGER_AUDIENCE<br><p> <br><p> See the [ASO docs] for more details.<br><p> <br><p> [ASO docs]: https://azure.github.io/azure-service-operator/guide/aso-controller-settings-options/
     */
    @JsonProperty("azureEnvironment")
    public void setAzureEnvironment(String azureEnvironment) {
        this.azureEnvironment = azureEnvironment;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("bastionSpec")
    public BastionSpec getBastionSpec() {
        return bastionSpec;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("bastionSpec")
    public void setBastionSpec(BastionSpec bastionSpec) {
        this.bastionSpec = bastionSpec;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("cloudProviderConfigOverrides")
    public CloudProviderConfigOverrides getCloudProviderConfigOverrides() {
        return cloudProviderConfigOverrides;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("cloudProviderConfigOverrides")
    public void setCloudProviderConfigOverrides(CloudProviderConfigOverrides cloudProviderConfigOverrides) {
        this.cloudProviderConfigOverrides = cloudProviderConfigOverrides;
    }

    /**
     * ControlPlaneEnabled enables control plane components in the cluster.
     */
    @JsonProperty("controlPlaneEnabled")
    public Boolean getControlPlaneEnabled() {
        return controlPlaneEnabled;
    }

    /**
     * ControlPlaneEnabled enables control plane components in the cluster.
     */
    @JsonProperty("controlPlaneEnabled")
    public void setControlPlaneEnabled(Boolean controlPlaneEnabled) {
        this.controlPlaneEnabled = controlPlaneEnabled;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("controlPlaneEndpoint")
    public APIEndpoint getControlPlaneEndpoint() {
        return controlPlaneEndpoint;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("controlPlaneEndpoint")
    public void setControlPlaneEndpoint(APIEndpoint controlPlaneEndpoint) {
        this.controlPlaneEndpoint = controlPlaneEndpoint;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("extendedLocation")
    public ExtendedLocationSpec getExtendedLocation() {
        return extendedLocation;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("extendedLocation")
    public void setExtendedLocation(ExtendedLocationSpec extendedLocation) {
        this.extendedLocation = extendedLocation;
    }

    /**
     * FailureDomains is a list of failure domains in the cluster's region, used to restrict eligibility to host the control plane. A FailureDomain maps to an availability zone, which is a separated group of datacenters within a region. See: https://learn.microsoft.com/azure/reliability/availability-zones-overview
     */
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, FailureDomainSpec> getFailureDomains() {
        return failureDomains;
    }

    /**
     * FailureDomains is a list of failure domains in the cluster's region, used to restrict eligibility to host the control plane. A FailureDomain maps to an availability zone, which is a separated group of datacenters within a region. See: https://learn.microsoft.com/azure/reliability/availability-zones-overview
     */
    @JsonProperty("failureDomains")
    public void setFailureDomains(Map<String, FailureDomainSpec> failureDomains) {
        this.failureDomains = failureDomains;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("identityRef")
    public ObjectReference getIdentityRef() {
        return identityRef;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("identityRef")
    public void setIdentityRef(ObjectReference identityRef) {
        this.identityRef = identityRef;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("networkSpec")
    public NetworkSpec getNetworkSpec() {
        return networkSpec;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("networkSpec")
    public void setNetworkSpec(NetworkSpec networkSpec) {
        this.networkSpec = networkSpec;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("resourceGroup")
    public String getResourceGroup() {
        return resourceGroup;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("resourceGroup")
    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("subscriptionID")
    public String getSubscriptionID() {
        return subscriptionID;
    }

    /**
     * AzureClusterSpec defines the desired state of AzureCluster.
     */
    @JsonProperty("subscriptionID")
    public void setSubscriptionID(String subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    @JsonIgnore
    public AzureClusterSpecBuilder edit() {
        return new AzureClusterSpecBuilder(this);
    }

    @JsonIgnore
    public AzureClusterSpecBuilder toBuilder() {
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
