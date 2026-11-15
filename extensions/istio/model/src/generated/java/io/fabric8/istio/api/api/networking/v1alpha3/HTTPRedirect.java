
package io.fabric8.istio.api.api.networking.v1alpha3;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * HTTPRedirect can be used to send a 301 redirect response to the caller, where the Authority/Host and the URI in the response can be swapped with the specified values. For example, the following rule redirects requests for /v1/getProductRatings API on the ratings service to /v1/bookRatings provided by the bookratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  redirect:<br><p> 	    uri: /v1/bookRatings<br><p> 	    authority: newratings.default.svc.cluster.local<br><p> 	...<br><p> <br><p> ```<br><p> <br><p> The following rule redirects requests with a path prefix of /foo to the authority foo.example.com, stripping the /foo prefix from the path:<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: foo-redirect<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- example.com<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      prefix: /foo/<br><p> 	  redirect:<br><p> 	    authority: foo.example.com<br><p> 	    prefix_rewrite: /<br><p> <br><p> ```<br><p> <br><p> With this rule, a request to example.com/foo/bar is redirected to foo.example.com/bar.
 */
@JsonDeserialize(using = io.fabric8.kubernetes.model.jackson.JsonUnwrappedDeserializer.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "RedirectPort",
    "authority",
    "prefixRewrite",
    "redirectCode",
    "scheme",
    "uri"
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
public class HTTPRedirect implements Editable<HTTPRedirectBuilder>, KubernetesResource
{

    @JsonProperty("RedirectPort")
    @JsonUnwrapped
    private IsHTTPRedirectRedirectPort redirectPort;
    @JsonProperty("authority")
    private String authority;
    @JsonProperty("prefixRewrite")
    private String prefixRewrite;
    @JsonProperty("redirectCode")
    private Long redirectCode;
    @JsonProperty("scheme")
    private String scheme;
    @JsonProperty("uri")
    private String uri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRedirect() {
    }

    public HTTPRedirect(IsHTTPRedirectRedirectPort redirectPort, String authority, String prefixRewrite, Long redirectCode, String scheme, String uri) {
        super();
        this.redirectPort = redirectPort;
        this.authority = authority;
        this.prefixRewrite = prefixRewrite;
        this.redirectCode = redirectCode;
        this.scheme = scheme;
        this.uri = uri;
    }

    /**
     * HTTPRedirect can be used to send a 301 redirect response to the caller, where the Authority/Host and the URI in the response can be swapped with the specified values. For example, the following rule redirects requests for /v1/getProductRatings API on the ratings service to /v1/bookRatings provided by the bookratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  redirect:<br><p> 	    uri: /v1/bookRatings<br><p> 	    authority: newratings.default.svc.cluster.local<br><p> 	...<br><p> <br><p> ```<br><p> <br><p> The following rule redirects requests with a path prefix of /foo to the authority foo.example.com, stripping the /foo prefix from the path:<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: foo-redirect<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- example.com<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      prefix: /foo/<br><p> 	  redirect:<br><p> 	    authority: foo.example.com<br><p> 	    prefix_rewrite: /<br><p> <br><p> ```<br><p> <br><p> With this rule, a request to example.com/foo/bar is redirected to foo.example.com/bar.
     */
    @JsonProperty("RedirectPort")
    @JsonUnwrapped
    public IsHTTPRedirectRedirectPort getRedirectPort() {
        return redirectPort;
    }

    /**
     * HTTPRedirect can be used to send a 301 redirect response to the caller, where the Authority/Host and the URI in the response can be swapped with the specified values. For example, the following rule redirects requests for /v1/getProductRatings API on the ratings service to /v1/bookRatings provided by the bookratings service.<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: ratings-route<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- ratings.prod.svc.cluster.local<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      exact: /v1/getProductRatings<br><p> 	  redirect:<br><p> 	    uri: /v1/bookRatings<br><p> 	    authority: newratings.default.svc.cluster.local<br><p> 	...<br><p> <br><p> ```<br><p> <br><p> The following rule redirects requests with a path prefix of /foo to the authority foo.example.com, stripping the /foo prefix from the path:<br><p> <br><p> ```yaml apiVersion: networking.istio.io/v1 kind: VirtualService metadata:<br><p> <br><p> 	name: foo-redirect<br><p> <br><p> spec:<br><p> <br><p> 	hosts:<br><p> 	- example.com<br><p> 	http:<br><p> 	- match:<br><p> 	  - uri:<br><p> 	      prefix: /foo/<br><p> 	  redirect:<br><p> 	    authority: foo.example.com<br><p> 	    prefix_rewrite: /<br><p> <br><p> ```<br><p> <br><p> With this rule, a request to example.com/foo/bar is redirected to foo.example.com/bar.
     */
    @JsonProperty("RedirectPort")
    public void setRedirectPort(IsHTTPRedirectRedirectPort redirectPort) {
        this.redirectPort = redirectPort;
    }

    /**
     * On a redirect, overwrite the Authority/Host portion of the URL with this value.
     */
    @JsonProperty("authority")
    public String getAuthority() {
        return authority;
    }

    /**
     * On a redirect, overwrite the Authority/Host portion of the URL with this value.
     */
    @JsonProperty("authority")
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * On a redirect, replace the matched prefix with this value. The route match must use a prefix match type. The matched prefix is stripped from the path and this value is prepended.<br><p> <br><p> Examples (route prefix match: /foo): - prefix_rewrite: /bar → /foo/baz becomes /bar/baz - prefix_rewrite: /   → /foo/baz becomes //baz (use /foo/ match to get /baz)<br><p> <br><p> Mutually exclusive with uri.
     */
    @JsonProperty("prefixRewrite")
    public String getPrefixRewrite() {
        return prefixRewrite;
    }

    /**
     * On a redirect, replace the matched prefix with this value. The route match must use a prefix match type. The matched prefix is stripped from the path and this value is prepended.<br><p> <br><p> Examples (route prefix match: /foo): - prefix_rewrite: /bar → /foo/baz becomes /bar/baz - prefix_rewrite: /   → /foo/baz becomes //baz (use /foo/ match to get /baz)<br><p> <br><p> Mutually exclusive with uri.
     */
    @JsonProperty("prefixRewrite")
    public void setPrefixRewrite(String prefixRewrite) {
        this.prefixRewrite = prefixRewrite;
    }

    /**
     * On a redirect, Specifies the HTTP status code to use in the redirect response. The default response code is MOVED_PERMANENTLY (301).
     */
    @JsonProperty("redirectCode")
    public Long getRedirectCode() {
        return redirectCode;
    }

    /**
     * On a redirect, Specifies the HTTP status code to use in the redirect response. The default response code is MOVED_PERMANENTLY (301).
     */
    @JsonProperty("redirectCode")
    public void setRedirectCode(Long redirectCode) {
        this.redirectCode = redirectCode;
    }

    /**
     * On a redirect, overwrite the scheme portion of the URL with this value. For example, `http` or `https`. If unset, the original scheme will be used. If `derivePort` is set to `FROM_PROTOCOL_DEFAULT`, this will impact the port used as well
     */
    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    /**
     * On a redirect, overwrite the scheme portion of the URL with this value. For example, `http` or `https`. If unset, the original scheme will be used. If `derivePort` is set to `FROM_PROTOCOL_DEFAULT`, this will impact the port used as well
     */
    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    /**
     * On a redirect, overwrite the Path portion of the URL with this value. Note that the entire path will be replaced, irrespective of the request URI being matched as an exact path or prefix.<br><p> <br><p> Mutually exclusive with prefix_rewrite.
     */
    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    /**
     * On a redirect, overwrite the Path portion of the URL with this value. Note that the entire path will be replaced, irrespective of the request URI being matched as an exact path or prefix.<br><p> <br><p> Mutually exclusive with prefix_rewrite.
     */
    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonIgnore
    public HTTPRedirectBuilder edit() {
        return new HTTPRedirectBuilder(this);
    }

    @JsonIgnore
    public HTTPRedirectBuilder toBuilder() {
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
        if (!(o instanceof HTTPRedirect)) {
            return false;
        }
        HTTPRedirect other = (HTTPRedirect) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$redirectPort = this.getRedirectPort();
        Object other$redirectPort = other.getRedirectPort();
        if (this$redirectPort == null ? other$redirectPort != null : !this$redirectPort.equals(other$redirectPort)) {
            return false;
        }
        Object this$authority = this.getAuthority();
        Object other$authority = other.getAuthority();
        if (this$authority == null ? other$authority != null : !this$authority.equals(other$authority)) {
            return false;
        }
        Object this$prefixRewrite = this.getPrefixRewrite();
        Object other$prefixRewrite = other.getPrefixRewrite();
        if (this$prefixRewrite == null ? other$prefixRewrite != null : !this$prefixRewrite.equals(other$prefixRewrite)) {
            return false;
        }
        Object this$redirectCode = this.getRedirectCode();
        Object other$redirectCode = other.getRedirectCode();
        if (this$redirectCode == null ? other$redirectCode != null : !this$redirectCode.equals(other$redirectCode)) {
            return false;
        }
        Object this$scheme = this.getScheme();
        Object other$scheme = other.getScheme();
        if (this$scheme == null ? other$scheme != null : !this$scheme.equals(other$scheme)) {
            return false;
        }
        Object this$uri = this.getUri();
        Object other$uri = other.getUri();
        if (this$uri == null ? other$uri != null : !this$uri.equals(other$uri)) {
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
        return other instanceof HTTPRedirect;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $redirectPort = this.getRedirectPort();
        result = result * prime + ($redirectPort == null ? 43 : $redirectPort.hashCode());
        Object $authority = this.getAuthority();
        result = result * prime + ($authority == null ? 43 : $authority.hashCode());
        Object $prefixRewrite = this.getPrefixRewrite();
        result = result * prime + ($prefixRewrite == null ? 43 : $prefixRewrite.hashCode());
        Object $redirectCode = this.getRedirectCode();
        result = result * prime + ($redirectCode == null ? 43 : $redirectCode.hashCode());
        Object $scheme = this.getScheme();
        result = result * prime + ($scheme == null ? 43 : $scheme.hashCode());
        Object $uri = this.getUri();
        result = result * prime + ($uri == null ? 43 : $uri.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPRedirect(" + "redirectPort=" + this.getRedirectPort() + ", authority=" + this.getAuthority() + ", prefixRewrite=" + this.getPrefixRewrite() + ", redirectCode=" + this.getRedirectCode() + ", scheme=" + this.getScheme() + ", uri=" + this.getUri() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
