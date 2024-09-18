
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
public class SubscriptionSpecCEValueFrom implements Editable<SubscriptionSpecCEValueFromBuilder> , KubernetesResource
{

    @JsonProperty("configMapKeyRef")
    private SubscriptionSpecCEVFConfigMapKeyRef configMapKeyRef;
    @JsonProperty("fieldRef")
    private SubscriptionSpecCEVFFieldRef fieldRef;
    @JsonProperty("resourceFieldRef")
    private SubscriptionSpecCEVFResourceFieldRef resourceFieldRef;
    @JsonProperty("secretKeyRef")
    private SubscriptionSpecCEVFSecretKeyRef secretKeyRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubscriptionSpecCEValueFrom() {
    }

    public SubscriptionSpecCEValueFrom(SubscriptionSpecCEVFConfigMapKeyRef configMapKeyRef, SubscriptionSpecCEVFFieldRef fieldRef, SubscriptionSpecCEVFResourceFieldRef resourceFieldRef, SubscriptionSpecCEVFSecretKeyRef secretKeyRef) {
        super();
        this.configMapKeyRef = configMapKeyRef;
        this.fieldRef = fieldRef;
        this.resourceFieldRef = resourceFieldRef;
        this.secretKeyRef = secretKeyRef;
    }

    @JsonProperty("configMapKeyRef")
    public SubscriptionSpecCEVFConfigMapKeyRef getConfigMapKeyRef() {
        return configMapKeyRef;
    }

    @JsonProperty("configMapKeyRef")
    public void setConfigMapKeyRef(SubscriptionSpecCEVFConfigMapKeyRef configMapKeyRef) {
        this.configMapKeyRef = configMapKeyRef;
    }

    @JsonProperty("fieldRef")
    public SubscriptionSpecCEVFFieldRef getFieldRef() {
        return fieldRef;
    }

    @JsonProperty("fieldRef")
    public void setFieldRef(SubscriptionSpecCEVFFieldRef fieldRef) {
        this.fieldRef = fieldRef;
    }

    @JsonProperty("resourceFieldRef")
    public SubscriptionSpecCEVFResourceFieldRef getResourceFieldRef() {
        return resourceFieldRef;
    }

    @JsonProperty("resourceFieldRef")
    public void setResourceFieldRef(SubscriptionSpecCEVFResourceFieldRef resourceFieldRef) {
        this.resourceFieldRef = resourceFieldRef;
    }

    @JsonProperty("secretKeyRef")
    public SubscriptionSpecCEVFSecretKeyRef getSecretKeyRef() {
        return secretKeyRef;
    }

    @JsonProperty("secretKeyRef")
    public void setSecretKeyRef(SubscriptionSpecCEVFSecretKeyRef secretKeyRef) {
        this.secretKeyRef = secretKeyRef;
    }

    @JsonIgnore
    public SubscriptionSpecCEValueFromBuilder edit() {
        return new SubscriptionSpecCEValueFromBuilder(this);
    }

    @JsonIgnore
    public SubscriptionSpecCEValueFromBuilder toBuilder() {
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
