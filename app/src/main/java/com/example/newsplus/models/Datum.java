
package com.example.newsplus.models;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Datum implements Serializable {

    @SerializedName("mal_id")
    @Expose
    private Integer malId;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("trailer")
    @Expose
    private Trailer trailer;
    @SerializedName("approved")
    @Expose
    private Boolean approved;
    @SerializedName("titles")
    @Expose
    private List<Title> titles;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("title_english")
    @Expose
    private String titleEnglish;
    @SerializedName("title_japanese")
    @Expose
    private String titleJapanese;
    @SerializedName("title_synonyms")
    @Expose
    private List<String> titleSynonyms;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("episodes")
    @Expose
    private Integer episodes;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("airing")
    @Expose
    private Boolean airing;
    @SerializedName("aired")
    @Expose
    private Aired aired;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("score")
    @Expose
    private Double score;
    @SerializedName("scored_by")
    @Expose
    private Integer scoredBy;
    @SerializedName("rank")
    @Expose
    private Integer rank;
    @SerializedName("popularity")
    @Expose
    private Integer popularity;
    @SerializedName("members")
    @Expose
    private Integer members;
    @SerializedName("favorites")
    @Expose
    private Integer favorites;
    @SerializedName("synopsis")
    @Expose
    private String synopsis;
    @SerializedName("background")
    @Expose
    private Object background;
    @SerializedName("season")
    @Expose
    private String season;
    @SerializedName("year")
    @Expose
    private Integer year;
    @SerializedName("broadcast")
    @Expose
    private Broadcast broadcast;
    @SerializedName("producers")
    @Expose
    private List<Producer> producers;
    @SerializedName("licensors")
    @Expose
    private List<Licensor> licensors;
    @SerializedName("studios")
    @Expose
    private List<Studio> studios;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres;
    @SerializedName("explicit_genres")
    @Expose
    private List<Object> explicitGenres;
    @SerializedName("themes")
    @Expose
    private List<Theme> themes;
    @SerializedName("demographics")
    @Expose
    private List<Demographic> demographics;

    public Integer getMalId() {
        return malId;
    }

    public void setMalId(Integer malId) {
        this.malId = malId;
    }

    public Datum withMalId(Integer malId) {
        this.malId = malId;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Datum withUrl(String url) {
        this.url = url;
        return this;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Datum withImages(Images images) {
        this.images = images;
        return this;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public Datum withTrailer(Trailer trailer) {
        this.trailer = trailer;
        return this;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public Datum withApproved(Boolean approved) {
        this.approved = approved;
        return this;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

    public Datum withTitles(List<Title> titles) {
        this.titles = titles;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Datum withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public void setTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
    }

    public Datum withTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
        return this;
    }

    public String getTitleJapanese() {
        return titleJapanese;
    }

    public void setTitleJapanese(String titleJapanese) {
        this.titleJapanese = titleJapanese;
    }

    public Datum withTitleJapanese(String titleJapanese) {
        this.titleJapanese = titleJapanese;
        return this;
    }

    public List<String> getTitleSynonyms() {
        return titleSynonyms;
    }

    public void setTitleSynonyms(List<String> titleSynonyms) {
        this.titleSynonyms = titleSynonyms;
    }

    public Datum withTitleSynonyms(List<String> titleSynonyms) {
        this.titleSynonyms = titleSynonyms;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Datum withType(String type) {
        this.type = type;
        return this;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Datum withSource(String source) {
        this.source = source;
        return this;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    public Datum withEpisodes(Integer episodes) {
        this.episodes = episodes;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Datum withStatus(String status) {
        this.status = status;
        return this;
    }

    public Boolean getAiring() {
        return airing;
    }

    public void setAiring(Boolean airing) {
        this.airing = airing;
    }

    public Datum withAiring(Boolean airing) {
        this.airing = airing;
        return this;
    }

    public Aired getAired() {
        return aired;
    }

    public void setAired(Aired aired) {
        this.aired = aired;
    }

    public Datum withAired(Aired aired) {
        this.aired = aired;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Datum withDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Datum withRating(String rating) {
        this.rating = rating;
        return this;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Datum withScore(Double score) {
        this.score = score;
        return this;
    }

    public Integer getScoredBy() {
        return scoredBy;
    }

    public void setScoredBy(Integer scoredBy) {
        this.scoredBy = scoredBy;
    }

    public Datum withScoredBy(Integer scoredBy) {
        this.scoredBy = scoredBy;
        return this;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Datum withRank(Integer rank) {
        this.rank = rank;
        return this;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Datum withPopularity(Integer popularity) {
        this.popularity = popularity;
        return this;
    }

    public Integer getMembers() {
        return members;
    }

    public void setMembers(Integer members) {
        this.members = members;
    }

    public Datum withMembers(Integer members) {
        this.members = members;
        return this;
    }

    public Integer getFavorites() {
        return favorites;
    }

    public void setFavorites(Integer favorites) {
        this.favorites = favorites;
    }

    public Datum withFavorites(Integer favorites) {
        this.favorites = favorites;
        return this;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Datum withSynopsis(String synopsis) {
        this.synopsis = synopsis;
        return this;
    }

    public Object getBackground() {
        return background;
    }

    public void setBackground(Object background) {
        this.background = background;
    }

    public Datum withBackground(Object background) {
        this.background = background;
        return this;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Datum withSeason(String season) {
        this.season = season;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Datum withYear(Integer year) {
        this.year = year;
        return this;
    }

    public Broadcast getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(Broadcast broadcast) {
        this.broadcast = broadcast;
    }

    public Datum withBroadcast(Broadcast broadcast) {
        this.broadcast = broadcast;
        return this;
    }

    public List<Producer> getProducers() {
        return producers;
    }

    public void setProducers(List<Producer> producers) {
        this.producers = producers;
    }

    public Datum withProducers(List<Producer> producers) {
        this.producers = producers;
        return this;
    }

    public List<Licensor> getLicensors() {
        return licensors;
    }

    public void setLicensors(List<Licensor> licensors) {
        this.licensors = licensors;
    }

    public Datum withLicensors(List<Licensor> licensors) {
        this.licensors = licensors;
        return this;
    }

    public List<Studio> getStudios() {
        return studios;
    }

    public void setStudios(List<Studio> studios) {
        this.studios = studios;
    }

    public Datum withStudios(List<Studio> studios) {
        this.studios = studios;
        return this;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Datum withGenres(List<Genre> genres) {
        this.genres = genres;
        return this;
    }

    public List<Object> getExplicitGenres() {
        return explicitGenres;
    }

    public void setExplicitGenres(List<Object> explicitGenres) {
        this.explicitGenres = explicitGenres;
    }

    public Datum withExplicitGenres(List<Object> explicitGenres) {
        this.explicitGenres = explicitGenres;
        return this;
    }

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

    public Datum withThemes(List<Theme> themes) {
        this.themes = themes;
        return this;
    }

    public List<Demographic> getDemographics() {
        return demographics;
    }

    public void setDemographics(List<Demographic> demographics) {
        this.demographics = demographics;
    }

    public Datum withDemographics(List<Demographic> demographics) {
        this.demographics = demographics;
        return this;
    }

}
