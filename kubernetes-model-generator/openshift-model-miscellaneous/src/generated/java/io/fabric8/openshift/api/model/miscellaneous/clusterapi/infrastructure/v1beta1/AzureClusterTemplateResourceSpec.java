
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.infrastructure.v1beta1;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1.FailureDomainSpec;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "additionalTags",
    "azureEnvironment",
    "bastionSpec",
    "cloudProviderConfigOverrides",
    "extendedLocation",
    "failureDomains",
    "identityRef",
    "location",
    "networkSpec",
    "subscriptionID"
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
public class AzureClusterTemplateResourceSpec implements Editable<AzureClusterTemplateResourceSpecBuilder>, KubernetesResource
{

    @JsonProperty("additionalTags")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> additionalTags = new LinkedHashMap<>();
    @JsonProperty("azureEnvironment")
    private String azureEnvironment;
    @JsonProperty("bastionSpec")
    private BastionTemplateSpec bastionSpec;
    @JsonProperty("cloudProviderConfigOverrides")
    private CloudProviderConfigOverrides cloudProviderConfigOverrides;
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
    private NetworkTemplateSpec networkSpec;
    @JsonProperty("subscriptionID")
    private String subscriptionID;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AzureClusterTemplateResourceSpec() {
    }

    public AzureClusterTemplateResourceSpec(Map<String, String> additionalTags, String azureEnvironment, BastionTemplateSpec bastionSpec, CloudProviderConfigOverrides cloudProviderConfigOverrides, ExtendedLocationSpec extendedLocation, Map<String, FailureDomainSpec> failureDomains, ObjectReference identityRef, String location, NetworkTemplateSpec networkSpec, String subscriptionID) {
        super();
        this.additionalTags = additionalTags;
        this.azureEnvironment = azureEnvironment;
        this.bastionSpec = bastionSpec;
        this.cloudProviderConfigOverrides = cloudProviderConfigOverrides;
        this.extendedLocation = extendedLocation;
        this.failureDomains = failureDomains;
        this.identityRef = identityRef;
        this.location = location;
        this.networkSpec = networkSpec;
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
     * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
     */
    @JsonProperty("bastionSpec")
    public BastionTemplateSpec getBastionSpec() {
        return bastionSpec;
    }

    /**
     * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
     */
    @JsonProperty("bastionSpec")
    public void setBastionSpec(BastionTemplateSpec bastionSpec) {
        this.bastionSpec = bastionSpec;
    }

    /**
     * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
     */
    @JsonProperty("cloudProviderConfigOverrides")
    public CloudProviderConfigOverrides getCloudProviderConfigOverrides() {
        return cloudProviderConfigOverrides;
    }

    /**
     * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
     */
    @JsonProperty("cloudProviderConfigOverrides")
    public void setCloudProviderConfigOverrides(CloudProviderConfigOverrides cloudProviderConfigOverrides) {
        this.cloudProviderConfigOverrides = cloudProviderConfigOverrides;
    }

    /**
     * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
     */
    @JsonProperty("extendedLocation")
    public ExtendedLocationSpec getExtendedLocation() {
        return extendedLocation;
    }

    /**
     * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
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
     * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
     */
    @JsonProperty("identityRef")
    public ObjectReference getIdentityRef() {
        return identityRef;
    }

    /**
     * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
     */
    @JsonProperty("identityRef")
    public void setIdentityRef(ObjectReference identityRef) {
        this.identityRef = identityRef;
    }

    /**
     * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
     */
    @JsonProperty("networkSpec")
    public NetworkTemplateSpec getNetworkSpec() {
        return networkSpec;
    }

    /**
     * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
     */
    @JsonProperty("networkSpec")
    public void setNetworkSpec(NetworkTemplateSpec networkSpec) {
        this.networkSpec = networkSpec;
    }

    /**
     * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
     */
    @JsonProperty("subscriptionID")
    public String getSubscriptionID() {
        return subscriptionID;
    }

    /**
     * AzureClusterTemplateResourceSpec specifies an Azure cluster template resource.
     */
    @JsonProperty("subscriptionID")
    public void setSubscriptionID(String subscriptionID) {
        this.subscriptionID = subscriptionID;
    }

    @JsonIgnore
    public AzureClusterTemplateResourceSpecBuilder edit() {
        return new AzureClusterTemplateResourceSpecBuilder(this);
    }

    @JsonIgnore
    public AzureClusterTemplateResourceSpecBuilder toBuilder() {
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
