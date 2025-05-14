
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
 * GatewayInfrastructure defines infrastructure level attributes about a Gateway instance.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotations",
    "labels",
    "parametersRef"
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
public class GatewayInfrastructure implements Editable<GatewayInfrastructureBuilder>, KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("parametersRef")
    private LocalParametersReference parametersRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GatewayInfrastructure() {
    }

    public GatewayInfrastructure(Map<String, String> annotations, Map<String, String> labels, LocalParametersReference parametersRef) {
        super();
        this.annotations = annotations;
        this.labels = labels;
        this.parametersRef = parametersRef;
    }

    /**
     * Annotations that SHOULD be applied to any resources created in response to this Gateway.<br><p> <br><p> For implementations creating other Kubernetes objects, this should be the `metadata.annotations` field on resources. For other implementations, this refers to any relevant (implementation specific) "annotations" concepts.<br><p> <br><p> An implementation may chose to add additional implementation-specific annotations as they see fit.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    /**
     * Annotations that SHOULD be applied to any resources created in response to this Gateway.<br><p> <br><p> For implementations creating other Kubernetes objects, this should be the `metadata.annotations` field on resources. For other implementations, this refers to any relevant (implementation specific) "annotations" concepts.<br><p> <br><p> An implementation may chose to add additional implementation-specific annotations as they see fit.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    /**
     * Labels that SHOULD be applied to any resources created in response to this Gateway.<br><p> <br><p> For implementations creating other Kubernetes objects, this should be the `metadata.labels` field on resources. For other implementations, this refers to any relevant (implementation specific) "labels" concepts.<br><p> <br><p> An implementation may chose to add additional implementation-specific labels as they see fit.<br><p> <br><p> If an implementation maps these labels to Pods, or any other resource that would need to be recreated when labels change, it SHOULD clearly warn about this behavior in documentation.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    /**
     * Labels that SHOULD be applied to any resources created in response to this Gateway.<br><p> <br><p> For implementations creating other Kubernetes objects, this should be the `metadata.labels` field on resources. For other implementations, this refers to any relevant (implementation specific) "labels" concepts.<br><p> <br><p> An implementation may chose to add additional implementation-specific labels as they see fit.<br><p> <br><p> If an implementation maps these labels to Pods, or any other resource that would need to be recreated when labels change, it SHOULD clearly warn about this behavior in documentation.<br><p> <br><p> Support: Extended
     */
    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    /**
     * GatewayInfrastructure defines infrastructure level attributes about a Gateway instance.
     */
    @JsonProperty("parametersRef")
    public LocalParametersReference getParametersRef() {
        return parametersRef;
    }

    /**
     * GatewayInfrastructure defines infrastructure level attributes about a Gateway instance.
     */
    @JsonProperty("parametersRef")
    public void setParametersRef(LocalParametersReference parametersRef) {
        this.parametersRef = parametersRef;
    }

    @JsonIgnore
    public GatewayInfrastructureBuilder edit() {
        return new GatewayInfrastructureBuilder(this);
    }

    @JsonIgnore
    public GatewayInfrastructureBuilder toBuilder() {
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
