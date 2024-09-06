
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
    "ca",
    "domainName",
    "tlsClientCert",
    "tlsClientKey",
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class OAuthSpecIPKeystone implements Editable<OAuthSpecIPKeystoneBuilder> , KubernetesResource
{

    @JsonProperty("ca")
    private OAuthSpecIPKCa ca;
    @JsonProperty("domainName")
    private String domainName;
    @JsonProperty("tlsClientCert")
    private OAuthSpecIPKTlsClientCert tlsClientCert;
    @JsonProperty("tlsClientKey")
    private OAuthSpecIPKTlsClientKey tlsClientKey;
    @JsonProperty("url")
    private String url;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OAuthSpecIPKeystone() {
    }

    public OAuthSpecIPKeystone(OAuthSpecIPKCa ca, String domainName, OAuthSpecIPKTlsClientCert tlsClientCert, OAuthSpecIPKTlsClientKey tlsClientKey, String url) {
        super();
        this.ca = ca;
        this.domainName = domainName;
        this.tlsClientCert = tlsClientCert;
        this.tlsClientKey = tlsClientKey;
        this.url = url;
    }

    @JsonProperty("ca")
    public OAuthSpecIPKCa getCa() {
        return ca;
    }

    @JsonProperty("ca")
    public void setCa(OAuthSpecIPKCa ca) {
        this.ca = ca;
    }

    @JsonProperty("domainName")
    public String getDomainName() {
        return domainName;
    }

    @JsonProperty("domainName")
    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    @JsonProperty("tlsClientCert")
    public OAuthSpecIPKTlsClientCert getTlsClientCert() {
        return tlsClientCert;
    }

    @JsonProperty("tlsClientCert")
    public void setTlsClientCert(OAuthSpecIPKTlsClientCert tlsClientCert) {
        this.tlsClientCert = tlsClientCert;
    }

    @JsonProperty("tlsClientKey")
    public OAuthSpecIPKTlsClientKey getTlsClientKey() {
        return tlsClientKey;
    }

    @JsonProperty("tlsClientKey")
    public void setTlsClientKey(OAuthSpecIPKTlsClientKey tlsClientKey) {
        this.tlsClientKey = tlsClientKey;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonIgnore
    public OAuthSpecIPKeystoneBuilder edit() {
        return new OAuthSpecIPKeystoneBuilder(this);
    }

    @JsonIgnore
    public OAuthSpecIPKeystoneBuilder toBuilder() {
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
