
package io.fabric8.openshift.api.model.hive.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "aws",
    "azure",
    "gcp",
    "linkToParentDomain",
    "preserveOnDelete",
    "zone"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class DNSZoneSpec implements KubernetesResource
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
     * 
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

    @JsonProperty("aws")
    public AWSDNSZoneSpec getAws() {
        return aws;
    }

    @JsonProperty("aws")
    public void setAws(AWSDNSZoneSpec aws) {
        this.aws = aws;
    }

    @JsonProperty("azure")
    public AzureDNSZoneSpec getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    public void setAzure(AzureDNSZoneSpec azure) {
        this.azure = azure;
    }

    @JsonProperty("gcp")
    public GCPDNSZoneSpec getGcp() {
        return gcp;
    }

    @JsonProperty("gcp")
    public void setGcp(GCPDNSZoneSpec gcp) {
        this.gcp = gcp;
    }

    @JsonProperty("linkToParentDomain")
    public Boolean getLinkToParentDomain() {
        return linkToParentDomain;
    }

    @JsonProperty("linkToParentDomain")
    public void setLinkToParentDomain(Boolean linkToParentDomain) {
        this.linkToParentDomain = linkToParentDomain;
    }

    @JsonProperty("preserveOnDelete")
    public Boolean getPreserveOnDelete() {
        return preserveOnDelete;
    }

    @JsonProperty("preserveOnDelete")
    public void setPreserveOnDelete(Boolean preserveOnDelete) {
        this.preserveOnDelete = preserveOnDelete;
    }

    @JsonProperty("zone")
    public String getZone() {
        return zone;
    }

    @JsonProperty("zone")
    public void setZone(String zone) {
        this.zone = zone;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
