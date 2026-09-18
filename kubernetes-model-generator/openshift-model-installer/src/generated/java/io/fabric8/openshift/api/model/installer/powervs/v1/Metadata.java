
package io.fabric8.openshift.api.model.installer.powervs.v1;

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
import io.fabric8.openshift.api.model.config.v1.PowerVSServiceEndpoint;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "BaseDomain",
    "cisInstanceCRN",
    "dnsInstanceCRN",
    "powerVSResourceGroup",
    "region",
    "serviceEndpoints",
    "serviceInstanceGUID",
    "transitGatewayName",
    "vpcName",
    "vpcRegion",
    "zone"
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

    @JsonProperty("BaseDomain")
    private String baseDomain;
    @JsonProperty("cisInstanceCRN")
    private String cisInstanceCRN;
    @JsonProperty("dnsInstanceCRN")
    private String dnsInstanceCRN;
    @JsonProperty("powerVSResourceGroup")
    private String powerVSResourceGroup;
    @JsonProperty("region")
    private String region;
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PowerVSServiceEndpoint> serviceEndpoints = new ArrayList<>();
    @JsonProperty("serviceInstanceGUID")
    private String serviceInstanceGUID;
    @JsonProperty("transitGatewayName")
    private String transitGatewayName;
    @JsonProperty("vpcName")
    private String vpcName;
    @JsonProperty("vpcRegion")
    private String vpcRegion;
    @JsonProperty("zone")
    private String zone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Metadata() {
    }

    public Metadata(String baseDomain, String cisInstanceCRN, String dnsInstanceCRN, String powerVSResourceGroup, String region, List<PowerVSServiceEndpoint> serviceEndpoints, String serviceInstanceGUID, String transitGatewayName, String vpcName, String vpcRegion, String zone) {
        super();
        this.baseDomain = baseDomain;
        this.cisInstanceCRN = cisInstanceCRN;
        this.dnsInstanceCRN = dnsInstanceCRN;
        this.powerVSResourceGroup = powerVSResourceGroup;
        this.region = region;
        this.serviceEndpoints = serviceEndpoints;
        this.serviceInstanceGUID = serviceInstanceGUID;
        this.transitGatewayName = transitGatewayName;
        this.vpcName = vpcName;
        this.vpcRegion = vpcRegion;
        this.zone = zone;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("BaseDomain")
    public String getBaseDomain() {
        return baseDomain;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("BaseDomain")
    public void setBaseDomain(String baseDomain) {
        this.baseDomain = baseDomain;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("cisInstanceCRN")
    public String getCisInstanceCRN() {
        return cisInstanceCRN;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("cisInstanceCRN")
    public void setCisInstanceCRN(String cisInstanceCRN) {
        this.cisInstanceCRN = cisInstanceCRN;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("dnsInstanceCRN")
    public String getDnsInstanceCRN() {
        return dnsInstanceCRN;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("dnsInstanceCRN")
    public void setDnsInstanceCRN(String dnsInstanceCRN) {
        this.dnsInstanceCRN = dnsInstanceCRN;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("powerVSResourceGroup")
    public String getPowerVSResourceGroup() {
        return powerVSResourceGroup;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("powerVSResourceGroup")
    public void setPowerVSResourceGroup(String powerVSResourceGroup) {
        this.powerVSResourceGroup = powerVSResourceGroup;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("serviceEndpoints")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PowerVSServiceEndpoint> getServiceEndpoints() {
        return serviceEndpoints;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("serviceEndpoints")
    public void setServiceEndpoints(List<PowerVSServiceEndpoint> serviceEndpoints) {
        this.serviceEndpoints = serviceEndpoints;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("serviceInstanceGUID")
    public String getServiceInstanceGUID() {
        return serviceInstanceGUID;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("serviceInstanceGUID")
    public void setServiceInstanceGUID(String serviceInstanceGUID) {
        this.serviceInstanceGUID = serviceInstanceGUID;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("transitGatewayName")
    public String getTransitGatewayName() {
        return transitGatewayName;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("transitGatewayName")
    public void setTransitGatewayName(String transitGatewayName) {
        this.transitGatewayName = transitGatewayName;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("vpcName")
    public String getVpcName() {
        return vpcName;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("vpcName")
    public void setVpcName(String vpcName) {
        this.vpcName = vpcName;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("vpcRegion")
    public String getVpcRegion() {
        return vpcRegion;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("vpcRegion")
    public void setVpcRegion(String vpcRegion) {
        this.vpcRegion = vpcRegion;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * Metadata contains Power VS metadata (e.g. for uninstalling the cluster).
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
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
        Object this$dnsInstanceCRN = this.getDnsInstanceCRN();
        Object other$dnsInstanceCRN = other.getDnsInstanceCRN();
        if (this$dnsInstanceCRN == null ? other$dnsInstanceCRN != null : !this$dnsInstanceCRN.equals(other$dnsInstanceCRN)) {
            return false;
        }
        Object this$powerVSResourceGroup = this.getPowerVSResourceGroup();
        Object other$powerVSResourceGroup = other.getPowerVSResourceGroup();
        if (this$powerVSResourceGroup == null ? other$powerVSResourceGroup != null : !this$powerVSResourceGroup.equals(other$powerVSResourceGroup)) {
            return false;
        }
        Object this$region = this.getRegion();
        Object other$region = other.getRegion();
        if (this$region == null ? other$region != null : !this$region.equals(other$region)) {
            return false;
        }
        Object this$serviceEndpoints = this.getServiceEndpoints();
        Object other$serviceEndpoints = other.getServiceEndpoints();
        if (this$serviceEndpoints == null ? other$serviceEndpoints != null : !this$serviceEndpoints.equals(other$serviceEndpoints)) {
            return false;
        }
        Object this$serviceInstanceGUID = this.getServiceInstanceGUID();
        Object other$serviceInstanceGUID = other.getServiceInstanceGUID();
        if (this$serviceInstanceGUID == null ? other$serviceInstanceGUID != null : !this$serviceInstanceGUID.equals(other$serviceInstanceGUID)) {
            return false;
        }
        Object this$transitGatewayName = this.getTransitGatewayName();
        Object other$transitGatewayName = other.getTransitGatewayName();
        if (this$transitGatewayName == null ? other$transitGatewayName != null : !this$transitGatewayName.equals(other$transitGatewayName)) {
            return false;
        }
        Object this$vpcName = this.getVpcName();
        Object other$vpcName = other.getVpcName();
        if (this$vpcName == null ? other$vpcName != null : !this$vpcName.equals(other$vpcName)) {
            return false;
        }
        Object this$vpcRegion = this.getVpcRegion();
        Object other$vpcRegion = other.getVpcRegion();
        if (this$vpcRegion == null ? other$vpcRegion != null : !this$vpcRegion.equals(other$vpcRegion)) {
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
        return other instanceof Metadata;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $baseDomain = this.getBaseDomain();
        result = result * prime + ($baseDomain == null ? 43 : $baseDomain.hashCode());
        Object $cisInstanceCRN = this.getCisInstanceCRN();
        result = result * prime + ($cisInstanceCRN == null ? 43 : $cisInstanceCRN.hashCode());
        Object $dnsInstanceCRN = this.getDnsInstanceCRN();
        result = result * prime + ($dnsInstanceCRN == null ? 43 : $dnsInstanceCRN.hashCode());
        Object $powerVSResourceGroup = this.getPowerVSResourceGroup();
        result = result * prime + ($powerVSResourceGroup == null ? 43 : $powerVSResourceGroup.hashCode());
        Object $region = this.getRegion();
        result = result * prime + ($region == null ? 43 : $region.hashCode());
        Object $serviceEndpoints = this.getServiceEndpoints();
        result = result * prime + ($serviceEndpoints == null ? 43 : $serviceEndpoints.hashCode());
        Object $serviceInstanceGUID = this.getServiceInstanceGUID();
        result = result * prime + ($serviceInstanceGUID == null ? 43 : $serviceInstanceGUID.hashCode());
        Object $transitGatewayName = this.getTransitGatewayName();
        result = result * prime + ($transitGatewayName == null ? 43 : $transitGatewayName.hashCode());
        Object $vpcName = this.getVpcName();
        result = result * prime + ($vpcName == null ? 43 : $vpcName.hashCode());
        Object $vpcRegion = this.getVpcRegion();
        result = result * prime + ($vpcRegion == null ? 43 : $vpcRegion.hashCode());
        Object $zone = this.getZone();
        result = result * prime + ($zone == null ? 43 : $zone.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Metadata(" + "baseDomain=" + this.getBaseDomain() + ", cisInstanceCRN=" + this.getCisInstanceCRN() + ", dnsInstanceCRN=" + this.getDnsInstanceCRN() + ", powerVSResourceGroup=" + this.getPowerVSResourceGroup() + ", region=" + this.getRegion() + ", serviceEndpoints=" + this.getServiceEndpoints() + ", serviceInstanceGUID=" + this.getServiceInstanceGUID() + ", transitGatewayName=" + this.getTransitGatewayName() + ", vpcName=" + this.getVpcName() + ", vpcRegion=" + this.getVpcRegion() + ", zone=" + this.getZone() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
