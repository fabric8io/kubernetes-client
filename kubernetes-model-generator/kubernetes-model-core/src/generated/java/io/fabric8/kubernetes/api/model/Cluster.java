
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "certificate-authority",
    "certificate-authority-data",
    "disable-compression",
    "extensions",
    "insecure-skip-tls-verify",
    "proxy-url",
    "server",
    "tls-server-name"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Cluster implements Editable<ClusterBuilder>, KubernetesResource
{

    @JsonProperty("certificate-authority")
    private String certificateAuthority;
    @JsonProperty("certificate-authority-data")
    private String certificateAuthorityData;
    @JsonProperty("disable-compression")
    private Boolean disableCompression;
    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedExtension> extensions = new ArrayList<>();
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    @JsonIgnore
    public ClusterBuilder edit() {
        return new ClusterBuilder(this);
    }

    @JsonIgnore
    public ClusterBuilder toBuilder() {
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Cluster)) {
            return false;
        }
        Cluster other = (Cluster) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$certificateAuthority = this.getCertificateAuthority();
        Object other$certificateAuthority = other.getCertificateAuthority();
        if (this$certificateAuthority == null ? other$certificateAuthority != null : !this$certificateAuthority.equals(other$certificateAuthority)) {
            return false;
        }
        Object this$certificateAuthorityData = this.getCertificateAuthorityData();
        Object other$certificateAuthorityData = other.getCertificateAuthorityData();
        if (this$certificateAuthorityData == null ? other$certificateAuthorityData != null : !this$certificateAuthorityData.equals(other$certificateAuthorityData)) {
            return false;
        }
        Object this$disableCompression = this.getDisableCompression();
        Object other$disableCompression = other.getDisableCompression();
        if (this$disableCompression == null ? other$disableCompression != null : !this$disableCompression.equals(other$disableCompression)) {
            return false;
        }
        Object this$extensions = this.getExtensions();
        Object other$extensions = other.getExtensions();
        if (this$extensions == null ? other$extensions != null : !this$extensions.equals(other$extensions)) {
            return false;
        }
        Object this$insecureSkipTlsVerify = this.getInsecureSkipTlsVerify();
        Object other$insecureSkipTlsVerify = other.getInsecureSkipTlsVerify();
        if (this$insecureSkipTlsVerify == null ? other$insecureSkipTlsVerify != null : !this$insecureSkipTlsVerify.equals(other$insecureSkipTlsVerify)) {
            return false;
        }
        Object this$proxyUrl = this.getProxyUrl();
        Object other$proxyUrl = other.getProxyUrl();
        if (this$proxyUrl == null ? other$proxyUrl != null : !this$proxyUrl.equals(other$proxyUrl)) {
            return false;
        }
        Object this$server = this.getServer();
        Object other$server = other.getServer();
        if (this$server == null ? other$server != null : !this$server.equals(other$server)) {
            return false;
        }
        Object this$tlsServerName = this.getTlsServerName();
        Object other$tlsServerName = other.getTlsServerName();
        if (this$tlsServerName == null ? other$tlsServerName != null : !this$tlsServerName.equals(other$tlsServerName)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Cluster;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $certificateAuthority = this.getCertificateAuthority();
        result = result * prime + ($certificateAuthority == null ? 43 : $certificateAuthority.hashCode());
        Object $certificateAuthorityData = this.getCertificateAuthorityData();
        result = result * prime + ($certificateAuthorityData == null ? 43 : $certificateAuthorityData.hashCode());
        Object $disableCompression = this.getDisableCompression();
        result = result * prime + ($disableCompression == null ? 43 : $disableCompression.hashCode());
        Object $extensions = this.getExtensions();
        result = result * prime + ($extensions == null ? 43 : $extensions.hashCode());
        Object $insecureSkipTlsVerify = this.getInsecureSkipTlsVerify();
        result = result * prime + ($insecureSkipTlsVerify == null ? 43 : $insecureSkipTlsVerify.hashCode());
        Object $proxyUrl = this.getProxyUrl();
        result = result * prime + ($proxyUrl == null ? 43 : $proxyUrl.hashCode());
        Object $server = this.getServer();
        result = result * prime + ($server == null ? 43 : $server.hashCode());
        Object $tlsServerName = this.getTlsServerName();
        result = result * prime + ($tlsServerName == null ? 43 : $tlsServerName.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Cluster(" + "certificateAuthority=" + this.getCertificateAuthority() + ", certificateAuthorityData=" + this.getCertificateAuthorityData() + ", disableCompression=" + this.getDisableCompression() + ", extensions=" + this.getExtensions() + ", insecureSkipTlsVerify=" + this.getInsecureSkipTlsVerify() + ", proxyUrl=" + this.getProxyUrl() + ", server=" + this.getServer() + ", tlsServerName=" + this.getTlsServerName() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
