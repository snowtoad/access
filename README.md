# access
Show Github Users in a List.

1. Implement the transformation in bulid gradle (module: app), gson, picasso and circleImage.
2. Project creation kit, including activities, adapters, assistants, models ... etc.
3. Activity establishes public BaseActivity, and then establish UserActivity and DetailActivity.
4. Put activity_user.xml, activity_detail.xml and row_user.xml in the layout of the res folder.
5. The model package establishes APIUserData and APIPersonData, and puts all returned attributes on the specified category.
6. The helper package establishes GithubService and ServiceGenerator. GithubGenerator is responsible for initializing the JSON returned by the URL; GithubService is responsible for specifying the filtering or filtering data behind the URL.
7. Create an Adapter and connect the user icon and login account component.
8. Finally, the BaseAcivity will be initialized, and then the JSON return result of UserActivty calling Async will be put to the APIUserAdapter, and then the UserAdapter will be connected, and finally the list will be displayed.
9.Detail Activity is to click a cell in the UserActivty list, and the detailed information can be displayed after logging in.
10. The project will be completed in about 10 hours.
