# AnimeHaven

- This application started as News App, related to Anime, Manga, and Japanese Culture.
- It is now a full-fledged Anime Listing App, with a lot of features.
- It is powered by [Jikan API](https://jikan.moe/), which is an Unofficial MyAnimeList API.
- It uses firebase for authentication and Realtime Database for saving user's data.
- It uses Retrofit for making API calls.
- It saved the JSON response in POJO classes using GSON.
- It also uses an open source Youtube Player API for playing trailers of anime.

## Pages

    + Login/Signup
        - Login with Email and Password
        - If new user detected, then signup with Email and Password
        - Login with Google(Not implemented yet because of google API restrictions)
    + Home/Top Anime Listing
        - Show a list of animes and their genres in a recycler view
        - Clicking on an anime will open a new activity with details of that anime
        - Clicking on Save button will save that anime in user's list
        - Clicking on Top Horizontal Scroll view items will filter the list Airing, Upcoming, Saved and Popular animes respectively

    + Show Details Page
        - Show details of the anime
        - Shows the Name Popularity and Rating of the anime
        - Shows the Season of the anime
        - Shows the Synopsis of the anime
    + Search
        - Search for animes
        - Apply filters before searching for animes
        - Clicking on Search will make a list of animes and their genres in a recycler view similar to Home Page
    + Trailer
        - Show a list of user's saved animes with their trailers
        - Opens an embedded youtube player to play the trailer

    - Logout
        - Logout the user and redirect to Login/Signup page
