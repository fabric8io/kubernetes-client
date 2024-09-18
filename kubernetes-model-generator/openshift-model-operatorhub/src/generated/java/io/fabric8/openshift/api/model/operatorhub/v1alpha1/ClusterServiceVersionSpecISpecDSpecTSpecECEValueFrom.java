
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
    "configMapKeyRef",
    "fieldRef",
    "resourceFieldRef",
    "secretKeyRef"
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
public class ClusterServiceVersionSpecISpecDSpecTSpecECEValueFrom implements Editable<ClusterServiceVersionSpecISpecDSpecTSpecECEValueFromBuilder> , KubernetesResource
{

    @JsonProperty("configMapKeyRef")
    private ClusterServiceVersionSpecISpecDSpecTSpecECEVFConfigMapKeyRef configMapKeyRef;
    @JsonProperty("fieldRef")
    private ClusterServiceVersionSpecISpecDSpecTSpecECEVFFieldRef fieldRef;
    @JsonProperty("resourceFieldRef")
    private ClusterServiceVersionSpecISpecDSpecTSpecECEVFResourceFieldRef resourceFieldRef;
    @JsonProperty("secretKeyRef")
    private ClusterServiceVersionSpecISpecDSpecTSpecECEVFSecretKeyRef secretKeyRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterServiceVersionSpecISpecDSpecTSpecECEValueFrom() {
    }

    public ClusterServiceVersionSpecISpecDSpecTSpecECEValueFrom(ClusterServiceVersionSpecISpecDSpecTSpecECEVFConfigMapKeyRef configMapKeyRef, ClusterServiceVersionSpecISpecDSpecTSpecECEVFFieldRef fieldRef, ClusterServiceVersionSpecISpecDSpecTSpecECEVFResourceFieldRef resourceFieldRef, ClusterServiceVersionSpecISpecDSpecTSpecECEVFSecretKeyRef secretKeyRef) {
        super();
        this.configMapKeyRef = configMapKeyRef;
        this.fieldRef = fieldRef;
        this.resourceFieldRef = resourceFieldRef;
        this.secretKeyRef = secretKeyRef;
    }

    @JsonProperty("configMapKeyRef")
    public ClusterServiceVersionSpecISpecDSpecTSpecECEVFConfigMapKeyRef getConfigMapKeyRef() {
        return configMapKeyRef;
    }

    @JsonProperty("configMapKeyRef")
    public void setConfigMapKeyRef(ClusterServiceVersionSpecISpecDSpecTSpecECEVFConfigMapKeyRef configMapKeyRef) {
        this.configMapKeyRef = configMapKeyRef;
    }

    @JsonProperty("fieldRef")
    public ClusterServiceVersionSpecISpecDSpecTSpecECEVFFieldRef getFieldRef() {
        return fieldRef;
    }

    @JsonProperty("fieldRef")
    public void setFieldRef(ClusterServiceVersionSpecISpecDSpecTSpecECEVFFieldRef fieldRef) {
        this.fieldRef = fieldRef;
    }

    @JsonProperty("resourceFieldRef")
    public ClusterServiceVersionSpecISpecDSpecTSpecECEVFResourceFieldRef getResourceFieldRef() {
        return resourceFieldRef;
    }

    @JsonProperty("resourceFieldRef")
    public void setResourceFieldRef(ClusterServiceVersionSpecISpecDSpecTSpecECEVFResourceFieldRef resourceFieldRef) {
        this.resourceFieldRef = resourceFieldRef;
    }

    @JsonProperty("secretKeyRef")
    public ClusterServiceVersionSpecISpecDSpecTSpecECEVFSecretKeyRef getSecretKeyRef() {
        return secretKeyRef;
    }

    @JsonProperty("secretKeyRef")
    public void setSecretKeyRef(ClusterServiceVersionSpecISpecDSpecTSpecECEVFSecretKeyRef secretKeyRef) {
        this.secretKeyRef = secretKeyRef;
    }

    @JsonIgnore
    public ClusterServiceVersionSpecISpecDSpecTSpecECEValueFromBuilder edit() {
        return new ClusterServiceVersionSpecISpecDSpecTSpecECEValueFromBuilder(this);
    }

    @JsonIgnore
    public ClusterServiceVersionSpecISpecDSpecTSpecECEValueFromBuilder toBuilder() {
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
