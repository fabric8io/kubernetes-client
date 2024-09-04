
package io.fabric8.openshift.api.model.config.v1;

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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class OAuthSpecTemplates implements Editable<OAuthSpecTemplatesBuilder> , KubernetesResource
{

    @JsonProperty("error")
    private OAuthSpecTError error;
    @JsonProperty("login")
    private OAuthSpecTLogin login;
    @JsonProperty("providerSelection")
    private OAuthSpecTProviderSelection providerSelection;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OAuthSpecTemplates() {
    }

    public OAuthSpecTemplates(OAuthSpecTError error, OAuthSpecTLogin login, OAuthSpecTProviderSelection providerSelection) {
        super();
        this.error = error;
        this.login = login;
        this.providerSelection = providerSelection;
    }

    @JsonProperty("error")
    public OAuthSpecTError getError() {
        return error;
    }

    @JsonProperty("error")
    public void setError(OAuthSpecTError error) {
        this.error = error;
    }

    @JsonProperty("login")
    public OAuthSpecTLogin getLogin() {
        return login;
    }

    @JsonProperty("login")
    public void setLogin(OAuthSpecTLogin login) {
        this.login = login;
    }

    @JsonProperty("providerSelection")
    public OAuthSpecTProviderSelection getProviderSelection() {
        return providerSelection;
    }

    @JsonProperty("providerSelection")
    public void setProviderSelection(OAuthSpecTProviderSelection providerSelection) {
        this.providerSelection = providerSelection;
    }

    @JsonIgnore
    public OAuthSpecTemplatesBuilder edit() {
        return new OAuthSpecTemplatesBuilder(this);
    }

    @JsonIgnore
    public OAuthSpecTemplatesBuilder toBuilder() {
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
