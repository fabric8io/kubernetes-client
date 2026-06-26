## Security Reports

Read below when hunting for vulnerabilities, validating security issues, or preparing a submission.

### Scope and Severity

Consult `doc/specs/security/THREAT_MODEL.md` to verify that the vulnerability
is in scope.

To assess vulnerability's severity consult the threat model but also check official
[go-client](https://github.com/kubernetes/client-go). This project tries to match its behavior.

If go-client has the same issue, then consider reporting to it instead of here.

### Deduplication

Vulnerability must be deduplicated against online GitHub issues and pull requests.

If issue (open or closed) exists for the bug, then it is already known and must
not be re-reported. If the issue significantly downgrades severity or does not
recognize security implications of the bug, then the issue can be updated with
new info instead of duplicate report.

If PR exists that fixes the vulnerability, then the bug must not be reported.

### POC

When reporting vulnerabilities always provide proof of concept (POC).

POC should be based on Java code that demonstrates vulnerable usage of kubernetes-client APIs.

POC can include supporting files like YAML configs or shell scripts for setting up environment.

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
5. If the patch changes generators, templates, sanitizers, expected-output
   fixtures, generated files, builder/config fields, or serialization metadata,
   run the relevant invariant gate. For this repo, generator, template, OpenAPI,
   and model-output changes require `make generate-model` plus
   `git status --short`. Include required generated or expected-file updates in
   the patch.
6. For sanitizer, encoder, parser, path, shell, or command-execution fixes, add
   at least one benign exact-output or compatibility regression test in addition
   to exploit-blocking tests.
7. Before pushing, run `git diff --check`, the repo license check, and the repo
   formatter/checker. If the full style gate is too expensive or blocked, run
   the narrowest relevant module-scoped check and document the skipped gate.
8. If a full CI-equivalent build is too expensive, state exactly what was not
   run in the PR body.
9. After opening the PR, inspect failed CI logs before classifying failures as
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
