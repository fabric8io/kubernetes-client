
package io.fabric8.openshift.api.model.config.v1;

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
 * OAuthTemplates allow for customization of pages like the login page
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "error",
    "login",
    "providerSelection"
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
public class OAuthTemplates implements Editable<OAuthTemplatesBuilder>, KubernetesResource
{

    @JsonProperty("error")
    private SecretNameReference error;
    @JsonProperty("login")
    private SecretNameReference login;
    @JsonProperty("providerSelection")
    private SecretNameReference providerSelection;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OAuthTemplates() {
    }

    public OAuthTemplates(SecretNameReference error, SecretNameReference login, SecretNameReference providerSelection) {
        super();
        this.error = error;
        this.login = login;
        this.providerSelection = providerSelection;
    }

    /**
     * OAuthTemplates allow for customization of pages like the login page
     */
    @JsonProperty("error")
    public SecretNameReference getError() {
        return error;
    }

    /**
     * OAuthTemplates allow for customization of pages like the login page
     */
    @JsonProperty("error")
    public void setError(SecretNameReference error) {
        this.error = error;
    }

    /**
     * OAuthTemplates allow for customization of pages like the login page
     */
    @JsonProperty("login")
    public SecretNameReference getLogin() {
        return login;
    }

    /**
     * OAuthTemplates allow for customization of pages like the login page
     */
    @JsonProperty("login")
    public void setLogin(SecretNameReference login) {
        this.login = login;
    }

    /**
     * OAuthTemplates allow for customization of pages like the login page
     */
    @JsonProperty("providerSelection")
    public SecretNameReference getProviderSelection() {
        return providerSelection;
    }

    /**
     * OAuthTemplates allow for customization of pages like the login page
     */
    @JsonProperty("providerSelection")
    public void setProviderSelection(SecretNameReference providerSelection) {
        this.providerSelection = providerSelection;
    }

    @JsonIgnore
    public OAuthTemplatesBuilder edit() {
        return new OAuthTemplatesBuilder(this);
    }

    @JsonIgnore
    public OAuthTemplatesBuilder toBuilder() {
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
