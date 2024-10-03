
package io.fabric8.openshift.api.model.installer.ibmcloud.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "private",
    "public"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class EndpointsVisibility implements Editable<EndpointsVisibilityBuilder> , KubernetesResource
{

    @JsonProperty("private")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> _private = new LinkedHashMap<>();
    @JsonProperty("public")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> _public = new LinkedHashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EndpointsVisibility() {
    }

    public EndpointsVisibility(Map<String, String> _private, Map<String, String> _public) {
        super();
        this._private = _private;
        this._public = _public;
    }

    @JsonProperty("private")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getPrivate() {
        return _private;
    }

    @JsonProperty("private")
    public void setPrivate(Map<String, String> _private) {
        this._private = _private;
    }

    @JsonProperty("public")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getPublic() {
        return _public;
    }

    @JsonProperty("public")
    public void setPublic(Map<String, String> _public) {
        this._public = _public;
    }

    @JsonIgnore
    public EndpointsVisibilityBuilder edit() {
        return new EndpointsVisibilityBuilder(this);
    }

    @JsonIgnore
    public EndpointsVisibilityBuilder toBuilder() {
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
