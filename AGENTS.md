# Agent Instructions

## Scope

These instructions apply to the whole repository.

## Build And Validation

- Run `./gradlew ktlintF build` before finishing any code change.
- Treat `ktlintF` changes as part of the work: inspect the resulting diff and keep only changes related to the task.
- If `./gradlew ktlintF build` fails, fix the cause and rerun the same command.
- If the command cannot be run, report the exact reason and the last command attempted.

## Code Changes

- Follow the existing Kotlin Multiplatform layout under `src/commonMain` and `src/commonTest`.
- Keep changes scoped to the requested behavior; avoid unrelated refactors and metadata churn.
- Add or update focused tests for behavior changes and regressions.

## Warnings And Suppressions

- Prefer fixing warnings instead of suppressing them.
- Use a suppression only when a real fix is impractical or would make the code worse.
- Every suppression must include a nearby justification explaining why it is necessary.

## Dependency And Tooling Updates

- Do not write explicit dependency, plugin, Gradle, Kotlin, or tool versions in this file.
- Keep version updates in the repository's existing version-management files and automation.
