
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * CustomResourceDefinitions declares all of the CRDs managed or required by an operator being ran by ClusterServiceVersion.<br><p> <br><p> If the CRD is present in the Owned list, it is implicitly required.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "owned",
    "required"
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
public class CustomResourceDefinitions implements Editable<CustomResourceDefinitionsBuilder>, KubernetesResource
{

    @JsonProperty("owned")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CRDDescription> owned = new ArrayList<>();
    @JsonProperty("required")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CRDDescription> required = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CustomResourceDefinitions() {
    }

    public CustomResourceDefinitions(List<CRDDescription> owned, List<CRDDescription> required) {
        super();
        this.owned = owned;
        this.required = required;
    }

    /**
     * CustomResourceDefinitions declares all of the CRDs managed or required by an operator being ran by ClusterServiceVersion.<br><p> <br><p> If the CRD is present in the Owned list, it is implicitly required.
     */
    @JsonProperty("owned")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CRDDescription> getOwned() {
        return owned;
    }

    /**
     * CustomResourceDefinitions declares all of the CRDs managed or required by an operator being ran by ClusterServiceVersion.<br><p> <br><p> If the CRD is present in the Owned list, it is implicitly required.
     */
    @JsonProperty("owned")
    public void setOwned(List<CRDDescription> owned) {
        this.owned = owned;
    }

    /**
     * CustomResourceDefinitions declares all of the CRDs managed or required by an operator being ran by ClusterServiceVersion.<br><p> <br><p> If the CRD is present in the Owned list, it is implicitly required.
     */
    @JsonProperty("required")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<CRDDescription> getRequired() {
        return required;
    }

    /**
     * CustomResourceDefinitions declares all of the CRDs managed or required by an operator being ran by ClusterServiceVersion.<br><p> <br><p> If the CRD is present in the Owned list, it is implicitly required.
     */
    @JsonProperty("required")
    public void setRequired(List<CRDDescription> required) {
        this.required = required;
    }

    @JsonIgnore
    public CustomResourceDefinitionsBuilder edit() {
        return new CustomResourceDefinitionsBuilder(this);
    }

    @JsonIgnore
    public CustomResourceDefinitionsBuilder toBuilder() {
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
