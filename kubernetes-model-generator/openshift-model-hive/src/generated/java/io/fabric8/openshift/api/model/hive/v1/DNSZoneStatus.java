
package io.fabric8.openshift.api.model.hive.v1;

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
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * DNSZoneStatus defines the observed state of DNSZone
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aws",
    "azure",
    "conditions",
    "gcp",
    "lastSyncGeneration",
    "lastSyncTimestamp",
    "nameServers"
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
public class DNSZoneStatus implements Editable<DNSZoneStatusBuilder>, KubernetesResource
{

    @JsonProperty("aws")
    private AWSDNSZoneStatus aws;
    @JsonProperty("azure")
    private AzureDNSZoneStatus azure;
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DNSZoneCondition> conditions = new ArrayList<>();
    @JsonProperty("gcp")
    private GCPDNSZoneStatus gcp;
    @JsonProperty("lastSyncGeneration")
    private Long lastSyncGeneration;
    @JsonProperty("lastSyncTimestamp")
    private String lastSyncTimestamp;
    @JsonProperty("nameServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> nameServers = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DNSZoneStatus() {
    }

    public DNSZoneStatus(AWSDNSZoneStatus aws, AzureDNSZoneStatus azure, List<DNSZoneCondition> conditions, GCPDNSZoneStatus gcp, Long lastSyncGeneration, String lastSyncTimestamp, List<String> nameServers) {
        super();
        this.aws = aws;
        this.azure = azure;
        this.conditions = conditions;
        this.gcp = gcp;
        this.lastSyncGeneration = lastSyncGeneration;
        this.lastSyncTimestamp = lastSyncTimestamp;
        this.nameServers = nameServers;
    }

    /**
     * DNSZoneStatus defines the observed state of DNSZone
     */
    @JsonProperty("aws")
    public AWSDNSZoneStatus getAws() {
        return aws;
    }

    /**
     * DNSZoneStatus defines the observed state of DNSZone
     */
    @JsonProperty("aws")
    public void setAws(AWSDNSZoneStatus aws) {
        this.aws = aws;
    }

    /**
     * DNSZoneStatus defines the observed state of DNSZone
     */
    @JsonProperty("azure")
    public AzureDNSZoneStatus getAzure() {
        return azure;
    }

    /**
     * DNSZoneStatus defines the observed state of DNSZone
     */
    @JsonProperty("azure")
    public void setAzure(AzureDNSZoneStatus azure) {
        this.azure = azure;
    }

    /**
     * Conditions includes more detailed status for the DNSZone
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DNSZoneCondition> getConditions() {
        return conditions;
    }

    /**
     * Conditions includes more detailed status for the DNSZone
     */
    @JsonProperty("conditions")
    public void setConditions(List<DNSZoneCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * DNSZoneStatus defines the observed state of DNSZone
     */
    @JsonProperty("gcp")
    public GCPDNSZoneStatus getGcp() {
        return gcp;
    }

    /**
     * DNSZoneStatus defines the observed state of DNSZone
     */
    @JsonProperty("gcp")
    public void setGcp(GCPDNSZoneStatus gcp) {
        this.gcp = gcp;
    }

    /**
     * LastSyncGeneration is the generation of the zone resource that was last sync'd. This is used to know if the Object has changed and we should sync immediately.
     */
    @JsonProperty("lastSyncGeneration")
    public Long getLastSyncGeneration() {
        return lastSyncGeneration;
    }

    /**
     * LastSyncGeneration is the generation of the zone resource that was last sync'd. This is used to know if the Object has changed and we should sync immediately.
     */
    @JsonProperty("lastSyncGeneration")
    public void setLastSyncGeneration(Long lastSyncGeneration) {
        this.lastSyncGeneration = lastSyncGeneration;
    }

    /**
     * DNSZoneStatus defines the observed state of DNSZone
     */
    @JsonProperty("lastSyncTimestamp")
    public String getLastSyncTimestamp() {
        return lastSyncTimestamp;
    }

    /**
     * DNSZoneStatus defines the observed state of DNSZone
     */
    @JsonProperty("lastSyncTimestamp")
    public void setLastSyncTimestamp(String lastSyncTimestamp) {
        this.lastSyncTimestamp = lastSyncTimestamp;
    }

    /**
     * NameServers is a list of nameservers for this DNS zone
     */
    @JsonProperty("nameServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNameServers() {
        return nameServers;
    }

    /**
     * NameServers is a list of nameservers for this DNS zone
     */
    @JsonProperty("nameServers")
    public void setNameServers(List<String> nameServers) {
        this.nameServers = nameServers;
    }

    @JsonIgnore
    public DNSZoneStatusBuilder edit() {
        return new DNSZoneStatusBuilder(this);
    }

    @JsonIgnore
    public DNSZoneStatusBuilder toBuilder() {
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
        if (!(o instanceof DNSZoneStatus)) {
            return false;
        }
        DNSZoneStatus other = (DNSZoneStatus) o;
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
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$gcp = this.getGcp();
        Object other$gcp = other.getGcp();
        if (this$gcp == null ? other$gcp != null : !this$gcp.equals(other$gcp)) {
            return false;
        }
        Object this$lastSyncGeneration = this.getLastSyncGeneration();
        Object other$lastSyncGeneration = other.getLastSyncGeneration();
        if (this$lastSyncGeneration == null ? other$lastSyncGeneration != null : !this$lastSyncGeneration.equals(other$lastSyncGeneration)) {
            return false;
        }
        Object this$lastSyncTimestamp = this.getLastSyncTimestamp();
        Object other$lastSyncTimestamp = other.getLastSyncTimestamp();
        if (this$lastSyncTimestamp == null ? other$lastSyncTimestamp != null : !this$lastSyncTimestamp.equals(other$lastSyncTimestamp)) {
            return false;
        }
        Object this$nameServers = this.getNameServers();
        Object other$nameServers = other.getNameServers();
        if (this$nameServers == null ? other$nameServers != null : !this$nameServers.equals(other$nameServers)) {
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
        return other instanceof DNSZoneStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $aws = this.getAws();
        result = result * prime + ($aws == null ? 43 : $aws.hashCode());
        Object $azure = this.getAzure();
        result = result * prime + ($azure == null ? 43 : $azure.hashCode());
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $gcp = this.getGcp();
        result = result * prime + ($gcp == null ? 43 : $gcp.hashCode());
        Object $lastSyncGeneration = this.getLastSyncGeneration();
        result = result * prime + ($lastSyncGeneration == null ? 43 : $lastSyncGeneration.hashCode());
        Object $lastSyncTimestamp = this.getLastSyncTimestamp();
        result = result * prime + ($lastSyncTimestamp == null ? 43 : $lastSyncTimestamp.hashCode());
        Object $nameServers = this.getNameServers();
        result = result * prime + ($nameServers == null ? 43 : $nameServers.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DNSZoneStatus(" + "aws=" + this.getAws() + ", azure=" + this.getAzure() + ", conditions=" + this.getConditions() + ", gcp=" + this.getGcp() + ", lastSyncGeneration=" + this.getLastSyncGeneration() + ", lastSyncTimestamp=" + this.getLastSyncTimestamp() + ", nameServers=" + this.getNameServers() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
