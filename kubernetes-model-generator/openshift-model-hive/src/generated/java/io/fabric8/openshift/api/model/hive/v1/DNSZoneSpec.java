
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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

}
