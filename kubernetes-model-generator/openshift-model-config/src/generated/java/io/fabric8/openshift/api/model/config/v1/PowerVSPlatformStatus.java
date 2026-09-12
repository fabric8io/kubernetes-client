
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
 * PowerVSPlatformStatus holds the current status of the IBM Power Systems Virtual Servers infrastrucutre provider.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cisInstanceCRN",
    "dnsInstanceCRN",
    "region",
    "resourceGroup",
    "serviceEndpoints",
    "zone"
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
public class PowerVSPlatformStatus implements Editable<PowerVSPlatformStatusBuilder>, KubernetesResource
{

    @JsonProperty("cisInstanceCRN")
    private String cisInstanceCRN;
    @JsonProperty("dnsInstanceCRN")
    private String dnsInstanceCRN;
    @JsonProperty("region")
    private String region;
    @JsonProperty("resourceGroup")
    private String resourceGroup;
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PowerVSServiceEndpoint> serviceEndpoints = new ArrayList<>();
    @JsonProperty("zone")
    private String zone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PowerVSPlatformStatus() {
    }

    public PowerVSPlatformStatus(String cisInstanceCRN, String dnsInstanceCRN, String region, String resourceGroup, List<PowerVSServiceEndpoint> serviceEndpoints, String zone) {
        super();
        this.cisInstanceCRN = cisInstanceCRN;
        this.dnsInstanceCRN = dnsInstanceCRN;
        this.region = region;
        this.resourceGroup = resourceGroup;
        this.serviceEndpoints = serviceEndpoints;
        this.zone = zone;
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
     * region holds the default Power VS region for new Power VS resources created by the cluster.
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * region holds the default Power VS region for new Power VS resources created by the cluster.
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * resourceGroup is the resource group name for new IBMCloud resources created for a cluster. The resource group specified here will be used by cluster-image-registry-operator to set up a COS Instance in IBMCloud for the cluster registry. More about resource groups can be found here: https://cloud.ibm.com/docs/account?topic=account-rgs. When omitted, the image registry operator won't be able to configure storage, which results in the image registry cluster operator not being in an available state.
     */
    @JsonProperty("resourceGroup")
    public String getResourceGroup() {
        return resourceGroup;
    }

    /**
     * resourceGroup is the resource group name for new IBMCloud resources created for a cluster. The resource group specified here will be used by cluster-image-registry-operator to set up a COS Instance in IBMCloud for the cluster registry. More about resource groups can be found here: https://cloud.ibm.com/docs/account?topic=account-rgs. When omitted, the image registry operator won't be able to configure storage, which results in the image registry cluster operator not being in an available state.
     */
    @JsonProperty("resourceGroup")
    public void setResourceGroup(String resourceGroup) {
        this.resourceGroup = resourceGroup;
    }

    /**
     * serviceEndpoints is a list of custom endpoints which will override the default service endpoints of a Power VS service.
     */
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PowerVSServiceEndpoint> getServiceEndpoints() {
        return serviceEndpoints;
    }

    /**
     * serviceEndpoints is a list of custom endpoints which will override the default service endpoints of a Power VS service.
     */
    @JsonProperty("serviceEndpoints")
    public void setServiceEndpoints(List<PowerVSServiceEndpoint> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
    }

    /**
     * zone holds the default zone for the new Power VS resources created by the cluster. Note: Currently only single-zone OCP clusters are supported
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * zone holds the default zone for the new Power VS resources created by the cluster. Note: Currently only single-zone OCP clusters are supported
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    @JsonIgnore
    public PowerVSPlatformStatusBuilder edit() {
        return new PowerVSPlatformStatusBuilder(this);
    }

    @JsonIgnore
    public PowerVSPlatformStatusBuilder toBuilder() {
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
        if (!(o instanceof PowerVSPlatformStatus)) {
            return false;
        }
        PowerVSPlatformStatus other = (PowerVSPlatformStatus) o;
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
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$resourceGroup = this.getResourceGroup();
        Object other$resourceGroup = other.getResourceGroup();
        if (this$resourceGroup == null ? other$resourceGroup != null : !this$resourceGroup.equals(other$resourceGroup)) {
            return false;
        }
        Object this$serviceEndpoints = this.getServiceEndpoints();
        Object other$serviceEndpoints = other.getServiceEndpoints();
        if (this$serviceEndpoints == null ? other$serviceEndpoints != null : !this$serviceEndpoints.equals(other$serviceEndpoints)) {
            return false;
        }
        Object this$zone = this.getZone();
        Object other$zone = other.getZone();
        if (this$zone == null ? other$zone != null : !this$zone.equals(other$zone)) {
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
        return other instanceof PowerVSPlatformStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $cisInstanceCRN = this.getCisInstanceCRN();
        result = result * prime + ($cisInstanceCRN == null ? 43 : $cisInstanceCRN.hashCode());
        Object $dnsInstanceCRN = this.getDnsInstanceCRN();
        result = result * prime + ($dnsInstanceCRN == null ? 43 : $dnsInstanceCRN.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $resourceGroup = this.getResourceGroup();
        result = result * prime + ($resourceGroup == null ? 43 : $resourceGroup.hashCode());
        Object $serviceEndpoints = this.getServiceEndpoints();
        result = result * prime + ($serviceEndpoints == null ? 43 : $serviceEndpoints.hashCode());
        Object $zone = this.getZone();
        result = result * prime + ($zone == null ? 43 : $zone.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PowerVSPlatformStatus(" + "cisInstanceCRN=" + this.getCisInstanceCRN() + ", dnsInstanceCRN=" + this.getDnsInstanceCRN() + ", region=" + this.getRegion() + ", resourceGroup=" + this.getResourceGroup() + ", serviceEndpoints=" + this.getServiceEndpoints() + ", zone=" + this.getZone() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
