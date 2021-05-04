
package io.fabric8.kubernetes.api.model.apiextensions.v1beta1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "acceptedNames",
    "conditions",
    "storedVersions"
})
@ToString
@EqualsAndHashCode
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
public class CustomResourceDefinitionStatus implements KubernetesResource
{

    @JsonProperty("acceptedNames")
    private CustomResourceDefinitionNames acceptedNames;
    @JsonProperty("conditions")
    private List<CustomResourceDefinitionCondition> conditions = new ArrayList<CustomResourceDefinitionCondition>();
    @JsonProperty("storedVersions")
    private List<String> storedVersions = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CustomResourceDefinitionStatus() {
    }

    /**
     * 
     * @param storedVersions
     * @param conditions
     * @param acceptedNames
     */
    public CustomResourceDefinitionStatus(CustomResourceDefinitionNames acceptedNames, List<CustomResourceDefinitionCondition> conditions, List<String> storedVersions) {
        super();
        this.acceptedNames = acceptedNames;
        this.conditions = conditions;
        this.storedVersions = storedVersions;
    }

    @JsonProperty("acceptedNames")
    public CustomResourceDefinitionNames getAcceptedNames() {
        return acceptedNames;
    }

    @JsonProperty("acceptedNames")
    public void setAcceptedNames(CustomResourceDefinitionNames acceptedNames) {
        this.acceptedNames = acceptedNames;
    }

    @JsonProperty("conditions")
    public List<CustomResourceDefinitionCondition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<CustomResourceDefinitionCondition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("storedVersions")
    public List<String> getStoredVersions() {
        return storedVersions;
    }

    @JsonProperty("storedVersions")
    public void setStoredVersions(List<String> storedVersions) {
        this.storedVersions = storedVersions;
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
