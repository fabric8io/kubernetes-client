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
public class GRPCRouteRuleFluent<A extends io.fabric8.kubernetes.api.model.gatewayapi.v1.GRPCRouteRuleFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<GRPCBackendRefBuilder> backendRefs = new ArrayList<GRPCBackendRefBuilder>();
  private ArrayList<GRPCRouteFilterBuilder> filters = new ArrayList<GRPCRouteFilterBuilder>();
  private ArrayList<GRPCRouteMatchBuilder> matches = new ArrayList<GRPCRouteMatchBuilder>();
  private String name;
  private SessionPersistenceBuilder sessionPersistence;

  public GRPCRouteRuleFluent() {
  }
  
  public GRPCRouteRuleFluent(GRPCRouteRule instance) {
    this.copyInstance(instance);
  }

  public A addAllToBackendRefs(Collection<GRPCBackendRef> items) {
    if (this.backendRefs == null) {
      this.backendRefs = new ArrayList();
    }
    for (GRPCBackendRef item : items) {
        GRPCBackendRefBuilder builder = new GRPCBackendRefBuilder(item);
        _visitables.get("backendRefs").add(builder);
        this.backendRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFilters(Collection<GRPCRouteFilter> items) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    for (GRPCRouteFilter item : items) {
        GRPCRouteFilterBuilder builder = new GRPCRouteFilterBuilder(item);
        _visitables.get("filters").add(builder);
        this.filters.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMatches(Collection<GRPCRouteMatch> items) {
    if (this.matches == null) {
      this.matches = new ArrayList();
    }
    for (GRPCRouteMatch item : items) {
        GRPCRouteMatchBuilder builder = new GRPCRouteMatchBuilder(item);
        _visitables.get("matches").add(builder);
        this.matches.add(builder);
    }
    return (A) this;
  }
  
  public BackendRefsNested<A> addNewBackendRef() {
    return new BackendRefsNested(-1, null);
  }
  
  public BackendRefsNested<A> addNewBackendRefLike(GRPCBackendRef item) {
    return new BackendRefsNested(-1, item);
  }
  
  public FiltersNested<A> addNewFilter() {
    return new FiltersNested(-1, null);
  }
  
  public FiltersNested<A> addNewFilterLike(GRPCRouteFilter item) {
    return new FiltersNested(-1, item);
  }
  
  public MatchesNested<A> addNewMatch() {
    return new MatchesNested(-1, null);
  }
  
  public MatchesNested<A> addNewMatchLike(GRPCRouteMatch item) {
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
  
  public A addToBackendRefs(GRPCBackendRef... items) {
    if (this.backendRefs == null) {
      this.backendRefs = new ArrayList();
    }
    for (GRPCBackendRef item : items) {
        GRPCBackendRefBuilder builder = new GRPCBackendRefBuilder(item);
        _visitables.get("backendRefs").add(builder);
        this.backendRefs.add(builder);
    }
    return (A) this;
  }
  
  public A addToBackendRefs(int index,GRPCBackendRef item) {
    if (this.backendRefs == null) {
      this.backendRefs = new ArrayList();
    }
    GRPCBackendRefBuilder builder = new GRPCBackendRefBuilder(item);
    if (index < 0 || index >= backendRefs.size()) {
        _visitables.get("backendRefs").add(builder);
        backendRefs.add(builder);
    } else {
        _visitables.get("backendRefs").add(builder);
        backendRefs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToFilters(GRPCRouteFilter... items) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    for (GRPCRouteFilter item : items) {
        GRPCRouteFilterBuilder builder = new GRPCRouteFilterBuilder(item);
        _visitables.get("filters").add(builder);
        this.filters.add(builder);
    }
    return (A) this;
  }
  
  public A addToFilters(int index,GRPCRouteFilter item) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    GRPCRouteFilterBuilder builder = new GRPCRouteFilterBuilder(item);
    if (index < 0 || index >= filters.size()) {
        _visitables.get("filters").add(builder);
        filters.add(builder);
    } else {
        _visitables.get("filters").add(builder);
        filters.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMatches(GRPCRouteMatch... items) {
    if (this.matches == null) {
      this.matches = new ArrayList();
    }
    for (GRPCRouteMatch item : items) {
        GRPCRouteMatchBuilder builder = new GRPCRouteMatchBuilder(item);
        _visitables.get("matches").add(builder);
        this.matches.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatches(int index,GRPCRouteMatch item) {
    if (this.matches == null) {
      this.matches = new ArrayList();
    }
    GRPCRouteMatchBuilder builder = new GRPCRouteMatchBuilder(item);
    if (index < 0 || index >= matches.size()) {
        _visitables.get("matches").add(builder);
        matches.add(builder);
    } else {
        _visitables.get("matches").add(builder);
        matches.add(index, builder);
    }
    return (A) this;
  }
  
  public GRPCBackendRef buildBackendRef(int index) {
    return this.backendRefs.get(index).build();
  }
  
  public List<GRPCBackendRef> buildBackendRefs() {
    return this.backendRefs != null ? build(backendRefs) : null;
  }
  
  public GRPCRouteFilter buildFilter(int index) {
    return this.filters.get(index).build();
  }
  
  public List<GRPCRouteFilter> buildFilters() {
    return this.filters != null ? build(filters) : null;
  }
  
  public GRPCBackendRef buildFirstBackendRef() {
    return this.backendRefs.get(0).build();
  }
  
  public GRPCRouteFilter buildFirstFilter() {
    return this.filters.get(0).build();
  }
  
  public GRPCRouteMatch buildFirstMatch() {
    return this.matches.get(0).build();
  }
  
  public GRPCBackendRef buildLastBackendRef() {
    return this.backendRefs.get(backendRefs.size() - 1).build();
  }
  
  public GRPCRouteFilter buildLastFilter() {
    return this.filters.get(filters.size() - 1).build();
  }
  
  public GRPCRouteMatch buildLastMatch() {
    return this.matches.get(matches.size() - 1).build();
  }
  
  public GRPCRouteMatch buildMatch(int index) {
    return this.matches.get(index).build();
  }
  
  public List<GRPCRouteMatch> buildMatches() {
    return this.matches != null ? build(matches) : null;
  }
  
  public GRPCBackendRef buildMatchingBackendRef(Predicate<GRPCBackendRefBuilder> predicate) {
      for (GRPCBackendRefBuilder item : backendRefs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GRPCRouteFilter buildMatchingFilter(Predicate<GRPCRouteFilterBuilder> predicate) {
      for (GRPCRouteFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public GRPCRouteMatch buildMatchingMatch(Predicate<GRPCRouteMatchBuilder> predicate) {
      for (GRPCRouteMatchBuilder item : matches) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SessionPersistence buildSessionPersistence() {
    return this.sessionPersistence != null ? this.sessionPersistence.build() : null;
  }
  
  protected void copyInstance(GRPCRouteRule instance) {
    instance = instance != null ? instance : new GRPCRouteRule();
    if (instance != null) {
        this.withBackendRefs(instance.getBackendRefs());
        this.withFilters(instance.getFilters());
        this.withMatches(instance.getMatches());
        this.withName(instance.getName());
        this.withSessionPersistence(instance.getSessionPersistence());
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
  
  public BackendRefsNested<A> editMatchingBackendRef(Predicate<GRPCBackendRefBuilder> predicate) {
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
  
  public FiltersNested<A> editMatchingFilter(Predicate<GRPCRouteFilterBuilder> predicate) {
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
  
  public MatchesNested<A> editMatchingMatch(Predicate<GRPCRouteMatchBuilder> predicate) {
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
  
  public SessionPersistenceNested<A> editOrNewSessionPersistence() {
    return this.withNewSessionPersistenceLike(Optional.ofNullable(this.buildSessionPersistence()).orElse(new SessionPersistenceBuilder().build()));
  }
  
  public SessionPersistenceNested<A> editOrNewSessionPersistenceLike(SessionPersistence item) {
    return this.withNewSessionPersistenceLike(Optional.ofNullable(this.buildSessionPersistence()).orElse(item));
  }
  
  public SessionPersistenceNested<A> editSessionPersistence() {
    return this.withNewSessionPersistenceLike(Optional.ofNullable(this.buildSessionPersistence()).orElse(null));
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
    GRPCRouteRuleFluent that = (GRPCRouteRuleFluent) o;
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
    if (!(Objects.equals(sessionPersistence, that.sessionPersistence))) {
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
  
  public boolean hasMatchingBackendRef(Predicate<GRPCBackendRefBuilder> predicate) {
      for (GRPCBackendRefBuilder item : backendRefs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingFilter(Predicate<GRPCRouteFilterBuilder> predicate) {
      for (GRPCRouteFilterBuilder item : filters) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMatch(Predicate<GRPCRouteMatchBuilder> predicate) {
      for (GRPCRouteMatchBuilder item : matches) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasSessionPersistence() {
    return this.sessionPersistence != null;
  }
  
  public int hashCode() {
    return Objects.hash(backendRefs, filters, matches, name, sessionPersistence, additionalProperties);
  }
  
  public A removeAllFromBackendRefs(Collection<GRPCBackendRef> items) {
    if (this.backendRefs == null) {
      return (A) this;
    }
    for (GRPCBackendRef item : items) {
        GRPCBackendRefBuilder builder = new GRPCBackendRefBuilder(item);
        _visitables.get("backendRefs").remove(builder);
        this.backendRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFilters(Collection<GRPCRouteFilter> items) {
    if (this.filters == null) {
      return (A) this;
    }
    for (GRPCRouteFilter item : items) {
        GRPCRouteFilterBuilder builder = new GRPCRouteFilterBuilder(item);
        _visitables.get("filters").remove(builder);
        this.filters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMatches(Collection<GRPCRouteMatch> items) {
    if (this.matches == null) {
      return (A) this;
    }
    for (GRPCRouteMatch item : items) {
        GRPCRouteMatchBuilder builder = new GRPCRouteMatchBuilder(item);
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
  
  public A removeFromBackendRefs(GRPCBackendRef... items) {
    if (this.backendRefs == null) {
      return (A) this;
    }
    for (GRPCBackendRef item : items) {
        GRPCBackendRefBuilder builder = new GRPCBackendRefBuilder(item);
        _visitables.get("backendRefs").remove(builder);
        this.backendRefs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromFilters(GRPCRouteFilter... items) {
    if (this.filters == null) {
      return (A) this;
    }
    for (GRPCRouteFilter item : items) {
        GRPCRouteFilterBuilder builder = new GRPCRouteFilterBuilder(item);
        _visitables.get("filters").remove(builder);
        this.filters.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMatches(GRPCRouteMatch... items) {
    if (this.matches == null) {
      return (A) this;
    }
    for (GRPCRouteMatch item : items) {
        GRPCRouteMatchBuilder builder = new GRPCRouteMatchBuilder(item);
        _visitables.get("matches").remove(builder);
        this.matches.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromBackendRefs(Predicate<GRPCBackendRefBuilder> predicate) {
    if (backendRefs == null) {
      return (A) this;
    }
    Iterator<GRPCBackendRefBuilder> each = backendRefs.iterator();
    List visitables = _visitables.get("backendRefs");
    while (each.hasNext()) {
        GRPCBackendRefBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromFilters(Predicate<GRPCRouteFilterBuilder> predicate) {
    if (filters == null) {
      return (A) this;
    }
    Iterator<GRPCRouteFilterBuilder> each = filters.iterator();
    List visitables = _visitables.get("filters");
    while (each.hasNext()) {
        GRPCRouteFilterBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatches(Predicate<GRPCRouteMatchBuilder> predicate) {
    if (matches == null) {
      return (A) this;
    }
    Iterator<GRPCRouteMatchBuilder> each = matches.iterator();
    List visitables = _visitables.get("matches");
    while (each.hasNext()) {
        GRPCRouteMatchBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public BackendRefsNested<A> setNewBackendRefLike(int index,GRPCBackendRef item) {
    return new BackendRefsNested(index, item);
  }
  
  public FiltersNested<A> setNewFilterLike(int index,GRPCRouteFilter item) {
    return new FiltersNested(index, item);
  }
  
  public MatchesNested<A> setNewMatchLike(int index,GRPCRouteMatch item) {
    return new MatchesNested(index, item);
  }
  
  public A setToBackendRefs(int index,GRPCBackendRef item) {
    if (this.backendRefs == null) {
      this.backendRefs = new ArrayList();
    }
    GRPCBackendRefBuilder builder = new GRPCBackendRefBuilder(item);
    if (index < 0 || index >= backendRefs.size()) {
        _visitables.get("backendRefs").add(builder);
        backendRefs.add(builder);
    } else {
        _visitables.get("backendRefs").add(builder);
        backendRefs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFilters(int index,GRPCRouteFilter item) {
    if (this.filters == null) {
      this.filters = new ArrayList();
    }
    GRPCRouteFilterBuilder builder = new GRPCRouteFilterBuilder(item);
    if (index < 0 || index >= filters.size()) {
        _visitables.get("filters").add(builder);
        filters.add(builder);
    } else {
        _visitables.get("filters").add(builder);
        filters.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMatches(int index,GRPCRouteMatch item) {
    if (this.matches == null) {
      this.matches = new ArrayList();
    }
    GRPCRouteMatchBuilder builder = new GRPCRouteMatchBuilder(item);
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
    if (!(sessionPersistence == null)) {
        sb.append("sessionPersistence:");
        sb.append(sessionPersistence);
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
  
  public A withBackendRefs(List<GRPCBackendRef> backendRefs) {
    if (this.backendRefs != null) {
      this._visitables.get("backendRefs").clear();
    }
    if (backendRefs != null) {
        this.backendRefs = new ArrayList();
        for (GRPCBackendRef item : backendRefs) {
          this.addToBackendRefs(item);
        }
    } else {
      this.backendRefs = null;
    }
    return (A) this;
  }
  
  public A withBackendRefs(GRPCBackendRef... backendRefs) {
    if (this.backendRefs != null) {
        this.backendRefs.clear();
        _visitables.remove("backendRefs");
    }
    if (backendRefs != null) {
      for (GRPCBackendRef item : backendRefs) {
        this.addToBackendRefs(item);
      }
    }
    return (A) this;
  }
  
  public A withFilters(List<GRPCRouteFilter> filters) {
    if (this.filters != null) {
      this._visitables.get("filters").clear();
    }
    if (filters != null) {
        this.filters = new ArrayList();
        for (GRPCRouteFilter item : filters) {
          this.addToFilters(item);
        }
    } else {
      this.filters = null;
    }
    return (A) this;
  }
  
  public A withFilters(GRPCRouteFilter... filters) {
    if (this.filters != null) {
        this.filters.clear();
        _visitables.remove("filters");
    }
    if (filters != null) {
      for (GRPCRouteFilter item : filters) {
        this.addToFilters(item);
      }
    }
    return (A) this;
  }
  
  public A withMatches(List<GRPCRouteMatch> matches) {
    if (this.matches != null) {
      this._visitables.get("matches").clear();
    }
    if (matches != null) {
        this.matches = new ArrayList();
        for (GRPCRouteMatch item : matches) {
          this.addToMatches(item);
        }
    } else {
      this.matches = null;
    }
    return (A) this;
  }
  
  public A withMatches(GRPCRouteMatch... matches) {
    if (this.matches != null) {
        this.matches.clear();
        _visitables.remove("matches");
    }
    if (matches != null) {
      for (GRPCRouteMatch item : matches) {
        this.addToMatches(item);
      }
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
    return (A) this;
  }
  
  public SessionPersistenceNested<A> withNewSessionPersistence() {
    return new SessionPersistenceNested(null);
  }
  
  public SessionPersistenceNested<A> withNewSessionPersistenceLike(SessionPersistence item) {
    return new SessionPersistenceNested(item);
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
  public class BackendRefsNested<N> extends GRPCBackendRefFluent<BackendRefsNested<N>> implements Nested<N>{
  
    GRPCBackendRefBuilder builder;
    int index;
  
    BackendRefsNested(int index,GRPCBackendRef item) {
      this.index = index;
      this.builder = new GRPCBackendRefBuilder(this, item);
    }
  
    public N and() {
      return (N) GRPCRouteRuleFluent.this.setToBackendRefs(index, builder.build());
    }
    
    public N endBackendRef() {
      return and();
    }
    
  }
  public class FiltersNested<N> extends GRPCRouteFilterFluent<FiltersNested<N>> implements Nested<N>{
  
    GRPCRouteFilterBuilder builder;
    int index;
  
    FiltersNested(int index,GRPCRouteFilter item) {
      this.index = index;
      this.builder = new GRPCRouteFilterBuilder(this, item);
    }
  
    public N and() {
      return (N) GRPCRouteRuleFluent.this.setToFilters(index, builder.build());
    }
    
    public N endFilter() {
      return and();
    }
    
  }
  public class MatchesNested<N> extends GRPCRouteMatchFluent<MatchesNested<N>> implements Nested<N>{
  
    GRPCRouteMatchBuilder builder;
    int index;
  
    MatchesNested(int index,GRPCRouteMatch item) {
      this.index = index;
      this.builder = new GRPCRouteMatchBuilder(this, item);
    }
  
    public N and() {
      return (N) GRPCRouteRuleFluent.this.setToMatches(index, builder.build());
    }
    
    public N endMatch() {
      return and();
    }
    
  }
  public class SessionPersistenceNested<N> extends SessionPersistenceFluent<SessionPersistenceNested<N>> implements Nested<N>{
  
    SessionPersistenceBuilder builder;
  
    SessionPersistenceNested(SessionPersistence item) {
      this.builder = new SessionPersistenceBuilder(this, item);
    }
  
    public N and() {
      return (N) GRPCRouteRuleFluent.this.withSessionPersistence(builder.build());
    }
    
    public N endSessionPersistence() {
      return and();
    }
    
  }
}