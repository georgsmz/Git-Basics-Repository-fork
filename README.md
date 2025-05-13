# Git-Basics-Repository
This repository is meant for small illustration or training purposes.

Follow a good introduction to git by following the [git-scm tutorial.](https://git-scm.com/docs/gittutorial)

This repository targets to provide an easy start into Git, also for no-coders.

## Basic Configuration

```shell
# ensure correct line endings (repository always linux; when using windows, git knows how to handle it)
git config --global core.autocrlf true

# TODO: Adapt your name and e-mail (e-mail should be associated with your Github account)
git config --global user.name "Tom Meyer"
git config --global user.email Your-mail@domain.tld
```

## Basic Commands

THe following commands are used to create a basic change and prepare the code change for a pull request (pr, GitHub) / merge request (mr, GitLab)

```shell
# update your local working copy with the online state
git pull

# switch the branch (e.g. per feature, per release). Shells commonly allow autocompletion with TAB
git switch branch-name

git status
# indicates 
# - which branch you're working on
# - which files have been changed
# - which files you would like to commit (staged)

# create a branch with current non-committed changes from the branch shown in previous command
git checkout -b branch-name

# Add all changes to be part of the commit
git add *

# Add specific files to be part of the commit. Shells commonly allow autocompletion with TAB
git add path/file

# Do the commit
# That's like writing down your current changes / checking in into version control.
# Please note: THAT'S LOCALLY. OTHERS WON'T SEE IT.
git commit -m "docs: changed something"

# you can do further changes and committs

# send your changes to the online repository (called remote / origin)
# If someone worked on your branch there may be conflicts that need to be resolved with a "git merge"
# If there is an error regarding "remote unkown", copy and execute the mentioned command. You're just on a new branch for which the remote branch has not yet been configured. The command does it.
git push

# more advanced. Let's do together if needed
# It's easy with changes in different areas (automerge)
# It's easy for smaller changes with a ui.
git merge other-branch-of-that-you-want-to-include-changes-in-your-branch
# Note: That's also what happens during a PR
```

### Further Links

The following links support you normalizing / standardizing your daily work with git:

- [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) - make concise descriptions of your pull requests
- [Semantic Versioning](https://semver.org/) - consider a versioning sccheme and write your code accordingly