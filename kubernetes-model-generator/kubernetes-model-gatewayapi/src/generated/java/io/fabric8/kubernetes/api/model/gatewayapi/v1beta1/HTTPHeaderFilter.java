
package io.fabric8.kubernetes.api.model.gatewayapi.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "add",
    "remove",
    "set"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class HTTPHeaderFilter implements KubernetesResource
{

    @JsonProperty("add")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPHeader> add = new ArrayList<HTTPHeader>();
    @JsonProperty("remove")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> remove = new ArrayList<String>();
    @JsonProperty("set")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<HTTPHeader> set = new ArrayList<HTTPHeader>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HTTPHeaderFilter() {
    }

    public HTTPHeaderFilter(List<HTTPHeader> add, List<String> remove, List<HTTPHeader> set) {
        super();
        this.add = add;
        this.remove = remove;
        this.set = set;
    }

    @JsonProperty("add")
    public List<HTTPHeader> getAdd() {
        return add;
    }

    @JsonProperty("add")
    public void setAdd(List<HTTPHeader> add) {
        this.add = add;
    }

    @JsonProperty("remove")
    public List<String> getRemove() {
        return remove;
    }

    @JsonProperty("remove")
    public void setRemove(List<String> remove) {
        this.remove = remove;
    }

    @JsonProperty("set")
    public List<HTTPHeader> getSet() {
        return set;
    }

    @JsonProperty("set")
    public void setSet(List<HTTPHeader> set) {
        this.set = set;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
