
package io.fabric8.openshift.api.model.operator.v1;

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
    "dnsManagementPolicy",
    "dnsName",
    "recordTTL",
    "recordType",
    "targets"
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
public class DNSRecordSpec implements KubernetesResource
{

    @JsonProperty("dnsManagementPolicy")
    private String dnsManagementPolicy;
    @JsonProperty("dnsName")
    private String dnsName;
    @JsonProperty("recordTTL")
    private Long recordTTL;
    @JsonProperty("recordType")
    private String recordType;
    @JsonProperty("targets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> targets = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public DNSRecordSpec() {
    }

    public DNSRecordSpec(String dnsManagementPolicy, String dnsName, Long recordTTL, String recordType, List<String> targets) {
        super();
        this.dnsManagementPolicy = dnsManagementPolicy;
        this.dnsName = dnsName;
        this.recordTTL = recordTTL;
        this.recordType = recordType;
        this.targets = targets;
    }

    @JsonProperty("dnsManagementPolicy")
    public String getDnsManagementPolicy() {
        return dnsManagementPolicy;
    }

    @JsonProperty("dnsManagementPolicy")
    public void setDnsManagementPolicy(String dnsManagementPolicy) {
        this.dnsManagementPolicy = dnsManagementPolicy;
    }

    @JsonProperty("dnsName")
    public String getDnsName() {
        return dnsName;
    }

    @JsonProperty("dnsName")
    public void setDnsName(String dnsName) {
        this.dnsName = dnsName;
    }

    @JsonProperty("recordTTL")
    public Long getRecordTTL() {
        return recordTTL;
    }

    @JsonProperty("recordTTL")
    public void setRecordTTL(Long recordTTL) {
        this.recordTTL = recordTTL;
    }

    @JsonProperty("recordType")
    public String getRecordType() {
        return recordType;
    }

    @JsonProperty("recordType")
    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    @JsonProperty("targets")
    public List<String> getTargets() {
        return targets;
    }

    @JsonProperty("targets")
    public void setTargets(List<String> targets) {
        this.targets = targets;
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
