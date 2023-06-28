
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "certificate-authority",
    "certificate-authority-data",
    "disable-compression",
    "extensions",
    "insecure-skip-tls-verify",
    "proxy-url",
    "server",
    "tls-server-name"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class Cluster implements KubernetesResource
{

    @JsonProperty("certificate-authority")
    private String certificateAuthority;
    @JsonProperty("certificate-authority-data")
    private String certificateAuthorityData;
    @JsonProperty("disable-compression")
    private Boolean disableCompression;
    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedExtension> extensions = new ArrayList<NamedExtension>();
    @JsonProperty("insecure-skip-tls-verify")
    private Boolean insecureSkipTlsVerify;
    @JsonProperty("proxy-url")
    private String proxyUrl;
    @JsonProperty("server")
    private String server;
    @JsonProperty("tls-server-name")
    private String tlsServerName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Cluster() {
    }

    public Cluster(String certificateAuthority, String certificateAuthorityData, Boolean disableCompression, List<NamedExtension> extensions, Boolean insecureSkipTlsVerify, String proxyUrl, String server, String tlsServerName) {
        super();
        this.certificateAuthority = certificateAuthority;
        this.certificateAuthorityData = certificateAuthorityData;
        this.disableCompression = disableCompression;
        this.extensions = extensions;
        this.insecureSkipTlsVerify = insecureSkipTlsVerify;
        this.proxyUrl = proxyUrl;
        this.server = server;
        this.tlsServerName = tlsServerName;
    }

    @JsonProperty("certificate-authority")
    public String getCertificateAuthority() {
        return certificateAuthority;
    }

    @JsonProperty("certificate-authority")
    public void setCertificateAuthority(String certificateAuthority) {
        this.certificateAuthority = certificateAuthority;
    }

    @JsonProperty("certificate-authority-data")
    public String getCertificateAuthorityData() {
        return certificateAuthorityData;
    }

    @JsonProperty("certificate-authority-data")
    public void setCertificateAuthorityData(String certificateAuthorityData) {
        this.certificateAuthorityData = certificateAuthorityData;
    }

    @JsonProperty("disable-compression")
    public Boolean getDisableCompression() {
        return disableCompression;
    }

    @JsonProperty("disable-compression")
    public void setDisableCompression(Boolean disableCompression) {
        this.disableCompression = disableCompression;
    }

    @JsonProperty("extensions")
    public List<NamedExtension> getExtensions() {
        return extensions;
    }

    @JsonProperty("extensions")
    public void setExtensions(List<NamedExtension> extensions) {
        this.extensions = extensions;
    }

    @JsonProperty("insecure-skip-tls-verify")
    public Boolean getInsecureSkipTlsVerify() {
        return insecureSkipTlsVerify;
    }

    @JsonProperty("insecure-skip-tls-verify")
    public void setInsecureSkipTlsVerify(Boolean insecureSkipTlsVerify) {
        this.insecureSkipTlsVerify = insecureSkipTlsVerify;
    }

    @JsonProperty("proxy-url")
    public String getProxyUrl() {
        return proxyUrl;
    }

    @JsonProperty("proxy-url")
    public void setProxyUrl(String proxyUrl) {
        this.proxyUrl = proxyUrl;
    }

    @JsonProperty("server")
    public String getServer() {
        return server;
    }

    @JsonProperty("server")
    public void setServer(String server) {
        this.server = server;
    }

    @JsonProperty("tls-server-name")
    public String getTlsServerName() {
        return tlsServerName;
    }

    @JsonProperty("tls-server-name")
    public void setTlsServerName(String tlsServerName) {
        this.tlsServerName = tlsServerName;
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
