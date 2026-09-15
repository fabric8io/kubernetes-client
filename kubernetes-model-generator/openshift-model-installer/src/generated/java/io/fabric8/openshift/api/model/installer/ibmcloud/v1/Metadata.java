
package io.fabric8.openshift.api.model.installer.ibmcloud.v1;

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
import io.fabric8.openshift.api.model.config.v1.IBMCloudServiceEndpoint;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accountID",
    "baseDomain",
    "cisInstanceCRN",
    "dnsInstanceID",
    "region",
    "resourceGroupName",
    "serviceEndpoints",
    "subnets",
    "vpc"
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
public class Metadata implements Editable<MetadataBuilder>, KubernetesResource
{

    @JsonProperty("accountID")
    private String accountID;
    @JsonProperty("baseDomain")
    private String baseDomain;
    @JsonProperty("cisInstanceCRN")
    private String cisInstanceCRN;
    @JsonProperty("dnsInstanceID")
    private String dnsInstanceID;
    @JsonProperty("region")
    private String region;
    @JsonProperty("resourceGroupName")
    private String resourceGroupName;
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IBMCloudServiceEndpoint> serviceEndpoints = new ArrayList<>();
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> subnets = new ArrayList<>();
    @JsonProperty("vpc")
    private String vpc;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metadata() {
    }

    public Metadata(String accountID, String baseDomain, String cisInstanceCRN, String dnsInstanceID, String region, String resourceGroupName, List<IBMCloudServiceEndpoint> serviceEndpoints, List<String> subnets, String vpc) {
        super();
        this.accountID = accountID;
        this.baseDomain = baseDomain;
        this.cisInstanceCRN = cisInstanceCRN;
        this.dnsInstanceID = dnsInstanceID;
        this.region = region;
        this.resourceGroupName = resourceGroupName;
        this.serviceEndpoints = serviceEndpoints;
        this.subnets = subnets;
        this.vpc = vpc;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("accountID")
    public String getAccountID() {
        return accountID;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("accountID")
    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("baseDomain")
    public String getBaseDomain() {
        return baseDomain;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("baseDomain")
    public void setBaseDomain(String baseDomain) {
        this.baseDomain = baseDomain;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("cisInstanceCRN")
    public String getCisInstanceCRN() {
        return cisInstanceCRN;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("cisInstanceCRN")
    public void setCisInstanceCRN(String cisInstanceCRN) {
        this.cisInstanceCRN = cisInstanceCRN;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("dnsInstanceID")
    public String getDnsInstanceID() {
        return dnsInstanceID;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("dnsInstanceID")
    public void setDnsInstanceID(String dnsInstanceID) {
        this.dnsInstanceID = dnsInstanceID;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("resourceGroupName")
    public String getResourceGroupName() {
        return resourceGroupName;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("resourceGroupName")
    public void setResourceGroupName(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IBMCloudServiceEndpoint> getServiceEndpoints() {
        return serviceEndpoints;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("serviceEndpoints")
    public void setServiceEndpoints(List<IBMCloudServiceEndpoint> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("subnets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSubnets() {
        return subnets;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("subnets")
    public void setSubnets(List<String> subnets) {
        this.subnets = subnets;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("vpc")
    public String getVpc() {
        return vpc;
    }

    /**
     * Metadata contains IBM Cloud metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("vpc")
    public void setVpc(String vpc) {
        this.vpc = vpc;
    }

    @JsonIgnore
    public MetadataBuilder edit() {
        return new MetadataBuilder(this);
    }

    @JsonIgnore
    public MetadataBuilder toBuilder() {
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
        if (!(o instanceof Metadata)) {
            return false;
        }
        Metadata other = (Metadata) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$accountID = this.getAccountID();
        Object other$accountID = other.getAccountID();
        if (this$accountID == null ? other$accountID != null : !this$accountID.equals(other$accountID)) {
            return false;
        }
        Object this$baseDomain = this.getBaseDomain();
        Object other$baseDomain = other.getBaseDomain();
        if (this$baseDomain == null ? other$baseDomain != null : !this$baseDomain.equals(other$baseDomain)) {
            return false;
        }
        Object this$cisInstanceCRN = this.getCisInstanceCRN();
        Object other$cisInstanceCRN = other.getCisInstanceCRN();
        if (this$cisInstanceCRN == null ? other$cisInstanceCRN != null : !this$cisInstanceCRN.equals(other$cisInstanceCRN)) {
            return false;
        }
        Object this$dnsInstanceID = this.getDnsInstanceID();
        Object other$dnsInstanceID = other.getDnsInstanceID();
        if (this$dnsInstanceID == null ? other$dnsInstanceID != null : !this$dnsInstanceID.equals(other$dnsInstanceID)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
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
        Object this$subnets = this.getSubnets();
        Object other$subnets = other.getSubnets();
        if (this$subnets == null ? other$subnets != null : !this$subnets.equals(other$subnets)) {
            return false;
        }
        Object this$vpc = this.getVpc();
        Object other$vpc = other.getVpc();
        if (this$vpc == null ? other$vpc != null : !this$vpc.equals(other$vpc)) {
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
        return other instanceof Metadata;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $accountID = this.getAccountID();
        result = result * prime + ($accountID == null ? 43 : $accountID.hashCode());
        Object $baseDomain = this.getBaseDomain();
        result = result * prime + ($baseDomain == null ? 43 : $baseDomain.hashCode());
        Object $cisInstanceCRN = this.getCisInstanceCRN();
        result = result * prime + ($cisInstanceCRN == null ? 43 : $cisInstanceCRN.hashCode());
        Object $dnsInstanceID = this.getDnsInstanceID();
        result = result * prime + ($dnsInstanceID == null ? 43 : $dnsInstanceID.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $resourceGroupName = this.getResourceGroupName();
        result = result * prime + ($resourceGroupName == null ? 43 : $resourceGroupName.hashCode());
        Object $serviceEndpoints = this.getServiceEndpoints();
        result = result * prime + ($serviceEndpoints == null ? 43 : $serviceEndpoints.hashCode());
        Object $subnets = this.getSubnets();
        result = result * prime + ($subnets == null ? 43 : $subnets.hashCode());
        Object $vpc = this.getVpc();
        result = result * prime + ($vpc == null ? 43 : $vpc.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metadata(" + "accountID=" + this.getAccountID() + ", baseDomain=" + this.getBaseDomain() + ", cisInstanceCRN=" + this.getCisInstanceCRN() + ", dnsInstanceID=" + this.getDnsInstanceID() + ", region=" + this.getRegion() + ", resourceGroupName=" + this.getResourceGroupName() + ", serviceEndpoints=" + this.getServiceEndpoints() + ", subnets=" + this.getSubnets() + ", vpc=" + this.getVpc() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
