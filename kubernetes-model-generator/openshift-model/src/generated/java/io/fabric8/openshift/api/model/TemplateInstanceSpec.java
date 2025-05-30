
package io.fabric8.openshift.api.model;

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
 * TemplateInstanceSpec describes the desired state of a TemplateInstance.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "requester",
    "secret",
    "template"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class TemplateInstanceSpec implements Editable<TemplateInstanceSpecBuilder>, KubernetesResource
{

    @JsonProperty("requester")
    private TemplateInstanceRequester requester;
    @JsonProperty("secret")
    private LocalObjectReference secret;
    @JsonProperty("template")
    private Template template;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TemplateInstanceSpec() {
    }

    public TemplateInstanceSpec(TemplateInstanceRequester requester, LocalObjectReference secret, Template template) {
        super();
        this.requester = requester;
        this.secret = secret;
        this.template = template;
    }

    /**
     * TemplateInstanceSpec describes the desired state of a TemplateInstance.
     */
    @JsonProperty("requester")
    public TemplateInstanceRequester getRequester() {
        return requester;
    }

    /**
     * TemplateInstanceSpec describes the desired state of a TemplateInstance.
     */
    @JsonProperty("requester")
    public void setRequester(TemplateInstanceRequester requester) {
        this.requester = requester;
    }

    /**
     * TemplateInstanceSpec describes the desired state of a TemplateInstance.
     */
    @JsonProperty("secret")
    public LocalObjectReference getSecret() {
        return secret;
    }

    /**
     * TemplateInstanceSpec describes the desired state of a TemplateInstance.
     */
    @JsonProperty("secret")
    public void setSecret(LocalObjectReference secret) {
        this.secret = secret;
    }

    /**
     * TemplateInstanceSpec describes the desired state of a TemplateInstance.
     */
    @JsonProperty("template")
    public Template getTemplate() {
        return template;
    }

    /**
     * TemplateInstanceSpec describes the desired state of a TemplateInstance.
     */
    @JsonProperty("template")
    public void setTemplate(Template template) {
        this.template = template;
    }

    @JsonIgnore
    public TemplateInstanceSpecBuilder edit() {
        return new TemplateInstanceSpecBuilder(this);
    }

    @JsonIgnore
    public TemplateInstanceSpecBuilder toBuilder() {
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
