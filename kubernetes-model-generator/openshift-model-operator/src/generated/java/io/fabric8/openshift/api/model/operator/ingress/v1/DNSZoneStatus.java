
package io.fabric8.openshift.api.model.operator.ingress.v1;

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
import io.fabric8.openshift.api.model.config.v1.DNSZone;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * DNSZoneStatus is the status of a record within a specific zone.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "dnsZone"
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
public class DNSZoneStatus implements Editable<DNSZoneStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<DNSZoneCondition> conditions = new ArrayList<>();
    @JsonProperty("dnsZone")
    private DNSZone dnsZone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DNSZoneStatus() {
    }

    public DNSZoneStatus(List<DNSZoneCondition> conditions, DNSZone dnsZone) {
        super();
        this.conditions = conditions;
        this.dnsZone = dnsZone;
    }

    /**
     * conditions are any conditions associated with the record in the zone.<br><p> <br><p> If publishing the record succeeds, the "Published" condition will be set with status "True" and upon failure it will be set to "False" along with the reason and message describing the cause of the failure.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<DNSZoneCondition> getConditions() {
        return conditions;
    }

    /**
     * conditions are any conditions associated with the record in the zone.<br><p> <br><p> If publishing the record succeeds, the "Published" condition will be set with status "True" and upon failure it will be set to "False" along with the reason and message describing the cause of the failure.
     */
    @JsonProperty("conditions")
    public void setConditions(List<DNSZoneCondition> conditions) {
        this.conditions = conditions;
    }

    /**
     * DNSZoneStatus is the status of a record within a specific zone.
     */
    @JsonProperty("dnsZone")
    public DNSZone getDnsZone() {
        return dnsZone;
    }

    /**
     * DNSZoneStatus is the status of a record within a specific zone.
     */
    @JsonProperty("dnsZone")
    public void setDnsZone(DNSZone dnsZone) {
        this.dnsZone = dnsZone;
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

}
