
package io.fabric8.openshift.api.model.miscellaneous.clusterapi.v1beta1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
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
 * JSONPatch defines a JSON patch.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "op",
    "path",
    "value",
    "valueFrom"
})
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
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
public class JSONPatch implements Editable<JSONPatchBuilder>, KubernetesResource
{

    @JsonProperty("op")
    private String op;
    @JsonProperty("path")
    private String path;
    @JsonProperty("value")
    private JsonNode value;
    @JsonProperty("valueFrom")
    private JSONPatchValue valueFrom;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JSONPatch() {
    }

    public JSONPatch(String op, String path, JsonNode value, JSONPatchValue valueFrom) {
        super();
        this.op = op;
        this.path = path;
        this.value = value;
        this.valueFrom = valueFrom;
    }

    /**
     * op defines the operation of the patch. Note: Only `add`, `replace` and `remove` are supported.
     */
    @JsonProperty("op")
    public String getOp() {
        return op;
    }

    /**
     * op defines the operation of the patch. Note: Only `add`, `replace` and `remove` are supported.
     */
    @JsonProperty("op")
    public void setOp(String op) {
        this.op = op;
    }

    /**
     * path defines the path of the patch. Note: Only the spec of a template can be patched, thus the path has to start with /spec/. Note: For now the only allowed array modifications are `append` and `prepend`, i.e.: &#42; for op: `add`: only index 0 (prepend) and - (append) are allowed &#42; for op: `replace` or `remove`: no indexes are allowed
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * path defines the path of the patch. Note: Only the spec of a template can be patched, thus the path has to start with /spec/. Note: For now the only allowed array modifications are `append` and `prepend`, i.e.: &#42; for op: `add`: only index 0 (prepend) and - (append) are allowed &#42; for op: `replace` or `remove`: no indexes are allowed
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * JSONPatch defines a JSON patch.
     */
    @JsonProperty("value")
    public JsonNode getValue() {
        return value;
    }

    /**
     * JSONPatch defines a JSON patch.
     */
    @JsonProperty("value")
    public void setValue(JsonNode value) {
        this.value = value;
    }

    /**
     * JSONPatch defines a JSON patch.
     */
    @JsonProperty("valueFrom")
    public JSONPatchValue getValueFrom() {
        return valueFrom;
    }

    /**
     * JSONPatch defines a JSON patch.
     */
    @JsonProperty("valueFrom")
    public void setValueFrom(JSONPatchValue valueFrom) {
        this.valueFrom = valueFrom;
    }

    @JsonIgnore
    public JSONPatchBuilder edit() {
        return new JSONPatchBuilder(this);
    }

    @JsonIgnore
    public JSONPatchBuilder toBuilder() {
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
