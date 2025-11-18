
package io.fabric8.istio.api.api.security.v1beta1;

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
 * JSON Web Token (JWT) token format for authentication as defined by [RFC 7519](https://tools.ietf.org/html/rfc7519). See [OAuth 2.0](https://tools.ietf.org/html/rfc6749) and [OIDC 1.0](http://openid.net/connect) for how this is used in the whole authentication flow.<br><p> <br><p> Examples:<br><p> <br><p> Spec for a JWT that is issued by `https://example.com`, with the audience claims must be either `bookstore_android.apps.example.com` or `bookstore_web.apps.example.com`. The token should be presented at the `Authorization` header (default). The JSON Web Key Set (JWKS) will be discovered following OpenID Connect protocol.<br><p> <br><p> ```yaml issuer: https://example.com audiences:<br><p>   - bookstore_android.apps.example.com<br><p>     bookstore_web.apps.example.com<br><p> <br><p> ```<br><p> <br><p> This example specifies a token in a non-default location (`x-goog-iap-jwt-assertion` header). It also defines the URI to fetch JWKS explicitly.<br><p> <br><p> ```yaml issuer: https://example.com jwksUri: https://example.com/.secret/jwks.json fromHeaders: - "x-goog-iap-jwt-assertion" ```<br><p> <br><p> This example shows how to configure custom claims to be treated as space-delimited strings. This is useful when JWT tokens contain custom claims with multiple space-separated values that should be available for individual matching in authorization policies.<br><p> <br><p> ```yaml issuer: https://example.com spaceDelimitedClaims: - "custom_scope" - "provider.login.scope" - "roles" ```<br><p> <br><p> With this configuration, a JWT containing `"custom_scope": "read write admin"` will allow authorization policies to match against individual values like "read", "write", or "admin".
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "audiences",
    "forwardOriginalToken",
    "fromCookies",
    "fromHeaders",
    "fromParams",
    "issuer",
    "jwks",
    "jwksUri",
    "outputClaimToHeaders",
    "outputPayloadToHeader",
    "spaceDelimitedClaims",
    "timeout"
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
public class JWTRule implements Editable<JWTRuleBuilder>, KubernetesResource
{

    @JsonProperty("audiences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> audiences = new ArrayList<>();
    @JsonProperty("forwardOriginalToken")
    private Boolean forwardOriginalToken;
    @JsonProperty("fromCookies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> fromCookies = new ArrayList<>();
    @JsonProperty("fromHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JWTHeader> fromHeaders = new ArrayList<>();
    @JsonProperty("fromParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> fromParams = new ArrayList<>();
    @JsonProperty("issuer")
    private String issuer;
    @JsonProperty("jwks")
    private String jwks;
    @JsonProperty("jwksUri")
    private String jwksUri;
    @JsonProperty("outputClaimToHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClaimToHeader> outputClaimToHeaders = new ArrayList<>();
    @JsonProperty("outputPayloadToHeader")
    private String outputPayloadToHeader;
    @JsonProperty("spaceDelimitedClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> spaceDelimitedClaims = new ArrayList<>();
    @JsonProperty("timeout")
    private String timeout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public JWTRule() {
    }

    public JWTRule(List<String> audiences, Boolean forwardOriginalToken, List<String> fromCookies, List<JWTHeader> fromHeaders, List<String> fromParams, String issuer, String jwks, String jwksUri, List<ClaimToHeader> outputClaimToHeaders, String outputPayloadToHeader, List<String> spaceDelimitedClaims, String timeout) {
        super();
        this.audiences = audiences;
        this.forwardOriginalToken = forwardOriginalToken;
        this.fromCookies = fromCookies;
        this.fromHeaders = fromHeaders;
        this.fromParams = fromParams;
        this.issuer = issuer;
        this.jwks = jwks;
        this.jwksUri = jwksUri;
        this.outputClaimToHeaders = outputClaimToHeaders;
        this.outputPayloadToHeader = outputPayloadToHeader;
        this.spaceDelimitedClaims = spaceDelimitedClaims;
        this.timeout = timeout;
    }

    /**
     * The list of JWT [audiences](https://tools.ietf.org/html/rfc7519#section-4.1.3) that are allowed to access. A JWT containing any of these audiences will be accepted.<br><p> <br><p> The service name will be accepted if audiences is empty.<br><p> <br><p> Example:<br><p> <br><p> ```yaml audiences:<br><p>   - bookstore_android.apps.example.com<br><p>     bookstore_web.apps.example.com<br><p> <br><p> ```
     */
    @JsonProperty("audiences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAudiences() {
        return audiences;
    }

    /**
     * The list of JWT [audiences](https://tools.ietf.org/html/rfc7519#section-4.1.3) that are allowed to access. A JWT containing any of these audiences will be accepted.<br><p> <br><p> The service name will be accepted if audiences is empty.<br><p> <br><p> Example:<br><p> <br><p> ```yaml audiences:<br><p>   - bookstore_android.apps.example.com<br><p>     bookstore_web.apps.example.com<br><p> <br><p> ```
     */
    @JsonProperty("audiences")
    public void setAudiences(List<String> audiences) {
        this.audiences = audiences;
    }

    /**
     * If set to true, the original token will be kept for the upstream request. Default is false.
     */
    @JsonProperty("forwardOriginalToken")
    public Boolean getForwardOriginalToken() {
        return forwardOriginalToken;
    }

    /**
     * If set to true, the original token will be kept for the upstream request. Default is false.
     */
    @JsonProperty("forwardOriginalToken")
    public void setForwardOriginalToken(Boolean forwardOriginalToken) {
        this.forwardOriginalToken = forwardOriginalToken;
    }

    /**
     * List of cookie names from which JWT is expected.	// For example, if config is:<br><p> <br><p> ``` yaml<br><p> <br><p> 	fromCookies:<br><p> 	- auth-token<br><p> <br><p> ``` Then JWT will be extracted from `auth-token` cookie in the request.<br><p> <br><p> Note: Requests with multiple tokens (at different locations) are not supported, the output principal of such requests is undefined.
     */
    @JsonProperty("fromCookies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFromCookies() {
        return fromCookies;
    }

    /**
     * List of cookie names from which JWT is expected.	// For example, if config is:<br><p> <br><p> ``` yaml<br><p> <br><p> 	fromCookies:<br><p> 	- auth-token<br><p> <br><p> ``` Then JWT will be extracted from `auth-token` cookie in the request.<br><p> <br><p> Note: Requests with multiple tokens (at different locations) are not supported, the output principal of such requests is undefined.
     */
    @JsonProperty("fromCookies")
    public void setFromCookies(List<String> fromCookies) {
        this.fromCookies = fromCookies;
    }

    /**
     * List of header locations from which JWT is expected. For example, below is the location spec if JWT is expected to be found in `x-jwt-assertion` header, and have `Bearer` prefix:<br><p> <br><p> ```yaml<br><p> <br><p> 	fromHeaders:<br><p> 	- name: x-jwt-assertion<br><p> 	  prefix: "Bearer "<br><p> <br><p> ```<br><p> <br><p> Note: Requests with multiple tokens (at different locations) are not supported, the output principal of such requests is undefined.
     */
    @JsonProperty("fromHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<JWTHeader> getFromHeaders() {
        return fromHeaders;
    }

    /**
     * List of header locations from which JWT is expected. For example, below is the location spec if JWT is expected to be found in `x-jwt-assertion` header, and have `Bearer` prefix:<br><p> <br><p> ```yaml<br><p> <br><p> 	fromHeaders:<br><p> 	- name: x-jwt-assertion<br><p> 	  prefix: "Bearer "<br><p> <br><p> ```<br><p> <br><p> Note: Requests with multiple tokens (at different locations) are not supported, the output principal of such requests is undefined.
     */
    @JsonProperty("fromHeaders")
    public void setFromHeaders(List<JWTHeader> fromHeaders) {
        this.fromHeaders = fromHeaders;
    }

    /**
     * List of query parameters from which JWT is expected. For example, if JWT is provided via query parameter `my_token` (e.g `/path?my_token=&lt;JWT&gt;`), the config is:<br><p> <br><p> ```yaml<br><p> <br><p> 	fromParams:<br><p> 	- "my_token"<br><p> <br><p> ```<br><p> <br><p> Note: Requests with multiple tokens (at different locations) are not supported, the output principal of such requests is undefined.
     */
    @JsonProperty("fromParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFromParams() {
        return fromParams;
    }

    /**
     * List of query parameters from which JWT is expected. For example, if JWT is provided via query parameter `my_token` (e.g `/path?my_token=&lt;JWT&gt;`), the config is:<br><p> <br><p> ```yaml<br><p> <br><p> 	fromParams:<br><p> 	- "my_token"<br><p> <br><p> ```<br><p> <br><p> Note: Requests with multiple tokens (at different locations) are not supported, the output principal of such requests is undefined.
     */
    @JsonProperty("fromParams")
    public void setFromParams(List<String> fromParams) {
        this.fromParams = fromParams;
    }

    /**
     * Identifies the issuer that issued the JWT. See [issuer](https://tools.ietf.org/html/rfc7519#section-4.1.1) A JWT with different `iss` claim will be rejected.<br><p> <br><p> Example: `https://foobar.auth0.com` Example: `1234567-compute@developer.gserviceaccount.com`
     */
    @JsonProperty("issuer")
    public String getIssuer() {
        return issuer;
    }

    /**
     * Identifies the issuer that issued the JWT. See [issuer](https://tools.ietf.org/html/rfc7519#section-4.1.1) A JWT with different `iss` claim will be rejected.<br><p> <br><p> Example: `https://foobar.auth0.com` Example: `1234567-compute@developer.gserviceaccount.com`
     */
    @JsonProperty("issuer")
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    /**
     * JSON Web Key Set of public keys to validate signature of the JWT. See https://auth0.com/docs/jwks.<br><p> <br><p> Note: Only one of `jwksUri` and `jwks` should be used.
     */
    @JsonProperty("jwks")
    public String getJwks() {
        return jwks;
    }

    /**
     * JSON Web Key Set of public keys to validate signature of the JWT. See https://auth0.com/docs/jwks.<br><p> <br><p> Note: Only one of `jwksUri` and `jwks` should be used.
     */
    @JsonProperty("jwks")
    public void setJwks(String jwks) {
        this.jwks = jwks;
    }

    /**
     * URL of the provider's public key set to validate signature of the JWT. See [OpenID Discovery](https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderMetadata).<br><p> <br><p> Optional if the key set document can either (a) be retrieved from [OpenID Discovery](https://openid.net/specs/openid-connect-discovery-1_0.html) of the issuer or (b) inferred from the email domain of the issuer (e.g. a Google service account).<br><p> <br><p> Example: `https://www.googleapis.com/oauth2/v1/certs`<br><p> <br><p> Note: Only one of `jwksUri` and `jwks` should be used.
     */
    @JsonProperty("jwksUri")
    public String getJwksUri() {
        return jwksUri;
    }

    /**
     * URL of the provider's public key set to validate signature of the JWT. See [OpenID Discovery](https://openid.net/specs/openid-connect-discovery-1_0.html#ProviderMetadata).<br><p> <br><p> Optional if the key set document can either (a) be retrieved from [OpenID Discovery](https://openid.net/specs/openid-connect-discovery-1_0.html) of the issuer or (b) inferred from the email domain of the issuer (e.g. a Google service account).<br><p> <br><p> Example: `https://www.googleapis.com/oauth2/v1/certs`<br><p> <br><p> Note: Only one of `jwksUri` and `jwks` should be used.
     */
    @JsonProperty("jwksUri")
    public void setJwksUri(String jwksUri) {
        this.jwksUri = jwksUri;
    }

    /**
     * This field specifies a list of operations to copy the claim to HTTP headers on a successfully verified token. This differs from the `output_payload_to_header` by allowing outputting individual claims instead of the whole payload. The header specified in each operation in the list must be unique. Nested claims of type string/int/bool is supported as well. ```<br><p> <br><p> 	outputClaimToHeaders:<br><p> 	- header: x-my-company-jwt-group<br><p> 	  claim: my-group<br><p> 	- header: x-test-environment-flag<br><p> 	  claim: test-flag<br><p> 	- header: x-jwt-claim-group<br><p> 	  claim: nested.key.group<br><p> <br><p> ``` [Experimental] This feature is a experimental feature.
     */
    @JsonProperty("outputClaimToHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClaimToHeader> getOutputClaimToHeaders() {
        return outputClaimToHeaders;
    }

    /**
     * This field specifies a list of operations to copy the claim to HTTP headers on a successfully verified token. This differs from the `output_payload_to_header` by allowing outputting individual claims instead of the whole payload. The header specified in each operation in the list must be unique. Nested claims of type string/int/bool is supported as well. ```<br><p> <br><p> 	outputClaimToHeaders:<br><p> 	- header: x-my-company-jwt-group<br><p> 	  claim: my-group<br><p> 	- header: x-test-environment-flag<br><p> 	  claim: test-flag<br><p> 	- header: x-jwt-claim-group<br><p> 	  claim: nested.key.group<br><p> <br><p> ``` [Experimental] This feature is a experimental feature.
     */
    @JsonProperty("outputClaimToHeaders")
    public void setOutputClaimToHeaders(List<ClaimToHeader> outputClaimToHeaders) {
        this.outputClaimToHeaders = outputClaimToHeaders;
    }

    /**
     * This field specifies the header name to output a successfully verified JWT payload to the backend. The forwarded data is `base64_encoded(jwt_payload_in_JSON)`. If it is not specified, the payload will not be emitted.
     */
    @JsonProperty("outputPayloadToHeader")
    public String getOutputPayloadToHeader() {
        return outputPayloadToHeader;
    }

    /**
     * This field specifies the header name to output a successfully verified JWT payload to the backend. The forwarded data is `base64_encoded(jwt_payload_in_JSON)`. If it is not specified, the payload will not be emitted.
     */
    @JsonProperty("outputPayloadToHeader")
    public void setOutputPayloadToHeader(String outputPayloadToHeader) {
        this.outputPayloadToHeader = outputPayloadToHeader;
    }

    /**
     * List of JWT claim names that should be treated as space-delimited strings. These claims will be split on whitespace and each individual value will be available for matching in authorization policies. This extends the default behavior that only treats 'scope' and 'permission' claims as space-delimited.<br><p> <br><p> Example usage for custom claims: ```yaml spaceDelimitedClaims: - "custom_scope" - "provider.login.scope" - "roles" ```<br><p> <br><p> This allows authorization policies to match individual values within space-separated claim strings, maintaining compatibility with existing JWT token formats.<br><p> <br><p> Note: The default claims 'scope' and 'permission' are always treated as space-delimited regardless of this setting.
     */
    @JsonProperty("spaceDelimitedClaims")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getSpaceDelimitedClaims() {
        return spaceDelimitedClaims;
    }

    /**
     * List of JWT claim names that should be treated as space-delimited strings. These claims will be split on whitespace and each individual value will be available for matching in authorization policies. This extends the default behavior that only treats 'scope' and 'permission' claims as space-delimited.<br><p> <br><p> Example usage for custom claims: ```yaml spaceDelimitedClaims: - "custom_scope" - "provider.login.scope" - "roles" ```<br><p> <br><p> This allows authorization policies to match individual values within space-separated claim strings, maintaining compatibility with existing JWT token formats.<br><p> <br><p> Note: The default claims 'scope' and 'permission' are always treated as space-delimited regardless of this setting.
     */
    @JsonProperty("spaceDelimitedClaims")
    public void setSpaceDelimitedClaims(List<String> spaceDelimitedClaims) {
        this.spaceDelimitedClaims = spaceDelimitedClaims;
    }

    /**
     * JSON Web Token (JWT) token format for authentication as defined by [RFC 7519](https://tools.ietf.org/html/rfc7519). See [OAuth 2.0](https://tools.ietf.org/html/rfc6749) and [OIDC 1.0](http://openid.net/connect) for how this is used in the whole authentication flow.<br><p> <br><p> Examples:<br><p> <br><p> Spec for a JWT that is issued by `https://example.com`, with the audience claims must be either `bookstore_android.apps.example.com` or `bookstore_web.apps.example.com`. The token should be presented at the `Authorization` header (default). The JSON Web Key Set (JWKS) will be discovered following OpenID Connect protocol.<br><p> <br><p> ```yaml issuer: https://example.com audiences:<br><p>   - bookstore_android.apps.example.com<br><p>     bookstore_web.apps.example.com<br><p> <br><p> ```<br><p> <br><p> This example specifies a token in a non-default location (`x-goog-iap-jwt-assertion` header). It also defines the URI to fetch JWKS explicitly.<br><p> <br><p> ```yaml issuer: https://example.com jwksUri: https://example.com/.secret/jwks.json fromHeaders: - "x-goog-iap-jwt-assertion" ```<br><p> <br><p> This example shows how to configure custom claims to be treated as space-delimited strings. This is useful when JWT tokens contain custom claims with multiple space-separated values that should be available for individual matching in authorization policies.<br><p> <br><p> ```yaml issuer: https://example.com spaceDelimitedClaims: - "custom_scope" - "provider.login.scope" - "roles" ```<br><p> <br><p> With this configuration, a JWT containing `"custom_scope": "read write admin"` will allow authorization policies to match against individual values like "read", "write", or "admin".
     */
    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    /**
     * JSON Web Token (JWT) token format for authentication as defined by [RFC 7519](https://tools.ietf.org/html/rfc7519). See [OAuth 2.0](https://tools.ietf.org/html/rfc6749) and [OIDC 1.0](http://openid.net/connect) for how this is used in the whole authentication flow.<br><p> <br><p> Examples:<br><p> <br><p> Spec for a JWT that is issued by `https://example.com`, with the audience claims must be either `bookstore_android.apps.example.com` or `bookstore_web.apps.example.com`. The token should be presented at the `Authorization` header (default). The JSON Web Key Set (JWKS) will be discovered following OpenID Connect protocol.<br><p> <br><p> ```yaml issuer: https://example.com audiences:<br><p>   - bookstore_android.apps.example.com<br><p>     bookstore_web.apps.example.com<br><p> <br><p> ```<br><p> <br><p> This example specifies a token in a non-default location (`x-goog-iap-jwt-assertion` header). It also defines the URI to fetch JWKS explicitly.<br><p> <br><p> ```yaml issuer: https://example.com jwksUri: https://example.com/.secret/jwks.json fromHeaders: - "x-goog-iap-jwt-assertion" ```<br><p> <br><p> This example shows how to configure custom claims to be treated as space-delimited strings. This is useful when JWT tokens contain custom claims with multiple space-separated values that should be available for individual matching in authorization policies.<br><p> <br><p> ```yaml issuer: https://example.com spaceDelimitedClaims: - "custom_scope" - "provider.login.scope" - "roles" ```<br><p> <br><p> With this configuration, a JWT containing `"custom_scope": "read write admin"` will allow authorization policies to match against individual values like "read", "write", or "admin".
     */
    @JsonProperty("timeout")
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    @JsonIgnore
    public JWTRuleBuilder edit() {
        return new JWTRuleBuilder(this);
    }

    @JsonIgnore
    public JWTRuleBuilder toBuilder() {
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
