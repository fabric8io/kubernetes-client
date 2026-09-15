
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * IBMCloudPlatformStatus holds the current status of the IBMCloud infrastructure provider.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cisInstanceCRN",
    "dnsInstanceCRN",
    "location",
    "providerType",
    "resourceGroupName",
    "serviceEndpoints"
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
public class IBMCloudPlatformStatus implements Editable<IBMCloudPlatformStatusBuilder>, KubernetesResource
{

    @JsonProperty("cisInstanceCRN")
    private String cisInstanceCRN;
    @JsonProperty("dnsInstanceCRN")
    private String dnsInstanceCRN;
    @JsonProperty("location")
    private String location;
    @JsonProperty("providerType")
    private String providerType;
    @JsonProperty("resourceGroupName")
    private String resourceGroupName;
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IBMCloudServiceEndpoint> serviceEndpoints = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IBMCloudPlatformStatus() {
    }

    public IBMCloudPlatformStatus(String cisInstanceCRN, String dnsInstanceCRN, String location, String providerType, String resourceGroupName, List<IBMCloudServiceEndpoint> serviceEndpoints) {
        super();
        this.cisInstanceCRN = cisInstanceCRN;
        this.dnsInstanceCRN = dnsInstanceCRN;
        this.location = location;
        this.providerType = providerType;
        this.resourceGroupName = resourceGroupName;
        this.serviceEndpoints = serviceEndpoints;
    }

    /**
     * cisInstanceCRN is the CRN of the Cloud Internet Services instance managing the DNS zone for the cluster's base domain
     */
    @JsonProperty("cisInstanceCRN")
    public String getCisInstanceCRN() {
        return cisInstanceCRN;
    }

    /**
     * cisInstanceCRN is the CRN of the Cloud Internet Services instance managing the DNS zone for the cluster's base domain
     */
    @JsonProperty("cisInstanceCRN")
    public void setCisInstanceCRN(String cisInstanceCRN) {
        this.cisInstanceCRN = cisInstanceCRN;
    }

    /**
     * dnsInstanceCRN is the CRN of the DNS Services instance managing the DNS zone for the cluster's base domain
     */
    @JsonProperty("dnsInstanceCRN")
    public String getDnsInstanceCRN() {
        return dnsInstanceCRN;
    }

    /**
     * dnsInstanceCRN is the CRN of the DNS Services instance managing the DNS zone for the cluster's base domain
     */
    @JsonProperty("dnsInstanceCRN")
    public void setDnsInstanceCRN(String dnsInstanceCRN) {
        this.dnsInstanceCRN = dnsInstanceCRN;
    }

    /**
     * location is where the cluster has been deployed
     */
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    /**
     * location is where the cluster has been deployed
     */
    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * providerType indicates the type of cluster that was created
     */
    @JsonProperty("providerType")
    public String getProviderType() {
        return providerType;
    }

    /**
     * providerType indicates the type of cluster that was created
     */
    @JsonProperty("providerType")
    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    /**
     * resourceGroupName is the Resource Group for new IBMCloud resources created for the cluster.
     */
    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    /**
     * resourceGroupName is the Resource Group for new IBMCloud resources created for the cluster.
     */
    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    /**
     * serviceEndpoints is a list of custom endpoints which will override the default service endpoints of an IBM service. These endpoints are used by components within the cluster when trying to reach the IBM Cloud Services that have been overriden. The CCCMO reads in the IBMCloudPlatformSpec and validates each endpoint is resolvable. Once validated, the cloud config and IBMCloudPlatformStatus are updated to reflect the same custom endpoints.
     */
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IBMCloudServiceEndpoint> getServiceEndpoints() {
        return serviceEndpoints;
    }

    /**
     * serviceEndpoints is a list of custom endpoints which will override the default service endpoints of an IBM service. These endpoints are used by components within the cluster when trying to reach the IBM Cloud Services that have been overriden. The CCCMO reads in the IBMCloudPlatformSpec and validates each endpoint is resolvable. Once validated, the cloud config and IBMCloudPlatformStatus are updated to reflect the same custom endpoints.
     */
    @JsonProperty("serviceEndpoints")
    public void setServiceEndpoints(List<IBMCloudServiceEndpoint> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
    }

    @JsonIgnore
    public IBMCloudPlatformStatusBuilder edit() {
        return new IBMCloudPlatformStatusBuilder(this);
    }

    @JsonIgnore
    public IBMCloudPlatformStatusBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof IBMCloudPlatformStatus)) {
            return false;
        }
        IBMCloudPlatformStatus other = (IBMCloudPlatformStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$cisInstanceCRN = this.getCisInstanceCRN();
        Object other$cisInstanceCRN = other.getCisInstanceCRN();
        if (this$cisInstanceCRN == null ? other$cisInstanceCRN != null : !this$cisInstanceCRN.equals(other$cisInstanceCRN)) {
            return false;
        }
        Object this$dnsInstanceCRN = this.getDnsInstanceCRN();
        Object other$dnsInstanceCRN = other.getDnsInstanceCRN();
        if (this$dnsInstanceCRN == null ? other$dnsInstanceCRN != null : !this$dnsInstanceCRN.equals(other$dnsInstanceCRN)) {
            return false;
        }
        Object this$location = this.getLocation();
        Object other$location = other.getLocation();
        if (this$location == null ? other$location != null : !this$location.equals(other$location)) {
            return false;
        }
        Object this$providerType = this.getProviderType();
        Object other$providerType = other.getProviderType();
        if (this$providerType == null ? other$providerType != null : !this$providerType.equals(other$providerType)) {
            return false;
        }
        Object this$resourceGroupName = this.getResourceGroupName();
        Object other$resourceGroupName = other.getResourceGroupName();
        if (this$resourceGroupName == null ? other$resourceGroupName != null : !this$resourceGroupName.equals(other$resourceGroupName)) {
            return false;
        }
        Object this$serviceEndpoints = this.getServiceEndpoints();
        Object other$serviceEndpoints = other.getServiceEndpoints();
        if (this$serviceEndpoints == null ? other$serviceEndpoints != null : !this$serviceEndpoints.equals(other$serviceEndpoints)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof IBMCloudPlatformStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cisInstanceCRN = this.getCisInstanceCRN();
        result = result * prime + ($cisInstanceCRN == null ? 43 : $cisInstanceCRN.hashCode());
        Object $dnsInstanceCRN = this.getDnsInstanceCRN();
        result = result * prime + ($dnsInstanceCRN == null ? 43 : $dnsInstanceCRN.hashCode());
        Object $location = this.getLocation();
        result = result * prime + ($location == null ? 43 : $location.hashCode());
        Object $providerType = this.getProviderType();
        result = result * prime + ($providerType == null ? 43 : $providerType.hashCode());
        Object $resourceGroupName = this.getResourceGroupName();
        result = result * prime + ($resourceGroupName == null ? 43 : $resourceGroupName.hashCode());
        Object $serviceEndpoints = this.getServiceEndpoints();
        result = result * prime + ($serviceEndpoints == null ? 43 : $serviceEndpoints.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IBMCloudPlatformStatus(" + "cisInstanceCRN=" + this.getCisInstanceCRN() + ", dnsInstanceCRN=" + this.getDnsInstanceCRN() + ", location=" + this.getLocation() + ", providerType=" + this.getProviderType() + ", resourceGroupName=" + this.getResourceGroupName() + ", serviceEndpoints=" + this.getServiceEndpoints() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
