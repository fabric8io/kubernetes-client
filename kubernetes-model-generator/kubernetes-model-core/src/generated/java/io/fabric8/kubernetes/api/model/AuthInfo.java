
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
    "as",
    "as-groups",
    "as-uid",
    "as-user-extra",
    "auth-provider",
    "client-certificate",
    "client-certificate-data",
    "client-key",
    "client-key-data",
    "exec",
    "extensions",
    "password",
    "token",
    "tokenFile",
    "username"
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
public class AuthInfo implements KubernetesResource
{

    @JsonProperty("as")
    private java.lang.String as;
    @JsonProperty("as-groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> asGroups = new ArrayList<java.lang.String>();
    @JsonProperty("as-uid")
    private java.lang.String asUid;
    @JsonProperty("as-user-extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, ArrayList<String>> asUserExtra = new LinkedHashMap<String, ArrayList<String>>();
    @JsonProperty("auth-provider")
    private AuthProviderConfig authProvider;
    @JsonProperty("client-certificate")
    private java.lang.String clientCertificate;
    @JsonProperty("client-certificate-data")
    private java.lang.String clientCertificateData;
    @JsonProperty("client-key")
    private java.lang.String clientKey;
    @JsonProperty("client-key-data")
    private java.lang.String clientKeyData;
    @JsonProperty("exec")
    private ExecConfig exec;
    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedExtension> extensions = new ArrayList<NamedExtension>();
    @JsonProperty("password")
    private java.lang.String password;
    @JsonProperty("token")
    private java.lang.String token;
    @JsonProperty("tokenFile")
    private java.lang.String tokenFile;
    @JsonProperty("username")
    private java.lang.String username;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AuthInfo() {
    }

    public AuthInfo(java.lang.String as, List<java.lang.String> asGroups, java.lang.String asUid, Map<String, ArrayList<String>> asUserExtra, AuthProviderConfig authProvider, java.lang.String clientCertificate, java.lang.String clientCertificateData, java.lang.String clientKey, java.lang.String clientKeyData, ExecConfig exec, List<NamedExtension> extensions, java.lang.String password, java.lang.String token, java.lang.String tokenFile, java.lang.String username) {
        super();
        this.as = as;
        this.asGroups = asGroups;
        this.asUid = asUid;
        this.asUserExtra = asUserExtra;
        this.authProvider = authProvider;
        this.clientCertificate = clientCertificate;
        this.clientCertificateData = clientCertificateData;
        this.clientKey = clientKey;
        this.clientKeyData = clientKeyData;
        this.exec = exec;
        this.extensions = extensions;
        this.password = password;
        this.token = token;
        this.tokenFile = tokenFile;
        this.username = username;
    }

    @JsonProperty("as")
    public java.lang.String getAs() {
        return as;
    }

    @JsonProperty("as")
    public void setAs(java.lang.String as) {
        this.as = as;
    }

    @JsonProperty("as-groups")
    public List<java.lang.String> getAsGroups() {
        return asGroups;
    }

    @JsonProperty("as-groups")
    public void setAsGroups(List<java.lang.String> asGroups) {
        this.asGroups = asGroups;
    }

    @JsonProperty("as-uid")
    public java.lang.String getAsUid() {
        return asUid;
    }

    @JsonProperty("as-uid")
    public void setAsUid(java.lang.String asUid) {
        this.asUid = asUid;
    }

    @JsonProperty("as-user-extra")
    public Map<String, ArrayList<String>> getAsUserExtra() {
        return asUserExtra;
    }

    @JsonProperty("as-user-extra")
    public void setAsUserExtra(Map<String, ArrayList<String>> asUserExtra) {
        this.asUserExtra = asUserExtra;
    }

    @JsonProperty("auth-provider")
    public AuthProviderConfig getAuthProvider() {
        return authProvider;
    }

    @JsonProperty("auth-provider")
    public void setAuthProvider(AuthProviderConfig authProvider) {
        this.authProvider = authProvider;
    }

    @JsonProperty("client-certificate")
    public java.lang.String getClientCertificate() {
        return clientCertificate;
    }

    @JsonProperty("client-certificate")
    public void setClientCertificate(java.lang.String clientCertificate) {
        this.clientCertificate = clientCertificate;
    }

    @JsonProperty("client-certificate-data")
    public java.lang.String getClientCertificateData() {
        return clientCertificateData;
    }

    @JsonProperty("client-certificate-data")
    public void setClientCertificateData(java.lang.String clientCertificateData) {
        this.clientCertificateData = clientCertificateData;
    }

    @JsonProperty("client-key")
    public java.lang.String getClientKey() {
        return clientKey;
    }

    @JsonProperty("client-key")
    public void setClientKey(java.lang.String clientKey) {
        this.clientKey = clientKey;
    }

    @JsonProperty("client-key-data")
    public java.lang.String getClientKeyData() {
        return clientKeyData;
    }

    @JsonProperty("client-key-data")
    public void setClientKeyData(java.lang.String clientKeyData) {
        this.clientKeyData = clientKeyData;
    }

    @JsonProperty("exec")
    public ExecConfig getExec() {
        return exec;
    }

    @JsonProperty("exec")
    public void setExec(ExecConfig exec) {
        this.exec = exec;
    }

    @JsonProperty("extensions")
    public List<NamedExtension> getExtensions() {
        return extensions;
    }

    @JsonProperty("extensions")
    public void setExtensions(List<NamedExtension> extensions) {
        this.extensions = extensions;
    }

    @JsonProperty("password")
    public java.lang.String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    @JsonProperty("token")
    public java.lang.String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(java.lang.String token) {
        this.token = token;
    }

    @JsonProperty("tokenFile")
    public java.lang.String getTokenFile() {
        return tokenFile;
    }

    @JsonProperty("tokenFile")
    public void setTokenFile(java.lang.String tokenFile) {
        this.tokenFile = tokenFile;
    }

    @JsonProperty("username")
    public java.lang.String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(java.lang.String username) {
        this.username = username;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
