
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
 * WebHookTrigger is a trigger that gets invoked using a webhook type of post
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowEnv",
    "secret",
    "secretReference"
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
public class WebHookTrigger implements Editable<WebHookTriggerBuilder>, KubernetesResource
{

    @JsonProperty("allowEnv")
    private Boolean allowEnv;
    @JsonProperty("secret")
    private String secret;
    @JsonProperty("secretReference")
    private SecretLocalReference secretReference;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WebHookTrigger() {
    }

    public WebHookTrigger(Boolean allowEnv, String secret, SecretLocalReference secretReference) {
        super();
        this.allowEnv = allowEnv;
        this.secret = secret;
        this.secretReference = secretReference;
    }

    /**
     * allowEnv determines whether the webhook can set environment variables; can only be set to true for GenericWebHook.
     */
    @JsonProperty("allowEnv")
    public Boolean getAllowEnv() {
        return allowEnv;
    }

    /**
     * allowEnv determines whether the webhook can set environment variables; can only be set to true for GenericWebHook.
     */
    @JsonProperty("allowEnv")
    public void setAllowEnv(Boolean allowEnv) {
        this.allowEnv = allowEnv;
    }

    /**
     * secret used to validate requests. Deprecated: use SecretReference instead.
     */
    @JsonProperty("secret")
    public String getSecret() {
        return secret;
    }

    /**
     * secret used to validate requests. Deprecated: use SecretReference instead.
     */
    @JsonProperty("secret")
    public void setSecret(String secret) {
        this.secret = secret;
    }

    /**
     * WebHookTrigger is a trigger that gets invoked using a webhook type of post
     */
    @JsonProperty("secretReference")
    public SecretLocalReference getSecretReference() {
        return secretReference;
    }

    /**
     * WebHookTrigger is a trigger that gets invoked using a webhook type of post
     */
    @JsonProperty("secretReference")
    public void setSecretReference(SecretLocalReference secretReference) {
        this.secretReference = secretReference;
    }

    @JsonIgnore
    public WebHookTriggerBuilder edit() {
        return new WebHookTriggerBuilder(this);
    }

    @JsonIgnore
    public WebHookTriggerBuilder toBuilder() {
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
