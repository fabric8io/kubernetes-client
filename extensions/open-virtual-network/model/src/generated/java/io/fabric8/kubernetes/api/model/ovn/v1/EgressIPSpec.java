
package io.fabric8.kubernetes.api.model.ovn.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * EgressIPSpec is a desired state description of EgressIP.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "egressIPs",
    "namespaceSelector",
    "podSelector"
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
public class EgressIPSpec implements Editable<EgressIPSpecBuilder>, KubernetesResource
{

    @JsonProperty("egressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> egressIPs = new ArrayList<>();
    @JsonProperty("namespaceSelector")
    private LabelSelector namespaceSelector;
    @JsonProperty("podSelector")
    private LabelSelector podSelector;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EgressIPSpec() {
    }

    public EgressIPSpec(List<String> egressIPs, LabelSelector namespaceSelector, LabelSelector podSelector) {
        super();
        this.egressIPs = egressIPs;
        this.namespaceSelector = namespaceSelector;
        this.podSelector = podSelector;
    }

    /**
     * EgressIPs is the list of egress IP addresses requested. Can be IPv4 and/or IPv6. This field is mandatory.
     */
    @JsonProperty("egressIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEgressIPs() {
        return egressIPs;
    }

    /**
     * EgressIPs is the list of egress IP addresses requested. Can be IPv4 and/or IPv6. This field is mandatory.
     */
    @JsonProperty("egressIPs")
    public void setEgressIPs(List<String> egressIPs) {
        this.egressIPs = egressIPs;
    }

    /**
     * EgressIPSpec is a desired state description of EgressIP.
     */
    @JsonProperty("namespaceSelector")
    public LabelSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    /**
     * EgressIPSpec is a desired state description of EgressIP.
     */
    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(LabelSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    /**
     * EgressIPSpec is a desired state description of EgressIP.
     */
    @JsonProperty("podSelector")
    public LabelSelector getPodSelector() {
        return podSelector;
    }

    /**
     * EgressIPSpec is a desired state description of EgressIP.
     */
    @JsonProperty("podSelector")
    public void setPodSelector(LabelSelector podSelector) {
        this.podSelector = podSelector;
    }

    @JsonIgnore
    public EgressIPSpecBuilder edit() {
        return new EgressIPSpecBuilder(this);
    }

    @JsonIgnore
    public EgressIPSpecBuilder toBuilder() {
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
