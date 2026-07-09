package io.fabric8.kubernetes.api.model.admissionregistration.v1;

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
public class ValidatingAdmissionPolicySpecFluent<A extends io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingAdmissionPolicySpecFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private ArrayList<AuditAnnotationBuilder> auditAnnotations = new ArrayList<AuditAnnotationBuilder>();
  private String failurePolicy;
  private ArrayList<MatchConditionBuilder> matchConditions = new ArrayList<MatchConditionBuilder>();
  private MatchResourcesBuilder matchConstraints;
  private ParamKindBuilder paramKind;
  private ArrayList<ValidationBuilder> validations = new ArrayList<ValidationBuilder>();
  private ArrayList<VariableBuilder> variables = new ArrayList<VariableBuilder>();

  public ValidatingAdmissionPolicySpecFluent() {
  }
  
  public ValidatingAdmissionPolicySpecFluent(ValidatingAdmissionPolicySpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAuditAnnotations(Collection<AuditAnnotation> items) {
    if (this.auditAnnotations == null) {
      this.auditAnnotations = new ArrayList();
    }
    for (AuditAnnotation item : items) {
        AuditAnnotationBuilder builder = new AuditAnnotationBuilder(item);
        _visitables.get("auditAnnotations").add(builder);
        this.auditAnnotations.add(builder);
    }
    return (A) this;
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
  
  public A addAllToValidations(Collection<Validation> items) {
    if (this.validations == null) {
      this.validations = new ArrayList();
    }
    for (Validation item : items) {
        ValidationBuilder builder = new ValidationBuilder(item);
        _visitables.get("validations").add(builder);
        this.validations.add(builder);
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
  
  public AuditAnnotationsNested<A> addNewAuditAnnotation() {
    return new AuditAnnotationsNested(-1, null);
  }
  
  public A addNewAuditAnnotation(String key,String valueExpression) {
    return (A) this.addToAuditAnnotations(new AuditAnnotation(key, valueExpression));
  }
  
  public AuditAnnotationsNested<A> addNewAuditAnnotationLike(AuditAnnotation item) {
    return new AuditAnnotationsNested(-1, item);
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
  
  public ValidationsNested<A> addNewValidation() {
    return new ValidationsNested(-1, null);
  }
  
  public A addNewValidation(String expression,String message,String messageExpression,String reason) {
    return (A) this.addToValidations(new Validation(expression, message, messageExpression, reason));
  }
  
  public ValidationsNested<A> addNewValidationLike(Validation item) {
    return new ValidationsNested(-1, item);
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
  
  public A addToAuditAnnotations(AuditAnnotation... items) {
    if (this.auditAnnotations == null) {
      this.auditAnnotations = new ArrayList();
    }
    for (AuditAnnotation item : items) {
        AuditAnnotationBuilder builder = new AuditAnnotationBuilder(item);
        _visitables.get("auditAnnotations").add(builder);
        this.auditAnnotations.add(builder);
    }
    return (A) this;
  }
  
  public A addToAuditAnnotations(int index,AuditAnnotation item) {
    if (this.auditAnnotations == null) {
      this.auditAnnotations = new ArrayList();
    }
    AuditAnnotationBuilder builder = new AuditAnnotationBuilder(item);
    if (index < 0 || index >= auditAnnotations.size()) {
        _visitables.get("auditAnnotations").add(builder);
        auditAnnotations.add(builder);
    } else {
        _visitables.get("auditAnnotations").add(builder);
        auditAnnotations.add(index, builder);
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
  
  public A addToValidations(Validation... items) {
    if (this.validations == null) {
      this.validations = new ArrayList();
    }
    for (Validation item : items) {
        ValidationBuilder builder = new ValidationBuilder(item);
        _visitables.get("validations").add(builder);
        this.validations.add(builder);
    }
    return (A) this;
  }
  
  public A addToValidations(int index,Validation item) {
    if (this.validations == null) {
      this.validations = new ArrayList();
    }
    ValidationBuilder builder = new ValidationBuilder(item);
    if (index < 0 || index >= validations.size()) {
        _visitables.get("validations").add(builder);
        validations.add(builder);
    } else {
        _visitables.get("validations").add(builder);
        validations.add(index, builder);
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
  
  public AuditAnnotation buildAuditAnnotation(int index) {
    return this.auditAnnotations.get(index).build();
  }
  
  public List<AuditAnnotation> buildAuditAnnotations() {
    return this.auditAnnotations != null ? build(auditAnnotations) : null;
  }
  
  public AuditAnnotation buildFirstAuditAnnotation() {
    return this.auditAnnotations.get(0).build();
  }
  
  public MatchCondition buildFirstMatchCondition() {
    return this.matchConditions.get(0).build();
  }
  
  public Validation buildFirstValidation() {
    return this.validations.get(0).build();
  }
  
  public Variable buildFirstVariable() {
    return this.variables.get(0).build();
  }
  
  public AuditAnnotation buildLastAuditAnnotation() {
    return this.auditAnnotations.get(auditAnnotations.size() - 1).build();
  }
  
  public MatchCondition buildLastMatchCondition() {
    return this.matchConditions.get(matchConditions.size() - 1).build();
  }
  
  public Validation buildLastValidation() {
    return this.validations.get(validations.size() - 1).build();
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
  
  public AuditAnnotation buildMatchingAuditAnnotation(Predicate<AuditAnnotationBuilder> predicate) {
      for (AuditAnnotationBuilder item : auditAnnotations) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public MatchCondition buildMatchingMatchCondition(Predicate<MatchConditionBuilder> predicate) {
      for (MatchConditionBuilder item : matchConditions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public Validation buildMatchingValidation(Predicate<ValidationBuilder> predicate) {
      for (ValidationBuilder item : validations) {
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
  
  public ParamKind buildParamKind() {
    return this.paramKind != null ? this.paramKind.build() : null;
  }
  
  public Validation buildValidation(int index) {
    return this.validations.get(index).build();
  }
  
  public List<Validation> buildValidations() {
    return this.validations != null ? build(validations) : null;
  }
  
  public Variable buildVariable(int index) {
    return this.variables.get(index).build();
  }
  
  public List<Variable> buildVariables() {
    return this.variables != null ? build(variables) : null;
  }
  
  protected void copyInstance(ValidatingAdmissionPolicySpec instance) {
    instance = instance != null ? instance : new ValidatingAdmissionPolicySpec();
    if (instance != null) {
        this.withAuditAnnotations(instance.getAuditAnnotations());
        this.withFailurePolicy(instance.getFailurePolicy());
        this.withMatchConditions(instance.getMatchConditions());
        this.withMatchConstraints(instance.getMatchConstraints());
        this.withParamKind(instance.getParamKind());
        this.withValidations(instance.getValidations());
        this.withVariables(instance.getVariables());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AuditAnnotationsNested<A> editAuditAnnotation(int index) {
    if (auditAnnotations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "auditAnnotations"));
    }
    return this.setNewAuditAnnotationLike(index, this.buildAuditAnnotation(index));
  }
  
  public AuditAnnotationsNested<A> editFirstAuditAnnotation() {
    if (auditAnnotations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "auditAnnotations"));
    }
    return this.setNewAuditAnnotationLike(0, this.buildAuditAnnotation(0));
  }
  
  public MatchConditionsNested<A> editFirstMatchCondition() {
    if (matchConditions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "matchConditions"));
    }
    return this.setNewMatchConditionLike(0, this.buildMatchCondition(0));
  }
  
  public ValidationsNested<A> editFirstValidation() {
    if (validations.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "validations"));
    }
    return this.setNewValidationLike(0, this.buildValidation(0));
  }
  
  public VariablesNested<A> editFirstVariable() {
    if (variables.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "variables"));
    }
    return this.setNewVariableLike(0, this.buildVariable(0));
  }
  
  public AuditAnnotationsNested<A> editLastAuditAnnotation() {
    int index = auditAnnotations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "auditAnnotations"));
    }
    return this.setNewAuditAnnotationLike(index, this.buildAuditAnnotation(index));
  }
  
  public MatchConditionsNested<A> editLastMatchCondition() {
    int index = matchConditions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "matchConditions"));
    }
    return this.setNewMatchConditionLike(index, this.buildMatchCondition(index));
  }
  
  public ValidationsNested<A> editLastValidation() {
    int index = validations.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "validations"));
    }
    return this.setNewValidationLike(index, this.buildValidation(index));
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
  
  public AuditAnnotationsNested<A> editMatchingAuditAnnotation(Predicate<AuditAnnotationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < auditAnnotations.size();i++) {
      if (predicate.test(auditAnnotations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "auditAnnotations"));
    }
    return this.setNewAuditAnnotationLike(index, this.buildAuditAnnotation(index));
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
  
  public ValidationsNested<A> editMatchingValidation(Predicate<ValidationBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < validations.size();i++) {
      if (predicate.test(validations.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "validations"));
    }
    return this.setNewValidationLike(index, this.buildValidation(index));
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
  
  public ValidationsNested<A> editValidation(int index) {
    if (validations.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "validations"));
    }
    return this.setNewValidationLike(index, this.buildValidation(index));
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
    ValidatingAdmissionPolicySpecFluent that = (ValidatingAdmissionPolicySpecFluent) o;
    if (!(Objects.equals(auditAnnotations, that.auditAnnotations))) {
      return false;
    }
    if (!(Objects.equals(failurePolicy, that.failurePolicy))) {
      return false;
    }
    if (!(Objects.equals(matchConditions, that.matchConditions))) {
      return false;
    }
    if (!(Objects.equals(matchConstraints, that.matchConstraints))) {
      return false;
    }
    if (!(Objects.equals(paramKind, that.paramKind))) {
      return false;
    }
    if (!(Objects.equals(validations, that.validations))) {
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
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAuditAnnotations() {
    return this.auditAnnotations != null && !(this.auditAnnotations.isEmpty());
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
  
  public boolean hasMatchingAuditAnnotation(Predicate<AuditAnnotationBuilder> predicate) {
      for (AuditAnnotationBuilder item : auditAnnotations) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMatchCondition(Predicate<MatchConditionBuilder> predicate) {
      for (MatchConditionBuilder item : matchConditions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingValidation(Predicate<ValidationBuilder> predicate) {
      for (ValidationBuilder item : validations) {
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
  
  public boolean hasParamKind() {
    return this.paramKind != null;
  }
  
  public boolean hasValidations() {
    return this.validations != null && !(this.validations.isEmpty());
  }
  
  public boolean hasVariables() {
    return this.variables != null && !(this.variables.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(auditAnnotations, failurePolicy, matchConditions, matchConstraints, paramKind, validations, variables, additionalProperties);
  }
  
  public A removeAllFromAuditAnnotations(Collection<AuditAnnotation> items) {
    if (this.auditAnnotations == null) {
      return (A) this;
    }
    for (AuditAnnotation item : items) {
        AuditAnnotationBuilder builder = new AuditAnnotationBuilder(item);
        _visitables.get("auditAnnotations").remove(builder);
        this.auditAnnotations.remove(builder);
    }
    return (A) this;
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
  
  public A removeAllFromValidations(Collection<Validation> items) {
    if (this.validations == null) {
      return (A) this;
    }
    for (Validation item : items) {
        ValidationBuilder builder = new ValidationBuilder(item);
        _visitables.get("validations").remove(builder);
        this.validations.remove(builder);
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
  
  public A removeFromAuditAnnotations(AuditAnnotation... items) {
    if (this.auditAnnotations == null) {
      return (A) this;
    }
    for (AuditAnnotation item : items) {
        AuditAnnotationBuilder builder = new AuditAnnotationBuilder(item);
        _visitables.get("auditAnnotations").remove(builder);
        this.auditAnnotations.remove(builder);
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
  
  public A removeFromValidations(Validation... items) {
    if (this.validations == null) {
      return (A) this;
    }
    for (Validation item : items) {
        ValidationBuilder builder = new ValidationBuilder(item);
        _visitables.get("validations").remove(builder);
        this.validations.remove(builder);
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
  
  public A removeMatchingFromAuditAnnotations(Predicate<AuditAnnotationBuilder> predicate) {
    if (auditAnnotations == null) {
      return (A) this;
    }
    Iterator<AuditAnnotationBuilder> each = auditAnnotations.iterator();
    List visitables = _visitables.get("auditAnnotations");
    while (each.hasNext()) {
        AuditAnnotationBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
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
  
  public A removeMatchingFromValidations(Predicate<ValidationBuilder> predicate) {
    if (validations == null) {
      return (A) this;
    }
    Iterator<ValidationBuilder> each = validations.iterator();
    List visitables = _visitables.get("validations");
    while (each.hasNext()) {
        ValidationBuilder builder = each.next();
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
  
  public AuditAnnotationsNested<A> setNewAuditAnnotationLike(int index,AuditAnnotation item) {
    return new AuditAnnotationsNested(index, item);
  }
  
  public MatchConditionsNested<A> setNewMatchConditionLike(int index,MatchCondition item) {
    return new MatchConditionsNested(index, item);
  }
  
  public ValidationsNested<A> setNewValidationLike(int index,Validation item) {
    return new ValidationsNested(index, item);
  }
  
  public VariablesNested<A> setNewVariableLike(int index,Variable item) {
    return new VariablesNested(index, item);
  }
  
  public A setToAuditAnnotations(int index,AuditAnnotation item) {
    if (this.auditAnnotations == null) {
      this.auditAnnotations = new ArrayList();
    }
    AuditAnnotationBuilder builder = new AuditAnnotationBuilder(item);
    if (index < 0 || index >= auditAnnotations.size()) {
        _visitables.get("auditAnnotations").add(builder);
        auditAnnotations.add(builder);
    } else {
        _visitables.get("auditAnnotations").add(builder);
        auditAnnotations.set(index, builder);
    }
    return (A) this;
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
  
  public A setToValidations(int index,Validation item) {
    if (this.validations == null) {
      this.validations = new ArrayList();
    }
    ValidationBuilder builder = new ValidationBuilder(item);
    if (index < 0 || index >= validations.size()) {
        _visitables.get("validations").add(builder);
        validations.add(builder);
    } else {
        _visitables.get("validations").add(builder);
        validations.set(index, builder);
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
    if (!(auditAnnotations == null) && !(auditAnnotations.isEmpty())) {
        sb.append("auditAnnotations:");
        sb.append(auditAnnotations);
        sb.append(",");
    }
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
    if (!(paramKind == null)) {
        sb.append("paramKind:");
        sb.append(paramKind);
        sb.append(",");
    }
    if (!(validations == null) && !(validations.isEmpty())) {
        sb.append("validations:");
        sb.append(validations);
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
  
  public A withAuditAnnotations(List<AuditAnnotation> auditAnnotations) {
    if (this.auditAnnotations != null) {
      this._visitables.get("auditAnnotations").clear();
    }
    if (auditAnnotations != null) {
        this.auditAnnotations = new ArrayList();
        for (AuditAnnotation item : auditAnnotations) {
          this.addToAuditAnnotations(item);
        }
    } else {
      this.auditAnnotations = null;
    }
    return (A) this;
  }
  
  public A withAuditAnnotations(AuditAnnotation... auditAnnotations) {
    if (this.auditAnnotations != null) {
        this.auditAnnotations.clear();
        _visitables.remove("auditAnnotations");
    }
    if (auditAnnotations != null) {
      for (AuditAnnotation item : auditAnnotations) {
        this.addToAuditAnnotations(item);
      }
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
  
  public A withValidations(List<Validation> validations) {
    if (this.validations != null) {
      this._visitables.get("validations").clear();
    }
    if (validations != null) {
        this.validations = new ArrayList();
        for (Validation item : validations) {
          this.addToValidations(item);
        }
    } else {
      this.validations = null;
    }
    return (A) this;
  }
  
  public A withValidations(Validation... validations) {
    if (this.validations != null) {
        this.validations.clear();
        _visitables.remove("validations");
    }
    if (validations != null) {
      for (Validation item : validations) {
        this.addToValidations(item);
      }
    }
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
  public class AuditAnnotationsNested<N> extends AuditAnnotationFluent<AuditAnnotationsNested<N>> implements Nested<N>{
  
    AuditAnnotationBuilder builder;
    int index;
  
    AuditAnnotationsNested(int index,AuditAnnotation item) {
      this.index = index;
      this.builder = new AuditAnnotationBuilder(this, item);
    }
  
    public N and() {
      return (N) ValidatingAdmissionPolicySpecFluent.this.setToAuditAnnotations(index, builder.build());
    }
    
    public N endAuditAnnotation() {
      return and();
    }
    
  }
  public class MatchConditionsNested<N> extends MatchConditionFluent<MatchConditionsNested<N>> implements Nested<N>{
  
    MatchConditionBuilder builder;
    int index;
  
    MatchConditionsNested(int index,MatchCondition item) {
      this.index = index;
      this.builder = new MatchConditionBuilder(this, item);
    }
  
    public N and() {
      return (N) ValidatingAdmissionPolicySpecFluent.this.setToMatchConditions(index, builder.build());
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
      return (N) ValidatingAdmissionPolicySpecFluent.this.withMatchConstraints(builder.build());
    }
    
    public N endMatchConstraints() {
      return and();
    }
    
  }
  public class ParamKindNested<N> extends ParamKindFluent<ParamKindNested<N>> implements Nested<N>{
  
    ParamKindBuilder builder;
  
    ParamKindNested(ParamKind item) {
      this.builder = new ParamKindBuilder(this, item);
    }
  
    public N and() {
      return (N) ValidatingAdmissionPolicySpecFluent.this.withParamKind(builder.build());
    }
    
    public N endParamKind() {
      return and();
    }
    
  }
  public class ValidationsNested<N> extends ValidationFluent<ValidationsNested<N>> implements Nested<N>{
  
    ValidationBuilder builder;
    int index;
  
    ValidationsNested(int index,Validation item) {
      this.index = index;
      this.builder = new ValidationBuilder(this, item);
    }
  
    public N and() {
      return (N) ValidatingAdmissionPolicySpecFluent.this.setToValidations(index, builder.build());
    }
    
    public N endValidation() {
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
      return (N) ValidatingAdmissionPolicySpecFluent.this.setToVariables(index, builder.build());
    }
    
    public N endVariable() {
      return and();
    }
    
  }
}