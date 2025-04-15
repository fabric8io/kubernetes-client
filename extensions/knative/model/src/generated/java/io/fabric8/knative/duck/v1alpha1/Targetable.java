
package io.fabric8.knative.duck.v1alpha1;

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
 * Targetable is an earlier version of the Callable interface. Callable is a higher-level interface which implements Addressable but further promises that the destination may synchronously return response messages in reply to a message.<br><p> <br><p> Targetable implementations should instead implement Addressable and include an `eventing.knative.dev/returns=any` annotation.<br><p> <br><p> Targetable is retired; implement Addressable for now.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "domainInternal"
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
public class Targetable implements Editable<TargetableBuilder>, KubernetesResource
{

    @JsonProperty("domainInternal")
    private String domainInternal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Targetable() {
    }

    public Targetable(String domainInternal) {
        super();
        this.domainInternal = domainInternal;
    }

    /**
     * Targetable is an earlier version of the Callable interface. Callable is a higher-level interface which implements Addressable but further promises that the destination may synchronously return response messages in reply to a message.<br><p> <br><p> Targetable implementations should instead implement Addressable and include an `eventing.knative.dev/returns=any` annotation.<br><p> <br><p> Targetable is retired; implement Addressable for now.
     */
    @JsonProperty("domainInternal")
    public String getDomainInternal() {
        return domainInternal;
    }

    /**
     * Targetable is an earlier version of the Callable interface. Callable is a higher-level interface which implements Addressable but further promises that the destination may synchronously return response messages in reply to a message.<br><p> <br><p> Targetable implementations should instead implement Addressable and include an `eventing.knative.dev/returns=any` annotation.<br><p> <br><p> Targetable is retired; implement Addressable for now.
     */
    @JsonProperty("domainInternal")
    public void setDomainInternal(String domainInternal) {
        this.domainInternal = domainInternal;
    }

    @JsonIgnore
    public TargetableBuilder edit() {
        return new TargetableBuilder(this);
    }

    @JsonIgnore
    public TargetableBuilder toBuilder() {
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
