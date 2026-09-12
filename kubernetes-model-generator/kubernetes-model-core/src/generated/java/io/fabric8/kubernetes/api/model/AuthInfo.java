
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
        if (!(o instanceof AuthInfo)) {
            return false;
        }
        AuthInfo other = (AuthInfo) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$as = this.getAs();
        Object other$as = other.getAs();
        if (this$as == null ? other$as != null : !this$as.equals(other$as)) {
            return false;
        }
        Object this$asGroups = this.getAsGroups();
        Object other$asGroups = other.getAsGroups();
        if (this$asGroups == null ? other$asGroups != null : !this$asGroups.equals(other$asGroups)) {
            return false;
        }
        Object this$asUid = this.getAsUid();
        Object other$asUid = other.getAsUid();
        if (this$asUid == null ? other$asUid != null : !this$asUid.equals(other$asUid)) {
            return false;
        }
        Object this$asUserExtra = this.getAsUserExtra();
        Object other$asUserExtra = other.getAsUserExtra();
        if (this$asUserExtra == null ? other$asUserExtra != null : !this$asUserExtra.equals(other$asUserExtra)) {
            return false;
        }
        Object this$authProvider = this.getAuthProvider();
        Object other$authProvider = other.getAuthProvider();
        if (this$authProvider == null ? other$authProvider != null : !this$authProvider.equals(other$authProvider)) {
            return false;
        }
        Object this$clientCertificate = this.getClientCertificate();
        Object other$clientCertificate = other.getClientCertificate();
        if (this$clientCertificate == null ? other$clientCertificate != null : !this$clientCertificate.equals(other$clientCertificate)) {
            return false;
        }
        Object this$clientCertificateData = this.getClientCertificateData();
        Object other$clientCertificateData = other.getClientCertificateData();
        if (this$clientCertificateData == null ? other$clientCertificateData != null : !this$clientCertificateData.equals(other$clientCertificateData)) {
            return false;
        }
        Object this$clientKey = this.getClientKey();
        Object other$clientKey = other.getClientKey();
        if (this$clientKey == null ? other$clientKey != null : !this$clientKey.equals(other$clientKey)) {
            return false;
        }
        Object this$clientKeyData = this.getClientKeyData();
        Object other$clientKeyData = other.getClientKeyData();
        if (this$clientKeyData == null ? other$clientKeyData != null : !this$clientKeyData.equals(other$clientKeyData)) {
            return false;
        }
        Object this$exec = this.getExec();
        Object other$exec = other.getExec();
        if (this$exec == null ? other$exec != null : !this$exec.equals(other$exec)) {
            return false;
        }
        Object this$extensions = this.getExtensions();
        Object other$extensions = other.getExtensions();
        if (this$extensions == null ? other$extensions != null : !this$extensions.equals(other$extensions)) {
            return false;
        }
        Object this$password = this.getPassword();
        Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        Object this$token = this.getToken();
        Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) {
            return false;
        }
        Object this$tokenFile = this.getTokenFile();
        Object other$tokenFile = other.getTokenFile();
        if (this$tokenFile == null ? other$tokenFile != null : !this$tokenFile.equals(other$tokenFile)) {
            return false;
        }
        Object this$username = this.getUsername();
        Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) {
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
        return other instanceof AuthInfo;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $as = this.getAs();
        result = result * prime + ($as == null ? 43 : $as.hashCode());
        Object $asGroups = this.getAsGroups();
        result = result * prime + ($asGroups == null ? 43 : $asGroups.hashCode());
        Object $asUid = this.getAsUid();
        result = result * prime + ($asUid == null ? 43 : $asUid.hashCode());
        Object $asUserExtra = this.getAsUserExtra();
        result = result * prime + ($asUserExtra == null ? 43 : $asUserExtra.hashCode());
        Object $authProvider = this.getAuthProvider();
        result = result * prime + ($authProvider == null ? 43 : $authProvider.hashCode());
        Object $clientCertificate = this.getClientCertificate();
        result = result * prime + ($clientCertificate == null ? 43 : $clientCertificate.hashCode());
        Object $clientCertificateData = this.getClientCertificateData();
        result = result * prime + ($clientCertificateData == null ? 43 : $clientCertificateData.hashCode());
        Object $clientKey = this.getClientKey();
        result = result * prime + ($clientKey == null ? 43 : $clientKey.hashCode());
        Object $clientKeyData = this.getClientKeyData();
        result = result * prime + ($clientKeyData == null ? 43 : $clientKeyData.hashCode());
        Object $exec = this.getExec();
        result = result * prime + ($exec == null ? 43 : $exec.hashCode());
        Object $extensions = this.getExtensions();
        result = result * prime + ($extensions == null ? 43 : $extensions.hashCode());
        Object $password = this.getPassword();
        result = result * prime + ($password == null ? 43 : $password.hashCode());
        Object $token = this.getToken();
        result = result * prime + ($token == null ? 43 : $token.hashCode());
        Object $tokenFile = this.getTokenFile();
        result = result * prime + ($tokenFile == null ? 43 : $tokenFile.hashCode());
        Object $username = this.getUsername();
        result = result * prime + ($username == null ? 43 : $username.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AuthInfo(" + "as=" + this.getAs() + ", asGroups=" + this.getAsGroups() + ", asUid=" + this.getAsUid() + ", asUserExtra=" + this.getAsUserExtra() + ", authProvider=" + this.getAuthProvider() + ", clientCertificate=" + this.getClientCertificate() + ", clientCertificateData=" + this.getClientCertificateData() + ", clientKey=" + this.getClientKey() + ", clientKeyData=" + this.getClientKeyData() + ", exec=" + this.getExec() + ", extensions=" + this.getExtensions() + ", password=" + this.getPassword() + ", token=" + this.getToken() + ", tokenFile=" + this.getTokenFile() + ", username=" + this.getUsername() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
