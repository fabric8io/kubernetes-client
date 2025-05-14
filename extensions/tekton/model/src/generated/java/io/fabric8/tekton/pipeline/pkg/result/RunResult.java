
package io.fabric8.tekton.pipeline.pkg.result;

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
 * RunResult is used to write key/value pairs to TaskRun pod termination messages. The key/value pairs may come from the entrypoint binary, or represent a TaskRunResult. If they represent a TaskRunResult, the key is the name of the result and the value is the JSON-serialized value of the result.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "key",
    "resourceName",
    "type",
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class RunResult implements Editable<RunResultBuilder>, KubernetesResource
{

    @JsonProperty("key")
    private String key;
    @JsonProperty("resourceName")
    private String resourceName;
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("value")
    private String value;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RunResult() {
    }

    public RunResult(String key, String resourceName, Integer type, String value) {
        super();
        this.key = key;
        this.resourceName = resourceName;
        this.type = type;
        this.value = value;
    }

    /**
     * RunResult is used to write key/value pairs to TaskRun pod termination messages. The key/value pairs may come from the entrypoint binary, or represent a TaskRunResult. If they represent a TaskRunResult, the key is the name of the result and the value is the JSON-serialized value of the result.
     */
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    /**
     * RunResult is used to write key/value pairs to TaskRun pod termination messages. The key/value pairs may come from the entrypoint binary, or represent a TaskRunResult. If they represent a TaskRunResult, the key is the name of the result and the value is the JSON-serialized value of the result.
     */
    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * ResourceName may be used in tests, but it is not populated in termination messages. It is preserved here for backwards compatibility and will not be ported to v1.
     */
    @JsonProperty("resourceName")
    public String getResourceName() {
        return resourceName;
    }

    /**
     * ResourceName may be used in tests, but it is not populated in termination messages. It is preserved here for backwards compatibility and will not be ported to v1.
     */
    @JsonProperty("resourceName")
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    /**
     * RunResult is used to write key/value pairs to TaskRun pod termination messages. The key/value pairs may come from the entrypoint binary, or represent a TaskRunResult. If they represent a TaskRunResult, the key is the name of the result and the value is the JSON-serialized value of the result.
     */
    @JsonProperty("type")
    public Integer getType() {
        return type;
    }

    /**
     * RunResult is used to write key/value pairs to TaskRun pod termination messages. The key/value pairs may come from the entrypoint binary, or represent a TaskRunResult. If they represent a TaskRunResult, the key is the name of the result and the value is the JSON-serialized value of the result.
     */
    @JsonProperty("type")
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * RunResult is used to write key/value pairs to TaskRun pod termination messages. The key/value pairs may come from the entrypoint binary, or represent a TaskRunResult. If they represent a TaskRunResult, the key is the name of the result and the value is the JSON-serialized value of the result.
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * RunResult is used to write key/value pairs to TaskRun pod termination messages. The key/value pairs may come from the entrypoint binary, or represent a TaskRunResult. If they represent a TaskRunResult, the key is the name of the result and the value is the JSON-serialized value of the result.
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonIgnore
    public RunResultBuilder edit() {
        return new RunResultBuilder(this);
    }

    @JsonIgnore
    public RunResultBuilder toBuilder() {
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
