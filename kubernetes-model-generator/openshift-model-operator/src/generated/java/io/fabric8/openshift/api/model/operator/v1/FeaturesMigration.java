
package io.fabric8.openshift.api.model.operator.v1;

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
    "egressFirewall",
    "egressIP",
    "multicast"
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
public class FeaturesMigration implements Editable<FeaturesMigrationBuilder>, KubernetesResource
{

    @JsonProperty("egressFirewall")
    private Boolean egressFirewall;
    @JsonProperty("egressIP")
    private Boolean egressIP;
    @JsonProperty("multicast")
    private Boolean multicast;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FeaturesMigration() {
    }

    public FeaturesMigration(Boolean egressFirewall, Boolean egressIP, Boolean multicast) {
        super();
        this.egressFirewall = egressFirewall;
        this.egressIP = egressIP;
        this.multicast = multicast;
    }

    /**
     * egressFirewall specified whether or not the Egress Firewall configuration was migrated. DEPRECATED: network type migration is no longer supported.
     */
    @JsonProperty("egressFirewall")
    public Boolean getEgressFirewall() {
        return egressFirewall;
    }

    /**
     * egressFirewall specified whether or not the Egress Firewall configuration was migrated. DEPRECATED: network type migration is no longer supported.
     */
    @JsonProperty("egressFirewall")
    public void setEgressFirewall(Boolean egressFirewall) {
        this.egressFirewall = egressFirewall;
    }

    /**
     * egressIP specified whether or not the Egress IP configuration was migrated. DEPRECATED: network type migration is no longer supported.
     */
    @JsonProperty("egressIP")
    public Boolean getEgressIP() {
        return egressIP;
    }

    /**
     * egressIP specified whether or not the Egress IP configuration was migrated. DEPRECATED: network type migration is no longer supported.
     */
    @JsonProperty("egressIP")
    public void setEgressIP(Boolean egressIP) {
        this.egressIP = egressIP;
    }

    /**
     * multicast specified whether or not the multicast configuration was migrated. DEPRECATED: network type migration is no longer supported.
     */
    @JsonProperty("multicast")
    public Boolean getMulticast() {
        return multicast;
    }

    /**
     * multicast specified whether or not the multicast configuration was migrated. DEPRECATED: network type migration is no longer supported.
     */
    @JsonProperty("multicast")
    public void setMulticast(Boolean multicast) {
        this.multicast = multicast;
    }

    @JsonIgnore
    public FeaturesMigrationBuilder edit() {
        return new FeaturesMigrationBuilder(this);
    }

    @JsonIgnore
    public FeaturesMigrationBuilder toBuilder() {
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
