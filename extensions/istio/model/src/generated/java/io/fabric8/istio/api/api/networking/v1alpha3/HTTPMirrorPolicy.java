
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.LinkedHashMap;
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
 * HTTPMirrorPolicy can be used to specify the destinations to mirror HTTP traffic in addition to the original destination. Mirrored traffic is on a best effort basis where the sidecar/gateway will not wait for the mirrored destinations to respond before returning the response from the original destination. Statistics will be generated for the mirrored destination.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "destination",
    "percentage"
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
public class HTTPMirrorPolicy implements Editable<HTTPMirrorPolicyBuilder>, KubernetesResource
{

    @JsonProperty("destination")
    private Destination destination;
    @JsonProperty("percentage")
    private Percent percentage;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPMirrorPolicy() {
    }

    public HTTPMirrorPolicy(Destination destination, Percent percentage) {
        super();
        this.destination = destination;
        this.percentage = percentage;
    }

    /**
     * HTTPMirrorPolicy can be used to specify the destinations to mirror HTTP traffic in addition to the original destination. Mirrored traffic is on a best effort basis where the sidecar/gateway will not wait for the mirrored destinations to respond before returning the response from the original destination. Statistics will be generated for the mirrored destination.
     */
    @JsonProperty("destination")
    public Destination getDestination() {
        return destination;
    }

    /**
     * HTTPMirrorPolicy can be used to specify the destinations to mirror HTTP traffic in addition to the original destination. Mirrored traffic is on a best effort basis where the sidecar/gateway will not wait for the mirrored destinations to respond before returning the response from the original destination. Statistics will be generated for the mirrored destination.
     */
    @JsonProperty("destination")
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    /**
     * HTTPMirrorPolicy can be used to specify the destinations to mirror HTTP traffic in addition to the original destination. Mirrored traffic is on a best effort basis where the sidecar/gateway will not wait for the mirrored destinations to respond before returning the response from the original destination. Statistics will be generated for the mirrored destination.
     */
    @JsonProperty("percentage")
    public Percent getPercentage() {
        return percentage;
    }

    /**
     * HTTPMirrorPolicy can be used to specify the destinations to mirror HTTP traffic in addition to the original destination. Mirrored traffic is on a best effort basis where the sidecar/gateway will not wait for the mirrored destinations to respond before returning the response from the original destination. Statistics will be generated for the mirrored destination.
     */
    @JsonProperty("percentage")
    public void setPercentage(Percent percentage) {
        this.percentage = percentage;
    }

    @JsonIgnore
    public HTTPMirrorPolicyBuilder edit() {
        return new HTTPMirrorPolicyBuilder(this);
    }

    @JsonIgnore
    public HTTPMirrorPolicyBuilder toBuilder() {
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
