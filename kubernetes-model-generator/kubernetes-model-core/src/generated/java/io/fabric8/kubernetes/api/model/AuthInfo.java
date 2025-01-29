
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class AuthInfo implements Editable<AuthInfoBuilder>, KubernetesResource
{

    @JsonProperty("as")
    private String as;
    @JsonProperty("as-groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> asGroups = new ArrayList<>();
    @JsonProperty("as-uid")
    private String asUid;
    @JsonProperty("as-user-extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> asUserExtra = new LinkedHashMap<>();
    @JsonProperty("auth-provider")
    private AuthProviderConfig authProvider;
    @JsonProperty("client-certificate")
    private String clientCertificate;
    @JsonProperty("client-certificate-data")
    private String clientCertificateData;
    @JsonProperty("client-key")
    private String clientKey;
    @JsonProperty("client-key-data")
    private String clientKeyData;
    @JsonProperty("exec")
    private ExecConfig exec;
    @JsonProperty("extensions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<NamedExtension> extensions = new ArrayList<>();
    @JsonProperty("password")
    private String password;
    @JsonProperty("token")
    private String token;
    @JsonProperty("tokenFile")
    private String tokenFile;
    @JsonProperty("username")
    private String username;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public AuthInfo() {
    }

    public AuthInfo(String as, List<String> asGroups, String asUid, Map<String, List<String>> asUserExtra, AuthProviderConfig authProvider, String clientCertificate, String clientCertificateData, String clientKey, String clientKeyData, ExecConfig exec, List<NamedExtension> extensions, String password, String token, String tokenFile, String username) {
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
    public String getAs() {
        return as;
    }

    @JsonProperty("as")
    public void setAs(String as) {
        this.as = as;
    }

    @JsonProperty("as-groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAsGroups() {
        return asGroups;
    }

    @JsonProperty("as-groups")
    public void setAsGroups(List<String> asGroups) {
        this.asGroups = asGroups;
    }

    @JsonProperty("as-uid")
    public String getAsUid() {
        return asUid;
    }

    @JsonProperty("as-uid")
    public void setAsUid(String asUid) {
        this.asUid = asUid;
    }

    @JsonProperty("as-user-extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getAsUserExtra() {
        return asUserExtra;
    }

    @JsonProperty("as-user-extra")
    public void setAsUserExtra(Map<String, List<String>> asUserExtra) {
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
    public String getClientCertificate() {
        return clientCertificate;
    }

    @JsonProperty("client-certificate")
    public void setClientCertificate(String clientCertificate) {
        this.clientCertificate = clientCertificate;
    }

    @JsonProperty("client-certificate-data")
    public String getClientCertificateData() {
        return clientCertificateData;
    }

    @JsonProperty("client-certificate-data")
    public void setClientCertificateData(String clientCertificateData) {
        this.clientCertificateData = clientCertificateData;
    }

    @JsonProperty("client-key")
    public String getClientKey() {
        return clientKey;
    }

    @JsonProperty("client-key")
    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }

    @JsonProperty("client-key-data")
    public String getClientKeyData() {
        return clientKeyData;
    }

    @JsonProperty("client-key-data")
    public void setClientKeyData(String clientKeyData) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<NamedExtension> getExtensions() {
        return extensions;
    }

    @JsonProperty("extensions")
    public void setExtensions(List<NamedExtension> extensions) {
        this.extensions = extensions;
    }

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("tokenFile")
    public String getTokenFile() {
        return tokenFile;
    }

    @JsonProperty("tokenFile")
    public void setTokenFile(String tokenFile) {
        this.tokenFile = tokenFile;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public AuthInfoBuilder edit() {
        return new AuthInfoBuilder(this);
    }

    @JsonIgnore
    public AuthInfoBuilder toBuilder() {
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
