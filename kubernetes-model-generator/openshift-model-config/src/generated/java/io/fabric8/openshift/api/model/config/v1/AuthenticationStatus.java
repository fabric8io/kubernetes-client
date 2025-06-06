
package io.fabric8.openshift.api.model.config.v1;

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
    "integratedOAuthMetadata",
    "oidcClients"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AuthenticationStatus implements Editable<AuthenticationStatusBuilder>, KubernetesResource
{

    @JsonProperty("integratedOAuthMetadata")
    private ConfigMapNameReference integratedOAuthMetadata;
    @JsonProperty("oidcClients")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OIDCClientStatus> oidcClients = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AuthenticationStatus() {
    }

    public AuthenticationStatus(ConfigMapNameReference integratedOAuthMetadata, List<OIDCClientStatus> oidcClients) {
        super();
        this.integratedOAuthMetadata = integratedOAuthMetadata;
        this.oidcClients = oidcClients;
    }

    @JsonProperty("integratedOAuthMetadata")
    public ConfigMapNameReference getIntegratedOAuthMetadata() {
        return integratedOAuthMetadata;
    }

    @JsonProperty("integratedOAuthMetadata")
    public void setIntegratedOAuthMetadata(ConfigMapNameReference integratedOAuthMetadata) {
        this.integratedOAuthMetadata = integratedOAuthMetadata;
    }

    /**
     * OIDCClients is where participating operators place the current OIDC client status for OIDC clients that can be customized by the cluster-admin.
     */
    @JsonProperty("oidcClients")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OIDCClientStatus> getOidcClients() {
        return oidcClients;
    }

    /**
     * OIDCClients is where participating operators place the current OIDC client status for OIDC clients that can be customized by the cluster-admin.
     */
    @JsonProperty("oidcClients")
    public void setOidcClients(List<OIDCClientStatus> oidcClients) {
        this.oidcClients = oidcClients;
    }

    @JsonIgnore
    public AuthenticationStatusBuilder edit() {
        return new AuthenticationStatusBuilder(this);
    }

    @JsonIgnore
    public AuthenticationStatusBuilder toBuilder() {
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
