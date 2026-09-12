
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

/**
 * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "describedObject",
    "metric",
    "target"
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
public class ObjectMetricSource implements Editable<ObjectMetricSourceBuilder>, KubernetesResource
{

    @JsonProperty("describedObject")
    private CrossVersionObjectReference describedObject;
    @JsonProperty("metric")
    private MetricIdentifier metric;
    @JsonProperty("target")
    private MetricTarget target;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ObjectMetricSource() {
    }

    public ObjectMetricSource(CrossVersionObjectReference describedObject, MetricIdentifier metric, MetricTarget target) {
        super();
        this.describedObject = describedObject;
        this.metric = metric;
        this.target = target;
    }

    /**
     * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
     */
    @JsonProperty("describedObject")
    public CrossVersionObjectReference getDescribedObject() {
        return describedObject;
    }

    /**
     * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
     */
    @JsonProperty("describedObject")
    public void setDescribedObject(CrossVersionObjectReference describedObject) {
        this.describedObject = describedObject;
    }

    /**
     * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
     */
    @JsonProperty("metric")
    public MetricIdentifier getMetric() {
        return metric;
    }

    /**
     * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
     */
    @JsonProperty("metric")
    public void setMetric(MetricIdentifier metric) {
        this.metric = metric;
    }

    /**
     * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
     */
    @JsonProperty("target")
    public MetricTarget getTarget() {
        return target;
    }

    /**
     * ObjectMetricSource indicates how to scale on a metric describing a kubernetes object (for example, hits-per-second on an Ingress object).
     */
    @JsonProperty("target")
    public void setTarget(MetricTarget target) {
        this.target = target;
    }

    @JsonIgnore
    public ObjectMetricSourceBuilder edit() {
        return new ObjectMetricSourceBuilder(this);
    }

    @JsonIgnore
    public ObjectMetricSourceBuilder toBuilder() {
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
        if (!(o instanceof ObjectMetricSource)) {
            return false;
        }
        ObjectMetricSource other = (ObjectMetricSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$describedObject = this.getDescribedObject();
        Object other$describedObject = other.getDescribedObject();
        if (this$describedObject == null ? other$describedObject != null : !this$describedObject.equals(other$describedObject)) {
            return false;
        }
        Object this$metric = this.getMetric();
        Object other$metric = other.getMetric();
        if (this$metric == null ? other$metric != null : !this$metric.equals(other$metric)) {
            return false;
        }
        Object this$target = this.getTarget();
        Object other$target = other.getTarget();
        if (this$target == null ? other$target != null : !this$target.equals(other$target)) {
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
        return other instanceof ObjectMetricSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $describedObject = this.getDescribedObject();
        result = result * prime + ($describedObject == null ? 43 : $describedObject.hashCode());
        Object $metric = this.getMetric();
        result = result * prime + ($metric == null ? 43 : $metric.hashCode());
        Object $target = this.getTarget();
        result = result * prime + ($target == null ? 43 : $target.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ObjectMetricSource(" + "describedObject=" + this.getDescribedObject() + ", metric=" + this.getMetric() + ", target=" + this.getTarget() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
