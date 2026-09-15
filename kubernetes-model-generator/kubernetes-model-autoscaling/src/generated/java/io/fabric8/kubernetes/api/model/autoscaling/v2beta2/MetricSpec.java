
package io.fabric8.kubernetes.api.model.autoscaling.v2beta2;

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
     * type is the type of metric source.  It should be one of "ContainerResource", "External", "Object", "Pods" or "Resource", each mapping to a matching field in the object. Note: "ContainerResource" type is available on when the feature-gate HPAContainerMetrics is enabled
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the type of metric source.  It should be one of "ContainerResource", "External", "Object", "Pods" or "Resource", each mapping to a matching field in the object. Note: "ContainerResource" type is available on when the feature-gate HPAContainerMetrics is enabled
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
        if (!(o instanceof MetricSpec)) {
            return false;
        }
        MetricSpec other = (MetricSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containerResource = this.getContainerResource();
        Object other$containerResource = other.getContainerResource();
        if (this$containerResource == null ? other$containerResource != null : !this$containerResource.equals(other$containerResource)) {
            return false;
        }
        Object this$external = this.getExternal();
        Object other$external = other.getExternal();
        if (this$external == null ? other$external != null : !this$external.equals(other$external)) {
            return false;
        }
        Object this$object = this.getObject();
        Object other$object = other.getObject();
        if (this$object == null ? other$object != null : !this$object.equals(other$object)) {
            return false;
        }
        Object this$pods = this.getPods();
        Object other$pods = other.getPods();
        if (this$pods == null ? other$pods != null : !this$pods.equals(other$pods)) {
            return false;
        }
        Object this$resource = this.getResource();
        Object other$resource = other.getResource();
        if (this$resource == null ? other$resource != null : !this$resource.equals(other$resource)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof MetricSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containerResource = this.getContainerResource();
        result = result * prime + ($containerResource == null ? 43 : $containerResource.hashCode());
        Object $external = this.getExternal();
        result = result * prime + ($external == null ? 43 : $external.hashCode());
        Object $object = this.getObject();
        result = result * prime + ($object == null ? 43 : $object.hashCode());
        Object $pods = this.getPods();
        result = result * prime + ($pods == null ? 43 : $pods.hashCode());
        Object $resource = this.getResource();
        result = result * prime + ($resource == null ? 43 : $resource.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "MetricSpec(" + "containerResource=" + this.getContainerResource() + ", external=" + this.getExternal() + ", object=" + this.getObject() + ", pods=" + this.getPods() + ", resource=" + this.getResource() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
