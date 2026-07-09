package io.fabric8.kubernetes.api.model.admissionregistration.v1beta1;

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
public class MutatingAdmissionPolicySpecFluent<A extends io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingAdmissionPolicySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String failurePolicy;
  private ArrayList<MatchConditionBuilder> matchConditions = new ArrayList<MatchConditionBuilder>();
  private MatchResourcesBuilder matchConstraints;
  private ArrayList<MutationBuilder> mutations = new ArrayList<MutationBuilder>();
  private ParamKindBuilder paramKind;
  private String reinvocationPolicy;
  private ArrayList<VariableBuilder> variables = new ArrayList<VariableBuilder>();

  public MutatingAdmissionPolicySpecFluent() {
  }
  
  public MutatingAdmissionPolicySpecFluent(MutatingAdmissionPolicySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToMatchConditions(Collection<MatchCondition> items) {
    if (this.matchConditions == null) {
      this.matchConditions = new ArrayList();
    }
    for (MatchCondition item : items) {
        MatchConditionBuilder builder = new MatchConditionBuilder(item);
        _visitables.get("matchConditions").add(builder);
        this.matchConditions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMutations(Collection<Mutation> items) {
    if (this.mutations == null) {
      this.mutations = new ArrayList();
    }
    for (Mutation item : items) {
        MutationBuilder builder = new MutationBuilder(item);
        _visitables.get("mutations").add(builder);
        this.mutations.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToVariables(Collection<Variable> items) {
    if (this.variables == null) {
      this.variables = new ArrayList();
    }
    for (Variable item : items) {
        VariableBuilder builder = new VariableBuilder(item);
        _visitables.get("variables").add(builder);
        this.variables.add(builder);
    }
    return (A) this;
  }
  
  public MatchConditionsNested<A> addNewMatchCondition() {
    return new MatchConditionsNested(-1, null);
  }
  
  public A addNewMatchCondition(String expression,String name) {
    return (A) this.addToMatchConditions(new MatchCondition(expression, name));
  }
  
  public MatchConditionsNested<A> addNewMatchConditionLike(MatchCondition item) {
    return new MatchConditionsNested(-1, item);
  }
  
  public MutationsNested<A> addNewMutation() {
    return new MutationsNested(-1, null);
  }
  
  public MutationsNested<A> addNewMutationLike(Mutation item) {
    return new MutationsNested(-1, item);
  }
  
  public VariablesNested<A> addNewVariable() {
    return new VariablesNested(-1, null);
  }
  
  public A addNewVariable(String expression,String name) {
    return (A) this.addToVariables(new Variable(expression, name));
  }
  
  public VariablesNested<A> addNewVariableLike(Variable item) {
    return new VariablesNested(-1, item);
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
  
  public A addToMatchConditions(MatchCondition... items) {
    if (this.matchConditions == null) {
      this.matchConditions = new ArrayList();
    }
    for (MatchCondition item : items) {
        MatchConditionBuilder builder = new MatchConditionBuilder(item);
        _visitables.get("matchConditions").add(builder);
        this.matchConditions.add(builder);
    }
    return (A) this;
  }
  
  public A addToMatchConditions(int index,MatchCondition item) {
    if (this.matchConditions == null) {
      this.matchConditions = new ArrayList();
    }
    MatchConditionBuilder builder = new MatchConditionBuilder(item);
    if (index < 0 || index >= matchConditions.size()) {
        _visitables.get("matchConditions").add(builder);
        matchConditions.add(builder);
    } else {
        _visitables.get("matchConditions").add(builder);
        matchConditions.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMutations(Mutation... items) {
    if (this.mutations == null) {
      this.mutations = new ArrayList();
    }
    for (Mutation item : items) {
        MutationBuilder builder = new MutationBuilder(item);
        _visitables.get("mutations").add(builder);
        this.mutations.add(builder);
    }
    return (A) this;
  }
  
  public A addToMutations(int index,Mutation item) {
    if (this.mutations == null) {
      this.mutations = new ArrayList();
    }
    MutationBuilder builder = new MutationBuilder(item);
    if (index < 0 || index >= mutations.size()) {
        _visitables.get("mutations").add(builder);
        mutations.add(builder);
    } else {
        _visitables.get("mutations").add(builder);
        mutations.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToVariables(Variable... items) {
    if (this.variables == null) {
      this.variables = new ArrayList();
    }
    for (Variable item : items) {
        VariableBuilder builder = new VariableBuilder(item);
        _visitables.get("variables").add(builder);
        this.variables.add(builder);
    }
    return (A) this;
  }
  
  public A addToVariables(int index,Variable item) {
    if (this.variables == null) {
      this.variables = new ArrayList();
    }
    VariableBuilder builder = new VariableBuilder(item);
    if (index < 0 || index >= variables.size()) {
        _visitables.get("variables").add(builder);
        variables.add(builder);
    } else {
        _visitables.get("variables").add(builder);
        variables.add(index, builder);
    }
    return (A) this;
  }
  
  public MatchCondition buildFirstMatchCondition() {
    return this.matchConditions.get(0).build();
  }
  
  public Mutation buildFirstMutation() {
    return this.mutations.get(0).build();
  }
  
  public Variable buildFirstVariable() {
    return this.variables.get(0).build();
  }
  
  public MatchCondition buildLastMatchCondition() {
    return this.matchConditions.get(matchConditions.size() - 1).build();
  }
  
  public Mutation buildLastMutation() {
    return this.mutations.get(mutations.size() - 1).build();
  }
  
  public Variable buildLastVariable() {
    return this.variables.get(variables.size() - 1).build();
  }
  
  public MatchCondition buildMatchCondition(int index) {
    return this.matchConditions.get(index).build();
  }
  
  public List<MatchCondition> buildMatchConditions() {
    return this.matchConditions != null ? build(matchConditions) : null;
  }
  
  public MatchResources buildMatchConstraints() {
    return this.matchConstraints != null ? this.matchConstraints.build() : null;
  }
  
  public MatchCondition buildMatchingMatchCondition(Predicate<MatchConditionBuilder> predicate) {
      for (MatchConditionBuilder item : matchConditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Mutation buildMatchingMutation(Predicate<MutationBuilder> predicate) {
      for (MutationBuilder item : mutations) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Variable buildMatchingVariable(Predicate<VariableBuilder> predicate) {
      for (VariableBuilder item : variables) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Mutation buildMutation(int index) {
    return this.mutations.get(index).build();
  }
  
  public List<Mutation> buildMutations() {
    return this.mutations != null ? build(mutations) : null;
  }
  
  public ParamKind buildParamKind() {
    return this.paramKind != null ? this.paramKind.build() : null;
  }
  
  public Variable buildVariable(int index) {
    return this.variables.get(index).build();
  }
  
  public List<Variable> buildVariables() {
    return this.variables != null ? build(variables) : null;
  }
  
  protected void copyInstance(MutatingAdmissionPolicySpec instance) {
    instance = instance != null ? instance : new MutatingAdmissionPolicySpec();
    if (instance != null) {
        this.withFailurePolicy(instance.getFailurePolicy());
        this.withMatchConditions(instance.getMatchConditions());
        this.withMatchConstraints(instance.getMatchConstraints());
        this.withMutations(instance.getMutations());
        this.withParamKind(instance.getParamKind());
        this.withReinvocationPolicy(instance.getReinvocationPolicy());
        this.withVariables(instance.getVariables());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public MatchConditionsNested<A> editFirstMatchCondition() {
    if (matchConditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "matchConditions"));
    }
    return this.setNewMatchConditionLike(0, this.buildMatchCondition(0));
  }
  
  public MutationsNested<A> editFirstMutation() {
    if (mutations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "mutations"));
    }
    return this.setNewMutationLike(0, this.buildMutation(0));
  }
  
  public VariablesNested<A> editFirstVariable() {
    if (variables.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "variables"));
    }
    return this.setNewVariableLike(0, this.buildVariable(0));
  }
  
  public MatchConditionsNested<A> editLastMatchCondition() {
    int index = matchConditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "matchConditions"));
    }
    return this.setNewMatchConditionLike(index, this.buildMatchCondition(index));
  }
  
  public MutationsNested<A> editLastMutation() {
    int index = mutations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "mutations"));
    }
    return this.setNewMutationLike(index, this.buildMutation(index));
  }
  
  public VariablesNested<A> editLastVariable() {
    int index = variables.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "variables"));
    }
    return this.setNewVariableLike(index, this.buildVariable(index));
  }
  
  public MatchConditionsNested<A> editMatchCondition(int index) {
    if (matchConditions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "matchConditions"));
    }
    return this.setNewMatchConditionLike(index, this.buildMatchCondition(index));
  }
  
  public MatchConstraintsNested<A> editMatchConstraints() {
    return this.withNewMatchConstraintsLike(Optional.ofNullable(this.buildMatchConstraints()).orElse(null));
  }
  
  public MatchConditionsNested<A> editMatchingMatchCondition(Predicate<MatchConditionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < matchConditions.size();i++) {
      if (predicate.test(matchConditions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "matchConditions"));
    }
    return this.setNewMatchConditionLike(index, this.buildMatchCondition(index));
  }
  
  public MutationsNested<A> editMatchingMutation(Predicate<MutationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < mutations.size();i++) {
      if (predicate.test(mutations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "mutations"));
    }
    return this.setNewMutationLike(index, this.buildMutation(index));
  }
  
  public VariablesNested<A> editMatchingVariable(Predicate<VariableBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < variables.size();i++) {
      if (predicate.test(variables.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "variables"));
    }
    return this.setNewVariableLike(index, this.buildVariable(index));
  }
  
  public MutationsNested<A> editMutation(int index) {
    if (mutations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "mutations"));
    }
    return this.setNewMutationLike(index, this.buildMutation(index));
  }
  
  public MatchConstraintsNested<A> editOrNewMatchConstraints() {
    return this.withNewMatchConstraintsLike(Optional.ofNullable(this.buildMatchConstraints()).orElse(new MatchResourcesBuilder().build()));
  }
  
  public MatchConstraintsNested<A> editOrNewMatchConstraintsLike(MatchResources item) {
    return this.withNewMatchConstraintsLike(Optional.ofNullable(this.buildMatchConstraints()).orElse(item));
  }
  
  public ParamKindNested<A> editOrNewParamKind() {
    return this.withNewParamKindLike(Optional.ofNullable(this.buildParamKind()).orElse(new ParamKindBuilder().build()));
  }
  
  public ParamKindNested<A> editOrNewParamKindLike(ParamKind item) {
    return this.withNewParamKindLike(Optional.ofNullable(this.buildParamKind()).orElse(item));
  }
  
  public ParamKindNested<A> editParamKind() {
    return this.withNewParamKindLike(Optional.ofNullable(this.buildParamKind()).orElse(null));
  }
  
  public VariablesNested<A> editVariable(int index) {
    if (variables.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "variables"));
    }
    return this.setNewVariableLike(index, this.buildVariable(index));
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
    MutatingAdmissionPolicySpecFluent that = (MutatingAdmissionPolicySpecFluent) o;
    if (!(Objects.equals(failurePolicy, that.failurePolicy))) {
      return false;
    }
    if (!(Objects.equals(matchConditions, that.matchConditions))) {
      return false;
    }
    if (!(Objects.equals(matchConstraints, that.matchConstraints))) {
      return false;
    }
    if (!(Objects.equals(mutations, that.mutations))) {
      return false;
    }
    if (!(Objects.equals(paramKind, that.paramKind))) {
      return false;
    }
    if (!(Objects.equals(reinvocationPolicy, that.reinvocationPolicy))) {
      return false;
    }
    if (!(Objects.equals(variables, that.variables))) {
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
  
  public String getFailurePolicy() {
    return this.failurePolicy;
  }
  
  public String getReinvocationPolicy() {
    return this.reinvocationPolicy;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasFailurePolicy() {
    return this.failurePolicy != null;
  }
  
  public boolean hasMatchConditions() {
    return this.matchConditions != null && !(this.matchConditions.isEmpty());
  }
  
  public boolean hasMatchConstraints() {
    return this.matchConstraints != null;
  }
  
  public boolean hasMatchingMatchCondition(Predicate<MatchConditionBuilder> predicate) {
      for (MatchConditionBuilder item : matchConditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMutation(Predicate<MutationBuilder> predicate) {
      for (MutationBuilder item : mutations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingVariable(Predicate<VariableBuilder> predicate) {
      for (VariableBuilder item : variables) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMutations() {
    return this.mutations != null && !(this.mutations.isEmpty());
  }
  
  public boolean hasParamKind() {
    return this.paramKind != null;
  }
  
  public boolean hasReinvocationPolicy() {
    return this.reinvocationPolicy != null;
  }
  
  public boolean hasVariables() {
    return this.variables != null && !(this.variables.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(failurePolicy, matchConditions, matchConstraints, mutations, paramKind, reinvocationPolicy, variables, additionalProperties);
  }
  
  public A removeAllFromMatchConditions(Collection<MatchCondition> items) {
    if (this.matchConditions == null) {
      return (A) this;
    }
    for (MatchCondition item : items) {
        MatchConditionBuilder builder = new MatchConditionBuilder(item);
        _visitables.get("matchConditions").remove(builder);
        this.matchConditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMutations(Collection<Mutation> items) {
    if (this.mutations == null) {
      return (A) this;
    }
    for (Mutation item : items) {
        MutationBuilder builder = new MutationBuilder(item);
        _visitables.get("mutations").remove(builder);
        this.mutations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromVariables(Collection<Variable> items) {
    if (this.variables == null) {
      return (A) this;
    }
    for (Variable item : items) {
        VariableBuilder builder = new VariableBuilder(item);
        _visitables.get("variables").remove(builder);
        this.variables.remove(builder);
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
  
  public A removeFromMatchConditions(MatchCondition... items) {
    if (this.matchConditions == null) {
      return (A) this;
    }
    for (MatchCondition item : items) {
        MatchConditionBuilder builder = new MatchConditionBuilder(item);
        _visitables.get("matchConditions").remove(builder);
        this.matchConditions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMutations(Mutation... items) {
    if (this.mutations == null) {
      return (A) this;
    }
    for (Mutation item : items) {
        MutationBuilder builder = new MutationBuilder(item);
        _visitables.get("mutations").remove(builder);
        this.mutations.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromVariables(Variable... items) {
    if (this.variables == null) {
      return (A) this;
    }
    for (Variable item : items) {
        VariableBuilder builder = new VariableBuilder(item);
        _visitables.get("variables").remove(builder);
        this.variables.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromMatchConditions(Predicate<MatchConditionBuilder> predicate) {
    if (matchConditions == null) {
      return (A) this;
    }
    Iterator<MatchConditionBuilder> each = matchConditions.iterator();
    List visitables = _visitables.get("matchConditions");
    while (each.hasNext()) {
        MatchConditionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromMutations(Predicate<MutationBuilder> predicate) {
    if (mutations == null) {
      return (A) this;
    }
    Iterator<MutationBuilder> each = mutations.iterator();
    List visitables = _visitables.get("mutations");
    while (each.hasNext()) {
        MutationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromVariables(Predicate<VariableBuilder> predicate) {
    if (variables == null) {
      return (A) this;
    }
    Iterator<VariableBuilder> each = variables.iterator();
    List visitables = _visitables.get("variables");
    while (each.hasNext()) {
        VariableBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public MatchConditionsNested<A> setNewMatchConditionLike(int index,MatchCondition item) {
    return new MatchConditionsNested(index, item);
  }
  
  public MutationsNested<A> setNewMutationLike(int index,Mutation item) {
    return new MutationsNested(index, item);
  }
  
  public VariablesNested<A> setNewVariableLike(int index,Variable item) {
    return new VariablesNested(index, item);
  }
  
  public A setToMatchConditions(int index,MatchCondition item) {
    if (this.matchConditions == null) {
      this.matchConditions = new ArrayList();
    }
    MatchConditionBuilder builder = new MatchConditionBuilder(item);
    if (index < 0 || index >= matchConditions.size()) {
        _visitables.get("matchConditions").add(builder);
        matchConditions.add(builder);
    } else {
        _visitables.get("matchConditions").add(builder);
        matchConditions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMutations(int index,Mutation item) {
    if (this.mutations == null) {
      this.mutations = new ArrayList();
    }
    MutationBuilder builder = new MutationBuilder(item);
    if (index < 0 || index >= mutations.size()) {
        _visitables.get("mutations").add(builder);
        mutations.add(builder);
    } else {
        _visitables.get("mutations").add(builder);
        mutations.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToVariables(int index,Variable item) {
    if (this.variables == null) {
      this.variables = new ArrayList();
    }
    VariableBuilder builder = new VariableBuilder(item);
    if (index < 0 || index >= variables.size()) {
        _visitables.get("variables").add(builder);
        variables.add(builder);
    } else {
        _visitables.get("variables").add(builder);
        variables.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(failurePolicy == null)) {
        sb.append("failurePolicy:");
        sb.append(failurePolicy);
        sb.append(",");
    }
    if (!(matchConditions == null) && !(matchConditions.isEmpty())) {
        sb.append("matchConditions:");
        sb.append(matchConditions);
        sb.append(",");
    }
    if (!(matchConstraints == null)) {
        sb.append("matchConstraints:");
        sb.append(matchConstraints);
        sb.append(",");
    }
    if (!(mutations == null) && !(mutations.isEmpty())) {
        sb.append("mutations:");
        sb.append(mutations);
        sb.append(",");
    }
    if (!(paramKind == null)) {
        sb.append("paramKind:");
        sb.append(paramKind);
        sb.append(",");
    }
    if (!(reinvocationPolicy == null)) {
        sb.append("reinvocationPolicy:");
        sb.append(reinvocationPolicy);
        sb.append(",");
    }
    if (!(variables == null) && !(variables.isEmpty())) {
        sb.append("variables:");
        sb.append(variables);
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
  
  public A withFailurePolicy(String failurePolicy) {
    this.failurePolicy = failurePolicy;
    return (A) this;
  }
  
  public A withMatchConditions(List<MatchCondition> matchConditions) {
    if (this.matchConditions != null) {
      this._visitables.get("matchConditions").clear();
    }
    if (matchConditions != null) {
        this.matchConditions = new ArrayList();
        for (MatchCondition item : matchConditions) {
          this.addToMatchConditions(item);
        }
    } else {
      this.matchConditions = null;
    }
    return (A) this;
  }
  
  public A withMatchConditions(MatchCondition... matchConditions) {
    if (this.matchConditions != null) {
        this.matchConditions.clear();
        _visitables.remove("matchConditions");
    }
    if (matchConditions != null) {
      for (MatchCondition item : matchConditions) {
        this.addToMatchConditions(item);
      }
    }
    return (A) this;
  }
  
  public A withMatchConstraints(MatchResources matchConstraints) {
    this._visitables.remove("matchConstraints");
    if (matchConstraints != null) {
        this.matchConstraints = new MatchResourcesBuilder(matchConstraints);
        this._visitables.get("matchConstraints").add(this.matchConstraints);
    } else {
        this.matchConstraints = null;
        this._visitables.get("matchConstraints").remove(this.matchConstraints);
    }
    return (A) this;
  }
  
  public A withMutations(List<Mutation> mutations) {
    if (this.mutations != null) {
      this._visitables.get("mutations").clear();
    }
    if (mutations != null) {
        this.mutations = new ArrayList();
        for (Mutation item : mutations) {
          this.addToMutations(item);
        }
    } else {
      this.mutations = null;
    }
    return (A) this;
  }
  
  public A withMutations(Mutation... mutations) {
    if (this.mutations != null) {
        this.mutations.clear();
        _visitables.remove("mutations");
    }
    if (mutations != null) {
      for (Mutation item : mutations) {
        this.addToMutations(item);
      }
    }
    return (A) this;
  }
  
  public MatchConstraintsNested<A> withNewMatchConstraints() {
    return new MatchConstraintsNested(null);
  }
  
  public MatchConstraintsNested<A> withNewMatchConstraintsLike(MatchResources item) {
    return new MatchConstraintsNested(item);
  }
  
  public ParamKindNested<A> withNewParamKind() {
    return new ParamKindNested(null);
  }
  
  public A withNewParamKind(String apiVersion,String kind) {
    return (A) this.withParamKind(new ParamKind(apiVersion, kind));
  }
  
  public ParamKindNested<A> withNewParamKindLike(ParamKind item) {
    return new ParamKindNested(item);
  }
  
  public A withParamKind(ParamKind paramKind) {
    this._visitables.remove("paramKind");
    if (paramKind != null) {
        this.paramKind = new ParamKindBuilder(paramKind);
        this._visitables.get("paramKind").add(this.paramKind);
    } else {
        this.paramKind = null;
        this._visitables.get("paramKind").remove(this.paramKind);
    }
    return (A) this;
  }
  
  public A withReinvocationPolicy(String reinvocationPolicy) {
    this.reinvocationPolicy = reinvocationPolicy;
    return (A) this;
  }
  
  public A withVariables(List<Variable> variables) {
    if (this.variables != null) {
      this._visitables.get("variables").clear();
    }
    if (variables != null) {
        this.variables = new ArrayList();
        for (Variable item : variables) {
          this.addToVariables(item);
        }
    } else {
      this.variables = null;
    }
    return (A) this;
  }
  
  public A withVariables(Variable... variables) {
    if (this.variables != null) {
        this.variables.clear();
        _visitables.remove("variables");
    }
    if (variables != null) {
      for (Variable item : variables) {
        this.addToVariables(item);
      }
    }
    return (A) this;
  }
  public class MatchConditionsNested<N> extends MatchConditionFluent<MatchConditionsNested<N>> implements Nested<N>{
  
    MatchConditionBuilder builder;
    int index;
  
    MatchConditionsNested(int index,MatchCondition item) {
      this.index = index;
      this.builder = new MatchConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) MutatingAdmissionPolicySpecFluent.this.setToMatchConditions(index, builder.build());
    }
    
    public N endMatchCondition() {
      return and();
    }
    
  }
  public class MatchConstraintsNested<N> extends MatchResourcesFluent<MatchConstraintsNested<N>> implements Nested<N>{
  
    MatchResourcesBuilder builder;
  
    MatchConstraintsNested(MatchResources item) {
      this.builder = new MatchResourcesBuilder(this, item);
    }
  
    public N and() {
      return (N) MutatingAdmissionPolicySpecFluent.this.withMatchConstraints(builder.build());
    }
    
    public N endMatchConstraints() {
      return and();
    }
    
  }
  public class MutationsNested<N> extends MutationFluent<MutationsNested<N>> implements Nested<N>{
  
    MutationBuilder builder;
    int index;
  
    MutationsNested(int index,Mutation item) {
      this.index = index;
      this.builder = new MutationBuilder(this, item);
    }
  
    public N and() {
      return (N) MutatingAdmissionPolicySpecFluent.this.setToMutations(index, builder.build());
    }
    
    public N endMutation() {
      return and();
    }
    
  }
  public class ParamKindNested<N> extends ParamKindFluent<ParamKindNested<N>> implements Nested<N>{
  
    ParamKindBuilder builder;
  
    ParamKindNested(ParamKind item) {
      this.builder = new ParamKindBuilder(this, item);
    }
  
    public N and() {
      return (N) MutatingAdmissionPolicySpecFluent.this.withParamKind(builder.build());
    }
    
    public N endParamKind() {
      return and();
    }
    
  }
  public class VariablesNested<N> extends VariableFluent<VariablesNested<N>> implements Nested<N>{
  
    VariableBuilder builder;
    int index;
  
    VariablesNested(int index,Variable item) {
      this.index = index;
      this.builder = new VariableBuilder(this, item);
    }
  
    public N and() {
      return (N) MutatingAdmissionPolicySpecFluent.this.setToVariables(index, builder.build());
    }
    
    public N endVariable() {
      return and();
    }
    
  }
}