
package io.fabric8.kubernetes.api.model.autoscaling.v2;

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
 * MetricSpec specifies how to scale based on a single metric (only `type` and one other matching field should be set at once).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerResource",
    "external",
    "object",
    "pods",
    "resource",
    "type"
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
public class MetricSpec implements Editable<MetricSpecBuilder>, KubernetesResource
{

    @JsonProperty("containerResource")
    private ContainerResourceMetricSource containerResource;
    @JsonProperty("external")
    private ExternalMetricSource external;
    @JsonProperty("object")
    private ObjectMetricSource object;
    @JsonProperty("pods")
    private PodsMetricSource pods;
    @JsonProperty("resource")
    private ResourceMetricSource resource;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public MetricSpec() {
    }

    public MetricSpec(ContainerResourceMetricSource containerResource, ExternalMetricSource external, ObjectMetricSource object, PodsMetricSource pods, ResourceMetricSource resource, String type) {
        super();
        this.containerResource = containerResource;
        this.external = external;
        this.object = object;
        this.pods = pods;
        this.resource = resource;
        this.type = type;
    }

    /**
     * MetricSpec specifies how to scale based on a single metric (only `type` and one other matching field should be set at once).
     */
    @JsonProperty("containerResource")
    public ContainerResourceMetricSource getContainerResource() {
        return containerResource;
    }

    /**
     * MetricSpec specifies how to scale based on a single metric (only `type` and one other matching field should be set at once).
     */
    @JsonProperty("containerResource")
    public void setContainerResource(ContainerResourceMetricSource containerResource) {
        this.containerResource = containerResource;
    }

    /**
     * MetricSpec specifies how to scale based on a single metric (only `type` and one other matching field should be set at once).
     */
    @JsonProperty("external")
    public ExternalMetricSource getExternal() {
        return external;
    }

    /**
     * MetricSpec specifies how to scale based on a single metric (only `type` and one other matching field should be set at once).
     */
    @JsonProperty("external")
    public void setExternal(ExternalMetricSource external) {
        this.external = external;
    }

    /**
     * MetricSpec specifies how to scale based on a single metric (only `type` and one other matching field should be set at once).
     */
    @JsonProperty("object")
    public ObjectMetricSource getObject() {
        return object;
    }

    /**
     * MetricSpec specifies how to scale based on a single metric (only `type` and one other matching field should be set at once).
     */
    @JsonProperty("object")
    public void setObject(ObjectMetricSource object) {
        this.object = object;
    }

    /**
     * MetricSpec specifies how to scale based on a single metric (only `type` and one other matching field should be set at once).
     */
    @JsonProperty("pods")
    public PodsMetricSource getPods() {
        return pods;
    }

    /**
     * MetricSpec specifies how to scale based on a single metric (only `type` and one other matching field should be set at once).
     */
    @JsonProperty("pods")
    public void setPods(PodsMetricSource pods) {
        this.pods = pods;
    }

    /**
     * MetricSpec specifies how to scale based on a single metric (only `type` and one other matching field should be set at once).
     */
    @JsonProperty("resource")
    public ResourceMetricSource getResource() {
        return resource;
    }

    /**
     * MetricSpec specifies how to scale based on a single metric (only `type` and one other matching field should be set at once).
     */
    @JsonProperty("resource")
    public void setResource(ResourceMetricSource resource) {
        this.resource = resource;
    }

    /**
     * type is the type of metric source.  It should be one of "ContainerResource", "External", "Object", "Pods" or "Resource", each mapping to a matching field in the object.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the type of metric source.  It should be one of "ContainerResource", "External", "Object", "Pods" or "Resource", each mapping to a matching field in the object.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public MetricSpecBuilder edit() {
        return new MetricSpecBuilder(this);
    }

    @JsonIgnore
    public MetricSpecBuilder toBuilder() {
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
