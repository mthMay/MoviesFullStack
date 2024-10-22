package com.example.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data // take cares of all getters and setters
@AllArgsConstructor // generates a constructor that initialize all fields of a class
@NoArgsConstructor // generates a no-argument constructor for that class
public class Movie {
    @Id // to specify the unique identifier for an entity
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    // define a relationship between documents->easier managing related data without embedding 1 document inside another
    @DocumentReference
    // embedded relationship: reviews related to this movie will be added to this list
    private List<Review> reviewIds;
}
