
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

/**
 * DNSZoneStatus is the status of a record within a specific zone.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "dnsZone"
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
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$dnsZone = this.getDnsZone();
        Object other$dnsZone = other.getDnsZone();
        if (this$dnsZone == null ? other$dnsZone != null : !this$dnsZone.equals(other$dnsZone)) {
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
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $dnsZone = this.getDnsZone();
        result = result * prime + ($dnsZone == null ? 43 : $dnsZone.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DNSZoneStatus(" + "conditions=" + this.getConditions() + ", dnsZone=" + this.getDnsZone() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
