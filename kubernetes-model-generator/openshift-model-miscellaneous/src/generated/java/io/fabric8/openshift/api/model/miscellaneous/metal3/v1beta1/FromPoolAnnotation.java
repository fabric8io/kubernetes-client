
package io.fabric8.openshift.api.model.miscellaneous.metal3.v1beta1;

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
 * FromPoolAnnotation contains the information to fetch pool reference details from an annotation.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "annotation",
    "object"
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
public class FromPoolAnnotation implements Editable<FromPoolAnnotationBuilder>, KubernetesResource
{

    @JsonProperty("annotation")
    private String annotation;
    @JsonProperty("object")
    private String object;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public FromPoolAnnotation() {
    }

    public FromPoolAnnotation(String annotation, String object) {
        super();
        this.annotation = annotation;
        this.object = object;
    }

    /**
     * Annotation is the key of the annotation that contains the pool name. The annotation value should be a string containing the pool name.
     */
    @JsonProperty("annotation")
    public String getAnnotation() {
        return annotation;
    }

    /**
     * Annotation is the key of the annotation that contains the pool name. The annotation value should be a string containing the pool name.
     */
    @JsonProperty("annotation")
    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    /**
     * Object is the type of the object from which we retrieve the annotation
     */
    @JsonProperty("object")
    public String getObject() {
        return object;
    }

    /**
     * Object is the type of the object from which we retrieve the annotation
     */
    @JsonProperty("object")
    public void setObject(String object) {
        this.object = object;
    }

    @JsonIgnore
    public FromPoolAnnotationBuilder edit() {
        return new FromPoolAnnotationBuilder(this);
    }

    @JsonIgnore
    public FromPoolAnnotationBuilder toBuilder() {
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
        if (!(o instanceof FromPoolAnnotation)) {
            return false;
        }
        FromPoolAnnotation other = (FromPoolAnnotation) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$annotation = this.getAnnotation();
        Object other$annotation = other.getAnnotation();
        if (this$annotation == null ? other$annotation != null : !this$annotation.equals(other$annotation)) {
            return false;
        }
        Object this$object = this.getObject();
        Object other$object = other.getObject();
        if (this$object == null ? other$object != null : !this$object.equals(other$object)) {
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
        return other instanceof FromPoolAnnotation;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $annotation = this.getAnnotation();
        result = result * prime + ($annotation == null ? 43 : $annotation.hashCode());
        Object $object = this.getObject();
        result = result * prime + ($object == null ? 43 : $object.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FromPoolAnnotation(" + "annotation=" + this.getAnnotation() + ", object=" + this.getObject() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
