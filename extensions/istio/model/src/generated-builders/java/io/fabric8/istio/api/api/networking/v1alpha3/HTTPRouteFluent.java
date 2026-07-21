package io.fabric8.istio.api.api.networking.v1alpha3;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Double;
import java.lang.Integer;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class HTTPRouteFluent<A extends io.fabric8.istio.api.api.networking.v1alpha3.HTTPRouteFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private CorsPolicyBuilder corsPolicy;
  private DelegateBuilder delegate;
  private HTTPDirectResponseBuilder directResponse;
  private HTTPFaultInjectionBuilder fault;
  private HeadersBuilder headers;
  private ArrayList<HTTPMatchRequestBuilder> match = new ArrayList<HTTPMatchRequestBuilder>();
  private DestinationBuilder mirror;
  private Integer mirrorPercent;
  private PercentBuilder mirrorPercentage;
  private ArrayList<HTTPMirrorPolicyBuilder> mirrors = new ArrayList<HTTPMirrorPolicyBuilder>();
  private String name;
  private HTTPRedirectBuilder redirect;
  private HTTPRetryBuilder retries;
  private HTTPRewriteBuilder rewrite;
  private ArrayList<HTTPRouteDestinationBuilder> route = new ArrayList<HTTPRouteDestinationBuilder>();
  private String timeout;

  public HTTPRouteFluent() {
  }
  
  public HTTPRouteFluent(HTTPRoute instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatch(Collection<HTTPMatchRequest> items) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    for (HTTPMatchRequest item : items) {
        HTTPMatchRequestBuilder builder = new HTTPMatchRequestBuilder(item);
        _visitables.get("match").add(builder);
        this.match.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMirrors(Collection<HTTPMirrorPolicy> items) {
    if (this.mirrors == null) {
      this.mirrors = new ArrayList();
    }
    for (HTTPMirrorPolicy item : items) {
        HTTPMirrorPolicyBuilder builder = new HTTPMirrorPolicyBuilder(item);
        _visitables.get("mirrors").add(builder);
        this.mirrors.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToRoute(Collection<HTTPRouteDestination> items) {
    if (this.route == null) {
      this.route = new ArrayList();
    }
    for (HTTPRouteDestination item : items) {
        HTTPRouteDestinationBuilder builder = new HTTPRouteDestinationBuilder(item);
        _visitables.get("route").add(builder);
        this.route.add(builder);
    }
    return (A) this;
  }
  
  public MatchNested<A> addNewMatch() {
    return new MatchNested(-1, null);
  }
  
  public MatchNested<A> addNewMatchLike(HTTPMatchRequest item) {
    return new MatchNested(-1, item);
  }
  
  public MirrorsNested<A> addNewMirror() {
    return new MirrorsNested(-1, null);
  }
  
  public MirrorsNested<A> addNewMirrorLike(HTTPMirrorPolicy item) {
    return new MirrorsNested(-1, item);
  }
  
  public RouteNested<A> addNewRoute() {
    return new RouteNested(-1, null);
  }
  
  public RouteNested<A> addNewRouteLike(HTTPRouteDestination item) {
    return new RouteNested(-1, item);
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToMatch(HTTPMatchRequest... items) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    for (HTTPMatchRequest item : items) {
        HTTPMatchRequestBuilder builder = new HTTPMatchRequestBuilder(item);
        _visitables.get("match").add(builder);
        this.match.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatch(int index,HTTPMatchRequest item) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    HTTPMatchRequestBuilder builder = new HTTPMatchRequestBuilder(item);
    if (index < 0 || index >= match.size()) {
        _visitables.get("match").add(builder);
        match.add(builder);
    } else {
        _visitables.get("match").add(builder);
        match.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMirrors(HTTPMirrorPolicy... items) {
    if (this.mirrors == null) {
      this.mirrors = new ArrayList();
    }
    for (HTTPMirrorPolicy item : items) {
        HTTPMirrorPolicyBuilder builder = new HTTPMirrorPolicyBuilder(item);
        _visitables.get("mirrors").add(builder);
        this.mirrors.add(builder);
    }
    return (A) this;
  }
  
  public A addToMirrors(int index,HTTPMirrorPolicy item) {
    if (this.mirrors == null) {
      this.mirrors = new ArrayList();
    }
    HTTPMirrorPolicyBuilder builder = new HTTPMirrorPolicyBuilder(item);
    if (index < 0 || index >= mirrors.size()) {
        _visitables.get("mirrors").add(builder);
        mirrors.add(builder);
    } else {
        _visitables.get("mirrors").add(builder);
        mirrors.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToRoute(HTTPRouteDestination... items) {
    if (this.route == null) {
      this.route = new ArrayList();
    }
    for (HTTPRouteDestination item : items) {
        HTTPRouteDestinationBuilder builder = new HTTPRouteDestinationBuilder(item);
        _visitables.get("route").add(builder);
        this.route.add(builder);
    }
    return (A) this;
  }
  
  public A addToRoute(int index,HTTPRouteDestination item) {
    if (this.route == null) {
      this.route = new ArrayList();
    }
    HTTPRouteDestinationBuilder builder = new HTTPRouteDestinationBuilder(item);
    if (index < 0 || index >= route.size()) {
        _visitables.get("route").add(builder);
        route.add(builder);
    } else {
        _visitables.get("route").add(builder);
        route.add(index, builder);
    }
    return (A) this;
  }
  
  public CorsPolicy buildCorsPolicy() {
    return this.corsPolicy != null ? this.corsPolicy.build() : null;
  }
  
  public Delegate buildDelegate() {
    return this.delegate != null ? this.delegate.build() : null;
  }
  
  public HTTPDirectResponse buildDirectResponse() {
    return this.directResponse != null ? this.directResponse.build() : null;
  }
  
  public HTTPFaultInjection buildFault() {
    return this.fault != null ? this.fault.build() : null;
  }
  
  public HTTPMatchRequest buildFirstMatch() {
    return this.match.get(0).build();
  }
  
  public HTTPMirrorPolicy buildFirstMirror() {
    return this.mirrors.get(0).build();
  }
  
  public HTTPRouteDestination buildFirstRoute() {
    return this.route.get(0).build();
  }
  
  public Headers buildHeaders() {
    return this.headers != null ? this.headers.build() : null;
  }
  
  public HTTPMatchRequest buildLastMatch() {
    return this.match.get(match.size() - 1).build();
  }
  
  public HTTPMirrorPolicy buildLastMirror() {
    return this.mirrors.get(mirrors.size() - 1).build();
  }
  
  public HTTPRouteDestination buildLastRoute() {
    return this.route.get(route.size() - 1).build();
  }
  
  public List<HTTPMatchRequest> buildMatch() {
    return this.match != null ? build(match) : null;
  }
  
  public HTTPMatchRequest buildMatch(int index) {
    return this.match.get(index).build();
  }
  
  public HTTPMatchRequest buildMatchingMatch(Predicate<HTTPMatchRequestBuilder> predicate) {
      for (HTTPMatchRequestBuilder item : match) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HTTPMirrorPolicy buildMatchingMirror(Predicate<HTTPMirrorPolicyBuilder> predicate) {
      for (HTTPMirrorPolicyBuilder item : mirrors) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HTTPRouteDestination buildMatchingRoute(Predicate<HTTPRouteDestinationBuilder> predicate) {
      for (HTTPRouteDestinationBuilder item : route) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Destination buildMirror() {
    return this.mirror != null ? this.mirror.build() : null;
  }
  
  public HTTPMirrorPolicy buildMirror(int index) {
    return this.mirrors.get(index).build();
  }
  
  public Percent buildMirrorPercentage() {
    return this.mirrorPercentage != null ? this.mirrorPercentage.build() : null;
  }
  
  public List<HTTPMirrorPolicy> buildMirrors() {
    return this.mirrors != null ? build(mirrors) : null;
  }
  
  public HTTPRedirect buildRedirect() {
    return this.redirect != null ? this.redirect.build() : null;
  }
  
  public HTTPRetry buildRetries() {
    return this.retries != null ? this.retries.build() : null;
  }
  
  public HTTPRewrite buildRewrite() {
    return this.rewrite != null ? this.rewrite.build() : null;
  }
  
  public List<HTTPRouteDestination> buildRoute() {
    return this.route != null ? build(route) : null;
  }
  
  public HTTPRouteDestination buildRoute(int index) {
    return this.route.get(index).build();
  }
  
  protected void copyInstance(HTTPRoute instance) {
    instance = instance != null ? instance : new HTTPRoute();
    if (instance != null) {
        this.withCorsPolicy(instance.getCorsPolicy());
        this.withDelegate(instance.getDelegate());
        this.withDirectResponse(instance.getDirectResponse());
        this.withFault(instance.getFault());
        this.withHeaders(instance.getHeaders());
        this.withMatch(instance.getMatch());
        this.withMirror(instance.getMirror());
        this.withMirrorPercent(instance.getMirrorPercent());
        this.withMirrorPercentage(instance.getMirrorPercentage());
        this.withMirrors(instance.getMirrors());
        this.withName(instance.getName());
        this.withRedirect(instance.getRedirect());
        this.withRetries(instance.getRetries());
        this.withRewrite(instance.getRewrite());
        this.withRoute(instance.getRoute());
        this.withTimeout(instance.getTimeout());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public CorsPolicyNested<A> editCorsPolicy() {
    return this.withNewCorsPolicyLike(Optional.ofNullable(this.buildCorsPolicy()).orElse(null));
  }
  
  public DelegateNested<A> editDelegate() {
    return this.withNewDelegateLike(Optional.ofNullable(this.buildDelegate()).orElse(null));
  }
  
  public DirectResponseNested<A> editDirectResponse() {
    return this.withNewDirectResponseLike(Optional.ofNullable(this.buildDirectResponse()).orElse(null));
  }
  
  public FaultNested<A> editFault() {
    return this.withNewFaultLike(Optional.ofNullable(this.buildFault()).orElse(null));
  }
  
  public MatchNested<A> editFirstMatch() {
    if (match.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "match"));
    }
    return this.setNewMatchLike(0, this.buildMatch(0));
  }
  
  public MirrorsNested<A> editFirstMirror() {
    if (mirrors.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "mirrors"));
    }
    return this.setNewMirrorLike(0, this.buildMirror(0));
  }
  
  public RouteNested<A> editFirstRoute() {
    if (route.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "route"));
    }
    return this.setNewRouteLike(0, this.buildRoute(0));
  }
  
  public HeadersNested<A> editHeaders() {
    return this.withNewHeadersLike(Optional.ofNullable(this.buildHeaders()).orElse(null));
  }
  
  public MatchNested<A> editLastMatch() {
    int index = match.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public MirrorsNested<A> editLastMirror() {
    int index = mirrors.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "mirrors"));
    }
    return this.setNewMirrorLike(index, this.buildMirror(index));
  }
  
  public RouteNested<A> editLastRoute() {
    int index = route.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "route"));
    }
    return this.setNewRouteLike(index, this.buildRoute(index));
  }
  
  public MatchNested<A> editMatch(int index) {
    if (match.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public MatchNested<A> editMatchingMatch(Predicate<HTTPMatchRequestBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < match.size();i++) {
      if (predicate.test(match.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "match"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public MirrorsNested<A> editMatchingMirror(Predicate<HTTPMirrorPolicyBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < mirrors.size();i++) {
      if (predicate.test(mirrors.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "mirrors"));
    }
    return this.setNewMirrorLike(index, this.buildMirror(index));
  }
  
  public RouteNested<A> editMatchingRoute(Predicate<HTTPRouteDestinationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < route.size();i++) {
      if (predicate.test(route.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "route"));
    }
    return this.setNewRouteLike(index, this.buildRoute(index));
  }
  
  public MirrorNested<A> editMirror() {
    return this.withNewMirrorLike(Optional.ofNullable(this.buildMirror()).orElse(null));
  }
  
  public MirrorsNested<A> editMirror(int index) {
    if (mirrors.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "mirrors"));
    }
    return this.setNewMirrorLike(index, this.buildMirror(index));
  }
  
  public MirrorPercentageNested<A> editMirrorPercentage() {
    return this.withNewMirrorPercentageLike(Optional.ofNullable(this.buildMirrorPercentage()).orElse(null));
  }
  
  public CorsPolicyNested<A> editOrNewCorsPolicy() {
    return this.withNewCorsPolicyLike(Optional.ofNullable(this.buildCorsPolicy()).orElse(new CorsPolicyBuilder().build()));
  }
  
  public CorsPolicyNested<A> editOrNewCorsPolicyLike(CorsPolicy item) {
    return this.withNewCorsPolicyLike(Optional.ofNullable(this.buildCorsPolicy()).orElse(item));
  }
  
  public DelegateNested<A> editOrNewDelegate() {
    return this.withNewDelegateLike(Optional.ofNullable(this.buildDelegate()).orElse(new DelegateBuilder().build()));
  }
  
  public DelegateNested<A> editOrNewDelegateLike(Delegate item) {
    return this.withNewDelegateLike(Optional.ofNullable(this.buildDelegate()).orElse(item));
  }
  
  public DirectResponseNested<A> editOrNewDirectResponse() {
    return this.withNewDirectResponseLike(Optional.ofNullable(this.buildDirectResponse()).orElse(new HTTPDirectResponseBuilder().build()));
  }
  
  public DirectResponseNested<A> editOrNewDirectResponseLike(HTTPDirectResponse item) {
    return this.withNewDirectResponseLike(Optional.ofNullable(this.buildDirectResponse()).orElse(item));
  }
  
  public FaultNested<A> editOrNewFault() {
    return this.withNewFaultLike(Optional.ofNullable(this.buildFault()).orElse(new HTTPFaultInjectionBuilder().build()));
  }
  
  public FaultNested<A> editOrNewFaultLike(HTTPFaultInjection item) {
    return this.withNewFaultLike(Optional.ofNullable(this.buildFault()).orElse(item));
  }
  
  public HeadersNested<A> editOrNewHeaders() {
    return this.withNewHeadersLike(Optional.ofNullable(this.buildHeaders()).orElse(new HeadersBuilder().build()));
  }
  
  public HeadersNested<A> editOrNewHeadersLike(Headers item) {
    return this.withNewHeadersLike(Optional.ofNullable(this.buildHeaders()).orElse(item));
  }
  
  public MirrorNested<A> editOrNewMirror() {
    return this.withNewMirrorLike(Optional.ofNullable(this.buildMirror()).orElse(new DestinationBuilder().build()));
  }
  
  public MirrorNested<A> editOrNewMirrorLike(Destination item) {
    return this.withNewMirrorLike(Optional.ofNullable(this.buildMirror()).orElse(item));
  }
  
  public MirrorPercentageNested<A> editOrNewMirrorPercentage() {
    return this.withNewMirrorPercentageLike(Optional.ofNullable(this.buildMirrorPercentage()).orElse(new PercentBuilder().build()));
  }
  
  public MirrorPercentageNested<A> editOrNewMirrorPercentageLike(Percent item) {
    return this.withNewMirrorPercentageLike(Optional.ofNullable(this.buildMirrorPercentage()).orElse(item));
  }
  
  public RedirectNested<A> editOrNewRedirect() {
    return this.withNewRedirectLike(Optional.ofNullable(this.buildRedirect()).orElse(new HTTPRedirectBuilder().build()));
  }
  
  public RedirectNested<A> editOrNewRedirectLike(HTTPRedirect item) {
    return this.withNewRedirectLike(Optional.ofNullable(this.buildRedirect()).orElse(item));
  }
  
  public RetriesNested<A> editOrNewRetries() {
    return this.withNewRetriesLike(Optional.ofNullable(this.buildRetries()).orElse(new HTTPRetryBuilder().build()));
  }
  
  public RetriesNested<A> editOrNewRetriesLike(HTTPRetry item) {
    return this.withNewRetriesLike(Optional.ofNullable(this.buildRetries()).orElse(item));
  }
  
  public RewriteNested<A> editOrNewRewrite() {
    return this.withNewRewriteLike(Optional.ofNullable(this.buildRewrite()).orElse(new HTTPRewriteBuilder().build()));
  }
  
  public RewriteNested<A> editOrNewRewriteLike(HTTPRewrite item) {
    return this.withNewRewriteLike(Optional.ofNullable(this.buildRewrite()).orElse(item));
  }
  
  public RedirectNested<A> editRedirect() {
    return this.withNewRedirectLike(Optional.ofNullable(this.buildRedirect()).orElse(null));
  }
  
  public RetriesNested<A> editRetries() {
    return this.withNewRetriesLike(Optional.ofNullable(this.buildRetries()).orElse(null));
  }
  
  public RewriteNested<A> editRewrite() {
    return this.withNewRewriteLike(Optional.ofNullable(this.buildRewrite()).orElse(null));
  }
  
  public RouteNested<A> editRoute(int index) {
    if (route.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "route"));
    }
    return this.setNewRouteLike(index, this.buildRoute(index));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    HTTPRouteFluent that = (HTTPRouteFluent) o;
    if (!(Objects.equals(corsPolicy, that.corsPolicy))) {
      return false;
    }
    if (!(Objects.equals(delegate, that.delegate))) {
      return false;
    }
    if (!(Objects.equals(directResponse, that.directResponse))) {
      return false;
    }
    if (!(Objects.equals(fault, that.fault))) {
      return false;
    }
    if (!(Objects.equals(headers, that.headers))) {
      return false;
    }
    if (!(Objects.equals(match, that.match))) {
      return false;
    }
    if (!(Objects.equals(mirror, that.mirror))) {
      return false;
    }
    if (!(Objects.equals(mirrorPercent, that.mirrorPercent))) {
      return false;
    }
    if (!(Objects.equals(mirrorPercentage, that.mirrorPercentage))) {
      return false;
    }
    if (!(Objects.equals(mirrors, that.mirrors))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(redirect, that.redirect))) {
      return false;
    }
    if (!(Objects.equals(retries, that.retries))) {
      return false;
    }
    if (!(Objects.equals(rewrite, that.rewrite))) {
      return false;
    }
    if (!(Objects.equals(route, that.route))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Integer getMirrorPercent() {
    return this.mirrorPercent;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getTimeout() {
    return this.timeout;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasCorsPolicy() {
    return this.corsPolicy != null;
  }
  
  public boolean hasDelegate() {
    return this.delegate != null;
  }
  
  public boolean hasDirectResponse() {
    return this.directResponse != null;
  }
  
  public boolean hasFault() {
    return this.fault != null;
  }
  
  public boolean hasHeaders() {
    return this.headers != null;
  }
  
  public boolean hasMatch() {
    return this.match != null && !(this.match.isEmpty());
  }
  
  public boolean hasMatchingMatch(Predicate<HTTPMatchRequestBuilder> predicate) {
      for (HTTPMatchRequestBuilder item : match) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMirror(Predicate<HTTPMirrorPolicyBuilder> predicate) {
      for (HTTPMirrorPolicyBuilder item : mirrors) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingRoute(Predicate<HTTPRouteDestinationBuilder> predicate) {
      for (HTTPRouteDestinationBuilder item : route) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMirror() {
    return this.mirror != null;
  }
  
  public boolean hasMirrorPercent() {
    return this.mirrorPercent != null;
  }
  
  public boolean hasMirrorPercentage() {
    return this.mirrorPercentage != null;
  }
  
  public boolean hasMirrors() {
    return this.mirrors != null && !(this.mirrors.isEmpty());
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasRedirect() {
    return this.redirect != null;
  }
  
  public boolean hasRetries() {
    return this.retries != null;
  }
  
  public boolean hasRewrite() {
    return this.rewrite != null;
  }
  
  public boolean hasRoute() {
    return this.route != null && !(this.route.isEmpty());
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public int hashCode() {
    return Objects.hash(corsPolicy, delegate, directResponse, fault, headers, match, mirror, mirrorPercent, mirrorPercentage, mirrors, name, redirect, retries, rewrite, route, timeout, additionalProperties);
  }
  
  public A removeAllFromMatch(Collection<HTTPMatchRequest> items) {
    if (this.match == null) {
      return (A) this;
    }
    for (HTTPMatchRequest item : items) {
        HTTPMatchRequestBuilder builder = new HTTPMatchRequestBuilder(item);
        _visitables.get("match").remove(builder);
        this.match.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMirrors(Collection<HTTPMirrorPolicy> items) {
    if (this.mirrors == null) {
      return (A) this;
    }
    for (HTTPMirrorPolicy item : items) {
        HTTPMirrorPolicyBuilder builder = new HTTPMirrorPolicyBuilder(item);
        _visitables.get("mirrors").remove(builder);
        this.mirrors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromRoute(Collection<HTTPRouteDestination> items) {
    if (this.route == null) {
      return (A) this;
    }
    for (HTTPRouteDestination item : items) {
        HTTPRouteDestinationBuilder builder = new HTTPRouteDestinationBuilder(item);
        _visitables.get("route").remove(builder);
        this.route.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromMatch(HTTPMatchRequest... items) {
    if (this.match == null) {
      return (A) this;
    }
    for (HTTPMatchRequest item : items) {
        HTTPMatchRequestBuilder builder = new HTTPMatchRequestBuilder(item);
        _visitables.get("match").remove(builder);
        this.match.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMirrors(HTTPMirrorPolicy... items) {
    if (this.mirrors == null) {
      return (A) this;
    }
    for (HTTPMirrorPolicy item : items) {
        HTTPMirrorPolicyBuilder builder = new HTTPMirrorPolicyBuilder(item);
        _visitables.get("mirrors").remove(builder);
        this.mirrors.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromRoute(HTTPRouteDestination... items) {
    if (this.route == null) {
      return (A) this;
    }
    for (HTTPRouteDestination item : items) {
        HTTPRouteDestinationBuilder builder = new HTTPRouteDestinationBuilder(item);
        _visitables.get("route").remove(builder);
        this.route.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatch(Predicate<HTTPMatchRequestBuilder> predicate) {
    if (match == null) {
      return (A) this;
    }
    Iterator<HTTPMatchRequestBuilder> each = match.iterator();
    List visitables = _visitables.get("match");
    while (each.hasNext()) {
        HTTPMatchRequestBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromMirrors(Predicate<HTTPMirrorPolicyBuilder> predicate) {
    if (mirrors == null) {
      return (A) this;
    }
    Iterator<HTTPMirrorPolicyBuilder> each = mirrors.iterator();
    List visitables = _visitables.get("mirrors");
    while (each.hasNext()) {
        HTTPMirrorPolicyBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromRoute(Predicate<HTTPRouteDestinationBuilder> predicate) {
    if (route == null) {
      return (A) this;
    }
    Iterator<HTTPRouteDestinationBuilder> each = route.iterator();
    List visitables = _visitables.get("route");
    while (each.hasNext()) {
        HTTPRouteDestinationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MatchNested<A> setNewMatchLike(int index,HTTPMatchRequest item) {
    return new MatchNested(index, item);
  }
  
  public MirrorsNested<A> setNewMirrorLike(int index,HTTPMirrorPolicy item) {
    return new MirrorsNested(index, item);
  }
  
  public RouteNested<A> setNewRouteLike(int index,HTTPRouteDestination item) {
    return new RouteNested(index, item);
  }
  
  public A setToMatch(int index,HTTPMatchRequest item) {
    if (this.match == null) {
      this.match = new ArrayList();
    }
    HTTPMatchRequestBuilder builder = new HTTPMatchRequestBuilder(item);
    if (index < 0 || index >= match.size()) {
        _visitables.get("match").add(builder);
        match.add(builder);
    } else {
        _visitables.get("match").add(builder);
        match.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMirrors(int index,HTTPMirrorPolicy item) {
    if (this.mirrors == null) {
      this.mirrors = new ArrayList();
    }
    HTTPMirrorPolicyBuilder builder = new HTTPMirrorPolicyBuilder(item);
    if (index < 0 || index >= mirrors.size()) {
        _visitables.get("mirrors").add(builder);
        mirrors.add(builder);
    } else {
        _visitables.get("mirrors").add(builder);
        mirrors.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToRoute(int index,HTTPRouteDestination item) {
    if (this.route == null) {
      this.route = new ArrayList();
    }
    HTTPRouteDestinationBuilder builder = new HTTPRouteDestinationBuilder(item);
    if (index < 0 || index >= route.size()) {
        _visitables.get("route").add(builder);
        route.add(builder);
    } else {
        _visitables.get("route").add(builder);
        route.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(corsPolicy == null)) {
        sb.append("corsPolicy:");
        sb.append(corsPolicy);
        sb.append(",");
    }
    if (!(delegate == null)) {
        sb.append("delegate:");
        sb.append(delegate);
        sb.append(",");
    }
    if (!(directResponse == null)) {
        sb.append("directResponse:");
        sb.append(directResponse);
        sb.append(",");
    }
    if (!(fault == null)) {
        sb.append("fault:");
        sb.append(fault);
        sb.append(",");
    }
    if (!(headers == null)) {
        sb.append("headers:");
        sb.append(headers);
        sb.append(",");
    }
    if (!(match == null) && !(match.isEmpty())) {
        sb.append("match:");
        sb.append(match);
        sb.append(",");
    }
    if (!(mirror == null)) {
        sb.append("mirror:");
        sb.append(mirror);
        sb.append(",");
    }
    if (!(mirrorPercent == null)) {
        sb.append("mirrorPercent:");
        sb.append(mirrorPercent);
        sb.append(",");
    }
    if (!(mirrorPercentage == null)) {
        sb.append("mirrorPercentage:");
        sb.append(mirrorPercentage);
        sb.append(",");
    }
    if (!(mirrors == null) && !(mirrors.isEmpty())) {
        sb.append("mirrors:");
        sb.append(mirrors);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(redirect == null)) {
        sb.append("redirect:");
        sb.append(redirect);
        sb.append(",");
    }
    if (!(retries == null)) {
        sb.append("retries:");
        sb.append(retries);
        sb.append(",");
    }
    if (!(rewrite == null)) {
        sb.append("rewrite:");
        sb.append(rewrite);
        sb.append(",");
    }
    if (!(route == null) && !(route.isEmpty())) {
        sb.append("route:");
        sb.append(route);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withCorsPolicy(CorsPolicy corsPolicy) {
    this._visitables.remove("corsPolicy");
    if (corsPolicy != null) {
        this.corsPolicy = new CorsPolicyBuilder(corsPolicy);
        this._visitables.get("corsPolicy").add(this.corsPolicy);
    } else {
        this.corsPolicy = null;
        this._visitables.get("corsPolicy").remove(this.corsPolicy);
    }
    return (A) this;
  }
  
  public A withDelegate(Delegate delegate) {
    this._visitables.remove("delegate");
    if (delegate != null) {
        this.delegate = new DelegateBuilder(delegate);
        this._visitables.get("delegate").add(this.delegate);
    } else {
        this.delegate = null;
        this._visitables.get("delegate").remove(this.delegate);
    }
    return (A) this;
  }
  
  public A withDirectResponse(HTTPDirectResponse directResponse) {
    this._visitables.remove("directResponse");
    if (directResponse != null) {
        this.directResponse = new HTTPDirectResponseBuilder(directResponse);
        this._visitables.get("directResponse").add(this.directResponse);
    } else {
        this.directResponse = null;
        this._visitables.get("directResponse").remove(this.directResponse);
    }
    return (A) this;
  }
  
  public A withFault(HTTPFaultInjection fault) {
    this._visitables.remove("fault");
    if (fault != null) {
        this.fault = new HTTPFaultInjectionBuilder(fault);
        this._visitables.get("fault").add(this.fault);
    } else {
        this.fault = null;
        this._visitables.get("fault").remove(this.fault);
    }
    return (A) this;
  }
  
  public A withHeaders(Headers headers) {
    this._visitables.remove("headers");
    if (headers != null) {
        this.headers = new HeadersBuilder(headers);
        this._visitables.get("headers").add(this.headers);
    } else {
        this.headers = null;
        this._visitables.get("headers").remove(this.headers);
    }
    return (A) this;
  }
  
  public A withMatch(List<HTTPMatchRequest> match) {
    if (this.match != null) {
      this._visitables.get("match").clear();
    }
    if (match != null) {
        this.match = new ArrayList();
        for (HTTPMatchRequest item : match) {
          this.addToMatch(item);
        }
    } else {
      this.match = null;
    }
    return (A) this;
  }
  
  public A withMatch(HTTPMatchRequest... match) {
    if (this.match != null) {
        this.match.clear();
        _visitables.remove("match");
    }
    if (match != null) {
      for (HTTPMatchRequest item : match) {
        this.addToMatch(item);
      }
    }
    return (A) this;
  }
  
  public A withMirror(Destination mirror) {
    this._visitables.remove("mirror");
    if (mirror != null) {
        this.mirror = new DestinationBuilder(mirror);
        this._visitables.get("mirror").add(this.mirror);
    } else {
        this.mirror = null;
        this._visitables.get("mirror").remove(this.mirror);
    }
    return (A) this;
  }
  
  public A withMirrorPercent(Integer mirrorPercent) {
    this.mirrorPercent = mirrorPercent;
    return (A) this;
  }
  
  public A withMirrorPercentage(Percent mirrorPercentage) {
    this._visitables.remove("mirrorPercentage");
    if (mirrorPercentage != null) {
        this.mirrorPercentage = new PercentBuilder(mirrorPercentage);
        this._visitables.get("mirrorPercentage").add(this.mirrorPercentage);
    } else {
        this.mirrorPercentage = null;
        this._visitables.get("mirrorPercentage").remove(this.mirrorPercentage);
    }
    return (A) this;
  }
  
  public A withMirrors(List<HTTPMirrorPolicy> mirrors) {
    if (this.mirrors != null) {
      this._visitables.get("mirrors").clear();
    }
    if (mirrors != null) {
        this.mirrors = new ArrayList();
        for (HTTPMirrorPolicy item : mirrors) {
          this.addToMirrors(item);
        }
    } else {
      this.mirrors = null;
    }
    return (A) this;
  }
  
  public A withMirrors(HTTPMirrorPolicy... mirrors) {
    if (this.mirrors != null) {
        this.mirrors.clear();
        _visitables.remove("mirrors");
    }
    if (mirrors != null) {
      for (HTTPMirrorPolicy item : mirrors) {
        this.addToMirrors(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public CorsPolicyNested<A> withNewCorsPolicy() {
    return new CorsPolicyNested(null);
  }
  
  public CorsPolicyNested<A> withNewCorsPolicyLike(CorsPolicy item) {
    return new CorsPolicyNested(item);
  }
  
  public DelegateNested<A> withNewDelegate() {
    return new DelegateNested(null);
  }
  
  public A withNewDelegate(String name,String namespace) {
    return (A) this.withDelegate(new Delegate(name, namespace));
  }
  
  public DelegateNested<A> withNewDelegateLike(Delegate item) {
    return new DelegateNested(item);
  }
  
  public DirectResponseNested<A> withNewDirectResponse() {
    return new DirectResponseNested(null);
  }
  
  public DirectResponseNested<A> withNewDirectResponseLike(HTTPDirectResponse item) {
    return new DirectResponseNested(item);
  }
  
  public FaultNested<A> withNewFault() {
    return new FaultNested(null);
  }
  
  public FaultNested<A> withNewFaultLike(HTTPFaultInjection item) {
    return new FaultNested(item);
  }
  
  public HeadersNested<A> withNewHeaders() {
    return new HeadersNested(null);
  }
  
  public HeadersNested<A> withNewHeadersLike(Headers item) {
    return new HeadersNested(item);
  }
  
  public MirrorNested<A> withNewMirror() {
    return new MirrorNested(null);
  }
  
  public MirrorNested<A> withNewMirrorLike(Destination item) {
    return new MirrorNested(item);
  }
  
  public MirrorPercentageNested<A> withNewMirrorPercentage() {
    return new MirrorPercentageNested(null);
  }
  
  public A withNewMirrorPercentage(Double value) {
    return (A) this.withMirrorPercentage(new Percent(value));
  }
  
  public MirrorPercentageNested<A> withNewMirrorPercentageLike(Percent item) {
    return new MirrorPercentageNested(item);
  }
  
  public RedirectNested<A> withNewRedirect() {
    return new RedirectNested(null);
  }
  
  public RedirectNested<A> withNewRedirectLike(HTTPRedirect item) {
    return new RedirectNested(item);
  }
  
  public RetriesNested<A> withNewRetries() {
    return new RetriesNested(null);
  }
  
  public RetriesNested<A> withNewRetriesLike(HTTPRetry item) {
    return new RetriesNested(item);
  }
  
  public RewriteNested<A> withNewRewrite() {
    return new RewriteNested(null);
  }
  
  public RewriteNested<A> withNewRewriteLike(HTTPRewrite item) {
    return new RewriteNested(item);
  }
  
  public A withRedirect(HTTPRedirect redirect) {
    this._visitables.remove("redirect");
    if (redirect != null) {
        this.redirect = new HTTPRedirectBuilder(redirect);
        this._visitables.get("redirect").add(this.redirect);
    } else {
        this.redirect = null;
        this._visitables.get("redirect").remove(this.redirect);
    }
    return (A) this;
  }
  
  public A withRetries(HTTPRetry retries) {
    this._visitables.remove("retries");
    if (retries != null) {
        this.retries = new HTTPRetryBuilder(retries);
        this._visitables.get("retries").add(this.retries);
    } else {
        this.retries = null;
        this._visitables.get("retries").remove(this.retries);
    }
    return (A) this;
  }
  
  public A withRewrite(HTTPRewrite rewrite) {
    this._visitables.remove("rewrite");
    if (rewrite != null) {
        this.rewrite = new HTTPRewriteBuilder(rewrite);
        this._visitables.get("rewrite").add(this.rewrite);
    } else {
        this.rewrite = null;
        this._visitables.get("rewrite").remove(this.rewrite);
    }
    return (A) this;
  }
  
  public A withRoute(List<HTTPRouteDestination> route) {
    if (this.route != null) {
      this._visitables.get("route").clear();
    }
    if (route != null) {
        this.route = new ArrayList();
        for (HTTPRouteDestination item : route) {
          this.addToRoute(item);
        }
    } else {
      this.route = null;
    }
    return (A) this;
  }
  
  public A withRoute(HTTPRouteDestination... route) {
    if (this.route != null) {
        this.route.clear();
        _visitables.remove("route");
    }
    if (route != null) {
      for (HTTPRouteDestination item : route) {
        this.addToRoute(item);
      }
    }
    return (A) this;
  }
  
  public A withTimeout(String timeout) {
    this.timeout = timeout;
    return (A) this;
  }
  public class CorsPolicyNested<N> extends CorsPolicyFluent<CorsPolicyNested<N>> implements Nested<N>{
  
    CorsPolicyBuilder builder;
  
    CorsPolicyNested(CorsPolicy item) {
      this.builder = new CorsPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFluent.this.withCorsPolicy(builder.build());
    }
    
    public N endCorsPolicy() {
      return and();
    }
    
  }
  public class DelegateNested<N> extends DelegateFluent<DelegateNested<N>> implements Nested<N>{
  
    DelegateBuilder builder;
  
    DelegateNested(Delegate item) {
      this.builder = new DelegateBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFluent.this.withDelegate(builder.build());
    }
    
    public N endDelegate() {
      return and();
    }
    
  }
  public class DirectResponseNested<N> extends HTTPDirectResponseFluent<DirectResponseNested<N>> implements Nested<N>{
  
    HTTPDirectResponseBuilder builder;
  
    DirectResponseNested(HTTPDirectResponse item) {
      this.builder = new HTTPDirectResponseBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFluent.this.withDirectResponse(builder.build());
    }
    
    public N endDirectResponse() {
      return and();
    }
    
  }
  public class FaultNested<N> extends HTTPFaultInjectionFluent<FaultNested<N>> implements Nested<N>{
  
    HTTPFaultInjectionBuilder builder;
  
    FaultNested(HTTPFaultInjection item) {
      this.builder = new HTTPFaultInjectionBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFluent.this.withFault(builder.build());
    }
    
    public N endFault() {
      return and();
    }
    
  }
  public class HeadersNested<N> extends HeadersFluent<HeadersNested<N>> implements Nested<N>{
  
    HeadersBuilder builder;
  
    HeadersNested(Headers item) {
      this.builder = new HeadersBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFluent.this.withHeaders(builder.build());
    }
    
    public N endHeaders() {
      return and();
    }
    
  }
  public class MatchNested<N> extends HTTPMatchRequestFluent<MatchNested<N>> implements Nested<N>{
  
    HTTPMatchRequestBuilder builder;
    int index;
  
    MatchNested(int index,HTTPMatchRequest item) {
      this.index = index;
      this.builder = new HTTPMatchRequestBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFluent.this.setToMatch(index, builder.build());
    }
    
    public N endMatch() {
      return and();
    }
    
  }
  public class MirrorNested<N> extends DestinationFluent<MirrorNested<N>> implements Nested<N>{
  
    DestinationBuilder builder;
  
    MirrorNested(Destination item) {
      this.builder = new DestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFluent.this.withMirror(builder.build());
    }
    
    public N endMirror() {
      return and();
    }
    
  }
  public class MirrorPercentageNested<N> extends PercentFluent<MirrorPercentageNested<N>> implements Nested<N>{
  
    PercentBuilder builder;
  
    MirrorPercentageNested(Percent item) {
      this.builder = new PercentBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFluent.this.withMirrorPercentage(builder.build());
    }
    
    public N endMirrorPercentage() {
      return and();
    }
    
  }
  public class MirrorsNested<N> extends HTTPMirrorPolicyFluent<MirrorsNested<N>> implements Nested<N>{
  
    HTTPMirrorPolicyBuilder builder;
    int index;
  
    MirrorsNested(int index,HTTPMirrorPolicy item) {
      this.index = index;
      this.builder = new HTTPMirrorPolicyBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFluent.this.setToMirrors(index, builder.build());
    }
    
    public N endMirror() {
      return and();
    }
    
  }
  public class RedirectNested<N> extends HTTPRedirectFluent<RedirectNested<N>> implements Nested<N>{
  
    HTTPRedirectBuilder builder;
  
    RedirectNested(HTTPRedirect item) {
      this.builder = new HTTPRedirectBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFluent.this.withRedirect(builder.build());
    }
    
    public N endRedirect() {
      return and();
    }
    
  }
  public class RetriesNested<N> extends HTTPRetryFluent<RetriesNested<N>> implements Nested<N>{
  
    HTTPRetryBuilder builder;
  
    RetriesNested(HTTPRetry item) {
      this.builder = new HTTPRetryBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFluent.this.withRetries(builder.build());
    }
    
    public N endRetries() {
      return and();
    }
    
  }
  public class RewriteNested<N> extends HTTPRewriteFluent<RewriteNested<N>> implements Nested<N>{
  
    HTTPRewriteBuilder builder;
  
    RewriteNested(HTTPRewrite item) {
      this.builder = new HTTPRewriteBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFluent.this.withRewrite(builder.build());
    }
    
    public N endRewrite() {
      return and();
    }
    
  }
  public class RouteNested<N> extends HTTPRouteDestinationFluent<RouteNested<N>> implements Nested<N>{
  
    HTTPRouteDestinationBuilder builder;
    int index;
  
    RouteNested(int index,HTTPRouteDestination item) {
      this.index = index;
      this.builder = new HTTPRouteDestinationBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteFluent.this.setToRoute(index, builder.build());
    }
    
    public N endRoute() {
      return and();
    }
    
  }
}