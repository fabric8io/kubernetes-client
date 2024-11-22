
package io.fabric8.openshift.api.model.hive.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
public class DNSZoneStatus implements Editable<DNSZoneStatusBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("aws")
    public AWSDNSZoneStatus getAws() {
        return aws;
    }

    @JsonProperty("aws")
    public void setAws(AWSDNSZoneStatus aws) {
        this.aws = aws;
    }

    @JsonProperty("azure")
    public AzureDNSZoneStatus getAzure() {
        return azure;
    }

    @JsonProperty("azure")
    public void setAzure(AzureDNSZoneStatus azure) {
        this.azure = azure;
    }

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DNSZoneCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<DNSZoneCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("gcp")
    public GCPDNSZoneStatus getGcp() {
        return gcp;
    }

    @JsonProperty("gcp")
    public void setGcp(GCPDNSZoneStatus gcp) {
        this.gcp = gcp;
    }

    @JsonProperty("lastSyncGeneration")
    public Long getLastSyncGeneration() {
        return lastSyncGeneration;
    }

    @JsonProperty("lastSyncGeneration")
    public void setLastSyncGeneration(Long lastSyncGeneration) {
        this.lastSyncGeneration = lastSyncGeneration;
    }

    @JsonProperty("lastSyncTimestamp")
    public String getLastSyncTimestamp() {
        return lastSyncTimestamp;
    }

    @JsonProperty("lastSyncTimestamp")
    public void setLastSyncTimestamp(String lastSyncTimestamp) {
        this.lastSyncTimestamp = lastSyncTimestamp;
    }

    @JsonProperty("nameServers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getNameServers() {
        return nameServers;
    }

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
