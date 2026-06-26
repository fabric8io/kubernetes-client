<!-- markdownlint-disable MD013 MD041 -->
<!-- Dense agent-facing guidance uses H2 sections and long API names. -->

## Security Reports

Read below when hunting for vulnerabilities, validating security issues, or preparing a submission.

### Scope and Severity

Consult `doc/specs/security/THREAT_MODEL.md` to verify that the vulnerability
is in scope.

To assess vulnerability severity, consult the threat model and also check
official [client-go](https://github.com/kubernetes/client-go). This project
tries to match Kubernetes/client-go behavior where the APIs overlap.

If client-go has the same issue, consider reporting to it instead of here. If
client-go is safer, use that as parity evidence and explain the security impact
of the behavior difference.

For every candidate, write down these five facts before drafting the report:

1. Attacker: who controls the input and what privileges they start with.
2. Controlled bytes: the exact field, file, object, stream, URL, path, or
   argument they control.
3. Public API path: the Fabric8 Java API that receives those bytes.
4. Sink: the request, process, parser, file, generated source, local listener,
   or log/artifact affected.
5. Boundary crossed: why Fabric8 has more Kubernetes, network, local filesystem,
   CI, or build-JVM authority than the attacker.

Do not report a candidate as a vulnerability if it only relies on attacker
control of a whole kubeconfig, local environment, JVM system properties,
classpath, Maven/Gradle build file, trusted schema, or local filesystem path.
Those are trusted configuration/code by default. Report only when a downstream
wrapper accepts a supposedly narrow subfield, or when Fabric8 promises safer
Kubernetes/client-go parity and violates it in a security-relevant way.

### Deduplication

Vulnerability must be deduplicated against online GitHub issues and pull requests.

If issue (open or closed) exists for the bug, then it is already known and must
not be re-reported. If the issue significantly downgrades severity or does not
recognize security implications of the bug, then the issue can be updated with
new info instead of duplicate report.

If PR exists that fixes the vulnerability, then the bug must not be reported.

Deduplicate against local findings and current GitHub state:

* `findings/`, `findings_reported/`, `KNOWN_BUG.md`, and prior agent notes in
  this workspace.
* Open and closed upstream issues and PRs. Search by affected class, API name,
  method, error string, and exploit primitive, not only by final title.
* Current PRs/issues from this campaign. Do not reopen a report already covered
  by the recent finding map in `THREAT_MODEL.md` unless the new evidence changes
  scope, severity, bypassability, or the fix.

### POC

When reporting vulnerabilities always provide proof of concept (POC).

POC should be based on Java code that demonstrates vulnerable usage of kubernetes-client APIs.

POC can include supporting files like YAML configs or shell scripts for setting up environment.

If the exploit primitive is easier to show with shell commands, still include or
describe the Java API call that reaches the same command, URL, parser, listener,
or file sink. For transport bugs, capture the actual method, path, query,
headers, body, proxy target, TLS behavior, or WebSocket path observed by a local
server. For wrapper/confused-deputy bugs, the PoC must show which field the
lower-trust user controls and which broader Fabric8 credential or local
privilege performs the action.

Severity needs evidence, not labels:

* RCE requires code execution in the caller JVM, build JVM, CI runner, local
  host, or pod where that execution crosses the stated trust boundary.
* Credential disclosure requires showing the credential source and the
  attacker-controlled sink or observation point.
* Authorization bypass requires showing the allowed wrapper capability and the
  wider Kubernetes action Fabric8 actually performs.
* DoS/resource exhaustion must include limits, defaults, and why the target
  environment cannot reasonably bound the input elsewhere.

### Patch

When reporting vulnerabilities always provide patch.

Patch must make the POC fail.

Patch should not change signature of public methods and APIs unless strictly necessary.

Patch must follow rules from CONTRIBUTING.md.

Patch must not break library's users.

Patch must undergo validation by fresh agents or a fresh checkout:

* Verify that patch does not introduce new vulnerabilities.
* Verify that the patch is complete: no bypasses that can keep the vulnerability
  exploitable must be possible. If the patch is not full and keeps any edge
  cases or bypasses, then the report must inform about that.

Patch must be properly validated:

1. Apply the exact patch to a fresh branch from the target repo default branch.
2. Run `git apply --check` before applying when possible.
3. Run every test command listed explicitly in the finding.
4. Run existing tests for every directly changed module, not only the new
   regression test. If the full module test suite is too expensive, run the
   closest existing invariant and compatibility tests and state exactly what was
   skipped.
5. For transport, TLS, proxy, WebSocket, method, path, or query fixes, test the
   affected HTTP backend and any alternate backend whose behavior may diverge.
   Include REST and WebSocket coverage when both paths exist.
6. If the patch changes generators, templates, sanitizers, expected-output
   fixtures, generated files, builder/config fields, or serialization metadata,
   run the relevant invariant gate. For this repo, generator, template, OpenAPI,
   and model-output changes require `make generate-model` plus
   `git status --short`. Include required generated or expected-file updates in
   the patch.
7. For sanitizer, encoder, parser, path, shell, or command-execution fixes, add
   at least one benign exact-output or compatibility regression test in addition
   to exploit-blocking tests.
8. For config precedence fixes, test the losing and winning source together and
   assert the effective credential, proxy, TLS, namespace, or impersonation
   field after merge.
9. For file, archive, symlink, or generator-output fixes, test traversal,
   symlink, size, and benign edge cases under a fresh temporary directory.
10. Before pushing, run `git diff --check`, the repo license check, and the repo
   formatter/checker. If the full style gate is too expensive or blocked, run
   the narrowest relevant module-scoped check and document the skipped gate.
11. If a full CI-equivalent build is too expensive, state exactly what was not
   run in the PR body.
12. After opening the PR, inspect failed CI logs before classifying failures as
   flakes.

#### Local CI Checks

Use the smallest command set that covers the changed surface, but prefer the
repository's actual CI gates when they are practical.

* Any Java patch: `./mvnw -B -ntp -pl <module>[,<module>] -am test`
* Formatting and license headers:
  `./mvnw -B -ntp -Pitests -N license:check` and
  `./mvnw -B -ntp -Pitests spotless:check`
* Generator, template, OpenAPI, or model output:
  `make generate-model` and `git status --short`
* Config, `RequestConfig`, or Sundrio builder fields:

  ```shell
  ./mvnw -B -ntp -pl kubernetes-client-api \
    -Dtest=SundrioConfigBuilderTest,RequestConfigTest test
  ```

* URL, path, shell, command, parser, sanitizer, or encoder behavior: focused
  exploit tests plus benign compatibility tests for valid edge values such as
  spaces, `+`, `:`, `~`, `?`, `#`, and ordinary backslashes.
* Shared test fixtures or resources: use `rg` to find consumers and run every
  test class that loads the changed fixture or resource.

If a command fails outside the patch's changed surface, inspect the failing test
or plugin output before calling it unrelated. Prefer rerunning the exact failed
test locally, or in a constrained CI-shaped container when the failure looks
timing-sensitive.
