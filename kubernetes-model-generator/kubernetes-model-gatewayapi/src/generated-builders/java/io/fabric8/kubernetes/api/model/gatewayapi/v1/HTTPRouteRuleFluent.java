package io.fabric8.kubernetes.api.model.gatewayapi.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
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
public class HTTPRouteRuleFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.HTTPRouteRuleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<HTTPBackendRefBuilder> backendRefs = new ArrayList<HTTPBackendRefBuilder>();
  private ArrayList<HTTPRouteFilterBuilder> filters = new ArrayList<HTTPRouteFilterBuilder>();
  private ArrayList<HTTPRouteMatchBuilder> matches = new ArrayList<HTTPRouteMatchBuilder>();
  private String name;
  private HTTPRouteRetryBuilder retry;
  private SessionPersistenceBuilder sessionPersistence;
  private HTTPRouteTimeoutsBuilder timeouts;

  public HTTPRouteRuleFluent() {
  }
  
  public HTTPRouteRuleFluent(HTTPRouteRule instance) {
    this.copyInstance(instance);
  }

  public A addAllToBackendRefs(Collection<HTTPBackendRef> items) {
    if (this.backendRefs == null) {
      this.backendRefs = new ArrayList();
    }
    for (HTTPBackendRef item : items) {
        HTTPBackendRefBuilder builder = new HTTPBackendRefBuilder(item);
        _visitables.get("backendRefs").add(builder);
        this.backendRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFilters(Collection<HTTPRouteFilter> items) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    for (HTTPRouteFilter item : items) {
        HTTPRouteFilterBuilder builder = new HTTPRouteFilterBuilder(item);
        _visitables.get("filters").add(builder);
        this.filters.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMatches(Collection<HTTPRouteMatch> items) {
    if (this.matches == null) {
      this.matches = new ArrayList();
    }
    for (HTTPRouteMatch item : items) {
        HTTPRouteMatchBuilder builder = new HTTPRouteMatchBuilder(item);
        _visitables.get("matches").add(builder);
        this.matches.add(builder);
    }
    return (A) this;
  }
  
  public BackendRefsNested<A> addNewBackendRef() {
    return new BackendRefsNested(-1, null);
  }
  
  public BackendRefsNested<A> addNewBackendRefLike(HTTPBackendRef item) {
    return new BackendRefsNested(-1, item);
  }
  
  public FiltersNested<A> addNewFilter() {
    return new FiltersNested(-1, null);
  }
  
  public FiltersNested<A> addNewFilterLike(HTTPRouteFilter item) {
    return new FiltersNested(-1, item);
  }
  
  public MatchesNested<A> addNewMatch() {
    return new MatchesNested(-1, null);
  }
  
  public MatchesNested<A> addNewMatchLike(HTTPRouteMatch item) {
    return new MatchesNested(-1, item);
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
  
  public A addToBackendRefs(HTTPBackendRef... items) {
    if (this.backendRefs == null) {
      this.backendRefs = new ArrayList();
    }
    for (HTTPBackendRef item : items) {
        HTTPBackendRefBuilder builder = new HTTPBackendRefBuilder(item);
        _visitables.get("backendRefs").add(builder);
        this.backendRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addToBackendRefs(int index,HTTPBackendRef item) {
    if (this.backendRefs == null) {
      this.backendRefs = new ArrayList();
    }
    HTTPBackendRefBuilder builder = new HTTPBackendRefBuilder(item);
    if (index < 0 || index >= backendRefs.size()) {
        _visitables.get("backendRefs").add(builder);
        backendRefs.add(builder);
    } else {
        _visitables.get("backendRefs").add(builder);
        backendRefs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToFilters(HTTPRouteFilter... items) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    for (HTTPRouteFilter item : items) {
        HTTPRouteFilterBuilder builder = new HTTPRouteFilterBuilder(item);
        _visitables.get("filters").add(builder);
        this.filters.add(builder);
    }
    return (A) this;
  }
  
  public A addToFilters(int index,HTTPRouteFilter item) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    HTTPRouteFilterBuilder builder = new HTTPRouteFilterBuilder(item);
    if (index < 0 || index >= filters.size()) {
        _visitables.get("filters").add(builder);
        filters.add(builder);
    } else {
        _visitables.get("filters").add(builder);
        filters.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMatches(HTTPRouteMatch... items) {
    if (this.matches == null) {
      this.matches = new ArrayList();
    }
    for (HTTPRouteMatch item : items) {
        HTTPRouteMatchBuilder builder = new HTTPRouteMatchBuilder(item);
        _visitables.get("matches").add(builder);
        this.matches.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatches(int index,HTTPRouteMatch item) {
    if (this.matches == null) {
      this.matches = new ArrayList();
    }
    HTTPRouteMatchBuilder builder = new HTTPRouteMatchBuilder(item);
    if (index < 0 || index >= matches.size()) {
        _visitables.get("matches").add(builder);
        matches.add(builder);
    } else {
        _visitables.get("matches").add(builder);
        matches.add(index, builder);
    }
    return (A) this;
  }
  
  public HTTPBackendRef buildBackendRef(int index) {
    return this.backendRefs.get(index).build();
  }
  
  public List<HTTPBackendRef> buildBackendRefs() {
    return this.backendRefs != null ? build(backendRefs) : null;
  }
  
  public HTTPRouteFilter buildFilter(int index) {
    return this.filters.get(index).build();
  }
  
  public List<HTTPRouteFilter> buildFilters() {
    return this.filters != null ? build(filters) : null;
  }
  
  public HTTPBackendRef buildFirstBackendRef() {
    return this.backendRefs.get(0).build();
  }
  
  public HTTPRouteFilter buildFirstFilter() {
    return this.filters.get(0).build();
  }
  
  public HTTPRouteMatch buildFirstMatch() {
    return this.matches.get(0).build();
  }
  
  public HTTPBackendRef buildLastBackendRef() {
    return this.backendRefs.get(backendRefs.size() - 1).build();
  }
  
  public HTTPRouteFilter buildLastFilter() {
    return this.filters.get(filters.size() - 1).build();
  }
  
  public HTTPRouteMatch buildLastMatch() {
    return this.matches.get(matches.size() - 1).build();
  }
  
  public HTTPRouteMatch buildMatch(int index) {
    return this.matches.get(index).build();
  }
  
  public List<HTTPRouteMatch> buildMatches() {
    return this.matches != null ? build(matches) : null;
  }
  
  public HTTPBackendRef buildMatchingBackendRef(Predicate<HTTPBackendRefBuilder> predicate) {
      for (HTTPBackendRefBuilder item : backendRefs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HTTPRouteFilter buildMatchingFilter(Predicate<HTTPRouteFilterBuilder> predicate) {
      for (HTTPRouteFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HTTPRouteMatch buildMatchingMatch(Predicate<HTTPRouteMatchBuilder> predicate) {
      for (HTTPRouteMatchBuilder item : matches) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public HTTPRouteRetry buildRetry() {
    return this.retry != null ? this.retry.build() : null;
  }
  
  public SessionPersistence buildSessionPersistence() {
    return this.sessionPersistence != null ? this.sessionPersistence.build() : null;
  }
  
  public HTTPRouteTimeouts buildTimeouts() {
    return this.timeouts != null ? this.timeouts.build() : null;
  }
  
  protected void copyInstance(HTTPRouteRule instance) {
    instance = instance != null ? instance : new HTTPRouteRule();
    if (instance != null) {
        this.withBackendRefs(instance.getBackendRefs());
        this.withFilters(instance.getFilters());
        this.withMatches(instance.getMatches());
        this.withName(instance.getName());
        this.withRetry(instance.getRetry());
        this.withSessionPersistence(instance.getSessionPersistence());
        this.withTimeouts(instance.getTimeouts());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public BackendRefsNested<A> editBackendRef(int index) {
    if (backendRefs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "backendRefs"));
    }
    return this.setNewBackendRefLike(index, this.buildBackendRef(index));
  }
  
  public FiltersNested<A> editFilter(int index) {
    if (filters.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "filters"));
    }
    return this.setNewFilterLike(index, this.buildFilter(index));
  }
  
  public BackendRefsNested<A> editFirstBackendRef() {
    if (backendRefs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "backendRefs"));
    }
    return this.setNewBackendRefLike(0, this.buildBackendRef(0));
  }
  
  public FiltersNested<A> editFirstFilter() {
    if (filters.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "filters"));
    }
    return this.setNewFilterLike(0, this.buildFilter(0));
  }
  
  public MatchesNested<A> editFirstMatch() {
    if (matches.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "matches"));
    }
    return this.setNewMatchLike(0, this.buildMatch(0));
  }
  
  public BackendRefsNested<A> editLastBackendRef() {
    int index = backendRefs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "backendRefs"));
    }
    return this.setNewBackendRefLike(index, this.buildBackendRef(index));
  }
  
  public FiltersNested<A> editLastFilter() {
    int index = filters.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "filters"));
    }
    return this.setNewFilterLike(index, this.buildFilter(index));
  }
  
  public MatchesNested<A> editLastMatch() {
    int index = matches.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "matches"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public MatchesNested<A> editMatch(int index) {
    if (matches.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "matches"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public BackendRefsNested<A> editMatchingBackendRef(Predicate<HTTPBackendRefBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < backendRefs.size();i++) {
      if (predicate.test(backendRefs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "backendRefs"));
    }
    return this.setNewBackendRefLike(index, this.buildBackendRef(index));
  }
  
  public FiltersNested<A> editMatchingFilter(Predicate<HTTPRouteFilterBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < filters.size();i++) {
      if (predicate.test(filters.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "filters"));
    }
    return this.setNewFilterLike(index, this.buildFilter(index));
  }
  
  public MatchesNested<A> editMatchingMatch(Predicate<HTTPRouteMatchBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < matches.size();i++) {
      if (predicate.test(matches.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "matches"));
    }
    return this.setNewMatchLike(index, this.buildMatch(index));
  }
  
  public RetryNested<A> editOrNewRetry() {
    return this.withNewRetryLike(Optional.ofNullable(this.buildRetry()).orElse(new HTTPRouteRetryBuilder().build()));
  }
  
  public RetryNested<A> editOrNewRetryLike(HTTPRouteRetry item) {
    return this.withNewRetryLike(Optional.ofNullable(this.buildRetry()).orElse(item));
  }
  
  public SessionPersistenceNested<A> editOrNewSessionPersistence() {
    return this.withNewSessionPersistenceLike(Optional.ofNullable(this.buildSessionPersistence()).orElse(new SessionPersistenceBuilder().build()));
  }
  
  public SessionPersistenceNested<A> editOrNewSessionPersistenceLike(SessionPersistence item) {
    return this.withNewSessionPersistenceLike(Optional.ofNullable(this.buildSessionPersistence()).orElse(item));
  }
  
  public TimeoutsNested<A> editOrNewTimeouts() {
    return this.withNewTimeoutsLike(Optional.ofNullable(this.buildTimeouts()).orElse(new HTTPRouteTimeoutsBuilder().build()));
  }
  
  public TimeoutsNested<A> editOrNewTimeoutsLike(HTTPRouteTimeouts item) {
    return this.withNewTimeoutsLike(Optional.ofNullable(this.buildTimeouts()).orElse(item));
  }
  
  public RetryNested<A> editRetry() {
    return this.withNewRetryLike(Optional.ofNullable(this.buildRetry()).orElse(null));
  }
  
  public SessionPersistenceNested<A> editSessionPersistence() {
    return this.withNewSessionPersistenceLike(Optional.ofNullable(this.buildSessionPersistence()).orElse(null));
  }
  
  public TimeoutsNested<A> editTimeouts() {
    return this.withNewTimeoutsLike(Optional.ofNullable(this.buildTimeouts()).orElse(null));
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
    HTTPRouteRuleFluent that = (HTTPRouteRuleFluent) o;
    if (!(Objects.equals(backendRefs, that.backendRefs))) {
      return false;
    }
    if (!(Objects.equals(filters, that.filters))) {
      return false;
    }
    if (!(Objects.equals(matches, that.matches))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(retry, that.retry))) {
      return false;
    }
    if (!(Objects.equals(sessionPersistence, that.sessionPersistence))) {
      return false;
    }
    if (!(Objects.equals(timeouts, that.timeouts))) {
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
  
  public String getName() {
    return this.name;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasBackendRefs() {
    return this.backendRefs != null && !(this.backendRefs.isEmpty());
  }
  
  public boolean hasFilters() {
    return this.filters != null && !(this.filters.isEmpty());
  }
  
  public boolean hasMatches() {
    return this.matches != null && !(this.matches.isEmpty());
  }
  
  public boolean hasMatchingBackendRef(Predicate<HTTPBackendRefBuilder> predicate) {
      for (HTTPBackendRefBuilder item : backendRefs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFilter(Predicate<HTTPRouteFilterBuilder> predicate) {
      for (HTTPRouteFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMatch(Predicate<HTTPRouteMatchBuilder> predicate) {
      for (HTTPRouteMatchBuilder item : matches) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasRetry() {
    return this.retry != null;
  }
  
  public boolean hasSessionPersistence() {
    return this.sessionPersistence != null;
  }
  
  public boolean hasTimeouts() {
    return this.timeouts != null;
  }
  
  public int hashCode() {
    return Objects.hash(backendRefs, filters, matches, name, retry, sessionPersistence, timeouts, additionalProperties);
  }
  
  public A removeAllFromBackendRefs(Collection<HTTPBackendRef> items) {
    if (this.backendRefs == null) {
      return (A) this;
    }
    for (HTTPBackendRef item : items) {
        HTTPBackendRefBuilder builder = new HTTPBackendRefBuilder(item);
        _visitables.get("backendRefs").remove(builder);
        this.backendRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFilters(Collection<HTTPRouteFilter> items) {
    if (this.filters == null) {
      return (A) this;
    }
    for (HTTPRouteFilter item : items) {
        HTTPRouteFilterBuilder builder = new HTTPRouteFilterBuilder(item);
        _visitables.get("filters").remove(builder);
        this.filters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMatches(Collection<HTTPRouteMatch> items) {
    if (this.matches == null) {
      return (A) this;
    }
    for (HTTPRouteMatch item : items) {
        HTTPRouteMatchBuilder builder = new HTTPRouteMatchBuilder(item);
        _visitables.get("matches").remove(builder);
        this.matches.remove(builder);
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
  
  public A removeFromBackendRefs(HTTPBackendRef... items) {
    if (this.backendRefs == null) {
      return (A) this;
    }
    for (HTTPBackendRef item : items) {
        HTTPBackendRefBuilder builder = new HTTPBackendRefBuilder(item);
        _visitables.get("backendRefs").remove(builder);
        this.backendRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromFilters(HTTPRouteFilter... items) {
    if (this.filters == null) {
      return (A) this;
    }
    for (HTTPRouteFilter item : items) {
        HTTPRouteFilterBuilder builder = new HTTPRouteFilterBuilder(item);
        _visitables.get("filters").remove(builder);
        this.filters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMatches(HTTPRouteMatch... items) {
    if (this.matches == null) {
      return (A) this;
    }
    for (HTTPRouteMatch item : items) {
        HTTPRouteMatchBuilder builder = new HTTPRouteMatchBuilder(item);
        _visitables.get("matches").remove(builder);
        this.matches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromBackendRefs(Predicate<HTTPBackendRefBuilder> predicate) {
    if (backendRefs == null) {
      return (A) this;
    }
    Iterator<HTTPBackendRefBuilder> each = backendRefs.iterator();
    List visitables = _visitables.get("backendRefs");
    while (each.hasNext()) {
        HTTPBackendRefBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromFilters(Predicate<HTTPRouteFilterBuilder> predicate) {
    if (filters == null) {
      return (A) this;
    }
    Iterator<HTTPRouteFilterBuilder> each = filters.iterator();
    List visitables = _visitables.get("filters");
    while (each.hasNext()) {
        HTTPRouteFilterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatches(Predicate<HTTPRouteMatchBuilder> predicate) {
    if (matches == null) {
      return (A) this;
    }
    Iterator<HTTPRouteMatchBuilder> each = matches.iterator();
    List visitables = _visitables.get("matches");
    while (each.hasNext()) {
        HTTPRouteMatchBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public BackendRefsNested<A> setNewBackendRefLike(int index,HTTPBackendRef item) {
    return new BackendRefsNested(index, item);
  }
  
  public FiltersNested<A> setNewFilterLike(int index,HTTPRouteFilter item) {
    return new FiltersNested(index, item);
  }
  
  public MatchesNested<A> setNewMatchLike(int index,HTTPRouteMatch item) {
    return new MatchesNested(index, item);
  }
  
  public A setToBackendRefs(int index,HTTPBackendRef item) {
    if (this.backendRefs == null) {
      this.backendRefs = new ArrayList();
    }
    HTTPBackendRefBuilder builder = new HTTPBackendRefBuilder(item);
    if (index < 0 || index >= backendRefs.size()) {
        _visitables.get("backendRefs").add(builder);
        backendRefs.add(builder);
    } else {
        _visitables.get("backendRefs").add(builder);
        backendRefs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFilters(int index,HTTPRouteFilter item) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    HTTPRouteFilterBuilder builder = new HTTPRouteFilterBuilder(item);
    if (index < 0 || index >= filters.size()) {
        _visitables.get("filters").add(builder);
        filters.add(builder);
    } else {
        _visitables.get("filters").add(builder);
        filters.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMatches(int index,HTTPRouteMatch item) {
    if (this.matches == null) {
      this.matches = new ArrayList();
    }
    HTTPRouteMatchBuilder builder = new HTTPRouteMatchBuilder(item);
    if (index < 0 || index >= matches.size()) {
        _visitables.get("matches").add(builder);
        matches.add(builder);
    } else {
        _visitables.get("matches").add(builder);
        matches.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(backendRefs == null) && !(backendRefs.isEmpty())) {
        sb.append("backendRefs:");
        sb.append(backendRefs);
        sb.append(",");
    }
    if (!(filters == null) && !(filters.isEmpty())) {
        sb.append("filters:");
        sb.append(filters);
        sb.append(",");
    }
    if (!(matches == null) && !(matches.isEmpty())) {
        sb.append("matches:");
        sb.append(matches);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(retry == null)) {
        sb.append("retry:");
        sb.append(retry);
        sb.append(",");
    }
    if (!(sessionPersistence == null)) {
        sb.append("sessionPersistence:");
        sb.append(sessionPersistence);
        sb.append(",");
    }
    if (!(timeouts == null)) {
        sb.append("timeouts:");
        sb.append(timeouts);
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
  
  public A withBackendRefs(List<HTTPBackendRef> backendRefs) {
    if (this.backendRefs != null) {
      this._visitables.get("backendRefs").clear();
    }
    if (backendRefs != null) {
        this.backendRefs = new ArrayList();
        for (HTTPBackendRef item : backendRefs) {
          this.addToBackendRefs(item);
        }
    } else {
      this.backendRefs = null;
    }
    return (A) this;
  }
  
  public A withBackendRefs(HTTPBackendRef... backendRefs) {
    if (this.backendRefs != null) {
        this.backendRefs.clear();
        _visitables.remove("backendRefs");
    }
    if (backendRefs != null) {
      for (HTTPBackendRef item : backendRefs) {
        this.addToBackendRefs(item);
      }
    }
    return (A) this;
  }
  
  public A withFilters(List<HTTPRouteFilter> filters) {
    if (this.filters != null) {
      this._visitables.get("filters").clear();
    }
    if (filters != null) {
        this.filters = new ArrayList();
        for (HTTPRouteFilter item : filters) {
          this.addToFilters(item);
        }
    } else {
      this.filters = null;
    }
    return (A) this;
  }
  
  public A withFilters(HTTPRouteFilter... filters) {
    if (this.filters != null) {
        this.filters.clear();
        _visitables.remove("filters");
    }
    if (filters != null) {
      for (HTTPRouteFilter item : filters) {
        this.addToFilters(item);
      }
    }
    return (A) this;
  }
  
  public A withMatches(List<HTTPRouteMatch> matches) {
    if (this.matches != null) {
      this._visitables.get("matches").clear();
    }
    if (matches != null) {
        this.matches = new ArrayList();
        for (HTTPRouteMatch item : matches) {
          this.addToMatches(item);
        }
    } else {
      this.matches = null;
    }
    return (A) this;
  }
  
  public A withMatches(HTTPRouteMatch... matches) {
    if (this.matches != null) {
        this.matches.clear();
        _visitables.remove("matches");
    }
    if (matches != null) {
      for (HTTPRouteMatch item : matches) {
        this.addToMatches(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public RetryNested<A> withNewRetry() {
    return new RetryNested(null);
  }
  
  public RetryNested<A> withNewRetryLike(HTTPRouteRetry item) {
    return new RetryNested(item);
  }
  
  public SessionPersistenceNested<A> withNewSessionPersistence() {
    return new SessionPersistenceNested(null);
  }
  
  public SessionPersistenceNested<A> withNewSessionPersistenceLike(SessionPersistence item) {
    return new SessionPersistenceNested(item);
  }
  
  public TimeoutsNested<A> withNewTimeouts() {
    return new TimeoutsNested(null);
  }
  
  public A withNewTimeouts(String backendRequest,String request) {
    return (A) this.withTimeouts(new HTTPRouteTimeouts(backendRequest, request));
  }
  
  public TimeoutsNested<A> withNewTimeoutsLike(HTTPRouteTimeouts item) {
    return new TimeoutsNested(item);
  }
  
  public A withRetry(HTTPRouteRetry retry) {
    this._visitables.remove("retry");
    if (retry != null) {
        this.retry = new HTTPRouteRetryBuilder(retry);
        this._visitables.get("retry").add(this.retry);
    } else {
        this.retry = null;
        this._visitables.get("retry").remove(this.retry);
    }
    return (A) this;
  }
  
  public A withSessionPersistence(SessionPersistence sessionPersistence) {
    this._visitables.remove("sessionPersistence");
    if (sessionPersistence != null) {
        this.sessionPersistence = new SessionPersistenceBuilder(sessionPersistence);
        this._visitables.get("sessionPersistence").add(this.sessionPersistence);
    } else {
        this.sessionPersistence = null;
        this._visitables.get("sessionPersistence").remove(this.sessionPersistence);
    }
    return (A) this;
  }
  
  public A withTimeouts(HTTPRouteTimeouts timeouts) {
    this._visitables.remove("timeouts");
    if (timeouts != null) {
        this.timeouts = new HTTPRouteTimeoutsBuilder(timeouts);
        this._visitables.get("timeouts").add(this.timeouts);
    } else {
        this.timeouts = null;
        this._visitables.get("timeouts").remove(this.timeouts);
    }
    return (A) this;
  }
  public class BackendRefsNested<N> extends HTTPBackendRefFluent<BackendRefsNested<N>> implements Nested<N>{
  
    HTTPBackendRefBuilder builder;
    int index;
  
    BackendRefsNested(int index,HTTPBackendRef item) {
      this.index = index;
      this.builder = new HTTPBackendRefBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteRuleFluent.this.setToBackendRefs(index, builder.build());
    }
    
    public N endBackendRef() {
      return and();
    }
    
  }
  public class FiltersNested<N> extends HTTPRouteFilterFluent<FiltersNested<N>> implements Nested<N>{
  
    HTTPRouteFilterBuilder builder;
    int index;
  
    FiltersNested(int index,HTTPRouteFilter item) {
      this.index = index;
      this.builder = new HTTPRouteFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteRuleFluent.this.setToFilters(index, builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
  public class MatchesNested<N> extends HTTPRouteMatchFluent<MatchesNested<N>> implements Nested<N>{
  
    HTTPRouteMatchBuilder builder;
    int index;
  
    MatchesNested(int index,HTTPRouteMatch item) {
      this.index = index;
      this.builder = new HTTPRouteMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteRuleFluent.this.setToMatches(index, builder.build());
    }
    
    public N endMatch() {
      return and();
    }
    
  }
  public class RetryNested<N> extends HTTPRouteRetryFluent<RetryNested<N>> implements Nested<N>{
  
    HTTPRouteRetryBuilder builder;
  
    RetryNested(HTTPRouteRetry item) {
      this.builder = new HTTPRouteRetryBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteRuleFluent.this.withRetry(builder.build());
    }
    
    public N endRetry() {
      return and();
    }
    
  }
  public class SessionPersistenceNested<N> extends SessionPersistenceFluent<SessionPersistenceNested<N>> implements Nested<N>{
  
    SessionPersistenceBuilder builder;
  
    SessionPersistenceNested(SessionPersistence item) {
      this.builder = new SessionPersistenceBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteRuleFluent.this.withSessionPersistence(builder.build());
    }
    
    public N endSessionPersistence() {
      return and();
    }
    
  }
  public class TimeoutsNested<N> extends HTTPRouteTimeoutsFluent<TimeoutsNested<N>> implements Nested<N>{
  
    HTTPRouteTimeoutsBuilder builder;
  
    TimeoutsNested(HTTPRouteTimeouts item) {
      this.builder = new HTTPRouteTimeoutsBuilder(this, item);
    }
  
    public N and() {
      return (N) HTTPRouteRuleFluent.this.withTimeouts(builder.build());
    }
    
    public N endTimeouts() {
      return and();
    }
    
  }
}