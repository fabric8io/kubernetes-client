
package io.fabric8.certmanager.api.model.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.fabric8.certmanager.api.model.meta.v1.LocalObjectReference;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * VenafiNGTS defines connection configuration for the Palo Alto Networks Next Generation Trust Services (NGTS) platform using OAuth 2.0 Client Credentials.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "credentialsRef",
    "tokenEndpoint",
    "tsgID",
    "url"
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
public class VenafiNGTS implements Editable<VenafiNGTSBuilder>, KubernetesResource
{

    @JsonProperty("credentialsRef")
    private LocalObjectReference credentialsRef;
    @JsonProperty("tokenEndpoint")
    private String tokenEndpoint;
    @JsonProperty("tsgID")
    private String tsgID;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public VenafiNGTS() {
    }

    public VenafiNGTS(LocalObjectReference credentialsRef, String tokenEndpoint, String tsgID, String url) {
        super();
        this.credentialsRef = credentialsRef;
        this.tokenEndpoint = tokenEndpoint;
        this.tsgID = tsgID;
        this.url = url;
    }

    /**
     * VenafiNGTS defines connection configuration for the Palo Alto Networks Next Generation Trust Services (NGTS) platform using OAuth 2.0 Client Credentials.
     */
    @JsonProperty("credentialsRef")
    public LocalObjectReference getCredentialsRef() {
        return credentialsRef;
    }

    /**
     * VenafiNGTS defines connection configuration for the Palo Alto Networks Next Generation Trust Services (NGTS) platform using OAuth 2.0 Client Credentials.
     */
    @JsonProperty("credentialsRef")
    public void setCredentialsRef(LocalObjectReference credentialsRef) {
        this.credentialsRef = credentialsRef;
    }

    /**
     * TokenEndpoint is the OAuth 2.0 token endpoint URL used to obtain access tokens, for example "https://auth.apps.paloaltonetworks.com/oauth2/access_token". Defaults to "https://auth.apps.paloaltonetworks.com/oauth2/access_token" if not set.
     */
    @JsonProperty("tokenEndpoint")
    public String getTokenEndpoint() {
        return tokenEndpoint;
    }

    /**
     * TokenEndpoint is the OAuth 2.0 token endpoint URL used to obtain access tokens, for example "https://auth.apps.paloaltonetworks.com/oauth2/access_token". Defaults to "https://auth.apps.paloaltonetworks.com/oauth2/access_token" if not set.
     */
    @JsonProperty("tokenEndpoint")
    public void setTokenEndpoint(String tokenEndpoint) {
        this.tokenEndpoint = tokenEndpoint;
    }

    /**
     * TSGID is the Tenant Service Group ID used to scope the OAuth 2.0 access token, for example "1234567890". The tsg_id: prefix is added automatically. This field is required.
     */
    @JsonProperty("tsgID")
    public String getTsgID() {
        return tsgID;
    }

    /**
     * TSGID is the Tenant Service Group ID used to scope the OAuth 2.0 access token, for example "1234567890". The tsg_id: prefix is added automatically. This field is required.
     */
    @JsonProperty("tsgID")
    public void setTsgID(String tsgID) {
        this.tsgID = tsgID;
    }

    /**
     * URL is the base URL for the NGTS API endpoint. Defaults to "https://api.strata.paloaltonetworks.com/ngts" if not set.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * URL is the base URL for the NGTS API endpoint. Defaults to "https://api.strata.paloaltonetworks.com/ngts" if not set.
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public VenafiNGTSBuilder edit() {
        return new VenafiNGTSBuilder(this);
    }

    @JsonIgnore
    public VenafiNGTSBuilder toBuilder() {
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
