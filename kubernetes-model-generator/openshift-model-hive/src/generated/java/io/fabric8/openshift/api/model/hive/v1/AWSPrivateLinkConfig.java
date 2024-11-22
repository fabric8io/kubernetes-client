
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
    "associatedVPCs",
    "credentialsSecretRef",
    "dnsRecordType",
    "endpointVPCInventory"
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
public class AWSPrivateLinkConfig implements Editable<AWSPrivateLinkConfigBuilder> , KubernetesResource
{

    @JsonProperty("associatedVPCs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AWSAssociatedVPC> associatedVPCs = new ArrayList<>();
    @JsonProperty("credentialsSecretRef")
    private LocalObjectReference credentialsSecretRef;
    @JsonProperty("dnsRecordType")
    private String dnsRecordType;
    @JsonProperty("endpointVPCInventory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<AWSPrivateLinkInventory> endpointVPCInventory = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AWSPrivateLinkConfig() {
    }

    public AWSPrivateLinkConfig(List<AWSAssociatedVPC> associatedVPCs, LocalObjectReference credentialsSecretRef, String dnsRecordType, List<AWSPrivateLinkInventory> endpointVPCInventory) {
        super();
        this.associatedVPCs = associatedVPCs;
        this.credentialsSecretRef = credentialsSecretRef;
        this.dnsRecordType = dnsRecordType;
        this.endpointVPCInventory = endpointVPCInventory;
    }

    @JsonProperty("associatedVPCs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AWSAssociatedVPC> getAssociatedVPCs() {
        return associatedVPCs;
    }

    @JsonProperty("associatedVPCs")
    public void setAssociatedVPCs(List<AWSAssociatedVPC> associatedVPCs) {
        this.associatedVPCs = associatedVPCs;
    }

    @JsonProperty("credentialsSecretRef")
    public LocalObjectReference getCredentialsSecretRef() {
        return credentialsSecretRef;
    }

    @JsonProperty("credentialsSecretRef")
    public void setCredentialsSecretRef(LocalObjectReference credentialsSecretRef) {
        this.credentialsSecretRef = credentialsSecretRef;
    }

    @JsonProperty("dnsRecordType")
    public String getDnsRecordType() {
        return dnsRecordType;
    }

    @JsonProperty("dnsRecordType")
    public void setDnsRecordType(String dnsRecordType) {
        this.dnsRecordType = dnsRecordType;
    }

    @JsonProperty("endpointVPCInventory")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<AWSPrivateLinkInventory> getEndpointVPCInventory() {
        return endpointVPCInventory;
    }

    @JsonProperty("endpointVPCInventory")
    public void setEndpointVPCInventory(List<AWSPrivateLinkInventory> endpointVPCInventory) {
        this.endpointVPCInventory = endpointVPCInventory;
    }

    @JsonIgnore
    public AWSPrivateLinkConfigBuilder edit() {
        return new AWSPrivateLinkConfigBuilder(this);
    }

    @JsonIgnore
    public AWSPrivateLinkConfigBuilder toBuilder() {
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
