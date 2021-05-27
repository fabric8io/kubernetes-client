
package io.fabric8.openshift.api.model;

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
    "bindingIDs",
    "secret",
    "templateInstance"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class BrokerTemplateInstanceSpec implements KubernetesResource
{

    @JsonProperty("bindingIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bindingIDs = new ArrayList<String>();
    @JsonProperty("secret")
    private io.fabric8.kubernetes.api.model.ObjectReference secret;
    @JsonProperty("templateInstance")
    private io.fabric8.kubernetes.api.model.ObjectReference templateInstance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BrokerTemplateInstanceSpec() {
    }

    /**
     * 
     * @param templateInstance
     * @param bindingIDs
     * @param secret
     */
    public BrokerTemplateInstanceSpec(List<String> bindingIDs, io.fabric8.kubernetes.api.model.ObjectReference secret, io.fabric8.kubernetes.api.model.ObjectReference templateInstance) {
        super();
        this.bindingIDs = bindingIDs;
        this.secret = secret;
        this.templateInstance = templateInstance;
    }

    @JsonProperty("bindingIDs")
    public List<String> getBindingIDs() {
        return bindingIDs;
    }

    @JsonProperty("bindingIDs")
    public void setBindingIDs(List<String> bindingIDs) {
        this.bindingIDs = bindingIDs;
    }

    @JsonProperty("secret")
    public io.fabric8.kubernetes.api.model.ObjectReference getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(io.fabric8.kubernetes.api.model.ObjectReference secret) {
        this.secret = secret;
    }

    @JsonProperty("templateInstance")
    public io.fabric8.kubernetes.api.model.ObjectReference getTemplateInstance() {
        return templateInstance;
    }

    @JsonProperty("templateInstance")
    public void setTemplateInstance(io.fabric8.kubernetes.api.model.ObjectReference templateInstance) {
        this.templateInstance = templateInstance;
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
