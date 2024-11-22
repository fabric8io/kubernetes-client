
package io.fabric8.openshift.api.model;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "bindingIDs",
    "secret",
    "templateInstance"
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
public class BrokerTemplateInstanceSpec implements Editable<BrokerTemplateInstanceSpecBuilder> , KubernetesResource
{

    @JsonProperty("bindingIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> bindingIDs = new ArrayList<>();
    @JsonProperty("secret")
    private ObjectReference secret;
    @JsonProperty("templateInstance")
    private ObjectReference templateInstance;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BrokerTemplateInstanceSpec() {
    }

    public BrokerTemplateInstanceSpec(List<String> bindingIDs, ObjectReference secret, ObjectReference templateInstance) {
        super();
        this.bindingIDs = bindingIDs;
        this.secret = secret;
        this.templateInstance = templateInstance;
    }

    @JsonProperty("bindingIDs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getBindingIDs() {
        return bindingIDs;
    }

    @JsonProperty("bindingIDs")
    public void setBindingIDs(List<String> bindingIDs) {
        this.bindingIDs = bindingIDs;
    }

    @JsonProperty("secret")
    public ObjectReference getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(ObjectReference secret) {
        this.secret = secret;
    }

    @JsonProperty("templateInstance")
    public ObjectReference getTemplateInstance() {
        return templateInstance;
    }

    @JsonProperty("templateInstance")
    public void setTemplateInstance(ObjectReference templateInstance) {
        this.templateInstance = templateInstance;
    }

    @JsonIgnore
    public BrokerTemplateInstanceSpecBuilder edit() {
        return new BrokerTemplateInstanceSpecBuilder(this);
    }

    @JsonIgnore
    public BrokerTemplateInstanceSpecBuilder toBuilder() {
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
