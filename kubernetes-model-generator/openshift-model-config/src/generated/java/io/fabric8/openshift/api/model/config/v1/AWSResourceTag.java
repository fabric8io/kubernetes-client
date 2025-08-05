
package io.fabric8.openshift.api.model.config.v1;

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
 * AWSResourceTag is a tag to apply to AWS resources created for the cluster.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "value"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AWSResourceTag implements Editable<AWSResourceTagBuilder>, KubernetesResource
{

    @JsonProperty("key")
    private String key;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AWSResourceTag() {
    }

    public AWSResourceTag(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    /**
     * key sets the key of the AWS resource tag key-value pair. Key is required when defining an AWS resource tag. Key should consist of between 1 and 128 characters, and may contain only the set of alphanumeric characters, space (' '), '_', '.', '/', '=', '+', '-', ':', and '@'.
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * key sets the key of the AWS resource tag key-value pair. Key is required when defining an AWS resource tag. Key should consist of between 1 and 128 characters, and may contain only the set of alphanumeric characters, space (' '), '_', '.', '/', '=', '+', '-', ':', and '@'.
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * value sets the value of the AWS resource tag key-value pair. Value is required when defining an AWS resource tag. Value should consist of between 1 and 256 characters, and may contain only the set of alphanumeric characters, space (' '), '_', '.', '/', '=', '+', '-', ':', and '@'. Some AWS service do not support empty values. Since tags are added to resources in many services, the length of the tag value must meet the requirements of all services.
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * value sets the value of the AWS resource tag key-value pair. Value is required when defining an AWS resource tag. Value should consist of between 1 and 256 characters, and may contain only the set of alphanumeric characters, space (' '), '_', '.', '/', '=', '+', '-', ':', and '@'. Some AWS service do not support empty values. Since tags are added to resources in many services, the length of the tag value must meet the requirements of all services.
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public AWSResourceTagBuilder edit() {
        return new AWSResourceTagBuilder(this);
    }

    @JsonIgnore
    public AWSResourceTagBuilder toBuilder() {
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
