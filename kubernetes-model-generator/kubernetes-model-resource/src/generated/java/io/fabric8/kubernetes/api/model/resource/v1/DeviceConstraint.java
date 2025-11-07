
package io.fabric8.kubernetes.api.model.resource.v1;

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
 * DeviceConstraint must have exactly one field set besides Requests.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "distinctAttribute",
    "matchAttribute",
    "requests"
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
public class DeviceConstraint implements Editable<DeviceConstraintBuilder>, KubernetesResource
{

    @JsonProperty("distinctAttribute")
    private String distinctAttribute;
    @JsonProperty("matchAttribute")
    private String matchAttribute;
    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> requests = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DeviceConstraint() {
    }

    public DeviceConstraint(String distinctAttribute, String matchAttribute, List<String> requests) {
        super();
        this.distinctAttribute = distinctAttribute;
        this.matchAttribute = matchAttribute;
        this.requests = requests;
    }

    /**
     * DistinctAttribute requires that all devices in question have this attribute and that its type and value are unique across those devices.<br><p> <br><p> This acts as the inverse of MatchAttribute.<br><p> <br><p> This constraint is used to avoid allocating multiple requests to the same device by ensuring attribute-level differentiation.<br><p> <br><p> This is useful for scenarios where resource requests must be fulfilled by separate physical devices. For example, a container requests two network interfaces that must be allocated from two different physical NICs.
     */
    @JsonProperty("distinctAttribute")
    public String getDistinctAttribute() {
        return distinctAttribute;
    }

    /**
     * DistinctAttribute requires that all devices in question have this attribute and that its type and value are unique across those devices.<br><p> <br><p> This acts as the inverse of MatchAttribute.<br><p> <br><p> This constraint is used to avoid allocating multiple requests to the same device by ensuring attribute-level differentiation.<br><p> <br><p> This is useful for scenarios where resource requests must be fulfilled by separate physical devices. For example, a container requests two network interfaces that must be allocated from two different physical NICs.
     */
    @JsonProperty("distinctAttribute")
    public void setDistinctAttribute(String distinctAttribute) {
        this.distinctAttribute = distinctAttribute;
    }

    /**
     * MatchAttribute requires that all devices in question have this attribute and that its type and value are the same across those devices.<br><p> <br><p> For example, if you specified "dra.example.com/numa" (a hypothetical example!), then only devices in the same NUMA node will be chosen. A device which does not have that attribute will not be chosen. All devices should use a value of the same type for this attribute because that is part of its specification, but if one device doesn't, then it also will not be chosen.<br><p> <br><p> Must include the domain qualifier.
     */
    @JsonProperty("matchAttribute")
    public String getMatchAttribute() {
        return matchAttribute;
    }

    /**
     * MatchAttribute requires that all devices in question have this attribute and that its type and value are the same across those devices.<br><p> <br><p> For example, if you specified "dra.example.com/numa" (a hypothetical example!), then only devices in the same NUMA node will be chosen. A device which does not have that attribute will not be chosen. All devices should use a value of the same type for this attribute because that is part of its specification, but if one device doesn't, then it also will not be chosen.<br><p> <br><p> Must include the domain qualifier.
     */
    @JsonProperty("matchAttribute")
    public void setMatchAttribute(String matchAttribute) {
        this.matchAttribute = matchAttribute;
    }

    /**
     * Requests is a list of the one or more requests in this claim which must co-satisfy this constraint. If a request is fulfilled by multiple devices, then all of the devices must satisfy the constraint. If this is not specified, this constraint applies to all requests in this claim.<br><p> <br><p> References to subrequests must include the name of the main request and may include the subrequest using the format &lt;main request&gt;[/&lt;subrequest&gt;]. If just the main request is given, the constraint applies to all subrequests.
     */
    @JsonProperty("requests")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getRequests() {
        return requests;
    }

    /**
     * Requests is a list of the one or more requests in this claim which must co-satisfy this constraint. If a request is fulfilled by multiple devices, then all of the devices must satisfy the constraint. If this is not specified, this constraint applies to all requests in this claim.<br><p> <br><p> References to subrequests must include the name of the main request and may include the subrequest using the format &lt;main request&gt;[/&lt;subrequest&gt;]. If just the main request is given, the constraint applies to all subrequests.
     */
    @JsonProperty("requests")
    public void setRequests(List<String> requests) {
        this.requests = requests;
    }

    @JsonIgnore
    public DeviceConstraintBuilder edit() {
        return new DeviceConstraintBuilder(this);
    }

    @JsonIgnore
    public DeviceConstraintBuilder toBuilder() {
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
