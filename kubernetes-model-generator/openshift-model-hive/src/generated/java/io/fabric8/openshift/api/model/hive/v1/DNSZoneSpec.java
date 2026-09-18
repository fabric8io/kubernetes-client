
package io.fabric8.openshift.api.model.hive.v1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * DNSZoneSpec defines the desired state of DNSZone
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "azure",
    "gcp",
    "linkToParentDomain",
    "preserveOnDelete",
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
public class DNSZoneSpec implements Editable<DNSZoneSpecBuilder>, KubernetesResource
{

    @JsonProperty("aws")
    private AWSDNSZoneSpec aws;
    @JsonProperty("azure")
    private AzureDNSZoneSpec azure;
    @JsonProperty("gcp")
    private GCPDNSZoneSpec gcp;
    @JsonProperty("linkToParentDomain")
    private Boolean linkToParentDomain;
    @JsonProperty("preserveOnDelete")
    private Boolean preserveOnDelete;
    @JsonProperty("zone")
    private String zone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DNSZoneSpec() {
    }

    public DNSZoneSpec(AWSDNSZoneSpec aws, AzureDNSZoneSpec azure, GCPDNSZoneSpec gcp, Boolean linkToParentDomain, Boolean preserveOnDelete, String zone) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.gcp = gcp;
        this.linkToParentDomain = linkToParentDomain;
        this.preserveOnDelete = preserveOnDelete;
        this.zone = zone;
    }

    /**
     * DNSZoneSpec defines the desired state of DNSZone
     */
    @JsonProperty("aws")
    public AWSDNSZoneSpec getAws() {
        return aws;
    }

    /**
     * DNSZoneSpec defines the desired state of DNSZone
     */
    @JsonProperty("aws")
    public void setAws(AWSDNSZoneSpec aws) {
        this.aws = aws;
    }

    /**
     * DNSZoneSpec defines the desired state of DNSZone
     */
    @JsonProperty("azure")
    public AzureDNSZoneSpec getAzure() {
        return azure;
    }

    /**
     * DNSZoneSpec defines the desired state of DNSZone
     */
    @JsonProperty("azure")
    public void setAzure(AzureDNSZoneSpec azure) {
        this.azure = azure;
    }

    /**
     * DNSZoneSpec defines the desired state of DNSZone
     */
    @JsonProperty("gcp")
    public GCPDNSZoneSpec getGcp() {
        return gcp;
    }

    /**
     * DNSZoneSpec defines the desired state of DNSZone
     */
    @JsonProperty("gcp")
    public void setGcp(GCPDNSZoneSpec gcp) {
        this.gcp = gcp;
    }

    /**
     * LinkToParentDomain specifies whether DNS records should be automatically created to link this DNSZone with a parent domain.
     */
    @JsonProperty("linkToParentDomain")
    public Boolean getLinkToParentDomain() {
        return linkToParentDomain;
    }

    /**
     * LinkToParentDomain specifies whether DNS records should be automatically created to link this DNSZone with a parent domain.
     */
    @JsonProperty("linkToParentDomain")
    public void setLinkToParentDomain(Boolean linkToParentDomain) {
        this.linkToParentDomain = linkToParentDomain;
    }

    /**
     * PreserveOnDelete allows the user to disconnect a DNSZone from Hive without deprovisioning it. This can also be used to abandon ongoing DNSZone deprovision. Typically set automatically due to PreserveOnDelete being set on a ClusterDeployment.
     */
    @JsonProperty("preserveOnDelete")
    public Boolean getPreserveOnDelete() {
        return preserveOnDelete;
    }

    /**
     * PreserveOnDelete allows the user to disconnect a DNSZone from Hive without deprovisioning it. This can also be used to abandon ongoing DNSZone deprovision. Typically set automatically due to PreserveOnDelete being set on a ClusterDeployment.
     */
    @JsonProperty("preserveOnDelete")
    public void setPreserveOnDelete(Boolean preserveOnDelete) {
        this.preserveOnDelete = preserveOnDelete;
    }

    /**
     * Zone is the DNS zone to host
     */
    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    /**
     * Zone is the DNS zone to host
     */
    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    @JsonIgnore
    public DNSZoneSpecBuilder edit() {
        return new DNSZoneSpecBuilder(this);
    }

    @JsonIgnore
    public DNSZoneSpecBuilder toBuilder() {
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
        if (!(o instanceof DNSZoneSpec)) {
            return false;
        }
        DNSZoneSpec other = (DNSZoneSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$aws = this.getAws();
        Object other$aws = other.getAws();
        if (this$aws == null ? other$aws != null : !this$aws.equals(other$aws)) {
            return false;
        }
        Object this$azure = this.getAzure();
        Object other$azure = other.getAzure();
        if (this$azure == null ? other$azure != null : !this$azure.equals(other$azure)) {
            return false;
        }
        Object this$gcp = this.getGcp();
        Object other$gcp = other.getGcp();
        if (this$gcp == null ? other$gcp != null : !this$gcp.equals(other$gcp)) {
            return false;
        }
        Object this$linkToParentDomain = this.getLinkToParentDomain();
        Object other$linkToParentDomain = other.getLinkToParentDomain();
        if (this$linkToParentDomain == null ? other$linkToParentDomain != null : !this$linkToParentDomain.equals(other$linkToParentDomain)) {
            return false;
        }
        Object this$preserveOnDelete = this.getPreserveOnDelete();
        Object other$preserveOnDelete = other.getPreserveOnDelete();
        if (this$preserveOnDelete == null ? other$preserveOnDelete != null : !this$preserveOnDelete.equals(other$preserveOnDelete)) {
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
        return other instanceof DNSZoneSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $aws = this.getAws();
        result = result * prime + ($aws == null ? 43 : $aws.hashCode());
        Object $azure = this.getAzure();
        result = result * prime + ($azure == null ? 43 : $azure.hashCode());
        Object $gcp = this.getGcp();
        result = result * prime + ($gcp == null ? 43 : $gcp.hashCode());
        Object $linkToParentDomain = this.getLinkToParentDomain();
        result = result * prime + ($linkToParentDomain == null ? 43 : $linkToParentDomain.hashCode());
        Object $preserveOnDelete = this.getPreserveOnDelete();
        result = result * prime + ($preserveOnDelete == null ? 43 : $preserveOnDelete.hashCode());
        Object $zone = this.getZone();
        result = result * prime + ($zone == null ? 43 : $zone.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DNSZoneSpec(" + "aws=" + this.getAws() + ", azure=" + this.getAzure() + ", gcp=" + this.getGcp() + ", linkToParentDomain=" + this.getLinkToParentDomain() + ", preserveOnDelete=" + this.getPreserveOnDelete() + ", zone=" + this.getZone() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
